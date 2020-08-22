/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.special;

import org.doovos.kernel.api.jvm.interpreter.KEndOfThreadException;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.jni.KJNIException;
import org.doovos.kernel.api.jvm.jni.KJNIMethod;
import org.doovos.kernel.api.jvm.reflect.KClassNotFoundException;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.core.util.KUtils;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;

import java.io.Serializable;
import java.rmi.RemoteException;

/**
 *
 * @author vpc
 */
public class JJIT_JNI_CALL implements JJITInstruction, Cloneable,Serializable{
    private String methodId;
    private transient KJNIMethod nativeMethod;
    public JJIT_JNI_CALL(String methodId) {
        this.methodId=methodId;
    }


    public JJITInstruction clone() {
        try {
            return (JJITInstruction)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void init(int index, JJITInstruction[] instructions, KRegister[] constants, KProcess process) {
        try {
            nativeMethod= process.getJNIMethod(methodId);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public JJITInstruction run(KFrame frame) throws Exception {
        KRegister[] parameters = frame.getParameters();
        KRegister dRegister;
        try {
            dRegister = nativeMethod.invoke(frame, parameters);
        } catch (KJNIException e) {
            KUtils.logStackTrace(e.toString(), "[run Error] ", frame);
            e.printStackTrace();
            throw e;
        } catch (KEndOfThreadException e) {
            KUtils.logStackTrace(e.toString(), "[run Error] ", frame);
            e.printStackTrace();
            throw e;
        } catch (UnsupportedOperationException e) {
            KUtils.logStackTrace(e.toString(), "[run Error] ", frame);
            e.printStackTrace();
            throw e;
        } catch (KClassNotFoundException e) {
            KUtils.logStackTrace(e.toString(), "[run Error] ", frame);
            e.printStackTrace();
            frame.throwClassNotFoundException(e.getMessage());
            return null;
        } catch (NullPointerException e) {
            KUtils.logStackTrace(e.toString(), "[run Error] ", frame);
            e.printStackTrace();
            frame.throwNullPointerException(e.getMessage());
            return null;
        } catch (RuntimeException e) {
            KUtils.logStackTrace(e.toString(), "[run Error] ", frame);
            e.printStackTrace();
            frame.throwRuntimeException(e.getMessage());
            return null;
        }
        frame = frame.getThread().popFrame();
        if (dRegister != null) {
            frame.push(dRegister);
        }
        return (JJITInstruction) frame.getCurrentInstruction();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JJIT_JNI_CALL that = (JJIT_JNI_CALL) o;

        if (!methodId.equals(that.methodId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return methodId.hashCode();
    }

    @Override
    public String toString() {
        return "<JNI_CALL>";
    }
    
}
