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
 * [count=8] [49] ISUB [50] ICONST_1(Integer{1}) [51] IADD [52] ILOAD(4) [53] ALOAD(1) [54] ILOAD(7) [55] AALOAD [56] INVOKEVIRTUAL(java.lang.String,length()I)
 */
public final class addColumn_014 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
        int index = 0;
        KReference ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_1 1 ; r=1/w=0 : NotCached
         // local_4 4 ; r=1/w=0 : NotCached
         // local_7 7 ; r=1/w=0 : NotCached
         // *********[49] ISUB
        index = frame.popInt();
         // **REMOVED Substitution** s0 = new KInteger((frame.popInt() - index));
         // *********[50] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[51] IADD
         // **REMOVED Substitution** index = 1;
        frame.push(new KInteger(((frame.popInt() - index) + 1)));
         // *********[52] ILOAD(4)
        frame.push(frame.getLocal(4));
         // *********[53] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[54] ILOAD(7)
         // **REMOVED Substitution** s1 = frame.getLocal(7);
         // *********[55] AALOAD
         // **REMOVED Substitution** index = frame.getLocal(7).intValue();
         // **REMOVED Substitution** ref = ((KReference)frame.getLocal(1));
         // **REMOVED Substitution** s0_ref = c_memman.getReferenceArray(((KReference)frame.getLocal(1)),frame.getLocal(7).intValue());
         // *********[56] INVOKEVIRTUAL(java.lang.String,length()I)
        regs = new KRegister[1];
        ref = c_memman.getReferenceArray(((KReference)frame.getLocal(1)),frame.getLocal(7).intValue());
        regs[0] = ref;
        frame.setProgramCounter(14);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("length()I"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("length()I"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[49] ISUB
         // *********[50] ICONST_1(Integer{1})
         // *********[51] IADD
         // *********[52] ILOAD(4)
         // *********[53] ALOAD(1)
         // *********[54] ILOAD(7)
         // *********[55] AALOAD
        c_memman = process.getMemoryManager();
         // *********[56] INVOKEVIRTUAL(java.lang.String,length()I)
      }
}
