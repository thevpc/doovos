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
 * [count=4] [14] ALOAD(0) [15] LDC(23->"BUTTON_BGCOLOR") [16] ALOAD(0) [17] INVOKEVIRTUAL(java.awt.Component,getBackground()Ljava/awt/Color;)
 */
public final class init_009 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R23 = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s0_ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[14] ALOAD(0)
        frame.push(this_ref);
         // *********[15] LDC(23->"BUTTON_BGCOLOR")
        frame.push(R23);
         // *********[16] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[17] INVOKEVIRTUAL(java.awt.Component,getBackground()Ljava/awt/Color;)
        regs = new KRegister[1];
         // **REMOVED Substitution** ref = this_ref;
        regs[0] = this_ref;
        frame.setProgramCounter(9);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("getBackground()Ljava/awt/Color;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("getBackground()Ljava/awt/Color;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[14] ALOAD(0)
         // *********[15] LDC(23->"BUTTON_BGCOLOR")
        R23 = ((KReference)constants[23]);
         // *********[16] ALOAD(0)
         // *********[17] INVOKEVIRTUAL(java.awt.Component,getBackground()Ljava/awt/Color;)
        c_memman = process.getMemoryManager();
      }
}
