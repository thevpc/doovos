package jjit.local.jnt.Bench.Plotter.paint_Ljava_awt_Graphics_V_847ABEA9;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Plotter
 * paint(Ljava/awt/Graphics;)V
 * [count=3] [75] ILOAD(13) [76] ILOAD(3) [77] IF_ICMPLT(38)
 */
public final class paint_023 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_3 3 ; r=1/w=0 : NotCached
         // local_13 13 ; r=1/w=0 : NotCached
         // *********[75] ILOAD(13)
         // **REMOVED Substitution** s0 = frame.getLocal(13);
         // *********[76] ILOAD(3)
         // **REMOVED Substitution** s1 = frame.getLocal(3);
         // *********[77] IF_ICMPLT(38)
         // **REMOVED Substitution** index = frame.getLocal(3).intValue();
         // **REMOVED Substitution** jump = frame.getLocal(13).intValue() < frame.getLocal(3).intValue();
        return ((frame.getLocal(13).intValue() < frame.getLocal(3).intValue())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[75] ILOAD(13)
         // *********[76] ILOAD(3)
         // *********[77] IF_ICMPLT(38)
        c_next = instructions[(index + 1)];
        c_label = instructions[14];
      }
}
