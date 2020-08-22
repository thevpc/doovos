package jjit.local.jnt.scimark2.Stopwatch.read__D_C4635912;
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
 * read()D
 * [count=3] [0] ALOAD(0) [1] GETFIELD(jnt.scimark2.Stopwatch,running,Z) [2] IFEQ(15)
 */
public final class read_001 extends JJITAbstractInstruction implements Cloneable{
      private KField c_running = null;
      private KClassRepository c_repo;
      private KClass c_CStopwatch = null;
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[0] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[1] GETFIELD(jnt.scimark2.Stopwatch,running,Z)
         // **REMOVED Substitution** s0 = c_running.getInstanceValue(((KReference)frame.getLocal(0)));
         // *********[2] IFEQ(15)
         // **REMOVED Substitution** index = c_running.getInstanceValue(((KReference)frame.getLocal(0))).intValue();
         // **REMOVED Substitution** jump = c_running.getInstanceValue(((KReference)frame.getLocal(0))).intValue() == 0;
        return ((c_running.getInstanceValue(((KReference)frame.getLocal(0))).intValue() == 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] GETFIELD(jnt.scimark2.Stopwatch,running,Z)
        c_repo = process.getClassRepository();
        c_CStopwatch = c_repo.getClassByName("jnt.scimark2.Stopwatch");
        c_running = c_CStopwatch.getField("running",true);
         // *********[2] IFEQ(15)
        c_next = instructions[(index + 1)];
        c_label = instructions[4];
      }
}
