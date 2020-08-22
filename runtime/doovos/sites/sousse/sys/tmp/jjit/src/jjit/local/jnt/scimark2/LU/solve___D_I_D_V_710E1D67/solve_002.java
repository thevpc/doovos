package jjit.local.jnt.scimark2.LU.solve___D_I_D_V_710E1D67;
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
 * solve([[D[I[D)V
 * [count=16] [13] ALOAD(1) [14] ILOAD(6) [15] IALOAD [16] ISTORE(7) [17] ALOAD(2) [18] ILOAD(7) [19] DALOAD [20] DSTORE(8) [21] ALOAD(2) [22] ILOAD(7) [23] ALOAD(2) [24] ILOAD(6) [25] DALOAD [26] DASTORE [27] ILOAD(5) [28] IFNE(49)
 */
public final class solve_002 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** double m_d;
        boolean jump;
         // local_1 1 ; r=1/w=0 : NotCached
         // local_2 2 ; r=3/w=0 : Cached
        KRegister local_2 = frame.getLocal(2);
         // local_5 5 ; r=1/w=0 : NotCached
         // local_6 6 ; r=2/w=0 : Cached
        int local_6 = frame.getLocal(6).intValue();
         // local_7 7 ; r=2/w=1 : Cached
        int local_7;
         // local_8 8 ; r=0/w=1 : NotCached
         // *********[13] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[14] ILOAD(6)
         // **REMOVED Substitution** s1 = new KInteger(local_6);
         // *********[15] IALOAD
         // **REMOVED Substitution** index = local_6;
         // **REMOVED Substitution** s0 = new KInteger(c_memman.getIntArray(((KReference)frame.getLocal(1)),local_6));
         // *********[16] ISTORE(7)
        local_7 = c_memman.getIntArray(((KReference)frame.getLocal(1)),local_6);
         // *********[17] ALOAD(2)
         // **REMOVED Substitution** s0 = local_2;
         // *********[18] ILOAD(7)
         // **REMOVED Substitution** s1 = new KInteger(local_7);
         // *********[19] DALOAD
         // **REMOVED Substitution** index = local_7;
         // **REMOVED Substitution** s0 = new KDouble(c_memman.getDoubleArray(((KReference)local_2),local_7));
         // *********[20] DSTORE(8)
        frame.setLocal(8,new KDouble(c_memman.getDoubleArray(((KReference)local_2),local_7)));
         // *********[21] ALOAD(2)
         // **REMOVED Substitution** s0 = local_2;
         // *********[22] ILOAD(7)
         // **REMOVED Substitution** s1 = new KInteger(local_7);
         // *********[23] ALOAD(2)
         // **REMOVED Substitution** s2 = local_2;
         // *********[24] ILOAD(6)
         // **REMOVED Substitution** s3 = new KInteger(local_6);
         // *********[25] DALOAD
         // **REMOVED Substitution** index = local_6;
         // **REMOVED Substitution** s2 = new KDouble(c_memman.getDoubleArray(((KReference)local_2),local_6));
         // *********[26] DASTORE
         // **REMOVED Substitution** m_d = c_memman.getDoubleArray(((KReference)local_2),local_6);
         // **REMOVED Substitution** index = local_7;
        c_memman.setDoubleArray(((KReference)local_2),local_7,c_memman.getDoubleArray(((KReference)local_2),local_6));
         // *********[27] ILOAD(5)
         // **REMOVED Substitution** s0 = frame.getLocal(5);
         // *********[28] IFNE(49)
         // **REMOVED Substitution** index = frame.getLocal(5).intValue();
        jump = frame.getLocal(5).intValue() != 0;
        frame.setLocal(7,new KInteger(local_7));
        return ((jump)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[13] ALOAD(1)
         // *********[14] ILOAD(6)
         // *********[15] IALOAD
        c_memman = process.getMemoryManager();
         // *********[16] ISTORE(7)
         // *********[17] ALOAD(2)
         // *********[18] ILOAD(7)
         // *********[19] DALOAD
         // *********[20] DSTORE(8)
         // *********[21] ALOAD(2)
         // *********[22] ILOAD(7)
         // *********[23] ALOAD(2)
         // *********[24] ILOAD(6)
         // *********[25] DALOAD
         // *********[26] DASTORE
         // *********[27] ILOAD(5)
         // *********[28] IFNE(49)
        c_next = instructions[(index + 1)];
        c_label = instructions[6];
      }
}
