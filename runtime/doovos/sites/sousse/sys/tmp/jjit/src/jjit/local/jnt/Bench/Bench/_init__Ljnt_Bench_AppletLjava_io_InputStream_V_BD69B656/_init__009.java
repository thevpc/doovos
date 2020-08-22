package jjit.local.jnt.Bench.Bench._init__Ljnt_Bench_AppletLjava_io_InputStream_V_BD69B656;
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
 * jnt.Bench.Bench
 * <init>(Ljnt/Bench/Applet;Ljava/io/InputStream;)V
 * [count=19] [28] PUTFIELD(jnt.Bench.Bench,entries) [29] ALOAD(0) [30] ACONST_NULL [31] PUTFIELD(jnt.Bench.Bench,applet) [32] ALOAD(0) [33] ICONST_1(Integer{1}) [34] PUTFIELD(jnt.Bench.Bench,ascending) [35] ALOAD(0) [36] ICONST_M1(Integer{-1}) [37] PUTFIELD(jnt.Bench.Bench,specpos) [38] ALOAD(0) [39] ICONST_0(Integer{0}) [40] PUTFIELD(jnt.Bench.Bench,timerAPIused) [41] ALOAD(0) [42] ALOAD(1) [43] PUTFIELD(jnt.Bench.Bench,applet) [44] ALOAD(0) [45] ALOAD(2) [46] INVOKEVIRTUAL(jnt.Bench.Bench,parseDescriptor(Ljava/io/InputStream;)V)
 */
public final class _init__009 extends JJITAbstractInstruction implements Cloneable{
      private KField c_entries = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private KField c_applet = null;
      private static final KInteger IONE = KInteger.ONE;
      private KField c_ascending = null;
      private KField c_specpos = null;
      private static final KInteger IZERO = KInteger.ZERO;
      private KField c_timerAPIused = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** KReference ref;
        KRegister reg;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=6/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // local_1 1 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[28] PUTFIELD(jnt.Bench.Bench,entries)
        reg = frame.pop();
         // **REMOVED Substitution** ref = frame.popRef();
        c_entries.setInstanceValue(frame.popRef(),reg);
         // *********[29] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[30] ACONST_NULL
         // **REMOVED Substitution** s1_ref = KReference.NULL;
         // *********[31] PUTFIELD(jnt.Bench.Bench,applet)
         // **REMOVED Substitution** reg = KReference.NULL;
         // **REMOVED Substitution** ref = this_ref;
        c_applet.setInstanceValue(this_ref,KReference.NULL);
         // *********[32] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[33] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[34] PUTFIELD(jnt.Bench.Bench,ascending)
         // **REMOVED Substitution** reg = IONE;
         // **REMOVED Substitution** ref = this_ref;
        c_ascending.setInstanceValue(this_ref,IONE);
         // *********[35] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[36] ICONST_M1(Integer{-1})
         // **REMOVED Substitution** s1 = IM1;
         // *********[37] PUTFIELD(jnt.Bench.Bench,specpos)
         // **REMOVED Substitution** reg = IM1;
         // **REMOVED Substitution** ref = this_ref;
        c_specpos.setInstanceInt(this_ref,-1);
         // *********[38] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[39] ICONST_0(Integer{0})
         // **REMOVED Substitution** s1 = IZERO;
         // *********[40] PUTFIELD(jnt.Bench.Bench,timerAPIused)
         // **REMOVED Substitution** reg = IZERO;
         // **REMOVED Substitution** ref = this_ref;
        c_timerAPIused.setInstanceValue(this_ref,IZERO);
         // *********[41] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[42] ALOAD(1)
         // **REMOVED Substitution** s1 = frame.getLocal(1);
         // *********[43] PUTFIELD(jnt.Bench.Bench,applet)
         // **REMOVED Substitution** reg = frame.getLocal(1);
         // **REMOVED Substitution** ref = this_ref;
        c_applet.setInstanceValue(this_ref,frame.getLocal(1));
         // *********[44] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[45] ALOAD(2)
         // **REMOVED Substitution** s1 = frame.getLocal(2);
         // *********[46] INVOKEVIRTUAL(jnt.Bench.Bench,parseDescriptor(Ljava/io/InputStream;)V)
        regs = new KRegister[2];
        regs[1] = frame.getLocal(2);
         // **REMOVED Substitution** ref = this_ref;
        regs[0] = this_ref;
        frame.setProgramCounter(9);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("parseDescriptor(Ljava/io/InputStream;)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("parseDescriptor(Ljava/io/InputStream;)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[28] PUTFIELD(jnt.Bench.Bench,entries)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_entries = c_CBench.getField("entries",true);
         // *********[29] ALOAD(0)
         // *********[30] ACONST_NULL
         // *********[31] PUTFIELD(jnt.Bench.Bench,applet)
        c_applet = c_CBench.getField("applet",true);
         // *********[32] ALOAD(0)
         // *********[33] ICONST_1(Integer{1})
         // *********[34] PUTFIELD(jnt.Bench.Bench,ascending)
        c_ascending = c_CBench.getField("ascending",true);
         // *********[35] ALOAD(0)
         // *********[36] ICONST_M1(Integer{-1})
         // *********[37] PUTFIELD(jnt.Bench.Bench,specpos)
        c_specpos = c_CBench.getField("specpos",true);
         // *********[38] ALOAD(0)
         // *********[39] ICONST_0(Integer{0})
         // *********[40] PUTFIELD(jnt.Bench.Bench,timerAPIused)
        c_timerAPIused = c_CBench.getField("timerAPIused",true);
         // *********[41] ALOAD(0)
         // *********[42] ALOAD(1)
         // *********[43] PUTFIELD(jnt.Bench.Bench,applet)
         // *********[44] ALOAD(0)
         // *********[45] ALOAD(2)
         // *********[46] INVOKEVIRTUAL(jnt.Bench.Bench,parseDescriptor(Ljava/io/InputStream;)V)
        c_memman = process.getMemoryManager();
      }
}
