package jjit.local.jnt.Bench.Applet.init__V_44AFC1AA;
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
 * jnt.Bench.Applet
 * init()V
 * [count=8] [199] ALOAD(0) [200] GETFIELD(jnt.Bench.Applet,table,Ljava/awt/List;) [201] NEW(java.awt.Font) [202] DUP [203] LDC(76->"Courier") [204] ICONST_0(Integer{0}) [205] ALOAD(3) [206] INVOKEVIRTUAL(java.awt.Font,getSize()I)
 */
public final class init_073 extends JJITAbstractInstruction implements Cloneable{
      private KField c_table = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private KClass c_CFont = null;
      private static KReference R76 = null;
      private static final KInteger IZERO = KInteger.ZERO;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=0 : NotCached
         // *********[199] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[200] GETFIELD(jnt.Bench.Applet,table,Ljava/awt/List;)
        frame.push(c_table.getInstanceRef(((KReference)frame.getLocal(0))));
         // *********[201] NEW(java.awt.Font)
        if(c_CFont == null){
          c_CFont = c_repo.getClassByName("java.awt.Font");
        }
        s0_ref = memseg.allocObject(c_CFont);
         // *********[202] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[203] LDC(76->"Courier")
        frame.push(R76);
         // *********[204] ICONST_0(Integer{0})
        frame.push(IZERO);
         // *********[205] ALOAD(3)
         // **REMOVED Substitution** s1 = frame.getLocal(3);
         // *********[206] INVOKEVIRTUAL(java.awt.Font,getSize()I)
        regs = new KRegister[1];
        ref = ((KReference)frame.getLocal(3));
        regs[0] = ref;
        frame.setProgramCounter(73);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getSize()I"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getSize()I"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[199] ALOAD(0)
         // *********[200] GETFIELD(jnt.Bench.Applet,table,Ljava/awt/List;)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_table = c_CApplet.getField("table",true);
         // *********[201] NEW(java.awt.Font)
        c_repo = process.getClassRepository();
         // *********[202] DUP
         // *********[203] LDC(76->"Courier")
        R76 = ((KReference)constants[76]);
         // *********[204] ICONST_0(Integer{0})
         // *********[205] ALOAD(3)
         // *********[206] INVOKEVIRTUAL(java.awt.Font,getSize()I)
        c_memman = process.getMemoryManager();
      }
}
