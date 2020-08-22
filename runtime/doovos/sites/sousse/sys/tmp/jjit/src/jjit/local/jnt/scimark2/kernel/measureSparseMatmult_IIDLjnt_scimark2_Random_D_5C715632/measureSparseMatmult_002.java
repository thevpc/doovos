package jjit.local.jnt.scimark2.kernel.measureSparseMatmult_IIDLjnt_scimark2_Random_D_5C715632;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.kernel
 * measureSparseMatmult(IIDLjnt/scimark2/Random;)D
 * [count=15] [3] ASTORE(5) [4] ILOAD(0) [5] NEWARRAY [6] ASTORE(6) [7] ILOAD(1) [8] ILOAD(0) [9] IDIV [10] ISTORE(7) [11] ILOAD(7) [12] ILOAD(0) [13] IMUL [14] ISTORE(8) [15] ILOAD(8) [16] ALOAD(4) [17] INVOKESTATIC(jnt.scimark2.kernel,RandomVector(ILjnt/scimark2/Random;)[D)
 */
public final class measureSparseMatmult_002 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_Ckernel = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // **REMOVED Unused Var** int index = 0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_0 0 ; r=3/w=0 : Cached
        int local_0 = frame.getLocal(0).intValue();
         // local_1 1 ; r=1/w=0 : NotCached
         // local_4 4 ; r=1/w=0 : NotCached
         // local_5 5 ; r=0/w=1 : NotCached
         // local_6 6 ; r=0/w=1 : NotCached
         // local_7 7 ; r=1/w=1 : Cached
        int local_7;
         // local_8 8 ; r=1/w=1 : Cached
         // **REMOVED Unused Var** int local_8;
         // *********[3] ASTORE(5)
        frame.setLocal(5,frame.pop());
         // *********[4] ILOAD(0)
         // **REMOVED Substitution** s0 = new KInteger(local_0);
         // *********[5] NEWARRAY
         // **REMOVED Substitution** s0_ref = memseg.allocDoubleArray(local_0);
         // *********[6] ASTORE(6)
        frame.setLocal(6,memseg.allocDoubleArray(local_0));
         // *********[7] ILOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[8] ILOAD(0)
         // **REMOVED Substitution** s1 = new KInteger(local_0);
         // *********[9] IDIV
         // **REMOVED Substitution** index = local_0;
         // **REMOVED Substitution** s0 = new KInteger((frame.getLocal(1).intValue() / local_0));
         // *********[10] ISTORE(7)
        local_7 = (frame.getLocal(1).intValue() / local_0);
         // *********[11] ILOAD(7)
         // **REMOVED Substitution** s0 = new KInteger(local_7);
         // *********[12] ILOAD(0)
         // **REMOVED Substitution** s1 = new KInteger(local_0);
         // *********[13] IMUL
         // **REMOVED Substitution** index = local_0;
         // **REMOVED Substitution** s0 = new KInteger((local_7 * local_0));
         // *********[14] ISTORE(8)
         // **REMOVED Substitution** local_8 = (local_7 * local_0);
         // *********[15] ILOAD(8)
         // **REMOVED Substitution** s0 = new KInteger((local_7 * local_0));
         // *********[16] ALOAD(4)
         // **REMOVED Substitution** s1 = frame.getLocal(4);
         // *********[17] INVOKESTATIC(jnt.scimark2.kernel,RandomVector(ILjnt/scimark2/Random;)[D)
        regs = new KRegister[2];
        regs[1] = frame.getLocal(4);
        regs[0] = new KInteger((local_7 * local_0));
        if(m_mth == null){
          m_mth = c_Ckernel.getMethodBySignature("RandomVector(ILjnt/scimark2/Random;)[D");
        }
        frame.setProgramCounter(2);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        frame.setLocal(7,new KInteger(local_7));
        frame.setLocal(8,new KInteger((local_7 * local_0)));
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[3] ASTORE(5)
         // *********[4] ILOAD(0)
         // *********[5] NEWARRAY
         // *********[6] ASTORE(6)
         // *********[7] ILOAD(1)
         // *********[8] ILOAD(0)
         // *********[9] IDIV
         // *********[10] ISTORE(7)
         // *********[11] ILOAD(7)
         // *********[12] ILOAD(0)
         // *********[13] IMUL
         // *********[14] ISTORE(8)
         // *********[15] ILOAD(8)
         // *********[16] ALOAD(4)
         // *********[17] INVOKESTATIC(jnt.scimark2.kernel,RandomVector(ILjnt/scimark2/Random;)[D)
        c_repo = process.getClassRepository();
        c_Ckernel = c_repo.getClassByName("jnt.scimark2.kernel");
      }
}
