package jjit.local.jnt.scimark2.kernel.matvec___D_D_D_V_E007F59D;
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
 * jnt.scimark2.kernel
 * matvec([[D[D[D)V
 * [count=11] [20] DLOAD(6) [21] ALOAD(8) [22] ILOAD(9) [23] DALOAD [24] ALOAD(1) [25] ILOAD(9) [26] DALOAD [27] DMUL [28] DADD [29] DSTORE(6) [30] IINC(9,1)
 */
public final class matvec_003 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** double m_d;
         // **REMOVED Unused Var** double m_d2;
         // local_1 1 ; r=1/w=0 : NotCached
         // local_6 6 ; r=1/w=1 : Cached
        KRegister local_6 = frame.getLocal(6);
         // local_8 8 ; r=1/w=0 : NotCached
         // local_9 9 ; r=3/w=1 : Cached
        int local_9 = frame.getLocal(9).intValue();
         // *********[20] DLOAD(6)
         // **REMOVED Substitution** s0 = local_6;
         // *********[21] ALOAD(8)
         // **REMOVED Substitution** s1 = frame.getLocal(8);
         // *********[22] ILOAD(9)
         // **REMOVED Substitution** s2 = new KInteger(local_9);
         // *********[23] DALOAD
         // **REMOVED Substitution** index = local_9;
         // **REMOVED Substitution** s1 = new KDouble(c_memman.getDoubleArray(((KReference)frame.getLocal(8)),local_9));
         // *********[24] ALOAD(1)
         // **REMOVED Substitution** s2 = frame.getLocal(1);
         // *********[25] ILOAD(9)
         // **REMOVED Substitution** s3 = new KInteger(local_9);
         // *********[26] DALOAD
         // **REMOVED Substitution** index = local_9;
         // **REMOVED Substitution** s2 = new KDouble(c_memman.getDoubleArray(((KReference)frame.getLocal(1)),local_9));
         // *********[27] DMUL
         // **REMOVED Substitution** m_d = c_memman.getDoubleArray(((KReference)frame.getLocal(1)),local_9);
         // **REMOVED Substitution** s1 = new KDouble((c_memman.getDoubleArray(((KReference)frame.getLocal(8)),local_9) * c_memman.getDoubleArray(((KReference)frame.getLocal(1)),local_9)));
         // *********[28] DADD
         // **REMOVED Substitution** m_d2 = (c_memman.getDoubleArray(((KReference)frame.getLocal(8)),local_9) * c_memman.getDoubleArray(((KReference)frame.getLocal(1)),local_9));
         // **REMOVED Substitution** s0 = new KDouble((local_6.doubleValue() + (c_memman.getDoubleArray(((KReference)frame.getLocal(8)),local_9) * c_memman.getDoubleArray(((KReference)frame.getLocal(1)),local_9))));
         // *********[29] DSTORE(6)
         // **REMOVED Substitution** local_6 = new KDouble((local_6.doubleValue() + (c_memman.getDoubleArray(((KReference)frame.getLocal(8)),local_9) * c_memman.getDoubleArray(((KReference)frame.getLocal(1)),local_9))));
         // *********[30] IINC(9,1)
         // **REMOVED Substitution** local_9 = (local_9 + 1);
        frame.setLocal(6,new KDouble((local_6.doubleValue() + (c_memman.getDoubleArray(((KReference)frame.getLocal(8)),local_9) * c_memman.getDoubleArray(((KReference)frame.getLocal(1)),local_9)))));
        frame.setLocal(9,new KInteger((local_9 + 1)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[20] DLOAD(6)
         // *********[21] ALOAD(8)
         // *********[22] ILOAD(9)
         // *********[23] DALOAD
        c_memman = process.getMemoryManager();
         // *********[24] ALOAD(1)
         // *********[25] ILOAD(9)
         // *********[26] DALOAD
         // *********[27] DMUL
         // *********[28] DADD
         // *********[29] DSTORE(6)
         // *********[30] IINC(9,1)
        c_next = instructions[(index + 1)];
      }
}
