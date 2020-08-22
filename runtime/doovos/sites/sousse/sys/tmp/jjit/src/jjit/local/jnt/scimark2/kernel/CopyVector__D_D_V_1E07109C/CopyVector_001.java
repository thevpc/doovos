package jjit.local.jnt.scimark2.kernel.CopyVector__D_D_V_1E07109C;
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
 * jnt.scimark2.kernel
 * CopyVector([D[D)V
 * [count=6] [0] ALOAD(1) [1] ARRAYLENGTH [2] ISTORE(2) [3] ICONST_0(Integer{0}) [4] ISTORE(3) [5] GOTO(13)
 */
public final class CopyVector_001 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_1 1 ; r=1/w=0 : NotCached
         // local_2 2 ; r=0/w=1 : NotCached
         // local_3 3 ; r=0/w=1 : NotCached
         // *********[0] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[1] ARRAYLENGTH
         // **REMOVED Substitution** s0 = new KInteger(c_memman.getArraySize(((KReference)frame.getLocal(1))));
         // *********[2] ISTORE(2)
        frame.setLocal(2,new KInteger(c_memman.getArraySize(((KReference)frame.getLocal(1)))));
         // *********[3] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[4] ISTORE(3)
        frame.setLocal(3,KInteger.ZERO);
         // *********[5] GOTO(13)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(1)
         // *********[1] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[2] ISTORE(2)
         // *********[3] ICONST_0(Integer{0})
         // *********[4] ISTORE(3)
         // *********[5] GOTO(13)
        c_label = instructions[2];
      }
}
