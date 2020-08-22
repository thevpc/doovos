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
 * [count=5] [19] ASTORE(1) [20] ALOAD(0) [21] LDC(24->"BUTTON_TEXT") [22] ALOAD(0) [23] INVOKEVIRTUAL(java.awt.Component,getForeground()Ljava/awt/Color;)
 */
public final class init_011 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R24 = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s0_ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // local_1 1 ; r=0/w=1 : NotCached
         // *********[19] ASTORE(1)
        frame.setLocal(1,frame.pop());
         // *********[20] ALOAD(0)
        frame.push(this_ref);
         // *********[21] LDC(24->"BUTTON_TEXT")
        frame.push(R24);
         // *********[22] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[23] INVOKEVIRTUAL(java.awt.Component,getForeground()Ljava/awt/Color;)
        regs = new KRegister[1];
         // **REMOVED Substitution** ref = this_ref;
        regs[0] = this_ref;
        frame.setProgramCounter(11);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("getForeground()Ljava/awt/Color;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("getForeground()Ljava/awt/Color;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[19] ASTORE(1)
         // *********[20] ALOAD(0)
         // *********[21] LDC(24->"BUTTON_TEXT")
        R24 = ((KReference)constants[24]);
         // *********[22] ALOAD(0)
         // *********[23] INVOKEVIRTUAL(java.awt.Component,getForeground()Ljava/awt/Color;)
        c_memman = process.getMemoryManager();
      }
}
