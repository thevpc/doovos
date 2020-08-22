package jjit.local.jnt.scimark2.LU.factor___D_I_I_722247B8;
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
 * jnt.scimark2.LU
 * factor([[D[I)I
 * [count=12] [48] ALOAD(1) [49] ILOAD(5) [50] ILOAD(6) [51] IASTORE [52] ALOAD(0) [53] ILOAD(6) [54] AALOAD [55] ILOAD(5) [56] DALOAD [57] DCONST_0(Double{0.0}) [58] DCMPL [59] IFNE(62)
 */
public final class factor_007 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** int m_i;
         // **REMOVED Unused Var** KReference ref;
        double m_d;
         // **REMOVED Unused Var** double m_d2;
         // **REMOVED Unused Var** boolean jump;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // local_5 5 ; r=2/w=0 : Cached
        int local_5 = frame.getLocal(5).intValue();
         // local_6 6 ; r=2/w=0 : Cached
        int local_6 = frame.getLocal(6).intValue();
         // *********[48] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[49] ILOAD(5)
         // **REMOVED Substitution** s1 = new KInteger(local_5);
         // *********[50] ILOAD(6)
         // **REMOVED Substitution** s2 = new KInteger(local_6);
         // *********[51] IASTORE
         // **REMOVED Substitution** m_i = local_6;
         // **REMOVED Substitution** index = local_5;
        c_memman.setIntArray(((KReference)frame.getLocal(1)),local_5,local_6);
         // *********[52] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[53] ILOAD(6)
         // **REMOVED Substitution** s1 = new KInteger(local_6);
         // *********[54] AALOAD
         // **REMOVED Substitution** index = local_6;
         // **REMOVED Substitution** ref = ((KReference)frame.getLocal(0));
         // **REMOVED Substitution** s0_ref = c_memman.getReferenceArray(((KReference)frame.getLocal(0)),local_6);
         // *********[55] ILOAD(5)
         // **REMOVED Substitution** s1 = new KInteger(local_5);
         // *********[56] DALOAD
         // **REMOVED Substitution** index = local_5;
         // **REMOVED Substitution** s0 = new KDouble(c_memman.getDoubleArray(c_memman.getReferenceArray(((KReference)frame.getLocal(0)),local_6),local_5));
         // *********[57] DCONST_0(Double{0.0})
         // **REMOVED Substitution** s1 = DZERO;
         // *********[58] DCMPL
         // **REMOVED Substitution** m_d2 = 0.0D;
        m_d = c_memman.getDoubleArray(c_memman.getReferenceArray(((KReference)frame.getLocal(0)),local_6),local_5);
         // **REMOVED Substitution** s0 = ((Double.isNaN(m_d))?(KInteger.M1):(((m_d == 0.0D)?(KInteger.ZERO):(((m_d > 0.0D)?(KInteger.ONE):(KInteger.M1))))));
         // *********[59] IFNE(62)
         // **REMOVED Substitution** index = ((Double.isNaN(m_d))?(-1):(((m_d == 0.0D)?(0):(((m_d > 0.0D)?(1):(-1))))));
         // **REMOVED Substitution** jump = ((Double.isNaN(m_d))?(-1):(((m_d == 0.0D)?(0):(((m_d > 0.0D)?(1):(-1)))))) != 0;
        return ((((Double.isNaN(m_d))?(-1):(((m_d == 0.0D)?(0):(((m_d > 0.0D)?(1):(-1)))))) != 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[48] ALOAD(1)
         // *********[49] ILOAD(5)
         // *********[50] ILOAD(6)
         // *********[51] IASTORE
        c_memman = process.getMemoryManager();
         // *********[52] ALOAD(0)
         // *********[53] ILOAD(6)
         // *********[54] AALOAD
         // *********[55] ILOAD(5)
         // *********[56] DALOAD
         // *********[57] DCONST_0(Double{0.0})
         // *********[58] DCMPL
         // *********[59] IFNE(62)
        c_next = instructions[(index + 1)];
        c_label = instructions[8];
      }
}
