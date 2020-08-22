package jjit.local.jnt.Bench.Applet.waitCursor__V_6A2B968E;
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
 * waitCursor()V
 * [count=2] [10] ALOAD(1) [11] IFNULL(15)
 */
public final class waitCursor_008 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[10] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[11] IFNULL(15)
        return ((((KReference)frame.getLocal(1)).isNull())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[10] ALOAD(1)
         // *********[11] IFNULL(15)
        c_next = instructions[(index + 1)];
        c_label = instructions[9];
      }
}
