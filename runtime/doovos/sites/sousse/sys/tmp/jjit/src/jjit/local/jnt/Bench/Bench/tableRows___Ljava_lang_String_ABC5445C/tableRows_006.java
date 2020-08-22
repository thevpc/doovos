package jjit.local.jnt.Bench.Bench.tableRows___Ljava_lang_String_ABC5445C;
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
 * tableRows()[Ljava/lang/String;
 * [count=4] [15] ASTORE(2) [16] ICONST_0(Integer{0}) [17] ISTORE(3) [18] GOTO(50)
 */
public final class tableRows_006 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_2 2 ; r=0/w=1 : NotCached
         // local_3 3 ; r=0/w=1 : NotCached
         // *********[15] ASTORE(2)
        frame.setLocal(2,frame.pop());
         // *********[16] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[17] ISTORE(3)
        frame.setLocal(3,KInteger.ZERO);
         // *********[18] GOTO(50)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[15] ASTORE(2)
         // *********[16] ICONST_0(Integer{0})
         // *********[17] ISTORE(3)
         // *********[18] GOTO(50)
        c_label = instructions[11];
      }
}
