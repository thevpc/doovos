/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs;

import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.memory.KBoolean;
import org.doovos.kernel.api.memory.KByte;
import org.doovos.kernel.api.memory.KChar;
import org.doovos.kernel.api.memory.KDouble;
import org.doovos.kernel.api.memory.KFloat;
import org.doovos.kernel.api.memory.KInteger;
import org.doovos.kernel.api.memory.KLong;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.memory.KReturn;
import org.doovos.kernel.api.memory.KShort;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;

/**
 *
 * @author vpc
 */
public class TypeStruct {

    private String name;

    public TypeStruct(Class type) {
        this.name=type.getName();
    }
    public TypeStruct(String type) {
        this.name = type;
    }

    public String getName() {
        return name;
    }
    
    public String getSimpleName() {
        int i = name.lastIndexOf('.');
        if(i>0){
            return name.substring(i+1);
        }
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeStruct that = (TypeStruct) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return  name;
    }
}
