package jjit.local.jnt.Bench.Bench.getEntries___Ljava_lang_String_D1553752;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Bench
 * getEntries()[Ljava/lang/String;
 * [count=5] [3] ANEWARRAY(40) [4] ASTORE(1) [5] ICONST_0(Integer{0}) [6] ISTORE(2) [7] GOTO(18)
 */
public final class getEntries_005 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private KClassRepository c_repo;
      private KClass c_CString = null;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** KProcess process = frame.getProcess();
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** KReference ref;
         // local_1 1 ; r=0/w=1 : NotCached
         // local_2 2 ; r=0/w=1 : NotCached
         // *********[3] ANEWARRAY(40)
         // **REMOVED Substitution** index = frame.popInt();
        if(c_CString == null){
          c_CString = c_repo.getClassByName("java.lang.String");
        }
         // **REMOVED Substitution** s0_ref = c_memman.allocRefArray(c_CString,frame.popInt());
         // *********[4] ASTORE(1)
        frame.setLocal(1,c_memman.allocRefArray(c_CString,frame.popInt()));
         // *********[5] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[6] ISTORE(2)
        frame.setLocal(2,KInteger.ZERO);
         // *********[7] GOTO(18)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[3] ANEWARRAY(40)
        c_memman = process.getMemoryManager();
        c_repo = process.getClassRepository();
         // *********[4] ASTORE(1)
         // *********[5] ICONST_0(Integer{0})
         // *********[6] ISTORE(2)
         // *********[7] GOTO(18)
        c_label = instructions[7];
      }
}
