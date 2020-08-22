package jjit.local.jnt.Bench.Bench.parseEntries_Ljava_io_StreamTokenizer_V_6B9C6DF2;
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
 * parseEntries(Ljava/io/StreamTokenizer;)V
 * [count=4] [45] ALOAD(0) [46] ALOAD(0) [47] GETFIELD(jnt.Bench.Bench,ascending,Z) [48] IFEQ(57)
 */
public final class parseEntries_012 extends JJITAbstractInstruction implements Cloneable{
      private KField c_ascending = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[45] ALOAD(0)
        frame.push(this_ref);
         // *********[46] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[47] GETFIELD(jnt.Bench.Bench,ascending,Z)
         // **REMOVED Substitution** s0 = c_ascending.getInstanceValue(this_ref);
         // *********[48] IFEQ(57)
         // **REMOVED Substitution** index = c_ascending.getInstanceValue(this_ref).intValue();
         // **REMOVED Substitution** jump = c_ascending.getInstanceValue(this_ref).intValue() == 0;
        return ((c_ascending.getInstanceValue(this_ref).intValue() == 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[45] ALOAD(0)
         // *********[46] ALOAD(0)
         // *********[47] GETFIELD(jnt.Bench.Bench,ascending,Z)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_ascending = c_CBench.getField("ascending",true);
         // *********[48] IFEQ(57)
        c_next = instructions[(index + 1)];
        c_label = instructions[14];
      }
}
