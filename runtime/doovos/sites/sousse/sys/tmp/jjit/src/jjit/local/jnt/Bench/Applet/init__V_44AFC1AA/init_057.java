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
 * [count=7] [147] POP [148] ALOAD(0) [149] GETFIELD(jnt.Bench.Applet,centerPanel,Ljava/awt/Panel;) [150] LDC(60->"table") [151] ALOAD(0) [152] NEW(java.awt.List) [153] DUP
 */
public final class init_057 extends JJITAbstractInstruction implements Cloneable{
      private KField c_centerPanel = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private static KReference R60 = null;
      private KClass c_CList = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[147] POP
        frame.pop();
         // *********[148] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[149] GETFIELD(jnt.Bench.Applet,centerPanel,Ljava/awt/Panel;)
        frame.push(c_centerPanel.getInstanceRef(this_ref));
         // *********[150] LDC(60->"table")
        frame.push(R60);
         // *********[151] ALOAD(0)
        frame.push(this_ref);
         // *********[152] NEW(java.awt.List)
        if(c_CList == null){
          c_CList = c_repo.getClassByName("java.awt.List");
        }
        s0_ref = memseg.allocObject(c_CList);
         // *********[153] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[147] POP
         // *********[148] ALOAD(0)
         // *********[149] GETFIELD(jnt.Bench.Applet,centerPanel,Ljava/awt/Panel;)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_centerPanel = c_CApplet.getField("centerPanel",true);
         // *********[150] LDC(60->"table")
        R60 = ((KReference)constants[60]);
         // *********[151] ALOAD(0)
         // *********[152] NEW(java.awt.List)
        c_repo = process.getClassRepository();
         // *********[153] DUP
        c_next = instructions[(index + 1)];
      }
}
