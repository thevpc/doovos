package jjit.local.jnt.scimark2.FFT.transform_internal__DI_V_5ED5CCC1;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.FFT
 * transform_internal([DI)V
 * [count=5] [240] IINC(4,1) [241] ILOAD(5) [242] ICONST_2(Integer{2}) [243] IMUL [244] ISTORE(5)
 */
public final class transform_internal_017 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // local_4 4 ; r=1/w=1 : Cached
        int local_4 = frame.getLocal(4).intValue();
         // local_5 5 ; r=1/w=1 : Cached
        int local_5 = frame.getLocal(5).intValue();
         // *********[240] IINC(4,1)
         // **REMOVED Substitution** local_4 = (local_4 + 1);
         // *********[241] ILOAD(5)
         // **REMOVED Substitution** s0 = new KInteger(local_5);
         // *********[242] ICONST_2(Integer{2})
         // **REMOVED Substitution** s1 = ITWO;
         // *********[243] IMUL
         // **REMOVED Substitution** index = 2;
         // **REMOVED Substitution** s0 = new KInteger((local_5 * 2));
         // *********[244] ISTORE(5)
         // **REMOVED Substitution** local_5 = (local_5 * 2);
        frame.setLocal(4,new KInteger((local_4 + 1)));
        frame.setLocal(5,new KInteger((local_5 * 2)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[240] IINC(4,1)
         // *********[241] ILOAD(5)
         // *********[242] ICONST_2(Integer{2})
         // *********[243] IMUL
         // *********[244] ISTORE(5)
        c_next = instructions[(index + 1)];
      }
}
