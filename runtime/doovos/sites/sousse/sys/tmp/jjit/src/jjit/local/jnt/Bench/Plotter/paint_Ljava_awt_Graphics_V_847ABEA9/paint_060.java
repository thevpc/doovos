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
 * [count=6] [352] ALOAD(1) [353] ALOAD(37) [354] ILOAD(25) [355] ALOAD(6) [356] ALOAD(37) [357] INVOKEVIRTUAL(java.awt.FontMetrics,stringWidth(Ljava/lang/String;)I)
 */
public final class paint_060 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_1 1 ; r=1/w=0 : NotCached
         // local_6 6 ; r=1/w=0 : NotCached
         // local_37 37 ; r=2/w=0 : Cached
        KRegister local_37 = frame.getLocal(37);
         // local_25 25 ; r=1/w=0 : NotCached
         // *********[352] ALOAD(1)
        frame.push(frame.getLocal(1));
         // *********[353] ALOAD(37)
        frame.push(local_37);
         // *********[354] ILOAD(25)
        frame.push(frame.getLocal(25));
         // *********[355] ALOAD(6)
         // **REMOVED Substitution** s0 = frame.getLocal(6);
         // *********[356] ALOAD(37)
         // **REMOVED Substitution** s1 = local_37;
         // *********[357] INVOKEVIRTUAL(java.awt.FontMetrics,stringWidth(Ljava/lang/String;)I)
        regs = new KRegister[2];
        regs[1] = local_37;
        ref = ((KReference)frame.getLocal(6));
        regs[0] = ref;
        frame.setProgramCounter(60);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("stringWidth(Ljava/lang/String;)I"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("stringWidth(Ljava/lang/String;)I"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[352] ALOAD(1)
         // *********[353] ALOAD(37)
         // *********[354] ILOAD(25)
         // *********[355] ALOAD(6)
         // *********[356] ALOAD(37)
         // *********[357] INVOKEVIRTUAL(java.awt.FontMetrics,stringWidth(Ljava/lang/String;)I)
        c_memman = process.getMemoryManager();
      }
}
