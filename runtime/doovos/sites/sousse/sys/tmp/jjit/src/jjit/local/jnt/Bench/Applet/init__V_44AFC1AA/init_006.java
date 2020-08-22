package jjit.local.jnt.Bench.Applet.init__V_44AFC1AA;
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
 * jnt.Bench.Applet
 * init()V
 * [count=5] [7] ALOAD(0) [8] ALOAD(0) [9] LDC(20->"TEXT") [10] ALOAD(0) [11] INVOKEVIRTUAL(java.awt.Component,getForeground()Ljava/awt/Color;)
 */
public final class init_006 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R20 = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s0_ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=3/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[7] ALOAD(0)
        frame.push(this_ref);
         // *********[8] ALOAD(0)
        frame.push(this_ref);
         // *********[9] LDC(20->"TEXT")
        frame.push(R20);
         // *********[10] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[11] INVOKEVIRTUAL(java.awt.Component,getForeground()Ljava/awt/Color;)
        regs = new KRegister[1];
         // **REMOVED Substitution** ref = this_ref;
        regs[0] = this_ref;
        frame.setProgramCounter(6);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("getForeground()Ljava/awt/Color;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("getForeground()Ljava/awt/Color;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[7] ALOAD(0)
         // *********[8] ALOAD(0)
         // *********[9] LDC(20->"TEXT")
        R20 = ((KReference)constants[20]);
         // *********[10] ALOAD(0)
         // *********[11] INVOKEVIRTUAL(java.awt.Component,getForeground()Ljava/awt/Color;)
        c_memman = process.getMemoryManager();
      }
}
