package jjit.local.jnt.Bench.Applet.doDisplay__V_3302CC33;
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
 * doDisplay()V
 * [count=4] [41] ALOAD(0) [42] GETFIELD(jnt.Bench.Applet,table,Ljava/awt/List;) [43] ILOAD(3) [44] INVOKEVIRTUAL(java.awt.List,select(I)V)
 */
public final class doDisplay_019 extends JJITAbstractInstruction implements Cloneable{
      private KField c_table = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=0 : NotCached
         // *********[41] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[42] GETFIELD(jnt.Bench.Applet,table,Ljava/awt/List;)
         // **REMOVED Substitution** s0_ref = c_table.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[43] ILOAD(3)
         // **REMOVED Substitution** s1 = frame.getLocal(3);
         // *********[44] INVOKEVIRTUAL(java.awt.List,select(I)V)
        regs = new KRegister[2];
        regs[1] = frame.getLocal(3);
        ref = c_table.getInstanceRef(((KReference)frame.getLocal(0)));
        regs[0] = ref;
        frame.setProgramCounter(19);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("select(I)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("select(I)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[41] ALOAD(0)
         // *********[42] GETFIELD(jnt.Bench.Applet,table,Ljava/awt/List;)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_table = c_CApplet.getField("table",true);
         // *********[43] ILOAD(3)
         // *********[44] INVOKEVIRTUAL(java.awt.List,select(I)V)
        c_memman = process.getMemoryManager();
      }
}
