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
 * [count=2] [235] LDC(44->"x") [236] INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
 */
public final class main_083 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R44 = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s0_ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // *********[235] LDC(44->"x")
         // **REMOVED Substitution** s0_ref = R44;
         // *********[236] INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
        regs = new KRegister[2];
        regs[1] = R44;
        ref = frame.popRef();
        regs[0] = ref;
        frame.setProgramCounter(83);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("append(Ljava/lang/String;)Ljava/lang/StringBuffer;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("append(Ljava/lang/String;)Ljava/lang/StringBuffer;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[235] LDC(44->"x")
        R44 = ((KReference)constants[44]);
         // *********[236] INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
        c_memman = process.getMemoryManager();
      }
}
