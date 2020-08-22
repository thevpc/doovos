package jjit.local.jnt.scimark2.LU.factor___D_I_I_722247B8;
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
 * [count=13] [84] DCONST_1(Double{1.0}) [85] ALOAD(0) [86] ILOAD(5) [87] AALOAD [88] ILOAD(5) [89] DALOAD [90] DDIV [91] DSTORE(10) [92] ILOAD(5) [93] ICONST_1(Integer{1}) [94] IADD [95] ISTORE(12) [96] GOTO(107)
 */
public final class factor_012 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** double m_d;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_5 5 ; r=3/w=0 : Cached
        int local_5 = frame.getLocal(5).intValue();
         // local_10 10 ; r=0/w=1 : NotCached
         // local_12 12 ; r=0/w=1 : NotCached
         // *********[84] DCONST_1(Double{1.0})
         // **REMOVED Substitution** s0 = DONE;
         // *********[85] ALOAD(0)
         // **REMOVED Substitution** s1 = frame.getLocal(0);
         // *********[86] ILOAD(5)
         // **REMOVED Substitution** s2 = new KInteger(local_5);
         // *********[87] AALOAD
         // **REMOVED Substitution** index = local_5;
         // **REMOVED Substitution** ref = ((KReference)frame.getLocal(0));
         // **REMOVED Substitution** s1_ref = c_memman.getReferenceArray(((KReference)frame.getLocal(0)),local_5);
         // *********[88] ILOAD(5)
         // **REMOVED Substitution** s2 = new KInteger(local_5);
         // *********[89] DALOAD
         // **REMOVED Substitution** index = local_5;
         // **REMOVED Substitution** s1 = new KDouble(c_memman.getDoubleArray(c_memman.getReferenceArray(((KReference)frame.getLocal(0)),local_5),local_5));
         // *********[90] DDIV
         // **REMOVED Substitution** m_d = c_memman.getDoubleArray(c_memman.getReferenceArray(((KReference)frame.getLocal(0)),local_5),local_5);
         // **REMOVED Substitution** s0 = new KDouble((1.0D / c_memman.getDoubleArray(c_memman.getReferenceArray(((KReference)frame.getLocal(0)),local_5),local_5)));
         // *********[91] DSTORE(10)
        frame.setLocal(10,new KDouble((1.0D / c_memman.getDoubleArray(c_memman.getReferenceArray(((KReference)frame.getLocal(0)),local_5),local_5))));
         // *********[92] ILOAD(5)
         // **REMOVED Substitution** s0 = new KInteger(local_5);
         // *********[93] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[94] IADD
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s0 = new KInteger((local_5 + 1));
         // *********[95] ISTORE(12)
        frame.setLocal(12,new KInteger((local_5 + 1)));
         // *********[96] GOTO(107)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[84] DCONST_1(Double{1.0})
         // *********[85] ALOAD(0)
         // *********[86] ILOAD(5)
         // *********[87] AALOAD
        c_memman = process.getMemoryManager();
         // *********[88] ILOAD(5)
         // *********[89] DALOAD
         // *********[90] DDIV
         // *********[91] DSTORE(10)
         // *********[92] ILOAD(5)
         // *********[93] ICONST_1(Integer{1})
         // *********[94] IADD
         // *********[95] ISTORE(12)
         // *********[96] GOTO(107)
        c_label = instructions[13];
      }
}
