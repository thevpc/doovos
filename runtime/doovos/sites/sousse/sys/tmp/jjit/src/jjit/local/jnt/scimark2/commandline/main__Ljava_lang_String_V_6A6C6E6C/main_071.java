package jjit.local.jnt.scimark2.commandline.main__Ljava_lang_String_V_6A6C6E6C;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.commandline
 * main([Ljava/lang/String;)V
 * [count=4] [207] GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;) [208] NEW(java.lang.StringBuffer) [209] DUP [210] INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
 */
public final class main_071 extends JJITAbstractInstruction implements Cloneable{
      private KField c_out = null;
      private KClassRepository c_repo;
      private KClass c_CStringBuffer = null;
      private JJITInstruction c_next;
      private KMethod m_mth = null;
      private boolean m_mth_ignorable = false;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KReference ref;
        JJITInstruction nextInstr;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // *********[207] GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
        if(c_out == null){
          c_out = c_repo.getClassByName("java.lang.System").getField("out",true);
        }
        frame.push(c_out.getStaticValue());
         // *********[208] NEW(java.lang.StringBuffer)
        if(c_CStringBuffer == null){
          c_CStringBuffer = c_repo.getClassByName("java.lang.StringBuffer");
        }
        s0_ref = memseg.allocObject(c_CStringBuffer);
         // *********[209] DUP
        frame.push(s0_ref);
         // **REMOVED Substitution** s1_ref = s0_ref;
         // *********[210] INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
        regs = new KRegister[1];
        if(m_mth == null){
          m_mth = c_CStringBuffer.getMethodBySignature("<init>()V");
          m_mth_ignorable = m_mth.isIgnorable();
        }
         // **REMOVED Substitution** ref = s0_ref;
        regs[0] = s0_ref;
        if(m_mth_ignorable){
          nextInstr = c_next;
        }else{
          frame.setProgramCounter(71);
           // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
          nextInstr = ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
        }
        return nextInstr;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[207] GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
        c_repo = process.getClassRepository();
         // *********[208] NEW(java.lang.StringBuffer)
        c_repo = process.getClassRepository();
         // *********[209] DUP
         // *********[210] INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
        c_next = instructions[(index + 1)];
      }
}
