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
 * [count=6] [26] ALOAD(2) [27] ICONST_2(Integer{2}) [28] BIPUSH(10) [29] DLOAD(6) [30] ALOAD(3) [31] INVOKESTATIC(jnt.scimark2.kernel,measureSOR(IDLjnt/scimark2/Random;)D)
 */
public final class execute_014 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger ITWO = KInteger.TWO;
      private static final KInteger I10 = new KInteger(10);
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
         // local_6 6 ; r=1/w=0 : NotCached
         // *********[26] ALOAD(2)
        frame.push(frame.getLocal(2));
         // *********[27] ICONST_2(Integer{2})
        frame.push(ITWO);
         // *********[28] BIPUSH(10)
         // **REMOVED Substitution** s0 = I10;
         // *********[29] DLOAD(6)
         // **REMOVED Substitution** s1 = frame.getLocal(6);
         // *********[30] ALOAD(3)
         // **REMOVED Substitution** s2 = frame.getLocal(3);
         // *********[31] INVOKESTATIC(jnt.scimark2.kernel,measureSOR(IDLjnt/scimark2/Random;)D)
        regs = new KRegister[3];
        regs[2] = frame.getLocal(3);
        regs[1] = frame.getLocal(6);
        regs[0] = I10;
        if(c_Ckernel == null){
          c_Ckernel = c_repo.getClassByName("jnt.scimark2.kernel");
        }
        if(m_mth == null){
          m_mth = c_Ckernel.getMethodBySignature("measureSOR(IDLjnt/scimark2/Random;)D");
        }
        frame.setProgramCounter(14);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[26] ALOAD(2)
         // *********[27] ICONST_2(Integer{2})
         // *********[28] BIPUSH(10)
         // *********[29] DLOAD(6)
         // *********[30] ALOAD(3)
         // *********[31] INVOKESTATIC(jnt.scimark2.kernel,measureSOR(IDLjnt/scimark2/Random;)D)
        c_repo = process.getClassRepository();
      }
}
