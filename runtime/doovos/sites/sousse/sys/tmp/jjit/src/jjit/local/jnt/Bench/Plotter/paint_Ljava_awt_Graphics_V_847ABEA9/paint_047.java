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
 * [count=3] [286] ALOAD(1) [287] ALOAD(2) [288] INVOKEVIRTUAL(java.awt.Graphics,setColor(Ljava/awt/Color;)V)
 */
public final class paint_047 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_1 1 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[286] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[287] ALOAD(2)
         // **REMOVED Substitution** s1 = frame.getLocal(2);
         // *********[288] INVOKEVIRTUAL(java.awt.Graphics,setColor(Ljava/awt/Color;)V)
        regs = new KRegister[2];
        regs[1] = frame.getLocal(2);
        ref = ((KReference)frame.getLocal(1));
        regs[0] = ref;
        frame.setProgramCounter(47);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("setColor(Ljava/awt/Color;)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("setColor(Ljava/awt/Color;)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[286] ALOAD(1)
         // *********[287] ALOAD(2)
         // *********[288] INVOKEVIRTUAL(java.awt.Graphics,setColor(Ljava/awt/Color;)V)
        c_memman = process.getMemoryManager();
      }
}
