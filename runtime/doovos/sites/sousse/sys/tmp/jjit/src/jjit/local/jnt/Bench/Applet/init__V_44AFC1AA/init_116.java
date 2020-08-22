package jjit.local.jnt.Bench.Applet.init__V_44AFC1AA;
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
 * init()V
 * [count=4] [354] ASTORE(9) [355] ALOAD(0) [356] GETFIELD(jnt.Bench.Applet,status,Ljava/awt/Label;) [357] ALOAD(9)
 */
public final class init_116 extends JJITAbstractInstruction implements Cloneable{
      private KField c_status = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_9 9 ; r=1/w=1 : Cached
        KRegister local_9;
         // *********[354] ASTORE(9)
        local_9 = frame.pop();
         // *********[355] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[356] GETFIELD(jnt.Bench.Applet,status,Ljava/awt/Label;)
        frame.push(c_status.getInstanceRef(((KReference)frame.getLocal(0))));
         // *********[357] ALOAD(9)
        frame.push(local_9);
        frame.setLocal(9,local_9);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[354] ASTORE(9)
         // *********[355] ALOAD(0)
         // *********[356] GETFIELD(jnt.Bench.Applet,status,Ljava/awt/Label;)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_status = c_CApplet.getField("status",true);
         // *********[357] ALOAD(9)
        c_next = instructions[(index + 1)];
      }
}
