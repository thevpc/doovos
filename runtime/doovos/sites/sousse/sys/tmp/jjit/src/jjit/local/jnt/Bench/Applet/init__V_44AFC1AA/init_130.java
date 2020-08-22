package jjit.local.jnt.Bench.Applet.init__V_44AFC1AA;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Applet
 * init()V
 * [count=3] [385] ICONST_1(Integer{1}) [386] ISTORE(10) [387] GOTO(395)
 */
public final class init_130 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_10 10 ; r=0/w=1 : NotCached
         // *********[385] ICONST_1(Integer{1})
         // **REMOVED Substitution** s0 = IONE;
         // *********[386] ISTORE(10)
        frame.setLocal(10,KInteger.ONE);
         // *********[387] GOTO(395)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[385] ICONST_1(Integer{1})
         // *********[386] ISTORE(10)
         // *********[387] GOTO(395)
        c_label = instructions[132];
      }
}
