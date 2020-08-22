package jjit.local.jnt.scimark2.FFT.bitreverse__D_V_5DDEB160;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.FFT
 * bitreverse([D)V
 * [count=3] [74] ILOAD(7) [75] ILOAD(4) [76] IF_ICMPLE(66)
 */
public final class bitreverse_005 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_4 4 ; r=1/w=0 : NotCached
         // local_7 7 ; r=1/w=0 : NotCached
         // *********[74] ILOAD(7)
         // **REMOVED Substitution** s0 = frame.getLocal(7);
         // *********[75] ILOAD(4)
         // **REMOVED Substitution** s1 = frame.getLocal(4);
         // *********[76] IF_ICMPLE(66)
         // **REMOVED Substitution** index = frame.getLocal(4).intValue();
         // **REMOVED Substitution** jump = frame.getLocal(7).intValue() <= frame.getLocal(4).intValue();
        return ((frame.getLocal(7).intValue() <= frame.getLocal(4).intValue())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[74] ILOAD(7)
         // *********[75] ILOAD(4)
         // *********[76] IF_ICMPLE(66)
        c_next = instructions[(index + 1)];
        c_label = instructions[3];
      }
}
