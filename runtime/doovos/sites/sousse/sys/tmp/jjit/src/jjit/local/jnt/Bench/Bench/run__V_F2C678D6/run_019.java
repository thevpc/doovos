package jjit.local.jnt.Bench.Bench.run__V_F2C678D6;
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
 * jnt.Bench.Bench
 * run()V
 * [count=3] [34] ALOAD(0) [35] GETFIELD(jnt.Bench.Bench,applet,Ljnt/Bench/Applet;) [36] IFNULL(42)
 */
public final class run_019 extends JJITAbstractInstruction implements Cloneable{
      private KField c_applet = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KReference s0_ref;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[34] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[35] GETFIELD(jnt.Bench.Bench,applet,Ljnt/Bench/Applet;)
         // **REMOVED Substitution** s0_ref = c_applet.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[36] IFNULL(42)
        return ((c_applet.getInstanceRef(((KReference)frame.getLocal(0))).isNull())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[34] ALOAD(0)
         // *********[35] GETFIELD(jnt.Bench.Bench,applet,Ljnt/Bench/Applet;)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_applet = c_CBench.getField("applet",true);
         // *********[36] IFNULL(42)
        c_next = instructions[(index + 1)];
        c_label = instructions[22];
      }
}
