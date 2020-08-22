package jjit.local.jnt.Bench.Applet.submitBenchmark__V_C8F7969;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Applet
 * submitBenchmark()V
 * [count=2] [6] POP [7] RETURN
 */
public final class submitBenchmark_004 extends JJITAbstractInstruction implements Cloneable{
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KFrame callerFrame = null;
        KLocalThread thread = frame.getThread();
         // *********[6] POP
        frame.pop();
         // *********[7] RETURN
         // **REMOVED Substitution** callerFrame = thread.popFrame();
        return ((JJITInstruction)thread.popFrame().getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[6] POP
         // *********[7] RETURN
      }
}
