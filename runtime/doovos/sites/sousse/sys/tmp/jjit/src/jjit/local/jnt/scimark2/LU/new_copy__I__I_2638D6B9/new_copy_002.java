package jjit.local.jnt.scimark2.LU.new_copy__I__I_2638D6B9;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.LU
 * new_copy([I)[I
 * [count=7] [9] ALOAD(2) [10] ILOAD(3) [11] ALOAD(0) [12] ILOAD(3) [13] IALOAD [14] IASTORE [15] IINC(3,1)
 */
public final class new_copy_002 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** int m_i;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // local_3 3 ; r=3/w=1 : Cached
        int local_3 = frame.getLocal(3).intValue();
         // *********[9] ALOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[10] ILOAD(3)
         // **REMOVED Substitution** s1 = new KInteger(local_3);
         // *********[11] ALOAD(0)
         // **REMOVED Substitution** s2 = frame.getLocal(0);
         // *********[12] ILOAD(3)
         // **REMOVED Substitution** s3 = new KInteger(local_3);
         // *********[13] IALOAD
         // **REMOVED Substitution** index = local_3;
         // **REMOVED Substitution** s2 = new KInteger(c_memman.getIntArray(((KReference)frame.getLocal(0)),local_3));
         // *********[14] IASTORE
         // **REMOVED Substitution** m_i = c_memman.getIntArray(((KReference)frame.getLocal(0)),local_3);
         // **REMOVED Substitution** index = local_3;
        c_memman.setIntArray(((KReference)frame.getLocal(2)),local_3,c_memman.getIntArray(((KReference)frame.getLocal(0)),local_3));
         // *********[15] IINC(3,1)
         // **REMOVED Substitution** local_3 = (local_3 + 1);
        frame.setLocal(3,new KInteger((local_3 + 1)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[9] ALOAD(2)
         // *********[10] ILOAD(3)
         // *********[11] ALOAD(0)
         // *********[12] ILOAD(3)
         // *********[13] IALOAD
        c_memman = process.getMemoryManager();
         // *********[14] IASTORE
         // *********[15] IINC(3,1)
        c_next = instructions[(index + 1)];
      }
}
