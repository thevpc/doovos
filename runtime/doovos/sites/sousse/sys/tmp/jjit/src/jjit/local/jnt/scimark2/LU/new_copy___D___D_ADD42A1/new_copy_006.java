package jjit.local.jnt.scimark2.LU.new_copy___D___D_ADD42A1;
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
 * new_copy([[D)[[D
 * [count=7] [26] ALOAD(5) [27] ILOAD(7) [28] ALOAD(6) [29] ILOAD(7) [30] DALOAD [31] DASTORE [32] IINC(7,1)
 */
public final class new_copy_006 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** double m_d;
         // local_5 5 ; r=1/w=0 : NotCached
         // local_6 6 ; r=1/w=0 : NotCached
         // local_7 7 ; r=3/w=1 : Cached
        int local_7 = frame.getLocal(7).intValue();
         // *********[26] ALOAD(5)
         // **REMOVED Substitution** s0 = frame.getLocal(5);
         // *********[27] ILOAD(7)
         // **REMOVED Substitution** s1 = new KInteger(local_7);
         // *********[28] ALOAD(6)
         // **REMOVED Substitution** s2 = frame.getLocal(6);
         // *********[29] ILOAD(7)
         // **REMOVED Substitution** s3 = new KInteger(local_7);
         // *********[30] DALOAD
         // **REMOVED Substitution** index = local_7;
         // **REMOVED Substitution** s2 = new KDouble(c_memman.getDoubleArray(((KReference)frame.getLocal(6)),local_7));
         // *********[31] DASTORE
         // **REMOVED Substitution** m_d = c_memman.getDoubleArray(((KReference)frame.getLocal(6)),local_7);
         // **REMOVED Substitution** index = local_7;
        c_memman.setDoubleArray(((KReference)frame.getLocal(5)),local_7,c_memman.getDoubleArray(((KReference)frame.getLocal(6)),local_7));
         // *********[32] IINC(7,1)
         // **REMOVED Substitution** local_7 = (local_7 + 1);
        frame.setLocal(7,new KInteger((local_7 + 1)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[26] ALOAD(5)
         // *********[27] ILOAD(7)
         // *********[28] ALOAD(6)
         // *********[29] ILOAD(7)
         // *********[30] DALOAD
        c_memman = process.getMemoryManager();
         // *********[31] DASTORE
         // *********[32] IINC(7,1)
        c_next = instructions[(index + 1)];
      }
}
