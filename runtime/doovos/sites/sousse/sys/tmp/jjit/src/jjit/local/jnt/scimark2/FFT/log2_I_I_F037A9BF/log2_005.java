package jjit.local.jnt.scimark2.FFT.log2_I_I_F037A9BF;
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
 * jnt.scimark2.FFT
 * log2(I)I
 * [count=4] [18] NEW(java.lang.Error) [19] DUP [20] NEW(java.lang.StringBuffer) [21] DUP
 */
public final class log2_005 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CError = null;
      private KClass c_CStringBuffer = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s1_ref;
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // *********[18] NEW(java.lang.Error)
        if(c_CError == null){
          c_CError = c_repo.getClassByName("java.lang.Error");
        }
        s0_ref = memseg.allocObject(c_CError);
         // *********[19] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[20] NEW(java.lang.StringBuffer)
        if(c_CStringBuffer == null){
          c_CStringBuffer = c_repo.getClassByName("java.lang.StringBuffer");
        }
        s1_ref = memseg.allocObject(c_CStringBuffer);
         // *********[21] DUP
        frame.push(s1_ref);
        frame.push(s1_ref);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[18] NEW(java.lang.Error)
        c_repo = process.getClassRepository();
         // *********[19] DUP
         // *********[20] NEW(java.lang.StringBuffer)
        c_repo = process.getClassRepository();
         // *********[21] DUP
        c_next = instructions[(index + 1)];
      }
}
