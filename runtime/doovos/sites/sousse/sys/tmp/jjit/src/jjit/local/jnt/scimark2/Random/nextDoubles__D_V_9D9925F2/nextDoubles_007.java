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
 * [count=4] [40] ILOAD(5) [41] LDC(9->"2147483647") [42] IADD [43] ISTORE(5)
 */
public final class nextDoubles_007 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // local_5 5 ; r=1/w=1 : Cached
        int local_5 = frame.getLocal(5).intValue();
         // *********[40] ILOAD(5)
         // **REMOVED Substitution** s0 = new KInteger(local_5);
         // *********[41] LDC(9->"2147483647")
         // **REMOVED Substitution** s1 = I2147483647;
         // *********[42] IADD
         // **REMOVED Substitution** index = 2147483647;
         // **REMOVED Substitution** s0 = new KInteger((local_5 + 2147483647));
         // *********[43] ISTORE(5)
         // **REMOVED Substitution** local_5 = (local_5 + 2147483647);
        frame.setLocal(5,new KInteger((local_5 + 2147483647)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[40] ILOAD(5)
         // *********[41] LDC(9->"2147483647")
         // *********[42] IADD
         // *********[43] ISTORE(5)
        c_next = instructions[(index + 1)];
      }
}
