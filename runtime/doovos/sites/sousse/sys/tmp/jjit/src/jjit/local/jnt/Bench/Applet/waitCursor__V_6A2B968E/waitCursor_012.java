package jjit.local.jnt.Bench.Applet.waitCursor__V_6A2B968E;
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
 * waitCursor()V
 * [count=4] [22] ALOAD(0) [23] ALOAD(0) [24] GETFIELD(jnt.Bench.Applet,parent,Ljava/awt/Frame;) [25] INVOKEVIRTUAL(java.awt.Frame,getCursorType()I)
 */
public final class waitCursor_012 extends JJITAbstractInstruction implements Cloneable{
      private KField c_parent = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s0_ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[22] ALOAD(0)
        frame.push(this_ref);
         // *********[23] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[24] GETFIELD(jnt.Bench.Applet,parent,Ljava/awt/Frame;)
         // **REMOVED Substitution** s0_ref = c_parent.getInstanceRef(this_ref);
         // *********[25] INVOKEVIRTUAL(java.awt.Frame,getCursorType()I)
        regs = new KRegister[1];
        ref = c_parent.getInstanceRef(this_ref);
        regs[0] = ref;
        frame.setProgramCounter(12);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getCursorType()I"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getCursorType()I"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[22] ALOAD(0)
         // *********[23] ALOAD(0)
         // *********[24] GETFIELD(jnt.Bench.Applet,parent,Ljava/awt/Frame;)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_parent = c_CApplet.getField("parent",true);
         // *********[25] INVOKEVIRTUAL(java.awt.Frame,getCursorType()I)
        c_memman = process.getMemoryManager();
      }
}
