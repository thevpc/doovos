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
 * [count=3] [8] ICONST_0(Integer{0}) [9] ISTORE(4) [10] GOTO(68)
 */
public final class parseEntries_003 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_4 4 ; r=0/w=1 : NotCached
         // *********[8] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[9] ISTORE(4)
        frame.setLocal(4,KInteger.ZERO);
         // *********[10] GOTO(68)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[8] ICONST_0(Integer{0})
         // *********[9] ISTORE(4)
         // *********[10] GOTO(68)
        c_label = instructions[18];
      }
}
