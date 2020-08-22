package jjit.local.jnt.scimark2.kernel.normabs__D_D_D_9592EBA0;
import java.lang.Math;
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
 * normabs([D[D)D
 * [count=12] [8] DLOAD(3) [9] ALOAD(0) [10] ILOAD(5) [11] DALOAD [12] ALOAD(1) [13] ILOAD(5) [14] DALOAD [15] DSUB [16] INVOKE_HOST(java.lang.Math.abs(D)D) [17] DADD [18] DSTORE(3) [19] IINC(5,1)
 */
public final class normabs_002 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** double m_d;
         // **REMOVED Unused Var** KRegister[] regs = null;
         // **REMOVED Unused Var** double m_v;
         // **REMOVED Unused Var** double m_d2;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=1 : Cached
        KRegister local_3 = frame.getLocal(3);
         // local_5 5 ; r=3/w=1 : Cached
        int local_5 = frame.getLocal(5).intValue();
         // *********[8] DLOAD(3)
         // **REMOVED Substitution** s0 = local_3;
         // *********[9] ALOAD(0)
         // **REMOVED Substitution** s1 = frame.getLocal(0);
         // *********[10] ILOAD(5)
         // **REMOVED Substitution** s2 = new KInteger(local_5);
         // *********[11] DALOAD
         // **REMOVED Substitution** index = local_5;
         // **REMOVED Substitution** s1 = new KDouble(c_memman.getDoubleArray(((KReference)frame.getLocal(0)),local_5));
         // *********[12] ALOAD(1)
         // **REMOVED Substitution** s2 = frame.getLocal(1);
         // *********[13] ILOAD(5)
         // **REMOVED Substitution** s3 = new KInteger(local_5);
         // *********[14] DALOAD
         // **REMOVED Substitution** index = local_5;
         // **REMOVED Substitution** s2 = new KDouble(c_memman.getDoubleArray(((KReference)frame.getLocal(1)),local_5));
         // *********[15] DSUB
         // **REMOVED Substitution** m_d = c_memman.getDoubleArray(((KReference)frame.getLocal(1)),local_5);
         // **REMOVED Substitution** s1 = new KDouble((c_memman.getDoubleArray(((KReference)frame.getLocal(0)),local_5) - c_memman.getDoubleArray(((KReference)frame.getLocal(1)),local_5)));
         // *********[16] INVOKE_HOST(java.lang.Math.abs(D)D)
         // **REMOVED Substitution** m_v = (c_memman.getDoubleArray(((KReference)frame.getLocal(0)),local_5) - c_memman.getDoubleArray(((KReference)frame.getLocal(1)),local_5));
         // **REMOVED Substitution** s1 = new KDouble(Math.abs((c_memman.getDoubleArray(((KReference)frame.getLocal(0)),local_5) - c_memman.getDoubleArray(((KReference)frame.getLocal(1)),local_5))));
         // *********[17] DADD
         // **REMOVED Substitution** m_d2 = Math.abs((c_memman.getDoubleArray(((KReference)frame.getLocal(0)),local_5) - c_memman.getDoubleArray(((KReference)frame.getLocal(1)),local_5)));
         // **REMOVED Substitution** s0 = new KDouble((local_3.doubleValue() + Math.abs((c_memman.getDoubleArray(((KReference)frame.getLocal(0)),local_5) - c_memman.getDoubleArray(((KReference)frame.getLocal(1)),local_5)))));
         // *********[18] DSTORE(3)
         // **REMOVED Substitution** local_3 = new KDouble((local_3.doubleValue() + Math.abs((c_memman.getDoubleArray(((KReference)frame.getLocal(0)),local_5) - c_memman.getDoubleArray(((KReference)frame.getLocal(1)),local_5)))));
         // *********[19] IINC(5,1)
         // **REMOVED Substitution** local_5 = (local_5 + 1);
        frame.setLocal(3,new KDouble((local_3.doubleValue() + Math.abs((c_memman.getDoubleArray(((KReference)frame.getLocal(0)),local_5) - c_memman.getDoubleArray(((KReference)frame.getLocal(1)),local_5))))));
        frame.setLocal(5,new KInteger((local_5 + 1)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[8] DLOAD(3)
         // *********[9] ALOAD(0)
         // *********[10] ILOAD(5)
         // *********[11] DALOAD
        c_memman = process.getMemoryManager();
         // *********[12] ALOAD(1)
         // *********[13] ILOAD(5)
         // *********[14] DALOAD
         // *********[15] DSUB
         // *********[16] INVOKE_HOST(java.lang.Math.abs(D)D)
         // *********[17] DADD
         // *********[18] DSTORE(3)
         // *********[19] IINC(5,1)
        c_next = instructions[(index + 1)];
      }
}
