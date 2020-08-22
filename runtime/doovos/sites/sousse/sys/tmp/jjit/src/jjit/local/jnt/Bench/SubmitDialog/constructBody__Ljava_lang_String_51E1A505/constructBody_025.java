package jjit.local.jnt.Bench.SubmitDialog.constructBody__Ljava_lang_String_51E1A505;
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
 * jnt.Bench.SubmitDialog
 * constructBody()Ljava/lang/String;
 * [count=4] [52] ILOAD(3) [53] ALOAD(2) [54] ARRAYLENGTH [55] IF_ICMPLT(38)
 */
public final class constructBody_025 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_2 2 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=0 : NotCached
         // *********[52] ILOAD(3)
         // **REMOVED Substitution** s0 = frame.getLocal(3);
         // *********[53] ALOAD(2)
         // **REMOVED Substitution** s1 = frame.getLocal(2);
         // *********[54] ARRAYLENGTH
         // **REMOVED Substitution** s1 = new KInteger(c_memman.getArraySize(((KReference)frame.getLocal(2))));
         // *********[55] IF_ICMPLT(38)
         // **REMOVED Substitution** index = c_memman.getArraySize(((KReference)frame.getLocal(2)));
         // **REMOVED Substitution** jump = frame.getLocal(3).intValue() < c_memman.getArraySize(((KReference)frame.getLocal(2)));
        return ((frame.getLocal(3).intValue() < c_memman.getArraySize(((KReference)frame.getLocal(2))))?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[52] ILOAD(3)
         // *********[53] ALOAD(2)
         // *********[54] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[55] IF_ICMPLT(38)
        c_next = instructions[(index + 1)];
        c_label = instructions[18];
      }
}
