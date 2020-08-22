package jjit.local.jnt.Bench.Formatter.pad_CI_Ljava_lang_String_58D199A6;
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
 * jnt.Bench.Formatter
 * pad(CI)Ljava/lang/String;
 * [count=3] [18] NEW(java.lang.String) [19] DUP [20] ALOAD(2)
 */
public final class pad_006 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CString = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[18] NEW(java.lang.String)
        if(c_CString == null){
          c_CString = c_repo.getClassByName("java.lang.String");
        }
        s0_ref = memseg.allocObject(c_CString);
         // *********[19] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[20] ALOAD(2)
        frame.push(frame.getLocal(2));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[18] NEW(java.lang.String)
        c_repo = process.getClassRepository();
         // *********[19] DUP
         // *********[20] ALOAD(2)
        c_next = instructions[(index + 1)];
      }
}
