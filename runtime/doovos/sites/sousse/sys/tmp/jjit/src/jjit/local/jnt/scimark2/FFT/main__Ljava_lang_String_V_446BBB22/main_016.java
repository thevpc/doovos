package jjit.local.jnt.scimark2.FFT.main__Ljava_lang_String_V_446BBB22;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.FFT
 * main([Ljava/lang/String;)V
 * [count=3] [21] ICONST_0(Integer{0}) [22] ISTORE(1) [23] GOTO(46)
 */
public final class main_016 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_1 1 ; r=0/w=1 : NotCached
         // *********[21] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[22] ISTORE(1)
        frame.setLocal(1,KInteger.ZERO);
         // *********[23] GOTO(46)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[21] ICONST_0(Integer{0})
         // *********[22] ISTORE(1)
         // *********[23] GOTO(46)
        c_label = instructions[27];
      }
}
