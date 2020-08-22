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
 * [count=3] [56] ALOAD(1) [57] LDC(20->"Downloading LU factorization") [58] INVOKEVIRTUAL(jnt.Bench.Bench,noteStatus(Ljava/lang/String;)V)
 */
public final class execute_022 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R20 = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[56] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[57] LDC(20->"Downloading LU factorization")
         // **REMOVED Substitution** s1_ref = R20;
         // *********[58] INVOKEVIRTUAL(jnt.Bench.Bench,noteStatus(Ljava/lang/String;)V)
        regs = new KRegister[2];
        regs[1] = R20;
        ref = ((KReference)frame.getLocal(1));
        regs[0] = ref;
        frame.setProgramCounter(22);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("noteStatus(Ljava/lang/String;)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("noteStatus(Ljava/lang/String;)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[56] ALOAD(1)
         // *********[57] LDC(20->"Downloading LU factorization")
        R20 = ((KReference)constants[20]);
         // *********[58] INVOKEVIRTUAL(jnt.Bench.Bench,noteStatus(Ljava/lang/String;)V)
        c_memman = process.getMemoryManager();
      }
}
