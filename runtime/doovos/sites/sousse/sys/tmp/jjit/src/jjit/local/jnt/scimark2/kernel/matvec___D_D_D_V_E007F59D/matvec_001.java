package jjit.local.jnt.scimark2.kernel.matvec___D_D_D_V_E007F59D;
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
 * matvec([[D[D[D)V
 * [count=11] [0] ALOAD(0) [1] ARRAYLENGTH [2] ISTORE(3) [3] ALOAD(0) [4] ICONST_0(Integer{0}) [5] AALOAD [6] ARRAYLENGTH [7] ISTORE(4) [8] ICONST_0(Integer{0}) [9] ISTORE(5) [10] GOTO(39)
 */
public final class matvec_001 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** KReference ref;
         // local_0 0 ; r=2/w=0 : Cached
        KRegister local_0 = frame.getLocal(0);
         // local_3 3 ; r=0/w=1 : NotCached
         // local_4 4 ; r=0/w=1 : NotCached
         // local_5 5 ; r=0/w=1 : NotCached
         // *********[0] ALOAD(0)
         // **REMOVED Substitution** s0 = local_0;
         // *********[1] ARRAYLENGTH
         // **REMOVED Substitution** s0 = new KInteger(c_memman.getArraySize(((KReference)local_0)));
         // *********[2] ISTORE(3)
        frame.setLocal(3,new KInteger(c_memman.getArraySize(((KReference)local_0))));
         // *********[3] ALOAD(0)
         // **REMOVED Substitution** s0 = local_0;
         // *********[4] ICONST_0(Integer{0})
         // **REMOVED Substitution** s1 = IZERO;
         // *********[5] AALOAD
         // **REMOVED Substitution** index = 0;
         // **REMOVED Substitution** ref = ((KReference)local_0);
         // **REMOVED Substitution** s0_ref = c_memman.getReferenceArray(((KReference)local_0),0);
         // *********[6] ARRAYLENGTH
         // **REMOVED Substitution** s0 = new KInteger(c_memman.getArraySize(c_memman.getReferenceArray(((KReference)local_0),0)));
         // *********[7] ISTORE(4)
        frame.setLocal(4,new KInteger(c_memman.getArraySize(c_memman.getReferenceArray(((KReference)local_0),0))));
         // *********[8] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[9] ISTORE(5)
        frame.setLocal(5,KInteger.ZERO);
         // *********[10] GOTO(39)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[2] ISTORE(3)
         // *********[3] ALOAD(0)
         // *********[4] ICONST_0(Integer{0})
         // *********[5] AALOAD
         // *********[6] ARRAYLENGTH
         // *********[7] ISTORE(4)
         // *********[8] ICONST_0(Integer{0})
         // *********[9] ISTORE(5)
         // *********[10] GOTO(39)
        c_label = instructions[5];
      }
}
