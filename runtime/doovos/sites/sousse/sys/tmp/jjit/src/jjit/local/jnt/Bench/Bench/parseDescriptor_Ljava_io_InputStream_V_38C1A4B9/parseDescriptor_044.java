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
 * [count=4] [116] NEW(java.io.IOException) [117] DUP [118] NEW(java.lang.StringBuffer) [119] DUP
 */
public final class parseDescriptor_044 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CIOException = null;
      private KClass c_CStringBuffer = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s1_ref;
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // *********[116] NEW(java.io.IOException)
        if(c_CIOException == null){
          c_CIOException = c_repo.getClassByName("java.io.IOException");
        }
        s0_ref = memseg.allocObject(c_CIOException);
         // *********[117] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[118] NEW(java.lang.StringBuffer)
        if(c_CStringBuffer == null){
          c_CStringBuffer = c_repo.getClassByName("java.lang.StringBuffer");
        }
        s1_ref = memseg.allocObject(c_CStringBuffer);
         // *********[119] DUP
        frame.push(s1_ref);
        frame.push(s1_ref);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[116] NEW(java.io.IOException)
        c_repo = process.getClassRepository();
         // *********[117] DUP
         // *********[118] NEW(java.lang.StringBuffer)
        c_repo = process.getClassRepository();
         // *********[119] DUP
        c_next = instructions[(index + 1)];
      }
}
