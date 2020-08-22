package jjit.local.jnt.scimark2.kernel.CopyVector__D_D_V_1E07109C;
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
 * CopyVector([D[D)V
 * [count=7] [6] ALOAD(0) [7] ILOAD(3) [8] ALOAD(1) [9] ILOAD(3) [10] DALOAD [11] DASTORE [12] IINC(3,1)
 */
public final class CopyVector_002 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** double m_d;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // local_3 3 ; r=3/w=1 : Cached
        int local_3 = frame.getLocal(3).intValue();
         // *********[6] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[7] ILOAD(3)
         // **REMOVED Substitution** s1 = new KInteger(local_3);
         // *********[8] ALOAD(1)
         // **REMOVED Substitution** s2 = frame.getLocal(1);
         // *********[9] ILOAD(3)
         // **REMOVED Substitution** s3 = new KInteger(local_3);
         // *********[10] DALOAD
         // **REMOVED Substitution** index = local_3;
         // **REMOVED Substitution** s2 = new KDouble(c_memman.getDoubleArray(((KReference)frame.getLocal(1)),local_3));
         // *********[11] DASTORE
         // **REMOVED Substitution** m_d = c_memman.getDoubleArray(((KReference)frame.getLocal(1)),local_3);
         // **REMOVED Substitution** index = local_3;
        c_memman.setDoubleArray(((KReference)frame.getLocal(0)),local_3,c_memman.getDoubleArray(((KReference)frame.getLocal(1)),local_3));
         // *********[12] IINC(3,1)
         // **REMOVED Substitution** local_3 = (local_3 + 1);
        frame.setLocal(3,new KInteger((local_3 + 1)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[6] ALOAD(0)
         // *********[7] ILOAD(3)
         // *********[8] ALOAD(1)
         // *********[9] ILOAD(3)
         // *********[10] DALOAD
        c_memman = process.getMemoryManager();
         // *********[11] DASTORE
         // *********[12] IINC(3,1)
        c_next = instructions[(index + 1)];
      }
}
