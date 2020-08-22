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
 * [count=9] [68] ALOAD(2) [69] ILOAD(7) [70] DALOAD [71] DSTORE(8) [72] ILOAD(7) [73] ICONST_1(Integer{1}) [74] IADD [75] ISTORE(10) [76] GOTO(90)
 */
public final class solve_012 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // local_2 2 ; r=1/w=0 : NotCached
         // local_7 7 ; r=2/w=0 : Cached
        int local_7 = frame.getLocal(7).intValue();
         // local_8 8 ; r=0/w=1 : NotCached
         // local_10 10 ; r=0/w=1 : NotCached
         // *********[68] ALOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[69] ILOAD(7)
         // **REMOVED Substitution** s1 = new KInteger(local_7);
         // *********[70] DALOAD
         // **REMOVED Substitution** index = local_7;
         // **REMOVED Substitution** s0 = new KDouble(c_memman.getDoubleArray(((KReference)frame.getLocal(2)),local_7));
         // *********[71] DSTORE(8)
        frame.setLocal(8,new KDouble(c_memman.getDoubleArray(((KReference)frame.getLocal(2)),local_7)));
         // *********[72] ILOAD(7)
         // **REMOVED Substitution** s0 = new KInteger(local_7);
         // *********[73] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[74] IADD
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s0 = new KInteger((local_7 + 1));
         // *********[75] ISTORE(10)
        frame.setLocal(10,new KInteger((local_7 + 1)));
         // *********[76] GOTO(90)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[68] ALOAD(2)
         // *********[69] ILOAD(7)
         // *********[70] DALOAD
        c_memman = process.getMemoryManager();
         // *********[71] DSTORE(8)
         // *********[72] ILOAD(7)
         // *********[73] ICONST_1(Integer{1})
         // *********[74] IADD
         // *********[75] ISTORE(10)
         // *********[76] GOTO(90)
        c_label = instructions[13];
      }
}
