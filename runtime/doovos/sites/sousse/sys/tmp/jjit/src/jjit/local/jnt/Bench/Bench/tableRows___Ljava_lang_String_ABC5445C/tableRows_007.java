package jjit.local.jnt.Bench.Bench.tableRows___Ljava_lang_String_ABC5445C;
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
 * tableRows()[Ljava/lang/String;
 * [count=21] [19] ALOAD(1) [20] ICONST_0(Integer{0}) [21] ALOAD(0) [22] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;) [23] ILOAD(3) [24] AALOAD [25] GETFIELD(jnt.Bench.Segment,shortname,Ljava/lang/String;) [26] AASTORE [27] ALOAD(1) [28] ICONST_1(Integer{1}) [29] ALOAD(0) [30] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;) [31] ILOAD(3) [32] AALOAD [33] GETFIELD(jnt.Bench.Segment,units,Ljava/lang/String;) [34] AASTORE [35] ALOAD(2) [36] ALOAD(1) [37] ALOAD(0) [38] ILOAD(3) [39] INVOKEVIRTUAL(jnt.Bench.Bench,getSegmentValues(I)[D)
 */
public final class tableRows_007 extends JJITAbstractInstruction implements Cloneable{
      private KField c_segments = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private KMemoryManager c_memman;
      private KField c_shortname = null;
      private KField c_units = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s2_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** KRegister s3;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KReference m_r;
         // **REMOVED Unused Var** KReference m_r2;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=3/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // local_1 1 ; r=3/w=0 : Cached
        KRegister local_1 = frame.getLocal(1);
         // local_2 2 ; r=1/w=0 : NotCached
         // local_3 3 ; r=3/w=0 : Cached
        int local_3 = frame.getLocal(3).intValue();
         // *********[19] ALOAD(1)
         // **REMOVED Substitution** s0 = local_1;
         // *********[20] ICONST_0(Integer{0})
         // **REMOVED Substitution** s1 = IZERO;
         // *********[21] ALOAD(0)
         // **REMOVED Substitution** s2_ref = this_ref;
         // *********[22] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;)
         // **REMOVED Substitution** s2_ref = c_segments.getInstanceRef(this_ref);
         // *********[23] ILOAD(3)
         // **REMOVED Substitution** s3 = new KInteger(local_3);
         // *********[24] AALOAD
         // **REMOVED Substitution** index = local_3;
         // **REMOVED Substitution** ref = c_segments.getInstanceRef(this_ref);
         // **REMOVED Substitution** s2_ref = c_memman.getReferenceArray(c_segments.getInstanceRef(this_ref),local_3);
         // *********[25] GETFIELD(jnt.Bench.Segment,shortname,Ljava/lang/String;)
        if(c_shortname == null){
          c_shortname = c_repo.getClassByName("jnt.Bench.Segment").getField("shortname",true);
        }
         // **REMOVED Substitution** s2 = c_shortname.getInstanceValue(c_memman.getReferenceArray(c_segments.getInstanceRef(this_ref),local_3));
         // *********[26] AASTORE
         // **REMOVED Substitution** m_r = ((KReference)c_shortname.getInstanceValue(c_memman.getReferenceArray(c_segments.getInstanceRef(this_ref),local_3)));
         // **REMOVED Substitution** index = 0;
        c_memman.setReferenceArray(((KReference)local_1),0,((KReference)c_shortname.getInstanceValue(c_memman.getReferenceArray(c_segments.getInstanceRef(this_ref),local_3))));
         // *********[27] ALOAD(1)
         // **REMOVED Substitution** s0 = local_1;
         // *********[28] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[29] ALOAD(0)
         // **REMOVED Substitution** s2_ref = this_ref;
         // *********[30] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;)
         // **REMOVED Substitution** s2_ref = c_segments.getInstanceRef(this_ref);
         // *********[31] ILOAD(3)
         // **REMOVED Substitution** s3 = new KInteger(local_3);
         // *********[32] AALOAD
         // **REMOVED Substitution** index = local_3;
         // **REMOVED Substitution** ref = c_segments.getInstanceRef(this_ref);
         // **REMOVED Substitution** s2_ref = c_memman.getReferenceArray(c_segments.getInstanceRef(this_ref),local_3);
         // *********[33] GETFIELD(jnt.Bench.Segment,units,Ljava/lang/String;)
        if(c_units == null){
          c_units = c_repo.getClassByName("jnt.Bench.Segment").getField("units",true);
        }
         // **REMOVED Substitution** s2 = c_units.getInstanceValue(c_memman.getReferenceArray(c_segments.getInstanceRef(this_ref),local_3));
         // *********[34] AASTORE
         // **REMOVED Substitution** m_r2 = ((KReference)c_units.getInstanceValue(c_memman.getReferenceArray(c_segments.getInstanceRef(this_ref),local_3)));
         // **REMOVED Substitution** index = 1;
        c_memman.setReferenceArray(((KReference)local_1),1,((KReference)c_units.getInstanceValue(c_memman.getReferenceArray(c_segments.getInstanceRef(this_ref),local_3))));
         // *********[35] ALOAD(2)
        frame.push(frame.getLocal(2));
         // *********[36] ALOAD(1)
        frame.push(local_1);
         // *********[37] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[38] ILOAD(3)
         // **REMOVED Substitution** s1 = new KInteger(local_3);
         // *********[39] INVOKEVIRTUAL(jnt.Bench.Bench,getSegmentValues(I)[D)
        regs = new KRegister[2];
        regs[1] = new KInteger(local_3);
         // **REMOVED Substitution** ref = this_ref;
        regs[0] = this_ref;
        frame.setProgramCounter(7);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("getSegmentValues(I)[D"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("getSegmentValues(I)[D"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[19] ALOAD(1)
         // *********[20] ICONST_0(Integer{0})
         // *********[21] ALOAD(0)
         // *********[22] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_segments = c_CBench.getField("segments",true);
         // *********[23] ILOAD(3)
         // *********[24] AALOAD
        c_memman = process.getMemoryManager();
         // *********[25] GETFIELD(jnt.Bench.Segment,shortname,Ljava/lang/String;)
        c_repo = process.getClassRepository();
         // *********[26] AASTORE
         // *********[27] ALOAD(1)
         // *********[28] ICONST_1(Integer{1})
         // *********[29] ALOAD(0)
         // *********[30] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;)
         // *********[31] ILOAD(3)
         // *********[32] AALOAD
         // *********[33] GETFIELD(jnt.Bench.Segment,units,Ljava/lang/String;)
        c_repo = process.getClassRepository();
         // *********[34] AASTORE
         // *********[35] ALOAD(2)
         // *********[36] ALOAD(1)
         // *********[37] ALOAD(0)
         // *********[38] ILOAD(3)
         // *********[39] INVOKEVIRTUAL(jnt.Bench.Bench,getSegmentValues(I)[D)
      }
}
