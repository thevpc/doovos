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
 * [count=6] [271] POP [272] ALOAD(0) [273] NEW(java.awt.Button) [274] DUP [275] LDC(85->"Submit Results") [276] INVOKESPECIAL(java.awt.Button,<init>(Ljava/lang/String;)V)
 */
public final class init_089 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CButton = null;
      private static KReference R85 = null;
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
         // *********[271] POP
        frame.pop();
         // *********[272] ALOAD(0)
        frame.push(frame.getLocal(0));
         // *********[273] NEW(java.awt.Button)
        if(c_CButton == null){
          c_CButton = c_repo.getClassByName("java.awt.Button");
        }
        s0_ref = memseg.allocObject(c_CButton);
         // *********[274] DUP
        frame.push(s0_ref);
         // **REMOVED Substitution** s1_ref = s0_ref;
         // *********[275] LDC(85->"Submit Results")
         // **REMOVED Substitution** s2_ref = R85;
         // *********[276] INVOKESPECIAL(java.awt.Button,<init>(Ljava/lang/String;)V)
        regs = new KRegister[2];
        if(m_mth == null){
          m_mth = c_CButton.getMethodBySignature("<init>(Ljava/lang/String;)V");
          m_mth_ignorable = m_mth.isIgnorable();
        }
        regs[1] = R85;
         // **REMOVED Substitution** ref = s0_ref;
        regs[0] = s0_ref;
        if(m_mth_ignorable){
          nextInstr = c_next;
        }else{
          frame.setProgramCounter(89);
           // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
          nextInstr = ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
        }
        return nextInstr;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[271] POP
         // *********[272] ALOAD(0)
         // *********[273] NEW(java.awt.Button)
        c_repo = process.getClassRepository();
         // *********[274] DUP
         // *********[275] LDC(85->"Submit Results")
        R85 = ((KReference)constants[85]);
         // *********[276] INVOKESPECIAL(java.awt.Button,<init>(Ljava/lang/String;)V)
        c_next = instructions[(index + 1)];
      }
}
