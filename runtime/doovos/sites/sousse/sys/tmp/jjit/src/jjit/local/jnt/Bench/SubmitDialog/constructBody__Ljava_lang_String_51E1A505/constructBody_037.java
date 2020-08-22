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
 * [count=4] [83] ALOAD(0) [84] ALOAD(0) [85] LDC(57->"os.version") [86] INVOKEVIRTUAL(jnt.Bench.SubmitDialog,getSysProp(Ljava/lang/String;)Ljava/lang/String;)
 */
public final class constructBody_037 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R57 = null;
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
         // *********[83] ALOAD(0)
        frame.push(this_ref);
         // *********[84] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[85] LDC(57->"os.version")
         // **REMOVED Substitution** s1_ref = R57;
         // *********[86] INVOKEVIRTUAL(jnt.Bench.SubmitDialog,getSysProp(Ljava/lang/String;)Ljava/lang/String;)
        regs = new KRegister[2];
        regs[1] = R57;
         // **REMOVED Substitution** ref = this_ref;
        regs[0] = this_ref;
        frame.setProgramCounter(37);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("getSysProp(Ljava/lang/String;)Ljava/lang/String;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("getSysProp(Ljava/lang/String;)Ljava/lang/String;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[83] ALOAD(0)
         // *********[84] ALOAD(0)
         // *********[85] LDC(57->"os.version")
        R57 = ((KReference)constants[57]);
         // *********[86] INVOKEVIRTUAL(jnt.Bench.SubmitDialog,getSysProp(Ljava/lang/String;)Ljava/lang/String;)
        c_memman = process.getMemoryManager();
      }
}
