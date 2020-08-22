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
 * [count=13] [32] DLOAD(8) [33] ALOAD(0) [34] ILOAD(6) [35] AALOAD [36] ILOAD(10) [37] DALOAD [38] ALOAD(2) [39] ILOAD(10) [40] DALOAD [41] DMUL [42] DSUB [43] DSTORE(8) [44] IINC(10,1)
 */
public final class solve_004 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** double m_d;
         // **REMOVED Unused Var** double m_d2;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // local_6 6 ; r=1/w=0 : NotCached
         // local_8 8 ; r=1/w=1 : Cached
        KRegister local_8 = frame.getLocal(8);
         // local_10 10 ; r=3/w=1 : Cached
        int local_10 = frame.getLocal(10).intValue();
         // *********[32] DLOAD(8)
         // **REMOVED Substitution** s0 = local_8;
         // *********[33] ALOAD(0)
         // **REMOVED Substitution** s1 = frame.getLocal(0);
         // *********[34] ILOAD(6)
         // **REMOVED Substitution** s2 = frame.getLocal(6);
         // *********[35] AALOAD
         // **REMOVED Substitution** index = frame.getLocal(6).intValue();
         // **REMOVED Substitution** ref = ((KReference)frame.getLocal(0));
         // **REMOVED Substitution** s1_ref = c_memman.getReferenceArray(((KReference)frame.getLocal(0)),frame.getLocal(6).intValue());
         // *********[36] ILOAD(10)
         // **REMOVED Substitution** s2 = new KInteger(local_10);
         // *********[37] DALOAD
         // **REMOVED Substitution** index = local_10;
         // **REMOVED Substitution** s1 = new KDouble(c_memman.getDoubleArray(c_memman.getReferenceArray(((KReference)frame.getLocal(0)),frame.getLocal(6).intValue()),local_10));
         // *********[38] ALOAD(2)
         // **REMOVED Substitution** s2 = frame.getLocal(2);
         // *********[39] ILOAD(10)
         // **REMOVED Substitution** s3 = new KInteger(local_10);
         // *********[40] DALOAD
         // **REMOVED Substitution** index = local_10;
         // **REMOVED Substitution** s2 = new KDouble(c_memman.getDoubleArray(((KReference)frame.getLocal(2)),local_10));
         // *********[41] DMUL
         // **REMOVED Substitution** m_d = c_memman.getDoubleArray(((KReference)frame.getLocal(2)),local_10);
         // **REMOVED Substitution** s1 = new KDouble((c_memman.getDoubleArray(c_memman.getReferenceArray(((KReference)frame.getLocal(0)),frame.getLocal(6).intValue()),local_10) * c_memman.getDoubleArray(((KReference)frame.getLocal(2)),local_10)));
         // *********[42] DSUB
         // **REMOVED Substitution** m_d2 = (c_memman.getDoubleArray(c_memman.getReferenceArray(((KReference)frame.getLocal(0)),frame.getLocal(6).intValue()),local_10) * c_memman.getDoubleArray(((KReference)frame.getLocal(2)),local_10));
         // **REMOVED Substitution** s0 = new KDouble((local_8.doubleValue() - (c_memman.getDoubleArray(c_memman.getReferenceArray(((KReference)frame.getLocal(0)),frame.getLocal(6).intValue()),local_10) * c_memman.getDoubleArray(((KReference)frame.getLocal(2)),local_10))));
         // *********[43] DSTORE(8)
         // **REMOVED Substitution** local_8 = new KDouble((local_8.doubleValue() - (c_memman.getDoubleArray(c_memman.getReferenceArray(((KReference)frame.getLocal(0)),frame.getLocal(6).intValue()),local_10) * c_memman.getDoubleArray(((KReference)frame.getLocal(2)),local_10))));
         // *********[44] IINC(10,1)
         // **REMOVED Substitution** local_10 = (local_10 + 1);
        frame.setLocal(8,new KDouble((local_8.doubleValue() - (c_memman.getDoubleArray(c_memman.getReferenceArray(((KReference)frame.getLocal(0)),frame.getLocal(6).intValue()),local_10) * c_memman.getDoubleArray(((KReference)frame.getLocal(2)),local_10)))));
        frame.setLocal(10,new KInteger((local_10 + 1)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[32] DLOAD(8)
         // *********[33] ALOAD(0)
         // *********[34] ILOAD(6)
         // *********[35] AALOAD
        c_memman = process.getMemoryManager();
         // *********[36] ILOAD(10)
         // *********[37] DALOAD
         // *********[38] ALOAD(2)
         // *********[39] ILOAD(10)
         // *********[40] DALOAD
         // *********[41] DMUL
         // *********[42] DSUB
         // *********[43] DSTORE(8)
         // *********[44] IINC(10,1)
        c_next = instructions[(index + 1)];
      }
}
