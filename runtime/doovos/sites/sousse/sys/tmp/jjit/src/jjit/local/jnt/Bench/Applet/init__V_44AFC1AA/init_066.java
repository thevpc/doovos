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
 * [count=4] [173] ALOAD(0) [174] GETFIELD(jnt.Bench.Applet,plotter,Ljnt/Bench/Plotter;) [175] ALOAD(8) [176] INVOKEVIRTUAL(jnt.Bench.Plotter,setLineColor(Ljava/awt/Color;)V)
 */
public final class init_066 extends JJITAbstractInstruction implements Cloneable{
      private KField c_plotter = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_8 8 ; r=1/w=0 : NotCached
         // *********[173] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[174] GETFIELD(jnt.Bench.Applet,plotter,Ljnt/Bench/Plotter;)
         // **REMOVED Substitution** s0_ref = c_plotter.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[175] ALOAD(8)
         // **REMOVED Substitution** s1 = frame.getLocal(8);
         // *********[176] INVOKEVIRTUAL(jnt.Bench.Plotter,setLineColor(Ljava/awt/Color;)V)
        regs = new KRegister[2];
        regs[1] = frame.getLocal(8);
        ref = c_plotter.getInstanceRef(((KReference)frame.getLocal(0)));
        regs[0] = ref;
        frame.setProgramCounter(66);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("setLineColor(Ljava/awt/Color;)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("setLineColor(Ljava/awt/Color;)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[173] ALOAD(0)
         // *********[174] GETFIELD(jnt.Bench.Applet,plotter,Ljnt/Bench/Plotter;)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_plotter = c_CApplet.getField("plotter",true);
         // *********[175] ALOAD(8)
         // *********[176] INVOKEVIRTUAL(jnt.Bench.Plotter,setLineColor(Ljava/awt/Color;)V)
        c_memman = process.getMemoryManager();
      }
}
