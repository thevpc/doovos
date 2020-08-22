package jjit.local.jnt.scimark2.FFT.test__D_D_DFA9FC78;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.FFT
 * test([D)D
 * [count=11] [0] ALOAD(0) [1] ARRAYLENGTH [2] ISTORE(1) [3] ILOAD(1) [4] NEWARRAY [5] ASTORE(2) [6] ALOAD(0) [7] ICONST_0(Integer{0}) [8] ALOAD(2) [9] ICONST_0(Integer{0}) [10] ILOAD(1)
 */
public final class test_001 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private static final KInteger IZERO = KInteger.ZERO;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // local_0 0 ; r=2/w=0 : Cached
        KRegister local_0 = frame.getLocal(0);
         // local_1 1 ; r=2/w=1 : Cached
        int local_1;
         // local_2 2 ; r=1/w=1 : Cached
        KRegister local_2;
         // *********[0] ALOAD(0)
         // **REMOVED Substitution** s0 = local_0;
         // *********[1] ARRAYLENGTH
         // **REMOVED Substitution** s0 = new KInteger(c_memman.getArraySize(((KReference)local_0)));
         // *********[2] ISTORE(1)
        local_1 = c_memman.getArraySize(((KReference)local_0));
         // *********[3] ILOAD(1)
         // **REMOVED Substitution** s0 = new KInteger(local_1);
         // *********[4] NEWARRAY
         // **REMOVED Substitution** s0_ref = memseg.allocDoubleArray(local_1);
         // *********[5] ASTORE(2)
        local_2 = memseg.allocDoubleArray(local_1);
         // *********[6] ALOAD(0)
        frame.push(local_0);
         // *********[7] ICONST_0(Integer{0})
        frame.push(IZERO);
         // *********[8] ALOAD(2)
        frame.push(local_2);
         // *********[9] ICONST_0(Integer{0})
        frame.push(IZERO);
         // *********[10] ILOAD(1)
        frame.push(new KInteger(local_1));
        frame.setLocal(1,new KInteger(local_1));
        frame.setLocal(2,local_2);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[2] ISTORE(1)
         // *********[3] ILOAD(1)
         // *********[4] NEWARRAY
         // *********[5] ASTORE(2)
         // *********[6] ALOAD(0)
         // *********[7] ICONST_0(Integer{0})
         // *********[8] ALOAD(2)
         // *********[9] ICONST_0(Integer{0})
         // *********[10] ILOAD(1)
        c_next = instructions[(index + 1)];
      }
}
