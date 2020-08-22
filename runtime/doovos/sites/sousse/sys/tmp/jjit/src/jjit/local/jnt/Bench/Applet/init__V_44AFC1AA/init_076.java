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
 * [count=4] [209] ALOAD(0) [210] NEW(java.awt.Button) [211] DUP [212] LDC(78->"Execute Benchmark")
 */
public final class init_076 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CButton = null;
      private static KReference R78 = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[209] ALOAD(0)
        frame.push(frame.getLocal(0));
         // *********[210] NEW(java.awt.Button)
        if(c_CButton == null){
          c_CButton = c_repo.getClassByName("java.awt.Button");
        }
        s0_ref = memseg.allocObject(c_CButton);
         // *********[211] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[212] LDC(78->"Execute Benchmark")
        frame.push(R78);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[209] ALOAD(0)
         // *********[210] NEW(java.awt.Button)
        c_repo = process.getClassRepository();
         // *********[211] DUP
         // *********[212] LDC(78->"Execute Benchmark")
        R78 = ((KReference)constants[78]);
        c_next = instructions[(index + 1)];
      }
}
