package jjit.local.jnt.scimark2.SparseCompRow.matmult__D_D_I_I_DI_V_7050E244;
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
 * jnt.scimark2.SparseCompRow
 * matmult([D[D[I[I[DI)V
 * [count=8] [0] ALOAD(2) [1] ARRAYLENGTH [2] ICONST_1(Integer{1}) [3] ISUB [4] ISTORE(6) [5] ICONST_0(Integer{0}) [6] ISTORE(7) [7] GOTO(51)
 */
public final class matmult_001 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // local_2 2 ; r=1/w=0 : NotCached
         // local_6 6 ; r=0/w=1 : NotCached
         // local_7 7 ; r=0/w=1 : NotCached
         // *********[0] ALOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[1] ARRAYLENGTH
         // **REMOVED Substitution** s0 = new KInteger(c_memman.getArraySize(((KReference)frame.getLocal(2))));
         // *********[2] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[3] ISUB
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s0 = new KInteger((c_memman.getArraySize(((KReference)frame.getLocal(2))) - 1));
         // *********[4] ISTORE(6)
        frame.setLocal(6,new KInteger((c_memman.getArraySize(((KReference)frame.getLocal(2))) - 1)));
         // *********[5] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[6] ISTORE(7)
        frame.setLocal(7,KInteger.ZERO);
         // *********[7] GOTO(51)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(2)
         // *********[1] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[2] ICONST_1(Integer{1})
         // *********[3] ISUB
         // *********[4] ISTORE(6)
         // *********[5] ICONST_0(Integer{0})
         // *********[6] ISTORE(7)
         // *********[7] GOTO(51)
        c_label = instructions[8];
      }
}
