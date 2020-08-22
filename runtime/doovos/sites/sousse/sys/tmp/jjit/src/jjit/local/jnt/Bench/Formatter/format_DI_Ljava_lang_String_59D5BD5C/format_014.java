package jjit.local.jnt.Bench.Formatter.format_DI_Ljava_lang_String_59D5BD5C;
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
 * format(DI)Ljava/lang/String;
 * [count=4] [35] ISUB [36] ICONST_1(Integer{1}) [37] IADD [38] INVOKESTATIC(jnt.Bench.Formatter,pad(CI)Ljava/lang/String;)
 */
public final class format_014 extends JJITAbstractInstruction implements Cloneable{
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
         // *********[35] ISUB
        index = frame.popInt();
         // **REMOVED Substitution** s0 = new KInteger((frame.popInt() - index));
         // *********[36] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[37] IADD
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s0 = new KInteger((s0.intValue() + 1));
         // *********[38] INVOKESTATIC(jnt.Bench.Formatter,pad(CI)Ljava/lang/String;)
        regs = new KRegister[2];
        regs[1] = new KInteger(((frame.popInt() - index) + 1));
        regs[0] = frame.pop();
        if(m_mth == null){
          m_mth = c_CFormatter.getMethodBySignature("pad(CI)Ljava/lang/String;");
        }
        frame.setProgramCounter(14);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[35] ISUB
         // *********[36] ICONST_1(Integer{1})
         // *********[37] IADD
         // *********[38] INVOKESTATIC(jnt.Bench.Formatter,pad(CI)Ljava/lang/String;)
        c_repo = process.getClassRepository();
        c_CFormatter = c_repo.getClassByName("jnt.Bench.Formatter");
      }
}
