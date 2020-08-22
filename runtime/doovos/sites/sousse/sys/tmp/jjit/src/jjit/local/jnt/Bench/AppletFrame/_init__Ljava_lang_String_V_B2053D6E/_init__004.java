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
 * [count=2] [3] NEW(jnt.Bench.Applet) [4] DUP
 */
public final class _init__004 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // *********[3] NEW(jnt.Bench.Applet)
        if(c_CApplet == null){
          c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        }
        s0_ref = memseg.allocObject(c_CApplet);
         // *********[4] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[3] NEW(jnt.Bench.Applet)
        c_repo = process.getClassRepository();
         // *********[4] DUP
        c_next = instructions[(index + 1)];
      }
}
