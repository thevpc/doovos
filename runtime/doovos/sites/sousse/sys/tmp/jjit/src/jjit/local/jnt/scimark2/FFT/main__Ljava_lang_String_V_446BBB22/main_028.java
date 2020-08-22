package jjit.local.jnt.scimark2.FFT.main__Ljava_lang_String_V_446BBB22;
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
 * jnt.scimark2.FFT
 * main([Ljava/lang/String;)V
 * [count=4] [46] ILOAD(1) [47] ALOAD(0) [48] ARRAYLENGTH [49] IF_ICMPLT(24)
 */
public final class main_028 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[46] ILOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[47] ALOAD(0)
         // **REMOVED Substitution** s1 = frame.getLocal(0);
         // *********[48] ARRAYLENGTH
         // **REMOVED Substitution** s1 = new KInteger(c_memman.getArraySize(((KReference)frame.getLocal(0))));
         // *********[49] IF_ICMPLT(24)
         // **REMOVED Substitution** index = c_memman.getArraySize(((KReference)frame.getLocal(0)));
         // **REMOVED Substitution** jump = frame.getLocal(1).intValue() < c_memman.getArraySize(((KReference)frame.getLocal(0)));
        return ((frame.getLocal(1).intValue() < c_memman.getArraySize(((KReference)frame.getLocal(0))))?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[46] ILOAD(1)
         // *********[47] ALOAD(0)
         // *********[48] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[49] IF_ICMPLT(24)
        c_next = instructions[(index + 1)];
        c_label = instructions[16];
      }
}
