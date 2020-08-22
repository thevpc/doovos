package jjit.local.jnt.scimark2.applet.execute_Ljnt_Bench_Bench__D_70A4923B;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.applet
 * execute(Ljnt/Bench/Bench;)[D
 * [count=7] [7] ASTORE(3) [8] LDC(5->"2.0") [9] DSTORE(4) [10] LDC(6->"1.0E-5") [11] DSTORE(6) [12] ALOAD(1) [13] LDC(7->"Downloading FFT")
 */
public final class execute_004 extends JJITAbstractInstruction implements Cloneable{
      private static final KDouble D2_0 = new KDouble(2.0D);
      private static final KDouble D1_0EM5 = new KDouble(1.0E-5D);
      private static KReference R7 = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_1 1 ; r=1/w=0 : NotCached
         // local_3 3 ; r=0/w=1 : NotCached
         // local_4 4 ; r=0/w=1 : NotCached
         // local_6 6 ; r=0/w=1 : NotCached
         // *********[7] ASTORE(3)
        frame.setLocal(3,frame.pop());
         // *********[8] LDC(5->"2.0")
         // **REMOVED Substitution** s0 = D2_0;
         // *********[9] DSTORE(4)
        frame.setLocal(4,D2_0);
         // *********[10] LDC(6->"1.0E-5")
         // **REMOVED Substitution** s0 = D1_0EM5;
         // *********[11] DSTORE(6)
        frame.setLocal(6,D1_0EM5);
         // *********[12] ALOAD(1)
        frame.push(frame.getLocal(1));
         // *********[13] LDC(7->"Downloading FFT")
        frame.push(R7);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[7] ASTORE(3)
         // *********[8] LDC(5->"2.0")
         // *********[9] DSTORE(4)
         // *********[10] LDC(6->"1.0E-5")
         // *********[11] DSTORE(6)
         // *********[12] ALOAD(1)
         // *********[13] LDC(7->"Downloading FFT")
        R7 = ((KReference)constants[7]);
        c_next = instructions[(index + 1)];
      }
}
