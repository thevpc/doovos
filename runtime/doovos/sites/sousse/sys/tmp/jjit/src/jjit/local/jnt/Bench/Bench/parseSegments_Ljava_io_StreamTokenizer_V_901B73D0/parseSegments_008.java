package jjit.local.jnt.Bench.Bench.parseSegments_Ljava_io_StreamTokenizer_V_901B73D0;
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
 * jnt.Bench.Bench
 * parseSegments(Ljava/io/StreamTokenizer;)V
 * [count=4] [25] ALOAD(1) [26] GETFIELD(java.io.StreamTokenizer,sval,Ljava/lang/String;) [27] ASTORE(4) [28] GOTO(95)
 */
public final class parseSegments_008 extends JJITAbstractInstruction implements Cloneable{
      private KField c_sval = null;
      private KClassRepository c_repo;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_1 1 ; r=1/w=0 : NotCached
         // local_4 4 ; r=0/w=1 : NotCached
         // *********[25] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[26] GETFIELD(java.io.StreamTokenizer,sval,Ljava/lang/String;)
        if(c_sval == null){
          c_sval = c_repo.getClassByName("java.io.StreamTokenizer").getField("sval",true);
        }
         // **REMOVED Substitution** s0 = c_sval.getInstanceValue(((KReference)frame.getLocal(1)));
         // *********[27] ASTORE(4)
        frame.setLocal(4,c_sval.getInstanceValue(((KReference)frame.getLocal(1))));
         // *********[28] GOTO(95)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[25] ALOAD(1)
         // *********[26] GETFIELD(java.io.StreamTokenizer,sval,Ljava/lang/String;)
        c_repo = process.getClassRepository();
         // *********[27] ASTORE(4)
         // *********[28] GOTO(95)
        c_label = instructions[30];
      }
}
