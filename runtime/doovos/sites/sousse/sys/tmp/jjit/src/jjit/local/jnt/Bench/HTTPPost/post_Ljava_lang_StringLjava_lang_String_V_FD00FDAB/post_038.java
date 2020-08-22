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
 * [count=7] [67] ICONST_1(Integer{1}) [68] IADD [69] ISTORE(8) [70] ALOAD(7) [71] BIPUSH(32) [72] ILOAD(8) [73] INVOKEVIRTUAL(java.lang.String,indexOf(II)I)
 */
public final class post_038 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger I32 = new KInteger(32);
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** int index = 0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_7 7 ; r=1/w=0 : NotCached
         // local_8 8 ; r=1/w=1 : Cached
        int local_8;
         // *********[67] ICONST_1(Integer{1})
         // **REMOVED Substitution** s0 = IONE;
         // *********[68] IADD
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s0 = new KInteger((frame.popInt() + 1));
         // *********[69] ISTORE(8)
        local_8 = (frame.popInt() + 1);
         // *********[70] ALOAD(7)
         // **REMOVED Substitution** s0 = frame.getLocal(7);
         // *********[71] BIPUSH(32)
         // **REMOVED Substitution** s1 = I32;
         // *********[72] ILOAD(8)
         // **REMOVED Substitution** s2 = new KInteger(local_8);
         // *********[73] INVOKEVIRTUAL(java.lang.String,indexOf(II)I)
        regs = new KRegister[3];
        regs[2] = new KInteger(local_8);
        regs[1] = I32;
        ref = ((KReference)frame.getLocal(7));
        regs[0] = ref;
        frame.setProgramCounter(38);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("indexOf(II)I"),regs);
        frame.setLocal(8,new KInteger(local_8));
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("indexOf(II)I"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[67] ICONST_1(Integer{1})
         // *********[68] IADD
         // *********[69] ISTORE(8)
         // *********[70] ALOAD(7)
         // *********[71] BIPUSH(32)
         // *********[72] ILOAD(8)
         // *********[73] INVOKEVIRTUAL(java.lang.String,indexOf(II)I)
        c_memman = process.getMemoryManager();
      }
}
