package jjit.local.jnt.scimark2.LU.solve___D_I_D_V_710E1D67;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.LU
 * solve([[D[I[D)V
 * [count=5] [63] ILOAD(4) [64] ICONST_1(Integer{1}) [65] ISUB [66] ISTORE(7) [67] GOTO(104)
 */
public final class solve_011 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // local_4 4 ; r=1/w=0 : NotCached
         // local_7 7 ; r=0/w=1 : NotCached
         // *********[63] ILOAD(4)
         // **REMOVED Substitution** s0 = frame.getLocal(4);
         // *********[64] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[65] ISUB
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s0 = new KInteger((frame.getLocal(4).intValue() - 1));
         // *********[66] ISTORE(7)
        frame.setLocal(7,new KInteger((frame.getLocal(4).intValue() - 1)));
         // *********[67] GOTO(104)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[63] ILOAD(4)
         // *********[64] ICONST_1(Integer{1})
         // *********[65] ISUB
         // *********[66] ISTORE(7)
         // *********[67] GOTO(104)
        c_label = instructions[15];
      }
}
