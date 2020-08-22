package jjit.local.jnt.Bench.Plotter._init___V_F9B22C82;
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
 * <init>()V
 * [count=19] [2] ALOAD(0) [3] ICONST_M1(Integer{-1}) [4] PUTFIELD(jnt.Bench.Plotter,specindex) [5] ALOAD(0) [6] ICONST_5(Integer{5}) [7] PUTFIELD(jnt.Bench.Plotter,MARGIN) [8] ALOAD(0) [9] ICONST_3(Integer{3}) [10] PUTFIELD(jnt.Bench.Plotter,TICK) [11] ALOAD(0) [12] ICONST_4(Integer{4}) [13] PUTFIELD(jnt.Bench.Plotter,GAP) [14] ALOAD(0) [15] ICONST_1(Integer{1}) [16] PUTFIELD(jnt.Bench.Plotter,MINZERO) [17] ALOAD(0) [18] BIPUSH(10) [19] PUTFIELD(jnt.Bench.Plotter,FONTSIZE) [20] ALOAD(0)
 */
public final class _init__004 extends JJITAbstractInstruction implements Cloneable{
      private KField c_specindex = null;
      private KClassRepository c_repo;
      private KClass c_CPlotter = null;
      private KField c_MARGIN = null;
      private KField c_TICK = null;
      private KField c_GAP = null;
      private static final KInteger IONE = KInteger.ONE;
      private KField c_MIN_ERO = null;
      private KField c_FONTSI_E = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KRegister reg;
         // this_ref 0 ; r=7/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[2] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[3] ICONST_M1(Integer{-1})
         // **REMOVED Substitution** s1 = IM1;
         // *********[4] PUTFIELD(jnt.Bench.Plotter,specindex)
         // **REMOVED Substitution** reg = IM1;
         // **REMOVED Substitution** ref = this_ref;
        c_specindex.setInstanceInt(this_ref,-1);
         // *********[5] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[6] ICONST_5(Integer{5})
         // **REMOVED Substitution** s1 = IFIVE;
         // *********[7] PUTFIELD(jnt.Bench.Plotter,MARGIN)
         // **REMOVED Substitution** reg = IFIVE;
         // **REMOVED Substitution** ref = this_ref;
        c_MARGIN.setInstanceInt(this_ref,5);
         // *********[8] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[9] ICONST_3(Integer{3})
         // **REMOVED Substitution** s1 = ITHREE;
         // *********[10] PUTFIELD(jnt.Bench.Plotter,TICK)
         // **REMOVED Substitution** reg = ITHREE;
         // **REMOVED Substitution** ref = this_ref;
        c_TICK.setInstanceInt(this_ref,3);
         // *********[11] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[12] ICONST_4(Integer{4})
         // **REMOVED Substitution** s1 = IFOUR;
         // *********[13] PUTFIELD(jnt.Bench.Plotter,GAP)
         // **REMOVED Substitution** reg = IFOUR;
         // **REMOVED Substitution** ref = this_ref;
        c_GAP.setInstanceInt(this_ref,4);
         // *********[14] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[15] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[16] PUTFIELD(jnt.Bench.Plotter,MINZERO)
         // **REMOVED Substitution** reg = IONE;
         // **REMOVED Substitution** ref = this_ref;
        c_MIN_ERO.setInstanceValue(this_ref,IONE);
         // *********[17] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[18] BIPUSH(10)
         // **REMOVED Substitution** s1 = I10;
         // *********[19] PUTFIELD(jnt.Bench.Plotter,FONTSIZE)
         // **REMOVED Substitution** reg = I10;
         // **REMOVED Substitution** ref = this_ref;
        c_FONTSI_E.setInstanceInt(this_ref,10);
         // *********[20] ALOAD(0)
        frame.push(this_ref);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[2] ALOAD(0)
         // *********[3] ICONST_M1(Integer{-1})
         // *********[4] PUTFIELD(jnt.Bench.Plotter,specindex)
        c_repo = process.getClassRepository();
        c_CPlotter = c_repo.getClassByName("jnt.Bench.Plotter");
        c_specindex = c_CPlotter.getField("specindex",true);
         // *********[5] ALOAD(0)
         // *********[6] ICONST_5(Integer{5})
         // *********[7] PUTFIELD(jnt.Bench.Plotter,MARGIN)
        c_MARGIN = c_CPlotter.getField("MARGIN",true);
         // *********[8] ALOAD(0)
         // *********[9] ICONST_3(Integer{3})
         // *********[10] PUTFIELD(jnt.Bench.Plotter,TICK)
        c_TICK = c_CPlotter.getField("TICK",true);
         // *********[11] ALOAD(0)
         // *********[12] ICONST_4(Integer{4})
         // *********[13] PUTFIELD(jnt.Bench.Plotter,GAP)
        c_GAP = c_CPlotter.getField("GAP",true);
         // *********[14] ALOAD(0)
         // *********[15] ICONST_1(Integer{1})
         // *********[16] PUTFIELD(jnt.Bench.Plotter,MINZERO)
        c_MIN_ERO = c_CPlotter.getField("MINZERO",true);
         // *********[17] ALOAD(0)
         // *********[18] BIPUSH(10)
         // *********[19] PUTFIELD(jnt.Bench.Plotter,FONTSIZE)
        c_FONTSI_E = c_CPlotter.getField("FONTSIZE",true);
         // *********[20] ALOAD(0)
        c_next = instructions[(index + 1)];
      }
}
