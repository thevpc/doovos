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
 * [count=4] [43] NEW(java.awt.Label) [44] DUP [45] LDC(27->"Submit Benchmark Results") [46] ICONST_1(Integer{1})
 */
public final class _init__025 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CLabel = null;
      private static KReference R27 = null;
      private static final KInteger IONE = KInteger.ONE;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // *********[43] NEW(java.awt.Label)
        if(c_CLabel == null){
          c_CLabel = c_repo.getClassByName("java.awt.Label");
        }
        s0_ref = memseg.allocObject(c_CLabel);
         // *********[44] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[45] LDC(27->"Submit Benchmark Results")
        frame.push(R27);
         // *********[46] ICONST_1(Integer{1})
        frame.push(IONE);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[43] NEW(java.awt.Label)
        c_repo = process.getClassRepository();
         // *********[44] DUP
         // *********[45] LDC(27->"Submit Benchmark Results")
        R27 = ((KReference)constants[27]);
         // *********[46] ICONST_1(Integer{1})
        c_next = instructions[(index + 1)];
      }
}
