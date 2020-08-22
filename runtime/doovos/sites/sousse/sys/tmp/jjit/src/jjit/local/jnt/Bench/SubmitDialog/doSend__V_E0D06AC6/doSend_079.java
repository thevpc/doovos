package jjit.local.jnt.Bench.SubmitDialog.doSend__V_E0D06AC6;
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
 * jnt.Bench.SubmitDialog
 * doSend()V
 * [count=5] [107] ALOAD(0) [108] GETFIELD(jnt.Bench.SubmitDialog,applet,Ljnt/Bench/Applet;) [109] ICONST_0(Integer{0}) [110] ALOAD(2) [111] INVOKEVIRTUAL(java.lang.Throwable,toString()Ljava/lang/String;)
 */
public final class doSend_079 extends JJITAbstractInstruction implements Cloneable{
      private KField c_applet = null;
      private KClassRepository c_repo;
      private KClass c_CSubmitDialog = null;
      private static final KInteger IZERO = KInteger.ZERO;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[107] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[108] GETFIELD(jnt.Bench.SubmitDialog,applet,Ljnt/Bench/Applet;)
        frame.push(c_applet.getInstanceRef(((KReference)frame.getLocal(0))));
         // *********[109] ICONST_0(Integer{0})
        frame.push(IZERO);
         // *********[110] ALOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[111] INVOKEVIRTUAL(java.lang.Throwable,toString()Ljava/lang/String;)
        regs = new KRegister[1];
        ref = ((KReference)frame.getLocal(2));
        regs[0] = ref;
        frame.setProgramCounter(79);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("toString()Ljava/lang/String;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("toString()Ljava/lang/String;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[107] ALOAD(0)
         // *********[108] GETFIELD(jnt.Bench.SubmitDialog,applet,Ljnt/Bench/Applet;)
        c_repo = process.getClassRepository();
        c_CSubmitDialog = c_repo.getClassByName("jnt.Bench.SubmitDialog");
        c_applet = c_CSubmitDialog.getField("applet",true);
         // *********[109] ICONST_0(Integer{0})
         // *********[110] ALOAD(2)
         // *********[111] INVOKEVIRTUAL(java.lang.Throwable,toString()Ljava/lang/String;)
        c_memman = process.getMemoryManager();
      }
}
