package jjit.local.jnt.Bench.HTTPPost.post_Ljava_lang_StringLjava_lang_String_V_FD00FDAB;
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
 * jnt.Bench.HTTPPost
 * post(Ljava/lang/String;Ljava/lang/String;)V
 * [count=5] [19] ASTORE(4) [20] NEW(java.io.PrintStream) [21] DUP [22] ALOAD(4) [23] INVOKEVIRTUAL(java.net.Socket,getOutputStream()Ljava/io/OutputStream;)
 */
public final class post_011 extends JJITAbstractInstruction implements Cloneable{
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
         // local_4 4 ; r=1/w=1 : Cached
        KRegister local_4;
         // *********[19] ASTORE(4)
        local_4 = frame.pop();
         // *********[20] NEW(java.io.PrintStream)
        if(c_CPrintStream == null){
          c_CPrintStream = c_repo.getClassByName("java.io.PrintStream");
        }
        s0_ref = memseg.allocObject(c_CPrintStream);
         // *********[21] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[22] ALOAD(4)
         // **REMOVED Substitution** s1 = local_4;
         // *********[23] INVOKEVIRTUAL(java.net.Socket,getOutputStream()Ljava/io/OutputStream;)
        regs = new KRegister[1];
         // **REMOVED Substitution** ref = ((KReference)local_4);
        regs[0] = ((KReference)local_4);
        frame.setProgramCounter(11);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(((KReference)local_4)).getVirtualMethodBySignature("getOutputStream()Ljava/io/OutputStream;"),regs);
        frame.setLocal(4,local_4);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(((KReference)local_4)).getVirtualMethodBySignature("getOutputStream()Ljava/io/OutputStream;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[19] ASTORE(4)
         // *********[20] NEW(java.io.PrintStream)
        c_repo = process.getClassRepository();
         // *********[21] DUP
         // *********[22] ALOAD(4)
         // *********[23] INVOKEVIRTUAL(java.net.Socket,getOutputStream()Ljava/io/OutputStream;)
        c_memman = process.getMemoryManager();
      }
}
