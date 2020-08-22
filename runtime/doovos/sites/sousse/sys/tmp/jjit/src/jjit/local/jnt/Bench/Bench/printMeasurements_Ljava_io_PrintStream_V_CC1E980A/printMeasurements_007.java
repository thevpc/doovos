package jjit.local.jnt.Bench.Bench.printMeasurements_Ljava_io_PrintStream_V_CC1E980A;
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
 * printMeasurements(Ljava/io/PrintStream;)V
 * [count=4] [27] ALOAD(2) [28] ALOAD(0) [29] GETFIELD(jnt.Bench.Bench,current,[D) [30] ILOAD(3)
 */
public final class printMeasurements_007 extends JJITAbstractInstruction implements Cloneable{
      private KField c_current = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=0 : NotCached
         // *********[27] ALOAD(2)
        frame.push(frame.getLocal(2));
         // *********[28] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[29] GETFIELD(jnt.Bench.Bench,current,[D)
        frame.push(c_current.getInstanceRef(((KReference)frame.getLocal(0))));
         // *********[30] ILOAD(3)
        frame.push(frame.getLocal(3));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[27] ALOAD(2)
         // *********[28] ALOAD(0)
         // *********[29] GETFIELD(jnt.Bench.Bench,current,[D)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_current = c_CBench.getField("current",true);
         // *********[30] ILOAD(3)
        c_next = instructions[(index + 1)];
      }
}
