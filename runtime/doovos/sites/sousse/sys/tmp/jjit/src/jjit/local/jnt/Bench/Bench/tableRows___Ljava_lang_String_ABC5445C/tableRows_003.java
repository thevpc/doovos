package jjit.local.jnt.Bench.Bench.tableRows___Ljava_lang_String_ABC5445C;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Bench
 * tableRows()[Ljava/lang/String;
 * [count=13] [1] ANEWARRAY(40) [2] ASTORE(1) [3] ALOAD(1) [4] ICONST_0(Integer{0}) [5] ALOAD(1) [6] ICONST_1(Integer{1}) [7] LDC(57->"") [8] DUP_X2Type1 [9] AASTORE [10] AASTORE [11] ALOAD(1) [12] ALOAD(0) [13] INVOKEVIRTUAL(jnt.Bench.Bench,getEntries()[Ljava/lang/String;)
 */
public final class tableRows_003 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private KClassRepository c_repo;
      private KClass c_CString = null;
      private static KReference R57 = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s5;
         // **REMOVED Unused Var** KRegister s4;
         // **REMOVED Unused Var** KReference s4_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** KProcess process = frame.getProcess();
         // **REMOVED Unused Var** int index = 0;
        KReference ref;
         // **REMOVED Unused Var** KRegister m_r;
         // **REMOVED Unused Var** KRegister m_r2;
         // **REMOVED Unused Var** KRegister m_r3;
         // **REMOVED Unused Var** KReference m_r4;
         // **REMOVED Unused Var** KReference m_r5;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=3/w=1 : Cached
        KRegister local_1;
         // *********[1] ANEWARRAY(40)
         // **REMOVED Substitution** index = frame.popInt();
        if(c_CString == null){
          c_CString = c_repo.getClassByName("java.lang.String");
        }
         // **REMOVED Substitution** s0_ref = c_memman.allocRefArray(c_CString,frame.popInt());
         // *********[2] ASTORE(1)
        local_1 = c_memman.allocRefArray(c_CString,frame.popInt());
         // *********[3] ALOAD(1)
         // **REMOVED Substitution** s0 = local_1;
         // *********[4] ICONST_0(Integer{0})
         // **REMOVED Substitution** s1 = IZERO;
         // *********[5] ALOAD(1)
         // **REMOVED Substitution** s2 = local_1;
         // *********[6] ICONST_1(Integer{1})
         // **REMOVED Substitution** s3 = IONE;
         // *********[7] LDC(57->"")
         // **REMOVED Substitution** s4_ref = R57;
         // *********[8] DUP_X2Type1
         // **REMOVED Substitution** m_r = R57;
         // **REMOVED Substitution** m_r2 = IONE;
         // **REMOVED Substitution** m_r3 = local_1;
         // **REMOVED Substitution** s2 = R57;
         // **REMOVED Substitution** s3 = local_1;
         // **REMOVED Substitution** s4 = IONE;
         // **REMOVED Substitution** s5 = R57;
         // *********[9] AASTORE
         // **REMOVED Substitution** m_r4 = R57;
         // **REMOVED Substitution** index = 1;
        c_memman.setReferenceArray(((KReference)local_1),1,R57);
         // *********[10] AASTORE
         // **REMOVED Substitution** m_r5 = R57;
         // **REMOVED Substitution** index = 0;
        c_memman.setReferenceArray(((KReference)local_1),0,R57);
         // *********[11] ALOAD(1)
        frame.push(local_1);
         // *********[12] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[13] INVOKEVIRTUAL(jnt.Bench.Bench,getEntries()[Ljava/lang/String;)
        regs = new KRegister[1];
        ref = ((KReference)frame.getLocal(0));
        regs[0] = ref;
        frame.setProgramCounter(3);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getEntries()[Ljava/lang/String;"),regs);
        frame.setLocal(1,local_1);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getEntries()[Ljava/lang/String;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[1] ANEWARRAY(40)
        c_memman = process.getMemoryManager();
        c_repo = process.getClassRepository();
         // *********[2] ASTORE(1)
         // *********[3] ALOAD(1)
         // *********[4] ICONST_0(Integer{0})
         // *********[5] ALOAD(1)
         // *********[6] ICONST_1(Integer{1})
         // *********[7] LDC(57->"")
        R57 = ((KReference)constants[57]);
         // *********[8] DUP_X2Type1
         // *********[9] AASTORE
         // *********[10] AASTORE
         // *********[11] ALOAD(1)
         // *********[12] ALOAD(0)
         // *********[13] INVOKEVIRTUAL(jnt.Bench.Bench,getEntries()[Ljava/lang/String;)
      }
}
