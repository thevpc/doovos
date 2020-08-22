package jjit.local.jnt.Bench.Bench.parseString_Ljava_io_StreamTokenizerLjava_lang_String_Ljava_lang_String_7FCD3831;
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
 * parseString(Ljava/io/StreamTokenizer;Ljava/lang/String;)Ljava/lang/String;
 * [count=3] [13] ALOAD(1) [14] GETFIELD(java.io.StreamTokenizer,sval,Ljava/lang/String;) [15] ARETURN
 */
public final class parseString_007 extends JJITAbstractInstruction implements Cloneable{
      private KField c_sval = null;
      private KClassRepository c_repo;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KFrame callerFrame = null;
         // **REMOVED Unused Var** KRegister reg;
        KLocalThread thread = frame.getThread();
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[13] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[14] GETFIELD(java.io.StreamTokenizer,sval,Ljava/lang/String;)
        if(c_sval == null){
          c_sval = c_repo.getClassByName("java.io.StreamTokenizer").getField("sval",true);
        }
         // **REMOVED Substitution** s0 = c_sval.getInstanceValue(((KReference)frame.getLocal(1)));
         // *********[15] ARETURN
         // **REMOVED Substitution** reg = c_sval.getInstanceValue(((KReference)frame.getLocal(1)));
        callerFrame = thread.popFrame();
        callerFrame.push(c_sval.getInstanceValue(((KReference)frame.getLocal(1))));
        return ((JJITInstruction)callerFrame.getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[13] ALOAD(1)
         // *********[14] GETFIELD(java.io.StreamTokenizer,sval,Ljava/lang/String;)
        c_repo = process.getClassRepository();
         // *********[15] ARETURN
      }
}
