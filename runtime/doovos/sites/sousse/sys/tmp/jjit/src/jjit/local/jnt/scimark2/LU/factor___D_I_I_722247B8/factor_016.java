package jjit.local.jnt.scimark2.LU.factor___D_I_I_722247B8;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.LU
 * factor([[D[I)I
 * [count=5] [115] ILOAD(5) [116] ICONST_1(Integer{1}) [117] IADD [118] ISTORE(10) [119] GOTO(153)
 */
public final class factor_016 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // local_5 5 ; r=1/w=0 : NotCached
         // local_10 10 ; r=0/w=1 : NotCached
         // *********[115] ILOAD(5)
         // **REMOVED Substitution** s0 = frame.getLocal(5);
         // *********[116] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[117] IADD
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s0 = new KInteger((frame.getLocal(5).intValue() + 1));
         // *********[118] ISTORE(10)
        frame.setLocal(10,new KInteger((frame.getLocal(5).intValue() + 1)));
         // *********[119] GOTO(153)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[115] ILOAD(5)
         // *********[116] ICONST_1(Integer{1})
         // *********[117] IADD
         // *********[118] ISTORE(10)
         // *********[119] GOTO(153)
        c_label = instructions[20];
      }
}
