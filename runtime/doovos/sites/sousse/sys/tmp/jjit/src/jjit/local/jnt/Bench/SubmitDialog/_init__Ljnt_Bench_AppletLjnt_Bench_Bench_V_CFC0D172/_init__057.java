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
 * [count=5] [161] PUTFIELD(jnt.Bench.SubmitDialog,comments) [162] ALOAD(0) [163] NEW(java.awt.Button) [164] DUP [165] LDC(67->"Send")
 */
public final class _init__057 extends JJITAbstractInstruction implements Cloneable{
      private KField c_comments = null;
      private KClassRepository c_repo;
      private KClass c_CSubmitDialog = null;
      private KClass c_CButton = null;
      private static KReference R67 = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
         // **REMOVED Unused Var** KReference ref;
        KRegister reg;
        KMemorySegment memseg = frame.getMemorySegment();
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[161] PUTFIELD(jnt.Bench.SubmitDialog,comments)
        reg = frame.pop();
         // **REMOVED Substitution** ref = frame.popRef();
        c_comments.setInstanceValue(frame.popRef(),reg);
         // *********[162] ALOAD(0)
        frame.push(frame.getLocal(0));
         // *********[163] NEW(java.awt.Button)
        if(c_CButton == null){
          c_CButton = c_repo.getClassByName("java.awt.Button");
        }
        s0_ref = memseg.allocObject(c_CButton);
         // *********[164] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[165] LDC(67->"Send")
        frame.push(R67);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[161] PUTFIELD(jnt.Bench.SubmitDialog,comments)
        c_repo = process.getClassRepository();
        c_CSubmitDialog = c_repo.getClassByName("jnt.Bench.SubmitDialog");
        c_comments = c_CSubmitDialog.getField("comments",true);
         // *********[162] ALOAD(0)
         // *********[163] NEW(java.awt.Button)
        c_repo = process.getClassRepository();
         // *********[164] DUP
         // *********[165] LDC(67->"Send")
        R67 = ((KReference)constants[67]);
        c_next = instructions[(index + 1)];
      }
}
