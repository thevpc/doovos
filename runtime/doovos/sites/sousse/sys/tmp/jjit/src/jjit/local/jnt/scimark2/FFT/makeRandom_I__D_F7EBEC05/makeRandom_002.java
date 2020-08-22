package jjit.local.jnt.scimark2.FFT.makeRandom_I__D_F7EBEC05;
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
 * jnt.scimark2.FFT
 * makeRandom(I)[D
 * [count=5] [10] ALOAD(2) [11] ILOAD(3) [12] INVOKE_HOST(java.lang.Math.random()D) [13] DASTORE [14] IINC(3,1)
 */
public final class makeRandom_002 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister[] regs = null;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** double m_d;
         // local_2 2 ; r=1/w=0 : NotCached
         // local_3 3 ; r=2/w=1 : Cached
        int local_3 = frame.getLocal(3).intValue();
         // *********[10] ALOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[11] ILOAD(3)
         // **REMOVED Substitution** s1 = new KInteger(local_3);
         // *********[12] INVOKE_HOST(java.lang.Math.random()D)
         // **REMOVED Substitution** s2 = new KDouble(Math.random());
         // *********[13] DASTORE
         // **REMOVED Substitution** m_d = Math.random();
         // **REMOVED Substitution** index = local_3;
        c_memman.setDoubleArray(((KReference)frame.getLocal(2)),local_3,Math.random());
         // *********[14] IINC(3,1)
         // **REMOVED Substitution** local_3 = (local_3 + 1);
        frame.setLocal(3,new KInteger((local_3 + 1)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[10] ALOAD(2)
         // *********[11] ILOAD(3)
         // *********[12] INVOKE_HOST(java.lang.Math.random()D)
         // *********[13] DASTORE
        c_memman = process.getMemoryManager();
         // *********[14] IINC(3,1)
        c_next = instructions[(index + 1)];
      }
}
