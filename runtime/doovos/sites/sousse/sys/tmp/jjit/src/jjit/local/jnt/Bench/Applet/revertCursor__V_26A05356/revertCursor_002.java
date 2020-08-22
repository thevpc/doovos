package jjit.local.jnt.Bench.Applet.revertCursor__V_26A05356;
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
 * revertCursor()V
 * [count=4] [4] ALOAD(0) [5] GETFIELD(jnt.Bench.Applet,parent,Ljava/awt/Frame;) [6] ALOAD(0) [7] GETFIELD(jnt.Bench.Applet,cursor,I)
 */
public final class revertCursor_002 extends JJITAbstractInstruction implements Cloneable{
      private KField c_parent = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private KField c_cursor = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s0_ref;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[4] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[5] GETFIELD(jnt.Bench.Applet,parent,Ljava/awt/Frame;)
        frame.push(c_parent.getInstanceRef(this_ref));
         // *********[6] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[7] GETFIELD(jnt.Bench.Applet,cursor,I)
        frame.push(new KInteger(c_cursor.getInstanceInt(this_ref)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[4] ALOAD(0)
         // *********[5] GETFIELD(jnt.Bench.Applet,parent,Ljava/awt/Frame;)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_parent = c_CApplet.getField("parent",true);
         // *********[6] ALOAD(0)
         // *********[7] GETFIELD(jnt.Bench.Applet,cursor,I)
        c_cursor = c_CApplet.getField("cursor",true);
        c_next = instructions[(index + 1)];
      }
}
