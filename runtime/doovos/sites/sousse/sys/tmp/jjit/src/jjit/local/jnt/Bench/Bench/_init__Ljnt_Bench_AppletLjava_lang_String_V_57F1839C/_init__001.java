package jjit.local.jnt.Bench.Bench._init__Ljnt_Bench_AppletLjava_lang_String_V_57F1839C;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Bench
 * <init>(Ljnt/Bench/Applet;Ljava/lang/String;)V
 * [count=5] [0] ALOAD(0) [1] ALOAD(1) [2] NEW(java.io.FileInputStream) [3] DUP [4] ALOAD(2)
 */
public final class _init__001 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CFileInputStream = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[0] ALOAD(0)
        frame.push(frame.getLocal(0));
         // *********[1] ALOAD(1)
        frame.push(frame.getLocal(1));
         // *********[2] NEW(java.io.FileInputStream)
        if(c_CFileInputStream == null){
          c_CFileInputStream = c_repo.getClassByName("java.io.FileInputStream");
        }
        s0_ref = memseg.allocObject(c_CFileInputStream);
         // *********[3] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[4] ALOAD(2)
        frame.push(frame.getLocal(2));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] ALOAD(1)
         // *********[2] NEW(java.io.FileInputStream)
        c_repo = process.getClassRepository();
         // *********[3] DUP
         // *********[4] ALOAD(2)
        c_next = instructions[(index + 1)];
      }
}
