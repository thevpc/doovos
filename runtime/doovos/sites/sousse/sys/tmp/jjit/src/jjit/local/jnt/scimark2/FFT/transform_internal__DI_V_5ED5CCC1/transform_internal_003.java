package jjit.local.jnt.scimark2.FFT.transform_internal__DI_V_5ED5CCC1;
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
 * jnt.scimark2.FFT
 * transform_internal([DI)V
 * [count=8] [4] ALOAD(0) [5] ARRAYLENGTH [6] ICONST_2(Integer{2}) [7] IDIV [8] ISTORE(2) [9] ILOAD(2) [10] ICONST_1(Integer{1}) [11] IF_ICMPNE(13)
 */
public final class transform_internal_003 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=1 : Cached
        int local_2;
         // *********[4] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[5] ARRAYLENGTH
         // **REMOVED Substitution** s0 = new KInteger(c_memman.getArraySize(((KReference)frame.getLocal(0))));
         // *********[6] ICONST_2(Integer{2})
         // **REMOVED Substitution** s1 = ITWO;
         // *********[7] IDIV
         // **REMOVED Substitution** index = 2;
         // **REMOVED Substitution** s0 = new KInteger((c_memman.getArraySize(((KReference)frame.getLocal(0))) / 2));
         // *********[8] ISTORE(2)
        local_2 = (c_memman.getArraySize(((KReference)frame.getLocal(0))) / 2);
         // *********[9] ILOAD(2)
         // **REMOVED Substitution** s0 = new KInteger(local_2);
         // *********[10] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[11] IF_ICMPNE(13)
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** jump = local_2 != 1;
        frame.setLocal(2,new KInteger(local_2));
        return ((local_2 != 1)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[4] ALOAD(0)
         // *********[5] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[6] ICONST_2(Integer{2})
         // *********[7] IDIV
         // *********[8] ISTORE(2)
         // *********[9] ILOAD(2)
         // *********[10] ICONST_1(Integer{1})
         // *********[11] IF_ICMPNE(13)
        c_next = instructions[(index + 1)];
        c_label = instructions[4];
      }
}
