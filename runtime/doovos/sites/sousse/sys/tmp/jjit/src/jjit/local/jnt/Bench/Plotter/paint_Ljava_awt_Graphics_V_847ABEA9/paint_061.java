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
 * [count=7] [358] ISUB [359] ILOAD(26) [360] ICONST_3(Integer{3}) [361] IADD [362] ILOAD(7) [363] IADD [364] INVOKEVIRTUAL(java.awt.Graphics,drawString(Ljava/lang/String;II)V)
 */
public final class paint_061 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
        int index = 0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_7 7 ; r=1/w=0 : NotCached
         // local_26 26 ; r=1/w=0 : NotCached
         // *********[358] ISUB
        index = frame.popInt();
         // **REMOVED Substitution** s0 = new KInteger((frame.popInt() - index));
         // *********[359] ILOAD(26)
         // **REMOVED Substitution** s1 = frame.getLocal(26);
         // *********[360] ICONST_3(Integer{3})
         // **REMOVED Substitution** s2 = ITHREE;
         // *********[361] IADD
         // **REMOVED Substitution** index = 3;
         // **REMOVED Substitution** s1 = new KInteger((frame.getLocal(26).intValue() + 3));
         // *********[362] ILOAD(7)
         // **REMOVED Substitution** s2 = frame.getLocal(7);
         // *********[363] IADD
         // **REMOVED Substitution** index = frame.getLocal(7).intValue();
         // **REMOVED Substitution** s1 = new KInteger(((frame.getLocal(26).intValue() + 3) + frame.getLocal(7).intValue()));
         // *********[364] INVOKEVIRTUAL(java.awt.Graphics,drawString(Ljava/lang/String;II)V)
        regs = new KRegister[4];
        regs[3] = new KInteger(((frame.getLocal(26).intValue() + 3) + frame.getLocal(7).intValue()));
        regs[2] = new KInteger((frame.popInt() - index));
        regs[1] = frame.pop();
        ref = frame.popRef();
        regs[0] = ref;
        frame.setProgramCounter(61);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("drawString(Ljava/lang/String;II)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("drawString(Ljava/lang/String;II)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[358] ISUB
         // *********[359] ILOAD(26)
         // *********[360] ICONST_3(Integer{3})
         // *********[361] IADD
         // *********[362] ILOAD(7)
         // *********[363] IADD
         // *********[364] INVOKEVIRTUAL(java.awt.Graphics,drawString(Ljava/lang/String;II)V)
        c_memman = process.getMemoryManager();
      }
}
