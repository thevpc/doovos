package jjit.local.jnt.scimark2.Random.nextDoubles__D_V_9D9925F2;
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
 * nextDoubles([D)V
 * [count=4] [343] ALOAD(0) [344] BIPUSH(16) [345] PUTFIELD(jnt.scimark2.Random,i) [346] GOTO(353)
 */
public final class nextDoubles_051 extends JJITAbstractInstruction implements Cloneable{
      private KField c_i = null;
      private KClassRepository c_repo;
      private KClass c_CRandom = null;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KRegister reg;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[343] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[344] BIPUSH(16)
         // **REMOVED Substitution** s1 = I16;
         // *********[345] PUTFIELD(jnt.scimark2.Random,i)
         // **REMOVED Substitution** reg = I16;
         // **REMOVED Substitution** ref = ((KReference)frame.getLocal(0));
        c_i.setInstanceInt(((KReference)frame.getLocal(0)),16);
         // *********[346] GOTO(353)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[343] ALOAD(0)
         // *********[344] BIPUSH(16)
         // *********[345] PUTFIELD(jnt.scimark2.Random,i)
        c_repo = process.getClassRepository();
        c_CRandom = c_repo.getClassByName("jnt.scimark2.Random");
        c_i = c_CRandom.getField("i",true);
         // *********[346] GOTO(353)
        c_label = instructions[52];
      }
}
