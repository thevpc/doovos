package jjit.local.jnt.Bench.Bench.isSubmittable__Z_A41AE0F7;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Bench
 * isSubmittable()Z
 * [count=2] [6] ICONST_1(Integer{1}) [7] GOTO(9)
 */
public final class isSubmittable_003 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger IONE = KInteger.ONE;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // *********[6] ICONST_1(Integer{1})
        frame.push(IONE);
         // *********[7] GOTO(9)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[6] ICONST_1(Integer{1})
         // *********[7] GOTO(9)
        c_label = instructions[4];
      }
}
