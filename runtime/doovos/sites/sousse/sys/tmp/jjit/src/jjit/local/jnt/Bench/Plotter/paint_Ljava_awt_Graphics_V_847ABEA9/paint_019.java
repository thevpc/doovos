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
 * [count=5] [57] ALOAD(0) [58] GETFIELD(jnt.Bench.Plotter,values,[D) [59] ILOAD(13) [60] DALOAD [61] DSTORE(11)
 */
public final class paint_019 extends JJITAbstractInstruction implements Cloneable{
      private KField c_values = null;
      private KClassRepository c_repo;
      private KClass c_CPlotter = null;
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_11 11 ; r=0/w=1 : NotCached
         // local_13 13 ; r=1/w=0 : NotCached
         // *********[57] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[58] GETFIELD(jnt.Bench.Plotter,values,[D)
         // **REMOVED Substitution** s0_ref = c_values.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[59] ILOAD(13)
         // **REMOVED Substitution** s1 = frame.getLocal(13);
         // *********[60] DALOAD
         // **REMOVED Substitution** index = frame.getLocal(13).intValue();
         // **REMOVED Substitution** s0 = new KDouble(c_memman.getDoubleArray(c_values.getInstanceRef(((KReference)frame.getLocal(0))),frame.getLocal(13).intValue()));
         // *********[61] DSTORE(11)
        frame.setLocal(11,new KDouble(c_memman.getDoubleArray(c_values.getInstanceRef(((KReference)frame.getLocal(0))),frame.getLocal(13).intValue())));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[57] ALOAD(0)
         // *********[58] GETFIELD(jnt.Bench.Plotter,values,[D)
        c_repo = process.getClassRepository();
        c_CPlotter = c_repo.getClassByName("jnt.Bench.Plotter");
        c_values = c_CPlotter.getField("values",true);
         // *********[59] ILOAD(13)
         // *********[60] DALOAD
        c_memman = process.getMemoryManager();
         // *********[61] DSTORE(11)
        c_next = instructions[(index + 1)];
      }
}
