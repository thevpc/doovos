package jjit.local.jnt.Bench.Applet.submissionDone_ZLjava_lang_String_V_44E63249;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Applet
 * submissionDone(ZLjava/lang/String;)V
 * [count=2] [8] ICONST_1(Integer{1}) [9] GOTO(11)
 */
public final class submissionDone_005 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger IONE = KInteger.ONE;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // *********[8] ICONST_1(Integer{1})
        frame.push(IONE);
         // *********[9] GOTO(11)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[8] ICONST_1(Integer{1})
         // *********[9] GOTO(11)
        c_label = instructions[7];
      }
}
