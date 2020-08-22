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
 * [count=3] [55] ICONST_0(Integer{0}) [56] ISTORE(15) [57] GOTO(67)
 */
public final class measureSparseMatmult_006 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_15 15 ; r=0/w=1 : NotCached
         // *********[55] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[56] ISTORE(15)
        frame.setLocal(15,KInteger.ZERO);
         // *********[57] GOTO(67)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[55] ICONST_0(Integer{0})
         // *********[56] ISTORE(15)
         // *********[57] GOTO(67)
        c_label = instructions[7];
      }
}
