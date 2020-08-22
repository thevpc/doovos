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
 * [count=2] [161] GETSTATIC(java.awt.Color,white,Ljava/awt/Color;) [162] INVOKEVIRTUAL(jnt.Bench.Applet,getColor(Ljava/lang/String;Ljava/awt/Color;)Ljava/awt/Color;)
 */
public final class init_063 extends JJITAbstractInstruction implements Cloneable{
      private KField c_white = null;
      private KClassRepository c_repo;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // *********[161] GETSTATIC(java.awt.Color,white,Ljava/awt/Color;)
        if(c_white == null){
          c_white = c_repo.getClassByName("java.awt.Color").getField("white",true);
        }
         // **REMOVED Substitution** s0 = c_white.getStaticValue();
         // *********[162] INVOKEVIRTUAL(jnt.Bench.Applet,getColor(Ljava/lang/String;Ljava/awt/Color;)Ljava/awt/Color;)
        regs = new KRegister[3];
        regs[2] = c_white.getStaticValue();
        regs[1] = frame.pop();
        ref = frame.popRef();
        regs[0] = ref;
        frame.setProgramCounter(63);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getColor(Ljava/lang/String;Ljava/awt/Color;)Ljava/awt/Color;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getColor(Ljava/lang/String;Ljava/awt/Color;)Ljava/awt/Color;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[161] GETSTATIC(java.awt.Color,white,Ljava/awt/Color;)
        c_repo = process.getClassRepository();
         // *********[162] INVOKEVIRTUAL(jnt.Bench.Applet,getColor(Ljava/lang/String;Ljava/awt/Color;)Ljava/awt/Color;)
        c_memman = process.getMemoryManager();
      }
}
