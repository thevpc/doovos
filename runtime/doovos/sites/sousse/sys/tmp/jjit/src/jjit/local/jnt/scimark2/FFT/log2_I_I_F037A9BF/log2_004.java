package jjit.local.jnt.scimark2.FFT.log2_I_I_F037A9BF;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.FFT
 * log2(I)I
 * [count=5] [13] ILOAD(0) [14] ICONST_1(Integer{1}) [15] ILOAD(1) [16] ISHL [17] IF_ICMPEQ(30)
 */
public final class log2_004 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[13] ILOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[14] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[15] ILOAD(1)
         // **REMOVED Substitution** s2 = frame.getLocal(1);
         // *********[16] ISHL
         // **REMOVED Substitution** index = frame.getLocal(1).intValue();
         // **REMOVED Substitution** s1 = new KInteger((1 << frame.getLocal(1).intValue()));
         // *********[17] IF_ICMPEQ(30)
         // **REMOVED Substitution** index = (1 << frame.getLocal(1).intValue());
         // **REMOVED Substitution** jump = frame.getLocal(0).intValue() == (1 << frame.getLocal(1).intValue());
        return ((frame.getLocal(0).intValue() == (1 << frame.getLocal(1).intValue()))?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[13] ILOAD(0)
         // *********[14] ICONST_1(Integer{1})
         // *********[15] ILOAD(1)
         // *********[16] ISHL
         // *********[17] IF_ICMPEQ(30)
        c_next = instructions[(index + 1)];
        c_label = instructions[13];
      }
}
