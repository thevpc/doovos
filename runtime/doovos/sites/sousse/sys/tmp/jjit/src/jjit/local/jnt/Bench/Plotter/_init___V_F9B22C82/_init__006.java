package jjit.local.jnt.Bench.Plotter._init___V_F9B22C82;
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
 * <init>()V
 * [count=12] [21] GETSTATIC(java.awt.Color,yellow,Ljava/awt/Color;) [22] PUTFIELD(jnt.Bench.Plotter,barColor) [23] ALOAD(0) [24] GETSTATIC(java.awt.Color,red,Ljava/awt/Color;) [25] PUTFIELD(jnt.Bench.Plotter,specColor) [26] ALOAD(0) [27] GETSTATIC(java.awt.Color,white,Ljava/awt/Color;) [28] PUTFIELD(jnt.Bench.Plotter,bgColor) [29] ALOAD(0) [30] GETSTATIC(java.awt.Color,black,Ljava/awt/Color;) [31] PUTFIELD(jnt.Bench.Plotter,fgColor) [32] RETURN
 */
public final class _init__006 extends JJITAbstractInstruction implements Cloneable{
      private KField c_yellow = null;
      private KClassRepository c_repo;
      private KField c_barColor = null;
      private KClass c_CPlotter = null;
      private KField c_red = null;
      private KField c_specColor = null;
      private KField c_white = null;
      private KField c_bgColor = null;
      private KField c_black = null;
      private KField c_fgColor = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KRegister reg;
         // **REMOVED Unused Var** KFrame callerFrame = null;
        KLocalThread thread = frame.getThread();
         // this_ref 0 ; r=3/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[21] GETSTATIC(java.awt.Color,yellow,Ljava/awt/Color;)
        if(c_yellow == null){
          c_yellow = c_repo.getClassByName("java.awt.Color").getField("yellow",true);
        }
         // **REMOVED Substitution** s0 = c_yellow.getStaticValue();
         // *********[22] PUTFIELD(jnt.Bench.Plotter,barColor)
         // **REMOVED Substitution** reg = c_yellow.getStaticValue();
         // **REMOVED Substitution** ref = frame.popRef();
        c_barColor.setInstanceValue(frame.popRef(),c_yellow.getStaticValue());
         // *********[23] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[24] GETSTATIC(java.awt.Color,red,Ljava/awt/Color;)
        if(c_red == null){
          c_red = c_repo.getClassByName("java.awt.Color").getField("red",true);
        }
         // **REMOVED Substitution** s1 = c_red.getStaticValue();
         // *********[25] PUTFIELD(jnt.Bench.Plotter,specColor)
         // **REMOVED Substitution** reg = c_red.getStaticValue();
         // **REMOVED Substitution** ref = this_ref;
        c_specColor.setInstanceValue(this_ref,c_red.getStaticValue());
         // *********[26] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[27] GETSTATIC(java.awt.Color,white,Ljava/awt/Color;)
        if(c_white == null){
          c_white = c_repo.getClassByName("java.awt.Color").getField("white",true);
        }
         // **REMOVED Substitution** s1 = c_white.getStaticValue();
         // *********[28] PUTFIELD(jnt.Bench.Plotter,bgColor)
         // **REMOVED Substitution** reg = c_white.getStaticValue();
         // **REMOVED Substitution** ref = this_ref;
        c_bgColor.setInstanceValue(this_ref,c_white.getStaticValue());
         // *********[29] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[30] GETSTATIC(java.awt.Color,black,Ljava/awt/Color;)
        if(c_black == null){
          c_black = c_repo.getClassByName("java.awt.Color").getField("black",true);
        }
         // **REMOVED Substitution** s1 = c_black.getStaticValue();
         // *********[31] PUTFIELD(jnt.Bench.Plotter,fgColor)
         // **REMOVED Substitution** reg = c_black.getStaticValue();
         // **REMOVED Substitution** ref = this_ref;
        c_fgColor.setInstanceValue(this_ref,c_black.getStaticValue());
         // *********[32] RETURN
         // **REMOVED Substitution** callerFrame = thread.popFrame();
        return ((JJITInstruction)thread.popFrame().getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[21] GETSTATIC(java.awt.Color,yellow,Ljava/awt/Color;)
        c_repo = process.getClassRepository();
         // *********[22] PUTFIELD(jnt.Bench.Plotter,barColor)
        c_repo = process.getClassRepository();
        c_CPlotter = c_repo.getClassByName("jnt.Bench.Plotter");
        c_barColor = c_CPlotter.getField("barColor",true);
         // *********[23] ALOAD(0)
         // *********[24] GETSTATIC(java.awt.Color,red,Ljava/awt/Color;)
        c_repo = process.getClassRepository();
         // *********[25] PUTFIELD(jnt.Bench.Plotter,specColor)
        c_specColor = c_CPlotter.getField("specColor",true);
         // *********[26] ALOAD(0)
         // *********[27] GETSTATIC(java.awt.Color,white,Ljava/awt/Color;)
        c_repo = process.getClassRepository();
         // *********[28] PUTFIELD(jnt.Bench.Plotter,bgColor)
        c_bgColor = c_CPlotter.getField("bgColor",true);
         // *********[29] ALOAD(0)
         // *********[30] GETSTATIC(java.awt.Color,black,Ljava/awt/Color;)
        c_repo = process.getClassRepository();
         // *********[31] PUTFIELD(jnt.Bench.Plotter,fgColor)
        c_fgColor = c_CPlotter.getField("fgColor",true);
         // *********[32] RETURN
      }
}
