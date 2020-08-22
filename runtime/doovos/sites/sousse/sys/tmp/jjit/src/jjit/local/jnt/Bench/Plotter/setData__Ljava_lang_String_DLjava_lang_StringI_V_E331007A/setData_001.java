package jjit.local.jnt.Bench.Plotter.setData__Ljava_lang_String_DLjava_lang_StringI_V_E331007A;
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
 * setData([Ljava/lang/String;[DLjava/lang/String;I)V
 * [count=13] [0] ALOAD(0) [1] ALOAD(1) [2] PUTFIELD(jnt.Bench.Plotter,labels) [3] ALOAD(0) [4] ALOAD(2) [5] PUTFIELD(jnt.Bench.Plotter,values) [6] ALOAD(0) [7] ALOAD(3) [8] PUTFIELD(jnt.Bench.Plotter,axisLabel) [9] ALOAD(0) [10] ILOAD(4) [11] PUTFIELD(jnt.Bench.Plotter,specindex) [12] ALOAD(0)
 */
public final class setData_001 extends JJITAbstractInstruction implements Cloneable{
      private KField c_labels = null;
      private KClassRepository c_repo;
      private KClass c_CPlotter = null;
      private KField c_values = null;
      private KField c_axisLabel = null;
      private KField c_specindex = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KRegister reg;
         // this_ref 0 ; r=5/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // local_1 1 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=0 : NotCached
         // local_4 4 ; r=1/w=0 : NotCached
         // *********[0] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[1] ALOAD(1)
         // **REMOVED Substitution** s1 = frame.getLocal(1);
         // *********[2] PUTFIELD(jnt.Bench.Plotter,labels)
         // **REMOVED Substitution** reg = frame.getLocal(1);
         // **REMOVED Substitution** ref = this_ref;
        c_labels.setInstanceValue(this_ref,frame.getLocal(1));
         // *********[3] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[4] ALOAD(2)
         // **REMOVED Substitution** s1 = frame.getLocal(2);
         // *********[5] PUTFIELD(jnt.Bench.Plotter,values)
         // **REMOVED Substitution** reg = frame.getLocal(2);
         // **REMOVED Substitution** ref = this_ref;
        c_values.setInstanceValue(this_ref,frame.getLocal(2));
         // *********[6] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[7] ALOAD(3)
         // **REMOVED Substitution** s1 = frame.getLocal(3);
         // *********[8] PUTFIELD(jnt.Bench.Plotter,axisLabel)
         // **REMOVED Substitution** reg = frame.getLocal(3);
         // **REMOVED Substitution** ref = this_ref;
        c_axisLabel.setInstanceValue(this_ref,frame.getLocal(3));
         // *********[9] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[10] ILOAD(4)
         // **REMOVED Substitution** s1 = frame.getLocal(4);
         // *********[11] PUTFIELD(jnt.Bench.Plotter,specindex)
         // **REMOVED Substitution** reg = frame.getLocal(4);
         // **REMOVED Substitution** ref = this_ref;
        c_specindex.setInstanceInt(this_ref,frame.getLocal(4).intValue());
         // *********[12] ALOAD(0)
        frame.push(this_ref);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] ALOAD(1)
         // *********[2] PUTFIELD(jnt.Bench.Plotter,labels)
        c_repo = process.getClassRepository();
        c_CPlotter = c_repo.getClassByName("jnt.Bench.Plotter");
        c_labels = c_CPlotter.getField("labels",true);
         // *********[3] ALOAD(0)
         // *********[4] ALOAD(2)
         // *********[5] PUTFIELD(jnt.Bench.Plotter,values)
        c_values = c_CPlotter.getField("values",true);
         // *********[6] ALOAD(0)
         // *********[7] ALOAD(3)
         // *********[8] PUTFIELD(jnt.Bench.Plotter,axisLabel)
        c_axisLabel = c_CPlotter.getField("axisLabel",true);
         // *********[9] ALOAD(0)
         // *********[10] ILOAD(4)
         // *********[11] PUTFIELD(jnt.Bench.Plotter,specindex)
        c_specindex = c_CPlotter.getField("specindex",true);
         // *********[12] ALOAD(0)
        c_next = instructions[(index + 1)];
      }
}
