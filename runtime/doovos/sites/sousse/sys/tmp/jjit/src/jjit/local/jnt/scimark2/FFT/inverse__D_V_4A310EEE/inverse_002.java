package jjit.local.jnt.scimark2.FFT.inverse__D_V_4A310EEE;
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
 * jnt.scimark2.FFT
 * inverse([D)V
 * [count=15] [3] ALOAD(0) [4] ARRAYLENGTH [5] ISTORE(1) [6] ILOAD(1) [7] ICONST_2(Integer{2}) [8] IDIV [9] ISTORE(2) [10] DCONST_1(Double{1.0}) [11] ILOAD(2) [12] I2D [13] DDIV [14] DSTORE(3) [15] ICONST_0(Integer{0}) [16] ISTORE(5) [17] GOTO(26)
 */
public final class inverse_002 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** double m_d;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=1 : Cached
        int local_1;
         // local_2 2 ; r=1/w=1 : Cached
         // **REMOVED Unused Var** int local_2;
         // local_3 3 ; r=0/w=1 : NotCached
         // local_5 5 ; r=0/w=1 : NotCached
         // *********[3] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[4] ARRAYLENGTH
         // **REMOVED Substitution** s0 = new KInteger(c_memman.getArraySize(((KReference)frame.getLocal(0))));
         // *********[5] ISTORE(1)
        local_1 = c_memman.getArraySize(((KReference)frame.getLocal(0)));
         // *********[6] ILOAD(1)
         // **REMOVED Substitution** s0 = new KInteger(local_1);
         // *********[7] ICONST_2(Integer{2})
         // **REMOVED Substitution** s1 = ITWO;
         // *********[8] IDIV
         // **REMOVED Substitution** index = 2;
         // **REMOVED Substitution** s0 = new KInteger((local_1 / 2));
         // *********[9] ISTORE(2)
         // **REMOVED Substitution** local_2 = (local_1 / 2);
         // *********[10] DCONST_1(Double{1.0})
         // **REMOVED Substitution** s0 = DONE;
         // *********[11] ILOAD(2)
         // **REMOVED Substitution** s1 = new KInteger((local_1 / 2));
         // *********[12] I2D
         // **REMOVED Substitution** s1 = new KDouble((local_1 / 2));
         // *********[13] DDIV
         // **REMOVED Substitution** m_d = ((double)(local_1 / 2));
         // **REMOVED Substitution** s0 = new KDouble((1.0D / ((double)(local_1 / 2))));
         // *********[14] DSTORE(3)
        frame.setLocal(3,new KDouble((1.0D / ((double)(local_1 / 2)))));
         // *********[15] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[16] ISTORE(5)
        frame.setLocal(5,KInteger.ZERO);
         // *********[17] GOTO(26)
        frame.setLocal(1,new KInteger(local_1));
        frame.setLocal(2,new KInteger((local_1 / 2)));
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[3] ALOAD(0)
         // *********[4] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[5] ISTORE(1)
         // *********[6] ILOAD(1)
         // *********[7] ICONST_2(Integer{2})
         // *********[8] IDIV
         // *********[9] ISTORE(2)
         // *********[10] DCONST_1(Double{1.0})
         // *********[11] ILOAD(2)
         // *********[12] I2D
         // *********[13] DDIV
         // *********[14] DSTORE(3)
         // *********[15] ICONST_0(Integer{0})
         // *********[16] ISTORE(5)
         // *********[17] GOTO(26)
        c_label = instructions[3];
      }
}
