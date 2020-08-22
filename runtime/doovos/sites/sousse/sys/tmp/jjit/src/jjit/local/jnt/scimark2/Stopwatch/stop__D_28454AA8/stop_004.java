package jjit.local.jnt.scimark2.Stopwatch.stop__D_28454AA8;
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
 * jnt.scimark2.Stopwatch
 * stop()D
 * [count=3] [15] ALOAD(0) [16] GETFIELD(jnt.scimark2.Stopwatch,total,D) [17] DRETURN
 */
public final class stop_004 extends JJITAbstractInstruction implements Cloneable{
      private KField c_total = null;
      private KClassRepository c_repo;
      private KClass c_CStopwatch = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KFrame callerFrame = null;
         // **REMOVED Unused Var** KRegister reg;
        KLocalThread thread = frame.getThread();
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[15] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[16] GETFIELD(jnt.scimark2.Stopwatch,total,D)
         // **REMOVED Substitution** s0 = new KDouble(c_total.getInstanceDouble(((KReference)frame.getLocal(0))));
         // *********[17] DRETURN
         // **REMOVED Substitution** reg = new KDouble(c_total.getInstanceDouble(((KReference)frame.getLocal(0))));
        callerFrame = thread.popFrame();
        callerFrame.push(new KDouble(c_total.getInstanceDouble(((KReference)frame.getLocal(0)))));
        return ((JJITInstruction)callerFrame.getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[15] ALOAD(0)
         // *********[16] GETFIELD(jnt.scimark2.Stopwatch,total,D)
        c_repo = process.getClassRepository();
        c_CStopwatch = c_repo.getClassByName("jnt.scimark2.Stopwatch");
        c_total = c_CStopwatch.getField("total",true);
         // *********[17] DRETURN
      }
}
