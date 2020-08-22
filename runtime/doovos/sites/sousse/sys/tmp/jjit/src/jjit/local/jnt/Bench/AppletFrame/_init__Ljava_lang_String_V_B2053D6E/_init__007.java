package jjit.local.jnt.Bench.AppletFrame._init__Ljava_lang_String_V_B2053D6E;
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
 * jnt.Bench.AppletFrame
 * <init>(Ljava/lang/String;)V
 * [count=6] [6] ASTORE(2) [7] ALOAD(2) [8] NEW(jnt.Bench.Bench) [9] DUP [10] ALOAD(2) [11] ALOAD(1)
 */
public final class _init__007 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // local_1 1 ; r=1/w=0 : NotCached
         // local_2 2 ; r=2/w=1 : Cached
        KRegister local_2;
         // *********[6] ASTORE(2)
        local_2 = frame.pop();
         // *********[7] ALOAD(2)
        frame.push(local_2);
         // *********[8] NEW(jnt.Bench.Bench)
        if(c_CBench == null){
          c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        }
        s0_ref = memseg.allocObject(c_CBench);
         // *********[9] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[10] ALOAD(2)
        frame.push(local_2);
         // *********[11] ALOAD(1)
        frame.push(frame.getLocal(1));
        frame.setLocal(2,local_2);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[6] ASTORE(2)
         // *********[7] ALOAD(2)
         // *********[8] NEW(jnt.Bench.Bench)
        c_repo = process.getClassRepository();
         // *********[9] DUP
         // *********[10] ALOAD(2)
         // *********[11] ALOAD(1)
        c_next = instructions[(index + 1)];
      }
}
