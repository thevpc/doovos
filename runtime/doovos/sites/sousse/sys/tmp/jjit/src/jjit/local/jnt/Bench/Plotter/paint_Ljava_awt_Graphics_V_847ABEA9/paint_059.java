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
 * [count=10] [342] ASTORE(37) [343] ALOAD(1) [344] ALOAD(36) [345] ILOAD(24) [346] ILOAD(26) [347] ICONST_3(Integer{3}) [348] IADD [349] ILOAD(7) [350] IADD [351] INVOKEVIRTUAL(java.awt.Graphics,drawString(Ljava/lang/String;II)V)
 */
public final class paint_059 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s4;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
         // **REMOVED Unused Var** int index = 0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_1 1 ; r=1/w=0 : NotCached
         // local_36 36 ; r=1/w=0 : NotCached
         // local_7 7 ; r=1/w=0 : NotCached
         // local_37 37 ; r=0/w=1 : NotCached
         // local_24 24 ; r=1/w=0 : NotCached
         // local_26 26 ; r=1/w=0 : NotCached
         // *********[342] ASTORE(37)
        frame.setLocal(37,frame.pop());
         // *********[343] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[344] ALOAD(36)
         // **REMOVED Substitution** s1 = frame.getLocal(36);
         // *********[345] ILOAD(24)
         // **REMOVED Substitution** s2 = frame.getLocal(24);
         // *********[346] ILOAD(26)
         // **REMOVED Substitution** s3 = frame.getLocal(26);
         // *********[347] ICONST_3(Integer{3})
         // **REMOVED Substitution** s4 = ITHREE;
         // *********[348] IADD
         // **REMOVED Substitution** index = 3;
         // **REMOVED Substitution** s3 = new KInteger((frame.getLocal(26).intValue() + 3));
         // *********[349] ILOAD(7)
         // **REMOVED Substitution** s4 = frame.getLocal(7);
         // *********[350] IADD
         // **REMOVED Substitution** index = frame.getLocal(7).intValue();
         // **REMOVED Substitution** s3 = new KInteger(((frame.getLocal(26).intValue() + 3) + frame.getLocal(7).intValue()));
         // *********[351] INVOKEVIRTUAL(java.awt.Graphics,drawString(Ljava/lang/String;II)V)
        regs = new KRegister[4];
        regs[3] = new KInteger(((frame.getLocal(26).intValue() + 3) + frame.getLocal(7).intValue()));
        regs[2] = frame.getLocal(24);
        regs[1] = frame.getLocal(36);
        ref = ((KReference)frame.getLocal(1));
        regs[0] = ref;
        frame.setProgramCounter(59);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("drawString(Ljava/lang/String;II)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("drawString(Ljava/lang/String;II)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[342] ASTORE(37)
         // *********[343] ALOAD(1)
         // *********[344] ALOAD(36)
         // *********[345] ILOAD(24)
         // *********[346] ILOAD(26)
         // *********[347] ICONST_3(Integer{3})
         // *********[348] IADD
         // *********[349] ILOAD(7)
         // *********[350] IADD
         // *********[351] INVOKEVIRTUAL(java.awt.Graphics,drawString(Ljava/lang/String;II)V)
        c_memman = process.getMemoryManager();
      }
}
