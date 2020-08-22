package jjit.local.jnt.Bench.Applet.main__Ljava_lang_String_V_4846D998;
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
 * main([Ljava/lang/String;)V
 * [count=2] [12] POP [13] RETURN
 */
public final class main_006 extends JJITAbstractInstruction implements Cloneable{
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KFrame callerFrame = null;
        KLocalThread thread = frame.getThread();
         // *********[12] POP
        frame.pop();
         // *********[13] RETURN
         // **REMOVED Substitution** callerFrame = thread.popFrame();
        return ((JJITInstruction)thread.popFrame().getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[12] POP
         // *********[13] RETURN
      }
}
