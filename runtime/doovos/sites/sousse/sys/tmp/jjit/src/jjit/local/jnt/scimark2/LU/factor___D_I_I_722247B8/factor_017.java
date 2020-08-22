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
 * [count=17] [120] ALOAD(0) [121] ILOAD(10) [122] AALOAD [123] ASTORE(11) [124] ALOAD(0) [125] ILOAD(5) [126] AALOAD [127] ASTORE(12) [128] ALOAD(11) [129] ILOAD(5) [130] DALOAD [131] DSTORE(13) [132] ILOAD(5) [133] ICONST_1(Integer{1}) [134] IADD [135] ISTORE(15) [136] GOTO(149)
 */
public final class factor_017 extends JJITAbstractInstruction implements Cloneable{
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
         // local_5 5 ; r=3/w=0 : Cached
        int local_5 = frame.getLocal(5).intValue();
         // local_10 10 ; r=1/w=0 : NotCached
         // local_11 11 ; r=1/w=1 : Cached
        KRegister local_11;
         // local_12 12 ; r=0/w=1 : NotCached
         // local_13 13 ; r=0/w=1 : NotCached
         // local_15 15 ; r=0/w=1 : NotCached
         // *********[120] ALOAD(0)
         // **REMOVED Substitution** s0 = local_0;
         // *********[121] ILOAD(10)
         // **REMOVED Substitution** s1 = frame.getLocal(10);
         // *********[122] AALOAD
         // **REMOVED Substitution** index = frame.getLocal(10).intValue();
         // **REMOVED Substitution** ref = ((KReference)local_0);
         // **REMOVED Substitution** s0_ref = c_memman.getReferenceArray(((KReference)local_0),frame.getLocal(10).intValue());
         // *********[123] ASTORE(11)
        local_11 = c_memman.getReferenceArray(((KReference)local_0),frame.getLocal(10).intValue());
         // *********[124] ALOAD(0)
         // **REMOVED Substitution** s0 = local_0;
         // *********[125] ILOAD(5)
         // **REMOVED Substitution** s1 = new KInteger(local_5);
         // *********[126] AALOAD
         // **REMOVED Substitution** index = local_5;
         // **REMOVED Substitution** ref = ((KReference)local_0);
         // **REMOVED Substitution** s0_ref = c_memman.getReferenceArray(((KReference)local_0),local_5);
         // *********[127] ASTORE(12)
        frame.setLocal(12,c_memman.getReferenceArray(((KReference)local_0),local_5));
         // *********[128] ALOAD(11)
         // **REMOVED Substitution** s0 = local_11;
         // *********[129] ILOAD(5)
         // **REMOVED Substitution** s1 = new KInteger(local_5);
         // *********[130] DALOAD
         // **REMOVED Substitution** index = local_5;
         // **REMOVED Substitution** s0 = new KDouble(c_memman.getDoubleArray(((KReference)local_11),local_5));
         // *********[131] DSTORE(13)
        frame.setLocal(13,new KDouble(c_memman.getDoubleArray(((KReference)local_11),local_5)));
         // *********[132] ILOAD(5)
         // **REMOVED Substitution** s0 = new KInteger(local_5);
         // *********[133] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[134] IADD
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s0 = new KInteger((local_5 + 1));
         // *********[135] ISTORE(15)
        frame.setLocal(15,new KInteger((local_5 + 1)));
         // *********[136] GOTO(149)
        frame.setLocal(11,local_11);
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[120] ALOAD(0)
         // *********[121] ILOAD(10)
         // *********[122] AALOAD
        c_memman = process.getMemoryManager();
         // *********[123] ASTORE(11)
         // *********[124] ALOAD(0)
         // *********[125] ILOAD(5)
         // *********[126] AALOAD
         // *********[127] ASTORE(12)
         // *********[128] ALOAD(11)
         // *********[129] ILOAD(5)
         // *********[130] DALOAD
         // *********[131] DSTORE(13)
         // *********[132] ILOAD(5)
         // *********[133] ICONST_1(Integer{1})
         // *********[134] IADD
         // *********[135] ISTORE(15)
         // *********[136] GOTO(149)
        c_label = instructions[18];
      }
}
