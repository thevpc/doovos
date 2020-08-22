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
 * [count=5] [84] ALOAD(0) [85] ALOAD(1) [86] LDC(63->")") [87] LDC(59->"char") [88] INVOKEVIRTUAL(jnt.Bench.Bench,parseError(Ljava/io/StreamTokenizer;Ljava/lang/String;Ljava/lang/String;)V)
 */
public final class parseSegments_028 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R63 = null;
      private static KReference R59 = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s2_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s3_ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[84] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[85] ALOAD(1)
         // **REMOVED Substitution** s1 = frame.getLocal(1);
         // *********[86] LDC(63->")")
         // **REMOVED Substitution** s2_ref = R63;
         // *********[87] LDC(59->"char")
         // **REMOVED Substitution** s3_ref = R59;
         // *********[88] INVOKEVIRTUAL(jnt.Bench.Bench,parseError(Ljava/io/StreamTokenizer;Ljava/lang/String;Ljava/lang/String;)V)
        regs = new KRegister[4];
        regs[3] = R59;
        regs[2] = R63;
        regs[1] = frame.getLocal(1);
        ref = ((KReference)frame.getLocal(0));
        regs[0] = ref;
        frame.setProgramCounter(28);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("parseError(Ljava/io/StreamTokenizer;Ljava/lang/String;Ljava/lang/String;)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("parseError(Ljava/io/StreamTokenizer;Ljava/lang/String;Ljava/lang/String;)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[84] ALOAD(0)
         // *********[85] ALOAD(1)
         // *********[86] LDC(63->")")
        R63 = ((KReference)constants[63]);
         // *********[87] LDC(59->"char")
        R59 = ((KReference)constants[59]);
         // *********[88] INVOKEVIRTUAL(jnt.Bench.Bench,parseError(Ljava/io/StreamTokenizer;Ljava/lang/String;Ljava/lang/String;)V)
        c_memman = process.getMemoryManager();
      }
}
