package jjit.local.jnt.Bench.SubmitDialog._init__Ljnt_Bench_AppletLjnt_Bench_Bench_V_CFC0D172;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.SubmitDialog
 * <init>(Ljnt/Bench/Applet;Ljnt/Bench/Bench;)V
 * [count=8] [134] PUTFIELD(jnt.Bench.SubmitDialog,os) [135] ALOAD(0) [136] ALOAD(0) [137] LDC(60->"Java VM name & version:") [138] ICONST_1(Integer{1}) [139] NEW(java.lang.StringBuffer) [140] DUP [141] INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
 */
public final class _init__048 extends JJITAbstractInstruction implements Cloneable{
      private KField c_os = null;
      private KClassRepository c_repo;
      private KClass c_CSubmitDialog = null;
      private static KReference R60 = null;
      private static final KInteger IONE = KInteger.ONE;
      private KClass c_CStringBuffer = null;
      private JJITInstruction c_next;
      private KMethod m_mth = null;
      private boolean m_mth_ignorable = false;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
        KReference s0_ref;
         // **REMOVED Unused Var** KReference ref;
        KRegister reg;
        KMemorySegment memseg = frame.getMemorySegment();
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        JJITInstruction nextInstr;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[134] PUTFIELD(jnt.Bench.SubmitDialog,os)
        reg = frame.pop();
         // **REMOVED Substitution** ref = frame.popRef();
        c_os.setInstanceValue(frame.popRef(),reg);
         // *********[135] ALOAD(0)
        frame.push(this_ref);
         // *********[136] ALOAD(0)
        frame.push(this_ref);
         // *********[137] LDC(60->"Java VM name & version:")
        frame.push(R60);
         // *********[138] ICONST_1(Integer{1})
        frame.push(IONE);
         // *********[139] NEW(java.lang.StringBuffer)
        if(c_CStringBuffer == null){
          c_CStringBuffer = c_repo.getClassByName("java.lang.StringBuffer");
        }
        s0_ref = memseg.allocObject(c_CStringBuffer);
         // *********[140] DUP
        frame.push(s0_ref);
         // **REMOVED Substitution** s1_ref = s0_ref;
         // *********[141] INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
        regs = new KRegister[1];
        if(m_mth == null){
          m_mth = c_CStringBuffer.getMethodBySignature("<init>()V");
          m_mth_ignorable = m_mth.isIgnorable();
        }
         // **REMOVED Substitution** ref = s0_ref;
        regs[0] = s0_ref;
        if(m_mth_ignorable){
          nextInstr = c_next;
        }else{
          frame.setProgramCounter(48);
           // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
          nextInstr = ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
        }
        return nextInstr;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[134] PUTFIELD(jnt.Bench.SubmitDialog,os)
        c_repo = process.getClassRepository();
        c_CSubmitDialog = c_repo.getClassByName("jnt.Bench.SubmitDialog");
        c_os = c_CSubmitDialog.getField("os",true);
         // *********[135] ALOAD(0)
         // *********[136] ALOAD(0)
         // *********[137] LDC(60->"Java VM name & version:")
        R60 = ((KReference)constants[60]);
         // *********[138] ICONST_1(Integer{1})
         // *********[139] NEW(java.lang.StringBuffer)
        c_repo = process.getClassRepository();
         // *********[140] DUP
         // *********[141] INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
        c_next = instructions[(index + 1)];
      }
}
