package jjit.local.jnt.scimark2.applet.execute_Ljnt_Bench_Bench__D_70A4923B;
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
 * jnt.scimark2.applet
 * execute(Ljnt/Bench/Bench;)[D
 * [count=6] [0] BIPUSH(6) [1] NEWARRAY [2] ASTORE(2) [3] NEW(jnt.scimark2.Random) [4] DUP [5] LDC(3->"101010")
 */
public final class execute_001 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CRandom = null;
      private static final KInteger I101010 = new KInteger(101010);
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // local_2 2 ; r=0/w=1 : NotCached
         // *********[0] BIPUSH(6)
         // **REMOVED Substitution** s0 = I6;
         // *********[1] NEWARRAY
         // **REMOVED Substitution** s0_ref = memseg.allocDoubleArray(6);
         // *********[2] ASTORE(2)
        frame.setLocal(2,memseg.allocDoubleArray(6));
         // *********[3] NEW(jnt.scimark2.Random)
        if(c_CRandom == null){
          c_CRandom = c_repo.getClassByName("jnt.scimark2.Random");
        }
        s0_ref = memseg.allocObject(c_CRandom);
         // *********[4] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[5] LDC(3->"101010")
        frame.push(I101010);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] BIPUSH(6)
         // *********[1] NEWARRAY
         // *********[2] ASTORE(2)
         // *********[3] NEW(jnt.scimark2.Random)
        c_repo = process.getClassRepository();
         // *********[4] DUP
         // *********[5] LDC(3->"101010")
        c_next = instructions[(index + 1)];
      }
}
