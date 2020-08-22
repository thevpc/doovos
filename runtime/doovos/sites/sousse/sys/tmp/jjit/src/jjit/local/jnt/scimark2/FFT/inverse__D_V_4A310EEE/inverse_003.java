package jjit.local.jnt.scimark2.FFT.inverse__D_V_4A310EEE;
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
 * inverse([D)V
 * [count=8] [18] ALOAD(0) [19] ILOAD(5) [20] DUP2Type1 [21] DALOAD [22] DLOAD(3) [23] DMUL [24] DASTORE [25] IINC(5,1)
 */
public final class inverse_003 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
         // **REMOVED Unused Var** KRegister reg;
         // **REMOVED Unused Var** KRegister reg2;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** double m_d;
         // **REMOVED Unused Var** double m_d2;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=0 : NotCached
         // local_5 5 ; r=2/w=1 : Cached
        int local_5 = frame.getLocal(5).intValue();
         // *********[18] ALOAD(0)
        s0 = frame.getLocal(0);
         // *********[19] ILOAD(5)
         // **REMOVED Substitution** s1 = new KInteger(local_5);
         // *********[20] DUP2Type1
         // **REMOVED Substitution** reg = new KInteger(local_5);
         // **REMOVED Substitution** reg2 = s0;
         // **REMOVED Substitution** s1 = new KInteger(local_5);
         // **REMOVED Substitution** s2 = s0;
         // **REMOVED Substitution** s3 = new KInteger(local_5);
         // *********[21] DALOAD
         // **REMOVED Substitution** index = local_5;
         // **REMOVED Substitution** s2 = new KDouble(c_memman.getDoubleArray(((KReference)s0),local_5));
         // *********[22] DLOAD(3)
         // **REMOVED Substitution** s3 = frame.getLocal(3);
         // *********[23] DMUL
         // **REMOVED Substitution** m_d = frame.getLocal(3).doubleValue();
         // **REMOVED Substitution** s2 = new KDouble((c_memman.getDoubleArray(((KReference)s0),local_5) * frame.getLocal(3).doubleValue()));
         // *********[24] DASTORE
         // **REMOVED Substitution** m_d2 = (c_memman.getDoubleArray(((KReference)s0),local_5) * frame.getLocal(3).doubleValue());
         // **REMOVED Substitution** index = local_5;
        c_memman.setDoubleArray(((KReference)s0),local_5,(c_memman.getDoubleArray(((KReference)s0),local_5) * frame.getLocal(3).doubleValue()));
         // *********[25] IINC(5,1)
         // **REMOVED Substitution** local_5 = (local_5 + 1);
        frame.setLocal(5,new KInteger((local_5 + 1)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[18] ALOAD(0)
         // *********[19] ILOAD(5)
         // *********[20] DUP2Type1
         // *********[21] DALOAD
        c_memman = process.getMemoryManager();
         // *********[22] DLOAD(3)
         // *********[23] DMUL
         // *********[24] DASTORE
         // *********[25] IINC(5,1)
        c_next = instructions[(index + 1)];
      }
}
