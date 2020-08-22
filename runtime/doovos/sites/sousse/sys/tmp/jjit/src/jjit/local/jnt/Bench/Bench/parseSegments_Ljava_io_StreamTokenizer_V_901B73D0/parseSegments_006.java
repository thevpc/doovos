package jjit.local.jnt.Bench.Bench.parseSegments_Ljava_io_StreamTokenizer_V_901B73D0;
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
 * parseSegments(Ljava/io/StreamTokenizer;)V
 * [count=13] [9] LDC(57->"") [10] ASTORE(4) [11] ALOAD(0) [12] GETFIELD(jnt.Bench.Bench,units,Ljava/lang/String;) [13] ASTORE(5) [14] ACONST_NULL [15] ASTORE(6) [16] ALOAD(0) [17] GETFIELD(jnt.Bench.Bench,decimals,I) [18] ISTORE(7) [19] ILOAD(3) [20] BIPUSH(-3) [21] IF_ICMPEQ(25)
 */
public final class parseSegments_006 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R57 = null;
      private KField c_units = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private KField c_decimals = null;
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // local_3 3 ; r=1/w=0 : NotCached
         // local_4 4 ; r=0/w=1 : NotCached
         // local_5 5 ; r=0/w=1 : NotCached
         // local_6 6 ; r=0/w=1 : NotCached
         // local_7 7 ; r=0/w=1 : NotCached
         // *********[9] LDC(57->"")
         // **REMOVED Substitution** s0_ref = R57;
         // *********[10] ASTORE(4)
        frame.setLocal(4,R57);
         // *********[11] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[12] GETFIELD(jnt.Bench.Bench,units,Ljava/lang/String;)
         // **REMOVED Substitution** s0_ref = c_units.getInstanceRef(this_ref);
         // *********[13] ASTORE(5)
        frame.setLocal(5,c_units.getInstanceRef(this_ref));
         // *********[14] ACONST_NULL
         // **REMOVED Substitution** s0_ref = KReference.NULL;
         // *********[15] ASTORE(6)
        frame.setLocal(6,KReference.NULL);
         // *********[16] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[17] GETFIELD(jnt.Bench.Bench,decimals,I)
         // **REMOVED Substitution** s0 = new KInteger(c_decimals.getInstanceInt(this_ref));
         // *********[18] ISTORE(7)
        frame.setLocal(7,new KInteger(c_decimals.getInstanceInt(this_ref)));
         // *********[19] ILOAD(3)
         // **REMOVED Substitution** s0 = frame.getLocal(3);
         // *********[20] BIPUSH(-3)
         // **REMOVED Substitution** s1 = IM3;
         // *********[21] IF_ICMPEQ(25)
         // **REMOVED Substitution** index = -3;
         // **REMOVED Substitution** jump = frame.getLocal(3).intValue() == -3;
        return ((frame.getLocal(3).intValue() == -3)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[9] LDC(57->"")
        R57 = ((KReference)constants[57]);
         // *********[10] ASTORE(4)
         // *********[11] ALOAD(0)
         // *********[12] GETFIELD(jnt.Bench.Bench,units,Ljava/lang/String;)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_units = c_CBench.getField("units",true);
         // *********[13] ASTORE(5)
         // *********[14] ACONST_NULL
         // *********[15] ASTORE(6)
         // *********[16] ALOAD(0)
         // *********[17] GETFIELD(jnt.Bench.Bench,decimals,I)
        c_decimals = c_CBench.getField("decimals",true);
         // *********[18] ISTORE(7)
         // *********[19] ILOAD(3)
         // *********[20] BIPUSH(-3)
         // *********[21] IF_ICMPEQ(25)
        c_next = instructions[(index + 1)];
        c_label = instructions[7];
      }
}
