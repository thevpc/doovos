package jjit.local.jnt.scimark2.commandline.main__Ljava_lang_String_V_6A6C6E6C;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.commandline
 * main([Ljava/lang/String;)V
 * [count=2] [27] GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;) [28] LDC(10->"Usage: [-large] [minimum_time]")
 */
public final class main_009 extends JJITAbstractInstruction implements Cloneable{
      private KField c_out = null;
      private KClassRepository c_repo;
      private static KReference R10 = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // *********[27] GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
        if(c_out == null){
          c_out = c_repo.getClassByName("java.lang.System").getField("out",true);
        }
        frame.push(c_out.getStaticValue());
         // *********[28] LDC(10->"Usage: [-large] [minimum_time]")
        frame.push(R10);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[27] GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
        c_repo = process.getClassRepository();
         // *********[28] LDC(10->"Usage: [-large] [minimum_time]")
        R10 = ((KReference)constants[10]);
        c_next = instructions[(index + 1)];
      }
}
