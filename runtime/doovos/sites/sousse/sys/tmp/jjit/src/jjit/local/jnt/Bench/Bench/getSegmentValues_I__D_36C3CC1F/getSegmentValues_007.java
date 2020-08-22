package jjit.local.jnt.Bench.Bench.getSegmentValues_I__D_36C3CC1F;
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
 * getSegmentValues(I)[D
 * [count=4] [20] ILOAD(3) [21] ALOAD(2) [22] ARRAYLENGTH [23] IF_ICMPLT(8)
 */
public final class getSegmentValues_007 extends JJITAbstractInstruction implements Cloneable{
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
         // *********[20] ILOAD(3)
         // **REMOVED Substitution** s0 = frame.getLocal(3);
         // *********[21] ALOAD(2)
         // **REMOVED Substitution** s1 = frame.getLocal(2);
         // *********[22] ARRAYLENGTH
         // **REMOVED Substitution** s1 = new KInteger(c_memman.getArraySize(((KReference)frame.getLocal(2))));
         // *********[23] IF_ICMPLT(8)
         // **REMOVED Substitution** index = c_memman.getArraySize(((KReference)frame.getLocal(2)));
         // **REMOVED Substitution** jump = frame.getLocal(3).intValue() < c_memman.getArraySize(((KReference)frame.getLocal(2)));
        return ((frame.getLocal(3).intValue() < c_memman.getArraySize(((KReference)frame.getLocal(2))))?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[20] ILOAD(3)
         // *********[21] ALOAD(2)
         // *********[22] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[23] IF_ICMPLT(8)
        c_next = instructions[(index + 1)];
        c_label = instructions[4];
      }
}
