package jjit.shared;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.HTTPPost
 * post(Ljava/lang/String;Ljava/lang/String;)V
 * [count=2] [16] ILOAD(3) [17] ICONST_1(Integer{1})
 */
public final class ILOAD3_ICONST_1 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger IONE = KInteger.ONE;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // local_3 3 ; r=1/w=0 : NotCached
         // *********[16] ILOAD(3)
        frame.push(frame.getLocal(3));
         // *********[17] ICONST_1(Integer{1})
        frame.push(IONE);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[16] ILOAD(3)
         // *********[17] ICONST_1(Integer{1})
        c_next = instructions[(index + 1)];
      }
}
