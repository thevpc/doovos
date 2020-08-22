package jjit.local.jnt.Bench.Plotter.drawBox_Ljava_awt_GraphicsLjava_awt_ColorIIII_V_F3834EFD;
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
 * drawBox(Ljava/awt/Graphics;Ljava/awt/Color;IIII)V
 * [count=6] [3] ALOAD(1) [4] ILOAD(3) [5] ILOAD(4) [6] ILOAD(5) [7] ILOAD(6) [8] INVOKEVIRTUAL(java.awt.Graphics,fillRect(IIII)V)
 */
public final class drawBox_004 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s4;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_1 1 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=0 : NotCached
         // local_4 4 ; r=1/w=0 : NotCached
         // local_5 5 ; r=1/w=0 : NotCached
         // local_6 6 ; r=1/w=0 : NotCached
         // *********[3] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[4] ILOAD(3)
         // **REMOVED Substitution** s1 = frame.getLocal(3);
         // *********[5] ILOAD(4)
         // **REMOVED Substitution** s2 = frame.getLocal(4);
         // *********[6] ILOAD(5)
         // **REMOVED Substitution** s3 = frame.getLocal(5);
         // *********[7] ILOAD(6)
         // **REMOVED Substitution** s4 = frame.getLocal(6);
         // *********[8] INVOKEVIRTUAL(java.awt.Graphics,fillRect(IIII)V)
        regs = new KRegister[5];
        regs[4] = frame.getLocal(6);
        regs[3] = frame.getLocal(5);
        regs[2] = frame.getLocal(4);
        regs[1] = frame.getLocal(3);
        ref = ((KReference)frame.getLocal(1));
        regs[0] = ref;
        frame.setProgramCounter(4);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("fillRect(IIII)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("fillRect(IIII)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[3] ALOAD(1)
         // *********[4] ILOAD(3)
         // *********[5] ILOAD(4)
         // *********[6] ILOAD(5)
         // *********[7] ILOAD(6)
         // *********[8] INVOKEVIRTUAL(java.awt.Graphics,fillRect(IIII)V)
        c_memman = process.getMemoryManager();
      }
}
