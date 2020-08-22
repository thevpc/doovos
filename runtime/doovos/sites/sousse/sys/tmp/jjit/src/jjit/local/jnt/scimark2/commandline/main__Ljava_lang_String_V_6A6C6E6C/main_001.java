package jjit.local.jnt.scimark2.commandline.main__Ljava_lang_String_V_6A6C6E6C;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.commandline
 * main([Ljava/lang/String;)V
 * [count=15] [0] LDC(2->"2.0") [1] DSTORE(1) [2] SIPUSH(Integer{1024}) [3] ISTORE(3) [4] BIPUSH(100) [5] ISTORE(4) [6] SIPUSH(Integer{1000}) [7] ISTORE(5) [8] SIPUSH(Integer{5000}) [9] ISTORE(6) [10] BIPUSH(100) [11] ISTORE(7) [12] ALOAD(0) [13] ARRAYLENGTH [14] IFLE(60)
 */
public final class main_001 extends JJITAbstractInstruction implements Cloneable{
      private static final KDouble D2_0 = new KDouble(2.0D);
      private KMemoryManager c_memman;
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=0/w=1 : NotCached
         // local_3 3 ; r=0/w=1 : NotCached
         // local_4 4 ; r=0/w=1 : NotCached
         // local_5 5 ; r=0/w=1 : NotCached
         // local_6 6 ; r=0/w=1 : NotCached
         // local_7 7 ; r=0/w=1 : NotCached
         // *********[0] LDC(2->"2.0")
         // **REMOVED Substitution** s0 = D2_0;
         // *********[1] DSTORE(1)
        frame.setLocal(1,D2_0);
         // *********[2] SIPUSH(Integer{1024})
         // **REMOVED Substitution** s0 = I1024;
         // *********[3] ISTORE(3)
        frame.setLocal(3,new KInteger(1024));
         // *********[4] BIPUSH(100)
         // **REMOVED Substitution** s0 = I100;
         // *********[5] ISTORE(4)
        frame.setLocal(4,new KInteger(100));
         // *********[6] SIPUSH(Integer{1000})
         // **REMOVED Substitution** s0 = I1000;
         // *********[7] ISTORE(5)
        frame.setLocal(5,new KInteger(1000));
         // *********[8] SIPUSH(Integer{5000})
         // **REMOVED Substitution** s0 = I5000;
         // *********[9] ISTORE(6)
        frame.setLocal(6,new KInteger(5000));
         // *********[10] BIPUSH(100)
         // **REMOVED Substitution** s0 = I100;
         // *********[11] ISTORE(7)
        frame.setLocal(7,new KInteger(100));
         // *********[12] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[13] ARRAYLENGTH
         // **REMOVED Substitution** s0 = new KInteger(c_memman.getArraySize(((KReference)frame.getLocal(0))));
         // *********[14] IFLE(60)
         // **REMOVED Substitution** index = c_memman.getArraySize(((KReference)frame.getLocal(0)));
         // **REMOVED Substitution** jump = c_memman.getArraySize(((KReference)frame.getLocal(0))) <= 0;
        return ((c_memman.getArraySize(((KReference)frame.getLocal(0))) <= 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] LDC(2->"2.0")
         // *********[1] DSTORE(1)
         // *********[2] SIPUSH(Integer{1024})
         // *********[3] ISTORE(3)
         // *********[4] BIPUSH(100)
         // *********[5] ISTORE(4)
         // *********[6] SIPUSH(Integer{1000})
         // *********[7] ISTORE(5)
         // *********[8] SIPUSH(Integer{5000})
         // *********[9] ISTORE(6)
         // *********[10] BIPUSH(100)
         // *********[11] ISTORE(7)
         // *********[12] ALOAD(0)
         // *********[13] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[14] IFLE(60)
        c_next = instructions[(index + 1)];
        c_label = instructions[21];
      }
}
