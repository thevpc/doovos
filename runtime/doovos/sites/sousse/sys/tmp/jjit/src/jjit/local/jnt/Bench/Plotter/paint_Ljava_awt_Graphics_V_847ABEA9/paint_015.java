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
 * [count=6] [38] ALOAD(6) [39] ALOAD(0) [40] GETFIELD(jnt.Bench.Plotter,labels,[Ljava/lang/String;) [41] ILOAD(13) [42] AALOAD [43] INVOKEVIRTUAL(java.awt.FontMetrics,stringWidth(Ljava/lang/String;)I)
 */
public final class paint_015 extends JJITAbstractInstruction implements Cloneable{
      private KField c_labels = null;
      private KClassRepository c_repo;
      private KClass c_CPlotter = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** int index = 0;
        KReference ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_6 6 ; r=1/w=0 : NotCached
         // local_13 13 ; r=1/w=0 : NotCached
         // *********[38] ALOAD(6)
         // **REMOVED Substitution** s0 = frame.getLocal(6);
         // *********[39] ALOAD(0)
         // **REMOVED Substitution** s1 = frame.getLocal(0);
         // *********[40] GETFIELD(jnt.Bench.Plotter,labels,[Ljava/lang/String;)
         // **REMOVED Substitution** s1_ref = c_labels.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[41] ILOAD(13)
         // **REMOVED Substitution** s2 = frame.getLocal(13);
         // *********[42] AALOAD
         // **REMOVED Substitution** index = frame.getLocal(13).intValue();
         // **REMOVED Substitution** ref = c_labels.getInstanceRef(((KReference)frame.getLocal(0)));
         // **REMOVED Substitution** s1_ref = c_memman.getReferenceArray(c_labels.getInstanceRef(((KReference)frame.getLocal(0))),frame.getLocal(13).intValue());
         // *********[43] INVOKEVIRTUAL(java.awt.FontMetrics,stringWidth(Ljava/lang/String;)I)
        regs = new KRegister[2];
        regs[1] = c_memman.getReferenceArray(c_labels.getInstanceRef(((KReference)frame.getLocal(0))),frame.getLocal(13).intValue());
        ref = ((KReference)frame.getLocal(6));
        regs[0] = ref;
        frame.setProgramCounter(15);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("stringWidth(Ljava/lang/String;)I"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("stringWidth(Ljava/lang/String;)I"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[38] ALOAD(6)
         // *********[39] ALOAD(0)
         // *********[40] GETFIELD(jnt.Bench.Plotter,labels,[Ljava/lang/String;)
        c_repo = process.getClassRepository();
        c_CPlotter = c_repo.getClassByName("jnt.Bench.Plotter");
        c_labels = c_CPlotter.getField("labels",true);
         // *********[41] ILOAD(13)
         // *********[42] AALOAD
        c_memman = process.getMemoryManager();
         // *********[43] INVOKEVIRTUAL(java.awt.FontMetrics,stringWidth(Ljava/lang/String;)I)
      }
}
