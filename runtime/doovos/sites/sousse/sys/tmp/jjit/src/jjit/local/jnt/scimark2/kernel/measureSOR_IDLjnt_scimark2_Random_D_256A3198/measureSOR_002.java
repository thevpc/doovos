package jjit.local.jnt.scimark2.kernel.measureSOR_IDLjnt_scimark2_Random_D_256A3198;
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
 * measureSOR(IDLjnt/scimark2/Random;)D
 * [count=3] [4] ASTORE(4) [5] NEW(jnt.scimark2.Stopwatch) [6] DUP
 */
public final class measureSOR_002 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CStopwatch = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // local_4 4 ; r=0/w=1 : NotCached
         // *********[4] ASTORE(4)
        frame.setLocal(4,frame.pop());
         // *********[5] NEW(jnt.scimark2.Stopwatch)
        if(c_CStopwatch == null){
          c_CStopwatch = c_repo.getClassByName("jnt.scimark2.Stopwatch");
        }
        s0_ref = memseg.allocObject(c_CStopwatch);
         // *********[6] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[4] ASTORE(4)
         // *********[5] NEW(jnt.scimark2.Stopwatch)
        c_repo = process.getClassRepository();
         // *********[6] DUP
        c_next = instructions[(index + 1)];
      }
}
