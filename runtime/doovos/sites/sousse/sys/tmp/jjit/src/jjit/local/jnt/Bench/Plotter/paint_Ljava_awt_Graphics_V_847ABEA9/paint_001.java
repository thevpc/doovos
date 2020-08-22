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
 * [count=3] [0] ALOAD(0) [1] GETFIELD(jnt.Bench.Plotter,labels,[Ljava/lang/String;) [2] IFNULL(7)
 */
public final class paint_001 extends JJITAbstractInstruction implements Cloneable{
      private KField c_labels = null;
      private KClassRepository c_repo;
      private KClass c_CPlotter = null;
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KReference s0_ref;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[0] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[1] GETFIELD(jnt.Bench.Plotter,labels,[Ljava/lang/String;)
         // **REMOVED Substitution** s0_ref = c_labels.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[2] IFNULL(7)
        return ((c_labels.getInstanceRef(((KReference)frame.getLocal(0))).isNull())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] GETFIELD(jnt.Bench.Plotter,labels,[Ljava/lang/String;)
        c_repo = process.getClassRepository();
        c_CPlotter = c_repo.getClassByName("jnt.Bench.Plotter");
        c_labels = c_CPlotter.getField("labels",true);
         // *********[2] IFNULL(7)
        c_next = instructions[(index + 1)];
        c_label = instructions[2];
      }
}
