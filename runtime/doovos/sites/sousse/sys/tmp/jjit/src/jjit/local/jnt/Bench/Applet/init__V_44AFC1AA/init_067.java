package jjit.local.jnt.Bench.Applet.init__V_44AFC1AA;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Applet
 * init()V
 * [count=6] [177] ALOAD(0) [178] GETFIELD(jnt.Bench.Applet,plotter,Ljnt/Bench/Plotter;) [179] ALOAD(0) [180] LDC(70->"PLOTTER_BAR") [181] GETSTATIC(java.awt.Color,yellow,Ljava/awt/Color;) [182] INVOKEVIRTUAL(jnt.Bench.Applet,getColor(Ljava/lang/String;Ljava/awt/Color;)Ljava/awt/Color;)
 */
public final class init_067 extends JJITAbstractInstruction implements Cloneable{
      private KField c_plotter = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private static KReference R70 = null;
      private KField c_yellow = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KReference s0_ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[177] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[178] GETFIELD(jnt.Bench.Applet,plotter,Ljnt/Bench/Plotter;)
        frame.push(c_plotter.getInstanceRef(this_ref));
         // *********[179] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[180] LDC(70->"PLOTTER_BAR")
         // **REMOVED Substitution** s1_ref = R70;
         // *********[181] GETSTATIC(java.awt.Color,yellow,Ljava/awt/Color;)
        if(c_yellow == null){
          c_yellow = c_repo.getClassByName("java.awt.Color").getField("yellow",true);
        }
         // **REMOVED Substitution** s2 = c_yellow.getStaticValue();
         // *********[182] INVOKEVIRTUAL(jnt.Bench.Applet,getColor(Ljava/lang/String;Ljava/awt/Color;)Ljava/awt/Color;)
        regs = new KRegister[3];
        regs[2] = c_yellow.getStaticValue();
        regs[1] = R70;
         // **REMOVED Substitution** ref = this_ref;
        regs[0] = this_ref;
        frame.setProgramCounter(67);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("getColor(Ljava/lang/String;Ljava/awt/Color;)Ljava/awt/Color;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("getColor(Ljava/lang/String;Ljava/awt/Color;)Ljava/awt/Color;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[177] ALOAD(0)
         // *********[178] GETFIELD(jnt.Bench.Applet,plotter,Ljnt/Bench/Plotter;)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_plotter = c_CApplet.getField("plotter",true);
         // *********[179] ALOAD(0)
         // *********[180] LDC(70->"PLOTTER_BAR")
        R70 = ((KReference)constants[70]);
         // *********[181] GETSTATIC(java.awt.Color,yellow,Ljava/awt/Color;)
        c_repo = process.getClassRepository();
         // *********[182] INVOKEVIRTUAL(jnt.Bench.Applet,getColor(Ljava/lang/String;Ljava/awt/Color;)Ljava/awt/Color;)
        c_memman = process.getMemoryManager();
      }
}
