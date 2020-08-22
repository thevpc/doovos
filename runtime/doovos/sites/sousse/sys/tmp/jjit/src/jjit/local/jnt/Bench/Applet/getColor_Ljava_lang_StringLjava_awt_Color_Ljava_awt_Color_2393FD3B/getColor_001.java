package jjit.local.jnt.Bench.Applet.getColor_Ljava_lang_StringLjava_awt_Color_Ljava_awt_Color_2393FD3B;
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
 * getColor(Ljava/lang/String;Ljava/awt/Color;)Ljava/awt/Color;
 * [count=4] [0] NEW(java.awt.Color) [1] DUP [2] ALOAD(0) [3] ALOAD(1)
 */
public final class getColor_001 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CColor = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[0] NEW(java.awt.Color)
        if(c_CColor == null){
          c_CColor = c_repo.getClassByName("java.awt.Color");
        }
        s0_ref = memseg.allocObject(c_CColor);
         // *********[1] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[2] ALOAD(0)
        frame.push(frame.getLocal(0));
         // *********[3] ALOAD(1)
        frame.push(frame.getLocal(1));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] NEW(java.awt.Color)
        c_repo = process.getClassRepository();
         // *********[1] DUP
         // *********[2] ALOAD(0)
         // *********[3] ALOAD(1)
        c_next = instructions[(index + 1)];
      }
}
