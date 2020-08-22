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
 * [count=4] [72] ALOAD(0) [73] GETFIELD(jnt.Bench.Bench,specpos,I) [74] ILOAD(3) [75] IF_ICMPLT(53)
 */
public final class insertEntry_019 extends JJITAbstractInstruction implements Cloneable{
      private KField c_specpos = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=0 : NotCached
         // *********[72] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[73] GETFIELD(jnt.Bench.Bench,specpos,I)
         // **REMOVED Substitution** s0 = new KInteger(c_specpos.getInstanceInt(((KReference)frame.getLocal(0))));
         // *********[74] ILOAD(3)
         // **REMOVED Substitution** s1 = frame.getLocal(3);
         // *********[75] IF_ICMPLT(53)
         // **REMOVED Substitution** index = frame.getLocal(3).intValue();
         // **REMOVED Substitution** jump = c_specpos.getInstanceInt(((KReference)frame.getLocal(0))) < frame.getLocal(3).intValue();
        return ((c_specpos.getInstanceInt(((KReference)frame.getLocal(0))) < frame.getLocal(3).intValue())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[72] ALOAD(0)
         // *********[73] GETFIELD(jnt.Bench.Bench,specpos,I)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_specpos = c_CBench.getField("specpos",true);
         // *********[74] ILOAD(3)
         // *********[75] IF_ICMPLT(53)
        c_next = instructions[(index + 1)];
        c_label = instructions[14];
      }
}
