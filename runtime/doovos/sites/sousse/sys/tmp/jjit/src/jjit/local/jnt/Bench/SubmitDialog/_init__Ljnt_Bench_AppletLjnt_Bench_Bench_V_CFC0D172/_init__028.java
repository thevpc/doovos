package jjit.local.jnt.Bench.SubmitDialog._init__Ljnt_Bench_AppletLjnt_Bench_Bench_V_CFC0D172;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.SubmitDialog
 * <init>(Ljnt/Bench/Applet;Ljnt/Bench/Bench;)V
 * [count=6] [48] ASTORE(4) [49] ALOAD(4) [50] NEW(java.awt.Font) [51] DUP [52] ALOAD(3) [53] INVOKEVIRTUAL(java.awt.Font,getName()Ljava/lang/String;)
 */
public final class _init__028 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CFont = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s1;
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_3 3 ; r=1/w=0 : NotCached
         // local_4 4 ; r=1/w=1 : Cached
        KRegister local_4;
         // *********[48] ASTORE(4)
        local_4 = frame.pop();
         // *********[49] ALOAD(4)
        frame.push(local_4);
         // *********[50] NEW(java.awt.Font)
        if(c_CFont == null){
          c_CFont = c_repo.getClassByName("java.awt.Font");
        }
        s0_ref = memseg.allocObject(c_CFont);
         // *********[51] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[52] ALOAD(3)
         // **REMOVED Substitution** s1 = frame.getLocal(3);
         // *********[53] INVOKEVIRTUAL(java.awt.Font,getName()Ljava/lang/String;)
        regs = new KRegister[1];
        ref = ((KReference)frame.getLocal(3));
        regs[0] = ref;
        frame.setProgramCounter(28);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getName()Ljava/lang/String;"),regs);
        frame.setLocal(4,local_4);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getName()Ljava/lang/String;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[48] ASTORE(4)
         // *********[49] ALOAD(4)
         // *********[50] NEW(java.awt.Font)
        c_repo = process.getClassRepository();
         // *********[51] DUP
         // *********[52] ALOAD(3)
         // *********[53] INVOKEVIRTUAL(java.awt.Font,getName()Ljava/lang/String;)
        c_memman = process.getMemoryManager();
      }
}
