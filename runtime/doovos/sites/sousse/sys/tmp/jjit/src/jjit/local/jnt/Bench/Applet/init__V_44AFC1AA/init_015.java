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
 * [count=5] [31] NEW(java.awt.Font) [32] DUP [33] LDC(27->"Helvetica") [34] ICONST_0(Integer{0}) [35] BIPUSH(12)
 */
public final class init_015 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CFont = null;
      private static KReference R27 = null;
      private static final KInteger IZERO = KInteger.ZERO;
      private static final KInteger I12 = new KInteger(12);
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // *********[31] NEW(java.awt.Font)
        if(c_CFont == null){
          c_CFont = c_repo.getClassByName("java.awt.Font");
        }
        s0_ref = memseg.allocObject(c_CFont);
         // *********[32] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[33] LDC(27->"Helvetica")
        frame.push(R27);
         // *********[34] ICONST_0(Integer{0})
        frame.push(IZERO);
         // *********[35] BIPUSH(12)
        frame.push(I12);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[31] NEW(java.awt.Font)
        c_repo = process.getClassRepository();
         // *********[32] DUP
         // *********[33] LDC(27->"Helvetica")
        R27 = ((KReference)constants[27]);
         // *********[34] ICONST_0(Integer{0})
         // *********[35] BIPUSH(12)
        c_next = instructions[(index + 1)];
      }
}
