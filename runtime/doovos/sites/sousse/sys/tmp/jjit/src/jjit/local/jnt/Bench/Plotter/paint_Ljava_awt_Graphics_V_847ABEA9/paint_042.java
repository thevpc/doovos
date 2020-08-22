package jjit.local.jnt.Bench.Plotter.paint_Ljava_awt_Graphics_V_847ABEA9;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Plotter
 * paint(Ljava/awt/Graphics;)V
 * [count=3] [256] ALOAD(0) [257] GETFIELD(jnt.Bench.Plotter,specColor,Ljava/awt/Color;) [258] GOTO(261)
 */
public final class paint_042 extends JJITAbstractInstruction implements Cloneable{
      private KField c_specColor = null;
      private KClassRepository c_repo;
      private KClass c_CPlotter = null;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[256] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[257] GETFIELD(jnt.Bench.Plotter,specColor,Ljava/awt/Color;)
        frame.push(c_specColor.getInstanceRef(((KReference)frame.getLocal(0))));
         // *********[258] GOTO(261)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[256] ALOAD(0)
         // *********[257] GETFIELD(jnt.Bench.Plotter,specColor,Ljava/awt/Color;)
        c_repo = process.getClassRepository();
        c_CPlotter = c_repo.getClassByName("jnt.Bench.Plotter");
        c_specColor = c_CPlotter.getField("specColor",true);
         // *********[258] GOTO(261)
        c_label = instructions[43];
      }
}
