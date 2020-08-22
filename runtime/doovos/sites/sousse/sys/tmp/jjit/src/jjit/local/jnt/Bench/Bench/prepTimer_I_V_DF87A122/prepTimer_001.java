package jjit.local.jnt.Bench.Bench.prepTimer_I_V_DF87A122;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Bench
 * prepTimer(I)V
 * [count=6] [0] ALOAD(0) [1] ICONST_1(Integer{1}) [2] PUTFIELD(jnt.Bench.Bench,timerAPIused) [3] ALOAD(0) [4] LDC(103->"GC'ing") [5] INVOKEVIRTUAL(jnt.Bench.Bench,noteStatus(Ljava/lang/String;)V)
 */
public final class prepTimer_001 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger IONE = KInteger.ONE;
      private KField c_timerAPIused = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private static KReference R103 = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KRegister reg;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[0] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[1] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[2] PUTFIELD(jnt.Bench.Bench,timerAPIused)
         // **REMOVED Substitution** reg = IONE;
         // **REMOVED Substitution** ref = this_ref;
        c_timerAPIused.setInstanceValue(this_ref,IONE);
         // *********[3] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[4] LDC(103->"GC'ing")
         // **REMOVED Substitution** s1_ref = R103;
         // *********[5] INVOKEVIRTUAL(jnt.Bench.Bench,noteStatus(Ljava/lang/String;)V)
        regs = new KRegister[2];
        regs[1] = R103;
         // **REMOVED Substitution** ref = this_ref;
        regs[0] = this_ref;
        frame.setProgramCounter(1);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("noteStatus(Ljava/lang/String;)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("noteStatus(Ljava/lang/String;)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] ICONST_1(Integer{1})
         // *********[2] PUTFIELD(jnt.Bench.Bench,timerAPIused)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_timerAPIused = c_CBench.getField("timerAPIused",true);
         // *********[3] ALOAD(0)
         // *********[4] LDC(103->"GC'ing")
        R103 = ((KReference)constants[103]);
         // *********[5] INVOKEVIRTUAL(jnt.Bench.Bench,noteStatus(Ljava/lang/String;)V)
        c_memman = process.getMemoryManager();
      }
}
