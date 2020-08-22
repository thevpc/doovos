package jjit.local.jnt.Bench.Bench.doExecution__V_C25B2F44;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Bench
 * doExecution()V
 * [count=6] [19] ALOAD(0) [20] GETFIELD(jnt.Bench.Bench,timer,[Ljnt/Bench/Stopwatch;) [21] ILOAD(3) [22] NEW(jnt.Bench.Stopwatch) [23] DUP [24] INVOKESPECIAL(jnt.Bench.Stopwatch,<init>()V)
 */
public final class doExecution_009 extends JJITAbstractInstruction implements Cloneable{
      private KField c_timer = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private KClass c_CStopwatch = null;
      private JJITInstruction c_next;
      private KMethod m_mth = null;
      private boolean m_mth_ignorable = false;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KReference ref;
        JJITInstruction nextInstr;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=0 : NotCached
         // *********[19] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[20] GETFIELD(jnt.Bench.Bench,timer,[Ljnt/Bench/Stopwatch;)
        frame.push(c_timer.getInstanceRef(((KReference)frame.getLocal(0))));
         // *********[21] ILOAD(3)
        frame.push(frame.getLocal(3));
         // *********[22] NEW(jnt.Bench.Stopwatch)
        if(c_CStopwatch == null){
          c_CStopwatch = c_repo.getClassByName("jnt.Bench.Stopwatch");
        }
        s0_ref = memseg.allocObject(c_CStopwatch);
         // *********[23] DUP
        frame.push(s0_ref);
         // **REMOVED Substitution** s1_ref = s0_ref;
         // *********[24] INVOKESPECIAL(jnt.Bench.Stopwatch,<init>()V)
        regs = new KRegister[1];
        if(m_mth == null){
          m_mth = c_CStopwatch.getMethodBySignature("<init>()V");
          m_mth_ignorable = m_mth.isIgnorable();
        }
         // **REMOVED Substitution** ref = s0_ref;
        regs[0] = s0_ref;
        if(m_mth_ignorable){
          nextInstr = c_next;
        }else{
          frame.setProgramCounter(9);
           // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
          nextInstr = ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
        }
        return nextInstr;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[19] ALOAD(0)
         // *********[20] GETFIELD(jnt.Bench.Bench,timer,[Ljnt/Bench/Stopwatch;)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_timer = c_CBench.getField("timer",true);
         // *********[21] ILOAD(3)
         // *********[22] NEW(jnt.Bench.Stopwatch)
        c_repo = process.getClassRepository();
         // *********[23] DUP
         // *********[24] INVOKESPECIAL(jnt.Bench.Stopwatch,<init>()V)
        c_next = instructions[(index + 1)];
      }
}
