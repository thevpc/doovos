package jjit.local.jnt.Bench.Bench.parseEntries_Ljava_io_StreamTokenizer_V_6B9C6DF2;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Bench
 * parseEntries(Ljava/io/StreamTokenizer;)V
 * [count=2] [24] ALOAD(5) [25] INVOKESPECIAL(jnt.Bench.Entry,<init>(Ljava/lang/String;[D)V)
 */
public final class parseEntries_005 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private KClassRepository c_repo;
      private KClass c_CEntry = null;
      private KMethod m_mth = null;
      private boolean m_mth_ignorable = false;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KReference ref;
        JJITInstruction nextInstr;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_5 5 ; r=1/w=0 : NotCached
         // *********[24] ALOAD(5)
         // **REMOVED Substitution** s0 = frame.getLocal(5);
         // *********[25] INVOKESPECIAL(jnt.Bench.Entry,<init>(Ljava/lang/String;[D)V)
        regs = new KRegister[3];
        if(c_CEntry == null){
          c_CEntry = c_repo.getClassByName("jnt.Bench.Entry");
        }
        if(m_mth == null){
          m_mth = c_CEntry.getMethodBySignature("<init>(Ljava/lang/String;[D)V");
          m_mth_ignorable = m_mth.isIgnorable();
        }
        regs[2] = frame.getLocal(5);
        regs[1] = frame.pop();
         // **REMOVED Substitution** ref = frame.popRef();
        regs[0] = frame.popRef();
        if(m_mth_ignorable){
          nextInstr = c_next;
        }else{
          frame.setProgramCounter(5);
           // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
          nextInstr = ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
        }
        return nextInstr;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[24] ALOAD(5)
         // *********[25] INVOKESPECIAL(jnt.Bench.Entry,<init>(Ljava/lang/String;[D)V)
        c_next = instructions[(index + 1)];
        c_repo = process.getClassRepository();
      }
}
