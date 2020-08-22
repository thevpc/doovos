package jjit.local.jnt.Bench.Applet.main__Ljava_lang_String_V_4846D998;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Applet
 * main([Ljava/lang/String;)V
 * [count=6] [0] NEW(jnt.Bench.AppletFrame) [1] DUP [2] ALOAD(0) [3] ARRAYLENGTH [4] ICONST_1(Integer{1}) [5] IF_ICMPLT(10)
 */
public final class main_001 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CAppletFrame = null;
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_0 0 ; r=1/w=0 : NotCached
         // *********[0] NEW(jnt.Bench.AppletFrame)
        if(c_CAppletFrame == null){
          c_CAppletFrame = c_repo.getClassByName("jnt.Bench.AppletFrame");
        }
        s0_ref = memseg.allocObject(c_CAppletFrame);
         // *********[1] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[2] ALOAD(0)
         // **REMOVED Substitution** s1 = frame.getLocal(0);
         // *********[3] ARRAYLENGTH
         // **REMOVED Substitution** s1 = new KInteger(c_memman.getArraySize(((KReference)frame.getLocal(0))));
         // *********[4] ICONST_1(Integer{1})
         // **REMOVED Substitution** s2 = IONE;
         // *********[5] IF_ICMPLT(10)
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** jump = c_memman.getArraySize(((KReference)frame.getLocal(0))) < 1;
        return ((c_memman.getArraySize(((KReference)frame.getLocal(0))) < 1)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] NEW(jnt.Bench.AppletFrame)
        c_repo = process.getClassRepository();
         // *********[1] DUP
         // *********[2] ALOAD(0)
         // *********[3] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[4] ICONST_1(Integer{1})
         // *********[5] IF_ICMPLT(10)
        c_next = instructions[(index + 1)];
        c_label = instructions[2];
      }
}
