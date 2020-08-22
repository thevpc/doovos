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
 * [count=4] [381] ALOAD(0) [382] GETFIELD(jnt.Bench.Applet,chooser,Ljava/awt/Choice;) [383] LDC(105->"Show Table") [384] INVOKEVIRTUAL(java.awt.Choice,addItem(Ljava/lang/String;)V)
 */
public final class init_129 extends JJITAbstractInstruction implements Cloneable{
      private KField c_chooser = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private static KReference R105 = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KReference s0_ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[381] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[382] GETFIELD(jnt.Bench.Applet,chooser,Ljava/awt/Choice;)
         // **REMOVED Substitution** s0_ref = c_chooser.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[383] LDC(105->"Show Table")
         // **REMOVED Substitution** s1_ref = R105;
         // *********[384] INVOKEVIRTUAL(java.awt.Choice,addItem(Ljava/lang/String;)V)
        regs = new KRegister[2];
        regs[1] = R105;
        ref = c_chooser.getInstanceRef(((KReference)frame.getLocal(0)));
        regs[0] = ref;
        frame.setProgramCounter(129);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("addItem(Ljava/lang/String;)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("addItem(Ljava/lang/String;)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[381] ALOAD(0)
         // *********[382] GETFIELD(jnt.Bench.Applet,chooser,Ljava/awt/Choice;)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_chooser = c_CApplet.getField("chooser",true);
         // *********[383] LDC(105->"Show Table")
        R105 = ((KReference)constants[105]);
         // *********[384] INVOKEVIRTUAL(java.awt.Choice,addItem(Ljava/lang/String;)V)
        c_memman = process.getMemoryManager();
      }
}
