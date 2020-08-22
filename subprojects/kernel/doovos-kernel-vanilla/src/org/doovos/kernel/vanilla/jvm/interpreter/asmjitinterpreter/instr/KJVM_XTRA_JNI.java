package org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.instr;

import org.doovos.kernel.api.jvm.interpreter.KEndOfThreadException;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClassNotFoundException;
import org.doovos.kernel.api.jvm.reflect.KInstruction;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.core.util.KUtils;
import org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.JITContext;
import org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.KInstructionJIT;

import java.rmi.RemoteException;
import org.doovos.kernel.api.jvm.jni.KJNIException;
import org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.KInstructionCompiled;

public class KJVM_XTRA_JNI implements KInstructionJIT, KInstructionCompiled {
    public static KJVM_XTRA_JNI INSTANCE=new KJVM_XTRA_JNI();
    
    public KInstructionCompiled run(KFrame frame) throws RemoteException {
        KRegister[] dRegisters = frame.getParameters();
        KRegister dRegister = null;
        try {
            dRegister = frame.getProcess().invokeNativeMethod(frame.getMethod().getAbsoluteSignature(), frame, dRegisters);
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
            int ii = frame.throwClassNotFoundException(e.getMessage());
            return (KInstructionCompiled) frame.getThread().getFrame().getMethod().getCode()[ii];
        } catch (NullPointerException e) {
            KUtils.logStackTrace(e.toString(), "[run Error] ", frame);
            e.printStackTrace();
            int ii = frame.throwNullPointerException(e.getMessage());
            return (KInstructionCompiled) frame.getThread().getFrame().getMethod().getCode()[ii];
        } catch (RuntimeException e) {
            KUtils.logStackTrace(e.toString(), "[run Error] ", frame);
            e.printStackTrace();
            int ii = frame.throwRuntimeException(e.getMessage());
            return (KInstructionCompiled) frame.getThread().getFrame().getMethod().getCode()[ii];
        }
        if (dRegister != null) {
            frame = frame.popFrame();
            frame.push(dRegister);
        } else {
            frame = frame.popFrame();
        }
        return (KInstructionCompiled) frame.getCurrentInstruction();
    }

    @Override
    public KInstructionJIT clone() {
        return this;
    }

    public void produceRunMethod(JITContext context) throws Exception {
        //
    }

    public boolean isJump() throws RemoteException {
        return true;
    }

    public boolean isLabel() throws RemoteException {
        return true;
    }

    public void relink(int index, KInstruction[] code, KMethod method) throws RemoteException {
        //
    }

    public int[] getLabels() throws RemoteException {
        return NO_LABELS;
    }

    public void configure(KInstructionCompiled[] instructions, int index) throws RemoteException {
        //
    }
}
