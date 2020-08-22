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
 * [count=11] [15] ALOAD(3) [16] ILOAD(4) [17] AALOAD [18] ASTORE(5) [19] ALOAD(0) [20] ILOAD(4) [21] AALOAD [22] ASTORE(6) [23] ICONST_0(Integer{0}) [24] ISTORE(7) [25] GOTO(33)
 */
public final class new_copy_005 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** KReference ref;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=0 : NotCached
         // local_4 4 ; r=2/w=0 : Cached
        int local_4 = frame.getLocal(4).intValue();
         // local_5 5 ; r=0/w=1 : NotCached
         // local_6 6 ; r=0/w=1 : NotCached
         // local_7 7 ; r=0/w=1 : NotCached
         // *********[15] ALOAD(3)
         // **REMOVED Substitution** s0 = frame.getLocal(3);
         // *********[16] ILOAD(4)
         // **REMOVED Substitution** s1 = new KInteger(local_4);
         // *********[17] AALOAD
         // **REMOVED Substitution** index = local_4;
         // **REMOVED Substitution** ref = ((KReference)frame.getLocal(3));
         // **REMOVED Substitution** s0_ref = c_memman.getReferenceArray(((KReference)frame.getLocal(3)),local_4);
         // *********[18] ASTORE(5)
        frame.setLocal(5,c_memman.getReferenceArray(((KReference)frame.getLocal(3)),local_4));
         // *********[19] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[20] ILOAD(4)
         // **REMOVED Substitution** s1 = new KInteger(local_4);
         // *********[21] AALOAD
         // **REMOVED Substitution** index = local_4;
         // **REMOVED Substitution** ref = ((KReference)frame.getLocal(0));
         // **REMOVED Substitution** s0_ref = c_memman.getReferenceArray(((KReference)frame.getLocal(0)),local_4);
         // *********[22] ASTORE(6)
        frame.setLocal(6,c_memman.getReferenceArray(((KReference)frame.getLocal(0)),local_4));
         // *********[23] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[24] ISTORE(7)
        frame.setLocal(7,KInteger.ZERO);
         // *********[25] GOTO(33)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[15] ALOAD(3)
         // *********[16] ILOAD(4)
         // *********[17] AALOAD
        c_memman = process.getMemoryManager();
         // *********[18] ASTORE(5)
         // *********[19] ALOAD(0)
         // *********[20] ILOAD(4)
         // *********[21] AALOAD
         // *********[22] ASTORE(6)
         // *********[23] ICONST_0(Integer{0})
         // *********[24] ISTORE(7)
         // *********[25] GOTO(33)
        c_label = instructions[6];
      }
}
