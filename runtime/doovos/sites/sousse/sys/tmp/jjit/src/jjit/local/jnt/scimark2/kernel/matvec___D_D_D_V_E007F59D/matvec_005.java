package jjit.local.jnt.scimark2.kernel.matvec___D_D_D_V_E007F59D;
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
 * jnt.scimark2.kernel
 * matvec([[D[D[D)V
 * [count=5] [34] ALOAD(2) [35] ILOAD(5) [36] DLOAD(6) [37] DASTORE [38] IINC(5,1)
 */
public final class matvec_005 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** double m_d;
         // local_2 2 ; r=1/w=0 : NotCached
         // local_5 5 ; r=2/w=1 : Cached
        int local_5 = frame.getLocal(5).intValue();
         // local_6 6 ; r=1/w=0 : NotCached
         // *********[34] ALOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[35] ILOAD(5)
         // **REMOVED Substitution** s1 = new KInteger(local_5);
         // *********[36] DLOAD(6)
         // **REMOVED Substitution** s2 = frame.getLocal(6);
         // *********[37] DASTORE
         // **REMOVED Substitution** m_d = frame.getLocal(6).doubleValue();
         // **REMOVED Substitution** index = local_5;
        c_memman.setDoubleArray(((KReference)frame.getLocal(2)),local_5,frame.getLocal(6).doubleValue());
         // *********[38] IINC(5,1)
         // **REMOVED Substitution** local_5 = (local_5 + 1);
        frame.setLocal(5,new KInteger((local_5 + 1)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[34] ALOAD(2)
         // *********[35] ILOAD(5)
         // *********[36] DLOAD(6)
         // *********[37] DASTORE
        c_memman = process.getMemoryManager();
         // *********[38] IINC(5,1)
        c_next = instructions[(index + 1)];
      }
}
