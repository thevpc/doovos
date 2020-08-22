package jjit.local.jnt.scimark2.LU.factor___D_I_I_722247B8;
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
 * factor([[D[I)I
 * [count=10] [97] ALOAD(0) [98] ILOAD(12) [99] AALOAD [100] ILOAD(5) [101] DUP2Type1 [102] DALOAD [103] DLOAD(10) [104] DMUL [105] DASTORE [106] IINC(12,1)
 */
public final class factor_013 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
        KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** KReference ref;
        KRegister reg;
         // **REMOVED Unused Var** KRegister reg2;
         // **REMOVED Unused Var** double m_d;
         // **REMOVED Unused Var** double m_d2;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_5 5 ; r=1/w=0 : NotCached
         // local_10 10 ; r=1/w=0 : NotCached
         // local_12 12 ; r=2/w=1 : Cached
        int local_12 = frame.getLocal(12).intValue();
         // *********[97] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[98] ILOAD(12)
         // **REMOVED Substitution** s1 = new KInteger(local_12);
         // *********[99] AALOAD
         // **REMOVED Substitution** index = local_12;
         // **REMOVED Substitution** ref = ((KReference)frame.getLocal(0));
        s0_ref = c_memman.getReferenceArray(((KReference)frame.getLocal(0)),local_12);
         // *********[100] ILOAD(5)
         // **REMOVED Substitution** s1 = frame.getLocal(5);
         // *********[101] DUP2Type1
        reg = frame.getLocal(5);
         // **REMOVED Substitution** reg2 = s0_ref;
         // **REMOVED Substitution** s1 = reg;
         // **REMOVED Substitution** s2 = s0_ref;
         // **REMOVED Substitution** s3 = reg;
         // *********[102] DALOAD
         // **REMOVED Substitution** index = reg.intValue();
         // **REMOVED Substitution** s2 = new KDouble(c_memman.getDoubleArray(s0_ref,reg.intValue()));
         // *********[103] DLOAD(10)
         // **REMOVED Substitution** s3 = frame.getLocal(10);
         // *********[104] DMUL
         // **REMOVED Substitution** m_d = frame.getLocal(10).doubleValue();
         // **REMOVED Substitution** s2 = new KDouble((c_memman.getDoubleArray(s0_ref,reg.intValue()) * frame.getLocal(10).doubleValue()));
         // *********[105] DASTORE
         // **REMOVED Substitution** m_d2 = (c_memman.getDoubleArray(s0_ref,reg.intValue()) * frame.getLocal(10).doubleValue());
         // **REMOVED Substitution** index = reg.intValue();
        c_memman.setDoubleArray(s0_ref,reg.intValue(),(c_memman.getDoubleArray(s0_ref,reg.intValue()) * frame.getLocal(10).doubleValue()));
         // *********[106] IINC(12,1)
         // **REMOVED Substitution** local_12 = (local_12 + 1);
        frame.setLocal(12,new KInteger((local_12 + 1)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[97] ALOAD(0)
         // *********[98] ILOAD(12)
         // *********[99] AALOAD
        c_memman = process.getMemoryManager();
         // *********[100] ILOAD(5)
         // *********[101] DUP2Type1
         // *********[102] DALOAD
         // *********[103] DLOAD(10)
         // *********[104] DMUL
         // *********[105] DASTORE
         // *********[106] IINC(12,1)
        c_next = instructions[(index + 1)];
      }
}
