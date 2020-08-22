package jjit.local.jnt.Bench.Applet.startBenchmark__V_C435FC83;
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
 * jnt.Bench.Applet
 * startBenchmark()V
 * [count=5] [16] ALOAD(0) [17] NEW(java.lang.Thread) [18] DUP [19] ALOAD(0) [20] GETFIELD(jnt.Bench.Applet,bench,Ljnt/Bench/Bench;)
 */
public final class startBenchmark_012 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CThread = null;
      private KField c_bench = null;
      private KClass c_CApplet = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[16] ALOAD(0)
        frame.push(this_ref);
         // *********[17] NEW(java.lang.Thread)
        if(c_CThread == null){
          c_CThread = c_repo.getClassByName("java.lang.Thread");
        }
        s0_ref = memseg.allocObject(c_CThread);
         // *********[18] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[19] ALOAD(0)
         // **REMOVED Substitution** s1_ref = this_ref;
         // *********[20] GETFIELD(jnt.Bench.Applet,bench,Ljnt/Bench/Bench;)
        frame.push(c_bench.getInstanceRef(this_ref));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[16] ALOAD(0)
         // *********[17] NEW(java.lang.Thread)
        c_repo = process.getClassRepository();
         // *********[18] DUP
         // *********[19] ALOAD(0)
         // *********[20] GETFIELD(jnt.Bench.Applet,bench,Ljnt/Bench/Bench;)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_bench = c_CApplet.getField("bench",true);
        c_next = instructions[(index + 1)];
      }
}
