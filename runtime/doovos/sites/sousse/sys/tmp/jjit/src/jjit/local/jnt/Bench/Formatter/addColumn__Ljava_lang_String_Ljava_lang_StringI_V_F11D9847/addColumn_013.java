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
 * [count=6] [43] BIPUSH(32) [44] ILOAD(3) [45] ALOAD(0) [46] ILOAD(7) [47] AALOAD [48] INVOKEVIRTUAL(java.lang.String,length()I)
 */
public final class addColumn_013 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger I32 = new KInteger(32);
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
         // local_0 0 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=0 : NotCached
         // local_7 7 ; r=1/w=0 : NotCached
         // *********[43] BIPUSH(32)
        frame.push(I32);
         // *********[44] ILOAD(3)
        frame.push(frame.getLocal(3));
         // *********[45] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[46] ILOAD(7)
         // **REMOVED Substitution** s1 = frame.getLocal(7);
         // *********[47] AALOAD
         // **REMOVED Substitution** index = frame.getLocal(7).intValue();
         // **REMOVED Substitution** ref = ((KReference)frame.getLocal(0));
         // **REMOVED Substitution** s0_ref = c_memman.getReferenceArray(((KReference)frame.getLocal(0)),frame.getLocal(7).intValue());
         // *********[48] INVOKEVIRTUAL(java.lang.String,length()I)
        regs = new KRegister[1];
        ref = c_memman.getReferenceArray(((KReference)frame.getLocal(0)),frame.getLocal(7).intValue());
        regs[0] = ref;
        frame.setProgramCounter(13);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("length()I"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("length()I"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[43] BIPUSH(32)
         // *********[44] ILOAD(3)
         // *********[45] ALOAD(0)
         // *********[46] ILOAD(7)
         // *********[47] AALOAD
        c_memman = process.getMemoryManager();
         // *********[48] INVOKEVIRTUAL(java.lang.String,length()I)
      }
}
