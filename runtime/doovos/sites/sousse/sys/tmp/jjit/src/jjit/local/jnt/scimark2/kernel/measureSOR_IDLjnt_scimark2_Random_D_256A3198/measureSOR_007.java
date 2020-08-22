package jjit.local.jnt.scimark2.kernel.measureSOR_IDLjnt_scimark2_Random_D_256A3198;
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
 * measureSOR(IDLjnt/scimark2/Random;)D
 * [count=4] [14] LDC(18->"1.25") [15] ALOAD(4) [16] ILOAD(6) [17] INVOKESTATIC(jnt.scimark2.SOR,execute(D[[DI)V)
 */
public final class measureSOR_007 extends JJITAbstractInstruction implements Cloneable{
      private static final KDouble D1_25 = new KDouble(1.25D);
      private KClassRepository c_repo;
      private KClass c_CSOR = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_4 4 ; r=1/w=0 : NotCached
         // local_6 6 ; r=1/w=0 : NotCached
         // *********[14] LDC(18->"1.25")
         // **REMOVED Substitution** s0 = D1_25;
         // *********[15] ALOAD(4)
         // **REMOVED Substitution** s1 = frame.getLocal(4);
         // *********[16] ILOAD(6)
         // **REMOVED Substitution** s2 = frame.getLocal(6);
         // *********[17] INVOKESTATIC(jnt.scimark2.SOR,execute(D[[DI)V)
        regs = new KRegister[3];
        regs[2] = frame.getLocal(6);
        regs[1] = frame.getLocal(4);
        regs[0] = D1_25;
        if(c_CSOR == null){
          c_CSOR = c_repo.getClassByName("jnt.scimark2.SOR");
        }
        if(m_mth == null){
          m_mth = c_CSOR.getMethodBySignature("execute(D[[DI)V");
        }
        frame.setProgramCounter(7);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[14] LDC(18->"1.25")
         // *********[15] ALOAD(4)
         // *********[16] ILOAD(6)
         // *********[17] INVOKESTATIC(jnt.scimark2.SOR,execute(D[[DI)V)
        c_repo = process.getClassRepository();
      }
}
