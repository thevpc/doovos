package jjit.local.jnt.Bench.SendMail.docmd_Ljava_io_PrintStreamLjava_lang_String_V_7DBB0AC2;
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
 * docmd(Ljava/io/PrintStream;Ljava/lang/String;)V
 * [count=4] [2] ASTORE(1) [3] ALOAD(0) [4] NEW(java.lang.StringBuffer) [5] DUP
 */
public final class docmd_004 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CStringBuffer = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // local_0 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=0/w=1 : NotCached
         // *********[2] ASTORE(1)
        frame.setLocal(1,frame.pop());
         // *********[3] ALOAD(0)
        frame.push(frame.getLocal(0));
         // *********[4] NEW(java.lang.StringBuffer)
        if(c_CStringBuffer == null){
          c_CStringBuffer = c_repo.getClassByName("java.lang.StringBuffer");
        }
        s0_ref = memseg.allocObject(c_CStringBuffer);
         // *********[5] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[2] ASTORE(1)
         // *********[3] ALOAD(0)
         // *********[4] NEW(java.lang.StringBuffer)
        c_repo = process.getClassRepository();
         // *********[5] DUP
        c_next = instructions[(index + 1)];
      }
}
