package jjit.local.jnt.Bench.Bench.doExecution__V_C25B2F44;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Bench
 * doExecution()V
 * [count=9] [46] ALOAD(0) [47] ALOAD(0) [48] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;) [49] ARRAYLENGTH [50] NEWARRAY [51] PUTFIELD(jnt.Bench.Bench,current) [52] ALOAD(0) [53] GETFIELD(jnt.Bench.Bench,timerAPIused,Z) [54] IFEQ(74)
 */
public final class doExecution_020 extends JJITAbstractInstruction implements Cloneable{
      private KField c_segments = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private KMemoryManager c_memman;
      private KField c_current = null;
      private KField c_timerAPIused = null;
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KRegister reg;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // this_ref 0 ; r=3/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[46] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[47] ALOAD(0)
         // **REMOVED Substitution** s1_ref = this_ref;
         // *********[48] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;)
         // **REMOVED Substitution** s1_ref = c_segments.getInstanceRef(this_ref);
         // *********[49] ARRAYLENGTH
         // **REMOVED Substitution** s1 = new KInteger(c_memman.getArraySize(c_segments.getInstanceRef(this_ref)));
         // *********[50] NEWARRAY
         // **REMOVED Substitution** s1_ref = memseg.allocDoubleArray(c_memman.getArraySize(c_segments.getInstanceRef(this_ref)));
         // *********[51] PUTFIELD(jnt.Bench.Bench,current)
         // **REMOVED Substitution** reg = memseg.allocDoubleArray(c_memman.getArraySize(c_segments.getInstanceRef(this_ref)));
         // **REMOVED Substitution** ref = this_ref;
        c_current.setInstanceValue(this_ref,memseg.allocDoubleArray(c_memman.getArraySize(c_segments.getInstanceRef(this_ref))));
         // *********[52] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[53] GETFIELD(jnt.Bench.Bench,timerAPIused,Z)
         // **REMOVED Substitution** s0 = c_timerAPIused.getInstanceValue(this_ref);
         // *********[54] IFEQ(74)
         // **REMOVED Substitution** index = c_timerAPIused.getInstanceValue(this_ref).intValue();
         // **REMOVED Substitution** jump = c_timerAPIused.getInstanceValue(this_ref).intValue() == 0;
        return ((c_timerAPIused.getInstanceValue(this_ref).intValue() == 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[46] ALOAD(0)
         // *********[47] ALOAD(0)
         // *********[48] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_segments = c_CBench.getField("segments",true);
         // *********[49] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[50] NEWARRAY
         // *********[51] PUTFIELD(jnt.Bench.Bench,current)
        c_current = c_CBench.getField("current",true);
         // *********[52] ALOAD(0)
         // *********[53] GETFIELD(jnt.Bench.Bench,timerAPIused,Z)
        c_timerAPIused = c_CBench.getField("timerAPIused",true);
         // *********[54] IFEQ(74)
        c_next = instructions[(index + 1)];
        c_label = instructions[25];
      }
}
