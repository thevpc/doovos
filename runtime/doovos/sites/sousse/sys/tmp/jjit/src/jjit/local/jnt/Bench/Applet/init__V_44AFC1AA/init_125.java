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
 * [count=4] [366] ALOAD(6) [367] ALOAD(0) [368] GETFIELD(jnt.Bench.Applet,bench,Ljnt/Bench/Bench;) [369] INVOKEVIRTUAL(jnt.Bench.Bench,getName()Ljava/lang/String;)
 */
public final class init_125 extends JJITAbstractInstruction implements Cloneable{
      private KField c_bench = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KReference s0_ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_6 6 ; r=1/w=0 : NotCached
         // *********[366] ALOAD(6)
        frame.push(frame.getLocal(6));
         // *********[367] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[368] GETFIELD(jnt.Bench.Applet,bench,Ljnt/Bench/Bench;)
         // **REMOVED Substitution** s0_ref = c_bench.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[369] INVOKEVIRTUAL(jnt.Bench.Bench,getName()Ljava/lang/String;)
        regs = new KRegister[1];
        ref = c_bench.getInstanceRef(((KReference)frame.getLocal(0)));
        regs[0] = ref;
        frame.setProgramCounter(125);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getName()Ljava/lang/String;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getName()Ljava/lang/String;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[366] ALOAD(6)
         // *********[367] ALOAD(0)
         // *********[368] GETFIELD(jnt.Bench.Applet,bench,Ljnt/Bench/Bench;)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_bench = c_CApplet.getField("bench",true);
         // *********[369] INVOKEVIRTUAL(jnt.Bench.Bench,getName()Ljava/lang/String;)
        c_memman = process.getMemoryManager();
      }
}
