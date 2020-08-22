package jjit.local.jnt.Bench.Applet.handleEvent_Ljava_awt_Event_Z_A52FD0A0;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Applet
 * handleEvent(Ljava/awt/Event;)Z
 * [count=4] [48] ISTORE(2) [49] ILOAD(2) [50] ICONST_1(Integer{1}) [51] IF_ICMPNE(55)
 */
public final class handleEvent_020 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_2 2 ; r=1/w=1 : Cached
        int local_2;
         // *********[48] ISTORE(2)
        local_2 = frame.popInt();
         // *********[49] ILOAD(2)
         // **REMOVED Substitution** s0 = new KInteger(local_2);
         // *********[50] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[51] IF_ICMPNE(55)
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** jump = local_2 != 1;
        frame.setLocal(2,new KInteger(local_2));
        return ((local_2 != 1)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[48] ISTORE(2)
         // *********[49] ILOAD(2)
         // *********[50] ICONST_1(Integer{1})
         // *********[51] IF_ICMPNE(55)
        c_next = instructions[(index + 1)];
        c_label = instructions[21];
      }
}
