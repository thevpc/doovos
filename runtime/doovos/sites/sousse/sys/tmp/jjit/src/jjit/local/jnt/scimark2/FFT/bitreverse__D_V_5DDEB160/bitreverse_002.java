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
 * [count=15] [14] ILOAD(3) [15] ICONST_1(Integer{1}) [16] ISHL [17] ISTORE(5) [18] ILOAD(4) [19] ICONST_1(Integer{1}) [20] ISHL [21] ISTORE(6) [22] ILOAD(1) [23] ICONST_1(Integer{1}) [24] ISHR [25] ISTORE(7) [26] ILOAD(3) [27] ILOAD(4) [28] IF_ICMPGE(74)
 */
public final class bitreverse_002 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_1 1 ; r=1/w=0 : NotCached
         // local_3 3 ; r=2/w=0 : Cached
        int local_3 = frame.getLocal(3).intValue();
         // local_4 4 ; r=2/w=0 : Cached
        int local_4 = frame.getLocal(4).intValue();
         // local_5 5 ; r=0/w=1 : NotCached
         // local_6 6 ; r=0/w=1 : NotCached
         // local_7 7 ; r=0/w=1 : NotCached
         // *********[14] ILOAD(3)
         // **REMOVED Substitution** s0 = new KInteger(local_3);
         // *********[15] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[16] ISHL
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s0 = new KInteger((local_3 << 1));
         // *********[17] ISTORE(5)
        frame.setLocal(5,new KInteger((local_3 << 1)));
         // *********[18] ILOAD(4)
         // **REMOVED Substitution** s0 = new KInteger(local_4);
         // *********[19] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[20] ISHL
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s0 = new KInteger((local_4 << 1));
         // *********[21] ISTORE(6)
        frame.setLocal(6,new KInteger((local_4 << 1)));
         // *********[22] ILOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[23] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[24] ISHR
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s0 = new KInteger((frame.getLocal(1).intValue() >> 1));
         // *********[25] ISTORE(7)
        frame.setLocal(7,new KInteger((frame.getLocal(1).intValue() >> 1)));
         // *********[26] ILOAD(3)
         // **REMOVED Substitution** s0 = new KInteger(local_3);
         // *********[27] ILOAD(4)
         // **REMOVED Substitution** s1 = new KInteger(local_4);
         // *********[28] IF_ICMPGE(74)
         // **REMOVED Substitution** index = local_4;
         // **REMOVED Substitution** jump = local_3 >= local_4;
        return ((local_3 >= local_4)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[14] ILOAD(3)
         // *********[15] ICONST_1(Integer{1})
         // *********[16] ISHL
         // *********[17] ISTORE(5)
         // *********[18] ILOAD(4)
         // *********[19] ICONST_1(Integer{1})
         // *********[20] ISHL
         // *********[21] ISTORE(6)
         // *********[22] ILOAD(1)
         // *********[23] ICONST_1(Integer{1})
         // *********[24] ISHR
         // *********[25] ISTORE(7)
         // *********[26] ILOAD(3)
         // *********[27] ILOAD(4)
         // *********[28] IF_ICMPGE(74)
        c_next = instructions[(index + 1)];
        c_label = instructions[4];
      }
}
