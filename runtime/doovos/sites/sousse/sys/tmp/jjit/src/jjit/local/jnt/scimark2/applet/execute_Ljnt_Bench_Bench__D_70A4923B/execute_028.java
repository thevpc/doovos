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
 * [count=6] [80] ALOAD(2) [81] ICONST_2(Integer{2}) [82] BIPUSH(100) [83] DLOAD(4) [84] ALOAD(3) [85] INVOKESTATIC(jnt.scimark2.kernel,measureSOR(IDLjnt/scimark2/Random;)D)
 */
public final class execute_028 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger ITWO = KInteger.TWO;
      private static final KInteger I100 = new KInteger(100);
      private KClassRepository c_repo;
      private KClass c_Ckernel = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_2 2 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=0 : NotCached
         // local_4 4 ; r=1/w=0 : NotCached
         // *********[80] ALOAD(2)
        frame.push(frame.getLocal(2));
         // *********[81] ICONST_2(Integer{2})
        frame.push(ITWO);
         // *********[82] BIPUSH(100)
         // **REMOVED Substitution** s0 = I100;
         // *********[83] DLOAD(4)
         // **REMOVED Substitution** s1 = frame.getLocal(4);
         // *********[84] ALOAD(3)
         // **REMOVED Substitution** s2 = frame.getLocal(3);
         // *********[85] INVOKESTATIC(jnt.scimark2.kernel,measureSOR(IDLjnt/scimark2/Random;)D)
        regs = new KRegister[3];
        regs[2] = frame.getLocal(3);
        regs[1] = frame.getLocal(4);
        regs[0] = I100;
        if(c_Ckernel == null){
          c_Ckernel = c_repo.getClassByName("jnt.scimark2.kernel");
        }
        if(m_mth == null){
          m_mth = c_Ckernel.getMethodBySignature("measureSOR(IDLjnt/scimark2/Random;)D");
        }
        frame.setProgramCounter(28);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[80] ALOAD(2)
         // *********[81] ICONST_2(Integer{2})
         // *********[82] BIPUSH(100)
         // *********[83] DLOAD(4)
         // *********[84] ALOAD(3)
         // *********[85] INVOKESTATIC(jnt.scimark2.kernel,measureSOR(IDLjnt/scimark2/Random;)D)
        c_repo = process.getClassRepository();
      }
}
