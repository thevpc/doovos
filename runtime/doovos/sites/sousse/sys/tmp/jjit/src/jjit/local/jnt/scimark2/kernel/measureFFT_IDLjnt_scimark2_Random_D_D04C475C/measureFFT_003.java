package jjit.local.jnt.scimark2.kernel.measureFFT_IDLjnt_scimark2_Random_D_D04C475C;
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
 * measureFFT(IDLjnt/scimark2/Random;)D
 * [count=5] [8] ASTORE(5) [9] LCONST_1(Long{1}) [10] LSTORE(6) [11] NEW(jnt.scimark2.Stopwatch) [12] DUP
 */
public final class measureFFT_003 extends JJITAbstractInstruction implements Cloneable{
      private static final KLong LONE = KLong.ONE;
      private KClassRepository c_repo;
      private KClass c_CStopwatch = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // local_5 5 ; r=0/w=1 : NotCached
         // local_6 6 ; r=0/w=1 : NotCached
         // *********[8] ASTORE(5)
        frame.setLocal(5,frame.pop());
         // *********[9] LCONST_1(Long{1})
         // **REMOVED Substitution** s0 = LONE;
         // *********[10] LSTORE(6)
        frame.setLocal(6,LONE);
         // *********[11] NEW(jnt.scimark2.Stopwatch)
        if(c_CStopwatch == null){
          c_CStopwatch = c_repo.getClassByName("jnt.scimark2.Stopwatch");
        }
        s0_ref = memseg.allocObject(c_CStopwatch);
         // *********[12] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[8] ASTORE(5)
         // *********[9] LCONST_1(Long{1})
         // *********[10] LSTORE(6)
         // *********[11] NEW(jnt.scimark2.Stopwatch)
        c_repo = process.getClassRepository();
         // *********[12] DUP
        c_next = instructions[(index + 1)];
      }
}
