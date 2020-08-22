//package org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.instr;
//
//import java.rmi.RemoteException;
//
//import org.doovos.kernel.api.jvm.interpreter.KEndOfThreadException;
//import org.doovos.kernel.api.jvm.interpreter.KFrame;
//import org.doovos.kernel.api.jvm.jni.JNIException;
//import org.doovos.kernel.api.jvm.reflect.KClassNotFoundException;
//import org.doovos.kernel.api.memory.KRegister;
//import org.doovos.kernel.core.util.KUtils;
//import org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.KInstructionCompiled;
//
//
//public class KJVM_XTRA_JNIDump implements KInstructionCompiled {
//    public static final KJVM_XTRA_JNIDump INSTANCE=new KJVM_XTRA_JNIDump();
//
//    private int index;
//    private KInstructionCompiled next;
//
//    public KInstructionCompiled run(KFrame frame) throws RemoteException {
//        KRegister[] dRegisters = frame.getParameters();
//        KRegister dRegister = null;
//        try {
//            dRegister = frame.getProcess().invokeNativeMethod(frame.getMethod().getAbsoluteSignature(), frame, dRegisters);
//        } catch (JNIException e) {
//            KUtils.logStackTrace(e.toString(), "[run Error] ", frame);
//            e.printStackTrace();
//            throw e;
//        } catch (KEndOfThreadException e) {
//            KUtils.logStackTrace(e.toString(), "[run Error] ", frame);
//            e.printStackTrace();
//            throw e;
//        } catch (UnsupportedOperationException e) {
//            KUtils.logStackTrace(e.toString(), "[run Error] ", frame);
//            e.printStackTrace();
//            throw e;
//        } catch (KClassNotFoundException e) {
//            KUtils.logStackTrace(e.toString(), "[run Error] ", frame);
//            e.printStackTrace();
//            int i= frame.throwClassNotFoundException(e.getMessage());
//            frame.getThread().getFrame().setInstruction(i);
//            return (KInstructionCompiled) frame.getThread().getFrame().getCurrentInstruction();
//        } catch (NullPointerException e) {
//            KUtils.logStackTrace(e.toString(), "[run Error] ", frame);
//            e.printStackTrace();
//            int i=frame.throwNullPointerException(e.getMessage());
//            return (KInstructionCompiled) frame.getThread().getFrame().getCurrentInstruction();
//        } catch (RuntimeException e) {
//            KUtils.logStackTrace(e.toString(), "[run Error] ", frame);
//            e.printStackTrace();
//            int i=frame.throwRuntimeException(e.getMessage());
//            return (KInstructionCompiled) frame.getThread().getFrame().getCurrentInstruction();
//        }
//        frame = frame.getThread().popFrame();
//        if (dRegister != null) {
//            frame.push(dRegister);
//        }
//        return (KInstructionCompiled)frame.getCurrentInstruction();
//    }
//
//    public void configure(KInstructionCompiled[] instructions, int index) throws RemoteException {
//        this.index=index;
//        next=instructions[index];
//    }
//}
