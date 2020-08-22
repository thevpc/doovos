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
 * [count=5] [25] ASTORE(5) [26] NEW(java.io.DataInputStream) [27] DUP [28] ALOAD(4) [29] INVOKEVIRTUAL(java.net.Socket,getInputStream()Ljava/io/InputStream;)
 */
public final class post_014 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CDataInputStream = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s1;
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_4 4 ; r=1/w=0 : NotCached
         // local_5 5 ; r=0/w=1 : NotCached
         // *********[25] ASTORE(5)
        frame.setLocal(5,frame.pop());
         // *********[26] NEW(java.io.DataInputStream)
        if(c_CDataInputStream == null){
          c_CDataInputStream = c_repo.getClassByName("java.io.DataInputStream");
        }
        s0_ref = memseg.allocObject(c_CDataInputStream);
         // *********[27] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[28] ALOAD(4)
         // **REMOVED Substitution** s1 = frame.getLocal(4);
         // *********[29] INVOKEVIRTUAL(java.net.Socket,getInputStream()Ljava/io/InputStream;)
        regs = new KRegister[1];
        ref = ((KReference)frame.getLocal(4));
        regs[0] = ref;
        frame.setProgramCounter(14);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getInputStream()Ljava/io/InputStream;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getInputStream()Ljava/io/InputStream;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[25] ASTORE(5)
         // *********[26] NEW(java.io.DataInputStream)
        c_repo = process.getClassRepository();
         // *********[27] DUP
         // *********[28] ALOAD(4)
         // *********[29] INVOKEVIRTUAL(java.net.Socket,getInputStream()Ljava/io/InputStream;)
        c_memman = process.getMemoryManager();
      }
}
