package jjit.local.jnt.Bench.Bench.parseEntries_Ljava_io_StreamTokenizer_V_6B9C6DF2;
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
 * parseEntries(Ljava/io/StreamTokenizer;)V
 * [count=2] [55] ICONST_1(Integer{1}) [56] GOTO(58)
 */
public final class parseEntries_014 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger IONE = KInteger.ONE;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // *********[55] ICONST_1(Integer{1})
        frame.push(IONE);
         // *********[56] GOTO(58)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[55] ICONST_1(Integer{1})
         // *********[56] GOTO(58)
        c_label = instructions[15];
      }
}
