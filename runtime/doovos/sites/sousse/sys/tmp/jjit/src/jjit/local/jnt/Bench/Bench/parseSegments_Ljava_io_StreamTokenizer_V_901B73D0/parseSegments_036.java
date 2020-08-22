package jjit.local.jnt.Bench.Bench.parseSegments_Ljava_io_StreamTokenizer_V_901B73D0;
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
 * parseSegments(Ljava/io/StreamTokenizer;)V
 * [count=6] [113] ANEWARRAY(18) [114] PUTFIELD(jnt.Bench.Bench,segments) [115] ALOAD(2) [116] ALOAD(0) [117] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;) [118] INVOKEVIRTUAL(java.util.Vector,copyInto([Ljava/lang/Object;)V)
 */
public final class parseSegments_036 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private KClassRepository c_repo;
      private KClass c_CSegment = null;
      private KField c_segments = null;
      private KClass c_CBench = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** KProcess process = frame.getProcess();
         // **REMOVED Unused Var** int index = 0;
        KReference ref;
        KRegister reg;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[113] ANEWARRAY(18)
         // **REMOVED Substitution** index = frame.popInt();
        if(c_CSegment == null){
          c_CSegment = c_repo.getClassByName("jnt.Bench.Segment");
        }
         // **REMOVED Substitution** s0_ref = c_memman.allocRefArray(c_CSegment,frame.popInt());
         // *********[114] PUTFIELD(jnt.Bench.Bench,segments)
        reg = c_memman.allocRefArray(c_CSegment,frame.popInt());
         // **REMOVED Substitution** ref = frame.popRef();
        c_segments.setInstanceValue(frame.popRef(),reg);
         // *********[115] ALOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[116] ALOAD(0)
         // **REMOVED Substitution** s1 = frame.getLocal(0);
         // *********[117] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;)
         // **REMOVED Substitution** s1_ref = c_segments.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[118] INVOKEVIRTUAL(java.util.Vector,copyInto([Ljava/lang/Object;)V)
        regs = new KRegister[2];
        regs[1] = c_segments.getInstanceRef(((KReference)frame.getLocal(0)));
        ref = ((KReference)frame.getLocal(2));
        regs[0] = ref;
        frame.setProgramCounter(36);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("copyInto([Ljava/lang/Object;)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("copyInto([Ljava/lang/Object;)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[113] ANEWARRAY(18)
        c_memman = process.getMemoryManager();
        c_repo = process.getClassRepository();
         // *********[114] PUTFIELD(jnt.Bench.Bench,segments)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_segments = c_CBench.getField("segments",true);
         // *********[115] ALOAD(2)
         // *********[116] ALOAD(0)
         // *********[117] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;)
         // *********[118] INVOKEVIRTUAL(java.util.Vector,copyInto([Ljava/lang/Object;)V)
      }
}
