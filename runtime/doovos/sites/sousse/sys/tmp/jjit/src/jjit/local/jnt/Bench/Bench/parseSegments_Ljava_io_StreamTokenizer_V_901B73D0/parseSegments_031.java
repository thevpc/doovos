package jjit.local.jnt.Bench.Bench.parseSegments_Ljava_io_StreamTokenizer_V_901B73D0;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Bench
 * parseSegments(Ljava/io/StreamTokenizer;)V
 * [count=8] [95] ALOAD(2) [96] NEW(jnt.Bench.Segment) [97] DUP [98] ALOAD(4) [99] ALOAD(6) [100] ALOAD(5) [101] ILOAD(7) [102] INVOKESPECIAL(jnt.Bench.Segment,<init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V)
 */
public final class parseSegments_031 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CSegment = null;
      private JJITInstruction c_next;
      private KMethod m_mth = null;
      private boolean m_mth_ignorable = false;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s5;
         // **REMOVED Unused Var** KRegister s4;
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KReference ref;
        JJITInstruction nextInstr;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_2 2 ; r=1/w=0 : NotCached
         // local_4 4 ; r=1/w=0 : NotCached
         // local_5 5 ; r=1/w=0 : NotCached
         // local_6 6 ; r=1/w=0 : NotCached
         // local_7 7 ; r=1/w=0 : NotCached
         // *********[95] ALOAD(2)
        frame.push(frame.getLocal(2));
         // *********[96] NEW(jnt.Bench.Segment)
        if(c_CSegment == null){
          c_CSegment = c_repo.getClassByName("jnt.Bench.Segment");
        }
        s0_ref = memseg.allocObject(c_CSegment);
         // *********[97] DUP
        frame.push(s0_ref);
         // **REMOVED Substitution** s1_ref = s0_ref;
         // *********[98] ALOAD(4)
         // **REMOVED Substitution** s2 = frame.getLocal(4);
         // *********[99] ALOAD(6)
         // **REMOVED Substitution** s3 = frame.getLocal(6);
         // *********[100] ALOAD(5)
         // **REMOVED Substitution** s4 = frame.getLocal(5);
         // *********[101] ILOAD(7)
         // **REMOVED Substitution** s5 = frame.getLocal(7);
         // *********[102] INVOKESPECIAL(jnt.Bench.Segment,<init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V)
        regs = new KRegister[5];
        if(m_mth == null){
          m_mth = c_CSegment.getMethodBySignature("<init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V");
          m_mth_ignorable = m_mth.isIgnorable();
        }
        regs[4] = frame.getLocal(7);
        regs[3] = frame.getLocal(5);
        regs[2] = frame.getLocal(6);
        regs[1] = frame.getLocal(4);
         // **REMOVED Substitution** ref = s0_ref;
        regs[0] = s0_ref;
        if(m_mth_ignorable){
          nextInstr = c_next;
        }else{
          frame.setProgramCounter(31);
           // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
          nextInstr = ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
        }
        return nextInstr;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[95] ALOAD(2)
         // *********[96] NEW(jnt.Bench.Segment)
        c_repo = process.getClassRepository();
         // *********[97] DUP
         // *********[98] ALOAD(4)
         // *********[99] ALOAD(6)
         // *********[100] ALOAD(5)
         // *********[101] ILOAD(7)
         // *********[102] INVOKESPECIAL(jnt.Bench.Segment,<init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V)
        c_next = instructions[(index + 1)];
      }
}
