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
 * [count=5] [74] ALOAD(0) [75] GETFIELD(jnt.Bench.Bench,current,[D) [76] ICONST_0(Integer{0}) [77] ALOAD(2) [78] INVOKEVIRTUAL(jnt.Bench.Stopwatch,read()D)
 */
public final class doExecution_026 extends JJITAbstractInstruction implements Cloneable{
      private KField c_current = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private static final KInteger IZERO = KInteger.ZERO;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[74] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[75] GETFIELD(jnt.Bench.Bench,current,[D)
        frame.push(c_current.getInstanceRef(((KReference)frame.getLocal(0))));
         // *********[76] ICONST_0(Integer{0})
        frame.push(IZERO);
         // *********[77] ALOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[78] INVOKEVIRTUAL(jnt.Bench.Stopwatch,read()D)
        regs = new KRegister[1];
        ref = ((KReference)frame.getLocal(2));
        regs[0] = ref;
        frame.setProgramCounter(26);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("read()D"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("read()D"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[74] ALOAD(0)
         // *********[75] GETFIELD(jnt.Bench.Bench,current,[D)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_current = c_CBench.getField("current",true);
         // *********[76] ICONST_0(Integer{0})
         // *********[77] ALOAD(2)
         // *********[78] INVOKEVIRTUAL(jnt.Bench.Stopwatch,read()D)
        c_memman = process.getMemoryManager();
      }
}
