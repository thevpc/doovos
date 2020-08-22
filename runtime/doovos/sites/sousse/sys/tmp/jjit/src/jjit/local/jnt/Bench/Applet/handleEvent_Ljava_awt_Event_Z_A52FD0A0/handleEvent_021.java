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
 * [count=3] [52] ICONST_M1(Integer{-1}) [53] ISTORE(2) [54] GOTO(59)
 */
public final class handleEvent_021 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_2 2 ; r=0/w=1 : NotCached
         // *********[52] ICONST_M1(Integer{-1})
         // **REMOVED Substitution** s0 = IM1;
         // *********[53] ISTORE(2)
        frame.setLocal(2,KInteger.M1);
         // *********[54] GOTO(59)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[52] ICONST_M1(Integer{-1})
         // *********[53] ISTORE(2)
         // *********[54] GOTO(59)
        c_label = instructions[23];
      }
}
