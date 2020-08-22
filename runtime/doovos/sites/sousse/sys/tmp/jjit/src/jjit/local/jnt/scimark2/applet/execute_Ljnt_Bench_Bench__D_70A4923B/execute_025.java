package jjit.local.jnt.scimark2.applet.execute_Ljnt_Bench_Bench__D_70A4923B;
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
 * jnt.scimark2.applet
 * execute(Ljnt/Bench/Bench;)[D
 * [count=3] [67] ALOAD(1) [68] LDC(22->"benchmarking FFT") [69] INVOKEVIRTUAL(jnt.Bench.Bench,noteStatus(Ljava/lang/String;)V)
 */
public final class execute_025 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R22 = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[67] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[68] LDC(22->"benchmarking FFT")
         // **REMOVED Substitution** s1_ref = R22;
         // *********[69] INVOKEVIRTUAL(jnt.Bench.Bench,noteStatus(Ljava/lang/String;)V)
        regs = new KRegister[2];
        regs[1] = R22;
        ref = ((KReference)frame.getLocal(1));
        regs[0] = ref;
        frame.setProgramCounter(25);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("noteStatus(Ljava/lang/String;)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("noteStatus(Ljava/lang/String;)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[67] ALOAD(1)
         // *********[68] LDC(22->"benchmarking FFT")
        R22 = ((KReference)constants[22]);
         // *********[69] INVOKEVIRTUAL(jnt.Bench.Bench,noteStatus(Ljava/lang/String;)V)
        c_memman = process.getMemoryManager();
      }
}
