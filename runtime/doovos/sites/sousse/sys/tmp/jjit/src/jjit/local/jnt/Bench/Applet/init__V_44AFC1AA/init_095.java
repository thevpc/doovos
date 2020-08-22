package jjit.local.jnt.Bench.Applet.init__V_44AFC1AA;
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
 * jnt.Bench.Applet
 * init()V
 * [count=7] [301] POP [302] ALOAD(0) [303] NEW(java.awt.Label) [304] DUP [305] LDC(34->"") [306] ICONST_1(Integer{1}) [307] INVOKESPECIAL(java.awt.Label,<init>(Ljava/lang/String;I)V)
 */
public final class init_095 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CLabel = null;
      private static KReference R34 = null;
      private static final KInteger IONE = KInteger.ONE;
      private JJITInstruction c_next;
      private KMethod m_mth = null;
      private boolean m_mth_ignorable = false;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KReference s2_ref;
         // **REMOVED Unused Var** KRegister s3;
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KReference ref;
        JJITInstruction nextInstr;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[301] POP
        frame.pop();
         // *********[302] ALOAD(0)
        frame.push(frame.getLocal(0));
         // *********[303] NEW(java.awt.Label)
        if(c_CLabel == null){
          c_CLabel = c_repo.getClassByName("java.awt.Label");
        }
        s0_ref = memseg.allocObject(c_CLabel);
         // *********[304] DUP
        frame.push(s0_ref);
         // **REMOVED Substitution** s1_ref = s0_ref;
         // *********[305] LDC(34->"")
         // **REMOVED Substitution** s2_ref = R34;
         // *********[306] ICONST_1(Integer{1})
         // **REMOVED Substitution** s3 = IONE;
         // *********[307] INVOKESPECIAL(java.awt.Label,<init>(Ljava/lang/String;I)V)
        regs = new KRegister[3];
        if(m_mth == null){
          m_mth = c_CLabel.getMethodBySignature("<init>(Ljava/lang/String;I)V");
          m_mth_ignorable = m_mth.isIgnorable();
        }
        regs[2] = IONE;
        regs[1] = R34;
         // **REMOVED Substitution** ref = s0_ref;
        regs[0] = s0_ref;
        if(m_mth_ignorable){
          nextInstr = c_next;
        }else{
          frame.setProgramCounter(95);
           // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
          nextInstr = ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
        }
        return nextInstr;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[301] POP
         // *********[302] ALOAD(0)
         // *********[303] NEW(java.awt.Label)
        c_repo = process.getClassRepository();
         // *********[304] DUP
         // *********[305] LDC(34->"")
        R34 = ((KReference)constants[34]);
         // *********[306] ICONST_1(Integer{1})
         // *********[307] INVOKESPECIAL(java.awt.Label,<init>(Ljava/lang/String;I)V)
        c_next = instructions[(index + 1)];
      }
}
