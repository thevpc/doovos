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
 * [count=5] [64] NEW(java.net.Socket) [65] DUP [66] ALOAD(0) [67] BIPUSH(25) [68] ICONST_1(Integer{1})
 */
public final class send_041 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CSocket = null;
      private static final KInteger I25 = new KInteger(25);
      private static final KInteger IONE = KInteger.ONE;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // local_0 0 ; r=1/w=0 : NotCached
         // *********[64] NEW(java.net.Socket)
        if(c_CSocket == null){
          c_CSocket = c_repo.getClassByName("java.net.Socket");
        }
        s0_ref = memseg.allocObject(c_CSocket);
         // *********[65] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[66] ALOAD(0)
        frame.push(frame.getLocal(0));
         // *********[67] BIPUSH(25)
        frame.push(I25);
         // *********[68] ICONST_1(Integer{1})
        frame.push(IONE);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[64] NEW(java.net.Socket)
        c_repo = process.getClassRepository();
         // *********[65] DUP
         // *********[66] ALOAD(0)
         // *********[67] BIPUSH(25)
         // *********[68] ICONST_1(Integer{1})
        c_next = instructions[(index + 1)];
      }
}
