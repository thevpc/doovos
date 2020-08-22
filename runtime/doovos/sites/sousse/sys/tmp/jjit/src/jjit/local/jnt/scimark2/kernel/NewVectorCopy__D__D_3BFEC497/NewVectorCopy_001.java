package jjit.local.jnt.scimark2.kernel.NewVectorCopy__D__D_3BFEC497;
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
 * jnt.scimark2.kernel
 * NewVectorCopy([D)[D
 * [count=9] [0] ALOAD(0) [1] ARRAYLENGTH [2] ISTORE(1) [3] ILOAD(1) [4] NEWARRAY [5] ASTORE(2) [6] ICONST_0(Integer{0}) [7] ISTORE(3) [8] GOTO(16)
 */
public final class NewVectorCopy_001 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // local_0 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=1 : Cached
        int local_1;
         // local_2 2 ; r=0/w=1 : NotCached
         // local_3 3 ; r=0/w=1 : NotCached
         // *********[0] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[1] ARRAYLENGTH
         // **REMOVED Substitution** s0 = new KInteger(c_memman.getArraySize(((KReference)frame.getLocal(0))));
         // *********[2] ISTORE(1)
        local_1 = c_memman.getArraySize(((KReference)frame.getLocal(0)));
         // *********[3] ILOAD(1)
         // **REMOVED Substitution** s0 = new KInteger(local_1);
         // *********[4] NEWARRAY
         // **REMOVED Substitution** s0_ref = memseg.allocDoubleArray(local_1);
         // *********[5] ASTORE(2)
        frame.setLocal(2,memseg.allocDoubleArray(local_1));
         // *********[6] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[7] ISTORE(3)
        frame.setLocal(3,KInteger.ZERO);
         // *********[8] GOTO(16)
        frame.setLocal(1,new KInteger(local_1));
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[2] ISTORE(1)
         // *********[3] ILOAD(1)
         // *********[4] NEWARRAY
         // *********[5] ASTORE(2)
         // *********[6] ICONST_0(Integer{0})
         // *********[7] ISTORE(3)
         // *********[8] GOTO(16)
        c_label = instructions[2];
      }
}
