package jjit.local.jnt.scimark2.commandline.main__Ljava_lang_String_V_6A6C6E6C;
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
 * jnt.scimark2.commandline
 * main([Ljava/lang/String;)V
 * [count=2] [237] ILOAD(7) [238] INVOKEVIRTUAL(java.lang.StringBuffer,append(I)Ljava/lang/StringBuffer;)
 */
public final class main_084 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_7 7 ; r=1/w=0 : NotCached
         // *********[237] ILOAD(7)
         // **REMOVED Substitution** s0 = frame.getLocal(7);
         // *********[238] INVOKEVIRTUAL(java.lang.StringBuffer,append(I)Ljava/lang/StringBuffer;)
        regs = new KRegister[2];
        regs[1] = frame.getLocal(7);
        ref = frame.popRef();
        regs[0] = ref;
        frame.setProgramCounter(84);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("append(I)Ljava/lang/StringBuffer;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("append(I)Ljava/lang/StringBuffer;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[237] ILOAD(7)
         // *********[238] INVOKEVIRTUAL(java.lang.StringBuffer,append(I)Ljava/lang/StringBuffer;)
        c_memman = process.getMemoryManager();
      }
}
