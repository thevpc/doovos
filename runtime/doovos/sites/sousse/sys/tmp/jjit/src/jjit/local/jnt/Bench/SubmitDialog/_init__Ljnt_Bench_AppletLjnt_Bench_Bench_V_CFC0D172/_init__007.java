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
 * [count=4] [7] PUTFIELD(jnt.Bench.SubmitDialog,layout) [8] ALOAD(0) [9] NEW(java.awt.GridBagConstraints) [10] DUP
 */
public final class _init__007 extends JJITAbstractInstruction implements Cloneable{
      private KField c_layout = null;
      private KClassRepository c_repo;
      private KClass c_CSubmitDialog = null;
      private KClass c_CGridBagConstraints = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
         // **REMOVED Unused Var** KReference ref;
        KRegister reg;
        KMemorySegment memseg = frame.getMemorySegment();
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[7] PUTFIELD(jnt.Bench.SubmitDialog,layout)
        reg = frame.pop();
         // **REMOVED Substitution** ref = frame.popRef();
        c_layout.setInstanceValue(frame.popRef(),reg);
         // *********[8] ALOAD(0)
        frame.push(frame.getLocal(0));
         // *********[9] NEW(java.awt.GridBagConstraints)
        if(c_CGridBagConstraints == null){
          c_CGridBagConstraints = c_repo.getClassByName("java.awt.GridBagConstraints");
        }
        s0_ref = memseg.allocObject(c_CGridBagConstraints);
         // *********[10] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[7] PUTFIELD(jnt.Bench.SubmitDialog,layout)
        c_repo = process.getClassRepository();
        c_CSubmitDialog = c_repo.getClassByName("jnt.Bench.SubmitDialog");
        c_layout = c_CSubmitDialog.getField("layout",true);
         // *********[8] ALOAD(0)
         // *********[9] NEW(java.awt.GridBagConstraints)
        c_repo = process.getClassRepository();
         // *********[10] DUP
        c_next = instructions[(index + 1)];
      }
}
