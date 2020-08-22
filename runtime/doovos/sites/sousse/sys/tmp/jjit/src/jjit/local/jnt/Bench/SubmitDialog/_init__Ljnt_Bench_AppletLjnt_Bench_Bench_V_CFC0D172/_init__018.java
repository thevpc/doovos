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
 * [count=5] [32] NEW(java.awt.Font) [33] DUP [34] LDC(22->"Helvetica") [35] ICONST_0(Integer{0}) [36] BIPUSH(12)
 */
public final class _init__018 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CFont = null;
      private static KReference R22 = null;
      private static final KInteger IZERO = KInteger.ZERO;
      private static final KInteger I12 = new KInteger(12);
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // *********[32] NEW(java.awt.Font)
        if(c_CFont == null){
          c_CFont = c_repo.getClassByName("java.awt.Font");
        }
        s0_ref = memseg.allocObject(c_CFont);
         // *********[33] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[34] LDC(22->"Helvetica")
        frame.push(R22);
         // *********[35] ICONST_0(Integer{0})
        frame.push(IZERO);
         // *********[36] BIPUSH(12)
        frame.push(I12);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[32] NEW(java.awt.Font)
        c_repo = process.getClassRepository();
         // *********[33] DUP
         // *********[34] LDC(22->"Helvetica")
        R22 = ((KReference)constants[22]);
         // *********[35] ICONST_0(Integer{0})
         // *********[36] BIPUSH(12)
        c_next = instructions[(index + 1)];
      }
}
