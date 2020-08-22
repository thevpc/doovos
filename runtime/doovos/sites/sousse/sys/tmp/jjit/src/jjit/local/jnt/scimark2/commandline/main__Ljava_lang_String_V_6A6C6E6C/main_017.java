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
 * [count=3] [54] ALOAD(0) [55] ILOAD(8) [56] AALOAD
 */
public final class main_017 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** KReference ref;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_8 8 ; r=1/w=0 : NotCached
         // *********[54] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[55] ILOAD(8)
         // **REMOVED Substitution** s1 = frame.getLocal(8);
         // *********[56] AALOAD
         // **REMOVED Substitution** index = frame.getLocal(8).intValue();
         // **REMOVED Substitution** ref = ((KReference)frame.getLocal(0));
        frame.push(c_memman.getReferenceArray(((KReference)frame.getLocal(0)),frame.getLocal(8).intValue()));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[54] ALOAD(0)
         // *********[55] ILOAD(8)
         // *********[56] AALOAD
        c_memman = process.getMemoryManager();
        c_next = instructions[(index + 1)];
      }
}
