package jjit.local.jnt.scimark2.SOR.execute_D__DI_V_DBC93CE5;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.SOR
 * execute(D[[DI)V
 * [count=3] [27] ICONST_1(Integer{1}) [28] ISTORE(13) [29] GOTO(84)
 */
public final class execute_002 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_13 13 ; r=0/w=1 : NotCached
         // *********[27] ICONST_1(Integer{1})
         // **REMOVED Substitution** s0 = IONE;
         // *********[28] ISTORE(13)
        frame.setLocal(13,KInteger.ONE);
         // *********[29] GOTO(84)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[27] ICONST_1(Integer{1})
         // *********[28] ISTORE(13)
         // *********[29] GOTO(84)
        c_label = instructions[6];
      }
}
