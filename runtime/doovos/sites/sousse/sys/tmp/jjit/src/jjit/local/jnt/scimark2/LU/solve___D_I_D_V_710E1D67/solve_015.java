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
 * [count=11] [93] ALOAD(2) [94] ILOAD(7) [95] DLOAD(8) [96] ALOAD(0) [97] ILOAD(7) [98] AALOAD [99] ILOAD(7) [100] DALOAD [101] DDIV [102] DASTORE [103] IINC(7,-1)
 */
public final class solve_015 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s4;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s3_ref;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** double m_d;
         // **REMOVED Unused Var** double m_d2;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // local_7 7 ; r=4/w=1 : Cached
        int local_7 = frame.getLocal(7).intValue();
         // local_8 8 ; r=1/w=0 : NotCached
         // *********[93] ALOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[94] ILOAD(7)
         // **REMOVED Substitution** s1 = new KInteger(local_7);
         // *********[95] DLOAD(8)
         // **REMOVED Substitution** s2 = frame.getLocal(8);
         // *********[96] ALOAD(0)
         // **REMOVED Substitution** s3 = frame.getLocal(0);
         // *********[97] ILOAD(7)
         // **REMOVED Substitution** s4 = new KInteger(local_7);
         // *********[98] AALOAD
         // **REMOVED Substitution** index = local_7;
         // **REMOVED Substitution** ref = ((KReference)frame.getLocal(0));
         // **REMOVED Substitution** s3_ref = c_memman.getReferenceArray(((KReference)frame.getLocal(0)),local_7);
         // *********[99] ILOAD(7)
         // **REMOVED Substitution** s4 = new KInteger(local_7);
         // *********[100] DALOAD
         // **REMOVED Substitution** index = local_7;
         // **REMOVED Substitution** s3 = new KDouble(c_memman.getDoubleArray(c_memman.getReferenceArray(((KReference)frame.getLocal(0)),local_7),local_7));
         // *********[101] DDIV
         // **REMOVED Substitution** m_d = c_memman.getDoubleArray(c_memman.getReferenceArray(((KReference)frame.getLocal(0)),local_7),local_7);
         // **REMOVED Substitution** s2 = new KDouble((frame.getLocal(8).doubleValue() / c_memman.getDoubleArray(c_memman.getReferenceArray(((KReference)frame.getLocal(0)),local_7),local_7)));
         // *********[102] DASTORE
         // **REMOVED Substitution** m_d2 = (frame.getLocal(8).doubleValue() / c_memman.getDoubleArray(c_memman.getReferenceArray(((KReference)frame.getLocal(0)),local_7),local_7));
         // **REMOVED Substitution** index = local_7;
        c_memman.setDoubleArray(((KReference)frame.getLocal(2)),local_7,(frame.getLocal(8).doubleValue() / c_memman.getDoubleArray(c_memman.getReferenceArray(((KReference)frame.getLocal(0)),local_7),local_7)));
         // *********[103] IINC(7,-1)
         // **REMOVED Substitution** local_7 = (local_7 + -1);
        frame.setLocal(7,new KInteger((local_7 + -1)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[93] ALOAD(2)
         // *********[94] ILOAD(7)
         // *********[95] DLOAD(8)
         // *********[96] ALOAD(0)
         // *********[97] ILOAD(7)
         // *********[98] AALOAD
        c_memman = process.getMemoryManager();
         // *********[99] ILOAD(7)
         // *********[100] DALOAD
         // *********[101] DDIV
         // *********[102] DASTORE
         // *********[103] IINC(7,-1)
        c_next = instructions[(index + 1)];
      }
}
