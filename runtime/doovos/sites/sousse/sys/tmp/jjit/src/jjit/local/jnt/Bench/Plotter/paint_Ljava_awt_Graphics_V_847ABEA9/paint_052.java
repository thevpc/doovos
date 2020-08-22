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
 * [count=3] [325] ILOAD(35) [326] ILOAD(34) [327] IF_ICMPLE(306)
 */
public final class paint_052 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_34 34 ; r=1/w=0 : NotCached
         // local_35 35 ; r=1/w=0 : NotCached
         // *********[325] ILOAD(35)
         // **REMOVED Substitution** s0 = frame.getLocal(35);
         // *********[326] ILOAD(34)
         // **REMOVED Substitution** s1 = frame.getLocal(34);
         // *********[327] IF_ICMPLE(306)
         // **REMOVED Substitution** index = frame.getLocal(34).intValue();
         // **REMOVED Substitution** jump = frame.getLocal(35).intValue() <= frame.getLocal(34).intValue();
        return ((frame.getLocal(35).intValue() <= frame.getLocal(34).intValue())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[325] ILOAD(35)
         // *********[326] ILOAD(34)
         // *********[327] IF_ICMPLE(306)
        c_next = instructions[(index + 1)];
        c_label = instructions[49];
      }
}
