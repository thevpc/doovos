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
 * [count=7] [99] ALOAD(2) [100] ICONST_4(Integer{4}) [101] SIPUSH(Integer{1000}) [102] SIPUSH(Integer{5000}) [103] DLOAD(4) [104] ALOAD(3) [105] INVOKESTATIC(jnt.scimark2.kernel,measureSparseMatmult(IIDLjnt/scimark2/Random;)D)
 */
public final class execute_032 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger IFOUR = KInteger.FOUR;
      private static final KInteger I1000 = new KInteger(1000);
      private static final KInteger I5000 = new KInteger(5000);
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
         // local_4 4 ; r=1/w=0 : NotCached
         // *********[99] ALOAD(2)
        frame.push(frame.getLocal(2));
         // *********[100] ICONST_4(Integer{4})
        frame.push(IFOUR);
         // *********[101] SIPUSH(Integer{1000})
         // **REMOVED Substitution** s0 = I1000;
         // *********[102] SIPUSH(Integer{5000})
         // **REMOVED Substitution** s1 = I5000;
         // *********[103] DLOAD(4)
         // **REMOVED Substitution** s2 = frame.getLocal(4);
         // *********[104] ALOAD(3)
         // **REMOVED Substitution** s3 = frame.getLocal(3);
         // *********[105] INVOKESTATIC(jnt.scimark2.kernel,measureSparseMatmult(IIDLjnt/scimark2/Random;)D)
        regs = new KRegister[4];
        regs[3] = frame.getLocal(3);
        regs[2] = frame.getLocal(4);
        regs[1] = I5000;
        regs[0] = I1000;
        if(c_Ckernel == null){
          c_Ckernel = c_repo.getClassByName("jnt.scimark2.kernel");
        }
        if(m_mth == null){
          m_mth = c_Ckernel.getMethodBySignature("measureSparseMatmult(IIDLjnt/scimark2/Random;)D");
        }
        frame.setProgramCounter(32);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[99] ALOAD(2)
         // *********[100] ICONST_4(Integer{4})
         // *********[101] SIPUSH(Integer{1000})
         // *********[102] SIPUSH(Integer{5000})
         // *********[103] DLOAD(4)
         // *********[104] ALOAD(3)
         // *********[105] INVOKESTATIC(jnt.scimark2.kernel,measureSparseMatmult(IIDLjnt/scimark2/Random;)D)
        c_repo = process.getClassRepository();
      }
}
