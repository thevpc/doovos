package jjit.local.jnt.Bench.Bench.parseEntries_Ljava_io_StreamTokenizer_V_6B9C6DF2;
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
 * jnt.Bench.Bench
 * parseEntries(Ljava/io/StreamTokenizer;)V
 * [count=6] [49] DLOAD(2) [50] ALOAD(5) [51] ICONST_0(Integer{0}) [52] DALOAD [53] DCMPG [54] IFGE(57)
 */
public final class parseEntries_013 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** int index = 0;
        double m_d;
        double m_d2;
         // **REMOVED Unused Var** boolean jump;
         // local_2 2 ; r=1/w=0 : NotCached
         // local_5 5 ; r=1/w=0 : NotCached
         // *********[49] DLOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[50] ALOAD(5)
         // **REMOVED Substitution** s1 = frame.getLocal(5);
         // *********[51] ICONST_0(Integer{0})
         // **REMOVED Substitution** s2 = IZERO;
         // *********[52] DALOAD
         // **REMOVED Substitution** index = 0;
         // **REMOVED Substitution** s1 = new KDouble(c_memman.getDoubleArray(((KReference)frame.getLocal(5)),0));
         // *********[53] DCMPG
        m_d2 = c_memman.getDoubleArray(((KReference)frame.getLocal(5)),0);
        m_d = frame.getLocal(2).doubleValue();
         // **REMOVED Substitution** s0 = ((Double.isNaN(m_d) || Double.isNaN(m_d2))?(KInteger.ONE):(((m_d == m_d2)?(KInteger.ZERO):(((m_d > m_d2)?(KInteger.ONE):(KInteger.M1))))));
         // *********[54] IFGE(57)
         // **REMOVED Substitution** index = ((Double.isNaN(m_d) || Double.isNaN(m_d2))?(1):(((m_d == m_d2)?(0):(((m_d > m_d2)?(1):(-1))))));
         // **REMOVED Substitution** jump = ((Double.isNaN(m_d) || Double.isNaN(m_d2))?(1):(((m_d == m_d2)?(0):(((m_d > m_d2)?(1):(-1)))))) >= 0;
        return ((((Double.isNaN(m_d) || Double.isNaN(m_d2))?(1):(((m_d == m_d2)?(0):(((m_d > m_d2)?(1):(-1)))))) >= 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[49] DLOAD(2)
         // *********[50] ALOAD(5)
         // *********[51] ICONST_0(Integer{0})
         // *********[52] DALOAD
        c_memman = process.getMemoryManager();
         // *********[53] DCMPG
         // *********[54] IFGE(57)
        c_next = instructions[(index + 1)];
        c_label = instructions[14];
      }
}
