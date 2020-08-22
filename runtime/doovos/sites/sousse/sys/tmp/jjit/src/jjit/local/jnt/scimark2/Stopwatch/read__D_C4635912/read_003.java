package jjit.local.jnt.scimark2.Stopwatch.read__D_C4635912;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.Stopwatch
 * read()D
 * [count=7] [7] ALOAD(0) [8] GETFIELD(jnt.scimark2.Stopwatch,last_time,D) [9] DSUB [10] DADD [11] PUTFIELD(jnt.scimark2.Stopwatch,total) [12] ALOAD(0) [13] INVOKESTATIC(jnt.scimark2.Stopwatch,seconds()D)
 */
public final class read_003 extends JJITAbstractInstruction implements Cloneable{
      private KField c_last_time = null;
      private KClassRepository c_repo;
      private KClass c_CStopwatch = null;
      private KField c_total = null;
      private KMethod m_mth2 = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** double m_d;
        double m_d2;
         // **REMOVED Unused Var** KReference ref;
        KRegister reg;
         // **REMOVED Unused Var** KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[7] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[8] GETFIELD(jnt.scimark2.Stopwatch,last_time,D)
         // **REMOVED Substitution** s0 = new KDouble(c_last_time.getInstanceDouble(this_ref));
         // *********[9] DSUB
         // **REMOVED Substitution** m_d = c_last_time.getInstanceDouble(this_ref);
         // **REMOVED Substitution** s0 = new KDouble((frame.popDouble() - c_last_time.getInstanceDouble(this_ref)));
         // *********[10] DADD
        m_d2 = (frame.popDouble() - c_last_time.getInstanceDouble(this_ref));
         // **REMOVED Substitution** s0 = new KDouble((frame.popDouble() + m_d2));
         // *********[11] PUTFIELD(jnt.scimark2.Stopwatch,total)
        reg = new KDouble((frame.popDouble() + m_d2));
         // **REMOVED Substitution** ref = frame.popRef();
        c_total.setInstanceValue(frame.popRef(),reg);
         // *********[12] ALOAD(0)
        frame.push(this_ref);
         // *********[13] INVOKESTATIC(jnt.scimark2.Stopwatch,seconds()D)
         // **REMOVED Substitution** regs = KRegister.EMPTY_ARRAY;
        if(m_mth2 == null){
          m_mth2 = c_CStopwatch.getMethodBySignature("seconds()D");
        }
        frame.setProgramCounter(3);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth2,KRegister.EMPTY_ARRAY);
        return ((JJITInstruction)thread.pushFrame(m_mth2,KRegister.EMPTY_ARRAY).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[7] ALOAD(0)
         // *********[8] GETFIELD(jnt.scimark2.Stopwatch,last_time,D)
        c_repo = process.getClassRepository();
        c_CStopwatch = c_repo.getClassByName("jnt.scimark2.Stopwatch");
        c_last_time = c_CStopwatch.getField("last_time",true);
         // *********[9] DSUB
         // *********[10] DADD
         // *********[11] PUTFIELD(jnt.scimark2.Stopwatch,total)
        c_total = c_CStopwatch.getField("total",true);
         // *********[12] ALOAD(0)
         // *********[13] INVOKESTATIC(jnt.scimark2.Stopwatch,seconds()D)
      }
}
