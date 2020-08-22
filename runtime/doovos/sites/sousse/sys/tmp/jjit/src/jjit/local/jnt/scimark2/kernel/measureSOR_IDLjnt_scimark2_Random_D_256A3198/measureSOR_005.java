package jjit.local.jnt.scimark2.kernel.measureSOR_IDLjnt_scimark2_Random_D_256A3198;
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
 * measureSOR(IDLjnt/scimark2/Random;)D
 * [count=4] [8] ASTORE(5) [9] ICONST_1(Integer{1}) [10] ISTORE(6) [11] GOTO(12)
 */
public final class measureSOR_005 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_5 5 ; r=0/w=1 : NotCached
         // local_6 6 ; r=0/w=1 : NotCached
         // *********[8] ASTORE(5)
        frame.setLocal(5,frame.pop());
         // *********[9] ICONST_1(Integer{1})
         // **REMOVED Substitution** s0 = IONE;
         // *********[10] ISTORE(6)
        frame.setLocal(6,KInteger.ONE);
         // *********[11] GOTO(12)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[8] ASTORE(5)
         // *********[9] ICONST_1(Integer{1})
         // *********[10] ISTORE(6)
         // *********[11] GOTO(12)
        c_label = instructions[5];
      }
}
