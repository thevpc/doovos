package jjit.local.jnt.Bench.SendMail.send_Ljava_lang_StringLjava_lang_StringLjava_lang_StringLjava_lang_StringLjava_lang_String_V_56E49BAB;
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
 * jnt.Bench.SendMail
 * send(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
 * [count=3] [22] NEW(java.net.ProtocolException) [23] DUP [24] LDC(9->"No SMTP recipient given!")
 */
public final class send_020 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CProtocolException = null;
      private static KReference R9 = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // *********[22] NEW(java.net.ProtocolException)
        if(c_CProtocolException == null){
          c_CProtocolException = c_repo.getClassByName("java.net.ProtocolException");
        }
        s0_ref = memseg.allocObject(c_CProtocolException);
         // *********[23] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[24] LDC(9->"No SMTP recipient given!")
        frame.push(R9);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[22] NEW(java.net.ProtocolException)
        c_repo = process.getClassRepository();
         // *********[23] DUP
         // *********[24] LDC(9->"No SMTP recipient given!")
        R9 = ((KReference)constants[9]);
        c_next = instructions[(index + 1)];
      }
}
