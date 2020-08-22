package jjit.local.jnt.Bench.Bench.printMeasurements_Ljava_io_PrintStream_V_CC1E980A;
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
 * printMeasurements(Ljava/io/PrintStream;)V
 * [count=4] [48] ILOAD(5) [49] ALOAD(2) [50] ARRAYLENGTH [51] IF_ICMPLT(42)
 */
public final class printMeasurements_016 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_2 2 ; r=1/w=0 : NotCached
         // local_5 5 ; r=1/w=0 : NotCached
         // *********[48] ILOAD(5)
         // **REMOVED Substitution** s0 = frame.getLocal(5);
         // *********[49] ALOAD(2)
         // **REMOVED Substitution** s1 = frame.getLocal(2);
         // *********[50] ARRAYLENGTH
         // **REMOVED Substitution** s1 = new KInteger(c_memman.getArraySize(((KReference)frame.getLocal(2))));
         // *********[51] IF_ICMPLT(42)
         // **REMOVED Substitution** index = c_memman.getArraySize(((KReference)frame.getLocal(2)));
         // **REMOVED Substitution** jump = frame.getLocal(5).intValue() < c_memman.getArraySize(((KReference)frame.getLocal(2)));
        return ((frame.getLocal(5).intValue() < c_memman.getArraySize(((KReference)frame.getLocal(2))))?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[48] ILOAD(5)
         // *********[49] ALOAD(2)
         // *********[50] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[51] IF_ICMPLT(42)
        c_next = instructions[(index + 1)];
        c_label = instructions[13];
      }
}
