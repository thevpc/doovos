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
 * [count=3] [155] DUP_X1 [156] PUTFIELD(jnt.Bench.Applet,table) [157] INVOKEVIRTUAL(java.awt.Container,add(Ljava/lang/String;Ljava/awt/Component;)Ljava/awt/Component;)
 */
public final class init_060 extends JJITAbstractInstruction implements Cloneable{
      private KField c_table = null;
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
         // *********[155] DUP_X1
        m_r = frame.pop();
         // **REMOVED Substitution** m_r2 = frame.pop();
         // **REMOVED Substitution** s0 = m_r;
         // **REMOVED Substitution** s1 = frame.pop();
         // **REMOVED Substitution** s2 = m_r;
         // *********[156] PUTFIELD(jnt.Bench.Applet,table)
         // **REMOVED Substitution** reg = m_r;
         // **REMOVED Substitution** ref = ((KReference)frame.pop());
        c_table.setInstanceValue(((KReference)frame.pop()),m_r);
         // *********[157] INVOKEVIRTUAL(java.awt.Container,add(Ljava/lang/String;Ljava/awt/Component;)Ljava/awt/Component;)
        regs = new KRegister[3];
        regs[2] = m_r;
        regs[1] = frame.pop();
        ref = frame.popRef();
        regs[0] = ref;
        frame.setProgramCounter(60);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("add(Ljava/lang/String;Ljava/awt/Component;)Ljava/awt/Component;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("add(Ljava/lang/String;Ljava/awt/Component;)Ljava/awt/Component;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[155] DUP_X1
         // *********[156] PUTFIELD(jnt.Bench.Applet,table)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_table = c_CApplet.getField("table",true);
         // *********[157] INVOKEVIRTUAL(java.awt.Container,add(Ljava/lang/String;Ljava/awt/Component;)Ljava/awt/Component;)
        c_memman = process.getMemoryManager();
      }
}
