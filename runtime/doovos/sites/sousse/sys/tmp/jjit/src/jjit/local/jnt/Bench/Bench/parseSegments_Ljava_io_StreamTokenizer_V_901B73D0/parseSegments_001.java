package jjit.local.jnt.Bench.Bench.parseSegments_Ljava_io_StreamTokenizer_V_901B73D0;
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
 * jnt.Bench.Bench
 * parseSegments(Ljava/io/StreamTokenizer;)V
 * [count=2] [0] NEW(java.util.Vector) [1] DUP
 */
public final class parseSegments_001 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CVector = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // *********[0] NEW(java.util.Vector)
        if(c_CVector == null){
          c_CVector = c_repo.getClassByName("java.util.Vector");
        }
        s0_ref = memseg.allocObject(c_CVector);
         // *********[1] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] NEW(java.util.Vector)
        c_repo = process.getClassRepository();
         // *********[1] DUP
        c_next = instructions[(index + 1)];
      }
}
