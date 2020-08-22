package jjit.local.jnt.Bench.Applet.init__V_44AFC1AA;
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
 * init()V
 * [count=5] [163] ASTORE(7) [164] ALOAD(0) [165] LDC(66->"PLOTTER_TEXT") [166] GETSTATIC(java.awt.Color,black,Ljava/awt/Color;) [167] INVOKEVIRTUAL(jnt.Bench.Applet,getColor(Ljava/lang/String;Ljava/awt/Color;)Ljava/awt/Color;)
 */
public final class init_064 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R66 = null;
      private KField c_black = null;
      private KClassRepository c_repo;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s2;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_7 7 ; r=0/w=1 : NotCached
         // *********[163] ASTORE(7)
        frame.setLocal(7,frame.pop());
         // *********[164] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[165] LDC(66->"PLOTTER_TEXT")
         // **REMOVED Substitution** s1_ref = R66;
         // *********[166] GETSTATIC(java.awt.Color,black,Ljava/awt/Color;)
        if(c_black == null){
          c_black = c_repo.getClassByName("java.awt.Color").getField("black",true);
        }
         // **REMOVED Substitution** s2 = c_black.getStaticValue();
         // *********[167] INVOKEVIRTUAL(jnt.Bench.Applet,getColor(Ljava/lang/String;Ljava/awt/Color;)Ljava/awt/Color;)
        regs = new KRegister[3];
        regs[2] = c_black.getStaticValue();
        regs[1] = R66;
        ref = ((KReference)frame.getLocal(0));
        regs[0] = ref;
        frame.setProgramCounter(64);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getColor(Ljava/lang/String;Ljava/awt/Color;)Ljava/awt/Color;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getColor(Ljava/lang/String;Ljava/awt/Color;)Ljava/awt/Color;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[163] ASTORE(7)
         // *********[164] ALOAD(0)
         // *********[165] LDC(66->"PLOTTER_TEXT")
        R66 = ((KReference)constants[66]);
         // *********[166] GETSTATIC(java.awt.Color,black,Ljava/awt/Color;)
        c_repo = process.getClassRepository();
         // *********[167] INVOKEVIRTUAL(jnt.Bench.Applet,getColor(Ljava/lang/String;Ljava/awt/Color;)Ljava/awt/Color;)
        c_memman = process.getMemoryManager();
      }
}
