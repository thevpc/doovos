package jjit.local.jnt.Bench.Applet.init__V_44AFC1AA;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Applet
 * init()V
 * [count=6] [127] POP [128] ALOAD(0) [129] GETFIELD(jnt.Bench.Applet,centerPanel,Ljava/awt/Panel;) [130] ALOAD(0) [131] NEW(java.awt.CardLayout) [132] DUP
 */
public final class init_049 extends JJITAbstractInstruction implements Cloneable{
      private KField c_centerPanel = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private KClass c_CCardLayout = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[127] POP
        frame.pop();
         // *********[128] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[129] GETFIELD(jnt.Bench.Applet,centerPanel,Ljava/awt/Panel;)
        frame.push(c_centerPanel.getInstanceRef(this_ref));
         // *********[130] ALOAD(0)
        frame.push(this_ref);
         // *********[131] NEW(java.awt.CardLayout)
        if(c_CCardLayout == null){
          c_CCardLayout = c_repo.getClassByName("java.awt.CardLayout");
        }
        s0_ref = memseg.allocObject(c_CCardLayout);
         // *********[132] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[127] POP
         // *********[128] ALOAD(0)
         // *********[129] GETFIELD(jnt.Bench.Applet,centerPanel,Ljava/awt/Panel;)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_centerPanel = c_CApplet.getField("centerPanel",true);
         // *********[130] ALOAD(0)
         // *********[131] NEW(java.awt.CardLayout)
        c_repo = process.getClassRepository();
         // *********[132] DUP
        c_next = instructions[(index + 1)];
      }
}
