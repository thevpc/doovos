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
 * [count=9] [11] DCONST_0(Double{0.0}) [12] DSTORE(6) [13] ALOAD(0) [14] ILOAD(5) [15] AALOAD [16] ASTORE(8) [17] ICONST_0(Integer{0}) [18] ISTORE(9) [19] GOTO(31)
 */
public final class matvec_002 extends JJITAbstractInstruction implements Cloneable{
      private static final KDouble DZERO = KDouble.ZERO;
      private KMemoryManager c_memman;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** KReference ref;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_5 5 ; r=1/w=0 : NotCached
         // local_6 6 ; r=0/w=1 : NotCached
         // local_8 8 ; r=0/w=1 : NotCached
         // local_9 9 ; r=0/w=1 : NotCached
         // *********[11] DCONST_0(Double{0.0})
         // **REMOVED Substitution** s0 = DZERO;
         // *********[12] DSTORE(6)
        frame.setLocal(6,DZERO);
         // *********[13] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[14] ILOAD(5)
         // **REMOVED Substitution** s1 = frame.getLocal(5);
         // *********[15] AALOAD
         // **REMOVED Substitution** index = frame.getLocal(5).intValue();
         // **REMOVED Substitution** ref = ((KReference)frame.getLocal(0));
         // **REMOVED Substitution** s0_ref = c_memman.getReferenceArray(((KReference)frame.getLocal(0)),frame.getLocal(5).intValue());
         // *********[16] ASTORE(8)
        frame.setLocal(8,c_memman.getReferenceArray(((KReference)frame.getLocal(0)),frame.getLocal(5).intValue()));
         // *********[17] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[18] ISTORE(9)
        frame.setLocal(9,KInteger.ZERO);
         // *********[19] GOTO(31)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[11] DCONST_0(Double{0.0})
         // *********[12] DSTORE(6)
         // *********[13] ALOAD(0)
         // *********[14] ILOAD(5)
         // *********[15] AALOAD
        c_memman = process.getMemoryManager();
         // *********[16] ASTORE(8)
         // *********[17] ICONST_0(Integer{0})
         // *********[18] ISTORE(9)
         // *********[19] GOTO(31)
        c_label = instructions[3];
      }
}
