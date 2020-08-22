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
 * [count=4] [49] NEW(java.awt.Label) [50] DUP [51] LDC(34->"") [52] ICONST_1(Integer{1})
 */
public final class init_028 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CLabel = null;
      private static KReference R34 = null;
      private static final KInteger IONE = KInteger.ONE;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // *********[49] NEW(java.awt.Label)
        if(c_CLabel == null){
          c_CLabel = c_repo.getClassByName("java.awt.Label");
        }
        s0_ref = memseg.allocObject(c_CLabel);
         // *********[50] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[51] LDC(34->"")
        frame.push(R34);
         // *********[52] ICONST_1(Integer{1})
        frame.push(IONE);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[49] NEW(java.awt.Label)
        c_repo = process.getClassRepository();
         // *********[50] DUP
         // *********[51] LDC(34->"")
        R34 = ((KReference)constants[34]);
         // *********[52] ICONST_1(Integer{1})
        c_next = instructions[(index + 1)];
      }
}
