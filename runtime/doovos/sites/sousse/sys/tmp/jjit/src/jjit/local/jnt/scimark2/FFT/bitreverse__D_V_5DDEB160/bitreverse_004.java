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
 * [count=8] [66] ILOAD(4) [67] ILOAD(7) [68] ISUB [69] ISTORE(4) [70] ILOAD(7) [71] ICONST_1(Integer{1}) [72] ISHR [73] ISTORE(7)
 */
public final class bitreverse_004 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // local_4 4 ; r=1/w=1 : Cached
        int local_4 = frame.getLocal(4).intValue();
         // local_7 7 ; r=2/w=1 : Cached
        int local_7 = frame.getLocal(7).intValue();
         // *********[66] ILOAD(4)
         // **REMOVED Substitution** s0 = new KInteger(local_4);
         // *********[67] ILOAD(7)
         // **REMOVED Substitution** s1 = new KInteger(local_7);
         // *********[68] ISUB
         // **REMOVED Substitution** index = local_7;
         // **REMOVED Substitution** s0 = new KInteger((local_4 - local_7));
         // *********[69] ISTORE(4)
         // **REMOVED Substitution** local_4 = (local_4 - local_7);
         // *********[70] ILOAD(7)
         // **REMOVED Substitution** s0 = new KInteger(local_7);
         // *********[71] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[72] ISHR
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s0 = new KInteger((local_7 >> 1));
         // *********[73] ISTORE(7)
         // **REMOVED Substitution** local_7 = (local_7 >> 1);
        frame.setLocal(4,new KInteger((local_4 - local_7)));
        frame.setLocal(7,new KInteger((local_7 >> 1)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[66] ILOAD(4)
         // *********[67] ILOAD(7)
         // *********[68] ISUB
         // *********[69] ISTORE(4)
         // *********[70] ILOAD(7)
         // *********[71] ICONST_1(Integer{1})
         // *********[72] ISHR
         // *********[73] ISTORE(7)
        c_next = instructions[(index + 1)];
      }
}
