package jjit.local.jnt.Bench.Bench.checkDefaultSegment__V_20A60AEF;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Bench
 * checkDefaultSegment()V
 * [count=5] [0] ALOAD(0) [1] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;) [2] ICONST_0(Integer{0}) [3] AALOAD [4] IFNONNULL(19)
 */
public final class checkDefaultSegment_001 extends JJITAbstractInstruction implements Cloneable{
      private KField c_segments = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private KMemoryManager c_memman;
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** KReference ref;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[0] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[1] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;)
         // **REMOVED Substitution** s0_ref = c_segments.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[2] ICONST_0(Integer{0})
         // **REMOVED Substitution** s1 = IZERO;
         // *********[3] AALOAD
         // **REMOVED Substitution** index = 0;
         // **REMOVED Substitution** ref = c_segments.getInstanceRef(((KReference)frame.getLocal(0)));
         // **REMOVED Substitution** s0_ref = c_memman.getReferenceArray(c_segments.getInstanceRef(((KReference)frame.getLocal(0))),0);
         // *********[4] IFNONNULL(19)
        return ((c_memman.getReferenceArray(c_segments.getInstanceRef(((KReference)frame.getLocal(0))),0).isNotNull())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_segments = c_CBench.getField("segments",true);
         // *********[2] ICONST_0(Integer{0})
         // *********[3] AALOAD
        c_memman = process.getMemoryManager();
         // *********[4] IFNONNULL(19)
        c_next = instructions[(index + 1)];
        c_label = instructions[5];
      }
}
