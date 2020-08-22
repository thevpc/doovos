package jjit.local.jnt.Bench.Bench.getSegmentNames___Ljava_lang_String_524B699E;
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
 * getSegmentNames()[Ljava/lang/String;
 * [count=9] [8] ALOAD(1) [9] ILOAD(2) [10] ALOAD(0) [11] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;) [12] ILOAD(2) [13] AALOAD [14] GETFIELD(jnt.Bench.Segment,name,Ljava/lang/String;) [15] AASTORE [16] IINC(2,1)
 */
public final class getSegmentNames_004 extends JJITAbstractInstruction implements Cloneable{
      private KField c_segments = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private KMemoryManager c_memman;
      private KField c_name = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s2_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KReference m_r;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // local_2 2 ; r=3/w=1 : Cached
        int local_2 = frame.getLocal(2).intValue();
         // *********[8] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[9] ILOAD(2)
         // **REMOVED Substitution** s1 = new KInteger(local_2);
         // *********[10] ALOAD(0)
         // **REMOVED Substitution** s2 = frame.getLocal(0);
         // *********[11] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;)
         // **REMOVED Substitution** s2_ref = c_segments.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[12] ILOAD(2)
         // **REMOVED Substitution** s3 = new KInteger(local_2);
         // *********[13] AALOAD
         // **REMOVED Substitution** index = local_2;
         // **REMOVED Substitution** ref = c_segments.getInstanceRef(((KReference)frame.getLocal(0)));
         // **REMOVED Substitution** s2_ref = c_memman.getReferenceArray(c_segments.getInstanceRef(((KReference)frame.getLocal(0))),local_2);
         // *********[14] GETFIELD(jnt.Bench.Segment,name,Ljava/lang/String;)
        if(c_name == null){
          c_name = c_repo.getClassByName("jnt.Bench.Segment").getField("name",true);
        }
         // **REMOVED Substitution** s2 = c_name.getInstanceValue(c_memman.getReferenceArray(c_segments.getInstanceRef(((KReference)frame.getLocal(0))),local_2));
         // *********[15] AASTORE
         // **REMOVED Substitution** m_r = ((KReference)c_name.getInstanceValue(c_memman.getReferenceArray(c_segments.getInstanceRef(((KReference)frame.getLocal(0))),local_2)));
         // **REMOVED Substitution** index = local_2;
        c_memman.setReferenceArray(((KReference)frame.getLocal(1)),local_2,((KReference)c_name.getInstanceValue(c_memman.getReferenceArray(c_segments.getInstanceRef(((KReference)frame.getLocal(0))),local_2))));
         // *********[16] IINC(2,1)
         // **REMOVED Substitution** local_2 = (local_2 + 1);
        frame.setLocal(2,new KInteger((local_2 + 1)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[8] ALOAD(1)
         // *********[9] ILOAD(2)
         // *********[10] ALOAD(0)
         // *********[11] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_segments = c_CBench.getField("segments",true);
         // *********[12] ILOAD(2)
         // *********[13] AALOAD
        c_memman = process.getMemoryManager();
         // *********[14] GETFIELD(jnt.Bench.Segment,name,Ljava/lang/String;)
        c_repo = process.getClassRepository();
         // *********[15] AASTORE
         // *********[16] IINC(2,1)
        c_next = instructions[(index + 1)];
      }
}
