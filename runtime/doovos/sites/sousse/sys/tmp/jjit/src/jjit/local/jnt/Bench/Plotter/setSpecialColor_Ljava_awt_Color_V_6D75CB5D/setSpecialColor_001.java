package jjit.local.jnt.Bench.Plotter.setSpecialColor_Ljava_awt_Color_V_6D75CB5D;
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
 * setSpecialColor(Ljava/awt/Color;)V
 * [count=4] [0] ALOAD(0) [1] ALOAD(1) [2] PUTFIELD(jnt.Bench.Plotter,specColor) [3] RETURN
 */
public final class setSpecialColor_001 extends JJITAbstractInstruction implements Cloneable{
      private KField c_specColor = null;
      private KClassRepository c_repo;
      private KClass c_CPlotter = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KRegister reg;
         // **REMOVED Unused Var** KFrame callerFrame = null;
        KLocalThread thread = frame.getThread();
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[0] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[1] ALOAD(1)
         // **REMOVED Substitution** s1 = frame.getLocal(1);
         // *********[2] PUTFIELD(jnt.Bench.Plotter,specColor)
         // **REMOVED Substitution** reg = frame.getLocal(1);
         // **REMOVED Substitution** ref = ((KReference)frame.getLocal(0));
        c_specColor.setInstanceValue(((KReference)frame.getLocal(0)),frame.getLocal(1));
         // *********[3] RETURN
         // **REMOVED Substitution** callerFrame = thread.popFrame();
        return ((JJITInstruction)thread.popFrame().getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] ALOAD(1)
         // *********[2] PUTFIELD(jnt.Bench.Plotter,specColor)
        c_repo = process.getClassRepository();
        c_CPlotter = c_repo.getClassByName("jnt.Bench.Plotter");
        c_specColor = c_CPlotter.getField("specColor",true);
         // *********[3] RETURN
      }
}
