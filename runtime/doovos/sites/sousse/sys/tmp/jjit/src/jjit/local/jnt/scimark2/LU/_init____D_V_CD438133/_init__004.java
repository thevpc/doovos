package jjit.local.jnt.scimark2.LU._init____D_V_CD438133;
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
 * jnt.scimark2.LU
 * <init>([[D)V
 * [count=11] [2] ALOAD(1) [3] ARRAYLENGTH [4] ISTORE(2) [5] ALOAD(1) [6] ICONST_0(Integer{0}) [7] AALOAD [8] ARRAYLENGTH [9] ISTORE(3) [10] ALOAD(0) [11] ILOAD(2) [12] ILOAD(3)
 */
public final class _init__004 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** KReference ref;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=2/w=0 : Cached
        KRegister local_1 = frame.getLocal(1);
         // local_2 2 ; r=1/w=1 : Cached
        int local_2;
         // local_3 3 ; r=1/w=1 : Cached
        int local_3;
         // *********[2] ALOAD(1)
         // **REMOVED Substitution** s0 = local_1;
         // *********[3] ARRAYLENGTH
         // **REMOVED Substitution** s0 = new KInteger(c_memman.getArraySize(((KReference)local_1)));
         // *********[4] ISTORE(2)
        local_2 = c_memman.getArraySize(((KReference)local_1));
         // *********[5] ALOAD(1)
         // **REMOVED Substitution** s0 = local_1;
         // *********[6] ICONST_0(Integer{0})
         // **REMOVED Substitution** s1 = IZERO;
         // *********[7] AALOAD
         // **REMOVED Substitution** index = 0;
         // **REMOVED Substitution** ref = ((KReference)local_1);
         // **REMOVED Substitution** s0_ref = c_memman.getReferenceArray(((KReference)local_1),0);
         // *********[8] ARRAYLENGTH
         // **REMOVED Substitution** s0 = new KInteger(c_memman.getArraySize(c_memman.getReferenceArray(((KReference)local_1),0)));
         // *********[9] ISTORE(3)
        local_3 = c_memman.getArraySize(c_memman.getReferenceArray(((KReference)local_1),0));
         // *********[10] ALOAD(0)
        frame.push(frame.getLocal(0));
         // *********[11] ILOAD(2)
        frame.push(new KInteger(local_2));
         // *********[12] ILOAD(3)
        frame.push(new KInteger(local_3));
        frame.setLocal(2,new KInteger(local_2));
        frame.setLocal(3,new KInteger(local_3));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[2] ALOAD(1)
         // *********[3] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[4] ISTORE(2)
         // *********[5] ALOAD(1)
         // *********[6] ICONST_0(Integer{0})
         // *********[7] AALOAD
         // *********[8] ARRAYLENGTH
         // *********[9] ISTORE(3)
         // *********[10] ALOAD(0)
         // *********[11] ILOAD(2)
         // *********[12] ILOAD(3)
        c_next = instructions[(index + 1)];
      }
}
