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
 * [count=3] [83] ALOAD(0) [84] GETFIELD(jnt.Bench.Bench,specpos,I) [85] INVOKEVIRTUAL(java.util.Vector,insertElementAt(Ljava/lang/Object;I)V)
 */
public final class insertEntry_021 extends JJITAbstractInstruction implements Cloneable{
      private KField c_specpos = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[83] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[84] GETFIELD(jnt.Bench.Bench,specpos,I)
         // **REMOVED Substitution** s0 = new KInteger(c_specpos.getInstanceInt(((KReference)frame.getLocal(0))));
         // *********[85] INVOKEVIRTUAL(java.util.Vector,insertElementAt(Ljava/lang/Object;I)V)
        regs = new KRegister[3];
        regs[2] = new KInteger(c_specpos.getInstanceInt(((KReference)frame.getLocal(0))));
        regs[1] = frame.pop();
        ref = frame.popRef();
        regs[0] = ref;
        frame.setProgramCounter(21);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("insertElementAt(Ljava/lang/Object;I)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("insertElementAt(Ljava/lang/Object;I)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[83] ALOAD(0)
         // *********[84] GETFIELD(jnt.Bench.Bench,specpos,I)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_specpos = c_CBench.getField("specpos",true);
         // *********[85] INVOKEVIRTUAL(java.util.Vector,insertElementAt(Ljava/lang/Object;I)V)
        c_memman = process.getMemoryManager();
      }
}
