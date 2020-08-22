package jjit.local.jnt.scimark2.FFT.transform_internal__DI_V_5ED5CCC1;
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
 * transform_internal([DI)V
 * [count=2] [13] ILOAD(2) [14] INVOKESTATIC(jnt.scimark2.FFT,log2(I)I)
 */
public final class transform_internal_005 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CFFT = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[13] ILOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[14] INVOKESTATIC(jnt.scimark2.FFT,log2(I)I)
        regs = new KRegister[1];
        regs[0] = frame.getLocal(2);
        if(m_mth == null){
          m_mth = c_CFFT.getMethodBySignature("log2(I)I");
        }
        frame.setProgramCounter(5);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[13] ILOAD(2)
         // *********[14] INVOKESTATIC(jnt.scimark2.FFT,log2(I)I)
        c_repo = process.getClassRepository();
        c_CFFT = c_repo.getClassByName("jnt.scimark2.FFT");
      }
}
