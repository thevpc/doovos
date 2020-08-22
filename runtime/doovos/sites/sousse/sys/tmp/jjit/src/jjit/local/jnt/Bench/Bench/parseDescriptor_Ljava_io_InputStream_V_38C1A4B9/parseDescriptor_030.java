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
 * [count=5] [81] ALOAD(0) [82] ALOAD(0) [83] ALOAD(2) [84] LDC(15->"units") [85] INVOKEVIRTUAL(jnt.Bench.Bench,parseString(Ljava/io/StreamTokenizer;Ljava/lang/String;)Ljava/lang/String;)
 */
public final class parseDescriptor_030 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R15 = null;
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
         // *********[81] ALOAD(0)
        frame.push(this_ref);
         // *********[82] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[83] ALOAD(2)
         // **REMOVED Substitution** s1 = frame.getLocal(2);
         // *********[84] LDC(15->"units")
         // **REMOVED Substitution** s2_ref = R15;
         // *********[85] INVOKEVIRTUAL(jnt.Bench.Bench,parseString(Ljava/io/StreamTokenizer;Ljava/lang/String;)Ljava/lang/String;)
        regs = new KRegister[3];
        regs[2] = R15;
        regs[1] = frame.getLocal(2);
         // **REMOVED Substitution** ref = this_ref;
        regs[0] = this_ref;
        frame.setProgramCounter(30);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("parseString(Ljava/io/StreamTokenizer;Ljava/lang/String;)Ljava/lang/String;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("parseString(Ljava/io/StreamTokenizer;Ljava/lang/String;)Ljava/lang/String;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[81] ALOAD(0)
         // *********[82] ALOAD(0)
         // *********[83] ALOAD(2)
         // *********[84] LDC(15->"units")
        R15 = ((KReference)constants[15]);
         // *********[85] INVOKEVIRTUAL(jnt.Bench.Bench,parseString(Ljava/io/StreamTokenizer;Ljava/lang/String;)Ljava/lang/String;)
        c_memman = process.getMemoryManager();
      }
}
