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
 * [count=5] [5] ILOAD(2) [6] ICONST_2(Integer{2}) [7] IMUL [8] ISTORE(2) [9] IINC(1,1)
 */
public final class log2_002 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // local_1 1 ; r=1/w=1 : Cached
        int local_1 = frame.getLocal(1).intValue();
         // local_2 2 ; r=1/w=1 : Cached
        int local_2 = frame.getLocal(2).intValue();
         // *********[5] ILOAD(2)
         // **REMOVED Substitution** s0 = new KInteger(local_2);
         // *********[6] ICONST_2(Integer{2})
         // **REMOVED Substitution** s1 = ITWO;
         // *********[7] IMUL
         // **REMOVED Substitution** index = 2;
         // **REMOVED Substitution** s0 = new KInteger((local_2 * 2));
         // *********[8] ISTORE(2)
         // **REMOVED Substitution** local_2 = (local_2 * 2);
         // *********[9] IINC(1,1)
         // **REMOVED Substitution** local_1 = (local_1 + 1);
        frame.setLocal(1,new KInteger((local_1 + 1)));
        frame.setLocal(2,new KInteger((local_2 * 2)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[5] ILOAD(2)
         // *********[6] ICONST_2(Integer{2})
         // *********[7] IMUL
         // *********[8] ISTORE(2)
         // *********[9] IINC(1,1)
        c_next = instructions[(index + 1)];
      }
}
