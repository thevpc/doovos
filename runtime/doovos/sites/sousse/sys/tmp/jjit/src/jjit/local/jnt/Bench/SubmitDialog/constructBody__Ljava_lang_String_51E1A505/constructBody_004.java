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
 * [count=4] [3] ASTORE(1) [4] ALOAD(1) [5] LDC(88->"START : **************************************** ;
") [6] INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
 */
public final class constructBody_004 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R88 = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_1 1 ; r=1/w=1 : Cached
        KRegister local_1;
         // *********[3] ASTORE(1)
        local_1 = frame.pop();
         // *********[4] ALOAD(1)
         // **REMOVED Substitution** s0 = local_1;
         // *********[5] LDC(88->"START : **************************************** ;
         // ")
         // **REMOVED Substitution** s1_ref = R88;
         // *********[6] INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
        regs = new KRegister[2];
        regs[1] = R88;
         // **REMOVED Substitution** ref = ((KReference)local_1);
        regs[0] = ((KReference)local_1);
        frame.setProgramCounter(4);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(((KReference)local_1)).getVirtualMethodBySignature("append(Ljava/lang/String;)Ljava/lang/StringBuffer;"),regs);
        frame.setLocal(1,local_1);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(((KReference)local_1)).getVirtualMethodBySignature("append(Ljava/lang/String;)Ljava/lang/StringBuffer;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[3] ASTORE(1)
         // *********[4] ALOAD(1)
         // *********[5] LDC(88->"START : **************************************** ;
         // ")
        R88 = ((KReference)constants[88]);
         // *********[6] INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
        c_memman = process.getMemoryManager();
      }
}
