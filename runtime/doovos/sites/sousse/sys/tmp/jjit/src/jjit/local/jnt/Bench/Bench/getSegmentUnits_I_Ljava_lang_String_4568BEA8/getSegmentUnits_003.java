package jjit.local.jnt.Bench.Bench.getSegmentUnits_I_Ljava_lang_String_4568BEA8;
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
 * getSegmentUnits(I)Ljava/lang/String;
 * [count=2] [4] GETFIELD(jnt.Bench.Segment,units,Ljava/lang/String;) [5] ARETURN
 */
public final class getSegmentUnits_003 extends JJITAbstractInstruction implements Cloneable{
      private KField c_units = null;
      private KClassRepository c_repo;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KFrame callerFrame = null;
         // **REMOVED Unused Var** KRegister reg;
        KLocalThread thread = frame.getThread();
         // *********[4] GETFIELD(jnt.Bench.Segment,units,Ljava/lang/String;)
        if(c_units == null){
          c_units = c_repo.getClassByName("jnt.Bench.Segment").getField("units",true);
        }
         // **REMOVED Substitution** s0 = c_units.getInstanceValue(frame.popRef());
         // *********[5] ARETURN
         // **REMOVED Substitution** reg = c_units.getInstanceValue(frame.popRef());
        callerFrame = thread.popFrame();
        callerFrame.push(c_units.getInstanceValue(frame.popRef()));
        return ((JJITInstruction)callerFrame.getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[4] GETFIELD(jnt.Bench.Segment,units,Ljava/lang/String;)
        c_repo = process.getClassRepository();
         // *********[5] ARETURN
      }
}
