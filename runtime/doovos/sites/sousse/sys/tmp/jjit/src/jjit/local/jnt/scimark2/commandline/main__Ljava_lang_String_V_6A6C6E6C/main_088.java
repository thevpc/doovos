package jjit.local.jnt.scimark2.commandline.main__Ljava_lang_String_V_6A6C6E6C;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.commandline
 * main([Ljava/lang/String;)V
 * [count=6] [243] ALOAD(8) [244] ICONST_5(Integer{5}) [245] DALOAD [246] DCONST_0(Double{0.0}) [247] DCMPL [248] IFNE(253)
 */
public final class main_088 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
        double m_d;
         // **REMOVED Unused Var** double m_d2;
         // **REMOVED Unused Var** boolean jump;
         // local_8 8 ; r=1/w=0 : NotCached
         // *********[243] ALOAD(8)
         // **REMOVED Substitution** s0 = frame.getLocal(8);
         // *********[244] ICONST_5(Integer{5})
         // **REMOVED Substitution** s1 = IFIVE;
         // *********[245] DALOAD
         // **REMOVED Substitution** index = 5;
         // **REMOVED Substitution** s0 = new KDouble(c_memman.getDoubleArray(((KReference)frame.getLocal(8)),5));
         // *********[246] DCONST_0(Double{0.0})
         // **REMOVED Substitution** s1 = DZERO;
         // *********[247] DCMPL
         // **REMOVED Substitution** m_d2 = 0.0D;
        m_d = c_memman.getDoubleArray(((KReference)frame.getLocal(8)),5);
         // **REMOVED Substitution** s0 = ((Double.isNaN(m_d))?(KInteger.M1):(((m_d == 0.0D)?(KInteger.ZERO):(((m_d > 0.0D)?(KInteger.ONE):(KInteger.M1))))));
         // *********[248] IFNE(253)
         // **REMOVED Substitution** index = ((Double.isNaN(m_d))?(-1):(((m_d == 0.0D)?(0):(((m_d > 0.0D)?(1):(-1))))));
         // **REMOVED Substitution** jump = ((Double.isNaN(m_d))?(-1):(((m_d == 0.0D)?(0):(((m_d > 0.0D)?(1):(-1)))))) != 0;
        return ((((Double.isNaN(m_d))?(-1):(((m_d == 0.0D)?(0):(((m_d > 0.0D)?(1):(-1)))))) != 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[243] ALOAD(8)
         // *********[244] ICONST_5(Integer{5})
         // *********[245] DALOAD
        c_memman = process.getMemoryManager();
         // *********[246] DCONST_0(Double{0.0})
         // *********[247] DCMPL
         // *********[248] IFNE(253)
        c_next = instructions[(index + 1)];
        c_label = instructions[90];
      }
}
