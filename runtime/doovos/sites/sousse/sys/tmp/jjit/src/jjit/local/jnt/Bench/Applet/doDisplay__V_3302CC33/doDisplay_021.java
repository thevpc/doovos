package jjit.local.jnt.Bench.Applet.doDisplay__V_3302CC33;
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
 * jnt.Bench.Applet
 * doDisplay()V
 * [count=5] [46] ALOAD(0) [47] GETFIELD(jnt.Bench.Applet,flipper,Ljava/awt/CardLayout;) [48] ALOAD(0) [49] GETFIELD(jnt.Bench.Applet,centerPanel,Ljava/awt/Panel;) [50] LDC(55->"graph")
 */
public final class doDisplay_021 extends JJITAbstractInstruction implements Cloneable{
      private KField c_flipper = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private KField c_centerPanel = null;
      private static KReference R55 = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s0_ref;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[46] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[47] GETFIELD(jnt.Bench.Applet,flipper,Ljava/awt/CardLayout;)
        frame.push(c_flipper.getInstanceRef(this_ref));
         // *********[48] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[49] GETFIELD(jnt.Bench.Applet,centerPanel,Ljava/awt/Panel;)
        frame.push(c_centerPanel.getInstanceRef(this_ref));
         // *********[50] LDC(55->"graph")
        frame.push(R55);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[46] ALOAD(0)
         // *********[47] GETFIELD(jnt.Bench.Applet,flipper,Ljava/awt/CardLayout;)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_flipper = c_CApplet.getField("flipper",true);
         // *********[48] ALOAD(0)
         // *********[49] GETFIELD(jnt.Bench.Applet,centerPanel,Ljava/awt/Panel;)
        c_centerPanel = c_CApplet.getField("centerPanel",true);
         // *********[50] LDC(55->"graph")
        R55 = ((KReference)constants[55]);
        c_next = instructions[(index + 1)];
      }
}
