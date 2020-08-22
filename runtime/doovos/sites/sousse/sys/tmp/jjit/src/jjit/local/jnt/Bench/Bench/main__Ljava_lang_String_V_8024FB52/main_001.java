package jjit.local.jnt.Bench.Bench.main__Ljava_lang_String_V_8024FB52;
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
 * jnt.Bench.Bench
 * main([Ljava/lang/String;)V
 * [count=7] [0] NEW(jnt.Bench.Bench) [1] DUP [2] ACONST_NULL [3] ALOAD(0) [4] ARRAYLENGTH [5] ICONST_1(Integer{1}) [6] IF_ICMPLT(11)
 */
public final class main_001 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CBench = null;
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
         // *********[0] NEW(jnt.Bench.Bench)
        s0_ref = memseg.allocObject(c_CBench);
         // *********[1] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[2] ACONST_NULL
        frame.push(KReference.NULL);
         // *********[3] ALOAD(0)
         // **REMOVED Substitution** s1 = frame.getLocal(0);
         // *********[4] ARRAYLENGTH
         // **REMOVED Substitution** s1 = new KInteger(c_memman.getArraySize(((KReference)frame.getLocal(0))));
         // *********[5] ICONST_1(Integer{1})
         // **REMOVED Substitution** s2 = IONE;
         // *********[6] IF_ICMPLT(11)
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** jump = c_memman.getArraySize(((KReference)frame.getLocal(0))) < 1;
        return ((c_memman.getArraySize(((KReference)frame.getLocal(0))) < 1)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] NEW(jnt.Bench.Bench)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
         // *********[1] DUP
         // *********[2] ACONST_NULL
         // *********[3] ALOAD(0)
         // *********[4] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[5] ICONST_1(Integer{1})
         // *********[6] IF_ICMPLT(11)
        c_next = instructions[(index + 1)];
        c_label = instructions[2];
      }
}
