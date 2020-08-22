package jjit.local.jnt.Bench.Bench.main__Ljava_lang_String_V_8024FB52;
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
 * main([Ljava/lang/String;)V
 * [count=3] [13] ASTORE(1) [14] ALOAD(1) [15] INVOKEVIRTUAL(jnt.Bench.Bench,doExecution()V)
 */
public final class main_005 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_1 1 ; r=1/w=1 : Cached
        KRegister local_1;
         // *********[13] ASTORE(1)
        local_1 = frame.pop();
         // *********[14] ALOAD(1)
         // **REMOVED Substitution** s0 = local_1;
         // *********[15] INVOKEVIRTUAL(jnt.Bench.Bench,doExecution()V)
        regs = new KRegister[1];
         // **REMOVED Substitution** ref = ((KReference)local_1);
        regs[0] = ((KReference)local_1);
        frame.setProgramCounter(5);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(((KReference)local_1)).getVirtualMethodBySignature("doExecution()V"),regs);
        frame.setLocal(1,local_1);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(((KReference)local_1)).getVirtualMethodBySignature("doExecution()V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[13] ASTORE(1)
         // *********[14] ALOAD(1)
         // *********[15] INVOKEVIRTUAL(jnt.Bench.Bench,doExecution()V)
        c_memman = process.getMemoryManager();
      }
}
