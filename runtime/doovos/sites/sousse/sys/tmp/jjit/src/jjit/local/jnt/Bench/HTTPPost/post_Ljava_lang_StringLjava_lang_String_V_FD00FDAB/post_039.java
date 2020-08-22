package jjit.local.jnt.Bench.HTTPPost.post_Ljava_lang_StringLjava_lang_String_V_FD00FDAB;
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
 * jnt.Bench.HTTPPost
 * post(Ljava/lang/String;Ljava/lang/String;)V
 * [count=5] [74] ISTORE(9) [75] ALOAD(7) [76] ILOAD(8) [77] ILOAD(9) [78] INVOKEVIRTUAL(java.lang.String,substring(II)Ljava/lang/String;)
 */
public final class post_039 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_7 7 ; r=1/w=0 : NotCached
         // local_8 8 ; r=1/w=0 : NotCached
         // local_9 9 ; r=1/w=1 : Cached
        int local_9;
         // *********[74] ISTORE(9)
        local_9 = frame.popInt();
         // *********[75] ALOAD(7)
         // **REMOVED Substitution** s0 = frame.getLocal(7);
         // *********[76] ILOAD(8)
         // **REMOVED Substitution** s1 = frame.getLocal(8);
         // *********[77] ILOAD(9)
         // **REMOVED Substitution** s2 = new KInteger(local_9);
         // *********[78] INVOKEVIRTUAL(java.lang.String,substring(II)Ljava/lang/String;)
        regs = new KRegister[3];
        regs[2] = new KInteger(local_9);
        regs[1] = frame.getLocal(8);
        ref = ((KReference)frame.getLocal(7));
        regs[0] = ref;
        frame.setProgramCounter(39);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("substring(II)Ljava/lang/String;"),regs);
        frame.setLocal(9,new KInteger(local_9));
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("substring(II)Ljava/lang/String;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[74] ISTORE(9)
         // *********[75] ALOAD(7)
         // *********[76] ILOAD(8)
         // *********[77] ILOAD(9)
         // *********[78] INVOKEVIRTUAL(java.lang.String,substring(II)Ljava/lang/String;)
        c_memman = process.getMemoryManager();
      }
}
