package jjit.local.jnt.scimark2.Random.initialize_I_V_EB929367;
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
 * jnt.scimark2.Random
 * initialize(I)V
 * [count=7] [67] ALOAD(0) [68] ICONST_4(Integer{4}) [69] PUTFIELD(jnt.scimark2.Random,i) [70] ALOAD(0) [71] BIPUSH(16) [72] PUTFIELD(jnt.scimark2.Random,j) [73] RETURN
 */
public final class initialize_006 extends JJITAbstractInstruction implements Cloneable{
      private KField c_i = null;
      private KClassRepository c_repo;
      private KClass c_CRandom = null;
      private KField c_j = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KRegister reg;
         // **REMOVED Unused Var** KFrame callerFrame = null;
        KLocalThread thread = frame.getThread();
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[67] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[68] ICONST_4(Integer{4})
         // **REMOVED Substitution** s1 = IFOUR;
         // *********[69] PUTFIELD(jnt.scimark2.Random,i)
         // **REMOVED Substitution** reg = IFOUR;
         // **REMOVED Substitution** ref = this_ref;
        c_i.setInstanceInt(this_ref,4);
         // *********[70] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[71] BIPUSH(16)
         // **REMOVED Substitution** s1 = I16;
         // *********[72] PUTFIELD(jnt.scimark2.Random,j)
         // **REMOVED Substitution** reg = I16;
         // **REMOVED Substitution** ref = this_ref;
        c_j.setInstanceInt(this_ref,16);
         // *********[73] RETURN
         // **REMOVED Substitution** callerFrame = thread.popFrame();
        return ((JJITInstruction)thread.popFrame().getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[67] ALOAD(0)
         // *********[68] ICONST_4(Integer{4})
         // *********[69] PUTFIELD(jnt.scimark2.Random,i)
        c_repo = process.getClassRepository();
        c_CRandom = c_repo.getClassByName("jnt.scimark2.Random");
        c_i = c_CRandom.getField("i",true);
         // *********[70] ALOAD(0)
         // *********[71] BIPUSH(16)
         // *********[72] PUTFIELD(jnt.scimark2.Random,j)
        c_j = c_CRandom.getField("j",true);
         // *********[73] RETURN
      }
}
