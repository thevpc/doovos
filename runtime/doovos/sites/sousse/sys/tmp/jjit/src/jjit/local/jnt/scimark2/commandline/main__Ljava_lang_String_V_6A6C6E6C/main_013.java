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
 * [count=7] [31] ICONST_0(Integer{0}) [32] ISTORE(8) [33] ALOAD(0) [34] ILOAD(8) [35] AALOAD [36] LDC(13->"-large") [37] INVOKEVIRTUAL(java.lang.String,equalsIgnoreCase(Ljava/lang/String;)Z)
 */
public final class main_013 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private static KReference R13 = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
        KReference ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_8 8 ; r=1/w=1 : Cached
         // **REMOVED Unused Var** int local_8;
         // *********[31] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[32] ISTORE(8)
         // **REMOVED Substitution** local_8 = 0;
         // *********[33] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[34] ILOAD(8)
         // **REMOVED Substitution** s1 = KInteger.ZERO;
         // *********[35] AALOAD
         // **REMOVED Substitution** index = 0;
         // **REMOVED Substitution** ref = ((KReference)frame.getLocal(0));
         // **REMOVED Substitution** s0_ref = c_memman.getReferenceArray(((KReference)frame.getLocal(0)),0);
         // *********[36] LDC(13->"-large")
         // **REMOVED Substitution** s1_ref = R13;
         // *********[37] INVOKEVIRTUAL(java.lang.String,equalsIgnoreCase(Ljava/lang/String;)Z)
        regs = new KRegister[2];
        regs[1] = R13;
        ref = c_memman.getReferenceArray(((KReference)frame.getLocal(0)),0);
        regs[0] = ref;
        frame.setProgramCounter(13);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("equalsIgnoreCase(Ljava/lang/String;)Z"),regs);
        frame.setLocal(8,KInteger.ZERO);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("equalsIgnoreCase(Ljava/lang/String;)Z"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[31] ICONST_0(Integer{0})
         // *********[32] ISTORE(8)
         // *********[33] ALOAD(0)
         // *********[34] ILOAD(8)
         // *********[35] AALOAD
        c_memman = process.getMemoryManager();
         // *********[36] LDC(13->"-large")
        R13 = ((KReference)constants[13]);
         // *********[37] INVOKEVIRTUAL(java.lang.String,equalsIgnoreCase(Ljava/lang/String;)Z)
      }
}
