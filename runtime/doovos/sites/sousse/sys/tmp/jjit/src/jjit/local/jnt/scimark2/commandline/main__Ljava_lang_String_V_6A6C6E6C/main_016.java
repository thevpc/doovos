package jjit.local.jnt.scimark2.commandline.main__Ljava_lang_String_V_6A6C6E6C;
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
 * jnt.scimark2.commandline
 * main([Ljava/lang/String;)V
 * [count=4] [50] ALOAD(0) [51] ARRAYLENGTH [52] ILOAD(8) [53] IF_ICMPLE(60)
 */
public final class main_016 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_8 8 ; r=1/w=0 : NotCached
         // *********[50] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[51] ARRAYLENGTH
         // **REMOVED Substitution** s0 = new KInteger(c_memman.getArraySize(((KReference)frame.getLocal(0))));
         // *********[52] ILOAD(8)
         // **REMOVED Substitution** s1 = frame.getLocal(8);
         // *********[53] IF_ICMPLE(60)
         // **REMOVED Substitution** index = frame.getLocal(8).intValue();
         // **REMOVED Substitution** jump = c_memman.getArraySize(((KReference)frame.getLocal(0))) <= frame.getLocal(8).intValue();
        return ((c_memman.getArraySize(((KReference)frame.getLocal(0))) <= frame.getLocal(8).intValue())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[50] ALOAD(0)
         // *********[51] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[52] ILOAD(8)
         // *********[53] IF_ICMPLE(60)
        c_next = instructions[(index + 1)];
        c_label = instructions[21];
      }
}
