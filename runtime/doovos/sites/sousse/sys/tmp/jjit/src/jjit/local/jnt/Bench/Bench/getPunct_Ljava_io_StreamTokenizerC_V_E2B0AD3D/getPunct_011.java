package jjit.local.jnt.Bench.Bench.getPunct_Ljava_io_StreamTokenizerC_V_E2B0AD3D;
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
 * getPunct(Ljava/io/StreamTokenizer;C)V
 * [count=2] [14] LDC(59->"char") [15] INVOKEVIRTUAL(jnt.Bench.Bench,parseError(Ljava/io/StreamTokenizer;Ljava/lang/String;Ljava/lang/String;)V)
 */
public final class getPunct_011 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R59 = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s0_ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // *********[14] LDC(59->"char")
         // **REMOVED Substitution** s0_ref = R59;
         // *********[15] INVOKEVIRTUAL(jnt.Bench.Bench,parseError(Ljava/io/StreamTokenizer;Ljava/lang/String;Ljava/lang/String;)V)
        regs = new KRegister[4];
        regs[3] = R59;
        regs[2] = frame.pop();
        regs[1] = frame.pop();
        ref = frame.popRef();
        regs[0] = ref;
        frame.setProgramCounter(11);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("parseError(Ljava/io/StreamTokenizer;Ljava/lang/String;Ljava/lang/String;)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("parseError(Ljava/io/StreamTokenizer;Ljava/lang/String;Ljava/lang/String;)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[14] LDC(59->"char")
        R59 = ((KReference)constants[59]);
         // *********[15] INVOKEVIRTUAL(jnt.Bench.Bench,parseError(Ljava/io/StreamTokenizer;Ljava/lang/String;Ljava/lang/String;)V)
        c_memman = process.getMemoryManager();
      }
}
