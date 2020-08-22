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
 * [count=14] [233] ALOAD(1) [234] ALOAD(0) [235] GETFIELD(jnt.Bench.Plotter,labels,[Ljava/lang/String;) [236] ILOAD(31) [237] AALOAD [238] ILOAD(24) [239] ICONST_5(Integer{5}) [240] ISUB [241] ALOAD(6) [242] ALOAD(0) [243] GETFIELD(jnt.Bench.Plotter,labels,[Ljava/lang/String;) [244] ILOAD(31) [245] AALOAD [246] INVOKEVIRTUAL(java.awt.FontMetrics,stringWidth(Ljava/lang/String;)I)
 */
public final class paint_039 extends JJITAbstractInstruction implements Cloneable{
      private KField c_labels = null;
      private KClassRepository c_repo;
      private KClass c_CPlotter = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
        KReference ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // local_1 1 ; r=1/w=0 : NotCached
         // local_6 6 ; r=1/w=0 : NotCached
         // local_24 24 ; r=1/w=0 : NotCached
         // local_31 31 ; r=2/w=0 : Cached
        int local_31 = frame.getLocal(31).intValue();
         // *********[233] ALOAD(1)
        frame.push(frame.getLocal(1));
         // *********[234] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[235] GETFIELD(jnt.Bench.Plotter,labels,[Ljava/lang/String;)
         // **REMOVED Substitution** s0_ref = c_labels.getInstanceRef(this_ref);
         // *********[236] ILOAD(31)
         // **REMOVED Substitution** s1 = new KInteger(local_31);
         // *********[237] AALOAD
         // **REMOVED Substitution** index = local_31;
         // **REMOVED Substitution** ref = c_labels.getInstanceRef(this_ref);
        frame.push(c_memman.getReferenceArray(c_labels.getInstanceRef(this_ref),local_31));
         // *********[238] ILOAD(24)
         // **REMOVED Substitution** s0 = frame.getLocal(24);
         // *********[239] ICONST_5(Integer{5})
         // **REMOVED Substitution** s1 = IFIVE;
         // *********[240] ISUB
         // **REMOVED Substitution** index = 5;
        frame.push(new KInteger((frame.getLocal(24).intValue() - 5)));
         // *********[241] ALOAD(6)
         // **REMOVED Substitution** s0 = frame.getLocal(6);
         // *********[242] ALOAD(0)
         // **REMOVED Substitution** s1_ref = this_ref;
         // *********[243] GETFIELD(jnt.Bench.Plotter,labels,[Ljava/lang/String;)
         // **REMOVED Substitution** s1_ref = c_labels.getInstanceRef(this_ref);
         // *********[244] ILOAD(31)
         // **REMOVED Substitution** s2 = new KInteger(local_31);
         // *********[245] AALOAD
         // **REMOVED Substitution** index = local_31;
         // **REMOVED Substitution** ref = c_labels.getInstanceRef(this_ref);
         // **REMOVED Substitution** s1_ref = c_memman.getReferenceArray(c_labels.getInstanceRef(this_ref),local_31);
         // *********[246] INVOKEVIRTUAL(java.awt.FontMetrics,stringWidth(Ljava/lang/String;)I)
        regs = new KRegister[2];
        regs[1] = c_memman.getReferenceArray(c_labels.getInstanceRef(this_ref),local_31);
        ref = ((KReference)frame.getLocal(6));
        regs[0] = ref;
        frame.setProgramCounter(39);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("stringWidth(Ljava/lang/String;)I"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("stringWidth(Ljava/lang/String;)I"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[233] ALOAD(1)
         // *********[234] ALOAD(0)
         // *********[235] GETFIELD(jnt.Bench.Plotter,labels,[Ljava/lang/String;)
        c_repo = process.getClassRepository();
        c_CPlotter = c_repo.getClassByName("jnt.Bench.Plotter");
        c_labels = c_CPlotter.getField("labels",true);
         // *********[236] ILOAD(31)
         // *********[237] AALOAD
        c_memman = process.getMemoryManager();
         // *********[238] ILOAD(24)
         // *********[239] ICONST_5(Integer{5})
         // *********[240] ISUB
         // *********[241] ALOAD(6)
         // *********[242] ALOAD(0)
         // *********[243] GETFIELD(jnt.Bench.Plotter,labels,[Ljava/lang/String;)
         // *********[244] ILOAD(31)
         // *********[245] AALOAD
         // *********[246] INVOKEVIRTUAL(java.awt.FontMetrics,stringWidth(Ljava/lang/String;)I)
      }
}
