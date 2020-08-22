package jjit.local.jnt.Bench.Bench.printMeasurements_Ljava_io_PrintStream_V_CC1E980A;
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
 * printMeasurements(Ljava/io/PrintStream;)V
 * [count=6] [15] ALOAD(0) [16] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;) [17] ILOAD(4) [18] AALOAD [19] GETFIELD(jnt.Bench.Segment,decimals,I) [20] ISTORE(3)
 */
public final class printMeasurements_004 extends JJITAbstractInstruction implements Cloneable{
      private KField c_segments = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private KMemoryManager c_memman;
      private KField c_decimals = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** KReference ref;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_3 3 ; r=0/w=1 : NotCached
         // local_4 4 ; r=1/w=0 : NotCached
         // *********[15] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[16] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;)
         // **REMOVED Substitution** s0_ref = c_segments.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[17] ILOAD(4)
         // **REMOVED Substitution** s1 = frame.getLocal(4);
         // *********[18] AALOAD
         // **REMOVED Substitution** index = frame.getLocal(4).intValue();
         // **REMOVED Substitution** ref = c_segments.getInstanceRef(((KReference)frame.getLocal(0)));
         // **REMOVED Substitution** s0_ref = c_memman.getReferenceArray(c_segments.getInstanceRef(((KReference)frame.getLocal(0))),frame.getLocal(4).intValue());
         // *********[19] GETFIELD(jnt.Bench.Segment,decimals,I)
        if(c_decimals == null){
          c_decimals = c_repo.getClassByName("jnt.Bench.Segment").getField("decimals",true);
        }
         // **REMOVED Substitution** s0 = c_decimals.getInstanceValue(c_memman.getReferenceArray(c_segments.getInstanceRef(((KReference)frame.getLocal(0))),frame.getLocal(4).intValue()));
         // *********[20] ISTORE(3)
        frame.setLocal(3,c_decimals.getInstanceValue(c_memman.getReferenceArray(c_segments.getInstanceRef(((KReference)frame.getLocal(0))),frame.getLocal(4).intValue())));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[15] ALOAD(0)
         // *********[16] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_segments = c_CBench.getField("segments",true);
         // *********[17] ILOAD(4)
         // *********[18] AALOAD
        c_memman = process.getMemoryManager();
         // *********[19] GETFIELD(jnt.Bench.Segment,decimals,I)
        c_repo = process.getClassRepository();
         // *********[20] ISTORE(3)
        c_next = instructions[(index + 1)];
      }
}
