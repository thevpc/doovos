package jjit.local.jnt.scimark2.kernel.RandomVector_ILjnt_scimark2_Random__D_4892868B;
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
 * jnt.scimark2.kernel
 * RandomVector(ILjnt/scimark2/Random;)[D
 * [count=6] [0] ILOAD(0) [1] NEWARRAY [2] ASTORE(2) [3] ICONST_0(Integer{0}) [4] ISTORE(3) [5] GOTO(12)
 */
public final class RandomVector_001 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // local_0 0 ; r=1/w=0 : NotCached
         // local_2 2 ; r=0/w=1 : NotCached
         // local_3 3 ; r=0/w=1 : NotCached
         // *********[0] ILOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[1] NEWARRAY
         // **REMOVED Substitution** s0_ref = memseg.allocDoubleArray(frame.getLocal(0).intValue());
         // *********[2] ASTORE(2)
        frame.setLocal(2,memseg.allocDoubleArray(frame.getLocal(0).intValue()));
         // *********[3] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[4] ISTORE(3)
        frame.setLocal(3,KInteger.ZERO);
         // *********[5] GOTO(12)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ILOAD(0)
         // *********[1] NEWARRAY
         // *********[2] ASTORE(2)
         // *********[3] ICONST_0(Integer{0})
         // *********[4] ISTORE(3)
         // *********[5] GOTO(12)
        c_label = instructions[3];
      }
}
