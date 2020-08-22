package jjit.local.jnt.scimark2.LU.factor___D_I_I_722247B8;
import java.lang.Math;
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
 * [count=11] [29] ALOAD(0) [30] ILOAD(9) [31] AALOAD [32] ILOAD(5) [33] DALOAD [34] INVOKE_HOST(java.lang.Math.abs(D)D) [35] DSTORE(10) [36] DLOAD(10) [37] DLOAD(7) [38] DCMPL [39] IFLE(44)
 */
public final class factor_003 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KRegister[] regs = null;
         // **REMOVED Unused Var** double m_v;
        double m_d;
        double m_d2;
         // **REMOVED Unused Var** boolean jump;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_5 5 ; r=1/w=0 : NotCached
         // local_7 7 ; r=1/w=0 : NotCached
         // local_9 9 ; r=1/w=0 : NotCached
         // local_10 10 ; r=1/w=1 : Cached
        KRegister local_10;
         // *********[29] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[30] ILOAD(9)
         // **REMOVED Substitution** s1 = frame.getLocal(9);
         // *********[31] AALOAD
         // **REMOVED Substitution** index = frame.getLocal(9).intValue();
         // **REMOVED Substitution** ref = ((KReference)frame.getLocal(0));
         // **REMOVED Substitution** s0_ref = c_memman.getReferenceArray(((KReference)frame.getLocal(0)),frame.getLocal(9).intValue());
         // *********[32] ILOAD(5)
         // **REMOVED Substitution** s1 = frame.getLocal(5);
         // *********[33] DALOAD
         // **REMOVED Substitution** index = frame.getLocal(5).intValue();
         // **REMOVED Substitution** s0 = new KDouble(c_memman.getDoubleArray(c_memman.getReferenceArray(((KReference)frame.getLocal(0)),frame.getLocal(9).intValue()),frame.getLocal(5).intValue()));
         // *********[34] INVOKE_HOST(java.lang.Math.abs(D)D)
         // **REMOVED Substitution** m_v = c_memman.getDoubleArray(c_memman.getReferenceArray(((KReference)frame.getLocal(0)),frame.getLocal(9).intValue()),frame.getLocal(5).intValue());
         // **REMOVED Substitution** s0 = new KDouble(Math.abs(c_memman.getDoubleArray(c_memman.getReferenceArray(((KReference)frame.getLocal(0)),frame.getLocal(9).intValue()),frame.getLocal(5).intValue())));
         // *********[35] DSTORE(10)
        local_10 = new KDouble(Math.abs(c_memman.getDoubleArray(c_memman.getReferenceArray(((KReference)frame.getLocal(0)),frame.getLocal(9).intValue()),frame.getLocal(5).intValue())));
         // *********[36] DLOAD(10)
         // **REMOVED Substitution** s0 = local_10;
         // *********[37] DLOAD(7)
         // **REMOVED Substitution** s1 = frame.getLocal(7);
         // *********[38] DCMPL
        m_d2 = frame.getLocal(7).doubleValue();
        m_d = local_10.doubleValue();
         // **REMOVED Substitution** s0 = ((Double.isNaN(m_d) || Double.isNaN(m_d2))?(KInteger.M1):(((m_d == m_d2)?(KInteger.ZERO):(((m_d > m_d2)?(KInteger.ONE):(KInteger.M1))))));
         // *********[39] IFLE(44)
         // **REMOVED Substitution** index = ((Double.isNaN(m_d) || Double.isNaN(m_d2))?(-1):(((m_d == m_d2)?(0):(((m_d > m_d2)?(1):(-1))))));
         // **REMOVED Substitution** jump = ((Double.isNaN(m_d) || Double.isNaN(m_d2))?(-1):(((m_d == m_d2)?(0):(((m_d > m_d2)?(1):(-1)))))) <= 0;
        frame.setLocal(10,local_10);
        return ((((Double.isNaN(m_d) || Double.isNaN(m_d2))?(-1):(((m_d == m_d2)?(0):(((m_d > m_d2)?(1):(-1)))))) <= 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[29] ALOAD(0)
         // *********[30] ILOAD(9)
         // *********[31] AALOAD
        c_memman = process.getMemoryManager();
         // *********[32] ILOAD(5)
         // *********[33] DALOAD
         // *********[34] INVOKE_HOST(java.lang.Math.abs(D)D)
         // *********[35] DSTORE(10)
         // *********[36] DLOAD(10)
         // *********[37] DLOAD(7)
         // *********[38] DCMPL
         // *********[39] IFLE(44)
        c_next = instructions[(index + 1)];
        c_label = instructions[4];
      }
}
