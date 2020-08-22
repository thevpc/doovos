package jjit.local.jnt.Bench.Formatter.format_DI_Ljava_lang_String_59D5BD5C;
import java.lang.Double;
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
 * [count=3] [4] DLOAD(0) [5] INVOKE_HOST(java.lang.Double.toString(D)Ljava/lang/String;) [6] ARETURN
 */
public final class format_002 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** KRegister[] regs = null;
        double m_v;
         // **REMOVED Unused Var** String m_s;
        KFrame callerFrame = null;
         // **REMOVED Unused Var** KRegister reg;
        KLocalThread thread = frame.getThread();
         // local_0 0 ; r=1/w=0 : NotCached
         // *********[4] DLOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[5] INVOKE_HOST(java.lang.Double.toString(D)Ljava/lang/String;)
        m_v = frame.getLocal(0).doubleValue();
         // **REMOVED Substitution** m_s = Double.toString(m_v);
         // **REMOVED Substitution** s0_ref = ((Double.toString(m_v) == null)?(KReference.NULL):(c_memman.allocString(Double.toString(m_v))));
         // *********[6] ARETURN
         // **REMOVED Substitution** reg = ((Double.toString(m_v) == null)?(KReference.NULL):(c_memman.allocString(Double.toString(m_v))));
        callerFrame = thread.popFrame();
        callerFrame.push(((Double.toString(m_v) == null)?(KReference.NULL):(c_memman.allocString(Double.toString(m_v)))));
        return ((JJITInstruction)callerFrame.getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[4] DLOAD(0)
         // *********[5] INVOKE_HOST(java.lang.Double.toString(D)Ljava/lang/String;)
        c_memman = process.getMemoryManager();
         // *********[6] ARETURN
      }
}
