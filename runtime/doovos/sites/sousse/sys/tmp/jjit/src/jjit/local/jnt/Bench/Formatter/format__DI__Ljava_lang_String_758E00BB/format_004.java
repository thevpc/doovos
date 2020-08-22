package jjit.local.jnt.Bench.Formatter.format__DI__Ljava_lang_String_758E00BB;
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
 * format([DI)[Ljava/lang/String;
 * [count=7] [7] ALOAD(2) [8] ILOAD(3) [9] ALOAD(0) [10] ILOAD(3) [11] DALOAD [12] ILOAD(1) [13] INVOKESTATIC(jnt.Bench.Formatter,format(DI)Ljava/lang/String;)
 */
public final class format_004 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private KClassRepository c_repo;
      private KClass c_CFormatter = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // local_3 3 ; r=2/w=0 : Cached
        int local_3 = frame.getLocal(3).intValue();
         // *********[7] ALOAD(2)
        frame.push(frame.getLocal(2));
         // *********[8] ILOAD(3)
        frame.push(new KInteger(local_3));
         // *********[9] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[10] ILOAD(3)
         // **REMOVED Substitution** s1 = new KInteger(local_3);
         // *********[11] DALOAD
         // **REMOVED Substitution** index = local_3;
         // **REMOVED Substitution** s0 = new KDouble(c_memman.getDoubleArray(((KReference)frame.getLocal(0)),local_3));
         // *********[12] ILOAD(1)
         // **REMOVED Substitution** s1 = frame.getLocal(1);
         // *********[13] INVOKESTATIC(jnt.Bench.Formatter,format(DI)Ljava/lang/String;)
        regs = new KRegister[2];
        regs[1] = frame.getLocal(1);
        regs[0] = new KDouble(c_memman.getDoubleArray(((KReference)frame.getLocal(0)),local_3));
        if(m_mth == null){
          m_mth = c_CFormatter.getMethodBySignature("format(DI)Ljava/lang/String;");
        }
        frame.setProgramCounter(4);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[7] ALOAD(2)
         // *********[8] ILOAD(3)
         // *********[9] ALOAD(0)
         // *********[10] ILOAD(3)
         // *********[11] DALOAD
        c_memman = process.getMemoryManager();
         // *********[12] ILOAD(1)
         // *********[13] INVOKESTATIC(jnt.Bench.Formatter,format(DI)Ljava/lang/String;)
        c_repo = process.getClassRepository();
        c_CFormatter = c_repo.getClassByName("jnt.Bench.Formatter");
      }
}
