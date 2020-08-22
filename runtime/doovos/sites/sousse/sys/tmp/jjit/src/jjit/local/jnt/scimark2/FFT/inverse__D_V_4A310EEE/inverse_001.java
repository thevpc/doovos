package jjit.local.jnt.scimark2.FFT.inverse__D_V_4A310EEE;
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
 * jnt.scimark2.FFT
 * inverse([D)V
 * [count=3] [0] ALOAD(0) [1] ICONST_1(Integer{1}) [2] INVOKESTATIC(jnt.scimark2.FFT,transform_internal([DI)V)
 */
public final class inverse_001 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger IONE = KInteger.ONE;
      private KClassRepository c_repo;
      private KClass c_CFFT = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_0 0 ; r=1/w=0 : NotCached
         // *********[0] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[1] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[2] INVOKESTATIC(jnt.scimark2.FFT,transform_internal([DI)V)
        regs = new KRegister[2];
        regs[1] = IONE;
        regs[0] = frame.getLocal(0);
        if(m_mth == null){
          m_mth = c_CFFT.getMethodBySignature("transform_internal([DI)V");
        }
        frame.setProgramCounter(1);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] ICONST_1(Integer{1})
         // *********[2] INVOKESTATIC(jnt.scimark2.FFT,transform_internal([DI)V)
        c_repo = process.getClassRepository();
        c_CFFT = c_repo.getClassByName("jnt.scimark2.FFT");
      }
}
