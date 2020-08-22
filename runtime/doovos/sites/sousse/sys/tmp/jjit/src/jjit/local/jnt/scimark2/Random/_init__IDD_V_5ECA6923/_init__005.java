package jjit.local.jnt.scimark2.Random._init__IDD_V_5ECA6923;
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
 * <init>(IDD)V
 * [count=15] [41] ALOAD(0) [42] DLOAD(2) [43] PUTFIELD(jnt.scimark2.Random,left) [44] ALOAD(0) [45] DLOAD(4) [46] PUTFIELD(jnt.scimark2.Random,right) [47] ALOAD(0) [48] DLOAD(4) [49] DLOAD(2) [50] DSUB [51] PUTFIELD(jnt.scimark2.Random,width) [52] ALOAD(0) [53] ICONST_1(Integer{1}) [54] PUTFIELD(jnt.scimark2.Random,haveRange) [55] RETURN
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
         // local_2 2 ; r=2/w=0 : Cached
        KRegister local_2 = frame.getLocal(2);
         // local_4 4 ; r=2/w=0 : Cached
        KRegister local_4 = frame.getLocal(4);
         // *********[41] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[42] DLOAD(2)
         // **REMOVED Substitution** s1 = local_2;
         // *********[43] PUTFIELD(jnt.scimark2.Random,left)
         // **REMOVED Substitution** reg = local_2;
         // **REMOVED Substitution** ref = this_ref;
        c_left.setInstanceValue(this_ref,local_2);
         // *********[44] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[45] DLOAD(4)
         // **REMOVED Substitution** s1 = local_4;
         // *********[46] PUTFIELD(jnt.scimark2.Random,right)
         // **REMOVED Substitution** reg = local_4;
         // **REMOVED Substitution** ref = this_ref;
        c_right.setInstanceValue(this_ref,local_4);
         // *********[47] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[48] DLOAD(4)
         // **REMOVED Substitution** s1 = local_4;
         // *********[49] DLOAD(2)
         // **REMOVED Substitution** s2 = local_2;
         // *********[50] DSUB
         // **REMOVED Substitution** m_d = local_2.doubleValue();
         // **REMOVED Substitution** s1 = new KDouble((local_4.doubleValue() - local_2.doubleValue()));
         // *********[51] PUTFIELD(jnt.scimark2.Random,width)
         // **REMOVED Substitution** reg = new KDouble((local_4.doubleValue() - local_2.doubleValue()));
         // **REMOVED Substitution** ref = this_ref;
        c_width.setInstanceValue(this_ref,new KDouble((local_4.doubleValue() - local_2.doubleValue())));
         // *********[52] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[53] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[54] PUTFIELD(jnt.scimark2.Random,haveRange)
         // **REMOVED Substitution** reg = IONE;
         // **REMOVED Substitution** ref = this_ref;
        c_haveRange.setInstanceValue(this_ref,IONE);
         // *********[55] RETURN
         // **REMOVED Substitution** callerFrame = thread.popFrame();
        return ((JJITInstruction)thread.popFrame().getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[41] ALOAD(0)
         // *********[42] DLOAD(2)
         // *********[43] PUTFIELD(jnt.scimark2.Random,left)
        c_repo = process.getClassRepository();
        c_CRandom = c_repo.getClassByName("jnt.scimark2.Random");
        c_left = c_CRandom.getField("left",true);
         // *********[44] ALOAD(0)
         // *********[45] DLOAD(4)
         // *********[46] PUTFIELD(jnt.scimark2.Random,right)
        c_right = c_CRandom.getField("right",true);
         // *********[47] ALOAD(0)
         // *********[48] DLOAD(4)
         // *********[49] DLOAD(2)
         // *********[50] DSUB
         // *********[51] PUTFIELD(jnt.scimark2.Random,width)
        c_width = c_CRandom.getField("width",true);
         // *********[52] ALOAD(0)
         // *********[53] ICONST_1(Integer{1})
         // *********[54] PUTFIELD(jnt.scimark2.Random,haveRange)
        c_haveRange = c_CRandom.getField("haveRange",true);
         // *********[55] RETURN
      }
}
