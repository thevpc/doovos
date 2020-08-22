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
 * [count=4] [12] NEW(java.net.Socket) [13] DUP [14] ALOAD(2) [15] INVOKEVIRTUAL(java.net.URL,getHost()Ljava/lang/String;)
 */
public final class post_007 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CSocket = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s1;
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[12] NEW(java.net.Socket)
        if(c_CSocket == null){
          c_CSocket = c_repo.getClassByName("java.net.Socket");
        }
        s0_ref = memseg.allocObject(c_CSocket);
         // *********[13] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[14] ALOAD(2)
         // **REMOVED Substitution** s1 = frame.getLocal(2);
         // *********[15] INVOKEVIRTUAL(java.net.URL,getHost()Ljava/lang/String;)
        regs = new KRegister[1];
        ref = ((KReference)frame.getLocal(2));
        regs[0] = ref;
        frame.setProgramCounter(7);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getHost()Ljava/lang/String;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getHost()Ljava/lang/String;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[12] NEW(java.net.Socket)
        c_repo = process.getClassRepository();
         // *********[13] DUP
         // *********[14] ALOAD(2)
         // *********[15] INVOKEVIRTUAL(java.net.URL,getHost()Ljava/lang/String;)
        c_memman = process.getMemoryManager();
      }
}
