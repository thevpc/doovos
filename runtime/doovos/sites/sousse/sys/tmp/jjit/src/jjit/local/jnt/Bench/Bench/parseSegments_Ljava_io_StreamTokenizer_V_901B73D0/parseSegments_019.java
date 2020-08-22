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
 * [count=4] [59] ALOAD(0) [60] ALOAD(1) [61] LDC(16->"decimals") [62] INVOKEVIRTUAL(jnt.Bench.Bench,parseNumber(Ljava/io/StreamTokenizer;Ljava/lang/String;)D)
 */
public final class parseSegments_019 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R16 = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s2_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[59] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[60] ALOAD(1)
         // **REMOVED Substitution** s1 = frame.getLocal(1);
         // *********[61] LDC(16->"decimals")
         // **REMOVED Substitution** s2_ref = R16;
         // *********[62] INVOKEVIRTUAL(jnt.Bench.Bench,parseNumber(Ljava/io/StreamTokenizer;Ljava/lang/String;)D)
        regs = new KRegister[3];
        regs[2] = R16;
        regs[1] = frame.getLocal(1);
        ref = ((KReference)frame.getLocal(0));
        regs[0] = ref;
        frame.setProgramCounter(19);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("parseNumber(Ljava/io/StreamTokenizer;Ljava/lang/String;)D"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("parseNumber(Ljava/io/StreamTokenizer;Ljava/lang/String;)D"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[59] ALOAD(0)
         // *********[60] ALOAD(1)
         // *********[61] LDC(16->"decimals")
        R16 = ((KReference)constants[16]);
         // *********[62] INVOKEVIRTUAL(jnt.Bench.Bench,parseNumber(Ljava/io/StreamTokenizer;Ljava/lang/String;)D)
        c_memman = process.getMemoryManager();
      }
}
