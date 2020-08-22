package jjit.local.jnt.Bench.Formatter.addColumn__Ljava_lang_String_Ljava_lang_StringI_V_F11D9847;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Formatter
 * addColumn([Ljava/lang/String;[Ljava/lang/String;I)V
 * [count=5] [57] ISUB [58] ILOAD(2) [59] IMUL [60] IADD [61] INVOKESTATIC(jnt.Bench.Formatter,pad(CI)Ljava/lang/String;)
 */
public final class addColumn_015 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CFormatter = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
        int index = 0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[57] ISUB
        index = frame.popInt();
         // **REMOVED Substitution** s0 = new KInteger((frame.popInt() - index));
         // *********[58] ILOAD(2)
         // **REMOVED Substitution** s1 = frame.getLocal(2);
         // *********[59] IMUL
         // **REMOVED Substitution** index = frame.getLocal(2).intValue();
         // **REMOVED Substitution** s0 = new KInteger((s0.intValue() * frame.getLocal(2).intValue()));
         // *********[60] IADD
        index = ((frame.popInt() - index) * frame.getLocal(2).intValue());
         // **REMOVED Substitution** s0 = new KInteger((frame.popInt() + index));
         // *********[61] INVOKESTATIC(jnt.Bench.Formatter,pad(CI)Ljava/lang/String;)
        regs = new KRegister[2];
        regs[1] = new KInteger((frame.popInt() + index));
        regs[0] = frame.pop();
        if(m_mth == null){
          m_mth = c_CFormatter.getMethodBySignature("pad(CI)Ljava/lang/String;");
        }
        frame.setProgramCounter(15);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[57] ISUB
         // *********[58] ILOAD(2)
         // *********[59] IMUL
         // *********[60] IADD
         // *********[61] INVOKESTATIC(jnt.Bench.Formatter,pad(CI)Ljava/lang/String;)
        c_repo = process.getClassRepository();
        c_CFormatter = c_repo.getClassByName("jnt.Bench.Formatter");
      }
}
