package jjit.local.jnt.scimark2.Random._init__DD_V_7E03AEC7;
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
 * jnt.scimark2.Random
 * <init>(DD)V
 * [count=15] [42] ALOAD(0) [43] DLOAD(1) [44] PUTFIELD(jnt.scimark2.Random,left) [45] ALOAD(0) [46] DLOAD(3) [47] PUTFIELD(jnt.scimark2.Random,right) [48] ALOAD(0) [49] DLOAD(3) [50] DLOAD(1) [51] DSUB [52] PUTFIELD(jnt.scimark2.Random,width) [53] ALOAD(0) [54] ICONST_1(Integer{1}) [55] PUTFIELD(jnt.scimark2.Random,haveRange) [56] RETURN
 */
public final class _init__005 extends JJITAbstractInstruction implements Cloneable{
      private KField c_left = null;
      private KClassRepository c_repo;
      private KClass c_CRandom = null;
      private KField c_right = null;
      private KField c_width = null;
      private static final KInteger IONE = KInteger.ONE;
      private KField c_haveRange = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KRegister reg;
         // **REMOVED Unused Var** double m_d;
         // **REMOVED Unused Var** KFrame callerFrame = null;
        KLocalThread thread = frame.getThread();
         // this_ref 0 ; r=4/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // local_1 1 ; r=2/w=0 : Cached
        KRegister local_1 = frame.getLocal(1);
         // local_3 3 ; r=2/w=0 : Cached
        KRegister local_3 = frame.getLocal(3);
         // *********[42] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[43] DLOAD(1)
         // **REMOVED Substitution** s1 = local_1;
         // *********[44] PUTFIELD(jnt.scimark2.Random,left)
         // **REMOVED Substitution** reg = local_1;
         // **REMOVED Substitution** ref = this_ref;
        c_left.setInstanceValue(this_ref,local_1);
         // *********[45] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[46] DLOAD(3)
         // **REMOVED Substitution** s1 = local_3;
         // *********[47] PUTFIELD(jnt.scimark2.Random,right)
         // **REMOVED Substitution** reg = local_3;
         // **REMOVED Substitution** ref = this_ref;
        c_right.setInstanceValue(this_ref,local_3);
         // *********[48] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[49] DLOAD(3)
         // **REMOVED Substitution** s1 = local_3;
         // *********[50] DLOAD(1)
         // **REMOVED Substitution** s2 = local_1;
         // *********[51] DSUB
         // **REMOVED Substitution** m_d = local_1.doubleValue();
         // **REMOVED Substitution** s1 = new KDouble((local_3.doubleValue() - local_1.doubleValue()));
         // *********[52] PUTFIELD(jnt.scimark2.Random,width)
         // **REMOVED Substitution** reg = new KDouble((local_3.doubleValue() - local_1.doubleValue()));
         // **REMOVED Substitution** ref = this_ref;
        c_width.setInstanceValue(this_ref,new KDouble((local_3.doubleValue() - local_1.doubleValue())));
         // *********[53] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[54] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[55] PUTFIELD(jnt.scimark2.Random,haveRange)
         // **REMOVED Substitution** reg = IONE;
         // **REMOVED Substitution** ref = this_ref;
        c_haveRange.setInstanceValue(this_ref,IONE);
         // *********[56] RETURN
         // **REMOVED Substitution** callerFrame = thread.popFrame();
        return ((JJITInstruction)thread.popFrame().getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[42] ALOAD(0)
         // *********[43] DLOAD(1)
         // *********[44] PUTFIELD(jnt.scimark2.Random,left)
        c_repo = process.getClassRepository();
        c_CRandom = c_repo.getClassByName("jnt.scimark2.Random");
        c_left = c_CRandom.getField("left",true);
         // *********[45] ALOAD(0)
         // *********[46] DLOAD(3)
         // *********[47] PUTFIELD(jnt.scimark2.Random,right)
        c_right = c_CRandom.getField("right",true);
         // *********[48] ALOAD(0)
         // *********[49] DLOAD(3)
         // *********[50] DLOAD(1)
         // *********[51] DSUB
         // *********[52] PUTFIELD(jnt.scimark2.Random,width)
        c_width = c_CRandom.getField("width",true);
         // *********[53] ALOAD(0)
         // *********[54] ICONST_1(Integer{1})
         // *********[55] PUTFIELD(jnt.scimark2.Random,haveRange)
        c_haveRange = c_CRandom.getField("haveRange",true);
         // *********[56] RETURN
      }
}
