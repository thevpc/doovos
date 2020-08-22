package jjit.local.jnt.Bench.Formatter.pad_CI_Ljava_lang_String_58D199A6;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Formatter
 * pad(CI)Ljava/lang/String;
 * [count=6] [4] ILOAD(1) [5] NEWARRAY [6] ASTORE(2) [7] ICONST_0(Integer{0}) [8] ISTORE(3) [9] GOTO(15)
 */
public final class pad_003 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // local_1 1 ; r=1/w=0 : NotCached
         // local_2 2 ; r=0/w=1 : NotCached
         // local_3 3 ; r=0/w=1 : NotCached
         // *********[4] ILOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[5] NEWARRAY
         // **REMOVED Substitution** s0_ref = memseg.allocCharArray(frame.getLocal(1).intValue());
         // *********[6] ASTORE(2)
        frame.setLocal(2,memseg.allocCharArray(frame.getLocal(1).intValue()));
         // *********[7] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[8] ISTORE(3)
        frame.setLocal(3,KInteger.ZERO);
         // *********[9] GOTO(15)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[4] ILOAD(1)
         // *********[5] NEWARRAY
         // *********[6] ASTORE(2)
         // *********[7] ICONST_0(Integer{0})
         // *********[8] ISTORE(3)
         // *********[9] GOTO(15)
        c_label = instructions[4];
      }
}
