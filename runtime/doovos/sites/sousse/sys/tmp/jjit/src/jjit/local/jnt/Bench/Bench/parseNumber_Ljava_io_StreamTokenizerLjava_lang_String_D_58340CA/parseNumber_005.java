package jjit.local.jnt.Bench.Bench.parseNumber_Ljava_io_StreamTokenizerLjava_lang_String_D_58340CA;
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
 * parseNumber(Ljava/io/StreamTokenizer;Ljava/lang/String;)D
 * [count=5] [4] ALOAD(0) [5] ALOAD(1) [6] ALOAD(2) [7] LDC(79->"number") [8] INVOKEVIRTUAL(jnt.Bench.Bench,parseError(Ljava/io/StreamTokenizer;Ljava/lang/String;Ljava/lang/String;)V)
 */
public final class parseNumber_005 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R79 = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s3_ref;
         // **REMOVED Unused Var** KRegister s2;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[4] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[5] ALOAD(1)
         // **REMOVED Substitution** s1 = frame.getLocal(1);
         // *********[6] ALOAD(2)
         // **REMOVED Substitution** s2 = frame.getLocal(2);
         // *********[7] LDC(79->"number")
         // **REMOVED Substitution** s3_ref = R79;
         // *********[8] INVOKEVIRTUAL(jnt.Bench.Bench,parseError(Ljava/io/StreamTokenizer;Ljava/lang/String;Ljava/lang/String;)V)
        regs = new KRegister[4];
        regs[3] = R79;
        regs[2] = frame.getLocal(2);
        regs[1] = frame.getLocal(1);
        ref = ((KReference)frame.getLocal(0));
        regs[0] = ref;
        frame.setProgramCounter(5);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("parseError(Ljava/io/StreamTokenizer;Ljava/lang/String;Ljava/lang/String;)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("parseError(Ljava/io/StreamTokenizer;Ljava/lang/String;Ljava/lang/String;)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[4] ALOAD(0)
         // *********[5] ALOAD(1)
         // *********[6] ALOAD(2)
         // *********[7] LDC(79->"number")
        R79 = ((KReference)constants[79]);
         // *********[8] INVOKEVIRTUAL(jnt.Bench.Bench,parseError(Ljava/io/StreamTokenizer;Ljava/lang/String;Ljava/lang/String;)V)
        c_memman = process.getMemoryManager();
      }
}
