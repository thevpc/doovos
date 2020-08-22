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
 * [count=6] [289] ALOAD(1) [290] ILOAD(24) [291] ILOAD(26) [292] ILOAD(25) [293] ILOAD(26) [294] INVOKEVIRTUAL(java.awt.Graphics,drawLine(IIII)V)
 */
public final class paint_048 extends JJITAbstractInstruction implements Cloneable{
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
         // local_25 25 ; r=1/w=0 : NotCached
         // local_24 24 ; r=1/w=0 : NotCached
         // local_26 26 ; r=2/w=0 : Cached
        int local_26 = frame.getLocal(26).intValue();
         // *********[289] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[290] ILOAD(24)
         // **REMOVED Substitution** s1 = frame.getLocal(24);
         // *********[291] ILOAD(26)
         // **REMOVED Substitution** s2 = new KInteger(local_26);
         // *********[292] ILOAD(25)
         // **REMOVED Substitution** s3 = frame.getLocal(25);
         // *********[293] ILOAD(26)
         // **REMOVED Substitution** s4 = new KInteger(local_26);
         // *********[294] INVOKEVIRTUAL(java.awt.Graphics,drawLine(IIII)V)
        regs = new KRegister[5];
        regs[4] = new KInteger(local_26);
        regs[3] = frame.getLocal(25);
        regs[2] = new KInteger(local_26);
        regs[1] = frame.getLocal(24);
        ref = ((KReference)frame.getLocal(1));
        regs[0] = ref;
        frame.setProgramCounter(48);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("drawLine(IIII)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("drawLine(IIII)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[289] ALOAD(1)
         // *********[290] ILOAD(24)
         // *********[291] ILOAD(26)
         // *********[292] ILOAD(25)
         // *********[293] ILOAD(26)
         // *********[294] INVOKEVIRTUAL(java.awt.Graphics,drawLine(IIII)V)
        c_memman = process.getMemoryManager();
      }
}
