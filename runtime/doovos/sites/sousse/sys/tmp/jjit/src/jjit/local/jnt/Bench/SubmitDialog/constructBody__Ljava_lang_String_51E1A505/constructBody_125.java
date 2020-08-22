package jjit.local.jnt.Bench.SubmitDialog.constructBody__Ljava_lang_String_51E1A505;
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
 * jnt.Bench.SubmitDialog
 * constructBody()Ljava/lang/String;
 * [count=4] [263] POP [264] ALOAD(1) [265] LDC(110->"END : **************************************** ;
") [266] INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
 */
public final class constructBody_125 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R110 = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[263] POP
        frame.pop();
         // *********[264] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[265] LDC(110->"END : **************************************** ;
         // ")
         // **REMOVED Substitution** s1_ref = R110;
         // *********[266] INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
        regs = new KRegister[2];
        regs[1] = R110;
        ref = ((KReference)frame.getLocal(1));
        regs[0] = ref;
        frame.setProgramCounter(125);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("append(Ljava/lang/String;)Ljava/lang/StringBuffer;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("append(Ljava/lang/String;)Ljava/lang/StringBuffer;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[263] POP
         // *********[264] ALOAD(1)
         // *********[265] LDC(110->"END : **************************************** ;
         // ")
        R110 = ((KReference)constants[110]);
         // *********[266] INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
        c_memman = process.getMemoryManager();
      }
}
