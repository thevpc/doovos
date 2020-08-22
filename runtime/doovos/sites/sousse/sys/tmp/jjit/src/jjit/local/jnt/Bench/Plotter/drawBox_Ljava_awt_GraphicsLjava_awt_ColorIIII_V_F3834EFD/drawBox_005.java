package jjit.local.jnt.Bench.Plotter.drawBox_Ljava_awt_GraphicsLjava_awt_ColorIIII_V_F3834EFD;
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
 * drawBox(Ljava/awt/Graphics;Ljava/awt/Color;IIII)V
 * [count=4] [9] ALOAD(1) [10] ALOAD(0) [11] GETFIELD(jnt.Bench.Plotter,fgColor,Ljava/awt/Color;) [12] INVOKEVIRTUAL(java.awt.Graphics,setColor(Ljava/awt/Color;)V)
 */
public final class drawBox_005 extends JJITAbstractInstruction implements Cloneable{
      private KField c_fgColor = null;
      private KClassRepository c_repo;
      private KClass c_CPlotter = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[9] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[10] ALOAD(0)
         // **REMOVED Substitution** s1 = frame.getLocal(0);
         // *********[11] GETFIELD(jnt.Bench.Plotter,fgColor,Ljava/awt/Color;)
         // **REMOVED Substitution** s1_ref = c_fgColor.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[12] INVOKEVIRTUAL(java.awt.Graphics,setColor(Ljava/awt/Color;)V)
        regs = new KRegister[2];
        regs[1] = c_fgColor.getInstanceRef(((KReference)frame.getLocal(0)));
        ref = ((KReference)frame.getLocal(1));
        regs[0] = ref;
        frame.setProgramCounter(5);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("setColor(Ljava/awt/Color;)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("setColor(Ljava/awt/Color;)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[9] ALOAD(1)
         // *********[10] ALOAD(0)
         // *********[11] GETFIELD(jnt.Bench.Plotter,fgColor,Ljava/awt/Color;)
        c_repo = process.getClassRepository();
        c_CPlotter = c_repo.getClassByName("jnt.Bench.Plotter");
        c_fgColor = c_CPlotter.getField("fgColor",true);
         // *********[12] INVOKEVIRTUAL(java.awt.Graphics,setColor(Ljava/awt/Color;)V)
        c_memman = process.getMemoryManager();
      }
}
