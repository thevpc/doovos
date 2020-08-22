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
 * [count=4] [44] ALOAD(2) [45] ILOAD(3) [46] DALOAD [47] INVOKEVIRTUAL(java.lang.StringBuffer,append(D)Ljava/lang/StringBuffer;)
 */
public final class constructBody_021 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_2 2 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=0 : NotCached
         // *********[44] ALOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[45] ILOAD(3)
         // **REMOVED Substitution** s1 = frame.getLocal(3);
         // *********[46] DALOAD
         // **REMOVED Substitution** index = frame.getLocal(3).intValue();
         // **REMOVED Substitution** s0 = new KDouble(c_memman.getDoubleArray(((KReference)frame.getLocal(2)),frame.getLocal(3).intValue()));
         // *********[47] INVOKEVIRTUAL(java.lang.StringBuffer,append(D)Ljava/lang/StringBuffer;)
        regs = new KRegister[2];
        regs[1] = new KDouble(c_memman.getDoubleArray(((KReference)frame.getLocal(2)),frame.getLocal(3).intValue()));
        ref = frame.popRef();
        regs[0] = ref;
        frame.setProgramCounter(21);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("append(D)Ljava/lang/StringBuffer;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("append(D)Ljava/lang/StringBuffer;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[44] ALOAD(2)
         // *********[45] ILOAD(3)
         // *********[46] DALOAD
        c_memman = process.getMemoryManager();
         // *********[47] INVOKEVIRTUAL(java.lang.StringBuffer,append(D)Ljava/lang/StringBuffer;)
      }
}
