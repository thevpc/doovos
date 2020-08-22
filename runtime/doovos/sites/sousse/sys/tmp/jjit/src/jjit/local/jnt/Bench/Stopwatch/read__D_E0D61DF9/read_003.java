package jjit.local.jnt.Bench.Stopwatch.read__D_E0D61DF9;
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
 * jnt.Bench.Stopwatch
 * read()D
 * [count=6] [17] ALOAD(0) [18] GETFIELD(jnt.Bench.Stopwatch,total,J) [19] L2D [20] LDC(11->"0.0010") [21] DMUL [22] DRETURN
 */
public final class read_003 extends JJITAbstractInstruction implements Cloneable{
      private KField c_total = null;
      private KClassRepository c_repo;
      private KClass c_CStopwatch = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** double m_d;
        KFrame callerFrame = null;
         // **REMOVED Unused Var** KRegister reg;
        KLocalThread thread = frame.getThread();
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[17] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[18] GETFIELD(jnt.Bench.Stopwatch,total,J)
         // **REMOVED Substitution** s0 = c_total.getInstanceValue(((KReference)frame.getLocal(0)));
         // *********[19] L2D
         // **REMOVED Substitution** s0 = new KDouble(((double)c_total.getInstanceValue(((KReference)frame.getLocal(0))).longValue()));
         // *********[20] LDC(11->"0.0010")
         // **REMOVED Substitution** s1 = D0_0010;
         // *********[21] DMUL
         // **REMOVED Substitution** m_d = 0.0010D;
         // **REMOVED Substitution** s0 = new KDouble((((double)c_total.getInstanceValue(((KReference)frame.getLocal(0))).longValue()) * 0.0010D));
         // *********[22] DRETURN
         // **REMOVED Substitution** reg = new KDouble((((double)c_total.getInstanceValue(((KReference)frame.getLocal(0))).longValue()) * 0.0010D));
        callerFrame = thread.popFrame();
        callerFrame.push(new KDouble((((double)c_total.getInstanceValue(((KReference)frame.getLocal(0))).longValue()) * 0.0010D)));
        return ((JJITInstruction)callerFrame.getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[17] ALOAD(0)
         // *********[18] GETFIELD(jnt.Bench.Stopwatch,total,J)
        c_repo = process.getClassRepository();
        c_CStopwatch = c_repo.getClassByName("jnt.Bench.Stopwatch");
        c_total = c_CStopwatch.getField("total",true);
         // *********[19] L2D
         // *********[20] LDC(11->"0.0010")
         // *********[21] DMUL
         // *********[22] DRETURN
      }
}
