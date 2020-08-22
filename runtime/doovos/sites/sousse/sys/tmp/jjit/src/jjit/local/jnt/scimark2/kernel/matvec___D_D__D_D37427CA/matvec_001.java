package jjit.local.jnt.scimark2.kernel.matvec___D_D__D_D37427CA;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.kernel
 * matvec([[D[D)[D
 * [count=10] [0] ALOAD(1) [1] ARRAYLENGTH [2] ISTORE(2) [3] ILOAD(2) [4] NEWARRAY [5] ASTORE(3) [6] ALOAD(0) [7] ALOAD(1) [8] ALOAD(3) [9] INVOKESTATIC(jnt.scimark2.kernel,matvec([[D[D[D)V)
 */
public final class matvec_001 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private KClassRepository c_repo;
      private KClass c_Ckernel = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=2/w=0 : Cached
        KRegister local_1 = frame.getLocal(1);
         // local_2 2 ; r=1/w=1 : Cached
        int local_2;
         // local_3 3 ; r=1/w=1 : Cached
        KRegister local_3;
         // *********[0] ALOAD(1)
         // **REMOVED Substitution** s0 = local_1;
         // *********[1] ARRAYLENGTH
         // **REMOVED Substitution** s0 = new KInteger(c_memman.getArraySize(((KReference)local_1)));
         // *********[2] ISTORE(2)
        local_2 = c_memman.getArraySize(((KReference)local_1));
         // *********[3] ILOAD(2)
         // **REMOVED Substitution** s0 = new KInteger(local_2);
         // *********[4] NEWARRAY
         // **REMOVED Substitution** s0_ref = memseg.allocDoubleArray(local_2);
         // *********[5] ASTORE(3)
        local_3 = memseg.allocDoubleArray(local_2);
         // *********[6] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[7] ALOAD(1)
         // **REMOVED Substitution** s1 = local_1;
         // *********[8] ALOAD(3)
         // **REMOVED Substitution** s2 = local_3;
         // *********[9] INVOKESTATIC(jnt.scimark2.kernel,matvec([[D[D[D)V)
        regs = new KRegister[3];
        regs[2] = local_3;
        regs[1] = local_1;
        regs[0] = frame.getLocal(0);
        if(m_mth == null){
          m_mth = c_Ckernel.getMethodBySignature("matvec([[D[D[D)V");
        }
        frame.setProgramCounter(1);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        frame.setLocal(2,new KInteger(local_2));
        frame.setLocal(3,local_3);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(1)
         // *********[1] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[2] ISTORE(2)
         // *********[3] ILOAD(2)
         // *********[4] NEWARRAY
         // *********[5] ASTORE(3)
         // *********[6] ALOAD(0)
         // *********[7] ALOAD(1)
         // *********[8] ALOAD(3)
         // *********[9] INVOKESTATIC(jnt.scimark2.kernel,matvec([[D[D[D)V)
        c_repo = process.getClassRepository();
        c_Ckernel = c_repo.getClassByName("jnt.scimark2.kernel");
      }
}
