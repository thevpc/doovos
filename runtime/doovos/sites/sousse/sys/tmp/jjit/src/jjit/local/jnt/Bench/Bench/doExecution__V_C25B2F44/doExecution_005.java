package jjit.local.jnt.Bench.Bench.doExecution__V_C25B2F44;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
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
 * [count=4] [4] CHECKCAST [5] ASTORE(1) [6] NEW(jnt.Bench.Stopwatch) [7] DUP
 */
public final class doExecution_005 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CStopwatch = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // local_1 1 ; r=0/w=1 : NotCached
         // *********[4] CHECKCAST
         // *********[5] ASTORE(1)
        frame.setLocal(1,frame.pop());
         // *********[6] NEW(jnt.Bench.Stopwatch)
        if(c_CStopwatch == null){
          c_CStopwatch = c_repo.getClassByName("jnt.Bench.Stopwatch");
        }
        s0_ref = memseg.allocObject(c_CStopwatch);
         // *********[7] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[4] CHECKCAST
         // *********[5] ASTORE(1)
         // *********[6] NEW(jnt.Bench.Stopwatch)
        c_repo = process.getClassRepository();
         // *********[7] DUP
        c_next = instructions[(index + 1)];
      }
}
