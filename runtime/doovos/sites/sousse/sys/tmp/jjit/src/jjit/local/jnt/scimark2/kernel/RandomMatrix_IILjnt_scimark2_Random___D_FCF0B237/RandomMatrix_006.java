package jjit.local.jnt.scimark2.kernel.RandomMatrix_IILjnt_scimark2_Random___D_FCF0B237;
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
 * RandomMatrix(IILjnt/scimark2/Random;)[[D
 * [count=6] [10] ALOAD(3) [11] ILOAD(4) [12] AALOAD [13] ILOAD(5) [14] ALOAD(2) [15] INVOKEVIRTUAL(jnt.scimark2.Random,nextDouble()D)
 */
public final class RandomMatrix_006 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
        KReference ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_2 2 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=0 : NotCached
         // local_4 4 ; r=1/w=0 : NotCached
         // local_5 5 ; r=1/w=0 : NotCached
         // *********[10] ALOAD(3)
         // **REMOVED Substitution** s0 = frame.getLocal(3);
         // *********[11] ILOAD(4)
         // **REMOVED Substitution** s1 = frame.getLocal(4);
         // *********[12] AALOAD
         // **REMOVED Substitution** index = frame.getLocal(4).intValue();
         // **REMOVED Substitution** ref = ((KReference)frame.getLocal(3));
        frame.push(c_memman.getReferenceArray(((KReference)frame.getLocal(3)),frame.getLocal(4).intValue()));
         // *********[13] ILOAD(5)
        frame.push(frame.getLocal(5));
         // *********[14] ALOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[15] INVOKEVIRTUAL(jnt.scimark2.Random,nextDouble()D)
        regs = new KRegister[1];
        ref = ((KReference)frame.getLocal(2));
        regs[0] = ref;
        frame.setProgramCounter(6);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("nextDouble()D"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("nextDouble()D"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[10] ALOAD(3)
         // *********[11] ILOAD(4)
         // *********[12] AALOAD
        c_memman = process.getMemoryManager();
         // *********[13] ILOAD(5)
         // *********[14] ALOAD(2)
         // *********[15] INVOKEVIRTUAL(jnt.scimark2.Random,nextDouble()D)
      }
}
