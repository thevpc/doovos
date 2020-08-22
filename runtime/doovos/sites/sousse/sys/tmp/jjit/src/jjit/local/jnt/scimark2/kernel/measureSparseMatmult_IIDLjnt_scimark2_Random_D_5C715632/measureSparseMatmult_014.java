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
 * [count=4] [77] ASTORE(13) [78] ICONST_1(Integer{1}) [79] ISTORE(14) [80] GOTO(81)
 */
public final class measureSparseMatmult_014 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_13 13 ; r=0/w=1 : NotCached
         // local_14 14 ; r=0/w=1 : NotCached
         // *********[77] ASTORE(13)
        frame.setLocal(13,frame.pop());
         // *********[78] ICONST_1(Integer{1})
         // **REMOVED Substitution** s0 = IONE;
         // *********[79] ISTORE(14)
        frame.setLocal(14,KInteger.ONE);
         // *********[80] GOTO(81)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[77] ASTORE(13)
         // *********[78] ICONST_1(Integer{1})
         // *********[79] ISTORE(14)
         // *********[80] GOTO(81)
        c_label = instructions[14];
      }
}
