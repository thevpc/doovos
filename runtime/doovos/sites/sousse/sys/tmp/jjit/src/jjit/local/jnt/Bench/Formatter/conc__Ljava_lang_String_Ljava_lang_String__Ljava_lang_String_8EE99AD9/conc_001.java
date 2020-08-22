package jjit.local.jnt.Bench.Formatter.conc__Ljava_lang_String_Ljava_lang_String__Ljava_lang_String_8EE99AD9;
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
 * conc([Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;
 * [count=5] [0] ALOAD(0) [1] ARRAYLENGTH [2] ALOAD(1) [3] ARRAYLENGTH [4] IADD
 */
public final class conc_001 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[0] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[1] ARRAYLENGTH
         // **REMOVED Substitution** s0 = new KInteger(c_memman.getArraySize(((KReference)frame.getLocal(0))));
         // *********[2] ALOAD(1)
         // **REMOVED Substitution** s1 = frame.getLocal(1);
         // *********[3] ARRAYLENGTH
         // **REMOVED Substitution** s1 = new KInteger(c_memman.getArraySize(((KReference)frame.getLocal(1))));
         // *********[4] IADD
         // **REMOVED Substitution** index = c_memman.getArraySize(((KReference)frame.getLocal(1)));
        frame.push(new KInteger((c_memman.getArraySize(((KReference)frame.getLocal(0))) + c_memman.getArraySize(((KReference)frame.getLocal(1))))));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[2] ALOAD(1)
         // *********[3] ARRAYLENGTH
         // *********[4] IADD
        c_next = instructions[(index + 1)];
      }
}
