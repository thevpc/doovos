package jjit.local.jnt.scimark2.FFT.test__D_D_DFA9FC78;
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
 * jnt.scimark2.FFT
 * test([D)D
 * [count=15] [21] ALOAD(0) [22] ILOAD(5) [23] DALOAD [24] ALOAD(2) [25] ILOAD(5) [26] DALOAD [27] DSUB [28] DSTORE(6) [29] DLOAD(3) [30] DLOAD(6) [31] DLOAD(6) [32] DMUL [33] DADD [34] DSTORE(3) [35] IINC(5,1)
 */
public final class test_007 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** double m_d;
         // **REMOVED Unused Var** double m_d2;
         // **REMOVED Unused Var** double m_d3;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=1 : Cached
        KRegister local_3 = frame.getLocal(3);
         // local_5 5 ; r=3/w=1 : Cached
        int local_5 = frame.getLocal(5).intValue();
         // local_6 6 ; r=2/w=1 : Cached
        KRegister local_6;
         // *********[21] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[22] ILOAD(5)
         // **REMOVED Substitution** s1 = new KInteger(local_5);
         // *********[23] DALOAD
         // **REMOVED Substitution** index = local_5;
         // **REMOVED Substitution** s0 = new KDouble(c_memman.getDoubleArray(((KReference)frame.getLocal(0)),local_5));
         // *********[24] ALOAD(2)
         // **REMOVED Substitution** s1 = frame.getLocal(2);
         // *********[25] ILOAD(5)
         // **REMOVED Substitution** s2 = new KInteger(local_5);
         // *********[26] DALOAD
         // **REMOVED Substitution** index = local_5;
         // **REMOVED Substitution** s1 = new KDouble(c_memman.getDoubleArray(((KReference)frame.getLocal(2)),local_5));
         // *********[27] DSUB
         // **REMOVED Substitution** m_d = c_memman.getDoubleArray(((KReference)frame.getLocal(2)),local_5);
         // **REMOVED Substitution** s0 = new KDouble((c_memman.getDoubleArray(((KReference)frame.getLocal(0)),local_5) - c_memman.getDoubleArray(((KReference)frame.getLocal(2)),local_5)));
         // *********[28] DSTORE(6)
        local_6 = new KDouble((c_memman.getDoubleArray(((KReference)frame.getLocal(0)),local_5) - c_memman.getDoubleArray(((KReference)frame.getLocal(2)),local_5)));
         // *********[29] DLOAD(3)
         // **REMOVED Substitution** s0 = local_3;
         // *********[30] DLOAD(6)
         // **REMOVED Substitution** s1 = local_6;
         // *********[31] DLOAD(6)
         // **REMOVED Substitution** s2 = local_6;
         // *********[32] DMUL
         // **REMOVED Substitution** m_d2 = local_6.doubleValue();
         // **REMOVED Substitution** s1 = new KDouble((local_6.doubleValue() * local_6.doubleValue()));
         // *********[33] DADD
         // **REMOVED Substitution** m_d3 = (local_6.doubleValue() * local_6.doubleValue());
         // **REMOVED Substitution** s0 = new KDouble((local_3.doubleValue() + (local_6.doubleValue() * local_6.doubleValue())));
         // *********[34] DSTORE(3)
         // **REMOVED Substitution** local_3 = new KDouble((local_3.doubleValue() + (local_6.doubleValue() * local_6.doubleValue())));
         // *********[35] IINC(5,1)
         // **REMOVED Substitution** local_5 = (local_5 + 1);
        frame.setLocal(3,new KDouble((local_3.doubleValue() + (local_6.doubleValue() * local_6.doubleValue()))));
        frame.setLocal(5,new KInteger((local_5 + 1)));
        frame.setLocal(6,local_6);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[21] ALOAD(0)
         // *********[22] ILOAD(5)
         // *********[23] DALOAD
        c_memman = process.getMemoryManager();
         // *********[24] ALOAD(2)
         // *********[25] ILOAD(5)
         // *********[26] DALOAD
         // *********[27] DSUB
         // *********[28] DSTORE(6)
         // *********[29] DLOAD(3)
         // *********[30] DLOAD(6)
         // *********[31] DLOAD(6)
         // *********[32] DMUL
         // *********[33] DADD
         // *********[34] DSTORE(3)
         // *********[35] IINC(5,1)
        c_next = instructions[(index + 1)];
      }
}
