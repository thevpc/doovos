package jjit.local.jnt.Bench.SendMail.check_Ljava_io_DataInputStreamI_V_FAF8EFD;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.SendMail
 * check(Ljava/io/DataInputStream;I)V
 * [count=4] [8] ISTORE(3) [9] ILOAD(3) [10] SIPUSH(Integer{250}) [11] IF_ICMPEQ(15)
 */
public final class check_009 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_3 3 ; r=1/w=1 : Cached
        int local_3;
         // *********[8] ISTORE(3)
        local_3 = frame.popInt();
         // *********[9] ILOAD(3)
         // **REMOVED Substitution** s0 = new KInteger(local_3);
         // *********[10] SIPUSH(Integer{250})
         // **REMOVED Substitution** s1 = I250;
         // *********[11] IF_ICMPEQ(15)
         // **REMOVED Substitution** index = 250;
         // **REMOVED Substitution** jump = local_3 == 250;
        frame.setLocal(3,new KInteger(local_3));
        return ((local_3 == 250)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[8] ISTORE(3)
         // *********[9] ILOAD(3)
         // *********[10] SIPUSH(Integer{250})
         // *********[11] IF_ICMPEQ(15)
        c_next = instructions[(index + 1)];
        c_label = instructions[10];
      }
}
