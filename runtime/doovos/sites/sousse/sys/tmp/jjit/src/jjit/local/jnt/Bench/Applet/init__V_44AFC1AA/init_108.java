package jjit.local.jnt.Bench.Applet.init__V_44AFC1AA;
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
 * jnt.Bench.Applet
 * init()V
 * [count=8] [341] ALOAD(0) [342] NEW(jnt.Bench.Bench) [343] DUP [344] ALOAD(0) [345] NEW(java.net.URL) [346] DUP [347] ALOAD(0) [348] INVOKEVIRTUAL(java.applet.Applet,getDocumentBase()Ljava/net/URL;)
 */
public final class init_108 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private KClass c_CURL = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s1_ref;
         // **REMOVED Unused Var** KReference s2_ref;
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=3/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[341] ALOAD(0)
        frame.push(this_ref);
         // *********[342] NEW(jnt.Bench.Bench)
        if(c_CBench == null){
          c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        }
        s0_ref = memseg.allocObject(c_CBench);
         // *********[343] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[344] ALOAD(0)
        frame.push(this_ref);
         // *********[345] NEW(java.net.URL)
        if(c_CURL == null){
          c_CURL = c_repo.getClassByName("java.net.URL");
        }
        s1_ref = memseg.allocObject(c_CURL);
         // *********[346] DUP
        frame.push(s1_ref);
        frame.push(s1_ref);
         // *********[347] ALOAD(0)
         // **REMOVED Substitution** s2_ref = this_ref;
         // *********[348] INVOKEVIRTUAL(java.applet.Applet,getDocumentBase()Ljava/net/URL;)
        regs = new KRegister[1];
         // **REMOVED Substitution** ref = this_ref;
        regs[0] = this_ref;
        frame.setProgramCounter(108);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("getDocumentBase()Ljava/net/URL;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("getDocumentBase()Ljava/net/URL;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[341] ALOAD(0)
         // *********[342] NEW(jnt.Bench.Bench)
        c_repo = process.getClassRepository();
         // *********[343] DUP
         // *********[344] ALOAD(0)
         // *********[345] NEW(java.net.URL)
        c_repo = process.getClassRepository();
         // *********[346] DUP
         // *********[347] ALOAD(0)
         // *********[348] INVOKEVIRTUAL(java.applet.Applet,getDocumentBase()Ljava/net/URL;)
        c_memman = process.getMemoryManager();
      }
}
