package jjit.local.jnt.Bench.Applet.submissionDone_ZLjava_lang_String_V_44E63249;
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
 * submissionDone(ZLjava/lang/String;)V
 * [count=4] [4] ALOAD(0) [5] GETFIELD(jnt.Bench.Applet,submitButton,Ljava/awt/Button;) [6] ILOAD(1) [7] IFNE(10)
 */
public final class submissionDone_004 extends JJITAbstractInstruction implements Cloneable{
      private KField c_submitButton = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[4] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[5] GETFIELD(jnt.Bench.Applet,submitButton,Ljava/awt/Button;)
        frame.push(c_submitButton.getInstanceRef(((KReference)frame.getLocal(0))));
         // *********[6] ILOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[7] IFNE(10)
         // **REMOVED Substitution** index = frame.getLocal(1).intValue();
         // **REMOVED Substitution** jump = frame.getLocal(1).intValue() != 0;
        return ((frame.getLocal(1).intValue() != 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[4] ALOAD(0)
         // *********[5] GETFIELD(jnt.Bench.Applet,submitButton,Ljava/awt/Button;)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_submitButton = c_CApplet.getField("submitButton",true);
         // *********[6] ILOAD(1)
         // *********[7] IFNE(10)
        c_next = instructions[(index + 1)];
        c_label = instructions[5];
      }
}
