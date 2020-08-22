package jjit.local.jnt.Bench.Bench.noteStatus_Ljava_lang_String_V_2680032F;
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
 * noteStatus(Ljava/lang/String;)V
 * [count=3] [3] ALOAD(0) [4] GETFIELD(jnt.Bench.Bench,applet,Ljnt/Bench/Applet;) [5] ALOAD(1)
 */
public final class noteStatus_002 extends JJITAbstractInstruction implements Cloneable{
      private KField c_applet = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[3] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[4] GETFIELD(jnt.Bench.Bench,applet,Ljnt/Bench/Applet;)
        frame.push(c_applet.getInstanceRef(((KReference)frame.getLocal(0))));
         // *********[5] ALOAD(1)
        frame.push(frame.getLocal(1));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[3] ALOAD(0)
         // *********[4] GETFIELD(jnt.Bench.Bench,applet,Ljnt/Bench/Applet;)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_applet = c_CBench.getField("applet",true);
         // *********[5] ALOAD(1)
        c_next = instructions[(index + 1)];
      }
}
