package jjit.local.jnt.Bench.Bench.run__V_F2C678D6;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Bench
 * run()V
 * [count=2] [44] ALOAD(3) [45] ATHROW
 */
public final class run_024 extends JJITAbstractInstruction implements Cloneable{
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_3 3 ; r=1/w=0 : NotCached
         // *********[44] ALOAD(3)
         // **REMOVED Substitution** s0 = frame.getLocal(3);
         // *********[45] ATHROW
        frame.throwThrowable(((KReference)frame.getLocal(3)));
        return ((JJITInstruction)frame.getThread().getFrame().getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[44] ALOAD(3)
         // *********[45] ATHROW
      }
}
