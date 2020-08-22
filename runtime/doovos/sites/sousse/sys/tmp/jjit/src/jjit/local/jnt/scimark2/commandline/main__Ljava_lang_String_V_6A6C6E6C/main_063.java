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
 * [count=4] [189] ALOAD(8) [190] ICONST_2(Integer{2}) [191] DALOAD [192] INVOKEVIRTUAL(java.lang.StringBuffer,append(D)Ljava/lang/StringBuffer;)
 */
public final class main_063 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_8 8 ; r=1/w=0 : NotCached
         // *********[189] ALOAD(8)
         // **REMOVED Substitution** s0 = frame.getLocal(8);
         // *********[190] ICONST_2(Integer{2})
         // **REMOVED Substitution** s1 = ITWO;
         // *********[191] DALOAD
         // **REMOVED Substitution** index = 2;
         // **REMOVED Substitution** s0 = new KDouble(c_memman.getDoubleArray(((KReference)frame.getLocal(8)),2));
         // *********[192] INVOKEVIRTUAL(java.lang.StringBuffer,append(D)Ljava/lang/StringBuffer;)
        regs = new KRegister[2];
        regs[1] = new KDouble(c_memman.getDoubleArray(((KReference)frame.getLocal(8)),2));
        ref = frame.popRef();
        regs[0] = ref;
        frame.setProgramCounter(63);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("append(D)Ljava/lang/StringBuffer;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("append(D)Ljava/lang/StringBuffer;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[189] ALOAD(8)
         // *********[190] ICONST_2(Integer{2})
         // *********[191] DALOAD
        c_memman = process.getMemoryManager();
         // *********[192] INVOKEVIRTUAL(java.lang.StringBuffer,append(D)Ljava/lang/StringBuffer;)
      }
}
