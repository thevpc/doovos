package jjit.local.jnt.Bench.Bench.insertEntry__D_V_B1D8381D;
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
 * insertEntry([D)V
 * [count=6] [66] ALOAD(0) [67] DUP [68] GETFIELD(jnt.Bench.Bench,specpos,I) [69] ICONST_1(Integer{1}) [70] IADD [71] PUTFIELD(jnt.Bench.Bench,specpos)
 */
public final class insertEntry_018 extends JJITAbstractInstruction implements Cloneable{
      private KField c_specpos = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KRegister reg;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[66] ALOAD(0)
        s0 = frame.getLocal(0);
         // *********[67] DUP
         // **REMOVED Substitution** s1 = s0;
         // *********[68] GETFIELD(jnt.Bench.Bench,specpos,I)
         // **REMOVED Substitution** s1 = new KInteger(c_specpos.getInstanceInt(((KReference)s0)));
         // *********[69] ICONST_1(Integer{1})
         // **REMOVED Substitution** s2 = IONE;
         // *********[70] IADD
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s1 = new KInteger((c_specpos.getInstanceInt(((KReference)s0)) + 1));
         // *********[71] PUTFIELD(jnt.Bench.Bench,specpos)
         // **REMOVED Substitution** reg = new KInteger((c_specpos.getInstanceInt(((KReference)s0)) + 1));
         // **REMOVED Substitution** ref = ((KReference)s0);
        c_specpos.setInstanceInt(((KReference)s0),(c_specpos.getInstanceInt(((KReference)s0)) + 1));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[66] ALOAD(0)
         // *********[67] DUP
         // *********[68] GETFIELD(jnt.Bench.Bench,specpos,I)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_specpos = c_CBench.getField("specpos",true);
         // *********[69] ICONST_1(Integer{1})
         // *********[70] IADD
         // *********[71] PUTFIELD(jnt.Bench.Bench,specpos)
        c_next = instructions[(index + 1)];
      }
}
