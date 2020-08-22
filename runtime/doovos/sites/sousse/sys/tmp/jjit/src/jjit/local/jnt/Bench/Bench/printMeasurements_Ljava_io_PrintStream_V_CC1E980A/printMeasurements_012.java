package jjit.local.jnt.Bench.Bench.printMeasurements_Ljava_io_PrintStream_V_CC1E980A;
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
 * printMeasurements(Ljava/io/PrintStream;)V
 * [count=2] [37] ICONST_0(Integer{0}) [38] INVOKESTATIC(jnt.Bench.Formatter,addColumn([Ljava/lang/String;[Ljava/lang/String;I)V)
 */
public final class printMeasurements_012 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger IZERO = KInteger.ZERO;
      private KClassRepository c_repo;
      private KClass c_CFormatter = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // *********[37] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[38] INVOKESTATIC(jnt.Bench.Formatter,addColumn([Ljava/lang/String;[Ljava/lang/String;I)V)
        regs = new KRegister[3];
        regs[2] = IZERO;
        regs[1] = frame.pop();
        regs[0] = frame.pop();
        if(c_CFormatter == null){
          c_CFormatter = c_repo.getClassByName("jnt.Bench.Formatter");
        }
        if(m_mth == null){
          m_mth = c_CFormatter.getMethodBySignature("addColumn([Ljava/lang/String;[Ljava/lang/String;I)V");
        }
        frame.setProgramCounter(12);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[37] ICONST_0(Integer{0})
         // *********[38] INVOKESTATIC(jnt.Bench.Formatter,addColumn([Ljava/lang/String;[Ljava/lang/String;I)V)
        c_repo = process.getClassRepository();
      }
}
