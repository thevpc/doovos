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
 * [count=3] [29] ILOAD(5) [30] ISTORE(10) [31] GOTO(45)
 */
public final class solve_003 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_5 5 ; r=1/w=0 : NotCached
         // local_10 10 ; r=0/w=1 : NotCached
         // *********[29] ILOAD(5)
         // **REMOVED Substitution** s0 = frame.getLocal(5);
         // *********[30] ISTORE(10)
        frame.setLocal(10,frame.getLocal(5));
         // *********[31] GOTO(45)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[29] ILOAD(5)
         // *********[30] ISTORE(10)
         // *********[31] GOTO(45)
        c_label = instructions[4];
      }
}
