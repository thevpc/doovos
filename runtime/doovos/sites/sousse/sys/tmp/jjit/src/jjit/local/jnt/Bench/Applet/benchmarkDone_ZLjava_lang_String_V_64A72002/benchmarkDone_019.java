package jjit.local.jnt.Bench.Applet.benchmarkDone_ZLjava_lang_String_V_64A72002;
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
 * benchmarkDone(ZLjava/lang/String;)V
 * [count=4] [28] ALOAD(0) [29] ACONST_NULL [30] PUTFIELD(jnt.Bench.Applet,thread) [31] RETURN
 */
public final class benchmarkDone_019 extends JJITAbstractInstruction implements Cloneable{
      private KField c_thread = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KRegister reg;
         // **REMOVED Unused Var** KFrame callerFrame = null;
        KLocalThread thread = frame.getThread();
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[28] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[29] ACONST_NULL
         // **REMOVED Substitution** s1_ref = KReference.NULL;
         // *********[30] PUTFIELD(jnt.Bench.Applet,thread)
         // **REMOVED Substitution** reg = KReference.NULL;
         // **REMOVED Substitution** ref = ((KReference)frame.getLocal(0));
        c_thread.setInstanceValue(((KReference)frame.getLocal(0)),KReference.NULL);
         // *********[31] RETURN
         // **REMOVED Substitution** callerFrame = thread.popFrame();
        return ((JJITInstruction)thread.popFrame().getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[28] ALOAD(0)
         // *********[29] ACONST_NULL
         // *********[30] PUTFIELD(jnt.Bench.Applet,thread)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_thread = c_CApplet.getField("thread",true);
         // *********[31] RETURN
      }
}
