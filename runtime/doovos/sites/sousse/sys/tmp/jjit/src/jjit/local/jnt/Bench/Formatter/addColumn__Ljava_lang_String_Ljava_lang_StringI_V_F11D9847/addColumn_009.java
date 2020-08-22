package jjit.local.jnt.Bench.Formatter.addColumn__Ljava_lang_String_Ljava_lang_StringI_V_F11D9847;
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
 * addColumn([Ljava/lang/String;[Ljava/lang/String;I)V
 * [count=4] [28] ILOAD(6) [29] ALOAD(0) [30] ARRAYLENGTH [31] IF_ICMPLT(7)
 */
public final class addColumn_009 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_6 6 ; r=1/w=0 : NotCached
         // *********[28] ILOAD(6)
         // **REMOVED Substitution** s0 = frame.getLocal(6);
         // *********[29] ALOAD(0)
         // **REMOVED Substitution** s1 = frame.getLocal(0);
         // *********[30] ARRAYLENGTH
         // **REMOVED Substitution** s1 = new KInteger(c_memman.getArraySize(((KReference)frame.getLocal(0))));
         // *********[31] IF_ICMPLT(7)
         // **REMOVED Substitution** index = c_memman.getArraySize(((KReference)frame.getLocal(0)));
         // **REMOVED Substitution** jump = frame.getLocal(6).intValue() < c_memman.getArraySize(((KReference)frame.getLocal(0)));
        return ((frame.getLocal(6).intValue() < c_memman.getArraySize(((KReference)frame.getLocal(0))))?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[28] ILOAD(6)
         // *********[29] ALOAD(0)
         // *********[30] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[31] IF_ICMPLT(7)
        c_next = instructions[(index + 1)];
        c_label = instructions[1];
      }
}
