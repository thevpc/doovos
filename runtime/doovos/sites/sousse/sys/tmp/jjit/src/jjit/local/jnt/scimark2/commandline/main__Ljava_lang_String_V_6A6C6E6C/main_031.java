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
 * [count=7] [95] DASTORE [96] ALOAD(8) [97] ICONST_5(Integer{5}) [98] ILOAD(7) [99] DLOAD(1) [100] ALOAD(9) [101] INVOKESTATIC(jnt.scimark2.kernel,measureLU(IDLjnt/scimark2/Random;)D)
 */
public final class main_031 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private static final KInteger IFIVE = KInteger.FIVE;
      private KClassRepository c_repo;
      private KClass c_Ckernel = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
        int index = 0;
        double m_d;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_1 1 ; r=1/w=0 : NotCached
         // local_7 7 ; r=1/w=0 : NotCached
         // local_8 8 ; r=1/w=0 : NotCached
         // local_9 9 ; r=1/w=0 : NotCached
         // *********[95] DASTORE
        m_d = frame.popDouble();
        index = frame.popInt();
        c_memman.setDoubleArray(frame.popRef(),index,m_d);
         // *********[96] ALOAD(8)
        frame.push(frame.getLocal(8));
         // *********[97] ICONST_5(Integer{5})
        frame.push(IFIVE);
         // *********[98] ILOAD(7)
         // **REMOVED Substitution** s0 = frame.getLocal(7);
         // *********[99] DLOAD(1)
         // **REMOVED Substitution** s1 = frame.getLocal(1);
         // *********[100] ALOAD(9)
         // **REMOVED Substitution** s2 = frame.getLocal(9);
         // *********[101] INVOKESTATIC(jnt.scimark2.kernel,measureLU(IDLjnt/scimark2/Random;)D)
        regs = new KRegister[3];
        regs[2] = frame.getLocal(9);
        regs[1] = frame.getLocal(1);
        regs[0] = frame.getLocal(7);
        if(c_Ckernel == null){
          c_Ckernel = c_repo.getClassByName("jnt.scimark2.kernel");
        }
        if(m_mth == null){
          m_mth = c_Ckernel.getMethodBySignature("measureLU(IDLjnt/scimark2/Random;)D");
        }
        frame.setProgramCounter(31);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[95] DASTORE
        c_memman = process.getMemoryManager();
         // *********[96] ALOAD(8)
         // *********[97] ICONST_5(Integer{5})
         // *********[98] ILOAD(7)
         // *********[99] DLOAD(1)
         // *********[100] ALOAD(9)
         // *********[101] INVOKESTATIC(jnt.scimark2.kernel,measureLU(IDLjnt/scimark2/Random;)D)
        c_repo = process.getClassRepository();
      }
}
