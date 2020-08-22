package jjit.local.jnt.Bench.Plotter.paint_Ljava_awt_Graphics_V_847ABEA9;
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
 * jnt.Bench.Plotter
 * paint(Ljava/awt/Graphics;)V
 * [count=10] [10] ASTORE(2) [11] ALOAD(0) [12] GETFIELD(jnt.Bench.Plotter,labels,[Ljava/lang/String;) [13] ARRAYLENGTH [14] ISTORE(3) [15] NEW(java.awt.Font) [16] DUP [17] LDC(35->"Helvetica") [18] ICONST_0(Integer{0}) [19] BIPUSH(10)
 */
public final class paint_007 extends JJITAbstractInstruction implements Cloneable{
      private KField c_labels = null;
      private KClassRepository c_repo;
      private KClass c_CPlotter = null;
      private KMemoryManager c_memman;
      private KClass c_CFont = null;
      private static KReference R35 = null;
      private static final KInteger IZERO = KInteger.ZERO;
      private static final KInteger I10 = new KInteger(10);
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_2 2 ; r=0/w=1 : NotCached
         // local_3 3 ; r=0/w=1 : NotCached
         // *********[10] ASTORE(2)
        frame.setLocal(2,frame.pop());
         // *********[11] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[12] GETFIELD(jnt.Bench.Plotter,labels,[Ljava/lang/String;)
         // **REMOVED Substitution** s0_ref = c_labels.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[13] ARRAYLENGTH
         // **REMOVED Substitution** s0 = new KInteger(c_memman.getArraySize(c_labels.getInstanceRef(((KReference)frame.getLocal(0)))));
         // *********[14] ISTORE(3)
        frame.setLocal(3,new KInteger(c_memman.getArraySize(c_labels.getInstanceRef(((KReference)frame.getLocal(0))))));
         // *********[15] NEW(java.awt.Font)
        if(c_CFont == null){
          c_CFont = c_repo.getClassByName("java.awt.Font");
        }
        s0_ref = memseg.allocObject(c_CFont);
         // *********[16] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[17] LDC(35->"Helvetica")
        frame.push(R35);
         // *********[18] ICONST_0(Integer{0})
        frame.push(IZERO);
         // *********[19] BIPUSH(10)
        frame.push(I10);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[10] ASTORE(2)
         // *********[11] ALOAD(0)
         // *********[12] GETFIELD(jnt.Bench.Plotter,labels,[Ljava/lang/String;)
        c_repo = process.getClassRepository();
        c_CPlotter = c_repo.getClassByName("jnt.Bench.Plotter");
        c_labels = c_CPlotter.getField("labels",true);
         // *********[13] ARRAYLENGTH
        c_memman = process.getMemoryManager();
         // *********[14] ISTORE(3)
         // *********[15] NEW(java.awt.Font)
        c_repo = process.getClassRepository();
         // *********[16] DUP
         // *********[17] LDC(35->"Helvetica")
        R35 = ((KReference)constants[35]);
         // *********[18] ICONST_0(Integer{0})
         // *********[19] BIPUSH(10)
        c_next = instructions[(index + 1)];
      }
}
