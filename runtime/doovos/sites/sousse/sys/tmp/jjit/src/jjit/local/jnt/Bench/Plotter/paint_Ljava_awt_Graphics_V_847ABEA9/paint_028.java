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
 * [count=3] [129] ILOAD(19) [130] ICONST_2(Integer{2}) [131] IF_ICMPNE(137)
 */
public final class paint_028 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_19 19 ; r=1/w=0 : NotCached
         // *********[129] ILOAD(19)
         // **REMOVED Substitution** s0 = frame.getLocal(19);
         // *********[130] ICONST_2(Integer{2})
         // **REMOVED Substitution** s1 = ITWO;
         // *********[131] IF_ICMPNE(137)
         // **REMOVED Substitution** index = 2;
         // **REMOVED Substitution** jump = frame.getLocal(19).intValue() != 2;
        return ((frame.getLocal(19).intValue() != 2)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[129] ILOAD(19)
         // *********[130] ICONST_2(Integer{2})
         // *********[131] IF_ICMPNE(137)
        c_next = instructions[(index + 1)];
        c_label = instructions[29];
      }
}
