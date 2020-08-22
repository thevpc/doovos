package jjit.local.jnt.Bench.Bench.parseEntries_Ljava_io_StreamTokenizer_V_6B9C6DF2;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Bench
 * parseEntries(Ljava/io/StreamTokenizer;)V
 * [count=3] [27] ICONST_0(Integer{0}) [28] ISTORE(6) [29] GOTO(38)
 */
public final class parseEntries_007 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_6 6 ; r=0/w=1 : NotCached
         // *********[27] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[28] ISTORE(6)
        frame.setLocal(6,KInteger.ZERO);
         // *********[29] GOTO(38)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[27] ICONST_0(Integer{0})
         // *********[28] ISTORE(6)
         // *********[29] GOTO(38)
        c_label = instructions[9];
      }
}
