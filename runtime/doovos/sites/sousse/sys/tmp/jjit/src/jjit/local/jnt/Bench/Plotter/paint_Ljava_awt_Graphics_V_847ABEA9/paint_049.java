package jjit.local.jnt.Bench.Plotter.paint_Ljava_awt_Graphics_V_847ABEA9;
import java.lang.Math;
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
 * [count=11] [295] DLOAD(11) [296] DLOAD(9) [297] DSUB [298] DLOAD(16) [299] DDIV [300] INVOKE_HOST(java.lang.Math.round(D)J) [301] L2I [302] ISTORE(34) [303] ICONST_0(Integer{0}) [304] ISTORE(35) [305] GOTO(325)
 */
public final class paint_049 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** double m_d;
         // **REMOVED Unused Var** double m_d2;
         // **REMOVED Unused Var** KRegister[] regs = null;
         // **REMOVED Unused Var** double m_v2;
         // local_34 34 ; r=0/w=1 : NotCached
         // local_35 35 ; r=0/w=1 : NotCached
         // local_16 16 ; r=1/w=0 : NotCached
         // local_9 9 ; r=1/w=0 : NotCached
         // local_11 11 ; r=1/w=0 : NotCached
         // *********[295] DLOAD(11)
         // **REMOVED Substitution** s0 = frame.getLocal(11);
         // *********[296] DLOAD(9)
         // **REMOVED Substitution** s1 = frame.getLocal(9);
         // *********[297] DSUB
         // **REMOVED Substitution** m_d = frame.getLocal(9).doubleValue();
         // **REMOVED Substitution** s0 = new KDouble((frame.getLocal(11).doubleValue() - frame.getLocal(9).doubleValue()));
         // *********[298] DLOAD(16)
         // **REMOVED Substitution** s1 = frame.getLocal(16);
         // *********[299] DDIV
         // **REMOVED Substitution** m_d2 = frame.getLocal(16).doubleValue();
         // **REMOVED Substitution** s0 = new KDouble(((frame.getLocal(11).doubleValue() - frame.getLocal(9).doubleValue()) / frame.getLocal(16).doubleValue()));
         // *********[300] INVOKE_HOST(java.lang.Math.round(D)J)
         // **REMOVED Substitution** m_v2 = ((frame.getLocal(11).doubleValue() - frame.getLocal(9).doubleValue()) / frame.getLocal(16).doubleValue());
         // **REMOVED Substitution** s0 = new KLong(Math.round(((frame.getLocal(11).doubleValue() - frame.getLocal(9).doubleValue()) / frame.getLocal(16).doubleValue())));
         // *********[301] L2I
         // **REMOVED Substitution** s0 = new KInteger(((int)Math.round(((frame.getLocal(11).doubleValue() - frame.getLocal(9).doubleValue()) / frame.getLocal(16).doubleValue()))));
         // *********[302] ISTORE(34)
        frame.setLocal(34,new KInteger(((int)Math.round(((frame.getLocal(11).doubleValue() - frame.getLocal(9).doubleValue()) / frame.getLocal(16).doubleValue())))));
         // *********[303] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[304] ISTORE(35)
        frame.setLocal(35,KInteger.ZERO);
         // *********[305] GOTO(325)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[295] DLOAD(11)
         // *********[296] DLOAD(9)
         // *********[297] DSUB
         // *********[298] DLOAD(16)
         // *********[299] DDIV
         // *********[300] INVOKE_HOST(java.lang.Math.round(D)J)
         // *********[301] L2I
         // *********[302] ISTORE(34)
         // *********[303] ICONST_0(Integer{0})
         // *********[304] ISTORE(35)
         // *********[305] GOTO(325)
        c_label = instructions[51];
      }
}
