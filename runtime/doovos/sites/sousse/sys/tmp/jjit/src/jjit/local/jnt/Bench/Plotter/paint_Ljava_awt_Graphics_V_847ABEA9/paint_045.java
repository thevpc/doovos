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
 * [count=9] [274] IINC(31,1) [275] ILOAD(32) [276] ILOAD(27) [277] IADD [278] ISTORE(32) [279] ILOAD(33) [280] ILOAD(27) [281] IADD [282] ISTORE(33)
 */
public final class paint_045 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // local_32 32 ; r=1/w=1 : Cached
        int local_32 = frame.getLocal(32).intValue();
         // local_33 33 ; r=1/w=1 : Cached
        int local_33 = frame.getLocal(33).intValue();
         // local_27 27 ; r=2/w=0 : Cached
        int local_27 = frame.getLocal(27).intValue();
         // local_31 31 ; r=1/w=1 : Cached
        int local_31 = frame.getLocal(31).intValue();
         // *********[274] IINC(31,1)
         // **REMOVED Substitution** local_31 = (local_31 + 1);
         // *********[275] ILOAD(32)
         // **REMOVED Substitution** s0 = new KInteger(local_32);
         // *********[276] ILOAD(27)
         // **REMOVED Substitution** s1 = new KInteger(local_27);
         // *********[277] IADD
         // **REMOVED Substitution** index = local_27;
         // **REMOVED Substitution** s0 = new KInteger((local_32 + local_27));
         // *********[278] ISTORE(32)
         // **REMOVED Substitution** local_32 = (local_32 + local_27);
         // *********[279] ILOAD(33)
         // **REMOVED Substitution** s0 = new KInteger(local_33);
         // *********[280] ILOAD(27)
         // **REMOVED Substitution** s1 = new KInteger(local_27);
         // *********[281] IADD
         // **REMOVED Substitution** index = local_27;
         // **REMOVED Substitution** s0 = new KInteger((local_33 + local_27));
         // *********[282] ISTORE(33)
         // **REMOVED Substitution** local_33 = (local_33 + local_27);
        frame.setLocal(32,new KInteger((local_32 + local_27)));
        frame.setLocal(33,new KInteger((local_33 + local_27)));
        frame.setLocal(31,new KInteger((local_31 + 1)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[274] IINC(31,1)
         // *********[275] ILOAD(32)
         // *********[276] ILOAD(27)
         // *********[277] IADD
         // *********[278] ISTORE(32)
         // *********[279] ILOAD(33)
         // *********[280] ILOAD(27)
         // *********[281] IADD
         // *********[282] ISTORE(33)
        c_next = instructions[(index + 1)];
      }
}
