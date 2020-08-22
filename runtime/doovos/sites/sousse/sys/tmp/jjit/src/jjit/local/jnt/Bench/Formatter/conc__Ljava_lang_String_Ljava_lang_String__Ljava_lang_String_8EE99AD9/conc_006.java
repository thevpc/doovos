package jjit.local.jnt.Bench.Formatter.conc__Ljava_lang_String_Ljava_lang_String__Ljava_lang_String_8EE99AD9;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Formatter
 * conc([Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;
 * [count=8] [14] ALOAD(1) [15] ICONST_0(Integer{0}) [16] ALOAD(2) [17] ALOAD(0) [18] ARRAYLENGTH [19] ALOAD(1) [20] ARRAYLENGTH [21] INVOKESTATIC(java.lang.System,arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V)
 */
public final class conc_006 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger IZERO = KInteger.ZERO;
      private KMemoryManager c_memman;
      private KClassRepository c_repo;
      private KClass c_CSystem = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s4;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=2/w=0 : Cached
        KRegister local_1 = frame.getLocal(1);
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[14] ALOAD(1)
         // **REMOVED Substitution** s0 = local_1;
         // *********[15] ICONST_0(Integer{0})
         // **REMOVED Substitution** s1 = IZERO;
         // *********[16] ALOAD(2)
         // **REMOVED Substitution** s2 = frame.getLocal(2);
         // *********[17] ALOAD(0)
         // **REMOVED Substitution** s3 = frame.getLocal(0);
         // *********[18] ARRAYLENGTH
         // **REMOVED Substitution** s3 = new KInteger(c_memman.getArraySize(((KReference)frame.getLocal(0))));
         // *********[19] ALOAD(1)
         // **REMOVED Substitution** s4 = local_1;
         // *********[20] ARRAYLENGTH
         // **REMOVED Substitution** s4 = new KInteger(c_memman.getArraySize(((KReference)local_1)));
         // *********[21] INVOKESTATIC(java.lang.System,arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V)
        regs = new KRegister[5];
        regs[4] = new KInteger(c_memman.getArraySize(((KReference)local_1)));
        regs[3] = new KInteger(c_memman.getArraySize(((KReference)frame.getLocal(0))));
        regs[2] = frame.getLocal(2);
        regs[1] = IZERO;
        regs[0] = local_1;
        if(c_CSystem == null){
          c_CSystem = c_repo.getClassByName("java.lang.System");
        }
        if(m_mth == null){
          m_mth = c_CSystem.getMethodBySignature("arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V");
        }
        frame.setProgramCounter(6);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[14] ALOAD(1)
         // *********[15] ICONST_0(Integer{0})
         // *********[16] ALOAD(2)
         // *********[17] ALOAD(0)
         // *********[18] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[19] ALOAD(1)
         // *********[20] ARRAYLENGTH
         // *********[21] INVOKESTATIC(java.lang.System,arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V)
        c_repo = process.getClassRepository();
      }
}
