package jjit.local.jnt.Bench.Bench.parseDescriptor_Ljava_io_InputStream_V_38C1A4B9;
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
 * parseDescriptor(Ljava/io/InputStream;)V
 * [count=7] [26] ALOAD(2) [27] GETFIELD(java.io.StreamTokenizer,sval,Ljava/lang/String;) [28] ASTORE(3) [29] ALOAD(0) [30] ALOAD(2) [31] BIPUSH(61) [32] INVOKEVIRTUAL(jnt.Bench.Bench,getPunct(Ljava/io/StreamTokenizer;C)V)
 */
public final class parseDescriptor_011 extends JJITAbstractInstruction implements Cloneable{
      private KField c_sval = null;
      private KClassRepository c_repo;
      private static final KInteger I61 = new KInteger(61);
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_2 2 ; r=2/w=0 : Cached
        KRegister local_2 = frame.getLocal(2);
         // local_3 3 ; r=0/w=1 : NotCached
         // *********[26] ALOAD(2)
         // **REMOVED Substitution** s0 = local_2;
         // *********[27] GETFIELD(java.io.StreamTokenizer,sval,Ljava/lang/String;)
        if(c_sval == null){
          c_sval = c_repo.getClassByName("java.io.StreamTokenizer").getField("sval",true);
        }
         // **REMOVED Substitution** s0 = c_sval.getInstanceValue(((KReference)local_2));
         // *********[28] ASTORE(3)
        frame.setLocal(3,c_sval.getInstanceValue(((KReference)local_2)));
         // *********[29] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[30] ALOAD(2)
         // **REMOVED Substitution** s1 = local_2;
         // *********[31] BIPUSH(61)
         // **REMOVED Substitution** s2 = I61;
         // *********[32] INVOKEVIRTUAL(jnt.Bench.Bench,getPunct(Ljava/io/StreamTokenizer;C)V)
        regs = new KRegister[3];
        regs[2] = I61;
        regs[1] = local_2;
        ref = ((KReference)frame.getLocal(0));
        regs[0] = ref;
        frame.setProgramCounter(11);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getPunct(Ljava/io/StreamTokenizer;C)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getPunct(Ljava/io/StreamTokenizer;C)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[26] ALOAD(2)
         // *********[27] GETFIELD(java.io.StreamTokenizer,sval,Ljava/lang/String;)
        c_repo = process.getClassRepository();
         // *********[28] ASTORE(3)
         // *********[29] ALOAD(0)
         // *********[30] ALOAD(2)
         // *********[31] BIPUSH(61)
         // *********[32] INVOKEVIRTUAL(jnt.Bench.Bench,getPunct(Ljava/io/StreamTokenizer;C)V)
        c_memman = process.getMemoryManager();
      }
}
