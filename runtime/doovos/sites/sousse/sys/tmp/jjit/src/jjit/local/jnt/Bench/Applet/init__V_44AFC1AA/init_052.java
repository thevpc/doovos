package jjit.local.jnt.Bench.Applet.init__V_44AFC1AA;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Applet
 * init()V
 * [count=3] [134] DUP_X1 [135] PUTFIELD(jnt.Bench.Applet,flipper) [136] INVOKEVIRTUAL(java.awt.Container,setLayout(Ljava/awt/LayoutManager;)V)
 */
public final class init_052 extends JJITAbstractInstruction implements Cloneable{
      private KField c_flipper = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
        KRegister m_r;
         // **REMOVED Unused Var** KRegister m_r2;
        KReference ref;
         // **REMOVED Unused Var** KRegister reg;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // *********[134] DUP_X1
        m_r = frame.pop();
         // **REMOVED Substitution** m_r2 = frame.pop();
         // **REMOVED Substitution** s0 = m_r;
         // **REMOVED Substitution** s1 = frame.pop();
         // **REMOVED Substitution** s2 = m_r;
         // *********[135] PUTFIELD(jnt.Bench.Applet,flipper)
         // **REMOVED Substitution** reg = m_r;
         // **REMOVED Substitution** ref = ((KReference)frame.pop());
        c_flipper.setInstanceValue(((KReference)frame.pop()),m_r);
         // *********[136] INVOKEVIRTUAL(java.awt.Container,setLayout(Ljava/awt/LayoutManager;)V)
        regs = new KRegister[2];
        regs[1] = m_r;
        ref = frame.popRef();
        regs[0] = ref;
        frame.setProgramCounter(52);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("setLayout(Ljava/awt/LayoutManager;)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("setLayout(Ljava/awt/LayoutManager;)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[134] DUP_X1
         // *********[135] PUTFIELD(jnt.Bench.Applet,flipper)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_flipper = c_CApplet.getField("flipper",true);
         // *********[136] INVOKEVIRTUAL(java.awt.Container,setLayout(Ljava/awt/LayoutManager;)V)
        c_memman = process.getMemoryManager();
      }
}
