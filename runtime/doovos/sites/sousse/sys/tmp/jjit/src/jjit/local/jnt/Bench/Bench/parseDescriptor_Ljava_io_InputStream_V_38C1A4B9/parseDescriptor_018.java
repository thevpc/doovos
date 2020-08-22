package jjit.local.jnt.Bench.Bench.parseDescriptor_Ljava_io_InputStream_V_38C1A4B9;
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
 * parseDescriptor(Ljava/io/InputStream;)V
 * [count=5] [48] ALOAD(0) [49] ALOAD(0) [50] ALOAD(2) [51] LDC(43->"target") [52] INVOKEVIRTUAL(jnt.Bench.Bench,parseString(Ljava/io/StreamTokenizer;Ljava/lang/String;)Ljava/lang/String;)
 */
public final class parseDescriptor_018 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R43 = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s2_ref;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[48] ALOAD(0)
        frame.push(this_ref);
         // *********[49] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[50] ALOAD(2)
         // **REMOVED Substitution** s1 = frame.getLocal(2);
         // *********[51] LDC(43->"target")
         // **REMOVED Substitution** s2_ref = R43;
         // *********[52] INVOKEVIRTUAL(jnt.Bench.Bench,parseString(Ljava/io/StreamTokenizer;Ljava/lang/String;)Ljava/lang/String;)
        regs = new KRegister[3];
        regs[2] = R43;
        regs[1] = frame.getLocal(2);
         // **REMOVED Substitution** ref = this_ref;
        regs[0] = this_ref;
        frame.setProgramCounter(18);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("parseString(Ljava/io/StreamTokenizer;Ljava/lang/String;)Ljava/lang/String;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("parseString(Ljava/io/StreamTokenizer;Ljava/lang/String;)Ljava/lang/String;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[48] ALOAD(0)
         // *********[49] ALOAD(0)
         // *********[50] ALOAD(2)
         // *********[51] LDC(43->"target")
        R43 = ((KReference)constants[43]);
         // *********[52] INVOKEVIRTUAL(jnt.Bench.Bench,parseString(Ljava/io/StreamTokenizer;Ljava/lang/String;)Ljava/lang/String;)
        c_memman = process.getMemoryManager();
      }
}
