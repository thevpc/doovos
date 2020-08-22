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
 * [count=5] [76] ASTORE(7) [77] NEW(java.io.DataInputStream) [78] DUP [79] ALOAD(6) [80] INVOKEVIRTUAL(java.net.Socket,getInputStream()Ljava/io/InputStream;)
 */
public final class send_047 extends JJITAbstractInstruction implements Cloneable{
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
         // local_6 6 ; r=1/w=0 : NotCached
         // local_7 7 ; r=0/w=1 : NotCached
         // *********[76] ASTORE(7)
        frame.setLocal(7,frame.pop());
         // *********[77] NEW(java.io.DataInputStream)
        if(c_CDataInputStream == null){
          c_CDataInputStream = c_repo.getClassByName("java.io.DataInputStream");
        }
        s0_ref = memseg.allocObject(c_CDataInputStream);
         // *********[78] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[79] ALOAD(6)
         // **REMOVED Substitution** s1 = frame.getLocal(6);
         // *********[80] INVOKEVIRTUAL(java.net.Socket,getInputStream()Ljava/io/InputStream;)
        regs = new KRegister[1];
        ref = ((KReference)frame.getLocal(6));
        regs[0] = ref;
        frame.setProgramCounter(47);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getInputStream()Ljava/io/InputStream;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getInputStream()Ljava/io/InputStream;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[76] ASTORE(7)
         // *********[77] NEW(java.io.DataInputStream)
        c_repo = process.getClassRepository();
         // *********[78] DUP
         // *********[79] ALOAD(6)
         // *********[80] INVOKEVIRTUAL(java.net.Socket,getInputStream()Ljava/io/InputStream;)
        c_memman = process.getMemoryManager();
      }
}
