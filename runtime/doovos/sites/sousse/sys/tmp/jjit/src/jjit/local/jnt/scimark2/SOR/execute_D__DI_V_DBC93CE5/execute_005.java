package jjit.local.jnt.scimark2.SOR.execute_D__DI_V_DBC93CE5;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.SOR
 * execute(D[[DI)V
 * [count=3] [80] ILOAD(17) [81] ILOAD(11) [82] IF_ICMPLT(49)
 */
public final class execute_005 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_17 17 ; r=1/w=0 : NotCached
         // local_11 11 ; r=1/w=0 : NotCached
         // *********[80] ILOAD(17)
         // **REMOVED Substitution** s0 = frame.getLocal(17);
         // *********[81] ILOAD(11)
         // **REMOVED Substitution** s1 = frame.getLocal(11);
         // *********[82] IF_ICMPLT(49)
         // **REMOVED Substitution** index = frame.getLocal(11).intValue();
         // **REMOVED Substitution** jump = frame.getLocal(17).intValue() < frame.getLocal(11).intValue();
        return ((frame.getLocal(17).intValue() < frame.getLocal(11).intValue())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[80] ILOAD(17)
         // *********[81] ILOAD(11)
         // *********[82] IF_ICMPLT(49)
        c_next = instructions[(index + 1)];
        c_label = instructions[3];
      }
}
