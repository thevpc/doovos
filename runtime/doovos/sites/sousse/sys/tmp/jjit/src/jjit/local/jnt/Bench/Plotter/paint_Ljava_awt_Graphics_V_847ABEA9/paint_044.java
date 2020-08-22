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
 * [count=13] [261] ILOAD(24) [262] ILOAD(32) [263] ALOAD(0) [264] GETFIELD(jnt.Bench.Plotter,values,[D) [265] ILOAD(31) [266] DALOAD [267] DLOAD(9) [268] DSUB [269] DLOAD(29) [270] DMUL [271] D2I [272] ILOAD(28) [273] INVOKEVIRTUAL(jnt.Bench.Plotter,drawBox(Ljava/awt/Graphics;Ljava/awt/Color;IIII)V)
 */
public final class paint_044 extends JJITAbstractInstruction implements Cloneable{
      private KField c_values = null;
      private KClassRepository c_repo;
      private KClass c_CPlotter = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s2_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** double m_d;
         // **REMOVED Unused Var** double m_d2;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_32 32 ; r=1/w=0 : NotCached
         // local_9 9 ; r=1/w=0 : NotCached
         // local_24 24 ; r=1/w=0 : NotCached
         // local_29 29 ; r=1/w=0 : NotCached
         // local_28 28 ; r=1/w=0 : NotCached
         // local_31 31 ; r=1/w=0 : NotCached
         // *********[261] ILOAD(24)
         // **REMOVED Substitution** s0 = frame.getLocal(24);
         // *********[262] ILOAD(32)
         // **REMOVED Substitution** s1 = frame.getLocal(32);
         // *********[263] ALOAD(0)
         // **REMOVED Substitution** s2 = frame.getLocal(0);
         // *********[264] GETFIELD(jnt.Bench.Plotter,values,[D)
         // **REMOVED Substitution** s2_ref = c_values.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[265] ILOAD(31)
         // **REMOVED Substitution** s3 = frame.getLocal(31);
         // *********[266] DALOAD
         // **REMOVED Substitution** index = frame.getLocal(31).intValue();
         // **REMOVED Substitution** s2 = new KDouble(c_memman.getDoubleArray(c_values.getInstanceRef(((KReference)frame.getLocal(0))),frame.getLocal(31).intValue()));
         // *********[267] DLOAD(9)
         // **REMOVED Substitution** s3 = frame.getLocal(9);
         // *********[268] DSUB
         // **REMOVED Substitution** m_d = frame.getLocal(9).doubleValue();
         // **REMOVED Substitution** s2 = new KDouble((c_memman.getDoubleArray(c_values.getInstanceRef(((KReference)frame.getLocal(0))),frame.getLocal(31).intValue()) - frame.getLocal(9).doubleValue()));
         // *********[269] DLOAD(29)
         // **REMOVED Substitution** s3 = frame.getLocal(29);
         // *********[270] DMUL
         // **REMOVED Substitution** m_d2 = frame.getLocal(29).doubleValue();
         // **REMOVED Substitution** s2 = new KDouble(((c_memman.getDoubleArray(c_values.getInstanceRef(((KReference)frame.getLocal(0))),frame.getLocal(31).intValue()) - frame.getLocal(9).doubleValue()) * frame.getLocal(29).doubleValue()));
         // *********[271] D2I
         // **REMOVED Substitution** s2 = new KInteger(((int)((c_memman.getDoubleArray(c_values.getInstanceRef(((KReference)frame.getLocal(0))),frame.getLocal(31).intValue()) - frame.getLocal(9).doubleValue()) * frame.getLocal(29).doubleValue())));
         // *********[272] ILOAD(28)
         // **REMOVED Substitution** s3 = frame.getLocal(28);
         // *********[273] INVOKEVIRTUAL(jnt.Bench.Plotter,drawBox(Ljava/awt/Graphics;Ljava/awt/Color;IIII)V)
        regs = new KRegister[7];
        regs[6] = frame.getLocal(28);
        regs[5] = new KInteger(((int)((c_memman.getDoubleArray(c_values.getInstanceRef(((KReference)frame.getLocal(0))),frame.getLocal(31).intValue()) - frame.getLocal(9).doubleValue()) * frame.getLocal(29).doubleValue())));
        regs[4] = frame.getLocal(32);
        regs[3] = frame.getLocal(24);
        regs[2] = frame.pop();
        regs[1] = frame.pop();
        ref = frame.popRef();
        regs[0] = ref;
        frame.setProgramCounter(44);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("drawBox(Ljava/awt/Graphics;Ljava/awt/Color;IIII)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("drawBox(Ljava/awt/Graphics;Ljava/awt/Color;IIII)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[261] ILOAD(24)
         // *********[262] ILOAD(32)
         // *********[263] ALOAD(0)
         // *********[264] GETFIELD(jnt.Bench.Plotter,values,[D)
        c_repo = process.getClassRepository();
        c_CPlotter = c_repo.getClassByName("jnt.Bench.Plotter");
        c_values = c_CPlotter.getField("values",true);
         // *********[265] ILOAD(31)
         // *********[266] DALOAD
        c_memman = process.getMemoryManager();
         // *********[267] DLOAD(9)
         // *********[268] DSUB
         // *********[269] DLOAD(29)
         // *********[270] DMUL
         // *********[271] D2I
         // *********[272] ILOAD(28)
         // *********[273] INVOKEVIRTUAL(jnt.Bench.Plotter,drawBox(Ljava/awt/Graphics;Ljava/awt/Color;IIII)V)
      }
}
