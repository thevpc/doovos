package jjit.local.jnt.Bench.Applet.init__V_44AFC1AA;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Applet
 * init()V
 * [count=7] [308] PUTFIELD(jnt.Bench.Applet,status) [309] ALOAD(0) [310] GETFIELD(jnt.Bench.Applet,status,Ljava/awt/Label;) [311] NEW(java.awt.Font) [312] DUP [313] ALOAD(3) [314] INVOKEVIRTUAL(java.awt.Font,getName()Ljava/lang/String;)
 */
public final class init_096 extends JJITAbstractInstruction implements Cloneable{
      private KField c_status = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private KClass c_CFont = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
        KReference s0_ref;
        KReference ref;
        KRegister reg;
        KMemorySegment memseg = frame.getMemorySegment();
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=0 : NotCached
         // *********[308] PUTFIELD(jnt.Bench.Applet,status)
        reg = frame.pop();
         // **REMOVED Substitution** ref = frame.popRef();
        c_status.setInstanceValue(frame.popRef(),reg);
         // *********[309] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[310] GETFIELD(jnt.Bench.Applet,status,Ljava/awt/Label;)
        frame.push(c_status.getInstanceRef(((KReference)frame.getLocal(0))));
         // *********[311] NEW(java.awt.Font)
        if(c_CFont == null){
          c_CFont = c_repo.getClassByName("java.awt.Font");
        }
        s0_ref = memseg.allocObject(c_CFont);
         // *********[312] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[313] ALOAD(3)
         // **REMOVED Substitution** s1 = frame.getLocal(3);
         // *********[314] INVOKEVIRTUAL(java.awt.Font,getName()Ljava/lang/String;)
        regs = new KRegister[1];
        ref = ((KReference)frame.getLocal(3));
        regs[0] = ref;
        frame.setProgramCounter(96);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getName()Ljava/lang/String;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getName()Ljava/lang/String;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[308] PUTFIELD(jnt.Bench.Applet,status)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_status = c_CApplet.getField("status",true);
         // *********[309] ALOAD(0)
         // *********[310] GETFIELD(jnt.Bench.Applet,status,Ljava/awt/Label;)
         // *********[311] NEW(java.awt.Font)
        c_repo = process.getClassRepository();
         // *********[312] DUP
         // *********[313] ALOAD(3)
         // *********[314] INVOKEVIRTUAL(java.awt.Font,getName()Ljava/lang/String;)
        c_memman = process.getMemoryManager();
      }
}
