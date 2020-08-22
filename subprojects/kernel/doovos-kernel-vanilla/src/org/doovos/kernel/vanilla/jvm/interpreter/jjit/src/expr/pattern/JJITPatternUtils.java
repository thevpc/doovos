/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.pattern;

import java.util.HashMap;
import java.util.Map;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITExpression;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.FieldStruct;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.TypeStruct;

/**
 *
 * @author vpc
 */
public class JJITPatternUtils {

    public static boolean matchesObj(Object a, Object b) {
        if(a==b){
            return true;
        }
        if(a==null){
            return false;
        }
        if(b==null){
            return true;
        }
        return a.equals(b);
    }

    public static boolean matches(TypeStruct a, TypeStruct b) {
        return matches(a==null?null:a.getName(), b==null?null:b.getName());
    }
    public static boolean matches(FieldStruct a, FieldStruct b) {
        return matches(a == null ? null : a.getFieldName(), b == null ? null : b.getFieldName());
    }

    public static boolean matches(String a, String b) {
        if (a == null && b == null) {
            return true;
        }
        if (b == null) {
            return false;
        }
        if (b.equals(".*")) {
            return true;
        }
        if (a == null) {
            return false;
        }
        return a.matches(b);
    }
    public static final int MATCH_CONTINUE=1;
    public static final int MATCH_OK=2;
    public static final int MATCH_KO=3;
    
    public static int matches0(JJITExpression a, JJITExpression b,Map<JJITPattern, JJITExpression> tt) {
        if (b instanceof JJITPatternAny) {
            tt.put((JJITPattern)b, a);
            return MATCH_OK;
        }
        if (a == b) {
            return MATCH_OK;
        }
        if (b == null || a.getClass() != b.getClass()) {
            return MATCH_KO;
        }
        return MATCH_CONTINUE;
    }
    
    public static boolean matches(JJITExpression a, JJITExpression b,Map<JJITPattern, JJITExpression> tt) {
        if (a == null && b == null) {
            return true;
        }
        if (b instanceof JJITPatternAny) {
            tt.put((JJITPatternAny) b, a);
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        Map<JJITPattern, JJITExpression> t = a.matches(b);
        if(t==null){
            return false;
        }
        tt.putAll(tt);
        return true;
    }

    public static boolean matches(JJITExpression[] a, JJITExpression[] b, Map<JJITPattern, JJITExpression> tt) {
        if (b.length == 1 && b[0] instanceof JJITPatternAnyArraySize) {
//            HashMap<JJITPattern,JJITExpression> ee=new HashMap<JJITPattern, JJITExpression>();
//            ee.put((JJITPatternAny)b,a);
            return true;
        }
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            Map<JJITPattern, JJITExpression> zz = a[i].matches(b[i]);
            if (zz == null) {
                return false;
            }
            tt.putAll(zz);
        }
        return true;
    }
}
