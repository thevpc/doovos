package jjit.local.jnt.scimark2.LU.solve___D_I_D_V_710E1D67;
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
 * solve([[D[I[D)V
 * [count=5] [55] ALOAD(2) [56] ILOAD(6) [57] DLOAD(8) [58] DASTORE [59] IINC(6,1)
 */
public final class solve_009 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** double m_d;
         // local_2 2 ; r=1/w=0 : NotCached
         // local_6 6 ; r=2/w=1 : Cached
        int local_6 = frame.getLocal(6).intValue();
         // local_8 8 ; r=1/w=0 : NotCached
         // *********[55] ALOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[56] ILOAD(6)
         // **REMOVED Substitution** s1 = new KInteger(local_6);
         // *********[57] DLOAD(8)
         // **REMOVED Substitution** s2 = frame.getLocal(8);
         // *********[58] DASTORE
         // **REMOVED Substitution** m_d = frame.getLocal(8).doubleValue();
         // **REMOVED Substitution** index = local_6;
        c_memman.setDoubleArray(((KReference)frame.getLocal(2)),local_6,frame.getLocal(8).doubleValue());
         // *********[59] IINC(6,1)
         // **REMOVED Substitution** local_6 = (local_6 + 1);
        frame.setLocal(6,new KInteger((local_6 + 1)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[55] ALOAD(2)
         // *********[56] ILOAD(6)
         // *********[57] DLOAD(8)
         // *********[58] DASTORE
        c_memman = process.getMemoryManager();
         // *********[59] IINC(6,1)
        c_next = instructions[(index + 1)];
      }
}
