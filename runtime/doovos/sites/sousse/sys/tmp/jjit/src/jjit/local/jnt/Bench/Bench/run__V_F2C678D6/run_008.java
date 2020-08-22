package jjit.local.jnt.Bench.Bench.run__V_F2C678D6;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Bench
 * run()V
 * [count=6] [8] ICONST_0(Integer{0}) [9] ISTORE(1) [10] LDC(57->"") [11] ASTORE(2) [12] ACONST_NULL [13] ASTORE(3)
 */
public final class run_008 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R57 = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KReference s0_ref;
         // local_1 1 ; r=0/w=1 : NotCached
         // local_2 2 ; r=0/w=1 : NotCached
         // local_3 3 ; r=0/w=1 : NotCached
         // *********[8] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[9] ISTORE(1)
        frame.setLocal(1,KInteger.ZERO);
         // *********[10] LDC(57->"")
         // **REMOVED Substitution** s0_ref = R57;
         // *********[11] ASTORE(2)
        frame.setLocal(2,R57);
         // *********[12] ACONST_NULL
         // **REMOVED Substitution** s0_ref = KReference.NULL;
         // *********[13] ASTORE(3)
        frame.setLocal(3,KReference.NULL);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[8] ICONST_0(Integer{0})
         // *********[9] ISTORE(1)
         // *********[10] LDC(57->"")
        R57 = ((KReference)constants[57]);
         // *********[11] ASTORE(2)
         // *********[12] ACONST_NULL
         // *********[13] ASTORE(3)
        c_next = instructions[(index + 1)];
      }
}
