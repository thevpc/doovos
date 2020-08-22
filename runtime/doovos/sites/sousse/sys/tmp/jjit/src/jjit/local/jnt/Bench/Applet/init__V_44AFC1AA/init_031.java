package jjit.local.jnt.Bench.Applet.init__V_44AFC1AA;
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
 * jnt.Bench.Applet
 * init()V
 * [count=6] [54] ASTORE(6) [55] ALOAD(6) [56] NEW(java.awt.Font) [57] DUP [58] ALOAD(3) [59] INVOKEVIRTUAL(java.awt.Font,getName()Ljava/lang/String;)
 */
public final class init_031 extends JJITAbstractInstruction implements Cloneable{
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
         // local_6 6 ; r=1/w=1 : Cached
        KRegister local_6;
         // *********[54] ASTORE(6)
        local_6 = frame.pop();
         // *********[55] ALOAD(6)
        frame.push(local_6);
         // *********[56] NEW(java.awt.Font)
        if(c_CFont == null){
          c_CFont = c_repo.getClassByName("java.awt.Font");
        }
        s0_ref = memseg.allocObject(c_CFont);
         // *********[57] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[58] ALOAD(3)
         // **REMOVED Substitution** s1 = frame.getLocal(3);
         // *********[59] INVOKEVIRTUAL(java.awt.Font,getName()Ljava/lang/String;)
        regs = new KRegister[1];
        ref = ((KReference)frame.getLocal(3));
        regs[0] = ref;
        frame.setProgramCounter(31);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getName()Ljava/lang/String;"),regs);
        frame.setLocal(6,local_6);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getName()Ljava/lang/String;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[54] ASTORE(6)
         // *********[55] ALOAD(6)
         // *********[56] NEW(java.awt.Font)
        c_repo = process.getClassRepository();
         // *********[57] DUP
         // *********[58] ALOAD(3)
         // *********[59] INVOKEVIRTUAL(java.awt.Font,getName()Ljava/lang/String;)
        c_memman = process.getMemoryManager();
      }
}
