package jjit.local.jnt.Bench.Applet.doDisplay__V_3302CC33;
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
 * jnt.Bench.Applet
 * doDisplay()V
 * [count=5] [57] ALOAD(0) [58] GETFIELD(jnt.Bench.Applet,bench,Ljnt/Bench/Bench;) [59] ALOAD(0) [60] GETFIELD(jnt.Bench.Applet,segment,I) [61] INVOKEVIRTUAL(jnt.Bench.Bench,getSegmentValues(I)[D)
 */
public final class doDisplay_027 extends JJITAbstractInstruction implements Cloneable{
      private KField c_bench = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private KField c_segment = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[57] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[58] GETFIELD(jnt.Bench.Applet,bench,Ljnt/Bench/Bench;)
         // **REMOVED Substitution** s0_ref = c_bench.getInstanceRef(this_ref);
         // *********[59] ALOAD(0)
         // **REMOVED Substitution** s1_ref = this_ref;
         // *********[60] GETFIELD(jnt.Bench.Applet,segment,I)
         // **REMOVED Substitution** s1 = new KInteger(c_segment.getInstanceInt(this_ref));
         // *********[61] INVOKEVIRTUAL(jnt.Bench.Bench,getSegmentValues(I)[D)
        regs = new KRegister[2];
        regs[1] = new KInteger(c_segment.getInstanceInt(this_ref));
        ref = c_bench.getInstanceRef(this_ref);
        regs[0] = ref;
        frame.setProgramCounter(27);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getSegmentValues(I)[D"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getSegmentValues(I)[D"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[57] ALOAD(0)
         // *********[58] GETFIELD(jnt.Bench.Applet,bench,Ljnt/Bench/Bench;)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_bench = c_CApplet.getField("bench",true);
         // *********[59] ALOAD(0)
         // *********[60] GETFIELD(jnt.Bench.Applet,segment,I)
        c_segment = c_CApplet.getField("segment",true);
         // *********[61] INVOKEVIRTUAL(jnt.Bench.Bench,getSegmentValues(I)[D)
        c_memman = process.getMemoryManager();
      }
}
