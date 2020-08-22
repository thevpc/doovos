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
 * [count=14] [15] ILOAD(5) [16] ISTORE(6) [17] ALOAD(0) [18] ILOAD(5) [19] AALOAD [20] ILOAD(5) [21] DALOAD [22] INVOKE_HOST(java.lang.Math.abs(D)D) [23] DSTORE(7) [24] ILOAD(5) [25] ICONST_1(Integer{1}) [26] IADD [27] ISTORE(9) [28] GOTO(45)
 */
public final class factor_002 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KRegister[] regs = null;
         // **REMOVED Unused Var** double m_v;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_5 5 ; r=4/w=0 : Cached
        int local_5 = frame.getLocal(5).intValue();
         // local_6 6 ; r=0/w=1 : NotCached
         // local_7 7 ; r=0/w=1 : NotCached
         // local_9 9 ; r=0/w=1 : NotCached
         // *********[15] ILOAD(5)
         // **REMOVED Substitution** s0 = new KInteger(local_5);
         // *********[16] ISTORE(6)
        frame.setLocal(6,new KInteger(local_5));
         // *********[17] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[18] ILOAD(5)
         // **REMOVED Substitution** s1 = new KInteger(local_5);
         // *********[19] AALOAD
         // **REMOVED Substitution** index = local_5;
         // **REMOVED Substitution** ref = ((KReference)frame.getLocal(0));
         // **REMOVED Substitution** s0_ref = c_memman.getReferenceArray(((KReference)frame.getLocal(0)),local_5);
         // *********[20] ILOAD(5)
         // **REMOVED Substitution** s1 = new KInteger(local_5);
         // *********[21] DALOAD
         // **REMOVED Substitution** index = local_5;
         // **REMOVED Substitution** s0 = new KDouble(c_memman.getDoubleArray(c_memman.getReferenceArray(((KReference)frame.getLocal(0)),local_5),local_5));
         // *********[22] INVOKE_HOST(java.lang.Math.abs(D)D)
         // **REMOVED Substitution** m_v = c_memman.getDoubleArray(c_memman.getReferenceArray(((KReference)frame.getLocal(0)),local_5),local_5);
         // **REMOVED Substitution** s0 = new KDouble(Math.abs(c_memman.getDoubleArray(c_memman.getReferenceArray(((KReference)frame.getLocal(0)),local_5),local_5)));
         // *********[23] DSTORE(7)
        frame.setLocal(7,new KDouble(Math.abs(c_memman.getDoubleArray(c_memman.getReferenceArray(((KReference)frame.getLocal(0)),local_5),local_5))));
         // *********[24] ILOAD(5)
         // **REMOVED Substitution** s0 = new KInteger(local_5);
         // *********[25] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[26] IADD
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s0 = new KInteger((local_5 + 1));
         // *********[27] ISTORE(9)
        frame.setLocal(9,new KInteger((local_5 + 1)));
         // *********[28] GOTO(45)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[15] ILOAD(5)
         // *********[16] ISTORE(6)
         // *********[17] ALOAD(0)
         // *********[18] ILOAD(5)
         // *********[19] AALOAD
        c_memman = process.getMemoryManager();
         // *********[20] ILOAD(5)
         // *********[21] DALOAD
         // *********[22] INVOKE_HOST(java.lang.Math.abs(D)D)
         // *********[23] DSTORE(7)
         // *********[24] ILOAD(5)
         // *********[25] ICONST_1(Integer{1})
         // *********[26] IADD
         // *********[27] ISTORE(9)
         // *********[28] GOTO(45)
        c_label = instructions[5];
      }
}
