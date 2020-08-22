package jjit.local.jnt.scimark2.Random.initialize_I_V_EB929367;
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
 * initialize(I)V
 * [count=15] [17] SIPUSH(Integer{9069}) [18] ISTORE(3) [19] ICONST_0(Integer{0}) [20] ISTORE(4) [21] ILOAD(2) [22] LDC(11->"65536") [23] IREM [24] ISTORE(5) [25] ILOAD(2) [26] LDC(11->"65536") [27] IDIV [28] ISTORE(6) [29] ICONST_0(Integer{0}) [30] ISTORE(7) [31] GOTO(64)
 */
public final class initialize_003 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // local_2 2 ; r=2/w=0 : Cached
        int local_2 = frame.getLocal(2).intValue();
         // local_3 3 ; r=0/w=1 : NotCached
         // local_4 4 ; r=0/w=1 : NotCached
         // local_5 5 ; r=0/w=1 : NotCached
         // local_6 6 ; r=0/w=1 : NotCached
         // local_7 7 ; r=0/w=1 : NotCached
         // *********[17] SIPUSH(Integer{9069})
         // **REMOVED Substitution** s0 = I9069;
         // *********[18] ISTORE(3)
        frame.setLocal(3,new KInteger(9069));
         // *********[19] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[20] ISTORE(4)
        frame.setLocal(4,KInteger.ZERO);
         // *********[21] ILOAD(2)
         // **REMOVED Substitution** s0 = new KInteger(local_2);
         // *********[22] LDC(11->"65536")
         // **REMOVED Substitution** s1 = I65536;
         // *********[23] IREM
         // **REMOVED Substitution** index = 65536;
         // **REMOVED Substitution** s0 = new KInteger((local_2 % 65536));
         // *********[24] ISTORE(5)
        frame.setLocal(5,new KInteger((local_2 % 65536)));
         // *********[25] ILOAD(2)
         // **REMOVED Substitution** s0 = new KInteger(local_2);
         // *********[26] LDC(11->"65536")
         // **REMOVED Substitution** s1 = I65536;
         // *********[27] IDIV
         // **REMOVED Substitution** index = 65536;
         // **REMOVED Substitution** s0 = new KInteger((local_2 / 65536));
         // *********[28] ISTORE(6)
        frame.setLocal(6,new KInteger((local_2 / 65536)));
         // *********[29] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[30] ISTORE(7)
        frame.setLocal(7,KInteger.ZERO);
         // *********[31] GOTO(64)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[17] SIPUSH(Integer{9069})
         // *********[18] ISTORE(3)
         // *********[19] ICONST_0(Integer{0})
         // *********[20] ISTORE(4)
         // *********[21] ILOAD(2)
         // *********[22] LDC(11->"65536")
         // *********[23] IREM
         // *********[24] ISTORE(5)
         // *********[25] ILOAD(2)
         // *********[26] LDC(11->"65536")
         // *********[27] IDIV
         // *********[28] ISTORE(6)
         // *********[29] ICONST_0(Integer{0})
         // *********[30] ISTORE(7)
         // *********[31] GOTO(64)
        c_label = instructions[4];
      }
}
