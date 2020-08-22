package jjit.local.jnt.Bench.Bench.run__V_F2C678D6;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Bench
 * run()V
 * [count=3] [3] ICONST_1(Integer{1}) [4] ISUB [5] INVOKEVIRTUAL(java.lang.Thread,setPriority(I)V)
 */
public final class run_005 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** int index = 0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // *********[3] ICONST_1(Integer{1})
         // **REMOVED Substitution** s0 = IONE;
         // *********[4] ISUB
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s0 = new KInteger((frame.popInt() - 1));
         // *********[5] INVOKEVIRTUAL(java.lang.Thread,setPriority(I)V)
        regs = new KRegister[2];
        regs[1] = new KInteger((frame.popInt() - 1));
        ref = frame.popRef();
        regs[0] = ref;
        frame.setProgramCounter(5);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("setPriority(I)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("setPriority(I)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[3] ICONST_1(Integer{1})
         // *********[4] ISUB
         // *********[5] INVOKEVIRTUAL(java.lang.Thread,setPriority(I)V)
        c_memman = process.getMemoryManager();
      }
}
