package jjit.local.jnt.scimark2.MonteCarlo.integrate_I_D_98DBB769;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.MonteCarlo
 * integrate(I)D
 * [count=8] [31] ILOAD(2) [32] I2D [33] ILOAD(0) [34] I2D [35] DDIV [36] LDC(2->"4.0") [37] DMUL [38] DRETURN
 */
public final class integrate_011 extends JJITAbstractInstruction implements Cloneable{
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** double m_d;
         // **REMOVED Unused Var** double m_d2;
        KFrame callerFrame = null;
         // **REMOVED Unused Var** KRegister reg;
        KLocalThread thread = frame.getThread();
         // local_0 0 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[31] ILOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[32] I2D
         // **REMOVED Substitution** s0 = new KDouble(frame.getLocal(2).intValue());
         // *********[33] ILOAD(0)
         // **REMOVED Substitution** s1 = frame.getLocal(0);
         // *********[34] I2D
         // **REMOVED Substitution** s1 = new KDouble(frame.getLocal(0).intValue());
         // *********[35] DDIV
         // **REMOVED Substitution** m_d = frame.getLocal(0).doubleValue();
         // **REMOVED Substitution** s0 = new KDouble((frame.getLocal(2).doubleValue() / frame.getLocal(0).doubleValue()));
         // *********[36] LDC(2->"4.0")
         // **REMOVED Substitution** s1 = D4_0;
         // *********[37] DMUL
         // **REMOVED Substitution** m_d2 = 4.0D;
         // **REMOVED Substitution** s0 = new KDouble(((frame.getLocal(2).doubleValue() / frame.getLocal(0).doubleValue()) * 4.0D));
         // *********[38] DRETURN
         // **REMOVED Substitution** reg = new KDouble(((frame.getLocal(2).doubleValue() / frame.getLocal(0).doubleValue()) * 4.0D));
        callerFrame = thread.popFrame();
        callerFrame.push(new KDouble(((frame.getLocal(2).doubleValue() / frame.getLocal(0).doubleValue()) * 4.0D)));
        return ((JJITInstruction)callerFrame.getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[31] ILOAD(2)
         // *********[32] I2D
         // *********[33] ILOAD(0)
         // *********[34] I2D
         // *********[35] DDIV
         // *********[36] LDC(2->"4.0")
         // *********[37] DMUL
         // *********[38] DRETURN
      }
}
