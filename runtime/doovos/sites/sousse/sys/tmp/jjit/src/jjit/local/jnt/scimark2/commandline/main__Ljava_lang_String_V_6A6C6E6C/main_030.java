package jjit.local.jnt.scimark2.commandline.main__Ljava_lang_String_V_6A6C6E6C;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.commandline
 * main([Ljava/lang/String;)V
 * [count=8] [87] DASTORE [88] ALOAD(8) [89] ICONST_4(Integer{4}) [90] ILOAD(5) [91] ILOAD(6) [92] DLOAD(1) [93] ALOAD(9) [94] INVOKESTATIC(jnt.scimark2.kernel,measureSparseMatmult(IIDLjnt/scimark2/Random;)D)
 */
public final class main_030 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private static final KInteger IFOUR = KInteger.FOUR;
      private KClassRepository c_repo;
      private KClass c_Ckernel = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
        int index = 0;
        double m_d;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_1 1 ; r=1/w=0 : NotCached
         // local_5 5 ; r=1/w=0 : NotCached
         // local_6 6 ; r=1/w=0 : NotCached
         // local_8 8 ; r=1/w=0 : NotCached
         // local_9 9 ; r=1/w=0 : NotCached
         // *********[87] DASTORE
        m_d = frame.popDouble();
        index = frame.popInt();
        c_memman.setDoubleArray(frame.popRef(),index,m_d);
         // *********[88] ALOAD(8)
        frame.push(frame.getLocal(8));
         // *********[89] ICONST_4(Integer{4})
        frame.push(IFOUR);
         // *********[90] ILOAD(5)
         // **REMOVED Substitution** s0 = frame.getLocal(5);
         // *********[91] ILOAD(6)
         // **REMOVED Substitution** s1 = frame.getLocal(6);
         // *********[92] DLOAD(1)
         // **REMOVED Substitution** s2 = frame.getLocal(1);
         // *********[93] ALOAD(9)
         // **REMOVED Substitution** s3 = frame.getLocal(9);
         // *********[94] INVOKESTATIC(jnt.scimark2.kernel,measureSparseMatmult(IIDLjnt/scimark2/Random;)D)
        regs = new KRegister[4];
        regs[3] = frame.getLocal(9);
        regs[2] = frame.getLocal(1);
        regs[1] = frame.getLocal(6);
        regs[0] = frame.getLocal(5);
        if(c_Ckernel == null){
          c_Ckernel = c_repo.getClassByName("jnt.scimark2.kernel");
        }
        if(m_mth == null){
          m_mth = c_Ckernel.getMethodBySignature("measureSparseMatmult(IIDLjnt/scimark2/Random;)D");
        }
        frame.setProgramCounter(30);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[87] DASTORE
        c_memman = process.getMemoryManager();
         // *********[88] ALOAD(8)
         // *********[89] ICONST_4(Integer{4})
         // *********[90] ILOAD(5)
         // *********[91] ILOAD(6)
         // *********[92] DLOAD(1)
         // *********[93] ALOAD(9)
         // *********[94] INVOKESTATIC(jnt.scimark2.kernel,measureSparseMatmult(IIDLjnt/scimark2/Random;)D)
        c_repo = process.getClassRepository();
      }
}
