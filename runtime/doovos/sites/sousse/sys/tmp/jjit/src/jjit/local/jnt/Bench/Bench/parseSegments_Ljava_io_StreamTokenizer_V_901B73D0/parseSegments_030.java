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
 * [count=5] [90] ALOAD(0) [91] ALOAD(1) [92] LDC(64->"( or segment name") [93] LDC(57->"") [94] INVOKEVIRTUAL(jnt.Bench.Bench,parseError(Ljava/io/StreamTokenizer;Ljava/lang/String;Ljava/lang/String;)V)
 */
public final class parseSegments_030 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R64 = null;
      private static KReference R57 = null;
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
         // *********[90] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[91] ALOAD(1)
         // **REMOVED Substitution** s1 = frame.getLocal(1);
         // *********[92] LDC(64->"( or segment name")
         // **REMOVED Substitution** s2_ref = R64;
         // *********[93] LDC(57->"")
         // **REMOVED Substitution** s3_ref = R57;
         // *********[94] INVOKEVIRTUAL(jnt.Bench.Bench,parseError(Ljava/io/StreamTokenizer;Ljava/lang/String;Ljava/lang/String;)V)
        regs = new KRegister[4];
        regs[3] = R57;
        regs[2] = R64;
        regs[1] = frame.getLocal(1);
        ref = ((KReference)frame.getLocal(0));
        regs[0] = ref;
        frame.setProgramCounter(30);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("parseError(Ljava/io/StreamTokenizer;Ljava/lang/String;Ljava/lang/String;)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("parseError(Ljava/io/StreamTokenizer;Ljava/lang/String;Ljava/lang/String;)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[90] ALOAD(0)
         // *********[91] ALOAD(1)
         // *********[92] LDC(64->"( or segment name")
        R64 = ((KReference)constants[64]);
         // *********[93] LDC(57->"")
        R57 = ((KReference)constants[57]);
         // *********[94] INVOKEVIRTUAL(jnt.Bench.Bench,parseError(Ljava/io/StreamTokenizer;Ljava/lang/String;Ljava/lang/String;)V)
        c_memman = process.getMemoryManager();
      }
}
