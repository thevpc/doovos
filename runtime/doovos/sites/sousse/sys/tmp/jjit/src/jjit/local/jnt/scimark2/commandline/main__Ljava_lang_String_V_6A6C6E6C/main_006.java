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
 * [count=5] [21] ALOAD(0) [22] ICONST_0(Integer{0}) [23] AALOAD [24] LDC(6->"-help") [25] INVOKEVIRTUAL(java.lang.String,equalsIgnoreCase(Ljava/lang/String;)Z)
 */
public final class main_006 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private static KReference R6 = null;
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
         // *********[21] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[22] ICONST_0(Integer{0})
         // **REMOVED Substitution** s1 = IZERO;
         // *********[23] AALOAD
         // **REMOVED Substitution** index = 0;
         // **REMOVED Substitution** ref = ((KReference)frame.getLocal(0));
         // **REMOVED Substitution** s0_ref = c_memman.getReferenceArray(((KReference)frame.getLocal(0)),0);
         // *********[24] LDC(6->"-help")
         // **REMOVED Substitution** s1_ref = R6;
         // *********[25] INVOKEVIRTUAL(java.lang.String,equalsIgnoreCase(Ljava/lang/String;)Z)
        regs = new KRegister[2];
        regs[1] = R6;
        ref = c_memman.getReferenceArray(((KReference)frame.getLocal(0)),0);
        regs[0] = ref;
        frame.setProgramCounter(6);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("equalsIgnoreCase(Ljava/lang/String;)Z"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("equalsIgnoreCase(Ljava/lang/String;)Z"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[21] ALOAD(0)
         // *********[22] ICONST_0(Integer{0})
         // *********[23] AALOAD
        c_memman = process.getMemoryManager();
         // *********[24] LDC(6->"-help")
        R6 = ((KReference)constants[6]);
         // *********[25] INVOKEVIRTUAL(java.lang.String,equalsIgnoreCase(Ljava/lang/String;)Z)
      }
}
