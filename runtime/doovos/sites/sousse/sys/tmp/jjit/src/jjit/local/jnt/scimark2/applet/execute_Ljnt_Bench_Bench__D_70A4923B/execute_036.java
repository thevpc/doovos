package jjit.local.jnt.scimark2.applet.execute_Ljnt_Bench_Bench__D_70A4923B;
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
 * jnt.scimark2.applet
 * execute(Ljnt/Bench/Bench;)[D
 * [count=6] [147] ALOAD(2) [148] ICONST_5(Integer{5}) [149] DALOAD [150] DCONST_0(Double{0.0}) [151] DCMPL [152] IFNE(177)
 */
public final class execute_036 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
        double m_d;
         // **REMOVED Unused Var** double m_d2;
         // **REMOVED Unused Var** boolean jump;
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[147] ALOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[148] ICONST_5(Integer{5})
         // **REMOVED Substitution** s1 = IFIVE;
         // *********[149] DALOAD
         // **REMOVED Substitution** index = 5;
         // **REMOVED Substitution** s0 = new KDouble(c_memman.getDoubleArray(((KReference)frame.getLocal(2)),5));
         // *********[150] DCONST_0(Double{0.0})
         // **REMOVED Substitution** s1 = DZERO;
         // *********[151] DCMPL
         // **REMOVED Substitution** m_d2 = 0.0D;
        m_d = c_memman.getDoubleArray(((KReference)frame.getLocal(2)),5);
         // **REMOVED Substitution** s0 = ((Double.isNaN(m_d))?(KInteger.M1):(((m_d == 0.0D)?(KInteger.ZERO):(((m_d > 0.0D)?(KInteger.ONE):(KInteger.M1))))));
         // *********[152] IFNE(177)
         // **REMOVED Substitution** index = ((Double.isNaN(m_d))?(-1):(((m_d == 0.0D)?(0):(((m_d > 0.0D)?(1):(-1))))));
         // **REMOVED Substitution** jump = ((Double.isNaN(m_d))?(-1):(((m_d == 0.0D)?(0):(((m_d > 0.0D)?(1):(-1)))))) != 0;
        return ((((Double.isNaN(m_d))?(-1):(((m_d == 0.0D)?(0):(((m_d > 0.0D)?(1):(-1)))))) != 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[147] ALOAD(2)
         // *********[148] ICONST_5(Integer{5})
         // *********[149] DALOAD
        c_memman = process.getMemoryManager();
         // *********[150] DCONST_0(Double{0.0})
         // *********[151] DCMPL
         // *********[152] IFNE(177)
        c_next = instructions[(index + 1)];
        c_label = instructions[37];
      }
}
