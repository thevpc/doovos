/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.doovos.kernel.depreciated.jvm.bytecode;

import com.sun.org.apache.bcel.internal.classfile.ClassParser;
import com.sun.org.apache.bcel.internal.classfile.JavaClass;
import java.io.IOException;
import java.io.InputStream;
import org.doovos.kernel.api.jvm.bytecode.JavaByteCodeLoader;
import org.doovos.kernel.api.jvm.bytecode.KClassDef;

/**
 *
 * @author vpc
 */
public class BCELJavaByteCodeLoader implements JavaByteCodeLoader{

    public KClassDef loadClass(InputStream inputStream) throws IOException {
        ClassParser c=new ClassParser(inputStream, "monfichier");
        JavaClass jc=c.parse();
        KClassDef d=new KClassDef();
        d.setName(jc.getClassName());
        d.setCode("L"+jc.getClassName()+";");
        d.setCode("L"+jc.getClassName()+";");
        return d;
    }

}
