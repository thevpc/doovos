package jjit.local.jnt.scimark2.kernel.measureFFT_IDLjnt_scimark2_Random_D_D04C475C;
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
 * jnt.scimark2.kernel
 * measureFFT(IDLjnt/scimark2/Random;)D
 * [count=2] [45] ALOAD(4) [46] INVOKESTATIC(jnt.scimark2.FFT,test([D)D)
 */
public final class measureFFT_018 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CFFT = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_4 4 ; r=1/w=0 : NotCached
         // *********[45] ALOAD(4)
         // **REMOVED Substitution** s0 = frame.getLocal(4);
         // *********[46] INVOKESTATIC(jnt.scimark2.FFT,test([D)D)
        regs = new KRegister[1];
        regs[0] = frame.getLocal(4);
        if(c_CFFT == null){
          c_CFFT = c_repo.getClassByName("jnt.scimark2.FFT");
        }
        if(m_mth == null){
          m_mth = c_CFFT.getMethodBySignature("test([D)D");
        }
        frame.setProgramCounter(18);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[45] ALOAD(4)
         // *********[46] INVOKESTATIC(jnt.scimark2.FFT,test([D)D)
        c_repo = process.getClassRepository();
      }
}
