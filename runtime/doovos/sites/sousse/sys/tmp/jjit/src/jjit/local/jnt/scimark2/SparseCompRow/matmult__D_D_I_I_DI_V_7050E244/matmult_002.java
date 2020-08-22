package jjit.local.jnt.scimark2.SparseCompRow.matmult__D_D_I_I_DI_V_7050E244;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.SparseCompRow
 * matmult([D[D[I[I[DI)V
 * [count=3] [8] ICONST_0(Integer{0}) [9] ISTORE(8) [10] GOTO(47)
 */
public final class matmult_002 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_8 8 ; r=0/w=1 : NotCached
         // *********[8] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[9] ISTORE(8)
        frame.setLocal(8,KInteger.ZERO);
         // *********[10] GOTO(47)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[8] ICONST_0(Integer{0})
         // *********[9] ISTORE(8)
         // *********[10] GOTO(47)
        c_label = instructions[6];
      }
}
