package jjit.local.jnt.scimark2.LU.new_copy___D___D_ADD42A1;
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
 * new_copy([[D)[[D
 * [count=10] [0] ALOAD(0) [1] ARRAYLENGTH [2] ISTORE(1) [3] ALOAD(0) [4] ICONST_0(Integer{0}) [5] AALOAD [6] ARRAYLENGTH [7] ISTORE(2) [8] ILOAD(1) [9] ILOAD(2)
 */
public final class new_copy_001 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** KReference ref;
         // local_0 0 ; r=2/w=0 : Cached
        KRegister local_0 = frame.getLocal(0);
         // local_1 1 ; r=1/w=1 : Cached
        int local_1;
         // local_2 2 ; r=1/w=1 : Cached
        int local_2;
         // *********[0] ALOAD(0)
         // **REMOVED Substitution** s0 = local_0;
         // *********[1] ARRAYLENGTH
         // **REMOVED Substitution** s0 = new KInteger(c_memman.getArraySize(((KReference)local_0)));
         // *********[2] ISTORE(1)
        local_1 = c_memman.getArraySize(((KReference)local_0));
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
         // *********[7] ISTORE(2)
        local_2 = c_memman.getArraySize(c_memman.getReferenceArray(((KReference)local_0),0));
         // *********[8] ILOAD(1)
        frame.push(new KInteger(local_1));
         // *********[9] ILOAD(2)
        frame.push(new KInteger(local_2));
        frame.setLocal(1,new KInteger(local_1));
        frame.setLocal(2,new KInteger(local_2));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[2] ISTORE(1)
         // *********[3] ALOAD(0)
         // *********[4] ICONST_0(Integer{0})
         // *********[5] AALOAD
         // *********[6] ARRAYLENGTH
         // *********[7] ISTORE(2)
         // *********[8] ILOAD(1)
         // *********[9] ILOAD(2)
        c_next = instructions[(index + 1)];
      }
}
