package jjit.local.jnt.Bench.Plotter.paint_Ljava_awt_Graphics_V_847ABEA9;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Plotter
 * paint(Ljava/awt/Graphics;)V
 * [count=4] [338] ASTORE(36) [339] DLOAD(11) [340] ILOAD(4) [341] INVOKESTATIC(jnt.Bench.Formatter,format(DI)Ljava/lang/String;)
 */
public final class paint_058 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CFormatter = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_4 4 ; r=1/w=0 : NotCached
         // local_36 36 ; r=0/w=1 : NotCached
         // local_11 11 ; r=1/w=0 : NotCached
         // *********[338] ASTORE(36)
        frame.setLocal(36,frame.pop());
         // *********[339] DLOAD(11)
         // **REMOVED Substitution** s0 = frame.getLocal(11);
         // *********[340] ILOAD(4)
         // **REMOVED Substitution** s1 = frame.getLocal(4);
         // *********[341] INVOKESTATIC(jnt.Bench.Formatter,format(DI)Ljava/lang/String;)
        regs = new KRegister[2];
        regs[1] = frame.getLocal(4);
        regs[0] = frame.getLocal(11);
        if(c_CFormatter == null){
          c_CFormatter = c_repo.getClassByName("jnt.Bench.Formatter");
        }
        if(m_mth == null){
          m_mth = c_CFormatter.getMethodBySignature("format(DI)Ljava/lang/String;");
        }
        frame.setProgramCounter(58);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[338] ASTORE(36)
         // *********[339] DLOAD(11)
         // *********[340] ILOAD(4)
         // *********[341] INVOKESTATIC(jnt.Bench.Formatter,format(DI)Ljava/lang/String;)
        c_repo = process.getClassRepository();
      }
}
