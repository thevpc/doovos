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
 * [count=4] [16] ICONST_1(Integer{1}) [17] ISTORE(1) [18] LDC(120->"Benchmark Done") [19] ASTORE(2)
 */
public final class run_010 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R120 = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KReference s0_ref;
         // local_1 1 ; r=0/w=1 : NotCached
         // local_2 2 ; r=0/w=1 : NotCached
         // *********[16] ICONST_1(Integer{1})
         // **REMOVED Substitution** s0 = IONE;
         // *********[17] ISTORE(1)
        frame.setLocal(1,KInteger.ONE);
         // *********[18] LDC(120->"Benchmark Done")
         // **REMOVED Substitution** s0_ref = R120;
         // *********[19] ASTORE(2)
        frame.setLocal(2,R120);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[16] ICONST_1(Integer{1})
         // *********[17] ISTORE(1)
         // *********[18] LDC(120->"Benchmark Done")
        R120 = ((KReference)constants[120]);
         // *********[19] ASTORE(2)
        c_next = instructions[(index + 1)];
      }
}
