package jjit.local.jnt.Bench.Bench.parseDescriptor_Ljava_io_InputStream_V_38C1A4B9;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Bench
 * parseDescriptor(Ljava/io/InputStream;)V
 * [count=2] [86] PUTFIELD(jnt.Bench.Bench,units) [87] GOTO(128)
 */
public final class parseDescriptor_031 extends JJITAbstractInstruction implements Cloneable{
      private KField c_units = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference ref;
        KRegister reg;
         // *********[86] PUTFIELD(jnt.Bench.Bench,units)
        reg = frame.pop();
         // **REMOVED Substitution** ref = frame.popRef();
        c_units.setInstanceValue(frame.popRef(),reg);
         // *********[87] GOTO(128)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[86] PUTFIELD(jnt.Bench.Bench,units)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_units = c_CBench.getField("units",true);
         // *********[87] GOTO(128)
        c_label = instructions[52];
      }
}
