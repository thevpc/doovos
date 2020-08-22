package jjit.local.jnt.Bench.Bench.isRunnable__Z_6C025744;
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
 * isRunnable()Z
 * [count=2] [3] ICONST_1(Integer{1}) [4] GOTO(6)
 */
public final class isRunnable_002 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger IONE = KInteger.ONE;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // *********[3] ICONST_1(Integer{1})
        frame.push(IONE);
         // *********[4] GOTO(6)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[3] ICONST_1(Integer{1})
         // *********[4] GOTO(6)
        c_label = instructions[3];
      }
}
