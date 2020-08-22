package jjit.local.jnt.Bench.AppletFrame._init__Ljava_lang_String_V_B2053D6E;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.AppletFrame
 * <init>(Ljava/lang/String;)V
 * [count=4] [17] POP [18] ALOAD(0) [19] SIPUSH(Integer{500}) [20] SIPUSH(Integer{360})
 */
public final class _init__013 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger I500 = new KInteger(500);
      private static final KInteger I360 = new KInteger(360);
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[17] POP
        frame.pop();
         // *********[18] ALOAD(0)
        frame.push(frame.getLocal(0));
         // *********[19] SIPUSH(Integer{500})
        frame.push(I500);
         // *********[20] SIPUSH(Integer{360})
        frame.push(I360);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[17] POP
         // *********[18] ALOAD(0)
         // *********[19] SIPUSH(Integer{500})
         // *********[20] SIPUSH(Integer{360})
        c_next = instructions[(index + 1)];
      }
}
