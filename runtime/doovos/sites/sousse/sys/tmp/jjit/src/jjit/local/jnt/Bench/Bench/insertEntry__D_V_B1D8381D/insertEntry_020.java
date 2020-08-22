package jjit.local.jnt.Bench.Bench.insertEntry__D_V_B1D8381D;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
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
 * insertEntry([D)V
 * [count=7] [76] ALOAD(0) [77] GETFIELD(jnt.Bench.Bench,entries,Ljava/util/Vector;) [78] NEW(jnt.Bench.Entry) [79] DUP [80] LDC(115->">>Your Computer<<") [81] ALOAD(1) [82] INVOKESPECIAL(jnt.Bench.Entry,<init>(Ljava/lang/String;[D)V)
 */
public final class insertEntry_020 extends JJITAbstractInstruction implements Cloneable{
      private KField c_entries = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private KClass c_CEntry = null;
      private static KReference R115 = null;
      private JJITInstruction c_next;
      private KMethod m_mth = null;
      private boolean m_mth_ignorable = false;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KReference s2_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s3;
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KReference ref;
        JJITInstruction nextInstr;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[76] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[77] GETFIELD(jnt.Bench.Bench,entries,Ljava/util/Vector;)
        frame.push(c_entries.getInstanceRef(((KReference)frame.getLocal(0))));
         // *********[78] NEW(jnt.Bench.Entry)
        if(c_CEntry == null){
          c_CEntry = c_repo.getClassByName("jnt.Bench.Entry");
        }
        s0_ref = memseg.allocObject(c_CEntry);
         // *********[79] DUP
        frame.push(s0_ref);
         // **REMOVED Substitution** s1_ref = s0_ref;
         // *********[80] LDC(115->">>Your Computer<<")
         // **REMOVED Substitution** s2_ref = R115;
         // *********[81] ALOAD(1)
         // **REMOVED Substitution** s3 = frame.getLocal(1);
         // *********[82] INVOKESPECIAL(jnt.Bench.Entry,<init>(Ljava/lang/String;[D)V)
        regs = new KRegister[3];
        if(m_mth == null){
          m_mth = c_CEntry.getMethodBySignature("<init>(Ljava/lang/String;[D)V");
          m_mth_ignorable = m_mth.isIgnorable();
        }
        regs[2] = frame.getLocal(1);
        regs[1] = R115;
         // **REMOVED Substitution** ref = s0_ref;
        regs[0] = s0_ref;
        if(m_mth_ignorable){
          nextInstr = c_next;
        }else{
          frame.setProgramCounter(20);
           // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
          nextInstr = ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
        }
        return nextInstr;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[76] ALOAD(0)
         // *********[77] GETFIELD(jnt.Bench.Bench,entries,Ljava/util/Vector;)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_entries = c_CBench.getField("entries",true);
         // *********[78] NEW(jnt.Bench.Entry)
        c_repo = process.getClassRepository();
         // *********[79] DUP
         // *********[80] LDC(115->">>Your Computer<<")
        R115 = ((KReference)constants[115]);
         // *********[81] ALOAD(1)
         // *********[82] INVOKESPECIAL(jnt.Bench.Entry,<init>(Ljava/lang/String;[D)V)
        c_next = instructions[(index + 1)];
      }
}
