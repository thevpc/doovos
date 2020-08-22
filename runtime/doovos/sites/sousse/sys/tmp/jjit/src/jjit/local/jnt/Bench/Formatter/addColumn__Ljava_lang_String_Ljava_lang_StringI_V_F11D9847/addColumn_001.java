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
 * [count=7] [0] ICONST_0(Integer{0}) [1] ISTORE(3) [2] ICONST_0(Integer{0}) [3] ISTORE(4) [4] ICONST_0(Integer{0}) [5] ISTORE(6) [6] GOTO(28)
 */
public final class addColumn_001 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_3 3 ; r=0/w=1 : NotCached
         // local_4 4 ; r=0/w=1 : NotCached
         // local_6 6 ; r=0/w=1 : NotCached
         // *********[0] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[1] ISTORE(3)
        frame.setLocal(3,KInteger.ZERO);
         // *********[2] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[3] ISTORE(4)
        frame.setLocal(4,KInteger.ZERO);
         // *********[4] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[5] ISTORE(6)
        frame.setLocal(6,KInteger.ZERO);
         // *********[6] GOTO(28)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ICONST_0(Integer{0})
         // *********[1] ISTORE(3)
         // *********[2] ICONST_0(Integer{0})
         // *********[3] ISTORE(4)
         // *********[4] ICONST_0(Integer{0})
         // *********[5] ISTORE(6)
         // *********[6] GOTO(28)
        c_label = instructions[8];
      }
}
