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
 * [count=5] [27] ILOAD(6) [28] ICONST_2(Integer{2}) [29] IMUL [30] ISTORE(6) [31] GOTO(12)
 */
public final class measureSOR_012 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // local_6 6 ; r=1/w=1 : Cached
        int local_6 = frame.getLocal(6).intValue();
         // *********[27] ILOAD(6)
         // **REMOVED Substitution** s0 = new KInteger(local_6);
         // *********[28] ICONST_2(Integer{2})
         // **REMOVED Substitution** s1 = ITWO;
         // *********[29] IMUL
         // **REMOVED Substitution** index = 2;
         // **REMOVED Substitution** s0 = new KInteger((local_6 * 2));
         // *********[30] ISTORE(6)
         // **REMOVED Substitution** local_6 = (local_6 * 2);
         // *********[31] GOTO(12)
        frame.setLocal(6,new KInteger((local_6 * 2)));
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[27] ILOAD(6)
         // *********[28] ICONST_2(Integer{2})
         // *********[29] IMUL
         // *********[30] ISTORE(6)
         // *********[31] GOTO(12)
        c_label = instructions[5];
      }
}
