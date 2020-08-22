package jjit.local.jnt.Bench.Bench.parseSegments_Ljava_io_StreamTokenizer_V_901B73D0;
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
 * parseSegments(Ljava/io/StreamTokenizer;)V
 * [count=3] [63] D2I [64] ISTORE(7) [65] GOTO(75)
 */
public final class parseSegments_020 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_7 7 ; r=0/w=1 : NotCached
         // *********[63] D2I
         // **REMOVED Substitution** s0 = new KInteger(((int)frame.popDouble()));
         // *********[64] ISTORE(7)
        frame.setLocal(7,new KInteger(((int)frame.popDouble())));
         // *********[65] GOTO(75)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[63] D2I
         // *********[64] ISTORE(7)
         // *********[65] GOTO(75)
        c_label = instructions[24];
      }
}
