package jjit.local.jnt.Bench.Bench.getName__Ljava_lang_String_10D2AC1C;
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
 * getName()Ljava/lang/String;
 * [count=3] [0] ALOAD(0) [1] GETFIELD(jnt.Bench.Bench,name,Ljava/lang/String;) [2] ARETURN
 */
public final class getName_001 extends JJITAbstractInstruction implements Cloneable{
      private KField c_name = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KReference s0_ref;
        KFrame callerFrame = null;
         // **REMOVED Unused Var** KRegister reg;
        KLocalThread thread = frame.getThread();
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[0] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[1] GETFIELD(jnt.Bench.Bench,name,Ljava/lang/String;)
         // **REMOVED Substitution** s0_ref = c_name.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[2] ARETURN
         // **REMOVED Substitution** reg = c_name.getInstanceRef(((KReference)frame.getLocal(0)));
        callerFrame = thread.popFrame();
        callerFrame.push(c_name.getInstanceRef(((KReference)frame.getLocal(0))));
        return ((JJITInstruction)callerFrame.getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] GETFIELD(jnt.Bench.Bench,name,Ljava/lang/String;)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_name = c_CBench.getField("name",true);
         // *********[2] ARETURN
      }
}
