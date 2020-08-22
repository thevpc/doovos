package jjit.local.jnt.Bench.Applet.waitCursor__V_6A2B968E;
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
 * waitCursor()V
 * [count=3] [19] ALOAD(0) [20] GETFIELD(jnt.Bench.Applet,parent,Ljava/awt/Frame;) [21] IFNULL(31)
 */
public final class waitCursor_011 extends JJITAbstractInstruction implements Cloneable{
      private KField c_parent = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KReference s0_ref;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[19] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[20] GETFIELD(jnt.Bench.Applet,parent,Ljava/awt/Frame;)
         // **REMOVED Substitution** s0_ref = c_parent.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[21] IFNULL(31)
        return ((c_parent.getInstanceRef(((KReference)frame.getLocal(0))).isNull())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[19] ALOAD(0)
         // *********[20] GETFIELD(jnt.Bench.Applet,parent,Ljava/awt/Frame;)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_parent = c_CApplet.getField("parent",true);
         // *********[21] IFNULL(31)
        c_next = instructions[(index + 1)];
        c_label = instructions[13];
      }
}
