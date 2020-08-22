package jjit.local.jnt.Bench.Bench.printMeasurements_Ljava_io_PrintStream_V_CC1E980A;
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
 * jnt.Bench.Bench
 * printMeasurements(Ljava/io/PrintStream;)V
 * [count=5] [42] ALOAD(1) [43] ALOAD(2) [44] ILOAD(5) [45] AALOAD [46] INVOKEVIRTUAL(java.io.PrintStream,println(Ljava/lang/String;)V)
 */
public final class printMeasurements_014 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** int index = 0;
        KReference ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_1 1 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // local_5 5 ; r=1/w=0 : NotCached
         // *********[42] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[43] ALOAD(2)
         // **REMOVED Substitution** s1 = frame.getLocal(2);
         // *********[44] ILOAD(5)
         // **REMOVED Substitution** s2 = frame.getLocal(5);
         // *********[45] AALOAD
         // **REMOVED Substitution** index = frame.getLocal(5).intValue();
         // **REMOVED Substitution** ref = ((KReference)frame.getLocal(2));
         // **REMOVED Substitution** s1_ref = c_memman.getReferenceArray(((KReference)frame.getLocal(2)),frame.getLocal(5).intValue());
         // *********[46] INVOKEVIRTUAL(java.io.PrintStream,println(Ljava/lang/String;)V)
        regs = new KRegister[2];
        regs[1] = c_memman.getReferenceArray(((KReference)frame.getLocal(2)),frame.getLocal(5).intValue());
        ref = ((KReference)frame.getLocal(1));
        regs[0] = ref;
        frame.setProgramCounter(14);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("println(Ljava/lang/String;)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("println(Ljava/lang/String;)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[42] ALOAD(1)
         // *********[43] ALOAD(2)
         // *********[44] ILOAD(5)
         // *********[45] AALOAD
        c_memman = process.getMemoryManager();
         // *********[46] INVOKEVIRTUAL(java.io.PrintStream,println(Ljava/lang/String;)V)
      }
}
