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
 * [count=3] [15] ISTORE(3) [16] ALOAD(0) [17] INVOKESTATIC(jnt.scimark2.FFT,bitreverse([D)V)
 */
public final class transform_internal_006 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CFFT = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_3 3 ; r=0/w=1 : NotCached
         // *********[15] ISTORE(3)
        frame.setLocal(3,new KInteger(frame.popInt()));
         // *********[16] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[17] INVOKESTATIC(jnt.scimark2.FFT,bitreverse([D)V)
        regs = new KRegister[1];
        regs[0] = frame.getLocal(0);
        if(m_mth == null){
          m_mth = c_CFFT.getMethodBySignature("bitreverse([D)V");
        }
        frame.setProgramCounter(6);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[15] ISTORE(3)
         // *********[16] ALOAD(0)
         // *********[17] INVOKESTATIC(jnt.scimark2.FFT,bitreverse([D)V)
        c_repo = process.getClassRepository();
        c_CFFT = c_repo.getClassByName("jnt.scimark2.FFT");
      }
}
