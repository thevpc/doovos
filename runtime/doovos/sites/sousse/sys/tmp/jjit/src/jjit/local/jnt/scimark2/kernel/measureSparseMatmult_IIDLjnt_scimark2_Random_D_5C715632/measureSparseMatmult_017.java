package jjit.local.jnt.scimark2.kernel.measureSparseMatmult_IIDLjnt_scimark2_Random_D_5C715632;
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
 * measureSparseMatmult(IIDLjnt/scimark2/Random;)D
 * [count=2] [90] ALOAD(13) [91] INVOKEVIRTUAL(jnt.scimark2.Stopwatch,stop()D)
 */
public final class measureSparseMatmult_017 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_13 13 ; r=1/w=0 : NotCached
         // *********[90] ALOAD(13)
         // **REMOVED Substitution** s0 = frame.getLocal(13);
         // *********[91] INVOKEVIRTUAL(jnt.scimark2.Stopwatch,stop()D)
        regs = new KRegister[1];
        ref = ((KReference)frame.getLocal(13));
        regs[0] = ref;
        frame.setProgramCounter(17);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("stop()D"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("stop()D"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[90] ALOAD(13)
         // *********[91] INVOKEVIRTUAL(jnt.scimark2.Stopwatch,stop()D)
        c_memman = process.getMemoryManager();
      }
}
