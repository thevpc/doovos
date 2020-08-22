package jjit.local.jnt.Bench.SendMail.send_Ljava_lang_StringLjava_lang_StringLjava_lang_StringLjava_lang_StringLjava_lang_String_V_56E49BAB;
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
 * jnt.Bench.SendMail
 * send(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
 * [count=3] [125] ALOAD(7) [126] LDC(33->"DATA") [127] INVOKESTATIC(jnt.Bench.SendMail,docmd(Ljava/io/PrintStream;Ljava/lang/String;)V)
 */
public final class send_069 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R33 = null;
      private KClassRepository c_repo;
      private KClass c_CSendMail = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_7 7 ; r=1/w=0 : NotCached
         // *********[125] ALOAD(7)
         // **REMOVED Substitution** s0 = frame.getLocal(7);
         // *********[126] LDC(33->"DATA")
         // **REMOVED Substitution** s1_ref = R33;
         // *********[127] INVOKESTATIC(jnt.Bench.SendMail,docmd(Ljava/io/PrintStream;Ljava/lang/String;)V)
        regs = new KRegister[2];
        regs[1] = R33;
        regs[0] = frame.getLocal(7);
        if(m_mth == null){
          m_mth = c_CSendMail.getMethodBySignature("docmd(Ljava/io/PrintStream;Ljava/lang/String;)V");
        }
        frame.setProgramCounter(69);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[125] ALOAD(7)
         // *********[126] LDC(33->"DATA")
        R33 = ((KReference)constants[33]);
         // *********[127] INVOKESTATIC(jnt.Bench.SendMail,docmd(Ljava/io/PrintStream;Ljava/lang/String;)V)
        c_repo = process.getClassRepository();
        c_CSendMail = c_repo.getClassByName("jnt.Bench.SendMail");
      }
}
