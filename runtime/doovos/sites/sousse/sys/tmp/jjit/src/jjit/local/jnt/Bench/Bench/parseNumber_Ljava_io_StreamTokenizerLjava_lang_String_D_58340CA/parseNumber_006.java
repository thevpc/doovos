package jjit.local.jnt.Bench.Bench.parseNumber_Ljava_io_StreamTokenizerLjava_lang_String_D_58340CA;
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
 * parseNumber(Ljava/io/StreamTokenizer;Ljava/lang/String;)D
 * [count=3] [9] ALOAD(1) [10] GETFIELD(java.io.StreamTokenizer,nval,D) [11] DRETURN
 */
public final class parseNumber_006 extends JJITAbstractInstruction implements Cloneable{
      private KField c_nval = null;
      private KClassRepository c_repo;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KFrame callerFrame = null;
         // **REMOVED Unused Var** KRegister reg;
        KLocalThread thread = frame.getThread();
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[9] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[10] GETFIELD(java.io.StreamTokenizer,nval,D)
        if(c_nval == null){
          c_nval = c_repo.getClassByName("java.io.StreamTokenizer").getField("nval",true);
        }
         // **REMOVED Substitution** s0 = c_nval.getInstanceValue(((KReference)frame.getLocal(1)));
         // *********[11] DRETURN
         // **REMOVED Substitution** reg = c_nval.getInstanceValue(((KReference)frame.getLocal(1)));
        callerFrame = thread.popFrame();
        callerFrame.push(c_nval.getInstanceValue(((KReference)frame.getLocal(1))));
        return ((JJITInstruction)callerFrame.getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[9] ALOAD(1)
         // *********[10] GETFIELD(java.io.StreamTokenizer,nval,D)
        c_repo = process.getClassRepository();
         // *********[11] DRETURN
      }
}
