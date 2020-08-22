package jjit.local.jnt.scimark2.kernel.normabs__D_D_D_9592EBA0;
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
 * normabs([D[D)D
 * [count=8] [0] ALOAD(0) [1] ARRAYLENGTH [2] ISTORE(2) [3] DCONST_0(Double{0.0}) [4] DSTORE(3) [5] ICONST_0(Integer{0}) [6] ISTORE(5) [7] GOTO(20)
 */
public final class normabs_001 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private static final KDouble DZERO = KDouble.ZERO;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_2 2 ; r=0/w=1 : NotCached
         // local_3 3 ; r=0/w=1 : NotCached
         // local_5 5 ; r=0/w=1 : NotCached
         // *********[0] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[1] ARRAYLENGTH
         // **REMOVED Substitution** s0 = new KInteger(c_memman.getArraySize(((KReference)frame.getLocal(0))));
         // *********[2] ISTORE(2)
        frame.setLocal(2,new KInteger(c_memman.getArraySize(((KReference)frame.getLocal(0)))));
         // *********[3] DCONST_0(Double{0.0})
         // **REMOVED Substitution** s0 = DZERO;
         // *********[4] DSTORE(3)
        frame.setLocal(3,DZERO);
         // *********[5] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[6] ISTORE(5)
        frame.setLocal(5,KInteger.ZERO);
         // *********[7] GOTO(20)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[2] ISTORE(2)
         // *********[3] DCONST_0(Double{0.0})
         // *********[4] DSTORE(3)
         // *********[5] ICONST_0(Integer{0})
         // *********[6] ISTORE(5)
         // *********[7] GOTO(20)
        c_label = instructions[2];
      }
}
