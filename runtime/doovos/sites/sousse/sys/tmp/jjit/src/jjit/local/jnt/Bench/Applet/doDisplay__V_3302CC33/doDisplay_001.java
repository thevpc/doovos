package jjit.local.jnt.Bench.Applet.doDisplay__V_3302CC33;
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
 * doDisplay()V
 * [count=4] [0] ALOAD(0) [1] GETFIELD(jnt.Bench.Applet,segment,I) [2] ICONST_M1(Integer{-1}) [3] IF_ICMPNE(46)
 */
public final class doDisplay_001 extends JJITAbstractInstruction implements Cloneable{
      private KField c_segment = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[0] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[1] GETFIELD(jnt.Bench.Applet,segment,I)
         // **REMOVED Substitution** s0 = new KInteger(c_segment.getInstanceInt(((KReference)frame.getLocal(0))));
         // *********[2] ICONST_M1(Integer{-1})
         // **REMOVED Substitution** s1 = IM1;
         // *********[3] IF_ICMPNE(46)
         // **REMOVED Substitution** index = -1;
         // **REMOVED Substitution** jump = c_segment.getInstanceInt(((KReference)frame.getLocal(0))) != -1;
        return ((c_segment.getInstanceInt(((KReference)frame.getLocal(0))) != -1)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] GETFIELD(jnt.Bench.Applet,segment,I)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_segment = c_CApplet.getField("segment",true);
         // *********[2] ICONST_M1(Integer{-1})
         // *********[3] IF_ICMPNE(46)
        c_next = instructions[(index + 1)];
        c_label = instructions[20];
      }
}
