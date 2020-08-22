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
 * [count=4] [2] ASTORE(2) [3] ALOAD(2) [4] ICONST_0(Integer{0}) [5] ICONST_3(Integer{3})
 */
public final class check_004 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger IZERO = KInteger.ZERO;
      private static final KInteger ITHREE = KInteger.THREE;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // local_2 2 ; r=1/w=1 : Cached
        KRegister local_2;
         // *********[2] ASTORE(2)
        local_2 = frame.pop();
         // *********[3] ALOAD(2)
        frame.push(local_2);
         // *********[4] ICONST_0(Integer{0})
        frame.push(IZERO);
         // *********[5] ICONST_3(Integer{3})
        frame.push(ITHREE);
        frame.setLocal(2,local_2);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[2] ASTORE(2)
         // *********[3] ALOAD(2)
         // *********[4] ICONST_0(Integer{0})
         // *********[5] ICONST_3(Integer{3})
        c_next = instructions[(index + 1)];
      }
}
