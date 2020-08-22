package jjit.local.jnt.Bench.Plotter.paint_Ljava_awt_Graphics_V_847ABEA9;
import java.lang.Math;
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
 * [count=67] [141] GETFIELD(java.awt.Dimension,width,I) [142] ISTORE(21) [143] ALOAD(20) [144] GETFIELD(java.awt.Dimension,height,I) [145] ISTORE(22) [146] ICONST_0(Integer{0}) [147] ISTORE(23) [148] ILOAD(8) [149] ILOAD(21) [150] ICONST_2(Integer{2}) [151] IDIV [152] INVOKE_HOST(java.lang.Math.min(II)I) [153] BIPUSH(10) [154] IADD [155] ISTORE(24) [156] ILOAD(21) [157] ICONST_2(Integer{2}) [158] ISUB [159] ISTORE(25) [160] ILOAD(22) [161] ICONST_2(Integer{2}) [162] ILOAD(7) [163] IMUL [164] ISUB [165] ICONST_3(Integer{3}) [166] ISUB [167] ISTORE(26) [168] ILOAD(26) [169] ILOAD(23) [170] ISUB [171] ILOAD(3) [172] IDIV [173] ISTORE(27) [174] ICONST_4(Integer{4}) [175] ILOAD(27) [176] ICONST_4(Integer{4}) [177] ISUB [178] INVOKE_HOST(java.lang.Math.max(II)I) [179] ISTORE(28) [180] ILOAD(25) [181] ILOAD(24) [182] ISUB [183] ICONST_5(Integer{5}) [184] ISUB [185] I2D [186] DLOAD(11) [187] DLOAD(9) [188] DSUB [189] DDIV [190] DSTORE(29) [191] ALOAD(0) [192] ALOAD(1) [193] ALOAD(0) [194] GETFIELD(jnt.Bench.Plotter,bgColor,Ljava/awt/Color;) [195] ILOAD(24) [196] ILOAD(23) [197] ILOAD(25) [198] ILOAD(24) [199] ISUB [200] ICONST_1(Integer{1}) [201] ISUB [202] ILOAD(26) [203] ILOAD(23) [204] ISUB [205] ICONST_1(Integer{1}) [206] ISUB [207] INVOKEVIRTUAL(jnt.Bench.Plotter,drawBox(Ljava/awt/Graphics;Ljava/awt/Color;IIII)V)
 */
public final class paint_033 extends JJITAbstractInstruction implements Cloneable{
      private KField c_width = null;
      private KClassRepository c_repo;
      private KField c_height = null;
      private KField c_bgColor = null;
      private KClass c_CPlotter = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s7;
         // **REMOVED Unused Var** KRegister s6;
         // **REMOVED Unused Var** KRegister s5;
         // **REMOVED Unused Var** KRegister s4;
         // **REMOVED Unused Var** KReference s2_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
        KRegister[] regs = null;
         // **REMOVED Unused Var** int m_v;
         // **REMOVED Unused Var** int m_v2;
         // **REMOVED Unused Var** int m_v3;
         // **REMOVED Unused Var** int m_v4;
         // **REMOVED Unused Var** double m_d4;
         // **REMOVED Unused Var** double m_d5;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // local_1 1 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=0 : NotCached
         // local_7 7 ; r=1/w=0 : NotCached
         // local_8 8 ; r=1/w=0 : NotCached
         // local_9 9 ; r=1/w=0 : NotCached
         // local_11 11 ; r=1/w=0 : NotCached
         // local_21 21 ; r=2/w=1 : Cached
        int local_21;
         // local_20 20 ; r=1/w=0 : NotCached
         // local_23 23 ; r=3/w=1 : Cached
         // **REMOVED Unused Var** int local_23;
         // local_22 22 ; r=1/w=1 : Cached
        int local_22;
         // local_25 25 ; r=2/w=1 : Cached
         // **REMOVED Unused Var** int local_25;
         // local_24 24 ; r=3/w=1 : Cached
        int local_24;
         // local_27 27 ; r=1/w=1 : Cached
        int local_27;
         // local_26 26 ; r=2/w=1 : Cached
        int local_26;
         // local_29 29 ; r=0/w=1 : NotCached
         // local_28 28 ; r=0/w=1 : NotCached
         // *********[141] GETFIELD(java.awt.Dimension,width,I)
        if(c_width == null){
          c_width = c_repo.getClassByName("java.awt.Dimension").getField("width",true);
        }
         // **REMOVED Substitution** s0 = c_width.getInstanceValue(frame.popRef());
         // *********[142] ISTORE(21)
        local_21 = c_width.getInstanceValue(frame.popRef()).intValue();
         // *********[143] ALOAD(20)
         // **REMOVED Substitution** s0 = frame.getLocal(20);
         // *********[144] GETFIELD(java.awt.Dimension,height,I)
        if(c_height == null){
          c_height = c_repo.getClassByName("java.awt.Dimension").getField("height",true);
        }
         // **REMOVED Substitution** s0 = c_height.getInstanceValue(((KReference)frame.getLocal(20)));
         // *********[145] ISTORE(22)
        local_22 = c_height.getInstanceValue(((KReference)frame.getLocal(20))).intValue();
         // *********[146] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[147] ISTORE(23)
         // **REMOVED Substitution** local_23 = 0;
         // *********[148] ILOAD(8)
         // **REMOVED Substitution** s0 = frame.getLocal(8);
         // *********[149] ILOAD(21)
         // **REMOVED Substitution** s1 = new KInteger(local_21);
         // *********[150] ICONST_2(Integer{2})
         // **REMOVED Substitution** s2 = ITWO;
         // *********[151] IDIV
         // **REMOVED Substitution** index = 2;
         // **REMOVED Substitution** s1 = new KInteger((local_21 / 2));
         // *********[152] INVOKE_HOST(java.lang.Math.min(II)I)
         // **REMOVED Substitution** m_v2 = (local_21 / 2);
         // **REMOVED Substitution** m_v = frame.getLocal(8).intValue();
         // **REMOVED Substitution** s0 = new KInteger(Math.min(frame.getLocal(8).intValue(),(local_21 / 2)));
         // *********[153] BIPUSH(10)
         // **REMOVED Substitution** s1 = I10;
         // *********[154] IADD
         // **REMOVED Substitution** index = 10;
         // **REMOVED Substitution** s0 = new KInteger((Math.min(frame.getLocal(8).intValue(),(local_21 / 2)) + 10));
         // *********[155] ISTORE(24)
        local_24 = (Math.min(frame.getLocal(8).intValue(),(local_21 / 2)) + 10);
         // *********[156] ILOAD(21)
         // **REMOVED Substitution** s0 = new KInteger(local_21);
         // *********[157] ICONST_2(Integer{2})
         // **REMOVED Substitution** s1 = ITWO;
         // *********[158] ISUB
         // **REMOVED Substitution** index = 2;
         // **REMOVED Substitution** s0 = new KInteger((local_21 - 2));
         // *********[159] ISTORE(25)
         // **REMOVED Substitution** local_25 = (local_21 - 2);
         // *********[160] ILOAD(22)
         // **REMOVED Substitution** s0 = new KInteger(local_22);
         // *********[161] ICONST_2(Integer{2})
         // **REMOVED Substitution** s1 = ITWO;
         // *********[162] ILOAD(7)
         // **REMOVED Substitution** s2 = frame.getLocal(7);
         // *********[163] IMUL
         // **REMOVED Substitution** index = frame.getLocal(7).intValue();
         // **REMOVED Substitution** s1 = new KInteger((2 * frame.getLocal(7).intValue()));
         // *********[164] ISUB
         // **REMOVED Substitution** index = (2 * frame.getLocal(7).intValue());
         // **REMOVED Substitution** s0 = new KInteger((local_22 - (2 * frame.getLocal(7).intValue())));
         // *********[165] ICONST_3(Integer{3})
         // **REMOVED Substitution** s1 = ITHREE;
         // *********[166] ISUB
         // **REMOVED Substitution** index = 3;
         // **REMOVED Substitution** s0 = new KInteger(((local_22 - (2 * frame.getLocal(7).intValue())) - 3));
         // *********[167] ISTORE(26)
        local_26 = ((local_22 - (2 * frame.getLocal(7).intValue())) - 3);
         // *********[168] ILOAD(26)
         // **REMOVED Substitution** s0 = new KInteger(local_26);
         // *********[169] ILOAD(23)
         // **REMOVED Substitution** s1 = KInteger.ZERO;
         // *********[170] ISUB
         // **REMOVED Substitution** index = 0;
         // **REMOVED Substitution** s0 = new KInteger((local_26 - 0));
         // *********[171] ILOAD(3)
         // **REMOVED Substitution** s1 = frame.getLocal(3);
         // *********[172] IDIV
         // **REMOVED Substitution** index = frame.getLocal(3).intValue();
         // **REMOVED Substitution** s0 = new KInteger(((local_26 - 0) / frame.getLocal(3).intValue()));
         // *********[173] ISTORE(27)
        local_27 = ((local_26 - 0) / frame.getLocal(3).intValue());
         // *********[174] ICONST_4(Integer{4})
         // **REMOVED Substitution** s0 = IFOUR;
         // *********[175] ILOAD(27)
         // **REMOVED Substitution** s1 = new KInteger(local_27);
         // *********[176] ICONST_4(Integer{4})
         // **REMOVED Substitution** s2 = IFOUR;
         // *********[177] ISUB
         // **REMOVED Substitution** index = 4;
         // **REMOVED Substitution** s1 = new KInteger((local_27 - 4));
         // *********[178] INVOKE_HOST(java.lang.Math.max(II)I)
         // **REMOVED Substitution** m_v4 = (local_27 - 4);
         // **REMOVED Substitution** m_v3 = 4;
         // **REMOVED Substitution** s0 = new KInteger(Math.max(4,(local_27 - 4)));
         // *********[179] ISTORE(28)
        frame.setLocal(28,new KInteger(Math.max(4,(local_27 - 4))));
         // *********[180] ILOAD(25)
         // **REMOVED Substitution** s0 = new KInteger((local_21 - 2));
         // *********[181] ILOAD(24)
         // **REMOVED Substitution** s1 = new KInteger(local_24);
         // *********[182] ISUB
         // **REMOVED Substitution** index = local_24;
         // **REMOVED Substitution** s0 = new KInteger(((local_21 - 2) - local_24));
         // *********[183] ICONST_5(Integer{5})
         // **REMOVED Substitution** s1 = IFIVE;
         // *********[184] ISUB
         // **REMOVED Substitution** index = 5;
         // **REMOVED Substitution** s0 = new KInteger((((local_21 - 2) - local_24) - 5));
         // *********[185] I2D
         // **REMOVED Substitution** s0 = new KDouble((((local_21 - 2) - local_24) - 5));
         // *********[186] DLOAD(11)
         // **REMOVED Substitution** s1 = frame.getLocal(11);
         // *********[187] DLOAD(9)
         // **REMOVED Substitution** s2 = frame.getLocal(9);
         // *********[188] DSUB
         // **REMOVED Substitution** m_d4 = frame.getLocal(9).doubleValue();
         // **REMOVED Substitution** s1 = new KDouble((frame.getLocal(11).doubleValue() - frame.getLocal(9).doubleValue()));
         // *********[189] DDIV
         // **REMOVED Substitution** m_d5 = (frame.getLocal(11).doubleValue() - frame.getLocal(9).doubleValue());
         // **REMOVED Substitution** s0 = new KDouble((((double)(((local_21 - 2) - local_24) - 5)) / (frame.getLocal(11).doubleValue() - frame.getLocal(9).doubleValue())));
         // *********[190] DSTORE(29)
        frame.setLocal(29,new KDouble((((double)(((local_21 - 2) - local_24) - 5)) / (frame.getLocal(11).doubleValue() - frame.getLocal(9).doubleValue()))));
         // *********[191] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[192] ALOAD(1)
         // **REMOVED Substitution** s1 = frame.getLocal(1);
         // *********[193] ALOAD(0)
         // **REMOVED Substitution** s2_ref = this_ref;
         // *********[194] GETFIELD(jnt.Bench.Plotter,bgColor,Ljava/awt/Color;)
         // **REMOVED Substitution** s2_ref = c_bgColor.getInstanceRef(this_ref);
         // *********[195] ILOAD(24)
         // **REMOVED Substitution** s3 = new KInteger(local_24);
         // *********[196] ILOAD(23)
         // **REMOVED Substitution** s4 = KInteger.ZERO;
         // *********[197] ILOAD(25)
         // **REMOVED Substitution** s5 = new KInteger((local_21 - 2));
         // *********[198] ILOAD(24)
         // **REMOVED Substitution** s6 = new KInteger(local_24);
         // *********[199] ISUB
         // **REMOVED Substitution** index = local_24;
         // **REMOVED Substitution** s5 = new KInteger(((local_21 - 2) - local_24));
         // *********[200] ICONST_1(Integer{1})
         // **REMOVED Substitution** s6 = IONE;
         // *********[201] ISUB
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s5 = new KInteger((((local_21 - 2) - local_24) - 1));
         // *********[202] ILOAD(26)
         // **REMOVED Substitution** s6 = new KInteger(local_26);
         // *********[203] ILOAD(23)
         // **REMOVED Substitution** s7 = KInteger.ZERO;
         // *********[204] ISUB
         // **REMOVED Substitution** index = 0;
         // **REMOVED Substitution** s6 = new KInteger((local_26 - 0));
         // *********[205] ICONST_1(Integer{1})
         // **REMOVED Substitution** s7 = IONE;
         // *********[206] ISUB
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s6 = new KInteger(((local_26 - 0) - 1));
         // *********[207] INVOKEVIRTUAL(jnt.Bench.Plotter,drawBox(Ljava/awt/Graphics;Ljava/awt/Color;IIII)V)
        regs = new KRegister[7];
        regs[6] = new KInteger(((local_26 - 0) - 1));
        regs[5] = new KInteger((((local_21 - 2) - local_24) - 1));
        regs[4] = KInteger.ZERO;
        regs[3] = new KInteger(local_24);
        regs[2] = c_bgColor.getInstanceRef(this_ref);
        regs[1] = frame.getLocal(1);
         // **REMOVED Substitution** ref = this_ref;
        regs[0] = this_ref;
        frame.setProgramCounter(33);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("drawBox(Ljava/awt/Graphics;Ljava/awt/Color;IIII)V"),regs);
        frame.setLocal(21,new KInteger(local_21));
        frame.setLocal(23,KInteger.ZERO);
        frame.setLocal(22,new KInteger(local_22));
        frame.setLocal(25,new KInteger((local_21 - 2)));
        frame.setLocal(24,new KInteger(local_24));
        frame.setLocal(27,new KInteger(local_27));
        frame.setLocal(26,new KInteger(local_26));
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("drawBox(Ljava/awt/Graphics;Ljava/awt/Color;IIII)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[141] GETFIELD(java.awt.Dimension,width,I)
        c_repo = process.getClassRepository();
         // *********[142] ISTORE(21)
         // *********[143] ALOAD(20)
         // *********[144] GETFIELD(java.awt.Dimension,height,I)
        c_repo = process.getClassRepository();
         // *********[145] ISTORE(22)
         // *********[146] ICONST_0(Integer{0})
         // *********[147] ISTORE(23)
         // *********[148] ILOAD(8)
         // *********[149] ILOAD(21)
         // *********[150] ICONST_2(Integer{2})
         // *********[151] IDIV
         // *********[152] INVOKE_HOST(java.lang.Math.min(II)I)
         // *********[153] BIPUSH(10)
         // *********[154] IADD
         // *********[155] ISTORE(24)
         // *********[156] ILOAD(21)
         // *********[157] ICONST_2(Integer{2})
         // *********[158] ISUB
         // *********[159] ISTORE(25)
         // *********[160] ILOAD(22)
         // *********[161] ICONST_2(Integer{2})
         // *********[162] ILOAD(7)
         // *********[163] IMUL
         // *********[164] ISUB
         // *********[165] ICONST_3(Integer{3})
         // *********[166] ISUB
         // *********[167] ISTORE(26)
         // *********[168] ILOAD(26)
         // *********[169] ILOAD(23)
         // *********[170] ISUB
         // *********[171] ILOAD(3)
         // *********[172] IDIV
         // *********[173] ISTORE(27)
         // *********[174] ICONST_4(Integer{4})
         // *********[175] ILOAD(27)
         // *********[176] ICONST_4(Integer{4})
         // *********[177] ISUB
         // *********[178] INVOKE_HOST(java.lang.Math.max(II)I)
         // *********[179] ISTORE(28)
         // *********[180] ILOAD(25)
         // *********[181] ILOAD(24)
         // *********[182] ISUB
         // *********[183] ICONST_5(Integer{5})
         // *********[184] ISUB
         // *********[185] I2D
         // *********[186] DLOAD(11)
         // *********[187] DLOAD(9)
         // *********[188] DSUB
         // *********[189] DDIV
         // *********[190] DSTORE(29)
         // *********[191] ALOAD(0)
         // *********[192] ALOAD(1)
         // *********[193] ALOAD(0)
         // *********[194] GETFIELD(jnt.Bench.Plotter,bgColor,Ljava/awt/Color;)
        c_repo = process.getClassRepository();
        c_CPlotter = c_repo.getClassByName("jnt.Bench.Plotter");
        c_bgColor = c_CPlotter.getField("bgColor",true);
         // *********[195] ILOAD(24)
         // *********[196] ILOAD(23)
         // *********[197] ILOAD(25)
         // *********[198] ILOAD(24)
         // *********[199] ISUB
         // *********[200] ICONST_1(Integer{1})
         // *********[201] ISUB
         // *********[202] ILOAD(26)
         // *********[203] ILOAD(23)
         // *********[204] ISUB
         // *********[205] ICONST_1(Integer{1})
         // *********[206] ISUB
         // *********[207] INVOKEVIRTUAL(jnt.Bench.Plotter,drawBox(Ljava/awt/Graphics;Ljava/awt/Color;IIII)V)
        c_memman = process.getMemoryManager();
      }
}
