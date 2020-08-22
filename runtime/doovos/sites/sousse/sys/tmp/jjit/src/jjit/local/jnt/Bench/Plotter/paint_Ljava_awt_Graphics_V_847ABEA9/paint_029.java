package jjit.local.jnt.Bench.Plotter.paint_Ljava_awt_Graphics_V_847ABEA9;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Plotter
 * paint(Ljava/awt/Graphics;)V
 * [count=5] [132] DLOAD(16) [133] LDC(48->"2.0") [134] DDIV [135] DSTORE(16) [136] IINC(18,-1)
 */
public final class paint_029 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** double m_d;
         // local_16 16 ; r=1/w=1 : Cached
        KRegister local_16 = frame.getLocal(16);
         // local_18 18 ; r=1/w=1 : Cached
        int local_18 = frame.getLocal(18).intValue();
         // *********[132] DLOAD(16)
         // **REMOVED Substitution** s0 = local_16;
         // *********[133] LDC(48->"2.0")
         // **REMOVED Substitution** s1 = D2_0;
         // *********[134] DDIV
         // **REMOVED Substitution** m_d = 2.0D;
         // **REMOVED Substitution** s0 = new KDouble((local_16.doubleValue() / 2.0D));
         // *********[135] DSTORE(16)
         // **REMOVED Substitution** local_16 = new KDouble((local_16.doubleValue() / 2.0D));
         // *********[136] IINC(18,-1)
         // **REMOVED Substitution** local_18 = (local_18 + -1);
        frame.setLocal(16,new KDouble((local_16.doubleValue() / 2.0D)));
        frame.setLocal(18,new KInteger((local_18 + -1)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[132] DLOAD(16)
         // *********[133] LDC(48->"2.0")
         // *********[134] DDIV
         // *********[135] DSTORE(16)
         // *********[136] IINC(18,-1)
        c_next = instructions[(index + 1)];
      }
}
