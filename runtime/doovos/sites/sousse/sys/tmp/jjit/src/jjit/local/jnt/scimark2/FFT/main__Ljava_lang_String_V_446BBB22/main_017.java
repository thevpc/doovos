package jjit.local.jnt.scimark2.FFT.main__Ljava_lang_String_V_446BBB22;
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
 * jnt.scimark2.FFT
 * main([Ljava/lang/String;)V
 * [count=4] [24] ALOAD(0) [25] ILOAD(1) [26] AALOAD [27] INVOKESTATIC(java.lang.Integer,parseInt(Ljava/lang/String;)I)
 */
public final class main_017 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private KClassRepository c_repo;
      private KClass c_CInteger = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** KReference ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[24] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[25] ILOAD(1)
         // **REMOVED Substitution** s1 = frame.getLocal(1);
         // *********[26] AALOAD
         // **REMOVED Substitution** index = frame.getLocal(1).intValue();
         // **REMOVED Substitution** ref = ((KReference)frame.getLocal(0));
         // **REMOVED Substitution** s0_ref = c_memman.getReferenceArray(((KReference)frame.getLocal(0)),frame.getLocal(1).intValue());
         // *********[27] INVOKESTATIC(java.lang.Integer,parseInt(Ljava/lang/String;)I)
        regs = new KRegister[1];
        regs[0] = c_memman.getReferenceArray(((KReference)frame.getLocal(0)),frame.getLocal(1).intValue());
        if(c_CInteger == null){
          c_CInteger = c_repo.getClassByName("java.lang.Integer");
        }
        if(m_mth == null){
          m_mth = c_CInteger.getMethodBySignature("parseInt(Ljava/lang/String;)I");
        }
        frame.setProgramCounter(17);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[24] ALOAD(0)
         // *********[25] ILOAD(1)
         // *********[26] AALOAD
        c_memman = process.getMemoryManager();
         // *********[27] INVOKESTATIC(java.lang.Integer,parseInt(Ljava/lang/String;)I)
        c_repo = process.getClassRepository();
      }
}
