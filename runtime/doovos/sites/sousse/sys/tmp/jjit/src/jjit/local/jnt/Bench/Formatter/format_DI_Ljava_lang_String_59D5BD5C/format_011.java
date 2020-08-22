package jjit.local.jnt.Bench.Formatter.format_DI_Ljava_lang_String_59D5BD5C;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Formatter
 * format(DI)Ljava/lang/String;
 * [count=5] [29] ASTORE(6) [30] ALOAD(6) [31] BIPUSH(48) [32] ILOAD(2) [33] ALOAD(5)
 */
public final class format_011 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger I48 = new KInteger(48);
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // local_2 2 ; r=1/w=0 : NotCached
         // local_5 5 ; r=1/w=0 : NotCached
         // local_6 6 ; r=1/w=1 : Cached
        KRegister local_6;
         // *********[29] ASTORE(6)
        local_6 = frame.pop();
         // *********[30] ALOAD(6)
        frame.push(local_6);
         // *********[31] BIPUSH(48)
        frame.push(I48);
         // *********[32] ILOAD(2)
        frame.push(frame.getLocal(2));
         // *********[33] ALOAD(5)
        frame.push(frame.getLocal(5));
        frame.setLocal(6,local_6);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[29] ASTORE(6)
         // *********[30] ALOAD(6)
         // *********[31] BIPUSH(48)
         // *********[32] ILOAD(2)
         // *********[33] ALOAD(5)
        c_next = instructions[(index + 1)];
      }
}
