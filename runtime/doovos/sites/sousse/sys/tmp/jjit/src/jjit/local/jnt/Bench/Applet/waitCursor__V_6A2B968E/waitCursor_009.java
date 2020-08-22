package jjit.local.jnt.Bench.Applet.waitCursor__V_6A2B968E;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Applet
 * waitCursor()V
 * [count=3] [12] ALOAD(1) [13] INSTANCEOF(java.awt.Frame) [14] IFEQ(7)
 */
public final class waitCursor_009 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private KClassRepository c_repo;
      private KClass c_CFrame = null;
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KReference ref;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[12] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[13] INSTANCEOF(java.awt.Frame)
        if(c_CFrame == null){
          c_CFrame = c_repo.getClassByName("java.awt.Frame");
        }
        ref = ((KReference)frame.getLocal(1));
         // **REMOVED Substitution** s0 = ((ref.isNull())?(KInteger.ZERO):(((c_CFrame.isAssignableFrom(c_memman.getKClass(ref)))?(KInteger.ONE):(KInteger.ZERO))));
         // *********[14] IFEQ(7)
         // **REMOVED Substitution** index = ((ref.isNull())?(0):(((c_CFrame.isAssignableFrom(c_memman.getKClass(ref)))?(1):(0))));
         // **REMOVED Substitution** jump = ((ref.isNull())?(0):(((c_CFrame.isAssignableFrom(c_memman.getKClass(ref)))?(1):(0)))) == 0;
        return ((((ref.isNull())?(0):(((c_CFrame.isAssignableFrom(c_memman.getKClass(ref)))?(1):(0)))) == 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[12] ALOAD(1)
         // *********[13] INSTANCEOF(java.awt.Frame)
        c_memman = process.getMemoryManager();
        c_repo = process.getClassRepository();
         // *********[14] IFEQ(7)
        c_next = instructions[(index + 1)];
        c_label = instructions[5];
      }
}
