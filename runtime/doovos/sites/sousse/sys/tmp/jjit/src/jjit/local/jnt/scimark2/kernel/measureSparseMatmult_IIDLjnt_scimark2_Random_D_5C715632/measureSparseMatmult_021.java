package jjit.local.jnt.scimark2.kernel.measureSparseMatmult_IIDLjnt_scimark2_Random_D_5C715632;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.kernel
 * measureSparseMatmult(IIDLjnt/scimark2/Random;)D
 * [count=5] [99] ILOAD(14) [100] ICONST_2(Integer{2}) [101] IMUL [102] ISTORE(14) [103] GOTO(81)
 */
public final class measureSparseMatmult_021 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // local_14 14 ; r=1/w=1 : Cached
        int local_14 = frame.getLocal(14).intValue();
         // *********[99] ILOAD(14)
         // **REMOVED Substitution** s0 = new KInteger(local_14);
         // *********[100] ICONST_2(Integer{2})
         // **REMOVED Substitution** s1 = ITWO;
         // *********[101] IMUL
         // **REMOVED Substitution** index = 2;
         // **REMOVED Substitution** s0 = new KInteger((local_14 * 2));
         // *********[102] ISTORE(14)
         // **REMOVED Substitution** local_14 = (local_14 * 2);
         // *********[103] GOTO(81)
        frame.setLocal(14,new KInteger((local_14 * 2)));
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[99] ILOAD(14)
         // *********[100] ICONST_2(Integer{2})
         // *********[101] IMUL
         // *********[102] ISTORE(14)
         // *********[103] GOTO(81)
        c_label = instructions[14];
      }
}
