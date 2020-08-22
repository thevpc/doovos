package jjit.local.jnt.Bench.Bench._init__Ljnt_Bench_AppletLjava_io_InputStream_V_BD69B656;
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
 * <init>(Ljnt/Bench/Applet;Ljava/io/InputStream;)V
 * [count=5] [22] ANEWARRAY(18) [23] PUTFIELD(jnt.Bench.Bench,segments) [24] ALOAD(0) [25] NEW(java.util.Vector) [26] DUP
 */
public final class _init__006 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private KClassRepository c_repo;
      private KClass c_CSegment = null;
      private KField c_segments = null;
      private KClass c_CBench = null;
      private KClass c_CVector = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
         // **REMOVED Unused Var** KProcess process = frame.getProcess();
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** KReference ref;
        KRegister reg;
        KMemorySegment memseg = frame.getMemorySegment();
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[22] ANEWARRAY(18)
         // **REMOVED Substitution** index = frame.popInt();
        if(c_CSegment == null){
          c_CSegment = c_repo.getClassByName("jnt.Bench.Segment");
        }
         // **REMOVED Substitution** s0_ref = c_memman.allocRefArray(c_CSegment,frame.popInt());
         // *********[23] PUTFIELD(jnt.Bench.Bench,segments)
        reg = c_memman.allocRefArray(c_CSegment,frame.popInt());
         // **REMOVED Substitution** ref = frame.popRef();
        c_segments.setInstanceValue(frame.popRef(),reg);
         // *********[24] ALOAD(0)
        frame.push(frame.getLocal(0));
         // *********[25] NEW(java.util.Vector)
        if(c_CVector == null){
          c_CVector = c_repo.getClassByName("java.util.Vector");
        }
        s0_ref = memseg.allocObject(c_CVector);
         // *********[26] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[22] ANEWARRAY(18)
        c_memman = process.getMemoryManager();
        c_repo = process.getClassRepository();
         // *********[23] PUTFIELD(jnt.Bench.Bench,segments)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_segments = c_CBench.getField("segments",true);
         // *********[24] ALOAD(0)
         // *********[25] NEW(java.util.Vector)
        c_repo = process.getClassRepository();
         // *********[26] DUP
        c_next = instructions[(index + 1)];
      }
}
