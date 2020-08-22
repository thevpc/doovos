package jjit.local.jnt.Bench.Plotter.paint_Ljava_awt_Graphics_V_847ABEA9;
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
 * jnt.Bench.Plotter
 * paint(Ljava/awt/Graphics;)V
 * [count=18] [306] ILOAD(24) [307] ILOAD(35) [308] I2D [309] DLOAD(16) [310] DMUL [311] DLOAD(29) [312] DMUL [313] D2I [314] IADD [315] ISTORE(36) [316] ALOAD(1) [317] ILOAD(36) [318] ILOAD(26) [319] ILOAD(36) [320] ILOAD(26) [321] ICONST_3(Integer{3}) [322] IADD [323] INVOKEVIRTUAL(java.awt.Graphics,drawLine(IIII)V)
 */
public final class paint_050 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s5;
         // **REMOVED Unused Var** KRegister s4;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
         // **REMOVED Unused Var** double m_d;
         // **REMOVED Unused Var** double m_d2;
         // **REMOVED Unused Var** int index = 0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_1 1 ; r=1/w=0 : NotCached
         // local_16 16 ; r=1/w=0 : NotCached
         // local_35 35 ; r=1/w=0 : NotCached
         // local_36 36 ; r=2/w=1 : Cached
        int local_36;
         // local_24 24 ; r=1/w=0 : NotCached
         // local_26 26 ; r=2/w=0 : Cached
        int local_26 = frame.getLocal(26).intValue();
         // local_29 29 ; r=1/w=0 : NotCached
         // *********[306] ILOAD(24)
         // **REMOVED Substitution** s0 = frame.getLocal(24);
         // *********[307] ILOAD(35)
         // **REMOVED Substitution** s1 = frame.getLocal(35);
         // *********[308] I2D
         // **REMOVED Substitution** s1 = new KDouble(frame.getLocal(35).intValue());
         // *********[309] DLOAD(16)
         // **REMOVED Substitution** s2 = frame.getLocal(16);
         // *********[310] DMUL
         // **REMOVED Substitution** m_d = frame.getLocal(16).doubleValue();
         // **REMOVED Substitution** s1 = new KDouble((frame.getLocal(35).doubleValue() * frame.getLocal(16).doubleValue()));
         // *********[311] DLOAD(29)
         // **REMOVED Substitution** s2 = frame.getLocal(29);
         // *********[312] DMUL
         // **REMOVED Substitution** m_d2 = frame.getLocal(29).doubleValue();
         // **REMOVED Substitution** s1 = new KDouble(((frame.getLocal(35).doubleValue() * frame.getLocal(16).doubleValue()) * frame.getLocal(29).doubleValue()));
         // *********[313] D2I
         // **REMOVED Substitution** s1 = new KInteger(((int)((frame.getLocal(35).doubleValue() * frame.getLocal(16).doubleValue()) * frame.getLocal(29).doubleValue())));
         // *********[314] IADD
         // **REMOVED Substitution** index = ((int)((frame.getLocal(35).doubleValue() * frame.getLocal(16).doubleValue()) * frame.getLocal(29).doubleValue()));
         // **REMOVED Substitution** s0 = new KInteger((frame.getLocal(24).intValue() + ((int)((frame.getLocal(35).doubleValue() * frame.getLocal(16).doubleValue()) * frame.getLocal(29).doubleValue()))));
         // *********[315] ISTORE(36)
        local_36 = (frame.getLocal(24).intValue() + ((int)((frame.getLocal(35).doubleValue() * frame.getLocal(16).doubleValue()) * frame.getLocal(29).doubleValue())));
         // *********[316] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[317] ILOAD(36)
         // **REMOVED Substitution** s1 = new KInteger(local_36);
         // *********[318] ILOAD(26)
         // **REMOVED Substitution** s2 = new KInteger(local_26);
         // *********[319] ILOAD(36)
         // **REMOVED Substitution** s3 = new KInteger(local_36);
         // *********[320] ILOAD(26)
         // **REMOVED Substitution** s4 = new KInteger(local_26);
         // *********[321] ICONST_3(Integer{3})
         // **REMOVED Substitution** s5 = ITHREE;
         // *********[322] IADD
         // **REMOVED Substitution** index = 3;
         // **REMOVED Substitution** s4 = new KInteger((local_26 + 3));
         // *********[323] INVOKEVIRTUAL(java.awt.Graphics,drawLine(IIII)V)
        regs = new KRegister[5];
        regs[4] = new KInteger((local_26 + 3));
        regs[3] = new KInteger(local_36);
        regs[2] = new KInteger(local_26);
        regs[1] = new KInteger(local_36);
        ref = ((KReference)frame.getLocal(1));
        regs[0] = ref;
        frame.setProgramCounter(50);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("drawLine(IIII)V"),regs);
        frame.setLocal(36,new KInteger(local_36));
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("drawLine(IIII)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[306] ILOAD(24)
         // *********[307] ILOAD(35)
         // *********[308] I2D
         // *********[309] DLOAD(16)
         // *********[310] DMUL
         // *********[311] DLOAD(29)
         // *********[312] DMUL
         // *********[313] D2I
         // *********[314] IADD
         // *********[315] ISTORE(36)
         // *********[316] ALOAD(1)
         // *********[317] ILOAD(36)
         // *********[318] ILOAD(26)
         // *********[319] ILOAD(36)
         // *********[320] ILOAD(26)
         // *********[321] ICONST_3(Integer{3})
         // *********[322] IADD
         // *********[323] INVOKEVIRTUAL(java.awt.Graphics,drawLine(IIII)V)
        c_memman = process.getMemoryManager();
      }
}
