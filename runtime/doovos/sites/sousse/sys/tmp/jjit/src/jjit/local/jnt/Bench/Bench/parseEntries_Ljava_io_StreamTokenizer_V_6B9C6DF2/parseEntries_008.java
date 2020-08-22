package jjit.local.jnt.Bench.Bench.parseEntries_Ljava_io_StreamTokenizer_V_6B9C6DF2;
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
 * parseEntries(Ljava/io/StreamTokenizer;)V
 * [count=6] [30] ALOAD(5) [31] ILOAD(6) [32] ALOAD(0) [33] ALOAD(1) [34] LDC(71->"Segment Value") [35] INVOKEVIRTUAL(jnt.Bench.Bench,parseNumber(Ljava/io/StreamTokenizer;Ljava/lang/String;)D)
 */
public final class parseEntries_008 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R71 = null;
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
         // local_5 5 ; r=1/w=0 : NotCached
         // local_6 6 ; r=1/w=0 : NotCached
         // *********[30] ALOAD(5)
        frame.push(frame.getLocal(5));
         // *********[31] ILOAD(6)
        frame.push(frame.getLocal(6));
         // *********[32] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[33] ALOAD(1)
         // **REMOVED Substitution** s1 = frame.getLocal(1);
         // *********[34] LDC(71->"Segment Value")
         // **REMOVED Substitution** s2_ref = R71;
         // *********[35] INVOKEVIRTUAL(jnt.Bench.Bench,parseNumber(Ljava/io/StreamTokenizer;Ljava/lang/String;)D)
        regs = new KRegister[3];
        regs[2] = R71;
        regs[1] = frame.getLocal(1);
        ref = ((KReference)frame.getLocal(0));
        regs[0] = ref;
        frame.setProgramCounter(8);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("parseNumber(Ljava/io/StreamTokenizer;Ljava/lang/String;)D"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("parseNumber(Ljava/io/StreamTokenizer;Ljava/lang/String;)D"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[30] ALOAD(5)
         // *********[31] ILOAD(6)
         // *********[32] ALOAD(0)
         // *********[33] ALOAD(1)
         // *********[34] LDC(71->"Segment Value")
        R71 = ((KReference)constants[71]);
         // *********[35] INVOKEVIRTUAL(jnt.Bench.Bench,parseNumber(Ljava/io/StreamTokenizer;Ljava/lang/String;)D)
        c_memman = process.getMemoryManager();
      }
}
