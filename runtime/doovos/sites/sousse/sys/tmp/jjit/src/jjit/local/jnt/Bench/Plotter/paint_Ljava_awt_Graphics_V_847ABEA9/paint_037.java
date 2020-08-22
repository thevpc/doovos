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
 * [count=19] [211] ICONST_0(Integer{0}) [212] ISTORE(31) [213] ILOAD(23) [214] ILOAD(27) [215] ILOAD(28) [216] ISUB [217] ICONST_2(Integer{2}) [218] IDIV [219] IADD [220] ISTORE(32) [221] ILOAD(23) [222] ILOAD(27) [223] ILOAD(7) [224] IADD [225] ICONST_2(Integer{2}) [226] IDIV [227] IADD [228] ISTORE(33) [229] GOTO(283)
 */
public final class paint_037 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** int index = 0;
         // local_32 32 ; r=0/w=1 : NotCached
         // local_33 33 ; r=0/w=1 : NotCached
         // local_23 23 ; r=2/w=0 : Cached
        int local_23 = frame.getLocal(23).intValue();
         // local_7 7 ; r=1/w=0 : NotCached
         // local_27 27 ; r=2/w=0 : Cached
        int local_27 = frame.getLocal(27).intValue();
         // local_28 28 ; r=1/w=0 : NotCached
         // local_31 31 ; r=0/w=1 : NotCached
         // *********[211] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[212] ISTORE(31)
        frame.setLocal(31,KInteger.ZERO);
         // *********[213] ILOAD(23)
         // **REMOVED Substitution** s0 = new KInteger(local_23);
         // *********[214] ILOAD(27)
         // **REMOVED Substitution** s1 = new KInteger(local_27);
         // *********[215] ILOAD(28)
         // **REMOVED Substitution** s2 = frame.getLocal(28);
         // *********[216] ISUB
         // **REMOVED Substitution** index = frame.getLocal(28).intValue();
         // **REMOVED Substitution** s1 = new KInteger((local_27 - frame.getLocal(28).intValue()));
         // *********[217] ICONST_2(Integer{2})
         // **REMOVED Substitution** s2 = ITWO;
         // *********[218] IDIV
         // **REMOVED Substitution** index = 2;
         // **REMOVED Substitution** s1 = new KInteger(((local_27 - frame.getLocal(28).intValue()) / 2));
         // *********[219] IADD
         // **REMOVED Substitution** index = ((local_27 - frame.getLocal(28).intValue()) / 2);
         // **REMOVED Substitution** s0 = new KInteger((local_23 + ((local_27 - frame.getLocal(28).intValue()) / 2)));
         // *********[220] ISTORE(32)
        frame.setLocal(32,new KInteger((local_23 + ((local_27 - frame.getLocal(28).intValue()) / 2))));
         // *********[221] ILOAD(23)
         // **REMOVED Substitution** s0 = new KInteger(local_23);
         // *********[222] ILOAD(27)
         // **REMOVED Substitution** s1 = new KInteger(local_27);
         // *********[223] ILOAD(7)
         // **REMOVED Substitution** s2 = frame.getLocal(7);
         // *********[224] IADD
         // **REMOVED Substitution** index = frame.getLocal(7).intValue();
         // **REMOVED Substitution** s1 = new KInteger((local_27 + frame.getLocal(7).intValue()));
         // *********[225] ICONST_2(Integer{2})
         // **REMOVED Substitution** s2 = ITWO;
         // *********[226] IDIV
         // **REMOVED Substitution** index = 2;
         // **REMOVED Substitution** s1 = new KInteger(((local_27 + frame.getLocal(7).intValue()) / 2));
         // *********[227] IADD
         // **REMOVED Substitution** index = ((local_27 + frame.getLocal(7).intValue()) / 2);
         // **REMOVED Substitution** s0 = new KInteger((local_23 + ((local_27 + frame.getLocal(7).intValue()) / 2)));
         // *********[228] ISTORE(33)
        frame.setLocal(33,new KInteger((local_23 + ((local_27 + frame.getLocal(7).intValue()) / 2))));
         // *********[229] GOTO(283)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[211] ICONST_0(Integer{0})
         // *********[212] ISTORE(31)
         // *********[213] ILOAD(23)
         // *********[214] ILOAD(27)
         // *********[215] ILOAD(28)
         // *********[216] ISUB
         // *********[217] ICONST_2(Integer{2})
         // *********[218] IDIV
         // *********[219] IADD
         // *********[220] ISTORE(32)
         // *********[221] ILOAD(23)
         // *********[222] ILOAD(27)
         // *********[223] ILOAD(7)
         // *********[224] IADD
         // *********[225] ICONST_2(Integer{2})
         // *********[226] IDIV
         // *********[227] IADD
         // *********[228] ISTORE(33)
         // *********[229] GOTO(283)
        c_label = instructions[45];
      }
}
