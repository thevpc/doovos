package jjit.local.jnt.Bench.Applet.init__V_44AFC1AA;
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
 * init()V
 * [count=3] [28] ASTORE(3) [29] ALOAD(3) [30] IFNONNULL(38)
 */
public final class init_014 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_3 3 ; r=1/w=1 : Cached
        KRegister local_3;
         // *********[28] ASTORE(3)
        local_3 = frame.pop();
         // *********[29] ALOAD(3)
         // **REMOVED Substitution** s0 = local_3;
         // *********[30] IFNONNULL(38)
        frame.setLocal(3,local_3);
        return ((((KReference)local_3).isNotNull())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[28] ASTORE(3)
         // *********[29] ALOAD(3)
         // *********[30] IFNONNULL(38)
        c_next = instructions[(index + 1)];
        c_label = instructions[18];
      }
}
