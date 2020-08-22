package jjit.local.jnt.Bench.Plotter.paint_Ljava_awt_Graphics_V_847ABEA9;
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
 * jnt.Bench.Plotter
 * paint(Ljava/awt/Graphics;)V
 * [count=12] [365] ALOAD(1) [366] ALOAD(0) [367] GETFIELD(jnt.Bench.Plotter,axisLabel,Ljava/lang/String;) [368] ILOAD(25) [369] ILOAD(24) [370] IADD [371] ICONST_2(Integer{2}) [372] IDIV [373] ALOAD(6) [374] ALOAD(0) [375] GETFIELD(jnt.Bench.Plotter,axisLabel,Ljava/lang/String;) [376] INVOKEVIRTUAL(java.awt.FontMetrics,stringWidth(Ljava/lang/String;)I)
 */
public final class paint_062 extends JJITAbstractInstruction implements Cloneable{
      private KField c_axisLabel = null;
      private KClassRepository c_repo;
      private KClass c_CPlotter = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // local_1 1 ; r=1/w=0 : NotCached
         // local_6 6 ; r=1/w=0 : NotCached
         // local_25 25 ; r=1/w=0 : NotCached
         // local_24 24 ; r=1/w=0 : NotCached
         // *********[365] ALOAD(1)
        frame.push(frame.getLocal(1));
         // *********[366] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[367] GETFIELD(jnt.Bench.Plotter,axisLabel,Ljava/lang/String;)
        frame.push(c_axisLabel.getInstanceRef(this_ref));
         // *********[368] ILOAD(25)
         // **REMOVED Substitution** s0 = frame.getLocal(25);
         // *********[369] ILOAD(24)
         // **REMOVED Substitution** s1 = frame.getLocal(24);
         // *********[370] IADD
         // **REMOVED Substitution** index = frame.getLocal(24).intValue();
         // **REMOVED Substitution** s0 = new KInteger((frame.getLocal(25).intValue() + frame.getLocal(24).intValue()));
         // *********[371] ICONST_2(Integer{2})
         // **REMOVED Substitution** s1 = ITWO;
         // *********[372] IDIV
         // **REMOVED Substitution** index = 2;
        frame.push(new KInteger(((frame.getLocal(25).intValue() + frame.getLocal(24).intValue()) / 2)));
         // *********[373] ALOAD(6)
         // **REMOVED Substitution** s0 = frame.getLocal(6);
         // *********[374] ALOAD(0)
         // **REMOVED Substitution** s1_ref = this_ref;
         // *********[375] GETFIELD(jnt.Bench.Plotter,axisLabel,Ljava/lang/String;)
         // **REMOVED Substitution** s1_ref = c_axisLabel.getInstanceRef(this_ref);
         // *********[376] INVOKEVIRTUAL(java.awt.FontMetrics,stringWidth(Ljava/lang/String;)I)
        regs = new KRegister[2];
        regs[1] = c_axisLabel.getInstanceRef(this_ref);
        ref = ((KReference)frame.getLocal(6));
        regs[0] = ref;
        frame.setProgramCounter(62);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("stringWidth(Ljava/lang/String;)I"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("stringWidth(Ljava/lang/String;)I"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[365] ALOAD(1)
         // *********[366] ALOAD(0)
         // *********[367] GETFIELD(jnt.Bench.Plotter,axisLabel,Ljava/lang/String;)
        c_repo = process.getClassRepository();
        c_CPlotter = c_repo.getClassByName("jnt.Bench.Plotter");
        c_axisLabel = c_CPlotter.getField("axisLabel",true);
         // *********[368] ILOAD(25)
         // *********[369] ILOAD(24)
         // *********[370] IADD
         // *********[371] ICONST_2(Integer{2})
         // *********[372] IDIV
         // *********[373] ALOAD(6)
         // *********[374] ALOAD(0)
         // *********[375] GETFIELD(jnt.Bench.Plotter,axisLabel,Ljava/lang/String;)
         // *********[376] INVOKEVIRTUAL(java.awt.FontMetrics,stringWidth(Ljava/lang/String;)I)
        c_memman = process.getMemoryManager();
      }
}
