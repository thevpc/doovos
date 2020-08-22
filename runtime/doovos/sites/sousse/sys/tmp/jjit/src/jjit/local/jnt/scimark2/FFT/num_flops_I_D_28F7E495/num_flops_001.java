package jjit.local.jnt.scimark2.FFT.num_flops_I_D_28F7E495;
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
 * num_flops(I)D
 * [count=5] [0] ILOAD(0) [1] I2D [2] DSTORE(1) [3] ILOAD(0) [4] INVOKESTATIC(jnt.scimark2.FFT,log2(I)I)
 */
public final class num_flops_001 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CFFT = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_0 0 ; r=2/w=0 : Cached
        int local_0 = frame.getLocal(0).intValue();
         // local_1 1 ; r=0/w=1 : NotCached
         // *********[0] ILOAD(0)
         // **REMOVED Substitution** s0 = new KInteger(local_0);
         // *********[1] I2D
         // **REMOVED Substitution** s0 = new KDouble(local_0);
         // *********[2] DSTORE(1)
        frame.setLocal(1,new KDouble(local_0));
         // *********[3] ILOAD(0)
         // **REMOVED Substitution** s0 = new KInteger(local_0);
         // *********[4] INVOKESTATIC(jnt.scimark2.FFT,log2(I)I)
        regs = new KRegister[1];
        regs[0] = new KInteger(local_0);
        if(m_mth == null){
          m_mth = c_CFFT.getMethodBySignature("log2(I)I");
        }
        frame.setProgramCounter(1);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ILOAD(0)
         // *********[1] I2D
         // *********[2] DSTORE(1)
         // *********[3] ILOAD(0)
         // *********[4] INVOKESTATIC(jnt.scimark2.FFT,log2(I)I)
        c_repo = process.getClassRepository();
        c_CFFT = c_repo.getClassByName("jnt.scimark2.FFT");
      }
}
