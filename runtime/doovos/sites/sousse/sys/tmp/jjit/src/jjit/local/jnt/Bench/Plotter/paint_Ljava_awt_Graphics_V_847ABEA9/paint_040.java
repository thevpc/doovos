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
 * [count=3] [247] ISUB [248] ILOAD(33) [249] INVOKEVIRTUAL(java.awt.Graphics,drawString(Ljava/lang/String;II)V)
 */
public final class paint_040 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
        int index = 0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_33 33 ; r=1/w=0 : NotCached
         // *********[247] ISUB
        index = frame.popInt();
         // **REMOVED Substitution** s0 = new KInteger((frame.popInt() - index));
         // *********[248] ILOAD(33)
         // **REMOVED Substitution** s1 = frame.getLocal(33);
         // *********[249] INVOKEVIRTUAL(java.awt.Graphics,drawString(Ljava/lang/String;II)V)
        regs = new KRegister[4];
        regs[3] = frame.getLocal(33);
        regs[2] = new KInteger((frame.popInt() - index));
        regs[1] = frame.pop();
        ref = frame.popRef();
        regs[0] = ref;
        frame.setProgramCounter(40);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("drawString(Ljava/lang/String;II)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("drawString(Ljava/lang/String;II)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[247] ISUB
         // *********[248] ILOAD(33)
         // *********[249] INVOKEVIRTUAL(java.awt.Graphics,drawString(Ljava/lang/String;II)V)
        c_memman = process.getMemoryManager();
      }
}
