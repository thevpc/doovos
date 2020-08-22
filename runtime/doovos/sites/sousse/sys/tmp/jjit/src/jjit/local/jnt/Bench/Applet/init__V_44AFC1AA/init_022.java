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
 * [count=3] [41] ASTORE(4) [42] NEW(java.awt.GridBagConstraints) [43] DUP
 */
public final class init_022 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CGridBagConstraints = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // local_4 4 ; r=0/w=1 : NotCached
         // *********[41] ASTORE(4)
        frame.setLocal(4,frame.pop());
         // *********[42] NEW(java.awt.GridBagConstraints)
        if(c_CGridBagConstraints == null){
          c_CGridBagConstraints = c_repo.getClassByName("java.awt.GridBagConstraints");
        }
        s0_ref = memseg.allocObject(c_CGridBagConstraints);
         // *********[43] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[41] ASTORE(4)
         // *********[42] NEW(java.awt.GridBagConstraints)
        c_repo = process.getClassRepository();
         // *********[43] DUP
        c_next = instructions[(index + 1)];
      }
}
