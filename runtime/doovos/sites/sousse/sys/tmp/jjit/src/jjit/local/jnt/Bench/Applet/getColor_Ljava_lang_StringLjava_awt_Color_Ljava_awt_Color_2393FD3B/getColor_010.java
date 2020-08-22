package jjit.local.jnt.Bench.Applet.getColor_Ljava_lang_StringLjava_awt_Color_Ljava_awt_Color_2393FD3B;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Applet
 * getColor(Ljava/lang/String;Ljava/awt/Color;)Ljava/awt/Color;
 * [count=3] [9] ASTORE(3) [10] ALOAD(2) [11] ARETURN
 */
public final class getColor_010 extends JJITAbstractInstruction implements Cloneable{
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KFrame callerFrame = null;
         // **REMOVED Unused Var** KRegister reg;
        KLocalThread thread = frame.getThread();
         // local_2 2 ; r=1/w=0 : NotCached
         // local_3 3 ; r=0/w=1 : NotCached
         // *********[9] ASTORE(3)
        frame.setLocal(3,frame.pop());
         // *********[10] ALOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[11] ARETURN
         // **REMOVED Substitution** reg = frame.getLocal(2);
        callerFrame = thread.popFrame();
        callerFrame.push(frame.getLocal(2));
        return ((JJITInstruction)callerFrame.getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[9] ASTORE(3)
         // *********[10] ALOAD(2)
         // *********[11] ARETURN
      }
}
