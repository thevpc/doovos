package jjit.local.jnt.Bench.Bench._init__Ljnt_Bench_AppletLjava_io_InputStream_V_BD69B656;
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
 * jnt.Bench.Bench
 * <init>(Ljnt/Bench/Applet;Ljava/io/InputStream;)V
 * [count=20] [2] ALOAD(0) [3] LDC(8->"A BenchMark") [4] PUTFIELD(jnt.Bench.Bench,name) [5] ALOAD(0) [6] ACONST_NULL [7] PUTFIELD(jnt.Bench.Bench,targetClass) [8] ALOAD(0) [9] ACONST_NULL [10] PUTFIELD(jnt.Bench.Bench,subemail) [11] ALOAD(0) [12] ACONST_NULL [13] PUTFIELD(jnt.Bench.Bench,suburl) [14] ALOAD(0) [15] LDC(14->"Seconds") [16] PUTFIELD(jnt.Bench.Bench,units) [17] ALOAD(0) [18] ICONST_0(Integer{0}) [19] PUTFIELD(jnt.Bench.Bench,decimals) [20] ALOAD(0) [21] ICONST_1(Integer{1})
 */
public final class _init__004 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R8 = null;
      private KField c_name = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private KField c_targetClass = null;
      private KField c_subemail = null;
      private KField c_suburl = null;
      private static KReference R14 = null;
      private KField c_units = null;
      private KField c_decimals = null;
      private static final KInteger IONE = KInteger.ONE;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KRegister reg;
         // this_ref 0 ; r=7/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[2] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[3] LDC(8->"A BenchMark")
         // **REMOVED Substitution** s1_ref = R8;
         // *********[4] PUTFIELD(jnt.Bench.Bench,name)
         // **REMOVED Substitution** reg = R8;
         // **REMOVED Substitution** ref = this_ref;
        c_name.setInstanceValue(this_ref,R8);
         // *********[5] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[6] ACONST_NULL
         // **REMOVED Substitution** s1_ref = KReference.NULL;
         // *********[7] PUTFIELD(jnt.Bench.Bench,targetClass)
         // **REMOVED Substitution** reg = KReference.NULL;
         // **REMOVED Substitution** ref = this_ref;
        c_targetClass.setInstanceValue(this_ref,KReference.NULL);
         // *********[8] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[9] ACONST_NULL
         // **REMOVED Substitution** s1_ref = KReference.NULL;
         // *********[10] PUTFIELD(jnt.Bench.Bench,subemail)
         // **REMOVED Substitution** reg = KReference.NULL;
         // **REMOVED Substitution** ref = this_ref;
        c_subemail.setInstanceValue(this_ref,KReference.NULL);
         // *********[11] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[12] ACONST_NULL
         // **REMOVED Substitution** s1_ref = KReference.NULL;
         // *********[13] PUTFIELD(jnt.Bench.Bench,suburl)
         // **REMOVED Substitution** reg = KReference.NULL;
         // **REMOVED Substitution** ref = this_ref;
        c_suburl.setInstanceValue(this_ref,KReference.NULL);
         // *********[14] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[15] LDC(14->"Seconds")
         // **REMOVED Substitution** s1_ref = R14;
         // *********[16] PUTFIELD(jnt.Bench.Bench,units)
         // **REMOVED Substitution** reg = R14;
         // **REMOVED Substitution** ref = this_ref;
        c_units.setInstanceValue(this_ref,R14);
         // *********[17] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[18] ICONST_0(Integer{0})
         // **REMOVED Substitution** s1 = IZERO;
         // *********[19] PUTFIELD(jnt.Bench.Bench,decimals)
         // **REMOVED Substitution** reg = IZERO;
         // **REMOVED Substitution** ref = this_ref;
        c_decimals.setInstanceInt(this_ref,0);
         // *********[20] ALOAD(0)
        frame.push(this_ref);
         // *********[21] ICONST_1(Integer{1})
        frame.push(IONE);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[2] ALOAD(0)
         // *********[3] LDC(8->"A BenchMark")
        R8 = ((KReference)constants[8]);
         // *********[4] PUTFIELD(jnt.Bench.Bench,name)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_name = c_CBench.getField("name",true);
         // *********[5] ALOAD(0)
         // *********[6] ACONST_NULL
         // *********[7] PUTFIELD(jnt.Bench.Bench,targetClass)
        c_targetClass = c_CBench.getField("targetClass",true);
         // *********[8] ALOAD(0)
         // *********[9] ACONST_NULL
         // *********[10] PUTFIELD(jnt.Bench.Bench,subemail)
        c_subemail = c_CBench.getField("subemail",true);
         // *********[11] ALOAD(0)
         // *********[12] ACONST_NULL
         // *********[13] PUTFIELD(jnt.Bench.Bench,suburl)
        c_suburl = c_CBench.getField("suburl",true);
         // *********[14] ALOAD(0)
         // *********[15] LDC(14->"Seconds")
        R14 = ((KReference)constants[14]);
         // *********[16] PUTFIELD(jnt.Bench.Bench,units)
        c_units = c_CBench.getField("units",true);
         // *********[17] ALOAD(0)
         // *********[18] ICONST_0(Integer{0})
         // *********[19] PUTFIELD(jnt.Bench.Bench,decimals)
        c_decimals = c_CBench.getField("decimals",true);
         // *********[20] ALOAD(0)
         // *********[21] ICONST_1(Integer{1})
        c_next = instructions[(index + 1)];
      }
}
