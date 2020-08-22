package jjit.local.jnt.Bench.Bench.isRunnable__Z_6C025744;
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
 * isRunnable()Z
 * [count=3] [0] ALOAD(0) [1] GETFIELD(jnt.Bench.Bench,targetClass,Ljava/lang/String;) [2] IFNULL(5)
 */
public final class isRunnable_001 extends JJITAbstractInstruction implements Cloneable{
      private KField c_targetClass = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KReference s0_ref;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[0] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[1] GETFIELD(jnt.Bench.Bench,targetClass,Ljava/lang/String;)
         // **REMOVED Substitution** s0_ref = c_targetClass.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[2] IFNULL(5)
        return ((c_targetClass.getInstanceRef(((KReference)frame.getLocal(0))).isNull())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] GETFIELD(jnt.Bench.Bench,targetClass,Ljava/lang/String;)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_targetClass = c_CBench.getField("targetClass",true);
         // *********[2] IFNULL(5)
        c_next = instructions[(index + 1)];
        c_label = instructions[2];
      }
}
