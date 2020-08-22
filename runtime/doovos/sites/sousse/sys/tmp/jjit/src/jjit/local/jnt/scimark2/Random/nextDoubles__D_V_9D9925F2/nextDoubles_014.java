package jjit.local.jnt.scimark2.Random.nextDoubles__D_V_9D9925F2;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.Random
 * nextDoubles([D)V
 * [count=3] [82] ICONST_0(Integer{0}) [83] ISTORE(4) [84] GOTO(144)
 */
public final class nextDoubles_014 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_4 4 ; r=0/w=1 : NotCached
         // *********[82] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[83] ISTORE(4)
        frame.setLocal(4,KInteger.ZERO);
         // *********[84] GOTO(144)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[82] ICONST_0(Integer{0})
         // *********[83] ISTORE(4)
         // *********[84] GOTO(144)
        c_label = instructions[23];
      }
}
