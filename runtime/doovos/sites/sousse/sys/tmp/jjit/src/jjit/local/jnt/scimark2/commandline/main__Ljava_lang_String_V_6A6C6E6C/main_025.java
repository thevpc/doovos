package jjit.local.jnt.scimark2.commandline.main__Ljava_lang_String_V_6A6C6E6C;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.commandline
 * main([Ljava/lang/String;)V
 * [count=6] [67] ASTORE(9) [68] ALOAD(8) [69] ICONST_1(Integer{1}) [70] ILOAD(3) [71] DLOAD(1) [72] ALOAD(9)
 */
public final class main_025 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger IONE = KInteger.ONE;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // local_1 1 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=0 : NotCached
         // local_8 8 ; r=1/w=0 : NotCached
         // local_9 9 ; r=1/w=1 : Cached
        KRegister local_9;
         // *********[67] ASTORE(9)
        local_9 = frame.pop();
         // *********[68] ALOAD(8)
        frame.push(frame.getLocal(8));
         // *********[69] ICONST_1(Integer{1})
        frame.push(IONE);
         // *********[70] ILOAD(3)
        frame.push(frame.getLocal(3));
         // *********[71] DLOAD(1)
        frame.push(frame.getLocal(1));
         // *********[72] ALOAD(9)
        frame.push(local_9);
        frame.setLocal(9,local_9);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[67] ASTORE(9)
         // *********[68] ALOAD(8)
         // *********[69] ICONST_1(Integer{1})
         // *********[70] ILOAD(3)
         // *********[71] DLOAD(1)
         // *********[72] ALOAD(9)
        c_next = instructions[(index + 1)];
      }
}
