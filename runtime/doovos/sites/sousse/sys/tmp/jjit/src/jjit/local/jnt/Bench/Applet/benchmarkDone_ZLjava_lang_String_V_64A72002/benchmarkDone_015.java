package jjit.local.jnt.Bench.Applet.benchmarkDone_ZLjava_lang_String_V_64A72002;
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
 * benchmarkDone(ZLjava/lang/String;)V
 * [count=2] [22] ICONST_1(Integer{1}) [23] GOTO(25)
 */
public final class benchmarkDone_015 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger IONE = KInteger.ONE;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // *********[22] ICONST_1(Integer{1})
        frame.push(IONE);
         // *********[23] GOTO(25)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[22] ICONST_1(Integer{1})
         // *********[23] GOTO(25)
        c_label = instructions[16];
      }
}
