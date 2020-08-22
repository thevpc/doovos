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
 * [count=5] [38] ALOAD(0) [39] ILOAD(7) [40] DUP2_X1Type1 [41] AALOAD [42] INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
 */
public final class addColumn_012 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
        KRegister m_r;
        KRegister m_r2;
        KRegister m_r3;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** KReference ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_7 7 ; r=1/w=0 : NotCached
         // *********[38] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[39] ILOAD(7)
         // **REMOVED Substitution** s1 = frame.getLocal(7);
         // *********[40] DUP2_X1Type1
        m_r = frame.getLocal(7);
        m_r2 = frame.getLocal(0);
        m_r3 = frame.pop();
        frame.push(m_r2);
        frame.push(m_r);
         // **REMOVED Substitution** s0 = m_r3;
         // **REMOVED Substitution** s1 = m_r2;
         // **REMOVED Substitution** s2 = m_r;
         // *********[41] AALOAD
         // **REMOVED Substitution** index = m_r.intValue();
         // **REMOVED Substitution** ref = ((KReference)m_r2);
         // **REMOVED Substitution** s1_ref = c_memman.getReferenceArray(((KReference)m_r2),m_r.intValue());
         // *********[42] INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
        regs = new KRegister[2];
        regs[1] = c_memman.getReferenceArray(((KReference)m_r2),m_r.intValue());
         // **REMOVED Substitution** ref = ((KReference)m_r3);
        regs[0] = ((KReference)m_r3);
        frame.setProgramCounter(12);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(((KReference)m_r3)).getVirtualMethodBySignature("append(Ljava/lang/String;)Ljava/lang/StringBuffer;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(((KReference)m_r3)).getVirtualMethodBySignature("append(Ljava/lang/String;)Ljava/lang/StringBuffer;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[38] ALOAD(0)
         // *********[39] ILOAD(7)
         // *********[40] DUP2_X1Type1
         // *********[41] AALOAD
        c_memman = process.getMemoryManager();
         // *********[42] INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
      }
}
