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
 * [count=5] [328] ILOAD(18) [329] INEG [330] ISTORE(4) [331] ILOAD(4) [332] IFGE(335)
 */
public final class paint_053 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_18 18 ; r=1/w=0 : NotCached
         // local_4 4 ; r=1/w=1 : Cached
        int local_4;
         // *********[328] ILOAD(18)
         // **REMOVED Substitution** s0 = frame.getLocal(18);
         // *********[329] INEG
         // **REMOVED Substitution** s0 = new KInteger(-(frame.getLocal(18).intValue()));
         // *********[330] ISTORE(4)
        local_4 = -(frame.getLocal(18).intValue());
         // *********[331] ILOAD(4)
         // **REMOVED Substitution** s0 = new KInteger(local_4);
         // *********[332] IFGE(335)
         // **REMOVED Substitution** index = local_4;
         // **REMOVED Substitution** jump = local_4 >= 0;
        frame.setLocal(4,new KInteger(local_4));
        return ((local_4 >= 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[328] ILOAD(18)
         // *********[329] INEG
         // *********[330] ISTORE(4)
         // *********[331] ILOAD(4)
         // *********[332] IFGE(335)
        c_next = instructions[(index + 1)];
        c_label = instructions[54];
      }
}
