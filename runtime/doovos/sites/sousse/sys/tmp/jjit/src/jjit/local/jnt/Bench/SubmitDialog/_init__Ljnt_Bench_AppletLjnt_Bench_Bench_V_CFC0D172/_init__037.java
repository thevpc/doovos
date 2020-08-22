package jjit.local.jnt.Bench.SubmitDialog._init__Ljnt_Bench_AppletLjnt_Bench_Bench_V_CFC0D172;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.SubmitDialog
 * <init>(Ljnt/Bench/Applet;Ljnt/Bench/Bench;)V
 * [count=7] [107] PUTFIELD(jnt.Bench.SubmitDialog,brand) [108] ALOAD(0) [109] ALOAD(0) [110] LDC(49->"CPU type & Speed:") [111] ICONST_1(Integer{1}) [112] LDC(41->"") [113] INVOKEVIRTUAL(jnt.Bench.SubmitDialog,addField(Ljava/lang/String;ILjava/lang/String;)Ljava/awt/TextComponent;)
 */
public final class _init__037 extends JJITAbstractInstruction implements Cloneable{
      private KField c_brand = null;
      private KClassRepository c_repo;
      private KClass c_CSubmitDialog = null;
      private static KReference R49 = null;
      private static final KInteger IONE = KInteger.ONE;
      private static KReference R41 = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KReference s3_ref;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** KReference ref;
        KRegister reg;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[107] PUTFIELD(jnt.Bench.SubmitDialog,brand)
        reg = frame.pop();
         // **REMOVED Substitution** ref = frame.popRef();
        c_brand.setInstanceValue(frame.popRef(),reg);
         // *********[108] ALOAD(0)
        frame.push(this_ref);
         // *********[109] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[110] LDC(49->"CPU type & Speed:")
         // **REMOVED Substitution** s1_ref = R49;
         // *********[111] ICONST_1(Integer{1})
         // **REMOVED Substitution** s2 = IONE;
         // *********[112] LDC(41->"")
         // **REMOVED Substitution** s3_ref = R41;
         // *********[113] INVOKEVIRTUAL(jnt.Bench.SubmitDialog,addField(Ljava/lang/String;ILjava/lang/String;)Ljava/awt/TextComponent;)
        regs = new KRegister[4];
        regs[3] = R41;
        regs[2] = IONE;
        regs[1] = R49;
         // **REMOVED Substitution** ref = this_ref;
        regs[0] = this_ref;
        frame.setProgramCounter(37);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("addField(Ljava/lang/String;ILjava/lang/String;)Ljava/awt/TextComponent;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("addField(Ljava/lang/String;ILjava/lang/String;)Ljava/awt/TextComponent;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[107] PUTFIELD(jnt.Bench.SubmitDialog,brand)
        c_repo = process.getClassRepository();
        c_CSubmitDialog = c_repo.getClassByName("jnt.Bench.SubmitDialog");
        c_brand = c_CSubmitDialog.getField("brand",true);
         // *********[108] ALOAD(0)
         // *********[109] ALOAD(0)
         // *********[110] LDC(49->"CPU type & Speed:")
        R49 = ((KReference)constants[49]);
         // *********[111] ICONST_1(Integer{1})
         // *********[112] LDC(41->"")
        R41 = ((KReference)constants[41]);
         // *********[113] INVOKEVIRTUAL(jnt.Bench.SubmitDialog,addField(Ljava/lang/String;ILjava/lang/String;)Ljava/awt/TextComponent;)
        c_memman = process.getMemoryManager();
      }
}
