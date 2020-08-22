package jjit.local.jnt.scimark2.kernel.CopyMatrix___D__D_V_4E84EC1A;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.kernel
 * CopyMatrix([[D[[D)V
 * [count=3] [36] ILOAD(4) [37] ISTORE(9) [38] GOTO(76)
 */
public final class CopyMatrix_005 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_4 4 ; r=1/w=0 : NotCached
         // local_9 9 ; r=0/w=1 : NotCached
         // *********[36] ILOAD(4)
         // **REMOVED Substitution** s0 = frame.getLocal(4);
         // *********[37] ISTORE(9)
        frame.setLocal(9,frame.getLocal(4));
         // *********[38] GOTO(76)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[36] ILOAD(4)
         // *********[37] ISTORE(9)
         // *********[38] GOTO(76)
        c_label = instructions[6];
      }
}
