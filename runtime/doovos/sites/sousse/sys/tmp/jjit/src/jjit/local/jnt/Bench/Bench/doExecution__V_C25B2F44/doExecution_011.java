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
 * [count=5] [27] ILOAD(3) [28] ALOAD(0) [29] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;) [30] ARRAYLENGTH [31] IF_ICMPLT(19)
 */
public final class doExecution_011 extends JJITAbstractInstruction implements Cloneable{
      private KField c_segments = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=0 : NotCached
         // *********[27] ILOAD(3)
         // **REMOVED Substitution** s0 = frame.getLocal(3);
         // *********[28] ALOAD(0)
         // **REMOVED Substitution** s1 = frame.getLocal(0);
         // *********[29] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;)
         // **REMOVED Substitution** s1_ref = c_segments.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[30] ARRAYLENGTH
         // **REMOVED Substitution** s1 = new KInteger(c_memman.getArraySize(c_segments.getInstanceRef(((KReference)frame.getLocal(0)))));
         // *********[31] IF_ICMPLT(19)
         // **REMOVED Substitution** index = c_memman.getArraySize(c_segments.getInstanceRef(((KReference)frame.getLocal(0))));
         // **REMOVED Substitution** jump = frame.getLocal(3).intValue() < c_memman.getArraySize(c_segments.getInstanceRef(((KReference)frame.getLocal(0))));
        return ((frame.getLocal(3).intValue() < c_memman.getArraySize(c_segments.getInstanceRef(((KReference)frame.getLocal(0)))))?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[27] ILOAD(3)
         // *********[28] ALOAD(0)
         // *********[29] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_segments = c_CBench.getField("segments",true);
         // *********[30] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[31] IF_ICMPLT(19)
        c_next = instructions[(index + 1)];
        c_label = instructions[8];
      }
}
