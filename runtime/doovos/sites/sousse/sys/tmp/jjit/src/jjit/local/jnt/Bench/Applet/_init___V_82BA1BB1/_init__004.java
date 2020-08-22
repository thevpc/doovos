package jjit.local.jnt.Bench.Applet._init___V_82BA1BB1;
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
 * jnt.Bench.Applet
 * <init>()V
 * [count=13] [2] ALOAD(0) [3] ACONST_NULL [4] PUTFIELD(jnt.Bench.Applet,bench) [5] ALOAD(0) [6] ICONST_0(Integer{0}) [7] PUTFIELD(jnt.Bench.Applet,segment) [8] ALOAD(0) [9] ICONST_M1(Integer{-1}) [10] PUTFIELD(jnt.Bench.Applet,cursor) [11] ALOAD(0) [12] ACONST_NULL [13] PUTFIELD(jnt.Bench.Applet,parent) [14] RETURN
 */
public final class _init__004 extends JJITAbstractInstruction implements Cloneable{
      private KField c_bench = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private KField c_segment = null;
      private KField c_cursor = null;
      private KField c_parent = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KRegister reg;
         // **REMOVED Unused Var** KFrame callerFrame = null;
        KLocalThread thread = frame.getThread();
         // this_ref 0 ; r=4/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[2] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[3] ACONST_NULL
         // **REMOVED Substitution** s1_ref = KReference.NULL;
         // *********[4] PUTFIELD(jnt.Bench.Applet,bench)
         // **REMOVED Substitution** reg = KReference.NULL;
         // **REMOVED Substitution** ref = this_ref;
        c_bench.setInstanceValue(this_ref,KReference.NULL);
         // *********[5] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[6] ICONST_0(Integer{0})
         // **REMOVED Substitution** s1 = IZERO;
         // *********[7] PUTFIELD(jnt.Bench.Applet,segment)
         // **REMOVED Substitution** reg = IZERO;
         // **REMOVED Substitution** ref = this_ref;
        c_segment.setInstanceInt(this_ref,0);
         // *********[8] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[9] ICONST_M1(Integer{-1})
         // **REMOVED Substitution** s1 = IM1;
         // *********[10] PUTFIELD(jnt.Bench.Applet,cursor)
         // **REMOVED Substitution** reg = IM1;
         // **REMOVED Substitution** ref = this_ref;
        c_cursor.setInstanceInt(this_ref,-1);
         // *********[11] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[12] ACONST_NULL
         // **REMOVED Substitution** s1_ref = KReference.NULL;
         // *********[13] PUTFIELD(jnt.Bench.Applet,parent)
         // **REMOVED Substitution** reg = KReference.NULL;
         // **REMOVED Substitution** ref = this_ref;
        c_parent.setInstanceValue(this_ref,KReference.NULL);
         // *********[14] RETURN
         // **REMOVED Substitution** callerFrame = thread.popFrame();
        return ((JJITInstruction)thread.popFrame().getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[2] ALOAD(0)
         // *********[3] ACONST_NULL
         // *********[4] PUTFIELD(jnt.Bench.Applet,bench)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_bench = c_CApplet.getField("bench",true);
         // *********[5] ALOAD(0)
         // *********[6] ICONST_0(Integer{0})
         // *********[7] PUTFIELD(jnt.Bench.Applet,segment)
        c_segment = c_CApplet.getField("segment",true);
         // *********[8] ALOAD(0)
         // *********[9] ICONST_M1(Integer{-1})
         // *********[10] PUTFIELD(jnt.Bench.Applet,cursor)
        c_cursor = c_CApplet.getField("cursor",true);
         // *********[11] ALOAD(0)
         // *********[12] ACONST_NULL
         // *********[13] PUTFIELD(jnt.Bench.Applet,parent)
        c_parent = c_CApplet.getField("parent",true);
         // *********[14] RETURN
      }
}
