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
 * [count=4] [80] POP [81] ALOAD(0) [82] NEW(java.awt.Choice) [83] DUP
 */
public final class init_037 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CChoice = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[80] POP
        frame.pop();
         // *********[81] ALOAD(0)
        frame.push(frame.getLocal(0));
         // *********[82] NEW(java.awt.Choice)
        if(c_CChoice == null){
          c_CChoice = c_repo.getClassByName("java.awt.Choice");
        }
        s0_ref = memseg.allocObject(c_CChoice);
         // *********[83] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[80] POP
         // *********[81] ALOAD(0)
         // *********[82] NEW(java.awt.Choice)
        c_repo = process.getClassRepository();
         // *********[83] DUP
        c_next = instructions[(index + 1)];
      }
}
