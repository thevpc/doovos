package jjit.local.jnt.Bench.Bench.insertEntry__D_V_B1D8381D;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Bench
 * insertEntry([D)V
 * [count=8] [13] ISTORE(3) [14] ALOAD(1) [15] ILOAD(2) [16] DALOAD [17] DSTORE(4) [18] ALOAD(0) [19] GETFIELD(jnt.Bench.Bench,ascending,Z) [20] IFEQ(49)
 */
public final class insertEntry_006 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private KField c_ascending = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // local_3 3 ; r=0/w=1 : NotCached
         // local_4 4 ; r=0/w=1 : NotCached
         // *********[13] ISTORE(3)
        frame.setLocal(3,new KInteger(frame.popInt()));
         // *********[14] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[15] ILOAD(2)
         // **REMOVED Substitution** s1 = frame.getLocal(2);
         // *********[16] DALOAD
         // **REMOVED Substitution** index = frame.getLocal(2).intValue();
         // **REMOVED Substitution** s0 = new KDouble(c_memman.getDoubleArray(((KReference)frame.getLocal(1)),frame.getLocal(2).intValue()));
         // *********[17] DSTORE(4)
        frame.setLocal(4,new KDouble(c_memman.getDoubleArray(((KReference)frame.getLocal(1)),frame.getLocal(2).intValue())));
         // *********[18] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[19] GETFIELD(jnt.Bench.Bench,ascending,Z)
         // **REMOVED Substitution** s0 = c_ascending.getInstanceValue(((KReference)frame.getLocal(0)));
         // *********[20] IFEQ(49)
         // **REMOVED Substitution** index = c_ascending.getInstanceValue(((KReference)frame.getLocal(0))).intValue();
         // **REMOVED Substitution** jump = c_ascending.getInstanceValue(((KReference)frame.getLocal(0))).intValue() == 0;
        return ((c_ascending.getInstanceValue(((KReference)frame.getLocal(0))).intValue() == 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[13] ISTORE(3)
         // *********[14] ALOAD(1)
         // *********[15] ILOAD(2)
         // *********[16] DALOAD
        c_memman = process.getMemoryManager();
         // *********[17] DSTORE(4)
         // *********[18] ALOAD(0)
         // *********[19] GETFIELD(jnt.Bench.Bench,ascending,Z)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_ascending = c_CBench.getField("ascending",true);
         // *********[20] IFEQ(49)
        c_next = instructions[(index + 1)];
        c_label = instructions[13];
      }
}
