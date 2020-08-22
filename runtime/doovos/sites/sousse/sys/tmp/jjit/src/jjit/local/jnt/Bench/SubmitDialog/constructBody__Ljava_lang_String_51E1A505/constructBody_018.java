package jjit.local.jnt.Bench.SubmitDialog.constructBody__Ljava_lang_String_51E1A505;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.SubmitDialog
 * constructBody()Ljava/lang/String;
 * [count=3] [35] ICONST_0(Integer{0}) [36] ISTORE(3) [37] GOTO(52)
 */
public final class constructBody_018 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_3 3 ; r=0/w=1 : NotCached
         // *********[35] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[36] ISTORE(3)
        frame.setLocal(3,KInteger.ZERO);
         // *********[37] GOTO(52)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[35] ICONST_0(Integer{0})
         // *********[36] ISTORE(3)
         // *********[37] GOTO(52)
        c_label = instructions[24];
      }
}
