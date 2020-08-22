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
 * [count=5] [44] ILOAD(8) [45] ICONST_2(Integer{2}) [46] IMUL [47] ISTORE(8) [48] GOTO(19)
 */
public final class measureLU_019 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // local_8 8 ; r=1/w=1 : Cached
        int local_8 = frame.getLocal(8).intValue();
         // *********[44] ILOAD(8)
         // **REMOVED Substitution** s0 = new KInteger(local_8);
         // *********[45] ICONST_2(Integer{2})
         // **REMOVED Substitution** s1 = ITWO;
         // *********[46] IMUL
         // **REMOVED Substitution** index = 2;
         // **REMOVED Substitution** s0 = new KInteger((local_8 * 2));
         // *********[47] ISTORE(8)
         // **REMOVED Substitution** local_8 = (local_8 * 2);
         // *********[48] GOTO(19)
        frame.setLocal(8,new KInteger((local_8 * 2)));
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[44] ILOAD(8)
         // *********[45] ICONST_2(Integer{2})
         // *********[46] IMUL
         // *********[47] ISTORE(8)
         // *********[48] GOTO(19)
        c_label = instructions[8];
      }
}
