package jjit.local.jnt.Bench.Bench.getSegmentValues_I__D_36C3CC1F;
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
 * getSegmentValues(I)[D
 * [count=6] [8] ALOAD(2) [9] ILOAD(3) [10] ALOAD(0) [11] GETFIELD(jnt.Bench.Bench,entries,Ljava/util/Vector;) [12] ILOAD(3) [13] INVOKEVIRTUAL(java.util.Vector,elementAt(I)Ljava/lang/Object;)
 */
public final class getSegmentValues_005 extends JJITAbstractInstruction implements Cloneable{
      private KField c_entries = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // local_3 3 ; r=2/w=0 : Cached
        int local_3 = frame.getLocal(3).intValue();
         // *********[8] ALOAD(2)
        frame.push(frame.getLocal(2));
         // *********[9] ILOAD(3)
        frame.push(new KInteger(local_3));
         // *********[10] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[11] GETFIELD(jnt.Bench.Bench,entries,Ljava/util/Vector;)
         // **REMOVED Substitution** s0_ref = c_entries.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[12] ILOAD(3)
         // **REMOVED Substitution** s1 = new KInteger(local_3);
         // *********[13] INVOKEVIRTUAL(java.util.Vector,elementAt(I)Ljava/lang/Object;)
        regs = new KRegister[2];
        regs[1] = new KInteger(local_3);
        ref = c_entries.getInstanceRef(((KReference)frame.getLocal(0)));
        regs[0] = ref;
        frame.setProgramCounter(5);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("elementAt(I)Ljava/lang/Object;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("elementAt(I)Ljava/lang/Object;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[8] ALOAD(2)
         // *********[9] ILOAD(3)
         // *********[10] ALOAD(0)
         // *********[11] GETFIELD(jnt.Bench.Bench,entries,Ljava/util/Vector;)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_entries = c_CBench.getField("entries",true);
         // *********[12] ILOAD(3)
         // *********[13] INVOKEVIRTUAL(java.util.Vector,elementAt(I)Ljava/lang/Object;)
        c_memman = process.getMemoryManager();
      }
}
