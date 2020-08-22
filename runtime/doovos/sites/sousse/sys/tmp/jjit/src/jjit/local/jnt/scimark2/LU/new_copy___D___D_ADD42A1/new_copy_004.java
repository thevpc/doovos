package jjit.local.jnt.scimark2.LU.new_copy___D___D_ADD42A1;
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
 * new_copy([[D)[[D
 * [count=4] [11] ASTORE(3) [12] ICONST_0(Integer{0}) [13] ISTORE(4) [14] GOTO(37)
 */
public final class new_copy_004 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_3 3 ; r=0/w=1 : NotCached
         // local_4 4 ; r=0/w=1 : NotCached
         // *********[11] ASTORE(3)
        frame.setLocal(3,frame.pop());
         // *********[12] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[13] ISTORE(4)
        frame.setLocal(4,KInteger.ZERO);
         // *********[14] GOTO(37)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[11] ASTORE(3)
         // *********[12] ICONST_0(Integer{0})
         // *********[13] ISTORE(4)
         // *********[14] GOTO(37)
        c_label = instructions[8];
      }
}
