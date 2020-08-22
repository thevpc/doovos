package jjit.local.jnt.Bench.Bench.main__Ljava_lang_String_V_8024FB52;
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
 * main([Ljava/lang/String;)V
 * [count=2] [17] GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;) [18] INVOKEVIRTUAL(jnt.Bench.Bench,printMeasurements(Ljava/io/PrintStream;)V)
 */
public final class main_008 extends JJITAbstractInstruction implements Cloneable{
      private KField c_out = null;
      private KClassRepository c_repo;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // *********[17] GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
        if(c_out == null){
          c_out = c_repo.getClassByName("java.lang.System").getField("out",true);
        }
         // **REMOVED Substitution** s0 = c_out.getStaticValue();
         // *********[18] INVOKEVIRTUAL(jnt.Bench.Bench,printMeasurements(Ljava/io/PrintStream;)V)
        regs = new KRegister[2];
        regs[1] = c_out.getStaticValue();
        ref = frame.popRef();
        regs[0] = ref;
        frame.setProgramCounter(8);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("printMeasurements(Ljava/io/PrintStream;)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("printMeasurements(Ljava/io/PrintStream;)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[17] GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
        c_repo = process.getClassRepository();
         // *********[18] INVOKEVIRTUAL(jnt.Bench.Bench,printMeasurements(Ljava/io/PrintStream;)V)
        c_memman = process.getMemoryManager();
      }
}
