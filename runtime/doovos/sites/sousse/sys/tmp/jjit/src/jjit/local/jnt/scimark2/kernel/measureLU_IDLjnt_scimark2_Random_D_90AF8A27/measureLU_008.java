package jjit.local.jnt.scimark2.kernel.measureLU_IDLjnt_scimark2_Random_D_90AF8A27;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.kernel
 * measureLU(IDLjnt/scimark2/Random;)D
 * [count=4] [15] ASTORE(7) [16] ICONST_1(Integer{1}) [17] ISTORE(8) [18] GOTO(19)
 */
public final class measureLU_008 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_7 7 ; r=0/w=1 : NotCached
         // local_8 8 ; r=0/w=1 : NotCached
         // *********[15] ASTORE(7)
        frame.setLocal(7,frame.pop());
         // *********[16] ICONST_1(Integer{1})
         // **REMOVED Substitution** s0 = IONE;
         // *********[17] ISTORE(8)
        frame.setLocal(8,KInteger.ONE);
         // *********[18] GOTO(19)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[15] ASTORE(7)
         // *********[16] ICONST_1(Integer{1})
         // *********[17] ISTORE(8)
         // *********[18] GOTO(19)
        c_label = instructions[8];
      }
}
