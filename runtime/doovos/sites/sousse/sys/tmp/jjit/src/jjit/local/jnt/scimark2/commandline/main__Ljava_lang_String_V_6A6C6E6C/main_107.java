package jjit.local.jnt.scimark2.commandline.main__Ljava_lang_String_V_6A6C6E6C;
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
 * jnt.scimark2.commandline
 * main([Ljava/lang/String;)V
 * [count=2] [288] LDC(56->"os.arch") [289] INVOKESTATIC(java.lang.System,getProperty(Ljava/lang/String;)Ljava/lang/String;)
 */
public final class main_107 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R56 = null;
      private KClassRepository c_repo;
      private KClass c_CSystem = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s0_ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // *********[288] LDC(56->"os.arch")
         // **REMOVED Substitution** s0_ref = R56;
         // *********[289] INVOKESTATIC(java.lang.System,getProperty(Ljava/lang/String;)Ljava/lang/String;)
        regs = new KRegister[1];
        regs[0] = R56;
        if(c_CSystem == null){
          c_CSystem = c_repo.getClassByName("java.lang.System");
        }
        if(m_mth == null){
          m_mth = c_CSystem.getMethodBySignature("getProperty(Ljava/lang/String;)Ljava/lang/String;");
        }
        frame.setProgramCounter(107);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[288] LDC(56->"os.arch")
        R56 = ((KReference)constants[56]);
         // *********[289] INVOKESTATIC(java.lang.System,getProperty(Ljava/lang/String;)Ljava/lang/String;)
        c_repo = process.getClassRepository();
      }
}
