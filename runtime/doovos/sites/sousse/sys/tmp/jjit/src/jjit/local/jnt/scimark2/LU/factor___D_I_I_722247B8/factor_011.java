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
 * [count=5] [79] ILOAD(5) [80] ILOAD(3) [81] ICONST_1(Integer{1}) [82] ISUB [83] IF_ICMPGE(110)
 */
public final class factor_011 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_3 3 ; r=1/w=0 : NotCached
         // local_5 5 ; r=1/w=0 : NotCached
         // *********[79] ILOAD(5)
         // **REMOVED Substitution** s0 = frame.getLocal(5);
         // *********[80] ILOAD(3)
         // **REMOVED Substitution** s1 = frame.getLocal(3);
         // *********[81] ICONST_1(Integer{1})
         // **REMOVED Substitution** s2 = IONE;
         // *********[82] ISUB
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s1 = new KInteger((frame.getLocal(3).intValue() - 1));
         // *********[83] IF_ICMPGE(110)
         // **REMOVED Substitution** index = (frame.getLocal(3).intValue() - 1);
         // **REMOVED Substitution** jump = frame.getLocal(5).intValue() >= (frame.getLocal(3).intValue() - 1);
        return ((frame.getLocal(5).intValue() >= (frame.getLocal(3).intValue() - 1))?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[79] ILOAD(5)
         // *********[80] ILOAD(3)
         // *********[81] ICONST_1(Integer{1})
         // *********[82] ISUB
         // *********[83] IF_ICMPGE(110)
        c_next = instructions[(index + 1)];
        c_label = instructions[14];
      }
}