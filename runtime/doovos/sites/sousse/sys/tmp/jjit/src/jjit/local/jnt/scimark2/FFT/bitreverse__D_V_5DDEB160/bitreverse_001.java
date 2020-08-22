package jjit.local.jnt.scimark2.FFT.bitreverse__D_V_5DDEB160;
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
 * bitreverse([D)V
 * [count=14] [0] ALOAD(0) [1] ARRAYLENGTH [2] ICONST_2(Integer{2}) [3] IDIV [4] ISTORE(1) [5] ILOAD(1) [6] ICONST_1(Integer{1}) [7] ISUB [8] ISTORE(2) [9] ICONST_0(Integer{0}) [10] ISTORE(3) [11] ICONST_0(Integer{0}) [12] ISTORE(4) [13] GOTO(82)
 */
public final class bitreverse_001 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=1 : Cached
        int local_1;
         // local_2 2 ; r=0/w=1 : NotCached
         // local_3 3 ; r=0/w=1 : NotCached
         // local_4 4 ; r=0/w=1 : NotCached
         // *********[0] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[1] ARRAYLENGTH
         // **REMOVED Substitution** s0 = new KInteger(c_memman.getArraySize(((KReference)frame.getLocal(0))));
         // *********[2] ICONST_2(Integer{2})
         // **REMOVED Substitution** s1 = ITWO;
         // *********[3] IDIV
         // **REMOVED Substitution** index = 2;
         // **REMOVED Substitution** s0 = new KInteger((c_memman.getArraySize(((KReference)frame.getLocal(0))) / 2));
         // *********[4] ISTORE(1)
        local_1 = (c_memman.getArraySize(((KReference)frame.getLocal(0))) / 2);
         // *********[5] ILOAD(1)
         // **REMOVED Substitution** s0 = new KInteger(local_1);
         // *********[6] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[7] ISUB
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s0 = new KInteger((local_1 - 1));
         // *********[8] ISTORE(2)
        frame.setLocal(2,new KInteger((local_1 - 1)));
         // *********[9] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[10] ISTORE(3)
        frame.setLocal(3,KInteger.ZERO);
         // *********[11] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[12] ISTORE(4)
        frame.setLocal(4,KInteger.ZERO);
         // *********[13] GOTO(82)
        frame.setLocal(1,new KInteger(local_1));
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[2] ICONST_2(Integer{2})
         // *********[3] IDIV
         // *********[4] ISTORE(1)
         // *********[5] ILOAD(1)
         // *********[6] ICONST_1(Integer{1})
         // *********[7] ISUB
         // *********[8] ISTORE(2)
         // *********[9] ICONST_0(Integer{0})
         // *********[10] ISTORE(3)
         // *********[11] ICONST_0(Integer{0})
         // *********[12] ISTORE(4)
         // *********[13] GOTO(82)
        c_label = instructions[6];
      }
}
