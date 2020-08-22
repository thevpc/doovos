package jjit.local.jnt.Bench.Segment._init__Ljava_lang_StringLjava_lang_StringLjava_lang_StringI_V_47A47A89;
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
 * jnt.Bench.Segment
 * <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
 * [count=6] [2] ALOAD(0) [3] ALOAD(1) [4] PUTFIELD(jnt.Bench.Segment,name) [5] ALOAD(0) [6] ALOAD(2) [7] IFNULL(10)
 */
public final class _init__004 extends JJITAbstractInstruction implements Cloneable{
      private KField c_name = null;
      private KClassRepository c_repo;
      private KClass c_CSegment = null;
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KRegister reg;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // local_1 1 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[2] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[3] ALOAD(1)
         // **REMOVED Substitution** s1 = frame.getLocal(1);
         // *********[4] PUTFIELD(jnt.Bench.Segment,name)
         // **REMOVED Substitution** reg = frame.getLocal(1);
         // **REMOVED Substitution** ref = this_ref;
        c_name.setInstanceValue(this_ref,frame.getLocal(1));
         // *********[5] ALOAD(0)
        frame.push(this_ref);
         // *********[6] ALOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[7] IFNULL(10)
        return ((((KReference)frame.getLocal(2)).isNull())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[2] ALOAD(0)
         // *********[3] ALOAD(1)
         // *********[4] PUTFIELD(jnt.Bench.Segment,name)
        c_repo = process.getClassRepository();
        c_CSegment = c_repo.getClassByName("jnt.Bench.Segment");
        c_name = c_CSegment.getField("name",true);
         // *********[5] ALOAD(0)
         // *********[6] ALOAD(2)
         // *********[7] IFNULL(10)
        c_next = instructions[(index + 1)];
        c_label = instructions[5];
      }
}
