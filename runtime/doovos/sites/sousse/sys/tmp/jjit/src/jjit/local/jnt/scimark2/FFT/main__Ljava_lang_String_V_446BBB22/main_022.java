package jjit.local.jnt.scimark2.FFT.main__Ljava_lang_String_V_446BBB22;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.FFT
 * main([Ljava/lang/String;)V
 * [count=2] [39] ILOAD(2) [40] INVOKESTATIC(jnt.scimark2.FFT,makeRandom(I)[D)
 */
public final class main_022 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CFFT = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[39] ILOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[40] INVOKESTATIC(jnt.scimark2.FFT,makeRandom(I)[D)
        regs = new KRegister[1];
        regs[0] = frame.getLocal(2);
        if(m_mth == null){
          m_mth = c_CFFT.getMethodBySignature("makeRandom(I)[D");
        }
        frame.setProgramCounter(22);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[39] ILOAD(2)
         // *********[40] INVOKESTATIC(jnt.scimark2.FFT,makeRandom(I)[D)
        c_repo = process.getClassRepository();
        c_CFFT = c_repo.getClassByName("jnt.scimark2.FFT");
      }
}
