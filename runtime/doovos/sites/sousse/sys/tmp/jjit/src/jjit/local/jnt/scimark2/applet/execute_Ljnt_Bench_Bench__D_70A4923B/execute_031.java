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
 * [count=4] [95] DASTORE [96] ALOAD(1) [97] LDC(25->"benchmarking Sparse Matrix Multplication") [98] INVOKEVIRTUAL(jnt.Bench.Bench,noteStatus(Ljava/lang/String;)V)
 */
public final class execute_031 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private static KReference R25 = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
        int index = 0;
        double m_d;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[95] DASTORE
        m_d = frame.popDouble();
        index = frame.popInt();
        c_memman.setDoubleArray(frame.popRef(),index,m_d);
         // *********[96] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[97] LDC(25->"benchmarking Sparse Matrix Multplication")
         // **REMOVED Substitution** s1_ref = R25;
         // *********[98] INVOKEVIRTUAL(jnt.Bench.Bench,noteStatus(Ljava/lang/String;)V)
        regs = new KRegister[2];
        regs[1] = R25;
        ref = ((KReference)frame.getLocal(1));
        regs[0] = ref;
        frame.setProgramCounter(31);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("noteStatus(Ljava/lang/String;)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("noteStatus(Ljava/lang/String;)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[95] DASTORE
        c_memman = process.getMemoryManager();
         // *********[96] ALOAD(1)
         // *********[97] LDC(25->"benchmarking Sparse Matrix Multplication")
        R25 = ((KReference)constants[25]);
         // *********[98] INVOKEVIRTUAL(jnt.Bench.Bench,noteStatus(Ljava/lang/String;)V)
      }
}
