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
 * [count=3] [97] D2I [98] PUTFIELD(jnt.Bench.Bench,decimals) [99] GOTO(128)
 */
public final class parseDescriptor_035 extends JJITAbstractInstruction implements Cloneable{
      private KField c_decimals = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KReference ref;
        KRegister reg;
         // *********[97] D2I
         // **REMOVED Substitution** s0 = new KInteger(((int)frame.popDouble()));
         // *********[98] PUTFIELD(jnt.Bench.Bench,decimals)
        reg = new KInteger(((int)frame.popDouble()));
         // **REMOVED Substitution** ref = frame.popRef();
        c_decimals.setInstanceInt(frame.popRef(),reg.intValue());
         // *********[99] GOTO(128)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[97] D2I
         // *********[98] PUTFIELD(jnt.Bench.Bench,decimals)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_decimals = c_CBench.getField("decimals",true);
         // *********[99] GOTO(128)
        c_label = instructions[52];
      }
}
