package jjit.local.jnt.scimark2.kernel.measureLU_IDLjnt_scimark2_Random_D_90AF8A27;
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
 * jnt.scimark2.kernel
 * measureLU(IDLjnt/scimark2/Random;)D
 * [count=6] [8] ASTORE(5) [9] ILOAD(0) [10] NEWARRAY [11] ASTORE(6) [12] NEW(jnt.scimark2.Stopwatch) [13] DUP
 */
public final class measureLU_005 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CStopwatch = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // local_0 0 ; r=1/w=0 : NotCached
         // local_5 5 ; r=0/w=1 : NotCached
         // local_6 6 ; r=0/w=1 : NotCached
         // *********[8] ASTORE(5)
        frame.setLocal(5,frame.pop());
         // *********[9] ILOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[10] NEWARRAY
         // **REMOVED Substitution** s0_ref = memseg.allocIntArray(frame.getLocal(0).intValue());
         // *********[11] ASTORE(6)
        frame.setLocal(6,memseg.allocIntArray(frame.getLocal(0).intValue()));
         // *********[12] NEW(jnt.scimark2.Stopwatch)
        if(c_CStopwatch == null){
          c_CStopwatch = c_repo.getClassByName("jnt.scimark2.Stopwatch");
        }
        s0_ref = memseg.allocObject(c_CStopwatch);
         // *********[13] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[8] ASTORE(5)
         // *********[9] ILOAD(0)
         // *********[10] NEWARRAY
         // *********[11] ASTORE(6)
         // *********[12] NEW(jnt.scimark2.Stopwatch)
        c_repo = process.getClassRepository();
         // *********[13] DUP
        c_next = instructions[(index + 1)];
      }
}
