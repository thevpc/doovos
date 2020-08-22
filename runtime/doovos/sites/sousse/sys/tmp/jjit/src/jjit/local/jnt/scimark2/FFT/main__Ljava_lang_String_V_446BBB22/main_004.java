package jjit.local.jnt.scimark2.FFT.main__Ljava_lang_String_V_446BBB22;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.FFT
 * main([Ljava/lang/String;)V
 * [count=3] [5] GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;) [6] NEW(java.lang.StringBuffer) [7] DUP
 */
public final class main_004 extends JJITAbstractInstruction implements Cloneable{
      private KField c_out = null;
      private KClassRepository c_repo;
      private KClass c_CStringBuffer = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // *********[5] GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
        if(c_out == null){
          c_out = c_repo.getClassByName("java.lang.System").getField("out",true);
        }
        frame.push(c_out.getStaticValue());
         // *********[6] NEW(java.lang.StringBuffer)
        if(c_CStringBuffer == null){
          c_CStringBuffer = c_repo.getClassByName("java.lang.StringBuffer");
        }
        s0_ref = memseg.allocObject(c_CStringBuffer);
         // *********[7] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[5] GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
        c_repo = process.getClassRepository();
         // *********[6] NEW(java.lang.StringBuffer)
        c_repo = process.getClassRepository();
         // *********[7] DUP
        c_next = instructions[(index + 1)];
      }
}
