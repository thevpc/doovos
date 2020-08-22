package jjit.local.jnt.Bench.Formatter.format__DI__Ljava_lang_String_758E00BB;
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
 * jnt.Bench.Formatter
 * format([DI)[Ljava/lang/String;
 * [count=5] [2] ANEWARRAY(3) [3] ASTORE(2) [4] ICONST_0(Integer{0}) [5] ISTORE(3) [6] GOTO(16)
 */
public final class format_003 extends JJITAbstractInstruction implements Cloneable{
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
         // local_2 2 ; r=0/w=1 : NotCached
         // local_3 3 ; r=0/w=1 : NotCached
         // *********[2] ANEWARRAY(3)
         // **REMOVED Substitution** index = frame.popInt();
        if(c_CString == null){
          c_CString = c_repo.getClassByName("java.lang.String");
        }
         // **REMOVED Substitution** s0_ref = c_memman.allocRefArray(c_CString,frame.popInt());
         // *********[3] ASTORE(2)
        frame.setLocal(2,c_memman.allocRefArray(c_CString,frame.popInt()));
         // *********[4] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[5] ISTORE(3)
        frame.setLocal(3,KInteger.ZERO);
         // *********[6] GOTO(16)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[2] ANEWARRAY(3)
        c_memman = process.getMemoryManager();
        c_repo = process.getClassRepository();
         // *********[3] ASTORE(2)
         // *********[4] ICONST_0(Integer{0})
         // *********[5] ISTORE(3)
         // *********[6] GOTO(16)
        c_label = instructions[5];
      }
}
