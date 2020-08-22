package jjit.local.jnt.scimark2.FFT.makeRandom_I__D_F7EBEC05;
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
 * jnt.scimark2.FFT
 * makeRandom(I)[D
 * [count=10] [0] ICONST_2(Integer{2}) [1] ILOAD(0) [2] IMUL [3] ISTORE(1) [4] ILOAD(1) [5] NEWARRAY [6] ASTORE(2) [7] ICONST_0(Integer{0}) [8] ISTORE(3) [9] GOTO(15)
 */
public final class makeRandom_001 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
        KMemorySegment memseg = frame.getMemorySegment();
         // local_0 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=1 : Cached
        int local_1;
         // local_2 2 ; r=0/w=1 : NotCached
         // local_3 3 ; r=0/w=1 : NotCached
         // *********[0] ICONST_2(Integer{2})
         // **REMOVED Substitution** s0 = ITWO;
         // *********[1] ILOAD(0)
         // **REMOVED Substitution** s1 = frame.getLocal(0);
         // *********[2] IMUL
         // **REMOVED Substitution** index = frame.getLocal(0).intValue();
         // **REMOVED Substitution** s0 = new KInteger((2 * frame.getLocal(0).intValue()));
         // *********[3] ISTORE(1)
        local_1 = (2 * frame.getLocal(0).intValue());
         // *********[4] ILOAD(1)
         // **REMOVED Substitution** s0 = new KInteger(local_1);
         // *********[5] NEWARRAY
         // **REMOVED Substitution** s0_ref = memseg.allocDoubleArray(local_1);
         // *********[6] ASTORE(2)
        frame.setLocal(2,memseg.allocDoubleArray(local_1));
         // *********[7] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[8] ISTORE(3)
        frame.setLocal(3,KInteger.ZERO);
         // *********[9] GOTO(15)
        frame.setLocal(1,new KInteger(local_1));
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ICONST_2(Integer{2})
         // *********[1] ILOAD(0)
         // *********[2] IMUL
         // *********[3] ISTORE(1)
         // *********[4] ILOAD(1)
         // *********[5] NEWARRAY
         // *********[6] ASTORE(2)
         // *********[7] ICONST_0(Integer{0})
         // *********[8] ISTORE(3)
         // *********[9] GOTO(15)
        c_label = instructions[2];
      }
}
