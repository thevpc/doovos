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
 * [count=6] [24] ALOAD(0) [25] GETFIELD(jnt.Bench.Applet,table,Ljava/awt/List;) [26] ALOAD(1) [27] ILOAD(2) [28] AALOAD [29] INVOKEVIRTUAL(java.awt.List,addItem(Ljava/lang/String;)V)
 */
public final class doDisplay_014 extends JJITAbstractInstruction implements Cloneable{
      private KField c_table = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
        KReference ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[24] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[25] GETFIELD(jnt.Bench.Applet,table,Ljava/awt/List;)
         // **REMOVED Substitution** s0_ref = c_table.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[26] ALOAD(1)
         // **REMOVED Substitution** s1 = frame.getLocal(1);
         // *********[27] ILOAD(2)
         // **REMOVED Substitution** s2 = frame.getLocal(2);
         // *********[28] AALOAD
         // **REMOVED Substitution** index = frame.getLocal(2).intValue();
         // **REMOVED Substitution** ref = ((KReference)frame.getLocal(1));
         // **REMOVED Substitution** s1_ref = c_memman.getReferenceArray(((KReference)frame.getLocal(1)),frame.getLocal(2).intValue());
         // *********[29] INVOKEVIRTUAL(java.awt.List,addItem(Ljava/lang/String;)V)
        regs = new KRegister[2];
        regs[1] = c_memman.getReferenceArray(((KReference)frame.getLocal(1)),frame.getLocal(2).intValue());
        ref = c_table.getInstanceRef(((KReference)frame.getLocal(0)));
        regs[0] = ref;
        frame.setProgramCounter(14);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("addItem(Ljava/lang/String;)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("addItem(Ljava/lang/String;)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[24] ALOAD(0)
         // *********[25] GETFIELD(jnt.Bench.Applet,table,Ljava/awt/List;)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_table = c_CApplet.getField("table",true);
         // *********[26] ALOAD(1)
         // *********[27] ILOAD(2)
         // *********[28] AALOAD
        c_memman = process.getMemoryManager();
         // *********[29] INVOKEVIRTUAL(java.awt.List,addItem(Ljava/lang/String;)V)
      }
}
