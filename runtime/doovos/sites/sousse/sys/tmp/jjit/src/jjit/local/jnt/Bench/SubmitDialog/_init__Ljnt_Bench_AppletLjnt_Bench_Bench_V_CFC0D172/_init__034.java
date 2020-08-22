package jjit.local.jnt.Bench.SubmitDialog._init__Ljnt_Bench_AppletLjnt_Bench_Bench_V_CFC0D172;
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
 * <init>(Ljnt/Bench/Applet;Ljnt/Bench/Bench;)V
 * [count=7] [86] POP [87] ALOAD(0) [88] ALOAD(0) [89] LDC(40->"Your Name:") [90] ICONST_1(Integer{1}) [91] LDC(41->"") [92] INVOKEVIRTUAL(jnt.Bench.SubmitDialog,addField(Ljava/lang/String;ILjava/lang/String;)Ljava/awt/TextComponent;)
 */
public final class _init__034 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R40 = null;
      private static final KInteger IONE = KInteger.ONE;
      private static KReference R41 = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KReference s3_ref;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KReference s0_ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[86] POP
        frame.pop();
         // *********[87] ALOAD(0)
        frame.push(this_ref);
         // *********[88] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[89] LDC(40->"Your Name:")
         // **REMOVED Substitution** s1_ref = R40;
         // *********[90] ICONST_1(Integer{1})
         // **REMOVED Substitution** s2 = IONE;
         // *********[91] LDC(41->"")
         // **REMOVED Substitution** s3_ref = R41;
         // *********[92] INVOKEVIRTUAL(jnt.Bench.SubmitDialog,addField(Ljava/lang/String;ILjava/lang/String;)Ljava/awt/TextComponent;)
        regs = new KRegister[4];
        regs[3] = R41;
        regs[2] = IONE;
        regs[1] = R40;
         // **REMOVED Substitution** ref = this_ref;
        regs[0] = this_ref;
        frame.setProgramCounter(34);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("addField(Ljava/lang/String;ILjava/lang/String;)Ljava/awt/TextComponent;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("addField(Ljava/lang/String;ILjava/lang/String;)Ljava/awt/TextComponent;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[86] POP
         // *********[87] ALOAD(0)
         // *********[88] ALOAD(0)
         // *********[89] LDC(40->"Your Name:")
        R40 = ((KReference)constants[40]);
         // *********[90] ICONST_1(Integer{1})
         // *********[91] LDC(41->"")
        R41 = ((KReference)constants[41]);
         // *********[92] INVOKEVIRTUAL(jnt.Bench.SubmitDialog,addField(Ljava/lang/String;ILjava/lang/String;)Ljava/awt/TextComponent;)
        c_memman = process.getMemoryManager();
      }
}
