package jjit.local.jnt.Bench.Plotter.paint_Ljava_awt_Graphics_V_847ABEA9;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Plotter
 * paint(Ljava/awt/Graphics;)V
 * [count=7] [62] ALOAD(0) [63] GETFIELD(jnt.Bench.Plotter,values,[D) [64] ILOAD(13) [65] DALOAD [66] DLOAD(9) [67] DCMPG [68] IFGE(74)
 */
public final class paint_020 extends JJITAbstractInstruction implements Cloneable{
      private KField c_values = null;
      private KClassRepository c_repo;
      private KClass c_CPlotter = null;
      private KMemoryManager c_memman;
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
        double m_d;
        double m_d2;
         // **REMOVED Unused Var** boolean jump;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_9 9 ; r=1/w=0 : NotCached
         // local_13 13 ; r=1/w=0 : NotCached
         // *********[62] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[63] GETFIELD(jnt.Bench.Plotter,values,[D)
         // **REMOVED Substitution** s0_ref = c_values.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[64] ILOAD(13)
         // **REMOVED Substitution** s1 = frame.getLocal(13);
         // *********[65] DALOAD
         // **REMOVED Substitution** index = frame.getLocal(13).intValue();
         // **REMOVED Substitution** s0 = new KDouble(c_memman.getDoubleArray(c_values.getInstanceRef(((KReference)frame.getLocal(0))),frame.getLocal(13).intValue()));
         // *********[66] DLOAD(9)
         // **REMOVED Substitution** s1 = frame.getLocal(9);
         // *********[67] DCMPG
        m_d2 = frame.getLocal(9).doubleValue();
        m_d = c_memman.getDoubleArray(c_values.getInstanceRef(((KReference)frame.getLocal(0))),frame.getLocal(13).intValue());
         // **REMOVED Substitution** s0 = ((Double.isNaN(m_d) || Double.isNaN(m_d2))?(KInteger.ONE):(((m_d == m_d2)?(KInteger.ZERO):(((m_d > m_d2)?(KInteger.ONE):(KInteger.M1))))));
         // *********[68] IFGE(74)
         // **REMOVED Substitution** index = ((Double.isNaN(m_d) || Double.isNaN(m_d2))?(1):(((m_d == m_d2)?(0):(((m_d > m_d2)?(1):(-1))))));
         // **REMOVED Substitution** jump = ((Double.isNaN(m_d) || Double.isNaN(m_d2))?(1):(((m_d == m_d2)?(0):(((m_d > m_d2)?(1):(-1)))))) >= 0;
        return ((((Double.isNaN(m_d) || Double.isNaN(m_d2))?(1):(((m_d == m_d2)?(0):(((m_d > m_d2)?(1):(-1)))))) >= 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[62] ALOAD(0)
         // *********[63] GETFIELD(jnt.Bench.Plotter,values,[D)
        c_repo = process.getClassRepository();
        c_CPlotter = c_repo.getClassByName("jnt.Bench.Plotter");
        c_values = c_CPlotter.getField("values",true);
         // *********[64] ILOAD(13)
         // *********[65] DALOAD
        c_memman = process.getMemoryManager();
         // *********[66] DLOAD(9)
         // *********[67] DCMPG
         // *********[68] IFGE(74)
        c_next = instructions[(index + 1)];
        c_label = instructions[21];
      }
}