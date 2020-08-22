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
 * [count=3] [44] ALOAD(3) [45] LDC(43->"target") [46] INVOKEVIRTUAL(java.lang.String,equals(Ljava/lang/Object;)Z)
 */
public final class parseDescriptor_016 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R43 = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_3 3 ; r=1/w=0 : NotCached
         // *********[44] ALOAD(3)
         // **REMOVED Substitution** s0 = frame.getLocal(3);
         // *********[45] LDC(43->"target")
         // **REMOVED Substitution** s1_ref = R43;
         // *********[46] INVOKEVIRTUAL(java.lang.String,equals(Ljava/lang/Object;)Z)
        regs = new KRegister[2];
        regs[1] = R43;
        ref = ((KReference)frame.getLocal(3));
        regs[0] = ref;
        frame.setProgramCounter(16);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("equals(Ljava/lang/Object;)Z"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("equals(Ljava/lang/Object;)Z"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[44] ALOAD(3)
         // *********[45] LDC(43->"target")
        R43 = ((KReference)constants[43]);
         // *********[46] INVOKEVIRTUAL(java.lang.String,equals(Ljava/lang/Object;)Z)
        c_memman = process.getMemoryManager();
      }
}
