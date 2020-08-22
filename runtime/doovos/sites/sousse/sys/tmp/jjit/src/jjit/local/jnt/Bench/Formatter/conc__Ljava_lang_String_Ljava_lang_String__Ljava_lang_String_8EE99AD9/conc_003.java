package jjit.local.jnt.Bench.Formatter.conc__Ljava_lang_String_Ljava_lang_String__Ljava_lang_String_8EE99AD9;
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
 * conc([Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;
 * [count=8] [5] ANEWARRAY(3) [6] ASTORE(2) [7] ALOAD(0) [8] ICONST_0(Integer{0}) [9] ALOAD(2) [10] ICONST_0(Integer{0}) [11] ALOAD(0) [12] ARRAYLENGTH
 */
public final class conc_003 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private KClassRepository c_repo;
      private KClass c_CString = null;
      private static final KInteger IZERO = KInteger.ZERO;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** KProcess process = frame.getProcess();
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** KReference ref;
         // local_0 0 ; r=2/w=0 : Cached
        KRegister local_0 = frame.getLocal(0);
         // local_2 2 ; r=1/w=1 : Cached
        KRegister local_2;
         // *********[5] ANEWARRAY(3)
         // **REMOVED Substitution** index = frame.popInt();
        if(c_CString == null){
          c_CString = c_repo.getClassByName("java.lang.String");
        }
         // **REMOVED Substitution** s0_ref = c_memman.allocRefArray(c_CString,frame.popInt());
         // *********[6] ASTORE(2)
        local_2 = c_memman.allocRefArray(c_CString,frame.popInt());
         // *********[7] ALOAD(0)
        frame.push(local_0);
         // *********[8] ICONST_0(Integer{0})
        frame.push(IZERO);
         // *********[9] ALOAD(2)
        frame.push(local_2);
         // *********[10] ICONST_0(Integer{0})
        frame.push(IZERO);
         // *********[11] ALOAD(0)
         // **REMOVED Substitution** s0 = local_0;
         // *********[12] ARRAYLENGTH
        frame.push(new KInteger(c_memman.getArraySize(((KReference)local_0))));
        frame.setLocal(2,local_2);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[5] ANEWARRAY(3)
        c_memman = process.getMemoryManager();
        c_repo = process.getClassRepository();
         // *********[6] ASTORE(2)
         // *********[7] ALOAD(0)
         // *********[8] ICONST_0(Integer{0})
         // *********[9] ALOAD(2)
         // *********[10] ICONST_0(Integer{0})
         // *********[11] ALOAD(0)
         // *********[12] ARRAYLENGTH
        c_next = instructions[(index + 1)];
      }
}
