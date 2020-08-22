package jjit.local.jnt.Bench.Formatter.format_DI_Ljava_lang_String_59D5BD5C;
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
 * format(DI)Ljava/lang/String;
 * [count=4] [50] ILOAD(2) [51] ISUB [52] BIPUSH(46) [53] INVOKEVIRTUAL(java.lang.StringBuffer,insert(IC)Ljava/lang/StringBuffer;)
 */
public final class format_019 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger I46 = new KInteger(46);
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
        int index = 0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[50] ILOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[51] ISUB
        index = frame.getLocal(2).intValue();
         // **REMOVED Substitution** s0 = new KInteger((frame.popInt() - index));
         // *********[52] BIPUSH(46)
         // **REMOVED Substitution** s1 = I46;
         // *********[53] INVOKEVIRTUAL(java.lang.StringBuffer,insert(IC)Ljava/lang/StringBuffer;)
        regs = new KRegister[3];
        regs[2] = I46;
        regs[1] = new KInteger((frame.popInt() - index));
        ref = frame.popRef();
        regs[0] = ref;
        frame.setProgramCounter(19);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("insert(IC)Ljava/lang/StringBuffer;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("insert(IC)Ljava/lang/StringBuffer;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[50] ILOAD(2)
         // *********[51] ISUB
         // *********[52] BIPUSH(46)
         // *********[53] INVOKEVIRTUAL(java.lang.StringBuffer,insert(IC)Ljava/lang/StringBuffer;)
        c_memman = process.getMemoryManager();
      }
}
