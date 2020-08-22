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
 * [count=6] [2] ASTORE(2) [3] ICONST_0(Integer{0}) [4] ISTORE(3) [5] ICONST_0(Integer{0}) [6] ISTORE(4) [7] GOTO(22)
 */
public final class printMeasurements_002 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_2 2 ; r=0/w=1 : NotCached
         // local_3 3 ; r=0/w=1 : NotCached
         // local_4 4 ; r=0/w=1 : NotCached
         // *********[2] ASTORE(2)
        frame.setLocal(2,frame.pop());
         // *********[3] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[4] ISTORE(3)
        frame.setLocal(3,KInteger.ZERO);
         // *********[5] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[6] ISTORE(4)
        frame.setLocal(4,KInteger.ZERO);
         // *********[7] GOTO(22)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[2] ASTORE(2)
         // *********[3] ICONST_0(Integer{0})
         // *********[4] ISTORE(3)
         // *********[5] ICONST_0(Integer{0})
         // *********[6] ISTORE(4)
         // *********[7] GOTO(22)
        c_label = instructions[5];
      }
}
