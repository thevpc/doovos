package jjit.local.jnt.scimark2.MonteCarlo.integrate_I_D_98DBB769;
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
 * jnt.scimark2.MonteCarlo
 * integrate(I)D
 * [count=3] [12] DSTORE(4) [13] ALOAD(1) [14] INVOKEVIRTUAL(jnt.scimark2.Random,nextDouble()D)
 */
public final class integrate_006 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_1 1 ; r=1/w=0 : NotCached
         // local_4 4 ; r=0/w=1 : NotCached
         // *********[12] DSTORE(4)
        frame.setLocal(4,frame.pop());
         // *********[13] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[14] INVOKEVIRTUAL(jnt.scimark2.Random,nextDouble()D)
        regs = new KRegister[1];
        ref = ((KReference)frame.getLocal(1));
        regs[0] = ref;
        frame.setProgramCounter(6);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("nextDouble()D"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("nextDouble()D"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[12] DSTORE(4)
         // *********[13] ALOAD(1)
         // *********[14] INVOKEVIRTUAL(jnt.scimark2.Random,nextDouble()D)
        c_memman = process.getMemoryManager();
      }
}
