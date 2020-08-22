package jjit.local.jnt.Bench.Applet.init__V_44AFC1AA;
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
 * jnt.Bench.Applet
 * init()V
 * [count=4] [103] POP [104] ALOAD(0) [105] NEW(java.awt.Panel) [106] DUP
 */
public final class init_044 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CPanel = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[103] POP
        frame.pop();
         // *********[104] ALOAD(0)
        frame.push(frame.getLocal(0));
         // *********[105] NEW(java.awt.Panel)
        if(c_CPanel == null){
          c_CPanel = c_repo.getClassByName("java.awt.Panel");
        }
        s0_ref = memseg.allocObject(c_CPanel);
         // *********[106] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[103] POP
         // *********[104] ALOAD(0)
         // *********[105] NEW(java.awt.Panel)
        c_repo = process.getClassRepository();
         // *********[106] DUP
        c_next = instructions[(index + 1)];
      }
}