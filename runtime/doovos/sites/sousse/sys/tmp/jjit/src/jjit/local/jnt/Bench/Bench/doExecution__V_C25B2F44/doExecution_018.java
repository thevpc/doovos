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
 * [count=3] [39] PUTFIELD(jnt.Bench.Bench,current) [40] ALOAD(2) [41] INVOKEVIRTUAL(jnt.Bench.Stopwatch,stop()D)
 */
public final class doExecution_018 extends JJITAbstractInstruction implements Cloneable{
      private KField c_current = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KReference ref;
        KRegister reg;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[39] PUTFIELD(jnt.Bench.Bench,current)
        reg = frame.pop();
         // **REMOVED Substitution** ref = frame.popRef();
        c_current.setInstanceValue(frame.popRef(),reg);
         // *********[40] ALOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[41] INVOKEVIRTUAL(jnt.Bench.Stopwatch,stop()D)
        regs = new KRegister[1];
        ref = ((KReference)frame.getLocal(2));
        regs[0] = ref;
        frame.setProgramCounter(18);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("stop()D"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("stop()D"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[39] PUTFIELD(jnt.Bench.Bench,current)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_current = c_CBench.getField("current",true);
         // *********[40] ALOAD(2)
         // *********[41] INVOKEVIRTUAL(jnt.Bench.Stopwatch,stop()D)
        c_memman = process.getMemoryManager();
      }
}
