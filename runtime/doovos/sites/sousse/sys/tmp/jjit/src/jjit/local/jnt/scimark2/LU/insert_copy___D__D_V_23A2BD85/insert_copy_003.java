package jjit.local.jnt.scimark2.LU.insert_copy___D__D_V_23A2BD85;
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
 * insert_copy([[D[[D)V
 * [count=7] [26] ALOAD(6) [27] ILOAD(8) [28] ALOAD(7) [29] ILOAD(8) [30] DALOAD [31] DASTORE [32] IINC(8,1)
 */
public final class insert_copy_003 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** double m_d;
         // local_6 6 ; r=1/w=0 : NotCached
         // local_7 7 ; r=1/w=0 : NotCached
         // local_8 8 ; r=3/w=1 : Cached
        int local_8 = frame.getLocal(8).intValue();
         // *********[26] ALOAD(6)
         // **REMOVED Substitution** s0 = frame.getLocal(6);
         // *********[27] ILOAD(8)
         // **REMOVED Substitution** s1 = new KInteger(local_8);
         // *********[28] ALOAD(7)
         // **REMOVED Substitution** s2 = frame.getLocal(7);
         // *********[29] ILOAD(8)
         // **REMOVED Substitution** s3 = new KInteger(local_8);
         // *********[30] DALOAD
         // **REMOVED Substitution** index = local_8;
         // **REMOVED Substitution** s2 = new KDouble(c_memman.getDoubleArray(((KReference)frame.getLocal(7)),local_8));
         // *********[31] DASTORE
         // **REMOVED Substitution** m_d = c_memman.getDoubleArray(((KReference)frame.getLocal(7)),local_8);
         // **REMOVED Substitution** index = local_8;
        c_memman.setDoubleArray(((KReference)frame.getLocal(6)),local_8,c_memman.getDoubleArray(((KReference)frame.getLocal(7)),local_8));
         // *********[32] IINC(8,1)
         // **REMOVED Substitution** local_8 = (local_8 + 1);
        frame.setLocal(8,new KInteger((local_8 + 1)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[26] ALOAD(6)
         // *********[27] ILOAD(8)
         // *********[28] ALOAD(7)
         // *********[29] ILOAD(8)
         // *********[30] DALOAD
        c_memman = process.getMemoryManager();
         // *********[31] DASTORE
         // *********[32] IINC(8,1)
        c_next = instructions[(index + 1)];
      }
}
