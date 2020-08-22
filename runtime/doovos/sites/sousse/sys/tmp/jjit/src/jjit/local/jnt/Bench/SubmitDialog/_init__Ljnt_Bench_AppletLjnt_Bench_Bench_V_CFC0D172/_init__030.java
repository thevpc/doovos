package jjit.local.jnt.Bench.SubmitDialog._init__Ljnt_Bench_AppletLjnt_Bench_Bench_V_CFC0D172;
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
 * jnt.Bench.SubmitDialog
 * <init>(Ljnt/Bench/Applet;Ljnt/Bench/Bench;)V
 * [count=3] [57] ICONST_2(Integer{2}) [58] IADD [59] INVOKESPECIAL(java.awt.Font,<init>(Ljava/lang/String;II)V)
 */
public final class _init__030 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private KClassRepository c_repo;
      private KClass c_CFont = null;
      private KMethod m_mth = null;
      private boolean m_mth_ignorable = false;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** int index = 0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KReference ref;
        JJITInstruction nextInstr;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // *********[57] ICONST_2(Integer{2})
         // **REMOVED Substitution** s0 = ITWO;
         // *********[58] IADD
         // **REMOVED Substitution** index = 2;
         // **REMOVED Substitution** s0 = new KInteger((frame.popInt() + 2));
         // *********[59] INVOKESPECIAL(java.awt.Font,<init>(Ljava/lang/String;II)V)
        regs = new KRegister[4];
        if(c_CFont == null){
          c_CFont = c_repo.getClassByName("java.awt.Font");
        }
        if(m_mth == null){
          m_mth = c_CFont.getMethodBySignature("<init>(Ljava/lang/String;II)V");
          m_mth_ignorable = m_mth.isIgnorable();
        }
        regs[3] = new KInteger((frame.popInt() + 2));
        regs[2] = frame.pop();
        regs[1] = frame.pop();
         // **REMOVED Substitution** ref = frame.popRef();
        regs[0] = frame.popRef();
        if(m_mth_ignorable){
          nextInstr = c_next;
        }else{
          frame.setProgramCounter(30);
           // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
          nextInstr = ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
        }
        return nextInstr;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[57] ICONST_2(Integer{2})
         // *********[58] IADD
         // *********[59] INVOKESPECIAL(java.awt.Font,<init>(Ljava/lang/String;II)V)
        c_next = instructions[(index + 1)];
        c_repo = process.getClassRepository();
      }
}
