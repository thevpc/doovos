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
 * [count=6] [137] ALOAD(0) [138] GETFIELD(jnt.Bench.Applet,centerPanel,Ljava/awt/Panel;) [139] LDC(55->"graph") [140] ALOAD(0) [141] NEW(jnt.Bench.Plotter) [142] DUP
 */
public final class init_053 extends JJITAbstractInstruction implements Cloneable{
      private KField c_centerPanel = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private static KReference R55 = null;
      private KClass c_CPlotter = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[137] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[138] GETFIELD(jnt.Bench.Applet,centerPanel,Ljava/awt/Panel;)
        frame.push(c_centerPanel.getInstanceRef(this_ref));
         // *********[139] LDC(55->"graph")
        frame.push(R55);
         // *********[140] ALOAD(0)
        frame.push(this_ref);
         // *********[141] NEW(jnt.Bench.Plotter)
        if(c_CPlotter == null){
          c_CPlotter = c_repo.getClassByName("jnt.Bench.Plotter");
        }
        s0_ref = memseg.allocObject(c_CPlotter);
         // *********[142] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[137] ALOAD(0)
         // *********[138] GETFIELD(jnt.Bench.Applet,centerPanel,Ljava/awt/Panel;)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_centerPanel = c_CApplet.getField("centerPanel",true);
         // *********[139] LDC(55->"graph")
        R55 = ((KReference)constants[55]);
         // *********[140] ALOAD(0)
         // *********[141] NEW(jnt.Bench.Plotter)
        c_repo = process.getClassRepository();
         // *********[142] DUP
        c_next = instructions[(index + 1)];
      }
}
