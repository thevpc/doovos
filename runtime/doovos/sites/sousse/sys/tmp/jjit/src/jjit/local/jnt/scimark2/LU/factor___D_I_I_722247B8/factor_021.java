package jjit.local.jnt.scimark2.LU.factor___D_I_I_722247B8;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.LU
 * factor([[D[I)I
 * [count=3] [153] ILOAD(10) [154] ILOAD(3) [155] IF_ICMPLT(120)
 */
public final class factor_021 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_3 3 ; r=1/w=0 : NotCached
         // local_10 10 ; r=1/w=0 : NotCached
         // *********[153] ILOAD(10)
         // **REMOVED Substitution** s0 = frame.getLocal(10);
         // *********[154] ILOAD(3)
         // **REMOVED Substitution** s1 = frame.getLocal(3);
         // *********[155] IF_ICMPLT(120)
         // **REMOVED Substitution** index = frame.getLocal(3).intValue();
         // **REMOVED Substitution** jump = frame.getLocal(10).intValue() < frame.getLocal(3).intValue();
        return ((frame.getLocal(10).intValue() < frame.getLocal(3).intValue())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[153] ILOAD(10)
         // *********[154] ILOAD(3)
         // *********[155] IF_ICMPLT(120)
        c_next = instructions[(index + 1)];
        c_label = instructions[16];
      }
}
