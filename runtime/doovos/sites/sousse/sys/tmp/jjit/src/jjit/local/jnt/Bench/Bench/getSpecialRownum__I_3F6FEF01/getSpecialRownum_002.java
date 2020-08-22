package jjit.local.jnt.Bench.Bench.getSpecialRownum__I_3F6FEF01;
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
 * getSpecialRownum()I
 * [count=5] [3] ICONST_2(Integer{2}) [4] ALOAD(0) [5] GETFIELD(jnt.Bench.Bench,specpos,I) [6] IADD [7] GOTO(9)
 */
public final class getSpecialRownum_002 extends JJITAbstractInstruction implements Cloneable{
      private KField c_specpos = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[3] ICONST_2(Integer{2})
         // **REMOVED Substitution** s0 = ITWO;
         // *********[4] ALOAD(0)
         // **REMOVED Substitution** s1 = frame.getLocal(0);
         // *********[5] GETFIELD(jnt.Bench.Bench,specpos,I)
         // **REMOVED Substitution** s1 = new KInteger(c_specpos.getInstanceInt(((KReference)frame.getLocal(0))));
         // *********[6] IADD
         // **REMOVED Substitution** index = c_specpos.getInstanceInt(((KReference)frame.getLocal(0)));
        frame.push(new KInteger((2 + c_specpos.getInstanceInt(((KReference)frame.getLocal(0))))));
         // *********[7] GOTO(9)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[3] ICONST_2(Integer{2})
         // *********[4] ALOAD(0)
         // *********[5] GETFIELD(jnt.Bench.Bench,specpos,I)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_specpos = c_CBench.getField("specpos",true);
         // *********[6] IADD
         // *********[7] GOTO(9)
        c_label = instructions[3];
      }
}
