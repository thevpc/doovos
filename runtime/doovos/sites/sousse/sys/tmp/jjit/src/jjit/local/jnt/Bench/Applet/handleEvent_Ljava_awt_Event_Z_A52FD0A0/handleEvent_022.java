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
 * [count=3] [55] ILOAD(2) [56] ICONST_1(Integer{1}) [57] IF_ICMPLE(59)
 */
public final class handleEvent_022 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[55] ILOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[56] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[57] IF_ICMPLE(59)
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** jump = frame.getLocal(2).intValue() <= 1;
        return ((frame.getLocal(2).intValue() <= 1)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[55] ILOAD(2)
         // *********[56] ICONST_1(Integer{1})
         // *********[57] IF_ICMPLE(59)
        c_next = instructions[(index + 1)];
        c_label = instructions[23];
      }
}
