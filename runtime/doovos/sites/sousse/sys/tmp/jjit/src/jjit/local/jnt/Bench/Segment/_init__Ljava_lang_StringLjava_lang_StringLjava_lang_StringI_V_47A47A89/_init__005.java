package jjit.local.jnt.Bench.Segment._init__Ljava_lang_StringLjava_lang_StringLjava_lang_StringI_V_47A47A89;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Segment
 * <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
 * [count=2] [8] ALOAD(2) [9] GOTO(11)
 */
public final class _init__005 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[8] ALOAD(2)
        frame.push(frame.getLocal(2));
         // *********[9] GOTO(11)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[8] ALOAD(2)
         // *********[9] GOTO(11)
        c_label = instructions[6];
      }
}
