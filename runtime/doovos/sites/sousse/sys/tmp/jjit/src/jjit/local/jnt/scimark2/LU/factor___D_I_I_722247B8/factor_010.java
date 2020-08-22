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
 * [count=14] [65] ALOAD(0) [66] ILOAD(5) [67] AALOAD [68] ASTORE(10) [69] ALOAD(0) [70] ILOAD(5) [71] ALOAD(0) [72] ILOAD(6) [73] AALOAD [74] AASTORE [75] ALOAD(0) [76] ILOAD(6) [77] ALOAD(10) [78] AASTORE
 */
public final class factor_010 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s2_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KReference m_r;
         // **REMOVED Unused Var** KReference m_r2;
         // local_0 0 ; r=4/w=0 : Cached
        KRegister local_0 = frame.getLocal(0);
         // local_5 5 ; r=2/w=0 : Cached
        int local_5 = frame.getLocal(5).intValue();
         // local_6 6 ; r=2/w=0 : Cached
        int local_6 = frame.getLocal(6).intValue();
         // local_10 10 ; r=1/w=1 : Cached
        KRegister local_10;
         // *********[65] ALOAD(0)
         // **REMOVED Substitution** s0 = local_0;
         // *********[66] ILOAD(5)
         // **REMOVED Substitution** s1 = new KInteger(local_5);
         // *********[67] AALOAD
         // **REMOVED Substitution** index = local_5;
         // **REMOVED Substitution** ref = ((KReference)local_0);
         // **REMOVED Substitution** s0_ref = c_memman.getReferenceArray(((KReference)local_0),local_5);
         // *********[68] ASTORE(10)
        local_10 = c_memman.getReferenceArray(((KReference)local_0),local_5);
         // *********[69] ALOAD(0)
         // **REMOVED Substitution** s0 = local_0;
         // *********[70] ILOAD(5)
         // **REMOVED Substitution** s1 = new KInteger(local_5);
         // *********[71] ALOAD(0)
         // **REMOVED Substitution** s2 = local_0;
         // *********[72] ILOAD(6)
         // **REMOVED Substitution** s3 = new KInteger(local_6);
         // *********[73] AALOAD
         // **REMOVED Substitution** index = local_6;
         // **REMOVED Substitution** ref = ((KReference)local_0);
         // **REMOVED Substitution** s2_ref = c_memman.getReferenceArray(((KReference)local_0),local_6);
         // *********[74] AASTORE
         // **REMOVED Substitution** m_r = c_memman.getReferenceArray(((KReference)local_0),local_6);
         // **REMOVED Substitution** index = local_5;
        c_memman.setReferenceArray(((KReference)local_0),local_5,c_memman.getReferenceArray(((KReference)local_0),local_6));
         // *********[75] ALOAD(0)
         // **REMOVED Substitution** s0 = local_0;
         // *********[76] ILOAD(6)
         // **REMOVED Substitution** s1 = new KInteger(local_6);
         // *********[77] ALOAD(10)
         // **REMOVED Substitution** s2 = local_10;
         // *********[78] AASTORE
         // **REMOVED Substitution** m_r2 = ((KReference)local_10);
         // **REMOVED Substitution** index = local_6;
        c_memman.setReferenceArray(((KReference)local_0),local_6,((KReference)local_10));
        frame.setLocal(10,local_10);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[65] ALOAD(0)
         // *********[66] ILOAD(5)
         // *********[67] AALOAD
        c_memman = process.getMemoryManager();
         // *********[68] ASTORE(10)
         // *********[69] ALOAD(0)
         // *********[70] ILOAD(5)
         // *********[71] ALOAD(0)
         // *********[72] ILOAD(6)
         // *********[73] AALOAD
         // *********[74] AASTORE
         // *********[75] ALOAD(0)
         // *********[76] ILOAD(6)
         // *********[77] ALOAD(10)
         // *********[78] AASTORE
        c_next = instructions[(index + 1)];
      }
}
