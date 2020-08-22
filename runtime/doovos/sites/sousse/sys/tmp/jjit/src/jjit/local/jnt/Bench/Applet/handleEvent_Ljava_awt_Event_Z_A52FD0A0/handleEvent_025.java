package jjit.local.jnt.Bench.Applet.handleEvent_Ljava_awt_Event_Z_A52FD0A0;
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
 * handleEvent(Ljava/awt/Event;)Z
 * [count=5] [63] ALOAD(0) [64] ILOAD(2) [65] PUTFIELD(jnt.Bench.Applet,segment) [66] ALOAD(0) [67] INVOKEVIRTUAL(jnt.Bench.Applet,doDisplay()V)
 */
public final class handleEvent_025 extends JJITAbstractInstruction implements Cloneable{
      private KField c_segment = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KRegister reg;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[63] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[64] ILOAD(2)
         // **REMOVED Substitution** s1 = frame.getLocal(2);
         // *********[65] PUTFIELD(jnt.Bench.Applet,segment)
         // **REMOVED Substitution** reg = frame.getLocal(2);
         // **REMOVED Substitution** ref = this_ref;
        c_segment.setInstanceInt(this_ref,frame.getLocal(2).intValue());
         // *********[66] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[67] INVOKEVIRTUAL(jnt.Bench.Applet,doDisplay()V)
        regs = new KRegister[1];
         // **REMOVED Substitution** ref = this_ref;
        regs[0] = this_ref;
        frame.setProgramCounter(25);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("doDisplay()V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("doDisplay()V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[63] ALOAD(0)
         // *********[64] ILOAD(2)
         // *********[65] PUTFIELD(jnt.Bench.Applet,segment)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_segment = c_CApplet.getField("segment",true);
         // *********[66] ALOAD(0)
         // *********[67] INVOKEVIRTUAL(jnt.Bench.Applet,doDisplay()V)
        c_memman = process.getMemoryManager();
      }
}
