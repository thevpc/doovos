package jjit.local.jnt.scimark2.commandline.main__Ljava_lang_String_V_6A6C6E6C;
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
 * jnt.scimark2.commandline
 * main([Ljava/lang/String;)V
 * [count=3] [249] GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;) [250] LDC(41->" ERROR, INVALID NUMERICAL RESULT!") [251] INVOKEVIRTUAL(java.io.PrintStream,println(Ljava/lang/String;)V)
 */
public final class main_089 extends JJITAbstractInstruction implements Cloneable{
      private KField c_out = null;
      private KClassRepository c_repo;
      private static KReference R41 = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // *********[249] GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
        if(c_out == null){
          c_out = c_repo.getClassByName("java.lang.System").getField("out",true);
        }
         // **REMOVED Substitution** s0 = c_out.getStaticValue();
         // *********[250] LDC(41->" ERROR, INVALID NUMERICAL RESULT!")
         // **REMOVED Substitution** s1_ref = R41;
         // *********[251] INVOKEVIRTUAL(java.io.PrintStream,println(Ljava/lang/String;)V)
        regs = new KRegister[2];
        regs[1] = R41;
        ref = ((KReference)c_out.getStaticValue());
        regs[0] = ref;
        frame.setProgramCounter(89);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("println(Ljava/lang/String;)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("println(Ljava/lang/String;)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[249] GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
        c_repo = process.getClassRepository();
         // *********[250] LDC(41->" ERROR, INVALID NUMERICAL RESULT!")
        R41 = ((KReference)constants[41]);
         // *********[251] INVOKEVIRTUAL(java.io.PrintStream,println(Ljava/lang/String;)V)
        c_memman = process.getMemoryManager();
      }
}
