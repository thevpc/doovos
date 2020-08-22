package jjit.local.jnt.Bench.Bench.parseDescriptor_Ljava_io_InputStream_V_38C1A4B9;
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
 * parseDescriptor(Ljava/io/InputStream;)V
 * [count=3] [0] NEW(java.io.StreamTokenizer) [1] DUP [2] ALOAD(1)
 */
public final class parseDescriptor_001 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CStreamTokeni_er = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[0] NEW(java.io.StreamTokenizer)
        if(c_CStreamTokeni_er == null){
          c_CStreamTokeni_er = c_repo.getClassByName("java.io.StreamTokenizer");
        }
        s0_ref = memseg.allocObject(c_CStreamTokeni_er);
         // *********[1] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[2] ALOAD(1)
        frame.push(frame.getLocal(1));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] NEW(java.io.StreamTokenizer)
        c_repo = process.getClassRepository();
         // *********[1] DUP
         // *********[2] ALOAD(1)
        c_next = instructions[(index + 1)];
      }
}
