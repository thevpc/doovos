package jjit.local.jnt.scimark2.kernel.measureLU_IDLjnt_scimark2_Random_D_90AF8A27;
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
 * jnt.scimark2.kernel
 * measureLU(IDLjnt/scimark2/Random;)D
 * [count=5] [75] ILOAD(8) [76] I2D [77] DMUL [78] ALOAD(7) [79] INVOKEVIRTUAL(jnt.scimark2.Stopwatch,read()D)
 */
public final class measureLU_028 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        double m_d;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_7 7 ; r=1/w=0 : NotCached
         // local_8 8 ; r=1/w=0 : NotCached
         // *********[75] ILOAD(8)
         // **REMOVED Substitution** s0 = frame.getLocal(8);
         // *********[76] I2D
         // **REMOVED Substitution** s0 = new KDouble(frame.getLocal(8).intValue());
         // *********[77] DMUL
        m_d = frame.getLocal(8).doubleValue();
        frame.push(new KDouble((frame.popDouble() * m_d)));
         // *********[78] ALOAD(7)
         // **REMOVED Substitution** s0 = frame.getLocal(7);
         // *********[79] INVOKEVIRTUAL(jnt.scimark2.Stopwatch,read()D)
        regs = new KRegister[1];
        ref = ((KReference)frame.getLocal(7));
        regs[0] = ref;
        frame.setProgramCounter(28);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("read()D"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("read()D"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[75] ILOAD(8)
         // *********[76] I2D
         // *********[77] DMUL
         // *********[78] ALOAD(7)
         // *********[79] INVOKEVIRTUAL(jnt.scimark2.Stopwatch,read()D)
        c_memman = process.getMemoryManager();
      }
}
