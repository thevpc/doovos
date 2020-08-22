package jjit.local.jnt.Bench.Formatter.format_DI_Ljava_lang_String_59D5BD5C;
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
 * jnt.Bench.Formatter
 * format(DI)Ljava/lang/String;
 * [count=3] [47] ALOAD(6) [48] ALOAD(6) [49] INVOKEVIRTUAL(java.lang.StringBuffer,length()I)
 */
public final class format_018 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_6 6 ; r=2/w=0 : Cached
        KRegister local_6 = frame.getLocal(6);
         // *********[47] ALOAD(6)
        frame.push(local_6);
         // *********[48] ALOAD(6)
         // **REMOVED Substitution** s0 = local_6;
         // *********[49] INVOKEVIRTUAL(java.lang.StringBuffer,length()I)
        regs = new KRegister[1];
         // **REMOVED Substitution** ref = ((KReference)local_6);
        regs[0] = ((KReference)local_6);
        frame.setProgramCounter(18);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(((KReference)local_6)).getVirtualMethodBySignature("length()I"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(((KReference)local_6)).getVirtualMethodBySignature("length()I"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[47] ALOAD(6)
         // *********[48] ALOAD(6)
         // *********[49] INVOKEVIRTUAL(java.lang.StringBuffer,length()I)
        c_memman = process.getMemoryManager();
      }
}
