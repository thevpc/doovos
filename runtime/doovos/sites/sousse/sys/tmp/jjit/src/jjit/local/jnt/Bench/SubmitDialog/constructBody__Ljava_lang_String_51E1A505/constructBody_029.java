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
 * [count=4] [66] ALOAD(0) [67] ALOAD(0) [68] LDC(53->"os.name") [69] INVOKEVIRTUAL(jnt.Bench.SubmitDialog,getSysProp(Ljava/lang/String;)Ljava/lang/String;)
 */
public final class constructBody_029 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R53 = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KReference s0_ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[66] ALOAD(0)
        frame.push(this_ref);
         // *********[67] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[68] LDC(53->"os.name")
         // **REMOVED Substitution** s1_ref = R53;
         // *********[69] INVOKEVIRTUAL(jnt.Bench.SubmitDialog,getSysProp(Ljava/lang/String;)Ljava/lang/String;)
        regs = new KRegister[2];
        regs[1] = R53;
         // **REMOVED Substitution** ref = this_ref;
        regs[0] = this_ref;
        frame.setProgramCounter(29);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("getSysProp(Ljava/lang/String;)Ljava/lang/String;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("getSysProp(Ljava/lang/String;)Ljava/lang/String;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[66] ALOAD(0)
         // *********[67] ALOAD(0)
         // *********[68] LDC(53->"os.name")
        R53 = ((KReference)constants[53]);
         // *********[69] INVOKEVIRTUAL(jnt.Bench.SubmitDialog,getSysProp(Ljava/lang/String;)Ljava/lang/String;)
        c_memman = process.getMemoryManager();
      }
}
