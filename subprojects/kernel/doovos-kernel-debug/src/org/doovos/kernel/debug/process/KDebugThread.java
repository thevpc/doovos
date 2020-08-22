//package org.doovos.kernel.debug.process;
//
//import org.doovos.kernel.api.jvm.interpreter.KFrame;
//import org.doovos.kernel.api.jvm.reflect.KMethod;
//import org.doovos.kernel.api.memory.KRegister;
//import org.doovos.kernel.api.process.KProcess;
//import org.doovos.kernel.api.process.KLocalThread;
//import org.doovos.kernel.debug.Debug;
//import org.doovos.kernel.debug.jvm.iterpreter.KDebugInterpreter;
//
//import java.rmi.RemoteException;
//
//public class KDebugThread extends KThreadAdapter {
//    public KDebugThread(KLocalThread base) {
//        super(base);
//    }
//
//    @Override
//    public KFrame pushFrame( KMethod method, KRegister... parameters) throws RemoteException {
//        if (method.getDefinition().isClassInitializer() && method.getParentClass().isInitialized()) {
//            throw new IllegalStateException("Class " + method.getParentClass() + " already initialized");
//        }
//        KFrame frame = super.pushFrame(method, parameters);
//        KProcess process = getProcess();
//        if (Debug.getDebugFilter(getProcess()).accept(frame) && Debug.isDebug(process, "step")) {
//            long count = ((KDebugInterpreter) getInterpreter()).getCounter();
//            Debug.log(this).info("T*******<" + count + ">" + frame + " ; params : " + KDebugInterpreter.toDebugObject(parameters) + " ; locals :" + KDebugInterpreter.traceLocals(frame));
//        }
//        return frame;
//    }
//}
