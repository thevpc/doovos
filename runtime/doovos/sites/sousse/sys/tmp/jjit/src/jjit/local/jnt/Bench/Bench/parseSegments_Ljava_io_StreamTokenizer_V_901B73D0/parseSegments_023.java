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
 * [count=4] [70] ALOAD(0) [71] ALOAD(1) [72] LDC(62->"shortname") [73] INVOKEVIRTUAL(jnt.Bench.Bench,parseString(Ljava/io/StreamTokenizer;Ljava/lang/String;)Ljava/lang/String;)
 */
public final class parseSegments_023 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R62 = null;
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
         // *********[70] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[71] ALOAD(1)
         // **REMOVED Substitution** s1 = frame.getLocal(1);
         // *********[72] LDC(62->"shortname")
         // **REMOVED Substitution** s2_ref = R62;
         // *********[73] INVOKEVIRTUAL(jnt.Bench.Bench,parseString(Ljava/io/StreamTokenizer;Ljava/lang/String;)Ljava/lang/String;)
        regs = new KRegister[3];
        regs[2] = R62;
        regs[1] = frame.getLocal(1);
        ref = ((KReference)frame.getLocal(0));
        regs[0] = ref;
        frame.setProgramCounter(23);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("parseString(Ljava/io/StreamTokenizer;Ljava/lang/String;)Ljava/lang/String;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("parseString(Ljava/io/StreamTokenizer;Ljava/lang/String;)Ljava/lang/String;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[70] ALOAD(0)
         // *********[71] ALOAD(1)
         // *********[72] LDC(62->"shortname")
        R62 = ((KReference)constants[62]);
         // *********[73] INVOKEVIRTUAL(jnt.Bench.Bench,parseString(Ljava/io/StreamTokenizer;Ljava/lang/String;)Ljava/lang/String;)
        c_memman = process.getMemoryManager();
      }
}
