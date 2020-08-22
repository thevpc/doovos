package jjit.local.jnt.Bench.Bench.checkDefaultSegment__V_20A60AEF;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Bench
 * checkDefaultSegment()V
 * [count=12] [5] ALOAD(0) [6] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;) [7] ICONST_0(Integer{0}) [8] NEW(jnt.Bench.Segment) [9] DUP [10] ALOAD(0) [11] GETFIELD(jnt.Bench.Bench,name,Ljava/lang/String;) [12] ACONST_NULL [13] ALOAD(0) [14] GETFIELD(jnt.Bench.Bench,units,Ljava/lang/String;) [15] ALOAD(0) [16] GETFIELD(jnt.Bench.Bench,decimals,I)
 */
public final class checkDefaultSegment_002 extends JJITAbstractInstruction implements Cloneable{
      private KField c_segments = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private static final KInteger IZERO = KInteger.ZERO;
      private KClass c_CSegment = null;
      private KField c_name = null;
      private KField c_units = null;
      private KField c_decimals = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // this_ref 0 ; r=4/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[5] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[6] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;)
        frame.push(c_segments.getInstanceRef(this_ref));
         // *********[7] ICONST_0(Integer{0})
        frame.push(IZERO);
         // *********[8] NEW(jnt.Bench.Segment)
        if(c_CSegment == null){
          c_CSegment = c_repo.getClassByName("jnt.Bench.Segment");
        }
        s0_ref = memseg.allocObject(c_CSegment);
         // *********[9] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[10] ALOAD(0)
         // **REMOVED Substitution** s1_ref = this_ref;
         // *********[11] GETFIELD(jnt.Bench.Bench,name,Ljava/lang/String;)
        frame.push(c_name.getInstanceRef(this_ref));
         // *********[12] ACONST_NULL
        frame.push(KReference.NULL);
         // *********[13] ALOAD(0)
         // **REMOVED Substitution** s1_ref = this_ref;
         // *********[14] GETFIELD(jnt.Bench.Bench,units,Ljava/lang/String;)
        frame.push(c_units.getInstanceRef(this_ref));
         // *********[15] ALOAD(0)
         // **REMOVED Substitution** s1_ref = this_ref;
         // *********[16] GETFIELD(jnt.Bench.Bench,decimals,I)
        frame.push(new KInteger(c_decimals.getInstanceInt(this_ref)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[5] ALOAD(0)
         // *********[6] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_segments = c_CBench.getField("segments",true);
         // *********[7] ICONST_0(Integer{0})
         // *********[8] NEW(jnt.Bench.Segment)
        c_repo = process.getClassRepository();
         // *********[9] DUP
         // *********[10] ALOAD(0)
         // *********[11] GETFIELD(jnt.Bench.Bench,name,Ljava/lang/String;)
        c_name = c_CBench.getField("name",true);
         // *********[12] ACONST_NULL
         // *********[13] ALOAD(0)
         // *********[14] GETFIELD(jnt.Bench.Bench,units,Ljava/lang/String;)
        c_units = c_CBench.getField("units",true);
         // *********[15] ALOAD(0)
         // *********[16] GETFIELD(jnt.Bench.Bench,decimals,I)
        c_decimals = c_CBench.getField("decimals",true);
        c_next = instructions[(index + 1)];
      }
}
