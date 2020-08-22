package jjit.local.jnt.Bench.Applet.init__V_44AFC1AA;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
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
 * [count=3] [60] ICONST_1(Integer{1}) [61] ALOAD(3) [62] INVOKEVIRTUAL(java.awt.Font,getSize()I)
 */
public final class init_032 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger IONE = KInteger.ONE;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_3 3 ; r=1/w=0 : NotCached
         // *********[60] ICONST_1(Integer{1})
        frame.push(IONE);
         // *********[61] ALOAD(3)
         // **REMOVED Substitution** s0 = frame.getLocal(3);
         // *********[62] INVOKEVIRTUAL(java.awt.Font,getSize()I)
        regs = new KRegister[1];
        ref = ((KReference)frame.getLocal(3));
        regs[0] = ref;
        frame.setProgramCounter(32);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getSize()I"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getSize()I"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[60] ICONST_1(Integer{1})
         // *********[61] ALOAD(3)
         // *********[62] INVOKEVIRTUAL(java.awt.Font,getSize()I)
        c_memman = process.getMemoryManager();
      }
}
