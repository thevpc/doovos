package jjit.local.jnt.scimark2.SparseCompRow.matmult__D_D_I_I_DI_V_7050E244;
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
 * jnt.scimark2.SparseCompRow
 * matmult([D[D[I[I[DI)V
 * [count=5] [42] ALOAD(0) [43] ILOAD(8) [44] DLOAD(9) [45] DASTORE [46] IINC(8,1)
 */
public final class matmult_006 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** double m_d;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_8 8 ; r=2/w=1 : Cached
        int local_8 = frame.getLocal(8).intValue();
         // local_9 9 ; r=1/w=0 : NotCached
         // *********[42] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[43] ILOAD(8)
         // **REMOVED Substitution** s1 = new KInteger(local_8);
         // *********[44] DLOAD(9)
         // **REMOVED Substitution** s2 = frame.getLocal(9);
         // *********[45] DASTORE
         // **REMOVED Substitution** m_d = frame.getLocal(9).doubleValue();
         // **REMOVED Substitution** index = local_8;
        c_memman.setDoubleArray(((KReference)frame.getLocal(0)),local_8,frame.getLocal(9).doubleValue());
         // *********[46] IINC(8,1)
         // **REMOVED Substitution** local_8 = (local_8 + 1);
        frame.setLocal(8,new KInteger((local_8 + 1)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[42] ALOAD(0)
         // *********[43] ILOAD(8)
         // *********[44] DLOAD(9)
         // *********[45] DASTORE
        c_memman = process.getMemoryManager();
         // *********[46] IINC(8,1)
        c_next = instructions[(index + 1)];
      }
}
