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
 * [count=4] [4] ALOAD(1) [5] GETFIELD(java.io.StreamTokenizer,ttype,I) [6] BIPUSH(-3) [7] IF_ICMPEQ(13)
 */
public final class parseString_005 extends JJITAbstractInstruction implements Cloneable{
      private KField c_ttype = null;
      private KClassRepository c_repo;
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[4] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[5] GETFIELD(java.io.StreamTokenizer,ttype,I)
        if(c_ttype == null){
          c_ttype = c_repo.getClassByName("java.io.StreamTokenizer").getField("ttype",true);
        }
         // **REMOVED Substitution** s0 = c_ttype.getInstanceValue(((KReference)frame.getLocal(1)));
         // *********[6] BIPUSH(-3)
         // **REMOVED Substitution** s1 = IM3;
         // *********[7] IF_ICMPEQ(13)
         // **REMOVED Substitution** index = -3;
         // **REMOVED Substitution** jump = c_ttype.getInstanceValue(((KReference)frame.getLocal(1))).intValue() == -3;
        return ((c_ttype.getInstanceValue(((KReference)frame.getLocal(1))).intValue() == -3)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[4] ALOAD(1)
         // *********[5] GETFIELD(java.io.StreamTokenizer,ttype,I)
        c_repo = process.getClassRepository();
         // *********[6] BIPUSH(-3)
         // *********[7] IF_ICMPEQ(13)
        c_next = instructions[(index + 1)];
        c_label = instructions[6];
      }
}
