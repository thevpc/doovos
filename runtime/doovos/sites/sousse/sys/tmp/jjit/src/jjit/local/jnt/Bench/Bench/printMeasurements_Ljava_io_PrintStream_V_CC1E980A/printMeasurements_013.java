package jjit.local.jnt.Bench.Bench.printMeasurements_Ljava_io_PrintStream_V_CC1E980A;
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
 * printMeasurements(Ljava/io/PrintStream;)V
 * [count=3] [39] ICONST_0(Integer{0}) [40] ISTORE(5) [41] GOTO(48)
 */
public final class printMeasurements_013 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_5 5 ; r=0/w=1 : NotCached
         // *********[39] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[40] ISTORE(5)
        frame.setLocal(5,KInteger.ZERO);
         // *********[41] GOTO(48)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[39] ICONST_0(Integer{0})
         // *********[40] ISTORE(5)
         // *********[41] GOTO(48)
        c_label = instructions[15];
      }
}
