package jjit.local.jnt.Bench.SubmitDialog._init__Ljnt_Bench_AppletLjnt_Bench_Bench_V_CFC0D172;
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
 * jnt.Bench.SubmitDialog
 * <init>(Ljnt/Bench/Applet;Ljnt/Bench/Bench;)V
 * [count=6] [205] POP [206] ALOAD(0) [207] NEW(java.awt.Label) [208] DUP [209] LDC(41->"") [210] INVOKESPECIAL(java.awt.Label,<init>(Ljava/lang/String;)V)
 */
public final class _init__065 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CLabel = null;
      private static KReference R41 = null;
      private JJITInstruction c_next;
      private KMethod m_mth = null;
      private boolean m_mth_ignorable = false;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KReference s2_ref;
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KReference ref;
        JJITInstruction nextInstr;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[205] POP
        frame.pop();
         // *********[206] ALOAD(0)
        frame.push(frame.getLocal(0));
         // *********[207] NEW(java.awt.Label)
        if(c_CLabel == null){
          c_CLabel = c_repo.getClassByName("java.awt.Label");
        }
        s0_ref = memseg.allocObject(c_CLabel);
         // *********[208] DUP
        frame.push(s0_ref);
         // **REMOVED Substitution** s1_ref = s0_ref;
         // *********[209] LDC(41->"")
         // **REMOVED Substitution** s2_ref = R41;
         // *********[210] INVOKESPECIAL(java.awt.Label,<init>(Ljava/lang/String;)V)
        regs = new KRegister[2];
        if(m_mth == null){
          m_mth = c_CLabel.getMethodBySignature("<init>(Ljava/lang/String;)V");
          m_mth_ignorable = m_mth.isIgnorable();
        }
        regs[1] = R41;
         // **REMOVED Substitution** ref = s0_ref;
        regs[0] = s0_ref;
        if(m_mth_ignorable){
          nextInstr = c_next;
        }else{
          frame.setProgramCounter(65);
           // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
          nextInstr = ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
        }
        return nextInstr;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[205] POP
         // *********[206] ALOAD(0)
         // *********[207] NEW(java.awt.Label)
        c_repo = process.getClassRepository();
         // *********[208] DUP
         // *********[209] LDC(41->"")
        R41 = ((KReference)constants[41]);
         // *********[210] INVOKESPECIAL(java.awt.Label,<init>(Ljava/lang/String;)V)
        c_next = instructions[(index + 1)];
      }
}
