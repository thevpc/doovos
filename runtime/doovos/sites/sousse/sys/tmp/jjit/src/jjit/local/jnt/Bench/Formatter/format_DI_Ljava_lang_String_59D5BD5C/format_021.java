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
 * [count=5] [56] ALOAD(6) [57] BIPUSH(48) [58] ILOAD(2) [59] INEG [60] INVOKESTATIC(jnt.Bench.Formatter,pad(CI)Ljava/lang/String;)
 */
public final class format_021 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger I48 = new KInteger(48);
      private KClassRepository c_repo;
      private KClass c_CFormatter = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_2 2 ; r=1/w=0 : NotCached
         // local_6 6 ; r=1/w=0 : NotCached
         // *********[56] ALOAD(6)
        frame.push(frame.getLocal(6));
         // *********[57] BIPUSH(48)
         // **REMOVED Substitution** s0 = I48;
         // *********[58] ILOAD(2)
         // **REMOVED Substitution** s1 = frame.getLocal(2);
         // *********[59] INEG
         // **REMOVED Substitution** s1 = new KInteger(-(frame.getLocal(2).intValue()));
         // *********[60] INVOKESTATIC(jnt.Bench.Formatter,pad(CI)Ljava/lang/String;)
        regs = new KRegister[2];
        regs[1] = new KInteger(-(frame.getLocal(2).intValue()));
        regs[0] = I48;
        if(m_mth == null){
          m_mth = c_CFormatter.getMethodBySignature("pad(CI)Ljava/lang/String;");
        }
        frame.setProgramCounter(21);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[56] ALOAD(6)
         // *********[57] BIPUSH(48)
         // *********[58] ILOAD(2)
         // *********[59] INEG
         // *********[60] INVOKESTATIC(jnt.Bench.Formatter,pad(CI)Ljava/lang/String;)
        c_repo = process.getClassRepository();
        c_CFormatter = c_repo.getClassByName("jnt.Bench.Formatter");
      }
}
