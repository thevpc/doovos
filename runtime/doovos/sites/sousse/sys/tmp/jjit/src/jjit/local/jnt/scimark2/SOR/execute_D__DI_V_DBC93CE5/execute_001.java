package jjit.local.jnt.scimark2.SOR.execute_D__DI_V_DBC93CE5;
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
 * jnt.scimark2.SOR
 * execute(D[[DI)V
 * [count=27] [0] ALOAD(2) [1] ARRAYLENGTH [2] ISTORE(4) [3] ALOAD(2) [4] ICONST_0(Integer{0}) [5] AALOAD [6] ARRAYLENGTH [7] ISTORE(5) [8] DLOAD(0) [9] LDC(3->"0.25") [10] DMUL [11] DSTORE(6) [12] DCONST_1(Double{1.0}) [13] DLOAD(0) [14] DSUB [15] DSTORE(8) [16] ILOAD(4) [17] ICONST_1(Integer{1}) [18] ISUB [19] ISTORE(10) [20] ILOAD(5) [21] ICONST_1(Integer{1}) [22] ISUB [23] ISTORE(11) [24] ICONST_0(Integer{0}) [25] ISTORE(12) [26] GOTO(88)
 */
public final class execute_001 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** double m_d;
         // **REMOVED Unused Var** double m_d2;
         // local_0 0 ; r=2/w=0 : Cached
        KRegister local_0 = frame.getLocal(0);
         // local_2 2 ; r=2/w=0 : Cached
        KRegister local_2 = frame.getLocal(2);
         // local_4 4 ; r=1/w=1 : Cached
        int local_4;
         // local_5 5 ; r=1/w=1 : Cached
        int local_5;
         // local_6 6 ; r=0/w=1 : NotCached
         // local_8 8 ; r=0/w=1 : NotCached
         // local_10 10 ; r=0/w=1 : NotCached
         // local_11 11 ; r=0/w=1 : NotCached
         // local_12 12 ; r=0/w=1 : NotCached
         // *********[0] ALOAD(2)
         // **REMOVED Substitution** s0 = local_2;
         // *********[1] ARRAYLENGTH
         // **REMOVED Substitution** s0 = new KInteger(c_memman.getArraySize(((KReference)local_2)));
         // *********[2] ISTORE(4)
        local_4 = c_memman.getArraySize(((KReference)local_2));
         // *********[3] ALOAD(2)
         // **REMOVED Substitution** s0 = local_2;
         // *********[4] ICONST_0(Integer{0})
         // **REMOVED Substitution** s1 = IZERO;
         // *********[5] AALOAD
         // **REMOVED Substitution** index = 0;
         // **REMOVED Substitution** ref = ((KReference)local_2);
         // **REMOVED Substitution** s0_ref = c_memman.getReferenceArray(((KReference)local_2),0);
         // *********[6] ARRAYLENGTH
         // **REMOVED Substitution** s0 = new KInteger(c_memman.getArraySize(c_memman.getReferenceArray(((KReference)local_2),0)));
         // *********[7] ISTORE(5)
        local_5 = c_memman.getArraySize(c_memman.getReferenceArray(((KReference)local_2),0));
         // *********[8] DLOAD(0)
         // **REMOVED Substitution** s0 = local_0;
         // *********[9] LDC(3->"0.25")
         // **REMOVED Substitution** s1 = D0_25;
         // *********[10] DMUL
         // **REMOVED Substitution** m_d = 0.25D;
         // **REMOVED Substitution** s0 = new KDouble((local_0.doubleValue() * 0.25D));
         // *********[11] DSTORE(6)
        frame.setLocal(6,new KDouble((local_0.doubleValue() * 0.25D)));
         // *********[12] DCONST_1(Double{1.0})
         // **REMOVED Substitution** s0 = DONE;
         // *********[13] DLOAD(0)
         // **REMOVED Substitution** s1 = local_0;
         // *********[14] DSUB
         // **REMOVED Substitution** m_d2 = local_0.doubleValue();
         // **REMOVED Substitution** s0 = new KDouble((1.0D - local_0.doubleValue()));
         // *********[15] DSTORE(8)
        frame.setLocal(8,new KDouble((1.0D - local_0.doubleValue())));
         // *********[16] ILOAD(4)
         // **REMOVED Substitution** s0 = new KInteger(local_4);
         // *********[17] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[18] ISUB
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s0 = new KInteger((local_4 - 1));
         // *********[19] ISTORE(10)
        frame.setLocal(10,new KInteger((local_4 - 1)));
         // *********[20] ILOAD(5)
         // **REMOVED Substitution** s0 = new KInteger(local_5);
         // *********[21] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[22] ISUB
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s0 = new KInteger((local_5 - 1));
         // *********[23] ISTORE(11)
        frame.setLocal(11,new KInteger((local_5 - 1)));
         // *********[24] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[25] ISTORE(12)
        frame.setLocal(12,KInteger.ZERO);
         // *********[26] GOTO(88)
        frame.setLocal(4,new KInteger(local_4));
        frame.setLocal(5,new KInteger(local_5));
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(2)
         // *********[1] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[2] ISTORE(4)
         // *********[3] ALOAD(2)
         // *********[4] ICONST_0(Integer{0})
         // *********[5] AALOAD
         // *********[6] ARRAYLENGTH
         // *********[7] ISTORE(5)
         // *********[8] DLOAD(0)
         // *********[9] LDC(3->"0.25")
         // *********[10] DMUL
         // *********[11] DSTORE(6)
         // *********[12] DCONST_1(Double{1.0})
         // *********[13] DLOAD(0)
         // *********[14] DSUB
         // *********[15] DSTORE(8)
         // *********[16] ILOAD(4)
         // *********[17] ICONST_1(Integer{1})
         // *********[18] ISUB
         // *********[19] ISTORE(10)
         // *********[20] ILOAD(5)
         // *********[21] ICONST_1(Integer{1})
         // *********[22] ISUB
         // *********[23] ISTORE(11)
         // *********[24] ICONST_0(Integer{0})
         // *********[25] ISTORE(12)
         // *********[26] GOTO(88)
        c_label = instructions[8];
      }
}
