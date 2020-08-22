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
 * [count=4] [15] ALOAD(0) [16] ICONST_0(Integer{0}) [17] AALOAD [18] LDC(3->"-h")
 */
public final class main_002 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private static KReference R3 = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** KReference ref;
         // local_0 0 ; r=1/w=0 : NotCached
         // *********[15] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[16] ICONST_0(Integer{0})
         // **REMOVED Substitution** s1 = IZERO;
         // *********[17] AALOAD
         // **REMOVED Substitution** index = 0;
         // **REMOVED Substitution** ref = ((KReference)frame.getLocal(0));
        frame.push(c_memman.getReferenceArray(((KReference)frame.getLocal(0)),0));
         // *********[18] LDC(3->"-h")
        frame.push(R3);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[15] ALOAD(0)
         // *********[16] ICONST_0(Integer{0})
         // *********[17] AALOAD
        c_memman = process.getMemoryManager();
         // *********[18] LDC(3->"-h")
        R3 = ((KReference)constants[3]);
        c_next = instructions[(index + 1)];
      }
}
