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
 * [count=3] [336] ASTORE(9) [337] ALOAD(9) [338] IFNONNULL(341)
 */
public final class init_106 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_9 9 ; r=1/w=1 : Cached
        KRegister local_9;
         // *********[336] ASTORE(9)
        local_9 = frame.pop();
         // *********[337] ALOAD(9)
         // **REMOVED Substitution** s0 = local_9;
         // *********[338] IFNONNULL(341)
        frame.setLocal(9,local_9);
        return ((((KReference)local_9).isNotNull())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[336] ASTORE(9)
         // *********[337] ALOAD(9)
         // *********[338] IFNONNULL(341)
        c_next = instructions[(index + 1)];
        c_label = instructions[107];
      }
}
