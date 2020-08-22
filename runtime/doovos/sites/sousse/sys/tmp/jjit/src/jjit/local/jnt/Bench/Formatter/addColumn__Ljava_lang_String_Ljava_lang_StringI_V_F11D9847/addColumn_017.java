package jjit.local.jnt.Bench.Formatter.addColumn__Ljava_lang_String_Ljava_lang_StringI_V_F11D9847;
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
 * jnt.Bench.Formatter
 * addColumn([Ljava/lang/String;[Ljava/lang/String;I)V
 * [count=4] [63] ALOAD(1) [64] ILOAD(7) [65] AALOAD [66] INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
 */
public final class addColumn_017 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
        KReference ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_1 1 ; r=1/w=0 : NotCached
         // local_7 7 ; r=1/w=0 : NotCached
         // *********[63] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[64] ILOAD(7)
         // **REMOVED Substitution** s1 = frame.getLocal(7);
         // *********[65] AALOAD
         // **REMOVED Substitution** index = frame.getLocal(7).intValue();
         // **REMOVED Substitution** ref = ((KReference)frame.getLocal(1));
         // **REMOVED Substitution** s0_ref = c_memman.getReferenceArray(((KReference)frame.getLocal(1)),frame.getLocal(7).intValue());
         // *********[66] INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
        regs = new KRegister[2];
        regs[1] = c_memman.getReferenceArray(((KReference)frame.getLocal(1)),frame.getLocal(7).intValue());
        ref = frame.popRef();
        regs[0] = ref;
        frame.setProgramCounter(17);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("append(Ljava/lang/String;)Ljava/lang/StringBuffer;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("append(Ljava/lang/String;)Ljava/lang/StringBuffer;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[63] ALOAD(1)
         // *********[64] ILOAD(7)
         // *********[65] AALOAD
        c_memman = process.getMemoryManager();
         // *********[66] INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
      }
}
