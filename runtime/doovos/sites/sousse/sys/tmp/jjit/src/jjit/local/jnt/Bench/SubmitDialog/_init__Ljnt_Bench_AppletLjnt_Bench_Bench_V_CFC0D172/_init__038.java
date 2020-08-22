package jjit.local.jnt.Bench.SubmitDialog._init__Ljnt_Bench_AppletLjnt_Bench_Bench_V_CFC0D172;
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
 * jnt.Bench.SubmitDialog
 * <init>(Ljnt/Bench/Applet;Ljnt/Bench/Bench;)V
 * [count=7] [114] PUTFIELD(jnt.Bench.SubmitDialog,cpu) [115] ALOAD(0) [116] ALOAD(0) [117] LDC(51->"OS name & version:") [118] ICONST_1(Integer{1}) [119] NEW(java.lang.StringBuffer) [120] DUP
 */
public final class _init__038 extends JJITAbstractInstruction implements Cloneable{
      private KField c_cpu = null;
      private KClassRepository c_repo;
      private KClass c_CSubmitDialog = null;
      private static KReference R51 = null;
      private static final KInteger IONE = KInteger.ONE;
      private KClass c_CStringBuffer = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
         // **REMOVED Unused Var** KReference ref;
        KRegister reg;
        KMemorySegment memseg = frame.getMemorySegment();
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[114] PUTFIELD(jnt.Bench.SubmitDialog,cpu)
        reg = frame.pop();
         // **REMOVED Substitution** ref = frame.popRef();
        c_cpu.setInstanceValue(frame.popRef(),reg);
         // *********[115] ALOAD(0)
        frame.push(this_ref);
         // *********[116] ALOAD(0)
        frame.push(this_ref);
         // *********[117] LDC(51->"OS name & version:")
        frame.push(R51);
         // *********[118] ICONST_1(Integer{1})
        frame.push(IONE);
         // *********[119] NEW(java.lang.StringBuffer)
        if(c_CStringBuffer == null){
          c_CStringBuffer = c_repo.getClassByName("java.lang.StringBuffer");
        }
        s0_ref = memseg.allocObject(c_CStringBuffer);
         // *********[120] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[114] PUTFIELD(jnt.Bench.SubmitDialog,cpu)
        c_repo = process.getClassRepository();
        c_CSubmitDialog = c_repo.getClassByName("jnt.Bench.SubmitDialog");
        c_cpu = c_CSubmitDialog.getField("cpu",true);
         // *********[115] ALOAD(0)
         // *********[116] ALOAD(0)
         // *********[117] LDC(51->"OS name & version:")
        R51 = ((KReference)constants[51]);
         // *********[118] ICONST_1(Integer{1})
         // *********[119] NEW(java.lang.StringBuffer)
        c_repo = process.getClassRepository();
         // *********[120] DUP
        c_next = instructions[(index + 1)];
      }
}
