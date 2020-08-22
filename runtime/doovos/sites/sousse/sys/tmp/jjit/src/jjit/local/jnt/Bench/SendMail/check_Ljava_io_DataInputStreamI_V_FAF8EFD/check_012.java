package jjit.local.jnt.Bench.SendMail.check_Ljava_io_DataInputStreamI_V_FAF8EFD;
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
 * check(Ljava/io/DataInputStream;I)V
 * [count=3] [16] NEW(java.net.ProtocolException) [17] DUP [18] ALOAD(2)
 */
public final class check_012 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CProtocolException = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[16] NEW(java.net.ProtocolException)
        if(c_CProtocolException == null){
          c_CProtocolException = c_repo.getClassByName("java.net.ProtocolException");
        }
        s0_ref = memseg.allocObject(c_CProtocolException);
         // *********[17] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[18] ALOAD(2)
        frame.push(frame.getLocal(2));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[16] NEW(java.net.ProtocolException)
        c_repo = process.getClassRepository();
         // *********[17] DUP
         // *********[18] ALOAD(2)
        c_next = instructions[(index + 1)];
      }
}
