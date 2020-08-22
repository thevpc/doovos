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
 * [count=5] [253] GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;) [254] ALOAD(8) [255] ICONST_5(Integer{5}) [256] DALOAD [257] INVOKEVIRTUAL(java.io.PrintStream,println(D)V)
 */
public final class main_091 extends JJITAbstractInstruction implements Cloneable{
      private KField c_out = null;
      private KClassRepository c_repo;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** int index = 0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_8 8 ; r=1/w=0 : NotCached
         // *********[253] GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
        if(c_out == null){
          c_out = c_repo.getClassByName("java.lang.System").getField("out",true);
        }
         // **REMOVED Substitution** s0 = c_out.getStaticValue();
         // *********[254] ALOAD(8)
         // **REMOVED Substitution** s1 = frame.getLocal(8);
         // *********[255] ICONST_5(Integer{5})
         // **REMOVED Substitution** s2 = IFIVE;
         // *********[256] DALOAD
         // **REMOVED Substitution** index = 5;
         // **REMOVED Substitution** s1 = new KDouble(c_memman.getDoubleArray(((KReference)frame.getLocal(8)),5));
         // *********[257] INVOKEVIRTUAL(java.io.PrintStream,println(D)V)
        regs = new KRegister[2];
        regs[1] = new KDouble(c_memman.getDoubleArray(((KReference)frame.getLocal(8)),5));
        ref = ((KReference)c_out.getStaticValue());
        regs[0] = ref;
        frame.setProgramCounter(91);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("println(D)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("println(D)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[253] GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
        c_repo = process.getClassRepository();
         // *********[254] ALOAD(8)
         // *********[255] ICONST_5(Integer{5})
         // *********[256] DALOAD
        c_memman = process.getMemoryManager();
         // *********[257] INVOKEVIRTUAL(java.io.PrintStream,println(D)V)
      }
}
