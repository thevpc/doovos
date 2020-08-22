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
 * [count=3] [0] ALOAD(0) [1] GETFIELD(jnt.Bench.Bench,specpos,I) [2] IFLT(8)
 */
public final class insertEntry_001 extends JJITAbstractInstruction implements Cloneable{
      private KField c_specpos = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[0] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[1] GETFIELD(jnt.Bench.Bench,specpos,I)
         // **REMOVED Substitution** s0 = new KInteger(c_specpos.getInstanceInt(((KReference)frame.getLocal(0))));
         // *********[2] IFLT(8)
         // **REMOVED Substitution** index = c_specpos.getInstanceInt(((KReference)frame.getLocal(0)));
         // **REMOVED Substitution** jump = c_specpos.getInstanceInt(((KReference)frame.getLocal(0))) < 0;
        return ((c_specpos.getInstanceInt(((KReference)frame.getLocal(0))) < 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] GETFIELD(jnt.Bench.Bench,specpos,I)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_specpos = c_CBench.getField("specpos",true);
         // *********[2] IFLT(8)
        c_next = instructions[(index + 1)];
        c_label = instructions[4];
      }
}
