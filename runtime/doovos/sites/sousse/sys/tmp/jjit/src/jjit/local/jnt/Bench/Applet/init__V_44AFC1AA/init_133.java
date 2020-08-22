package jjit.local.jnt.Bench.Applet.init__V_44AFC1AA;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Applet
 * init()V
 * [count=4] [395] ILOAD(10) [396] ALOAD(9) [397] ARRAYLENGTH [398] IF_ICMPLT(388)
 */
public final class init_133 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_9 9 ; r=1/w=0 : NotCached
         // local_10 10 ; r=1/w=0 : NotCached
         // *********[395] ILOAD(10)
         // **REMOVED Substitution** s0 = frame.getLocal(10);
         // *********[396] ALOAD(9)
         // **REMOVED Substitution** s1 = frame.getLocal(9);
         // *********[397] ARRAYLENGTH
         // **REMOVED Substitution** s1 = new KInteger(c_memman.getArraySize(((KReference)frame.getLocal(9))));
         // *********[398] IF_ICMPLT(388)
         // **REMOVED Substitution** index = c_memman.getArraySize(((KReference)frame.getLocal(9)));
         // **REMOVED Substitution** jump = frame.getLocal(10).intValue() < c_memman.getArraySize(((KReference)frame.getLocal(9)));
        return ((frame.getLocal(10).intValue() < c_memman.getArraySize(((KReference)frame.getLocal(9))))?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[395] ILOAD(10)
         // *********[396] ALOAD(9)
         // *********[397] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[398] IF_ICMPLT(388)
        c_next = instructions[(index + 1)];
        c_label = instructions[130];
      }
}
