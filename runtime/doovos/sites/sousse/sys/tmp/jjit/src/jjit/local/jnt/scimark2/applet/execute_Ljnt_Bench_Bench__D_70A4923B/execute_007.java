package jjit.local.jnt.scimark2.applet.execute_Ljnt_Bench_Bench__D_70A4923B;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.applet
 * execute(Ljnt/Bench/Bench;)[D
 * [count=5] [15] ALOAD(2) [16] ICONST_1(Integer{1}) [17] BIPUSH(16) [18] DLOAD(6) [19] ALOAD(3)
 */
public final class execute_007 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger IONE = KInteger.ONE;
      private static final KInteger I16 = new KInteger(16);
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // local_2 2 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=0 : NotCached
         // local_6 6 ; r=1/w=0 : NotCached
         // *********[15] ALOAD(2)
        frame.push(frame.getLocal(2));
         // *********[16] ICONST_1(Integer{1})
        frame.push(IONE);
         // *********[17] BIPUSH(16)
        frame.push(I16);
         // *********[18] DLOAD(6)
        frame.push(frame.getLocal(6));
         // *********[19] ALOAD(3)
        frame.push(frame.getLocal(3));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[15] ALOAD(2)
         // *********[16] ICONST_1(Integer{1})
         // *********[17] BIPUSH(16)
         // *********[18] DLOAD(6)
         // *********[19] ALOAD(3)
        c_next = instructions[(index + 1)];
      }
}
