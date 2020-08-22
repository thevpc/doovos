package jjit.local.jnt.Bench.Formatter.format_DI_Ljava_lang_String_59D5BD5C;
import java.lang.Math;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Formatter
 * format(DI)Ljava/lang/String;
 * [count=12] [7] DLOAD(0) [8] LDC(9->"10.0") [9] ILOAD(2) [10] I2D [11] INVOKE_HOST(java.lang.Math.pow(DD)D) [12] DMUL [13] DSTORE(3) [14] DLOAD(3) [15] INVOKE_HOST(java.lang.Math.abs(D)D) [16] LDC(12->"9.223372036854776E18") [17] DCMPL [18] IFLE(22)
 */
public final class format_003 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister[] regs = null;
         // **REMOVED Unused Var** double m_v;
         // **REMOVED Unused Var** double m_v2;
         // **REMOVED Unused Var** double m_d2;
         // **REMOVED Unused Var** double m_v3;
        double m_d3;
         // **REMOVED Unused Var** double m_d4;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=1 : Cached
        KRegister local_3;
         // *********[7] DLOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[8] LDC(9->"10.0")
         // **REMOVED Substitution** s1 = D10_0;
         // *********[9] ILOAD(2)
         // **REMOVED Substitution** s2 = frame.getLocal(2);
         // *********[10] I2D
         // **REMOVED Substitution** s2 = new KDouble(frame.getLocal(2).intValue());
         // *********[11] INVOKE_HOST(java.lang.Math.pow(DD)D)
         // **REMOVED Substitution** m_v2 = frame.getLocal(2).doubleValue();
         // **REMOVED Substitution** m_v = 10.0D;
         // **REMOVED Substitution** s1 = new KDouble(Math.pow(10.0D,frame.getLocal(2).doubleValue()));
         // *********[12] DMUL
         // **REMOVED Substitution** m_d2 = Math.pow(10.0D,frame.getLocal(2).doubleValue());
         // **REMOVED Substitution** s0 = new KDouble((frame.getLocal(0).doubleValue() * Math.pow(10.0D,frame.getLocal(2).doubleValue())));
         // *********[13] DSTORE(3)
        local_3 = new KDouble((frame.getLocal(0).doubleValue() * Math.pow(10.0D,frame.getLocal(2).doubleValue())));
         // *********[14] DLOAD(3)
         // **REMOVED Substitution** s0 = local_3;
         // *********[15] INVOKE_HOST(java.lang.Math.abs(D)D)
         // **REMOVED Substitution** m_v3 = local_3.doubleValue();
         // **REMOVED Substitution** s0 = new KDouble(Math.abs(local_3.doubleValue()));
         // *********[16] LDC(12->"9.223372036854776E18")
         // **REMOVED Substitution** s1 = D9_223372036854776E18;
         // *********[17] DCMPL
         // **REMOVED Substitution** m_d4 = 9.223372036854776E18D;
        m_d3 = Math.abs(local_3.doubleValue());
         // **REMOVED Substitution** s0 = ((Double.isNaN(m_d3))?(KInteger.M1):(((m_d3 == 9.223372036854776E18D)?(KInteger.ZERO):(((m_d3 > 9.223372036854776E18D)?(KInteger.ONE):(KInteger.M1))))));
         // *********[18] IFLE(22)
         // **REMOVED Substitution** index = ((Double.isNaN(m_d3))?(-1):(((m_d3 == 9.223372036854776E18D)?(0):(((m_d3 > 9.223372036854776E18D)?(1):(-1))))));
         // **REMOVED Substitution** jump = ((Double.isNaN(m_d3))?(-1):(((m_d3 == 9.223372036854776E18D)?(0):(((m_d3 > 9.223372036854776E18D)?(1):(-1)))))) <= 0;
        frame.setLocal(3,local_3);
        return ((((Double.isNaN(m_d3))?(-1):(((m_d3 == 9.223372036854776E18D)?(0):(((m_d3 > 9.223372036854776E18D)?(1):(-1)))))) <= 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[7] DLOAD(0)
         // *********[8] LDC(9->"10.0")
         // *********[9] ILOAD(2)
         // *********[10] I2D
         // *********[11] INVOKE_HOST(java.lang.Math.pow(DD)D)
         // *********[12] DMUL
         // *********[13] DSTORE(3)
         // *********[14] DLOAD(3)
         // *********[15] INVOKE_HOST(java.lang.Math.abs(D)D)
         // *********[16] LDC(12->"9.223372036854776E18")
         // *********[17] DCMPL
         // *********[18] IFLE(22)
        c_next = instructions[(index + 1)];
        c_label = instructions[4];
      }
}
