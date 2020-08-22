package jjit.local.jnt.Bench.Bench.parseEntries_Ljava_io_StreamTokenizer_V_6B9C6DF2;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Bench
 * parseEntries(Ljava/io/StreamTokenizer;)V
 * [count=13] [11] ALOAD(0) [12] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;) [13] ARRAYLENGTH [14] NEWARRAY [15] ASTORE(5) [16] ALOAD(0) [17] GETFIELD(jnt.Bench.Bench,entries,Ljava/util/Vector;) [18] NEW(jnt.Bench.Entry) [19] DUP [20] ALOAD(0) [21] ALOAD(1) [22] LDC(69->"Entry Name") [23] INVOKEVIRTUAL(jnt.Bench.Bench,parseString(Ljava/io/StreamTokenizer;Ljava/lang/String;)Ljava/lang/String;)
 */
public final class parseEntries_004 extends JJITAbstractInstruction implements Cloneable{
      private KField c_segments = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private KMemoryManager c_memman;
      private KField c_entries = null;
      private KClass c_CEntry = null;
      private static KReference R69 = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KReference s3_ref;
         // **REMOVED Unused Var** KRegister s2;
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=3/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // local_1 1 ; r=1/w=0 : NotCached
         // local_5 5 ; r=0/w=1 : NotCached
         // *********[11] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[12] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;)
         // **REMOVED Substitution** s0_ref = c_segments.getInstanceRef(this_ref);
         // *********[13] ARRAYLENGTH
         // **REMOVED Substitution** s0 = new KInteger(c_memman.getArraySize(c_segments.getInstanceRef(this_ref)));
         // *********[14] NEWARRAY
         // **REMOVED Substitution** s0_ref = memseg.allocDoubleArray(c_memman.getArraySize(c_segments.getInstanceRef(this_ref)));
         // *********[15] ASTORE(5)
        frame.setLocal(5,memseg.allocDoubleArray(c_memman.getArraySize(c_segments.getInstanceRef(this_ref))));
         // *********[16] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[17] GETFIELD(jnt.Bench.Bench,entries,Ljava/util/Vector;)
        frame.push(c_entries.getInstanceRef(this_ref));
         // *********[18] NEW(jnt.Bench.Entry)
        if(c_CEntry == null){
          c_CEntry = c_repo.getClassByName("jnt.Bench.Entry");
        }
        s0_ref = memseg.allocObject(c_CEntry);
         // *********[19] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[20] ALOAD(0)
         // **REMOVED Substitution** s1_ref = this_ref;
         // *********[21] ALOAD(1)
         // **REMOVED Substitution** s2 = frame.getLocal(1);
         // *********[22] LDC(69->"Entry Name")
         // **REMOVED Substitution** s3_ref = R69;
         // *********[23] INVOKEVIRTUAL(jnt.Bench.Bench,parseString(Ljava/io/StreamTokenizer;Ljava/lang/String;)Ljava/lang/String;)
        regs = new KRegister[3];
        regs[2] = R69;
        regs[1] = frame.getLocal(1);
         // **REMOVED Substitution** ref = this_ref;
        regs[0] = this_ref;
        frame.setProgramCounter(4);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("parseString(Ljava/io/StreamTokenizer;Ljava/lang/String;)Ljava/lang/String;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("parseString(Ljava/io/StreamTokenizer;Ljava/lang/String;)Ljava/lang/String;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[11] ALOAD(0)
         // *********[12] GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_segments = c_CBench.getField("segments",true);
         // *********[13] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[14] NEWARRAY
         // *********[15] ASTORE(5)
         // *********[16] ALOAD(0)
         // *********[17] GETFIELD(jnt.Bench.Bench,entries,Ljava/util/Vector;)
        c_entries = c_CBench.getField("entries",true);
         // *********[18] NEW(jnt.Bench.Entry)
        c_repo = process.getClassRepository();
         // *********[19] DUP
         // *********[20] ALOAD(0)
         // *********[21] ALOAD(1)
         // *********[22] LDC(69->"Entry Name")
        R69 = ((KReference)constants[69]);
         // *********[23] INVOKEVIRTUAL(jnt.Bench.Bench,parseString(Ljava/io/StreamTokenizer;Ljava/lang/String;)Ljava/lang/String;)
      }
}
