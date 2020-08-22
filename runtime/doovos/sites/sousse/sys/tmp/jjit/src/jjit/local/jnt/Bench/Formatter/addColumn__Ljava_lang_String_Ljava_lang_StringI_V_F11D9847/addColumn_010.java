package jjit.local.jnt.Bench.Formatter.addColumn__Ljava_lang_String_Ljava_lang_StringI_V_F11D9847;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Formatter
 * addColumn([Ljava/lang/String;[Ljava/lang/String;I)V
 * [count=3] [32] ICONST_0(Integer{0}) [33] ISTORE(7) [34] GOTO(70)
 */
public final class addColumn_010 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_7 7 ; r=0/w=1 : NotCached
         // *********[32] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[33] ISTORE(7)
        frame.setLocal(7,KInteger.ZERO);
         // *********[34] GOTO(70)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[32] ICONST_0(Integer{0})
         // *********[33] ISTORE(7)
         // *********[34] GOTO(70)
        c_label = instructions[19];
      }
}
