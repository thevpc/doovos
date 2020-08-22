package jjit.local.jnt.Bench.Entry._init__Ljava_lang_String_D_V_8DCB6CC2;
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
 * jnt.Bench.Entry
 * <init>(Ljava/lang/String;[D)V
 * [count=7] [2] ALOAD(0) [3] ALOAD(1) [4] PUTFIELD(jnt.Bench.Entry,platform) [5] ALOAD(0) [6] ALOAD(2) [7] PUTFIELD(jnt.Bench.Entry,values) [8] RETURN
 */
public final class _init__004 extends JJITAbstractInstruction implements Cloneable{
      private KField c_platform = null;
      private KClassRepository c_repo;
      private KClass c_CEntry = null;
      private KField c_values = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KRegister reg;
         // **REMOVED Unused Var** KFrame callerFrame = null;
        KLocalThread thread = frame.getThread();
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // local_1 1 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[2] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[3] ALOAD(1)
         // **REMOVED Substitution** s1 = frame.getLocal(1);
         // *********[4] PUTFIELD(jnt.Bench.Entry,platform)
         // **REMOVED Substitution** reg = frame.getLocal(1);
         // **REMOVED Substitution** ref = this_ref;
        c_platform.setInstanceValue(this_ref,frame.getLocal(1));
         // *********[5] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[6] ALOAD(2)
         // **REMOVED Substitution** s1 = frame.getLocal(2);
         // *********[7] PUTFIELD(jnt.Bench.Entry,values)
         // **REMOVED Substitution** reg = frame.getLocal(2);
         // **REMOVED Substitution** ref = this_ref;
        c_values.setInstanceValue(this_ref,frame.getLocal(2));
         // *********[8] RETURN
         // **REMOVED Substitution** callerFrame = thread.popFrame();
        return ((JJITInstruction)thread.popFrame().getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[2] ALOAD(0)
         // *********[3] ALOAD(1)
         // *********[4] PUTFIELD(jnt.Bench.Entry,platform)
        c_repo = process.getClassRepository();
        c_CEntry = c_repo.getClassByName("jnt.Bench.Entry");
        c_platform = c_CEntry.getField("platform",true);
         // *********[5] ALOAD(0)
         // *********[6] ALOAD(2)
         // *********[7] PUTFIELD(jnt.Bench.Entry,values)
        c_values = c_CEntry.getField("values",true);
         // *********[8] RETURN
      }
}
