package jjit.local.jnt.Bench.Plotter.paint_Ljava_awt_Graphics_V_847ABEA9;
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
 * jnt.Bench.Plotter
 * paint(Ljava/awt/Graphics;)V
 * [count=4] [21] ASTORE(5) [22] ALOAD(0) [23] ALOAD(5) [24] INVOKEVIRTUAL(java.awt.Component,getFontMetrics(Ljava/awt/Font;)Ljava/awt/FontMetrics;)
 */
public final class paint_010 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_5 5 ; r=1/w=1 : Cached
        KRegister local_5;
         // *********[21] ASTORE(5)
        local_5 = frame.pop();
         // *********[22] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[23] ALOAD(5)
         // **REMOVED Substitution** s1 = local_5;
         // *********[24] INVOKEVIRTUAL(java.awt.Component,getFontMetrics(Ljava/awt/Font;)Ljava/awt/FontMetrics;)
        regs = new KRegister[2];
        regs[1] = local_5;
        ref = ((KReference)frame.getLocal(0));
        regs[0] = ref;
        frame.setProgramCounter(10);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getFontMetrics(Ljava/awt/Font;)Ljava/awt/FontMetrics;"),regs);
        frame.setLocal(5,local_5);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getFontMetrics(Ljava/awt/Font;)Ljava/awt/FontMetrics;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[21] ASTORE(5)
         // *********[22] ALOAD(0)
         // *********[23] ALOAD(5)
         // *********[24] INVOKEVIRTUAL(java.awt.Component,getFontMetrics(Ljava/awt/Font;)Ljava/awt/FontMetrics;)
        c_memman = process.getMemoryManager();
      }
}
