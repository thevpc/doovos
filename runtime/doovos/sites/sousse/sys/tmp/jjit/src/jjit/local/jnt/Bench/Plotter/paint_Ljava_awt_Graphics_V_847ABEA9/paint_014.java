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
 * [count=10] [28] ISTORE(7) [29] ICONST_0(Integer{0}) [30] ISTORE(8) [31] DCONST_0(Double{0.0}) [32] DSTORE(9) [33] LDC(40->"-1.7976931348623157E308") [34] DSTORE(11) [35] ICONST_0(Integer{0}) [36] ISTORE(13) [37] GOTO(75)
 */
public final class paint_014 extends JJITAbstractInstruction implements Cloneable{
      private static final KDouble DZERO = KDouble.ZERO;
      private static final KDouble DM1_7976931348623157E308 = new KDouble(-1.7976931348623157E308D);
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_7 7 ; r=0/w=1 : NotCached
         // local_8 8 ; r=0/w=1 : NotCached
         // local_9 9 ; r=0/w=1 : NotCached
         // local_11 11 ; r=0/w=1 : NotCached
         // local_13 13 ; r=0/w=1 : NotCached
         // *********[28] ISTORE(7)
        frame.setLocal(7,new KInteger(frame.popInt()));
         // *********[29] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[30] ISTORE(8)
        frame.setLocal(8,KInteger.ZERO);
         // *********[31] DCONST_0(Double{0.0})
         // **REMOVED Substitution** s0 = DZERO;
         // *********[32] DSTORE(9)
        frame.setLocal(9,DZERO);
         // *********[33] LDC(40->"-1.7976931348623157E308")
         // **REMOVED Substitution** s0 = DM1_7976931348623157E308;
         // *********[34] DSTORE(11)
        frame.setLocal(11,DM1_7976931348623157E308);
         // *********[35] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[36] ISTORE(13)
        frame.setLocal(13,KInteger.ZERO);
         // *********[37] GOTO(75)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[28] ISTORE(7)
         // *********[29] ICONST_0(Integer{0})
         // *********[30] ISTORE(8)
         // *********[31] DCONST_0(Double{0.0})
         // *********[32] DSTORE(9)
         // *********[33] LDC(40->"-1.7976931348623157E308")
         // *********[34] DSTORE(11)
         // *********[35] ICONST_0(Integer{0})
         // *********[36] ISTORE(13)
         // *********[37] GOTO(75)
        c_label = instructions[22];
      }
}
