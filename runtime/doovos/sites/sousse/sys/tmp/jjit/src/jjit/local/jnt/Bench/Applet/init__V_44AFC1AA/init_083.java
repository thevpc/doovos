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
 * [count=6] [244] POP [245] ALOAD(0) [246] NEW(java.awt.Button) [247] DUP [248] LDC(82->"ABORT") [249] INVOKESPECIAL(java.awt.Button,<init>(Ljava/lang/String;)V)
 */
public final class init_083 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CButton = null;
      private static KReference R82 = null;
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
         // *********[244] POP
        frame.pop();
         // *********[245] ALOAD(0)
        frame.push(frame.getLocal(0));
         // *********[246] NEW(java.awt.Button)
        if(c_CButton == null){
          c_CButton = c_repo.getClassByName("java.awt.Button");
        }
        s0_ref = memseg.allocObject(c_CButton);
         // *********[247] DUP
        frame.push(s0_ref);
         // **REMOVED Substitution** s1_ref = s0_ref;
         // *********[248] LDC(82->"ABORT")
         // **REMOVED Substitution** s2_ref = R82;
         // *********[249] INVOKESPECIAL(java.awt.Button,<init>(Ljava/lang/String;)V)
        regs = new KRegister[2];
        if(m_mth == null){
          m_mth = c_CButton.getMethodBySignature("<init>(Ljava/lang/String;)V");
          m_mth_ignorable = m_mth.isIgnorable();
        }
        regs[1] = R82;
         // **REMOVED Substitution** ref = s0_ref;
        regs[0] = s0_ref;
        if(m_mth_ignorable){
          nextInstr = c_next;
        }else{
          frame.setProgramCounter(83);
           // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
          nextInstr = ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
        }
        return nextInstr;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[244] POP
         // *********[245] ALOAD(0)
         // *********[246] NEW(java.awt.Button)
        c_repo = process.getClassRepository();
         // *********[247] DUP
         // *********[248] LDC(82->"ABORT")
        R82 = ((KReference)constants[82]);
         // *********[249] INVOKESPECIAL(java.awt.Button,<init>(Ljava/lang/String;)V)
        c_next = instructions[(index + 1)];
      }
}
