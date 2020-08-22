package jjit.local.jnt.Bench.Plotter.paint_Ljava_awt_Graphics_V_847ABEA9;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Plotter
 * paint(Ljava/awt/Graphics;)V
 * [count=6] [250] ALOAD(0) [251] ALOAD(1) [252] ILOAD(31) [253] ALOAD(0) [254] GETFIELD(jnt.Bench.Plotter,specindex,I) [255] IF_ICMPNE(259)
 */
public final class paint_041 extends JJITAbstractInstruction implements Cloneable{
      private KField c_specindex = null;
      private KClassRepository c_repo;
      private KClass c_CPlotter = null;
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // local_1 1 ; r=1/w=0 : NotCached
         // local_31 31 ; r=1/w=0 : NotCached
         // *********[250] ALOAD(0)
        frame.push(this_ref);
         // *********[251] ALOAD(1)
        frame.push(frame.getLocal(1));
         // *********[252] ILOAD(31)
         // **REMOVED Substitution** s0 = frame.getLocal(31);
         // *********[253] ALOAD(0)
         // **REMOVED Substitution** s1_ref = this_ref;
         // *********[254] GETFIELD(jnt.Bench.Plotter,specindex,I)
         // **REMOVED Substitution** s1 = new KInteger(c_specindex.getInstanceInt(this_ref));
         // *********[255] IF_ICMPNE(259)
         // **REMOVED Substitution** index = c_specindex.getInstanceInt(this_ref);
         // **REMOVED Substitution** jump = frame.getLocal(31).intValue() != c_specindex.getInstanceInt(this_ref);
        return ((frame.getLocal(31).intValue() != c_specindex.getInstanceInt(this_ref))?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[250] ALOAD(0)
         // *********[251] ALOAD(1)
         // *********[252] ILOAD(31)
         // *********[253] ALOAD(0)
         // *********[254] GETFIELD(jnt.Bench.Plotter,specindex,I)
        c_repo = process.getClassRepository();
        c_CPlotter = c_repo.getClassByName("jnt.Bench.Plotter");
        c_specindex = c_CPlotter.getField("specindex",true);
         // *********[255] IF_ICMPNE(259)
        c_next = instructions[(index + 1)];
        c_label = instructions[42];
      }
}
