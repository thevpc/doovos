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
 * [count=5] [77] ILOAD(4) [78] ILOAD(7) [79] IADD [80] ISTORE(4) [81] IINC(3,1)
 */
public final class bitreverse_006 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // local_3 3 ; r=1/w=1 : Cached
        int local_3 = frame.getLocal(3).intValue();
         // local_4 4 ; r=1/w=1 : Cached
        int local_4 = frame.getLocal(4).intValue();
         // local_7 7 ; r=1/w=0 : NotCached
         // *********[77] ILOAD(4)
         // **REMOVED Substitution** s0 = new KInteger(local_4);
         // *********[78] ILOAD(7)
         // **REMOVED Substitution** s1 = frame.getLocal(7);
         // *********[79] IADD
         // **REMOVED Substitution** index = frame.getLocal(7).intValue();
         // **REMOVED Substitution** s0 = new KInteger((local_4 + frame.getLocal(7).intValue()));
         // *********[80] ISTORE(4)
        local_4 = (local_4 + frame.getLocal(7).intValue());
         // *********[81] IINC(3,1)
         // **REMOVED Substitution** local_3 = (local_3 + 1);
        frame.setLocal(3,new KInteger((local_3 + 1)));
        frame.setLocal(4,new KInteger(local_4));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[77] ILOAD(4)
         // *********[78] ILOAD(7)
         // *********[79] IADD
         // *********[80] ISTORE(4)
         // *********[81] IINC(3,1)
        c_next = instructions[(index + 1)];
      }
}
