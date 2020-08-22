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
 * [count=8] [11] PUTFIELD(jnt.Bench.Segment,shortname) [12] ALOAD(0) [13] ALOAD(3) [14] PUTFIELD(jnt.Bench.Segment,units) [15] ALOAD(0) [16] ILOAD(4) [17] PUTFIELD(jnt.Bench.Segment,decimals) [18] RETURN
 */
public final class _init__007 extends JJITAbstractInstruction implements Cloneable{
      private KField c_shortname = null;
      private KClassRepository c_repo;
      private KClass c_CSegment = null;
      private KField c_units = null;
      private KField c_decimals = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** KReference ref;
        KRegister reg;
         // **REMOVED Unused Var** KFrame callerFrame = null;
        KLocalThread thread = frame.getThread();
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // local_3 3 ; r=1/w=0 : NotCached
         // local_4 4 ; r=1/w=0 : NotCached
         // *********[11] PUTFIELD(jnt.Bench.Segment,shortname)
        reg = frame.pop();
         // **REMOVED Substitution** ref = frame.popRef();
        c_shortname.setInstanceValue(frame.popRef(),reg);
         // *********[12] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[13] ALOAD(3)
         // **REMOVED Substitution** s1 = frame.getLocal(3);
         // *********[14] PUTFIELD(jnt.Bench.Segment,units)
         // **REMOVED Substitution** reg = frame.getLocal(3);
         // **REMOVED Substitution** ref = this_ref;
        c_units.setInstanceValue(this_ref,frame.getLocal(3));
         // *********[15] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[16] ILOAD(4)
         // **REMOVED Substitution** s1 = frame.getLocal(4);
         // *********[17] PUTFIELD(jnt.Bench.Segment,decimals)
         // **REMOVED Substitution** reg = frame.getLocal(4);
         // **REMOVED Substitution** ref = this_ref;
        c_decimals.setInstanceInt(this_ref,frame.getLocal(4).intValue());
         // *********[18] RETURN
         // **REMOVED Substitution** callerFrame = thread.popFrame();
        return ((JJITInstruction)thread.popFrame().getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[11] PUTFIELD(jnt.Bench.Segment,shortname)
        c_repo = process.getClassRepository();
        c_CSegment = c_repo.getClassByName("jnt.Bench.Segment");
        c_shortname = c_CSegment.getField("shortname",true);
         // *********[12] ALOAD(0)
         // *********[13] ALOAD(3)
         // *********[14] PUTFIELD(jnt.Bench.Segment,units)
        c_units = c_CSegment.getField("units",true);
         // *********[15] ALOAD(0)
         // *********[16] ILOAD(4)
         // *********[17] PUTFIELD(jnt.Bench.Segment,decimals)
        c_decimals = c_CSegment.getField("decimals",true);
         // *********[18] RETURN
      }
}
