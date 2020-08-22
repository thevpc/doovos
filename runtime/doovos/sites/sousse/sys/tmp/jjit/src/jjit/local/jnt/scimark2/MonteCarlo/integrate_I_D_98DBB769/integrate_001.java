package jjit.local.jnt.scimark2.MonteCarlo.integrate_I_D_98DBB769;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.MonteCarlo
 * integrate(I)D
 * [count=3] [0] NEW(jnt.scimark2.Random) [1] DUP [2] BIPUSH(113)
 */
public final class integrate_001 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CRandom = null;
      private static final KInteger I113 = new KInteger(113);
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // *********[0] NEW(jnt.scimark2.Random)
        if(c_CRandom == null){
          c_CRandom = c_repo.getClassByName("jnt.scimark2.Random");
        }
        s0_ref = memseg.allocObject(c_CRandom);
         // *********[1] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[2] BIPUSH(113)
        frame.push(I113);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] NEW(jnt.scimark2.Random)
        c_repo = process.getClassRepository();
         // *********[1] DUP
         // *********[2] BIPUSH(113)
        c_next = instructions[(index + 1)];
      }
}
