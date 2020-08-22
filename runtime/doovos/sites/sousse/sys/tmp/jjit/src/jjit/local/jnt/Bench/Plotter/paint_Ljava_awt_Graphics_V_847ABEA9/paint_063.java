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
 * [count=11] [377] ISUB [378] ILOAD(26) [379] ICONST_3(Integer{3}) [380] IADD [381] ICONST_3(Integer{3}) [382] ILOAD(7) [383] IMUL [384] ICONST_2(Integer{2}) [385] IDIV [386] IADD [387] INVOKEVIRTUAL(java.awt.Graphics,drawString(Ljava/lang/String;II)V)
 */
public final class paint_063 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
        int index = 0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_7 7 ; r=1/w=0 : NotCached
         // local_26 26 ; r=1/w=0 : NotCached
         // *********[377] ISUB
        index = frame.popInt();
         // **REMOVED Substitution** s0 = new KInteger((frame.popInt() - index));
         // *********[378] ILOAD(26)
         // **REMOVED Substitution** s1 = frame.getLocal(26);
         // *********[379] ICONST_3(Integer{3})
         // **REMOVED Substitution** s2 = ITHREE;
         // *********[380] IADD
         // **REMOVED Substitution** index = 3;
         // **REMOVED Substitution** s1 = new KInteger((frame.getLocal(26).intValue() + 3));
         // *********[381] ICONST_3(Integer{3})
         // **REMOVED Substitution** s2 = ITHREE;
         // *********[382] ILOAD(7)
         // **REMOVED Substitution** s3 = frame.getLocal(7);
         // *********[383] IMUL
         // **REMOVED Substitution** index = frame.getLocal(7).intValue();
         // **REMOVED Substitution** s2 = new KInteger((3 * frame.getLocal(7).intValue()));
         // *********[384] ICONST_2(Integer{2})
         // **REMOVED Substitution** s3 = ITWO;
         // *********[385] IDIV
         // **REMOVED Substitution** index = 2;
         // **REMOVED Substitution** s2 = new KInteger(((3 * frame.getLocal(7).intValue()) / 2));
         // *********[386] IADD
         // **REMOVED Substitution** index = ((3 * frame.getLocal(7).intValue()) / 2);
         // **REMOVED Substitution** s1 = new KInteger(((frame.getLocal(26).intValue() + 3) + ((3 * frame.getLocal(7).intValue()) / 2)));
         // *********[387] INVOKEVIRTUAL(java.awt.Graphics,drawString(Ljava/lang/String;II)V)
        regs = new KRegister[4];
        regs[3] = new KInteger(((frame.getLocal(26).intValue() + 3) + ((3 * frame.getLocal(7).intValue()) / 2)));
        regs[2] = new KInteger((frame.popInt() - index));
        regs[1] = frame.pop();
        ref = frame.popRef();
        regs[0] = ref;
        frame.setProgramCounter(63);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("drawString(Ljava/lang/String;II)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("drawString(Ljava/lang/String;II)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[377] ISUB
         // *********[378] ILOAD(26)
         // *********[379] ICONST_3(Integer{3})
         // *********[380] IADD
         // *********[381] ICONST_3(Integer{3})
         // *********[382] ILOAD(7)
         // *********[383] IMUL
         // *********[384] ICONST_2(Integer{2})
         // *********[385] IDIV
         // *********[386] IADD
         // *********[387] INVOKEVIRTUAL(java.awt.Graphics,drawString(Ljava/lang/String;II)V)
        c_memman = process.getMemoryManager();
      }
}
