/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit;

import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.jvm.jni.KJNIMethodInfo;
import org.doovos.kernel.api.util.EmptyArray;
import org.doovos.kernel.api.util.JavaByteCodeUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author vpc
 */
public class JJITGuestToHostStaticFilterDefault implements JJITGuestToHostStaticFilter {
//    private static final String[] EMPTY_ARRAY_STRING = new String[0];

    private Set<String> utilityClasses = new HashSet<String>();
    private Map<String,KJNIMethodInfo> impls = new HashMap<String, KJNIMethodInfo>();

    public JJITGuestToHostStaticFilterDefault() {
        addPattern("java.lang.Math.*");
        addPattern("java.lang.StrictMath.*");
        addPattern("java.lang.Integer.toString(II)Ljava/lang/String;");
        addPattern("java.lang.Long.toString(LI)Ljava/lang/String;");

        addPattern("java.lang.Double.toString(D)Ljava/lang/String;");
        addPattern("java.lang.Double.toHexString(D)Ljava/lang/String;");
        addPattern("java.lang.Double.doubleToLongBits(L)L");
        addPattern("java.lang.Double.doubleToRawLongBits(L)L");

        addPattern("java.lang.Float.toString(D)Ljava/lang/String;");
        addPattern("java.lang.Float.toHexString(D)Ljava/lang/String;");
        addPattern("java.lang.Float.floatToIntBits(F)I");
        addPattern("java.lang.Float.floatToRawIntBits(F)I");
        addPattern("java.lang.Float.compare(FF)I");


        addPattern("java.lang.Short.toString(S)Ljava/lang/String;");
        addPattern("java.lang.Short.toString(S)Ljava/lang/String;");


        add(new KJNIMethodInfo("java.lang.System.currentTimeMillis()J", java.lang.System.class.getName(),"currentTimeMillis", EmptyArray.STRINGS));
        add(new KJNIMethodInfo("java.lang.System.nanoTime()J", java.lang.System.class.getName(),"nanoTime",EmptyArray.STRINGS));
    }

    private void add(KJNIMethodInfo s) {
        impls.put(s.getSpecMethodDesc(),s);
    }

    private void addPattern(String s) {
        if (s.endsWith(".*")) {
            utilityClasses.add(s.substring(0, s.length() - 2));
        } else {
            add(new KJNIMethodInfo(s, null, null, null));
        }
    }

    public KJNIMethodInfo getImpl(String className, String methodSignature) {
        String fullMethodSig = className + "." + methodSignature;
        if (utilityClasses.contains(className)) {
            return new KJNIMethodInfo(fullMethodSig, null,null,null);
        }
        return impls.get(fullMethodSig);
    }
}
