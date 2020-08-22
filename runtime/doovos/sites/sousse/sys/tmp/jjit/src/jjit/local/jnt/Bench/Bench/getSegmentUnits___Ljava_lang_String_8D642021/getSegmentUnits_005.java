package jjit.local.jnt.Bench.Bench.getSegmentUnits___Ljava_lang_String_8D642021;
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
 * jnt.Bench.Bench
 * getSegmentUnits()[Ljava/lang/String;
 * [count=4] [17] ILOAD(2) [18] ALOAD(1) [19] ARRAYLENGTH [20] IF_ICMPLT(8)
 */
public final class getSegmentUnits_005 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_1 1 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[17] ILOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[18] ALOAD(1)
         // **REMOVED Substitution** s1 = frame.getLocal(1);
         // *********[19] ARRAYLENGTH
         // **REMOVED Substitution** s1 = new KInteger(c_memman.getArraySize(((KReference)frame.getLocal(1))));
         // *********[20] IF_ICMPLT(8)
         // **REMOVED Substitution** index = c_memman.getArraySize(((KReference)frame.getLocal(1)));
         // **REMOVED Substitution** jump = frame.getLocal(2).intValue() < c_memman.getArraySize(((KReference)frame.getLocal(1)));
        return ((frame.getLocal(2).intValue() < c_memman.getArraySize(((KReference)frame.getLocal(1))))?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[17] ILOAD(2)
         // *********[18] ALOAD(1)
         // *********[19] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[20] IF_ICMPLT(8)
        c_next = instructions[(index + 1)];
        c_label = instructions[3];
      }
}
