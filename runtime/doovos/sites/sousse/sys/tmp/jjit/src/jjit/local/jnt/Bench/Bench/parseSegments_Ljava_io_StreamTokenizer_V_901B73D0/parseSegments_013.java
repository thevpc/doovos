package jjit.local.jnt.Bench.Bench.parseSegments_Ljava_io_StreamTokenizer_V_901B73D0;
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
 * parseSegments(Ljava/io/StreamTokenizer;)V
 * [count=3] [45] ALOAD(8) [46] LDC(15->"units") [47] INVOKEVIRTUAL(java.lang.String,equals(Ljava/lang/Object;)Z)
 */
public final class parseSegments_013 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R15 = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_8 8 ; r=1/w=0 : NotCached
         // *********[45] ALOAD(8)
         // **REMOVED Substitution** s0 = frame.getLocal(8);
         // *********[46] LDC(15->"units")
         // **REMOVED Substitution** s1_ref = R15;
         // *********[47] INVOKEVIRTUAL(java.lang.String,equals(Ljava/lang/Object;)Z)
        regs = new KRegister[2];
        regs[1] = R15;
        ref = ((KReference)frame.getLocal(8));
        regs[0] = ref;
        frame.setProgramCounter(13);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("equals(Ljava/lang/Object;)Z"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("equals(Ljava/lang/Object;)Z"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[45] ALOAD(8)
         // *********[46] LDC(15->"units")
        R15 = ((KReference)constants[15]);
         // *********[47] INVOKEVIRTUAL(java.lang.String,equals(Ljava/lang/Object;)Z)
        c_memman = process.getMemoryManager();
      }
}
