package jjit.local.jnt.scimark2.LU.factor___D_I_I_722247B8;
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
 * factor([[D[I)I
 * [count=4] [40] ILOAD(9) [41] ISTORE(6) [42] DLOAD(10) [43] DSTORE(7)
 */
public final class factor_004 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_6 6 ; r=0/w=1 : NotCached
         // local_7 7 ; r=0/w=1 : NotCached
         // local_9 9 ; r=1/w=0 : NotCached
         // local_10 10 ; r=1/w=0 : NotCached
         // *********[40] ILOAD(9)
         // **REMOVED Substitution** s0 = frame.getLocal(9);
         // *********[41] ISTORE(6)
        frame.setLocal(6,frame.getLocal(9));
         // *********[42] DLOAD(10)
         // **REMOVED Substitution** s0 = frame.getLocal(10);
         // *********[43] DSTORE(7)
        frame.setLocal(7,frame.getLocal(10));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[40] ILOAD(9)
         // *********[41] ISTORE(6)
         // *********[42] DLOAD(10)
         // *********[43] DSTORE(7)
        c_next = instructions[(index + 1)];
      }
}
