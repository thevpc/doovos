package jjit.local.jnt.Bench.SendMail.send_Ljava_lang_StringLjava_lang_StringLjava_lang_StringLjava_lang_StringLjava_lang_String_V_56E49BAB;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.SendMail
 * send(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
 * [count=5] [70] ASTORE(6) [71] NEW(java.io.PrintStream) [72] DUP [73] ALOAD(6) [74] INVOKEVIRTUAL(java.net.Socket,getOutputStream()Ljava/io/OutputStream;)
 */
public final class send_044 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CPrintStream = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s1;
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_6 6 ; r=1/w=1 : Cached
        KRegister local_6;
         // *********[70] ASTORE(6)
        local_6 = frame.pop();
         // *********[71] NEW(java.io.PrintStream)
        if(c_CPrintStream == null){
          c_CPrintStream = c_repo.getClassByName("java.io.PrintStream");
        }
        s0_ref = memseg.allocObject(c_CPrintStream);
         // *********[72] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[73] ALOAD(6)
         // **REMOVED Substitution** s1 = local_6;
         // *********[74] INVOKEVIRTUAL(java.net.Socket,getOutputStream()Ljava/io/OutputStream;)
        regs = new KRegister[1];
         // **REMOVED Substitution** ref = ((KReference)local_6);
        regs[0] = ((KReference)local_6);
        frame.setProgramCounter(44);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(((KReference)local_6)).getVirtualMethodBySignature("getOutputStream()Ljava/io/OutputStream;"),regs);
        frame.setLocal(6,local_6);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(((KReference)local_6)).getVirtualMethodBySignature("getOutputStream()Ljava/io/OutputStream;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[70] ASTORE(6)
         // *********[71] NEW(java.io.PrintStream)
        c_repo = process.getClassRepository();
         // *********[72] DUP
         // *********[73] ALOAD(6)
         // *********[74] INVOKEVIRTUAL(java.net.Socket,getOutputStream()Ljava/io/OutputStream;)
        c_memman = process.getMemoryManager();
      }
}
