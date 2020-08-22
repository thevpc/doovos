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
 * [count=4] [52] ALOAD(0) [53] GETFIELD(jnt.Bench.Applet,plotter,Ljnt/Bench/Plotter;) [54] ALOAD(0) [55] GETFIELD(jnt.Bench.Applet,bench,Ljnt/Bench/Bench;)
 */
public final class doDisplay_024 extends JJITAbstractInstruction implements Cloneable{
      private KField c_plotter = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private KField c_bench = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s0_ref;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[52] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[53] GETFIELD(jnt.Bench.Applet,plotter,Ljnt/Bench/Plotter;)
        frame.push(c_plotter.getInstanceRef(this_ref));
         // *********[54] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[55] GETFIELD(jnt.Bench.Applet,bench,Ljnt/Bench/Bench;)
        frame.push(c_bench.getInstanceRef(this_ref));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[52] ALOAD(0)
         // *********[53] GETFIELD(jnt.Bench.Applet,plotter,Ljnt/Bench/Plotter;)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_plotter = c_CApplet.getField("plotter",true);
         // *********[54] ALOAD(0)
         // *********[55] GETFIELD(jnt.Bench.Applet,bench,Ljnt/Bench/Bench;)
        c_bench = c_CApplet.getField("bench",true);
        c_next = instructions[(index + 1)];
      }
}
