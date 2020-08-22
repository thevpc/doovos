package jjit.local.jnt.Bench.Applet.startBenchmark__V_C435FC83;
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
 * startBenchmark()V
 * [count=4] [22] PUTFIELD(jnt.Bench.Applet,thread) [23] ALOAD(0) [24] GETFIELD(jnt.Bench.Applet,thread,Ljava/lang/Thread;) [25] INVOKEVIRTUAL(java.lang.Thread,start()V)
 */
public final class startBenchmark_015 extends JJITAbstractInstruction implements Cloneable{
      private KField c_thread = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KReference s0_ref;
        KReference ref;
        KRegister reg;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[22] PUTFIELD(jnt.Bench.Applet,thread)
        reg = frame.pop();
         // **REMOVED Substitution** ref = frame.popRef();
        c_thread.setInstanceValue(frame.popRef(),reg);
         // *********[23] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[24] GETFIELD(jnt.Bench.Applet,thread,Ljava/lang/Thread;)
         // **REMOVED Substitution** s0_ref = c_thread.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[25] INVOKEVIRTUAL(java.lang.Thread,start()V)
        regs = new KRegister[1];
        ref = c_thread.getInstanceRef(((KReference)frame.getLocal(0)));
        regs[0] = ref;
        frame.setProgramCounter(15);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("start()V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("start()V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[22] PUTFIELD(jnt.Bench.Applet,thread)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_thread = c_CApplet.getField("thread",true);
         // *********[23] ALOAD(0)
         // *********[24] GETFIELD(jnt.Bench.Applet,thread,Ljava/lang/Thread;)
         // *********[25] INVOKEVIRTUAL(java.lang.Thread,start()V)
        c_memman = process.getMemoryManager();
      }
}
