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
 * [count=6] [81] DASTORE [82] ALOAD(8) [83] ICONST_3(Integer{3}) [84] DLOAD(1) [85] ALOAD(9) [86] INVOKESTATIC(jnt.scimark2.kernel,measureMonteCarlo(DLjnt/scimark2/Random;)D)
 */
public final class main_029 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private static final KInteger ITHREE = KInteger.THREE;
      private KClassRepository c_repo;
      private KClass c_Ckernel = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
        int index = 0;
        double m_d;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_1 1 ; r=1/w=0 : NotCached
         // local_8 8 ; r=1/w=0 : NotCached
         // local_9 9 ; r=1/w=0 : NotCached
         // *********[81] DASTORE
        m_d = frame.popDouble();
        index = frame.popInt();
        c_memman.setDoubleArray(frame.popRef(),index,m_d);
         // *********[82] ALOAD(8)
        frame.push(frame.getLocal(8));
         // *********[83] ICONST_3(Integer{3})
        frame.push(ITHREE);
         // *********[84] DLOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[85] ALOAD(9)
         // **REMOVED Substitution** s1 = frame.getLocal(9);
         // *********[86] INVOKESTATIC(jnt.scimark2.kernel,measureMonteCarlo(DLjnt/scimark2/Random;)D)
        regs = new KRegister[2];
        regs[1] = frame.getLocal(9);
        regs[0] = frame.getLocal(1);
        if(c_Ckernel == null){
          c_Ckernel = c_repo.getClassByName("jnt.scimark2.kernel");
        }
        if(m_mth == null){
          m_mth = c_Ckernel.getMethodBySignature("measureMonteCarlo(DLjnt/scimark2/Random;)D");
        }
        frame.setProgramCounter(29);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[81] DASTORE
        c_memman = process.getMemoryManager();
         // *********[82] ALOAD(8)
         // *********[83] ICONST_3(Integer{3})
         // *********[84] DLOAD(1)
         // *********[85] ALOAD(9)
         // *********[86] INVOKESTATIC(jnt.scimark2.kernel,measureMonteCarlo(DLjnt/scimark2/Random;)D)
        c_repo = process.getClassRepository();
      }
}
