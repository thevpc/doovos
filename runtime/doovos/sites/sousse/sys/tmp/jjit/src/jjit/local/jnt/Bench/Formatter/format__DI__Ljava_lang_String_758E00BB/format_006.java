package jjit.local.jnt.Bench.Formatter.format__DI__Ljava_lang_String_758E00BB;
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
 * jnt.Bench.Formatter
 * format([DI)[Ljava/lang/String;
 * [count=4] [16] ILOAD(3) [17] ALOAD(0) [18] ARRAYLENGTH [19] IF_ICMPLT(7)
 */
public final class format_006 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=0 : NotCached
         // *********[16] ILOAD(3)
         // **REMOVED Substitution** s0 = frame.getLocal(3);
         // *********[17] ALOAD(0)
         // **REMOVED Substitution** s1 = frame.getLocal(0);
         // *********[18] ARRAYLENGTH
         // **REMOVED Substitution** s1 = new KInteger(c_memman.getArraySize(((KReference)frame.getLocal(0))));
         // *********[19] IF_ICMPLT(7)
         // **REMOVED Substitution** index = c_memman.getArraySize(((KReference)frame.getLocal(0)));
         // **REMOVED Substitution** jump = frame.getLocal(3).intValue() < c_memman.getArraySize(((KReference)frame.getLocal(0)));
        return ((frame.getLocal(3).intValue() < c_memman.getArraySize(((KReference)frame.getLocal(0))))?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[16] ILOAD(3)
         // *********[17] ALOAD(0)
         // *********[18] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[19] IF_ICMPLT(7)
        c_next = instructions[(index + 1)];
        c_label = instructions[3];
      }
}
