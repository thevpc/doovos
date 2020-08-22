package jjit.local.jnt.scimark2.LU.factor___D_I_I_722247B8;
import java.lang.Math;
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
 * factor([[D[I)I
 * [count=15] [0] ALOAD(0) [1] ARRAYLENGTH [2] ISTORE(2) [3] ALOAD(0) [4] ICONST_0(Integer{0}) [5] AALOAD [6] ARRAYLENGTH [7] ISTORE(3) [8] ILOAD(3) [9] ILOAD(2) [10] INVOKE_HOST(java.lang.Math.min(II)I) [11] ISTORE(4) [12] ICONST_0(Integer{0}) [13] ISTORE(5) [14] GOTO(157)
 */
public final class factor_001 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KRegister[] regs = null;
         // **REMOVED Unused Var** int m_v;
         // **REMOVED Unused Var** int m_v2;
         // local_0 0 ; r=2/w=0 : Cached
        KRegister local_0 = frame.getLocal(0);
         // local_2 2 ; r=1/w=1 : Cached
        int local_2;
         // local_3 3 ; r=1/w=1 : Cached
        int local_3;
         // local_4 4 ; r=0/w=1 : NotCached
         // local_5 5 ; r=0/w=1 : NotCached
         // *********[0] ALOAD(0)
         // **REMOVED Substitution** s0 = local_0;
         // *********[1] ARRAYLENGTH
         // **REMOVED Substitution** s0 = new KInteger(c_memman.getArraySize(((KReference)local_0)));
         // *********[2] ISTORE(2)
        local_2 = c_memman.getArraySize(((KReference)local_0));
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
         // *********[7] ISTORE(3)
        local_3 = c_memman.getArraySize(c_memman.getReferenceArray(((KReference)local_0),0));
         // *********[8] ILOAD(3)
         // **REMOVED Substitution** s0 = new KInteger(local_3);
         // *********[9] ILOAD(2)
         // **REMOVED Substitution** s1 = new KInteger(local_2);
         // *********[10] INVOKE_HOST(java.lang.Math.min(II)I)
         // **REMOVED Substitution** m_v2 = local_2;
         // **REMOVED Substitution** m_v = local_3;
         // **REMOVED Substitution** s0 = new KInteger(Math.min(local_3,local_2));
         // *********[11] ISTORE(4)
        frame.setLocal(4,new KInteger(Math.min(local_3,local_2)));
         // *********[12] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[13] ISTORE(5)
        frame.setLocal(5,KInteger.ZERO);
         // *********[14] GOTO(157)
        frame.setLocal(2,new KInteger(local_2));
        frame.setLocal(3,new KInteger(local_3));
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[2] ISTORE(2)
         // *********[3] ALOAD(0)
         // *********[4] ICONST_0(Integer{0})
         // *********[5] AALOAD
         // *********[6] ARRAYLENGTH
         // *********[7] ISTORE(3)
         // *********[8] ILOAD(3)
         // *********[9] ILOAD(2)
         // *********[10] INVOKE_HOST(java.lang.Math.min(II)I)
         // *********[11] ISTORE(4)
         // *********[12] ICONST_0(Integer{0})
         // *********[13] ISTORE(5)
         // *********[14] GOTO(157)
        c_label = instructions[22];
      }
}
