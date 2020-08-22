package jjit.local.jnt.scimark2.applet.execute_Ljnt_Bench_Bench__D_70A4923B;
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
 * jnt.scimark2.applet
 * execute(Ljnt/Bench/Bench;)[D
 * [count=7] [47] ALOAD(2) [48] ICONST_4(Integer{4}) [49] BIPUSH(10) [50] BIPUSH(50) [51] DLOAD(6) [52] ALOAD(3) [53] INVOKESTATIC(jnt.scimark2.kernel,measureSparseMatmult(IIDLjnt/scimark2/Random;)D)
 */
public final class execute_020 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger IFOUR = KInteger.FOUR;
      private static final KInteger I10 = new KInteger(10);
      private static final KInteger I50 = new KInteger(50);
      private KClassRepository c_repo;
      private KClass c_Ckernel = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_2 2 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=0 : NotCached
         // local_6 6 ; r=1/w=0 : NotCached
         // *********[47] ALOAD(2)
        frame.push(frame.getLocal(2));
         // *********[48] ICONST_4(Integer{4})
        frame.push(IFOUR);
         // *********[49] BIPUSH(10)
         // **REMOVED Substitution** s0 = I10;
         // *********[50] BIPUSH(50)
         // **REMOVED Substitution** s1 = I50;
         // *********[51] DLOAD(6)
         // **REMOVED Substitution** s2 = frame.getLocal(6);
         // *********[52] ALOAD(3)
         // **REMOVED Substitution** s3 = frame.getLocal(3);
         // *********[53] INVOKESTATIC(jnt.scimark2.kernel,measureSparseMatmult(IIDLjnt/scimark2/Random;)D)
        regs = new KRegister[4];
        regs[3] = frame.getLocal(3);
        regs[2] = frame.getLocal(6);
        regs[1] = I50;
        regs[0] = I10;
        if(c_Ckernel == null){
          c_Ckernel = c_repo.getClassByName("jnt.scimark2.kernel");
        }
        if(m_mth == null){
          m_mth = c_Ckernel.getMethodBySignature("measureSparseMatmult(IIDLjnt/scimark2/Random;)D");
        }
        frame.setProgramCounter(20);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[47] ALOAD(2)
         // *********[48] ICONST_4(Integer{4})
         // *********[49] BIPUSH(10)
         // *********[50] BIPUSH(50)
         // *********[51] DLOAD(6)
         // *********[52] ALOAD(3)
         // *********[53] INVOKESTATIC(jnt.scimark2.kernel,measureSparseMatmult(IIDLjnt/scimark2/Random;)D)
        c_repo = process.getClassRepository();
      }
}
