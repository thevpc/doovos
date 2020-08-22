package jjit.local.jnt.scimark2.commandline.main__Ljava_lang_String_V_6A6C6E6C;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.commandline
 * main([Ljava/lang/String;)V
 * [count=6] [60] BIPUSH(6) [61] NEWARRAY [62] ASTORE(8) [63] NEW(jnt.scimark2.Random) [64] DUP [65] LDC(21->"101010")
 */
public final class main_022 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CRandom = null;
      private static final KInteger I101010 = new KInteger(101010);
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // local_8 8 ; r=0/w=1 : NotCached
         // *********[60] BIPUSH(6)
         // **REMOVED Substitution** s0 = I6;
         // *********[61] NEWARRAY
         // **REMOVED Substitution** s0_ref = memseg.allocDoubleArray(6);
         // *********[62] ASTORE(8)
        frame.setLocal(8,memseg.allocDoubleArray(6));
         // *********[63] NEW(jnt.scimark2.Random)
        if(c_CRandom == null){
          c_CRandom = c_repo.getClassByName("jnt.scimark2.Random");
        }
        s0_ref = memseg.allocObject(c_CRandom);
         // *********[64] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[65] LDC(21->"101010")
        frame.push(I101010);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[60] BIPUSH(6)
         // *********[61] NEWARRAY
         // *********[62] ASTORE(8)
         // *********[63] NEW(jnt.scimark2.Random)
        c_repo = process.getClassRepository();
         // *********[64] DUP
         // *********[65] LDC(21->"101010")
        c_next = instructions[(index + 1)];
      }
}
