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
 * [count=6] [53] DLOAD(4) [54] ALOAD(0) [55] GETFIELD(jnt.Bench.Bench,entries,Ljava/util/Vector;) [56] ALOAD(0) [57] GETFIELD(jnt.Bench.Bench,specpos,I) [58] INVOKEVIRTUAL(java.util.Vector,elementAt(I)Ljava/lang/Object;)
 */
public final class insertEntry_015 extends JJITAbstractInstruction implements Cloneable{
      private KField c_entries = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private KField c_specpos = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // local_4 4 ; r=1/w=0 : NotCached
         // *********[53] DLOAD(4)
        frame.push(frame.getLocal(4));
         // *********[54] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[55] GETFIELD(jnt.Bench.Bench,entries,Ljava/util/Vector;)
         // **REMOVED Substitution** s0_ref = c_entries.getInstanceRef(this_ref);
         // *********[56] ALOAD(0)
         // **REMOVED Substitution** s1_ref = this_ref;
         // *********[57] GETFIELD(jnt.Bench.Bench,specpos,I)
         // **REMOVED Substitution** s1 = new KInteger(c_specpos.getInstanceInt(this_ref));
         // *********[58] INVOKEVIRTUAL(java.util.Vector,elementAt(I)Ljava/lang/Object;)
        regs = new KRegister[2];
        regs[1] = new KInteger(c_specpos.getInstanceInt(this_ref));
        ref = c_entries.getInstanceRef(this_ref);
        regs[0] = ref;
        frame.setProgramCounter(15);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("elementAt(I)Ljava/lang/Object;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("elementAt(I)Ljava/lang/Object;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[53] DLOAD(4)
         // *********[54] ALOAD(0)
         // *********[55] GETFIELD(jnt.Bench.Bench,entries,Ljava/util/Vector;)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_entries = c_CBench.getField("entries",true);
         // *********[56] ALOAD(0)
         // *********[57] GETFIELD(jnt.Bench.Bench,specpos,I)
        c_specpos = c_CBench.getField("specpos",true);
         // *********[58] INVOKEVIRTUAL(java.util.Vector,elementAt(I)Ljava/lang/Object;)
        c_memman = process.getMemoryManager();
      }
}
