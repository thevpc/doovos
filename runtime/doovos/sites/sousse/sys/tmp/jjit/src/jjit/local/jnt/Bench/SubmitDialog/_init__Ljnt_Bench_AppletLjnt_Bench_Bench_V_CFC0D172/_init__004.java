package jjit.local.jnt.Bench.SubmitDialog._init__Ljnt_Bench_AppletLjnt_Bench_Bench_V_CFC0D172;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.SubmitDialog
 * <init>(Ljnt/Bench/Applet;Ljnt/Bench/Bench;)V
 * [count=3] [3] ALOAD(0) [4] NEW(java.awt.GridBagLayout) [5] DUP
 */
public final class _init__004 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CGridBagLayout = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[3] ALOAD(0)
        frame.push(frame.getLocal(0));
         // *********[4] NEW(java.awt.GridBagLayout)
        if(c_CGridBagLayout == null){
          c_CGridBagLayout = c_repo.getClassByName("java.awt.GridBagLayout");
        }
        s0_ref = memseg.allocObject(c_CGridBagLayout);
         // *********[5] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[3] ALOAD(0)
         // *********[4] NEW(java.awt.GridBagLayout)
        c_repo = process.getClassRepository();
         // *********[5] DUP
        c_next = instructions[(index + 1)];
      }
}
