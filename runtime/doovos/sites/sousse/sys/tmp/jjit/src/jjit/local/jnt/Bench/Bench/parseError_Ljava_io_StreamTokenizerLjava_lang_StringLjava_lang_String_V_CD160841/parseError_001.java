package jjit.local.jnt.Bench.Bench.parseError_Ljava_io_StreamTokenizerLjava_lang_StringLjava_lang_String_V_CD160841;
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
 * parseError(Ljava/io/StreamTokenizer;Ljava/lang/String;Ljava/lang/String;)V
 * [count=4] [0] NEW(java.io.IOException) [1] DUP [2] NEW(java.lang.StringBuffer) [3] DUP
 */
public final class parseError_001 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CIOException = null;
      private KClass c_CStringBuffer = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s1_ref;
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // *********[0] NEW(java.io.IOException)
        if(c_CIOException == null){
          c_CIOException = c_repo.getClassByName("java.io.IOException");
        }
        s0_ref = memseg.allocObject(c_CIOException);
         // *********[1] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[2] NEW(java.lang.StringBuffer)
        if(c_CStringBuffer == null){
          c_CStringBuffer = c_repo.getClassByName("java.lang.StringBuffer");
        }
        s1_ref = memseg.allocObject(c_CStringBuffer);
         // *********[3] DUP
        frame.push(s1_ref);
        frame.push(s1_ref);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] NEW(java.io.IOException)
        c_repo = process.getClassRepository();
         // *********[1] DUP
         // *********[2] NEW(java.lang.StringBuffer)
        c_repo = process.getClassRepository();
         // *********[3] DUP
        c_next = instructions[(index + 1)];
      }
}
