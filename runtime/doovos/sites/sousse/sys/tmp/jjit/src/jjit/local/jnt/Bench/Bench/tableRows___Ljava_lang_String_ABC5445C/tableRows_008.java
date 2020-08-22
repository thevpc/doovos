package jjit.local.jnt.Bench.Bench.tableRows___Ljava_lang_String_ABC5445C;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.jvm.reflect.KMethod;
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
 * [count=6] [40] ALOAD(0) [41] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;) [42] ILOAD(3) [43] AALOAD [44] GETFIELD(jnt.Bench.Segment,decimals,I) [45] INVOKESTATIC(jnt.Bench.Formatter,format([DI)[Ljava/lang/String;)
 */
public final class tableRows_008 extends JJITAbstractInstruction implements Cloneable{
      private KField c_segments = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private KMemoryManager c_memman;
      private KField c_decimals = null;
      private KClass c_CFormatter = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** KReference ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=0 : NotCached
         // *********[40] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[41] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;)
         // **REMOVED Substitution** s0_ref = c_segments.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[42] ILOAD(3)
         // **REMOVED Substitution** s1 = frame.getLocal(3);
         // *********[43] AALOAD
         // **REMOVED Substitution** index = frame.getLocal(3).intValue();
         // **REMOVED Substitution** ref = c_segments.getInstanceRef(((KReference)frame.getLocal(0)));
         // **REMOVED Substitution** s0_ref = c_memman.getReferenceArray(c_segments.getInstanceRef(((KReference)frame.getLocal(0))),frame.getLocal(3).intValue());
         // *********[44] GETFIELD(jnt.Bench.Segment,decimals,I)
        if(c_decimals == null){
          c_decimals = c_repo.getClassByName("jnt.Bench.Segment").getField("decimals",true);
        }
         // **REMOVED Substitution** s0 = c_decimals.getInstanceValue(c_memman.getReferenceArray(c_segments.getInstanceRef(((KReference)frame.getLocal(0))),frame.getLocal(3).intValue()));
         // *********[45] INVOKESTATIC(jnt.Bench.Formatter,format([DI)[Ljava/lang/String;)
        regs = new KRegister[2];
        regs[1] = c_decimals.getInstanceValue(c_memman.getReferenceArray(c_segments.getInstanceRef(((KReference)frame.getLocal(0))),frame.getLocal(3).intValue()));
        regs[0] = frame.pop();
        if(c_CFormatter == null){
          c_CFormatter = c_repo.getClassByName("jnt.Bench.Formatter");
        }
        if(m_mth == null){
          m_mth = c_CFormatter.getMethodBySignature("format([DI)[Ljava/lang/String;");
        }
        frame.setProgramCounter(8);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[40] ALOAD(0)
         // *********[41] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_segments = c_CBench.getField("segments",true);
         // *********[42] ILOAD(3)
         // *********[43] AALOAD
        c_memman = process.getMemoryManager();
         // *********[44] GETFIELD(jnt.Bench.Segment,decimals,I)
        c_repo = process.getClassRepository();
         // *********[45] INVOKESTATIC(jnt.Bench.Formatter,format([DI)[Ljava/lang/String;)
        c_repo = process.getClassRepository();
      }
}
