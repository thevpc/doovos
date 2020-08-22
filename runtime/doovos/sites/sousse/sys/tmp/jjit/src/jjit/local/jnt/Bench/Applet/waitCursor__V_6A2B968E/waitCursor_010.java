package jjit.local.jnt.Bench.Applet.waitCursor__V_6A2B968E;
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
 * waitCursor()V
 * [count=4] [15] ALOAD(0) [16] ALOAD(1) [17] CHECKCAST [18] PUTFIELD(jnt.Bench.Applet,parent)
 */
public final class waitCursor_010 extends JJITAbstractInstruction implements Cloneable{
      private KField c_parent = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KRegister reg;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[15] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[16] ALOAD(1)
         // **REMOVED Substitution** s1 = frame.getLocal(1);
         // *********[17] CHECKCAST
         // *********[18] PUTFIELD(jnt.Bench.Applet,parent)
         // **REMOVED Substitution** reg = frame.getLocal(1);
         // **REMOVED Substitution** ref = ((KReference)frame.getLocal(0));
        c_parent.setInstanceValue(((KReference)frame.getLocal(0)),frame.getLocal(1));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[15] ALOAD(0)
         // *********[16] ALOAD(1)
         // *********[17] CHECKCAST
         // *********[18] PUTFIELD(jnt.Bench.Applet,parent)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_parent = c_CApplet.getField("parent",true);
        c_next = instructions[(index + 1)];
      }
}
