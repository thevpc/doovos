package jjit.local.jnt.Bench.Bench.resetTimer_I_V_1FD80F96;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Bench
 * resetTimer(I)V
 * [count=4] [0] ALOAD(0) [1] GETFIELD(jnt.Bench.Bench,timer,[Ljnt/Bench/Stopwatch;) [2] ILOAD(1) [3] AALOAD
 */
public final class resetTimer_001 extends JJITAbstractInstruction implements Cloneable{
      private KField c_timer = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** KReference ref;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[0] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[1] GETFIELD(jnt.Bench.Bench,timer,[Ljnt/Bench/Stopwatch;)
         // **REMOVED Substitution** s0_ref = c_timer.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[2] ILOAD(1)
         // **REMOVED Substitution** s1 = frame.getLocal(1);
         // *********[3] AALOAD
         // **REMOVED Substitution** index = frame.getLocal(1).intValue();
         // **REMOVED Substitution** ref = c_timer.getInstanceRef(((KReference)frame.getLocal(0)));
        frame.push(c_memman.getReferenceArray(c_timer.getInstanceRef(((KReference)frame.getLocal(0))),frame.getLocal(1).intValue()));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] GETFIELD(jnt.Bench.Bench,timer,[Ljnt/Bench/Stopwatch;)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_timer = c_CBench.getField("timer",true);
         // *********[2] ILOAD(1)
         // *********[3] AALOAD
        c_memman = process.getMemoryManager();
        c_next = instructions[(index + 1)];
      }
}
