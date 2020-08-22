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
 * [count=4] [49] ALOAD(0) [50] ICONST_0(Integer{0}) [51] PUTFIELD(jnt.Bench.Bench,specpos) [52] GOTO(72)
 */
public final class insertEntry_014 extends JJITAbstractInstruction implements Cloneable{
      private KField c_specpos = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KRegister reg;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[49] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[50] ICONST_0(Integer{0})
         // **REMOVED Substitution** s1 = IZERO;
         // *********[51] PUTFIELD(jnt.Bench.Bench,specpos)
         // **REMOVED Substitution** reg = IZERO;
         // **REMOVED Substitution** ref = ((KReference)frame.getLocal(0));
        c_specpos.setInstanceInt(((KReference)frame.getLocal(0)),0);
         // *********[52] GOTO(72)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[49] ALOAD(0)
         // *********[50] ICONST_0(Integer{0})
         // *********[51] PUTFIELD(jnt.Bench.Bench,specpos)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_specpos = c_CBench.getField("specpos",true);
         // *********[52] GOTO(72)
        c_label = instructions[18];
      }
}
