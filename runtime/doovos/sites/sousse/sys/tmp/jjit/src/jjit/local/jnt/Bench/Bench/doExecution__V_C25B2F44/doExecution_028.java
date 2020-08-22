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
 * [count=4] [80] ALOAD(0) [81] ALOAD(0) [82] GETFIELD(jnt.Bench.Bench,current,[D) [83] INVOKEVIRTUAL(jnt.Bench.Bench,insertEntry([D)V)
 */
public final class doExecution_028 extends JJITAbstractInstruction implements Cloneable{
      private KField c_current = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KReference s0_ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[80] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[81] ALOAD(0)
         // **REMOVED Substitution** s1_ref = this_ref;
         // *********[82] GETFIELD(jnt.Bench.Bench,current,[D)
         // **REMOVED Substitution** s1_ref = c_current.getInstanceRef(this_ref);
         // *********[83] INVOKEVIRTUAL(jnt.Bench.Bench,insertEntry([D)V)
        regs = new KRegister[2];
        regs[1] = c_current.getInstanceRef(this_ref);
         // **REMOVED Substitution** ref = this_ref;
        regs[0] = this_ref;
        frame.setProgramCounter(28);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("insertEntry([D)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("insertEntry([D)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[80] ALOAD(0)
         // *********[81] ALOAD(0)
         // *********[82] GETFIELD(jnt.Bench.Bench,current,[D)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_current = c_CBench.getField("current",true);
         // *********[83] INVOKEVIRTUAL(jnt.Bench.Bench,insertEntry([D)V)
        c_memman = process.getMemoryManager();
      }
}
