package jjit.local.jnt.Bench.Bench.getSegmentValues_I__D_36C3CC1F;
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
 * jnt.Bench.Bench
 * getSegmentValues(I)[D
 * [count=5] [3] NEWARRAY [4] ASTORE(2) [5] ICONST_0(Integer{0}) [6] ISTORE(3) [7] GOTO(20)
 */
public final class getSegmentValues_004 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // local_2 2 ; r=0/w=1 : NotCached
         // local_3 3 ; r=0/w=1 : NotCached
         // *********[3] NEWARRAY
         // **REMOVED Substitution** s0_ref = memseg.allocDoubleArray(frame.popInt());
         // *********[4] ASTORE(2)
        frame.setLocal(2,memseg.allocDoubleArray(frame.popInt()));
         // *********[5] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[6] ISTORE(3)
        frame.setLocal(3,KInteger.ZERO);
         // *********[7] GOTO(20)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[3] NEWARRAY
         // *********[4] ASTORE(2)
         // *********[5] ICONST_0(Integer{0})
         // *********[6] ISTORE(3)
         // *********[7] GOTO(20)
        c_label = instructions[6];
      }
}
