package jjit.local.jnt.scimark2.kernel.measureFFT_IDLjnt_scimark2_Random_D_D04C475C;
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
 * measureFFT(IDLjnt/scimark2/Random;)D
 * [count=3] [33] POP2Type2 [34] ALOAD(8) [35] INVOKEVIRTUAL(jnt.scimark2.Stopwatch,read()D)
 */
public final class measureFFT_014 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_8 8 ; r=1/w=0 : NotCached
         // *********[33] POP2Type2
        frame.pop();
         // *********[34] ALOAD(8)
         // **REMOVED Substitution** s0 = frame.getLocal(8);
         // *********[35] INVOKEVIRTUAL(jnt.scimark2.Stopwatch,read()D)
        regs = new KRegister[1];
        ref = ((KReference)frame.getLocal(8));
        regs[0] = ref;
        frame.setProgramCounter(14);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("read()D"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("read()D"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[33] POP2Type2
         // *********[34] ALOAD(8)
         // *********[35] INVOKEVIRTUAL(jnt.scimark2.Stopwatch,read()D)
        c_memman = process.getMemoryManager();
      }
}
