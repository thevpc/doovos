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
 * [count=2] [339] LDC(90->"default.descriptor") [340] ASTORE(9)
 */
public final class init_107 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R90 = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s0_ref;
         // local_9 9 ; r=0/w=1 : NotCached
         // *********[339] LDC(90->"default.descriptor")
         // **REMOVED Substitution** s0_ref = R90;
         // *********[340] ASTORE(9)
        frame.setLocal(9,R90);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[339] LDC(90->"default.descriptor")
        R90 = ((KReference)constants[90]);
         // *********[340] ASTORE(9)
        c_next = instructions[(index + 1)];
      }
}
