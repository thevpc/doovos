package jjit.local.jnt.Bench.Formatter.addColumn__Ljava_lang_String_Ljava_lang_StringI_V_F11D9847;
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
 * addColumn([Ljava/lang/String;[Ljava/lang/String;I)V
 * [count=4] [11] DUP [12] ISTORE(5) [13] ILOAD(3) [14] IF_ICMPLE(17)
 */
public final class addColumn_003 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_3 3 ; r=1/w=0 : NotCached
         // local_5 5 ; r=0/w=1 : NotCached
         // *********[11] DUP
         // **REMOVED Substitution** s0 = frame.peek();
         // *********[12] ISTORE(5)
        frame.setLocal(5,frame.peek());
         // *********[13] ILOAD(3)
         // **REMOVED Substitution** s0 = frame.getLocal(3);
         // *********[14] IF_ICMPLE(17)
        index = frame.getLocal(3).intValue();
         // **REMOVED Substitution** jump = frame.popInt() <= index;
        return ((frame.popInt() <= index)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[11] DUP
         // *********[12] ISTORE(5)
         // *********[13] ILOAD(3)
         // *********[14] IF_ICMPLE(17)
        c_next = instructions[(index + 1)];
        c_label = instructions[4];
      }
}
