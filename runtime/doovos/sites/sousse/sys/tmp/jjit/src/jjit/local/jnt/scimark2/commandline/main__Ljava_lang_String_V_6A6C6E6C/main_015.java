package jjit.local.jnt.scimark2.commandline.main__Ljava_lang_String_V_6A6C6E6C;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.commandline
 * main([Ljava/lang/String;)V
 * [count=11] [39] LDC(14->"1048576") [40] ISTORE(3) [41] SIPUSH(Integer{1000}) [42] ISTORE(4) [43] LDC(15->"100000") [44] ISTORE(5) [45] LDC(16->"1000000") [46] ISTORE(6) [47] SIPUSH(Integer{1000}) [48] ISTORE(7) [49] IINC(8,1)
 */
public final class main_015 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_3 3 ; r=0/w=1 : NotCached
         // local_4 4 ; r=0/w=1 : NotCached
         // local_5 5 ; r=0/w=1 : NotCached
         // local_6 6 ; r=0/w=1 : NotCached
         // local_7 7 ; r=0/w=1 : NotCached
         // local_8 8 ; r=1/w=1 : Cached
        int local_8 = frame.getLocal(8).intValue();
         // *********[39] LDC(14->"1048576")
         // **REMOVED Substitution** s0 = I1048576;
         // *********[40] ISTORE(3)
        frame.setLocal(3,new KInteger(1048576));
         // *********[41] SIPUSH(Integer{1000})
         // **REMOVED Substitution** s0 = I1000;
         // *********[42] ISTORE(4)
        frame.setLocal(4,new KInteger(1000));
         // *********[43] LDC(15->"100000")
         // **REMOVED Substitution** s0 = I100000;
         // *********[44] ISTORE(5)
        frame.setLocal(5,new KInteger(100000));
         // *********[45] LDC(16->"1000000")
         // **REMOVED Substitution** s0 = I1000000;
         // *********[46] ISTORE(6)
        frame.setLocal(6,new KInteger(1000000));
         // *********[47] SIPUSH(Integer{1000})
         // **REMOVED Substitution** s0 = I1000;
         // *********[48] ISTORE(7)
        frame.setLocal(7,new KInteger(1000));
         // *********[49] IINC(8,1)
         // **REMOVED Substitution** local_8 = (local_8 + 1);
        frame.setLocal(8,new KInteger((local_8 + 1)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[39] LDC(14->"1048576")
         // *********[40] ISTORE(3)
         // *********[41] SIPUSH(Integer{1000})
         // *********[42] ISTORE(4)
         // *********[43] LDC(15->"100000")
         // *********[44] ISTORE(5)
         // *********[45] LDC(16->"1000000")
         // *********[46] ISTORE(6)
         // *********[47] SIPUSH(Integer{1000})
         // *********[48] ISTORE(7)
         // *********[49] IINC(8,1)
        c_next = instructions[(index + 1)];
      }
}
