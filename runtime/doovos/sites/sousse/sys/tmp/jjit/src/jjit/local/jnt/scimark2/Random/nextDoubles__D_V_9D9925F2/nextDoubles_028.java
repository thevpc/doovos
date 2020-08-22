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
 * [count=6] [169] ALOAD(0) [170] DUP [171] GETFIELD(jnt.scimark2.Random,i,I) [172] ICONST_1(Integer{1}) [173] ISUB [174] PUTFIELD(jnt.scimark2.Random,i)
 */
public final class nextDoubles_028 extends JJITAbstractInstruction implements Cloneable{
      private KField c_i = null;
      private KClassRepository c_repo;
      private KClass c_CRandom = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KRegister reg;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[169] ALOAD(0)
        s0 = frame.getLocal(0);
         // *********[170] DUP
         // **REMOVED Substitution** s1 = s0;
         // *********[171] GETFIELD(jnt.scimark2.Random,i,I)
         // **REMOVED Substitution** s1 = new KInteger(c_i.getInstanceInt(((KReference)s0)));
         // *********[172] ICONST_1(Integer{1})
         // **REMOVED Substitution** s2 = IONE;
         // *********[173] ISUB
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s1 = new KInteger((c_i.getInstanceInt(((KReference)s0)) - 1));
         // *********[174] PUTFIELD(jnt.scimark2.Random,i)
         // **REMOVED Substitution** reg = new KInteger((c_i.getInstanceInt(((KReference)s0)) - 1));
         // **REMOVED Substitution** ref = ((KReference)s0);
        c_i.setInstanceInt(((KReference)s0),(c_i.getInstanceInt(((KReference)s0)) - 1));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[169] ALOAD(0)
         // *********[170] DUP
         // *********[171] GETFIELD(jnt.scimark2.Random,i,I)
        c_repo = process.getClassRepository();
        c_CRandom = c_repo.getClassByName("jnt.scimark2.Random");
        c_i = c_CRandom.getField("i",true);
         // *********[172] ICONST_1(Integer{1})
         // *********[173] ISUB
         // *********[174] PUTFIELD(jnt.scimark2.Random,i)
        c_next = instructions[(index + 1)];
      }
}
