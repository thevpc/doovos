package jjit.local.jnt.Bench.Formatter.pad_CI_Ljava_lang_String_58D199A6;
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
 * pad(CI)Ljava/lang/String;
 * [count=5] [10] ALOAD(2) [11] ILOAD(3) [12] ILOAD(0) [13] CASTORE [14] IINC(3,1)
 */
public final class pad_004 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** int m_i;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // local_3 3 ; r=2/w=1 : Cached
        int local_3 = frame.getLocal(3).intValue();
         // *********[10] ALOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[11] ILOAD(3)
         // **REMOVED Substitution** s1 = new KInteger(local_3);
         // *********[12] ILOAD(0)
         // **REMOVED Substitution** s2 = frame.getLocal(0);
         // *********[13] CASTORE
         // **REMOVED Substitution** m_i = frame.getLocal(0).intValue();
         // **REMOVED Substitution** index = local_3;
        c_memman.setCharArray(((KReference)frame.getLocal(2)),local_3,((char)frame.getLocal(0).intValue()));
         // *********[14] IINC(3,1)
         // **REMOVED Substitution** local_3 = (local_3 + 1);
        frame.setLocal(3,new KInteger((local_3 + 1)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[10] ALOAD(2)
         // *********[11] ILOAD(3)
         // *********[12] ILOAD(0)
         // *********[13] CASTORE
        c_memman = process.getMemoryManager();
         // *********[14] IINC(3,1)
        c_next = instructions[(index + 1)];
      }
}
