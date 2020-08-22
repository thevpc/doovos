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
 * [count=3] [85] NEW(java.net.ProtocolException) [86] DUP [87] ALOAD(7)
 */
public final class post_044 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CProtocolException = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // local_7 7 ; r=1/w=0 : NotCached
         // *********[85] NEW(java.net.ProtocolException)
        if(c_CProtocolException == null){
          c_CProtocolException = c_repo.getClassByName("java.net.ProtocolException");
        }
        s0_ref = memseg.allocObject(c_CProtocolException);
         // *********[86] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[87] ALOAD(7)
        frame.push(frame.getLocal(7));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[85] NEW(java.net.ProtocolException)
        c_repo = process.getClassRepository();
         // *********[86] DUP
         // *********[87] ALOAD(7)
        c_next = instructions[(index + 1)];
      }
}
