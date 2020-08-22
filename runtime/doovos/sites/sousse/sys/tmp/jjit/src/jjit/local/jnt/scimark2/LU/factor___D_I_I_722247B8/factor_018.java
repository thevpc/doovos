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
 * [count=12] [137] ALOAD(11) [138] ILOAD(15) [139] DUP2Type1 [140] DALOAD [141] DLOAD(13) [142] ALOAD(12) [143] ILOAD(15) [144] DALOAD [145] DMUL [146] DSUB [147] DASTORE [148] IINC(15,1)
 */
public final class factor_018 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s5;
         // **REMOVED Unused Var** KRegister s4;
        KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
         // **REMOVED Unused Var** KRegister reg;
         // **REMOVED Unused Var** KRegister reg2;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** double m_d;
         // **REMOVED Unused Var** double m_d2;
         // **REMOVED Unused Var** double m_d3;
         // local_11 11 ; r=1/w=0 : NotCached
         // local_12 12 ; r=1/w=0 : NotCached
         // local_13 13 ; r=1/w=0 : NotCached
         // local_15 15 ; r=3/w=1 : Cached
        int local_15 = frame.getLocal(15).intValue();
         // *********[137] ALOAD(11)
        s0 = frame.getLocal(11);
         // *********[138] ILOAD(15)
         // **REMOVED Substitution** s1 = new KInteger(local_15);
         // *********[139] DUP2Type1
         // **REMOVED Substitution** reg = new KInteger(local_15);
         // **REMOVED Substitution** reg2 = s0;
         // **REMOVED Substitution** s1 = new KInteger(local_15);
         // **REMOVED Substitution** s2 = s0;
         // **REMOVED Substitution** s3 = new KInteger(local_15);
         // *********[140] DALOAD
         // **REMOVED Substitution** index = local_15;
         // **REMOVED Substitution** s2 = new KDouble(c_memman.getDoubleArray(((KReference)s0),local_15));
         // *********[141] DLOAD(13)
         // **REMOVED Substitution** s3 = frame.getLocal(13);
         // *********[142] ALOAD(12)
         // **REMOVED Substitution** s4 = frame.getLocal(12);
         // *********[143] ILOAD(15)
         // **REMOVED Substitution** s5 = new KInteger(local_15);
         // *********[144] DALOAD
         // **REMOVED Substitution** index = local_15;
         // **REMOVED Substitution** s4 = new KDouble(c_memman.getDoubleArray(((KReference)frame.getLocal(12)),local_15));
         // *********[145] DMUL
         // **REMOVED Substitution** m_d = c_memman.getDoubleArray(((KReference)frame.getLocal(12)),local_15);
         // **REMOVED Substitution** s3 = new KDouble((frame.getLocal(13).doubleValue() * c_memman.getDoubleArray(((KReference)frame.getLocal(12)),local_15)));
         // *********[146] DSUB
         // **REMOVED Substitution** m_d2 = (frame.getLocal(13).doubleValue() * c_memman.getDoubleArray(((KReference)frame.getLocal(12)),local_15));
         // **REMOVED Substitution** s2 = new KDouble((c_memman.getDoubleArray(((KReference)s0),local_15) - (frame.getLocal(13).doubleValue() * c_memman.getDoubleArray(((KReference)frame.getLocal(12)),local_15))));
         // *********[147] DASTORE
         // **REMOVED Substitution** m_d3 = (c_memman.getDoubleArray(((KReference)s0),local_15) - (frame.getLocal(13).doubleValue() * c_memman.getDoubleArray(((KReference)frame.getLocal(12)),local_15)));
         // **REMOVED Substitution** index = local_15;
        c_memman.setDoubleArray(((KReference)s0),local_15,(c_memman.getDoubleArray(((KReference)s0),local_15) - (frame.getLocal(13).doubleValue() * c_memman.getDoubleArray(((KReference)frame.getLocal(12)),local_15))));
         // *********[148] IINC(15,1)
         // **REMOVED Substitution** local_15 = (local_15 + 1);
        frame.setLocal(15,new KInteger((local_15 + 1)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[137] ALOAD(11)
         // *********[138] ILOAD(15)
         // *********[139] DUP2Type1
         // *********[140] DALOAD
        c_memman = process.getMemoryManager();
         // *********[141] DLOAD(13)
         // *********[142] ALOAD(12)
         // *********[143] ILOAD(15)
         // *********[144] DALOAD
         // *********[145] DMUL
         // *********[146] DSUB
         // *********[147] DASTORE
         // *********[148] IINC(15,1)
        c_next = instructions[(index + 1)];
      }
}
