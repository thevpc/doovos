package jjit.local.jnt.Bench.Bench.doExecution__V_C25B2F44;
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
 * doExecution()V
 * [count=8] [58] ALOAD(0) [59] GETFIELD(jnt.Bench.Bench,current,[D) [60] ILOAD(4) [61] ALOAD(0) [62] GETFIELD(jnt.Bench.Bench,timer,[Ljnt/Bench/Stopwatch;) [63] ILOAD(4) [64] AALOAD [65] INVOKEVIRTUAL(jnt.Bench.Stopwatch,read()D)
 */
public final class doExecution_022 extends JJITAbstractInstruction implements Cloneable{
      private KField c_current = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private KField c_timer = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
        KReference ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // local_4 4 ; r=2/w=0 : Cached
        int local_4 = frame.getLocal(4).intValue();
         // *********[58] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[59] GETFIELD(jnt.Bench.Bench,current,[D)
        frame.push(c_current.getInstanceRef(this_ref));
         // *********[60] ILOAD(4)
        frame.push(new KInteger(local_4));
         // *********[61] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[62] GETFIELD(jnt.Bench.Bench,timer,[Ljnt/Bench/Stopwatch;)
         // **REMOVED Substitution** s0_ref = c_timer.getInstanceRef(this_ref);
         // *********[63] ILOAD(4)
         // **REMOVED Substitution** s1 = new KInteger(local_4);
         // *********[64] AALOAD
         // **REMOVED Substitution** index = local_4;
         // **REMOVED Substitution** ref = c_timer.getInstanceRef(this_ref);
         // **REMOVED Substitution** s0_ref = c_memman.getReferenceArray(c_timer.getInstanceRef(this_ref),local_4);
         // *********[65] INVOKEVIRTUAL(jnt.Bench.Stopwatch,read()D)
        regs = new KRegister[1];
        ref = c_memman.getReferenceArray(c_timer.getInstanceRef(this_ref),local_4);
        regs[0] = ref;
        frame.setProgramCounter(22);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("read()D"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("read()D"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[58] ALOAD(0)
         // *********[59] GETFIELD(jnt.Bench.Bench,current,[D)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_current = c_CBench.getField("current",true);
         // *********[60] ILOAD(4)
         // *********[61] ALOAD(0)
         // *********[62] GETFIELD(jnt.Bench.Bench,timer,[Ljnt/Bench/Stopwatch;)
        c_timer = c_CBench.getField("timer",true);
         // *********[63] ILOAD(4)
         // *********[64] AALOAD
        c_memman = process.getMemoryManager();
         // *********[65] INVOKEVIRTUAL(jnt.Bench.Stopwatch,read()D)
      }
}
