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
 * [count=4] [355] ILOAD(6) [356] LDC(9->"2147483647") [357] IADD [358] ISTORE(6)
 */
public final class nextDoubles_054 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // local_6 6 ; r=1/w=1 : Cached
        int local_6 = frame.getLocal(6).intValue();
         // *********[355] ILOAD(6)
         // **REMOVED Substitution** s0 = new KInteger(local_6);
         // *********[356] LDC(9->"2147483647")
         // **REMOVED Substitution** s1 = I2147483647;
         // *********[357] IADD
         // **REMOVED Substitution** index = 2147483647;
         // **REMOVED Substitution** s0 = new KInteger((local_6 + 2147483647));
         // *********[358] ISTORE(6)
         // **REMOVED Substitution** local_6 = (local_6 + 2147483647);
        frame.setLocal(6,new KInteger((local_6 + 2147483647)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[355] ILOAD(6)
         // *********[356] LDC(9->"2147483647")
         // *********[357] IADD
         // *********[358] ISTORE(6)
        c_next = instructions[(index + 1)];
      }
}
