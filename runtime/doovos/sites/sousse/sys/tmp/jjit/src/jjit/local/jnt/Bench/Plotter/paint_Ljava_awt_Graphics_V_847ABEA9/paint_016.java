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
 * [count=4] [44] DUP [45] ISTORE(4) [46] ILOAD(8) [47] IF_ICMPLE(50)
 */
public final class paint_016 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_4 4 ; r=0/w=1 : NotCached
         // local_8 8 ; r=1/w=0 : NotCached
         // *********[44] DUP
         // **REMOVED Substitution** s0 = frame.peek();
         // *********[45] ISTORE(4)
        frame.setLocal(4,frame.peek());
         // *********[46] ILOAD(8)
         // **REMOVED Substitution** s0 = frame.getLocal(8);
         // *********[47] IF_ICMPLE(50)
        index = frame.getLocal(8).intValue();
         // **REMOVED Substitution** jump = frame.popInt() <= index;
        return ((frame.popInt() <= index)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[44] DUP
         // *********[45] ISTORE(4)
         // *********[46] ILOAD(8)
         // *********[47] IF_ICMPLE(50)
        c_next = instructions[(index + 1)];
        c_label = instructions[17];
      }
}
