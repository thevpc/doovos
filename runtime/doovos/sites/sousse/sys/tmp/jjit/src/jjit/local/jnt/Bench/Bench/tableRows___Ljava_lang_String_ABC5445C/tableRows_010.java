package jjit.local.jnt.Bench.Bench.tableRows___Ljava_lang_String_ABC5445C;
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
 * jnt.Bench.Bench
 * tableRows()[Ljava/lang/String;
 * [count=2] [47] ICONST_1(Integer{1}) [48] INVOKESTATIC(jnt.Bench.Formatter,addColumn([Ljava/lang/String;[Ljava/lang/String;I)V)
 */
public final class tableRows_010 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger IONE = KInteger.ONE;
      private KClassRepository c_repo;
      private KClass c_CFormatter = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // *********[47] ICONST_1(Integer{1})
         // **REMOVED Substitution** s0 = IONE;
         // *********[48] INVOKESTATIC(jnt.Bench.Formatter,addColumn([Ljava/lang/String;[Ljava/lang/String;I)V)
        regs = new KRegister[3];
        regs[2] = IONE;
        regs[1] = frame.pop();
        regs[0] = frame.pop();
        if(c_CFormatter == null){
          c_CFormatter = c_repo.getClassByName("jnt.Bench.Formatter");
        }
        if(m_mth == null){
          m_mth = c_CFormatter.getMethodBySignature("addColumn([Ljava/lang/String;[Ljava/lang/String;I)V");
        }
        frame.setProgramCounter(10);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[47] ICONST_1(Integer{1})
         // *********[48] INVOKESTATIC(jnt.Bench.Formatter,addColumn([Ljava/lang/String;[Ljava/lang/String;I)V)
        c_repo = process.getClassRepository();
      }
}
