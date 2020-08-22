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
 * [count=3] [128] ALOAD(8) [129] SIPUSH(Integer{354}) [130] INVOKESTATIC(jnt.Bench.SendMail,check(Ljava/io/DataInputStream;I)V)
 */
public final class send_070 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger I354 = new KInteger(354);
      private KClassRepository c_repo;
      private KClass c_CSendMail = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_8 8 ; r=1/w=0 : NotCached
         // *********[128] ALOAD(8)
         // **REMOVED Substitution** s0 = frame.getLocal(8);
         // *********[129] SIPUSH(Integer{354})
         // **REMOVED Substitution** s1 = I354;
         // *********[130] INVOKESTATIC(jnt.Bench.SendMail,check(Ljava/io/DataInputStream;I)V)
        regs = new KRegister[2];
        regs[1] = I354;
        regs[0] = frame.getLocal(8);
        if(m_mth == null){
          m_mth = c_CSendMail.getMethodBySignature("check(Ljava/io/DataInputStream;I)V");
        }
        frame.setProgramCounter(70);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[128] ALOAD(8)
         // *********[129] SIPUSH(Integer{354})
         // *********[130] INVOKESTATIC(jnt.Bench.SendMail,check(Ljava/io/DataInputStream;I)V)
        c_repo = process.getClassRepository();
        c_CSendMail = c_repo.getClassByName("jnt.Bench.SendMail");
      }
}
