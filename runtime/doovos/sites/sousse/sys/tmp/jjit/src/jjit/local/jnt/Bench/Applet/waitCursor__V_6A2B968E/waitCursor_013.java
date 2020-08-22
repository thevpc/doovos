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
 * [count=5] [26] PUTFIELD(jnt.Bench.Applet,cursor) [27] ALOAD(0) [28] GETFIELD(jnt.Bench.Applet,parent,Ljava/awt/Frame;) [29] ICONST_3(Integer{3}) [30] INVOKEVIRTUAL(java.awt.Frame,setCursor(I)V)
 */
public final class waitCursor_013 extends JJITAbstractInstruction implements Cloneable{
      private KField c_cursor = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private KField c_parent = null;
      private static final KInteger ITHREE = KInteger.THREE;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
        KReference ref;
        KRegister reg;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[26] PUTFIELD(jnt.Bench.Applet,cursor)
        reg = frame.pop();
         // **REMOVED Substitution** ref = frame.popRef();
        c_cursor.setInstanceInt(frame.popRef(),reg.intValue());
         // *********[27] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[28] GETFIELD(jnt.Bench.Applet,parent,Ljava/awt/Frame;)
         // **REMOVED Substitution** s0_ref = c_parent.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[29] ICONST_3(Integer{3})
         // **REMOVED Substitution** s1 = ITHREE;
         // *********[30] INVOKEVIRTUAL(java.awt.Frame,setCursor(I)V)
        regs = new KRegister[2];
        regs[1] = ITHREE;
        ref = c_parent.getInstanceRef(((KReference)frame.getLocal(0)));
        regs[0] = ref;
        frame.setProgramCounter(13);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("setCursor(I)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("setCursor(I)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[26] PUTFIELD(jnt.Bench.Applet,cursor)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_cursor = c_CApplet.getField("cursor",true);
         // *********[27] ALOAD(0)
         // *********[28] GETFIELD(jnt.Bench.Applet,parent,Ljava/awt/Frame;)
        c_parent = c_CApplet.getField("parent",true);
         // *********[29] ICONST_3(Integer{3})
         // *********[30] INVOKEVIRTUAL(java.awt.Frame,setCursor(I)V)
        c_memman = process.getMemoryManager();
      }
}
