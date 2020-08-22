package jjit.local.jnt.Bench.Bench.main__Ljava_lang_String_V_8024FB52;
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
 * main([Ljava/lang/String;)V
 * [count=4] [7] ALOAD(0) [8] ICONST_0(Integer{0}) [9] AALOAD [10] GOTO(12)
 */
public final class main_002 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** KReference ref;
         // local_0 0 ; r=1/w=0 : NotCached
         // *********[7] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[8] ICONST_0(Integer{0})
         // **REMOVED Substitution** s1 = IZERO;
         // *********[9] AALOAD
         // **REMOVED Substitution** index = 0;
         // **REMOVED Substitution** ref = ((KReference)frame.getLocal(0));
        frame.push(c_memman.getReferenceArray(((KReference)frame.getLocal(0)),0));
         // *********[10] GOTO(12)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[7] ALOAD(0)
         // *********[8] ICONST_0(Integer{0})
         // *********[9] AALOAD
        c_memman = process.getMemoryManager();
         // *********[10] GOTO(12)
        c_label = instructions[3];
      }
}
