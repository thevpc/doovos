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
 * [count=2] [299] LDC(58->"os.name") [300] INVOKESTATIC(java.lang.System,getProperty(Ljava/lang/String;)Ljava/lang/String;)
 */
public final class main_113 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R58 = null;
      private KClassRepository c_repo;
      private KClass c_CSystem = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s0_ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // *********[299] LDC(58->"os.name")
         // **REMOVED Substitution** s0_ref = R58;
         // *********[300] INVOKESTATIC(java.lang.System,getProperty(Ljava/lang/String;)Ljava/lang/String;)
        regs = new KRegister[1];
        regs[0] = R58;
        if(c_CSystem == null){
          c_CSystem = c_repo.getClassByName("java.lang.System");
        }
        if(m_mth == null){
          m_mth = c_CSystem.getMethodBySignature("getProperty(Ljava/lang/String;)Ljava/lang/String;");
        }
        frame.setProgramCounter(113);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[299] LDC(58->"os.name")
        R58 = ((KReference)constants[58]);
         // *********[300] INVOKESTATIC(java.lang.System,getProperty(Ljava/lang/String;)Ljava/lang/String;)
        c_repo = process.getClassRepository();
      }
}
