package jjit.local.jnt.Bench.Bench.doExecution__V_C25B2F44;
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
 * doExecution()V
 * [count=10] [9] ASTORE(2) [10] ALOAD(0) [11] ALOAD(0) [12] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;) [13] ARRAYLENGTH [14] ANEWARRAY(93) [15] PUTFIELD(jnt.Bench.Bench,timer) [16] ICONST_0(Integer{0}) [17] ISTORE(3) [18] GOTO(27)
 */
public final class doExecution_008 extends JJITAbstractInstruction implements Cloneable{
      private KField c_segments = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private KMemoryManager c_memman;
      private KClass c_CStopwatch = null;
      private KField c_timer = null;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** KProcess process = frame.getProcess();
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KRegister reg;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // local_2 2 ; r=0/w=1 : NotCached
         // local_3 3 ; r=0/w=1 : NotCached
         // *********[9] ASTORE(2)
        frame.setLocal(2,frame.pop());
         // *********[10] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[11] ALOAD(0)
         // **REMOVED Substitution** s1_ref = this_ref;
         // *********[12] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;)
         // **REMOVED Substitution** s1_ref = c_segments.getInstanceRef(this_ref);
         // *********[13] ARRAYLENGTH
         // **REMOVED Substitution** s1 = new KInteger(c_memman.getArraySize(c_segments.getInstanceRef(this_ref)));
         // *********[14] ANEWARRAY(93)
         // **REMOVED Substitution** index = c_memman.getArraySize(c_segments.getInstanceRef(this_ref));
        if(c_CStopwatch == null){
          c_CStopwatch = c_repo.getClassByName("jnt.Bench.Stopwatch");
        }
         // **REMOVED Substitution** s1_ref = c_memman.allocRefArray(c_CStopwatch,c_memman.getArraySize(c_segments.getInstanceRef(this_ref)));
         // *********[15] PUTFIELD(jnt.Bench.Bench,timer)
         // **REMOVED Substitution** reg = c_memman.allocRefArray(c_CStopwatch,c_memman.getArraySize(c_segments.getInstanceRef(this_ref)));
         // **REMOVED Substitution** ref = this_ref;
        c_timer.setInstanceValue(this_ref,c_memman.allocRefArray(c_CStopwatch,c_memman.getArraySize(c_segments.getInstanceRef(this_ref))));
         // *********[16] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[17] ISTORE(3)
        frame.setLocal(3,KInteger.ZERO);
         // *********[18] GOTO(27)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[9] ASTORE(2)
         // *********[10] ALOAD(0)
         // *********[11] ALOAD(0)
         // *********[12] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_segments = c_CBench.getField("segments",true);
         // *********[13] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[14] ANEWARRAY(93)
        c_repo = process.getClassRepository();
         // *********[15] PUTFIELD(jnt.Bench.Bench,timer)
        c_timer = c_CBench.getField("timer",true);
         // *********[16] ICONST_0(Integer{0})
         // *********[17] ISTORE(3)
         // *********[18] GOTO(27)
        c_label = instructions[10];
      }
}
