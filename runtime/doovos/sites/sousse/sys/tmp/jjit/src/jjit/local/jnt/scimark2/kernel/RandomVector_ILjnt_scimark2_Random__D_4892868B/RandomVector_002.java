package jjit.local.jnt.scimark2.kernel.RandomVector_ILjnt_scimark2_Random__D_4892868B;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.kernel
 * RandomVector(ILjnt/scimark2/Random;)[D
 * [count=4] [6] ALOAD(2) [7] ILOAD(3) [8] ALOAD(1) [9] INVOKEVIRTUAL(jnt.scimark2.Random,nextDouble()D)
 */
public final class RandomVector_002 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_1 1 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=0 : NotCached
         // *********[6] ALOAD(2)
        frame.push(frame.getLocal(2));
         // *********[7] ILOAD(3)
        frame.push(frame.getLocal(3));
         // *********[8] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[9] INVOKEVIRTUAL(jnt.scimark2.Random,nextDouble()D)
        regs = new KRegister[1];
        ref = ((KReference)frame.getLocal(1));
        regs[0] = ref;
        frame.setProgramCounter(2);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("nextDouble()D"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("nextDouble()D"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[6] ALOAD(2)
         // *********[7] ILOAD(3)
         // *********[8] ALOAD(1)
         // *********[9] INVOKEVIRTUAL(jnt.scimark2.Random,nextDouble()D)
        c_memman = process.getMemoryManager();
      }
}
