package jjit.local.jnt.Bench.AppletFrame._init__Ljava_lang_String_V_B2053D6E;
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
 * jnt.Bench.AppletFrame
 * <init>(Ljava/lang/String;)V
 * [count=3] [13] PUTFIELD(jnt.Bench.Applet,bench) [14] ALOAD(0) [15] ALOAD(2)
 */
public final class _init__010 extends JJITAbstractInstruction implements Cloneable{
      private KField c_bench = null;
      private KClassRepository c_repo;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference ref;
        KRegister reg;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[13] PUTFIELD(jnt.Bench.Applet,bench)
        if(c_bench == null){
          c_bench = c_repo.getClassByName("jnt.Bench.Applet").getField("bench",true);
        }
        reg = frame.pop();
         // **REMOVED Substitution** ref = frame.popRef();
        c_bench.setInstanceValue(frame.popRef(),reg);
         // *********[14] ALOAD(0)
        frame.push(frame.getLocal(0));
         // *********[15] ALOAD(2)
        frame.push(frame.getLocal(2));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[13] PUTFIELD(jnt.Bench.Applet,bench)
        c_repo = process.getClassRepository();
         // *********[14] ALOAD(0)
         // *********[15] ALOAD(2)
        c_next = instructions[(index + 1)];
      }
}
