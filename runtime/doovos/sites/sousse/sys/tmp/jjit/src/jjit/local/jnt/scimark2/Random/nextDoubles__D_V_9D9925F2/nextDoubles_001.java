package jjit.local.jnt.scimark2.Random.nextDoubles__D_V_9D9925F2;
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
 * jnt.scimark2.Random
 * nextDoubles([D)V
 * [count=10] [0] ALOAD(1) [1] ARRAYLENGTH [2] ISTORE(2) [3] ILOAD(2) [4] ICONST_3(Integer{3}) [5] IAND [6] ISTORE(3) [7] ALOAD(0) [8] GETFIELD(jnt.scimark2.Random,haveRange,Z) [9] IFEQ(82)
 */
public final class nextDoubles_001 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private KField c_haveRange = null;
      private KClassRepository c_repo;
      private KClass c_CRandom = null;
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
        boolean jump;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=1 : Cached
        int local_2;
         // local_3 3 ; r=0/w=1 : NotCached
         // *********[0] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[1] ARRAYLENGTH
         // **REMOVED Substitution** s0 = new KInteger(c_memman.getArraySize(((KReference)frame.getLocal(1))));
         // *********[2] ISTORE(2)
        local_2 = c_memman.getArraySize(((KReference)frame.getLocal(1)));
         // *********[3] ILOAD(2)
         // **REMOVED Substitution** s0 = new KInteger(local_2);
         // *********[4] ICONST_3(Integer{3})
         // **REMOVED Substitution** s1 = ITHREE;
         // *********[5] IAND
         // **REMOVED Substitution** index = 3;
         // **REMOVED Substitution** s0 = new KInteger((local_2 & 3));
         // *********[6] ISTORE(3)
        frame.setLocal(3,new KInteger((local_2 & 3)));
         // *********[7] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[8] GETFIELD(jnt.scimark2.Random,haveRange,Z)
         // **REMOVED Substitution** s0 = c_haveRange.getInstanceValue(((KReference)frame.getLocal(0)));
         // *********[9] IFEQ(82)
         // **REMOVED Substitution** index = c_haveRange.getInstanceValue(((KReference)frame.getLocal(0))).intValue();
        jump = c_haveRange.getInstanceValue(((KReference)frame.getLocal(0))).intValue() == 0;
        frame.setLocal(2,new KInteger(local_2));
        return ((jump)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(1)
         // *********[1] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[2] ISTORE(2)
         // *********[3] ILOAD(2)
         // *********[4] ICONST_3(Integer{3})
         // *********[5] IAND
         // *********[6] ISTORE(3)
         // *********[7] ALOAD(0)
         // *********[8] GETFIELD(jnt.scimark2.Random,haveRange,Z)
        c_repo = process.getClassRepository();
        c_CRandom = c_repo.getClassByName("jnt.scimark2.Random");
        c_haveRange = c_CRandom.getField("haveRange",true);
         // *********[9] IFEQ(82)
        c_next = instructions[(index + 1)];
        c_label = instructions[13];
      }
}
