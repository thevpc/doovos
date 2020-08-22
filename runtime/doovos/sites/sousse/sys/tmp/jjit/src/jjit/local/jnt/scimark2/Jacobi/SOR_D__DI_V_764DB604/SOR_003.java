package jjit.local.jnt.scimark2.Jacobi.SOR_D__DI_V_764DB604;
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
 * jnt.scimark2.Jacobi
 * SOR(D[[DI)V
 * [count=19] [30] ALOAD(2) [31] ILOAD(13) [32] AALOAD [33] ASTORE(14) [34] ALOAD(2) [35] ILOAD(13) [36] ICONST_1(Integer{1}) [37] ISUB [38] AALOAD [39] ASTORE(15) [40] ALOAD(2) [41] ILOAD(13) [42] ICONST_1(Integer{1}) [43] IADD [44] AALOAD [45] ASTORE(16) [46] ICONST_1(Integer{1}) [47] ISTORE(17) [48] GOTO(80)
 */
public final class SOR_003 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** KReference ref;
         // local_17 17 ; r=0/w=1 : NotCached
         // local_16 16 ; r=0/w=1 : NotCached
         // local_2 2 ; r=3/w=0 : Cached
        KRegister local_2 = frame.getLocal(2);
         // local_13 13 ; r=3/w=0 : Cached
        int local_13 = frame.getLocal(13).intValue();
         // local_14 14 ; r=0/w=1 : NotCached
         // local_15 15 ; r=0/w=1 : NotCached
         // *********[30] ALOAD(2)
         // **REMOVED Substitution** s0 = local_2;
         // *********[31] ILOAD(13)
         // **REMOVED Substitution** s1 = new KInteger(local_13);
         // *********[32] AALOAD
         // **REMOVED Substitution** index = local_13;
         // **REMOVED Substitution** ref = ((KReference)local_2);
         // **REMOVED Substitution** s0_ref = c_memman.getReferenceArray(((KReference)local_2),local_13);
         // *********[33] ASTORE(14)
        frame.setLocal(14,c_memman.getReferenceArray(((KReference)local_2),local_13));
         // *********[34] ALOAD(2)
         // **REMOVED Substitution** s0 = local_2;
         // *********[35] ILOAD(13)
         // **REMOVED Substitution** s1 = new KInteger(local_13);
         // *********[36] ICONST_1(Integer{1})
         // **REMOVED Substitution** s2 = IONE;
         // *********[37] ISUB
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s1 = new KInteger((local_13 - 1));
         // *********[38] AALOAD
         // **REMOVED Substitution** index = (local_13 - 1);
         // **REMOVED Substitution** ref = ((KReference)local_2);
         // **REMOVED Substitution** s0_ref = c_memman.getReferenceArray(((KReference)local_2),(local_13 - 1));
         // *********[39] ASTORE(15)
        frame.setLocal(15,c_memman.getReferenceArray(((KReference)local_2),(local_13 - 1)));
         // *********[40] ALOAD(2)
         // **REMOVED Substitution** s0 = local_2;
         // *********[41] ILOAD(13)
         // **REMOVED Substitution** s1 = new KInteger(local_13);
         // *********[42] ICONST_1(Integer{1})
         // **REMOVED Substitution** s2 = IONE;
         // *********[43] IADD
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s1 = new KInteger((local_13 + 1));
         // *********[44] AALOAD
         // **REMOVED Substitution** index = (local_13 + 1);
         // **REMOVED Substitution** ref = ((KReference)local_2);
         // **REMOVED Substitution** s0_ref = c_memman.getReferenceArray(((KReference)local_2),(local_13 + 1));
         // *********[45] ASTORE(16)
        frame.setLocal(16,c_memman.getReferenceArray(((KReference)local_2),(local_13 + 1)));
         // *********[46] ICONST_1(Integer{1})
         // **REMOVED Substitution** s0 = IONE;
         // *********[47] ISTORE(17)
        frame.setLocal(17,KInteger.ONE);
         // *********[48] GOTO(80)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[30] ALOAD(2)
         // *********[31] ILOAD(13)
         // *********[32] AALOAD
        c_memman = process.getMemoryManager();
         // *********[33] ASTORE(14)
         // *********[34] ALOAD(2)
         // *********[35] ILOAD(13)
         // *********[36] ICONST_1(Integer{1})
         // *********[37] ISUB
         // *********[38] AALOAD
         // *********[39] ASTORE(15)
         // *********[40] ALOAD(2)
         // *********[41] ILOAD(13)
         // *********[42] ICONST_1(Integer{1})
         // *********[43] IADD
         // *********[44] AALOAD
         // *********[45] ASTORE(16)
         // *********[46] ICONST_1(Integer{1})
         // *********[47] ISTORE(17)
         // *********[48] GOTO(80)
        c_label = instructions[4];
      }
}
