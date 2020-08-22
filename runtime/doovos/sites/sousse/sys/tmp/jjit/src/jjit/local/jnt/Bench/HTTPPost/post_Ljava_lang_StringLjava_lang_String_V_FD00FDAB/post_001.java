package jjit.local.jnt.Bench.HTTPPost.post_Ljava_lang_StringLjava_lang_String_V_FD00FDAB;
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
 * jnt.Bench.HTTPPost
 * post(Ljava/lang/String;Ljava/lang/String;)V
 * [count=3] [0] NEW(java.net.URL) [1] DUP [2] ALOAD(0)
 */
public final class post_001 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CURL = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // local_0 0 ; r=1/w=0 : NotCached
         // *********[0] NEW(java.net.URL)
        if(c_CURL == null){
          c_CURL = c_repo.getClassByName("java.net.URL");
        }
        s0_ref = memseg.allocObject(c_CURL);
         // *********[1] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[2] ALOAD(0)
        frame.push(frame.getLocal(0));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] NEW(java.net.URL)
        c_repo = process.getClassRepository();
         // *********[1] DUP
         // *********[2] ALOAD(0)
        c_next = instructions[(index + 1)];
      }
}
