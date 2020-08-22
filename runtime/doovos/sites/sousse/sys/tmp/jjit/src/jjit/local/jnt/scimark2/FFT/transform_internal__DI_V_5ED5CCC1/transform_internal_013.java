package jjit.local.jnt.scimark2.FFT.transform_internal__DI_V_5ED5CCC1;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.FFT
 * transform_internal([DI)V
 * [count=82] [151] ICONST_2(Integer{2}) [152] ILOAD(20) [153] ILOAD(19) [154] IADD [155] IMUL [156] ISTORE(21) [157] ICONST_2(Integer{2}) [158] ILOAD(20) [159] ILOAD(19) [160] IADD [161] ILOAD(5) [162] IADD [163] IMUL [164] ISTORE(22) [165] ALOAD(0) [166] ILOAD(22) [167] DALOAD [168] DSTORE(23) [169] ALOAD(0) [170] ILOAD(22) [171] ICONST_1(Integer{1}) [172] IADD [173] DALOAD [174] DSTORE(25) [175] DLOAD(6) [176] DLOAD(23) [177] DMUL [178] DLOAD(8) [179] DLOAD(25) [180] DMUL [181] DSUB [182] DSTORE(27) [183] DLOAD(6) [184] DLOAD(25) [185] DMUL [186] DLOAD(8) [187] DLOAD(23) [188] DMUL [189] DADD [190] DSTORE(29) [191] ALOAD(0) [192] ILOAD(22) [193] ALOAD(0) [194] ILOAD(21) [195] DALOAD [196] DLOAD(27) [197] DSUB [198] DASTORE [199] ALOAD(0) [200] ILOAD(22) [201] ICONST_1(Integer{1}) [202] IADD [203] ALOAD(0) [204] ILOAD(21) [205] ICONST_1(Integer{1}) [206] IADD [207] DALOAD [208] DLOAD(29) [209] DSUB [210] DASTORE [211] ALOAD(0) [212] ILOAD(21) [213] DUP2Type1 [214] DALOAD [215] DLOAD(27) [216] DADD [217] DASTORE [218] ALOAD(0) [219] ILOAD(21) [220] ICONST_1(Integer{1}) [221] IADD [222] DUP2Type1 [223] DALOAD [224] DLOAD(29) [225] DADD [226] DASTORE [227] ILOAD(20) [228] ICONST_2(Integer{2}) [229] ILOAD(5) [230] IMUL [231] IADD [232] ISTORE(20)
 */
public final class transform_internal_013 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s4;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** double m_d;
         // **REMOVED Unused Var** double m_d2;
         // **REMOVED Unused Var** double m_d3;
         // **REMOVED Unused Var** double m_d4;
         // **REMOVED Unused Var** double m_d5;
         // **REMOVED Unused Var** double m_d6;
         // **REMOVED Unused Var** double m_d7;
         // **REMOVED Unused Var** double m_d8;
         // **REMOVED Unused Var** double m_d9;
         // **REMOVED Unused Var** double m_d10;
        KRegister reg;
         // **REMOVED Unused Var** KRegister reg2;
         // **REMOVED Unused Var** double m_d11;
         // **REMOVED Unused Var** double m_d12;
         // **REMOVED Unused Var** double m_d13;
         // **REMOVED Unused Var** double m_d14;
         // local_0 0 ; r=8/w=0 : Cached
        KRegister local_0 = frame.getLocal(0);
         // local_19 19 ; r=2/w=0 : Cached
        int local_19 = frame.getLocal(19).intValue();
         // local_21 21 ; r=4/w=1 : Cached
        int local_21;
         // local_5 5 ; r=2/w=0 : Cached
        int local_5 = frame.getLocal(5).intValue();
         // local_20 20 ; r=3/w=1 : Cached
        int local_20 = frame.getLocal(20).intValue();
         // local_6 6 ; r=2/w=0 : Cached
        KRegister local_6 = frame.getLocal(6);
         // local_23 23 ; r=2/w=1 : Cached
        KRegister local_23;
         // local_22 22 ; r=4/w=1 : Cached
        int local_22;
         // local_8 8 ; r=2/w=0 : Cached
        KRegister local_8 = frame.getLocal(8);
         // local_25 25 ; r=2/w=1 : Cached
        KRegister local_25;
         // local_27 27 ; r=2/w=1 : Cached
        KRegister local_27;
         // local_29 29 ; r=2/w=1 : Cached
        KRegister local_29;
         // *********[151] ICONST_2(Integer{2})
         // **REMOVED Substitution** s0 = ITWO;
         // *********[152] ILOAD(20)
         // **REMOVED Substitution** s1 = new KInteger(local_20);
         // *********[153] ILOAD(19)
         // **REMOVED Substitution** s2 = new KInteger(local_19);
         // *********[154] IADD
         // **REMOVED Substitution** index = local_19;
         // **REMOVED Substitution** s1 = new KInteger((local_20 + local_19));
         // *********[155] IMUL
         // **REMOVED Substitution** index = (local_20 + local_19);
         // **REMOVED Substitution** s0 = new KInteger((2 * (local_20 + local_19)));
         // *********[156] ISTORE(21)
        local_21 = (2 * (local_20 + local_19));
         // *********[157] ICONST_2(Integer{2})
         // **REMOVED Substitution** s0 = ITWO;
         // *********[158] ILOAD(20)
         // **REMOVED Substitution** s1 = new KInteger(local_20);
         // *********[159] ILOAD(19)
         // **REMOVED Substitution** s2 = new KInteger(local_19);
         // *********[160] IADD
         // **REMOVED Substitution** index = local_19;
         // **REMOVED Substitution** s1 = new KInteger((local_20 + local_19));
         // *********[161] ILOAD(5)
         // **REMOVED Substitution** s2 = new KInteger(local_5);
         // *********[162] IADD
         // **REMOVED Substitution** index = local_5;
         // **REMOVED Substitution** s1 = new KInteger(((local_20 + local_19) + local_5));
         // *********[163] IMUL
         // **REMOVED Substitution** index = ((local_20 + local_19) + local_5);
         // **REMOVED Substitution** s0 = new KInteger((2 * ((local_20 + local_19) + local_5)));
         // *********[164] ISTORE(22)
        local_22 = (2 * ((local_20 + local_19) + local_5));
         // *********[165] ALOAD(0)
         // **REMOVED Substitution** s0 = local_0;
         // *********[166] ILOAD(22)
         // **REMOVED Substitution** s1 = new KInteger(local_22);
         // *********[167] DALOAD
         // **REMOVED Substitution** index = local_22;
         // **REMOVED Substitution** s0 = new KDouble(c_memman.getDoubleArray(((KReference)local_0),local_22));
         // *********[168] DSTORE(23)
        local_23 = new KDouble(c_memman.getDoubleArray(((KReference)local_0),local_22));
         // *********[169] ALOAD(0)
         // **REMOVED Substitution** s0 = local_0;
         // *********[170] ILOAD(22)
         // **REMOVED Substitution** s1 = new KInteger(local_22);
         // *********[171] ICONST_1(Integer{1})
         // **REMOVED Substitution** s2 = IONE;
         // *********[172] IADD
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s1 = new KInteger((local_22 + 1));
         // *********[173] DALOAD
         // **REMOVED Substitution** index = (local_22 + 1);
         // **REMOVED Substitution** s0 = new KDouble(c_memman.getDoubleArray(((KReference)local_0),(local_22 + 1)));
         // *********[174] DSTORE(25)
        local_25 = new KDouble(c_memman.getDoubleArray(((KReference)local_0),(local_22 + 1)));
         // *********[175] DLOAD(6)
         // **REMOVED Substitution** s0 = local_6;
         // *********[176] DLOAD(23)
         // **REMOVED Substitution** s1 = local_23;
         // *********[177] DMUL
         // **REMOVED Substitution** m_d = local_23.doubleValue();
         // **REMOVED Substitution** s0 = new KDouble((local_6.doubleValue() * local_23.doubleValue()));
         // *********[178] DLOAD(8)
         // **REMOVED Substitution** s1 = local_8;
         // *********[179] DLOAD(25)
         // **REMOVED Substitution** s2 = local_25;
         // *********[180] DMUL
         // **REMOVED Substitution** m_d2 = local_25.doubleValue();
         // **REMOVED Substitution** s1 = new KDouble((local_8.doubleValue() * local_25.doubleValue()));
         // *********[181] DSUB
         // **REMOVED Substitution** m_d3 = (local_8.doubleValue() * local_25.doubleValue());
         // **REMOVED Substitution** s0 = new KDouble(((local_6.doubleValue() * local_23.doubleValue()) - (local_8.doubleValue() * local_25.doubleValue())));
         // *********[182] DSTORE(27)
        local_27 = new KDouble(((local_6.doubleValue() * local_23.doubleValue()) - (local_8.doubleValue() * local_25.doubleValue())));
         // *********[183] DLOAD(6)
         // **REMOVED Substitution** s0 = local_6;
         // *********[184] DLOAD(25)
         // **REMOVED Substitution** s1 = local_25;
         // *********[185] DMUL
         // **REMOVED Substitution** m_d4 = local_25.doubleValue();
         // **REMOVED Substitution** s0 = new KDouble((local_6.doubleValue() * local_25.doubleValue()));
         // *********[186] DLOAD(8)
         // **REMOVED Substitution** s1 = local_8;
         // *********[187] DLOAD(23)
         // **REMOVED Substitution** s2 = local_23;
         // *********[188] DMUL
         // **REMOVED Substitution** m_d5 = local_23.doubleValue();
         // **REMOVED Substitution** s1 = new KDouble((local_8.doubleValue() * local_23.doubleValue()));
         // *********[189] DADD
         // **REMOVED Substitution** m_d6 = (local_8.doubleValue() * local_23.doubleValue());
         // **REMOVED Substitution** s0 = new KDouble(((local_6.doubleValue() * local_25.doubleValue()) + (local_8.doubleValue() * local_23.doubleValue())));
         // *********[190] DSTORE(29)
        local_29 = new KDouble(((local_6.doubleValue() * local_25.doubleValue()) + (local_8.doubleValue() * local_23.doubleValue())));
         // *********[191] ALOAD(0)
         // **REMOVED Substitution** s0 = local_0;
         // *********[192] ILOAD(22)
         // **REMOVED Substitution** s1 = new KInteger(local_22);
         // *********[193] ALOAD(0)
         // **REMOVED Substitution** s2 = local_0;
         // *********[194] ILOAD(21)
         // **REMOVED Substitution** s3 = new KInteger(local_21);
         // *********[195] DALOAD
         // **REMOVED Substitution** index = local_21;
         // **REMOVED Substitution** s2 = new KDouble(c_memman.getDoubleArray(((KReference)local_0),local_21));
         // *********[196] DLOAD(27)
         // **REMOVED Substitution** s3 = local_27;
         // *********[197] DSUB
         // **REMOVED Substitution** m_d7 = local_27.doubleValue();
         // **REMOVED Substitution** s2 = new KDouble((c_memman.getDoubleArray(((KReference)local_0),local_21) - local_27.doubleValue()));
         // *********[198] DASTORE
         // **REMOVED Substitution** m_d8 = (c_memman.getDoubleArray(((KReference)local_0),local_21) - local_27.doubleValue());
         // **REMOVED Substitution** index = local_22;
        c_memman.setDoubleArray(((KReference)local_0),local_22,(c_memman.getDoubleArray(((KReference)local_0),local_21) - local_27.doubleValue()));
         // *********[199] ALOAD(0)
         // **REMOVED Substitution** s0 = local_0;
         // *********[200] ILOAD(22)
         // **REMOVED Substitution** s1 = new KInteger(local_22);
         // *********[201] ICONST_1(Integer{1})
         // **REMOVED Substitution** s2 = IONE;
         // *********[202] IADD
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s1 = new KInteger((local_22 + 1));
         // *********[203] ALOAD(0)
         // **REMOVED Substitution** s2 = local_0;
         // *********[204] ILOAD(21)
         // **REMOVED Substitution** s3 = new KInteger(local_21);
         // *********[205] ICONST_1(Integer{1})
         // **REMOVED Substitution** s4 = IONE;
         // *********[206] IADD
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s3 = new KInteger((local_21 + 1));
         // *********[207] DALOAD
         // **REMOVED Substitution** index = (local_21 + 1);
         // **REMOVED Substitution** s2 = new KDouble(c_memman.getDoubleArray(((KReference)local_0),(local_21 + 1)));
         // *********[208] DLOAD(29)
         // **REMOVED Substitution** s3 = local_29;
         // *********[209] DSUB
         // **REMOVED Substitution** m_d9 = local_29.doubleValue();
         // **REMOVED Substitution** s2 = new KDouble((c_memman.getDoubleArray(((KReference)local_0),(local_21 + 1)) - local_29.doubleValue()));
         // *********[210] DASTORE
         // **REMOVED Substitution** m_d10 = (c_memman.getDoubleArray(((KReference)local_0),(local_21 + 1)) - local_29.doubleValue());
         // **REMOVED Substitution** index = (local_22 + 1);
        c_memman.setDoubleArray(((KReference)local_0),(local_22 + 1),(c_memman.getDoubleArray(((KReference)local_0),(local_21 + 1)) - local_29.doubleValue()));
         // *********[211] ALOAD(0)
         // **REMOVED Substitution** s0 = local_0;
         // *********[212] ILOAD(21)
         // **REMOVED Substitution** s1 = new KInteger(local_21);
         // *********[213] DUP2Type1
         // **REMOVED Substitution** reg = new KInteger(local_21);
         // **REMOVED Substitution** reg2 = local_0;
         // **REMOVED Substitution** s1 = new KInteger(local_21);
         // **REMOVED Substitution** s2 = local_0;
         // **REMOVED Substitution** s3 = new KInteger(local_21);
         // *********[214] DALOAD
         // **REMOVED Substitution** index = local_21;
         // **REMOVED Substitution** s2 = new KDouble(c_memman.getDoubleArray(((KReference)local_0),local_21));
         // *********[215] DLOAD(27)
         // **REMOVED Substitution** s3 = local_27;
         // *********[216] DADD
         // **REMOVED Substitution** m_d11 = local_27.doubleValue();
         // **REMOVED Substitution** s2 = new KDouble((c_memman.getDoubleArray(((KReference)local_0),local_21) + local_27.doubleValue()));
         // *********[217] DASTORE
         // **REMOVED Substitution** m_d12 = (c_memman.getDoubleArray(((KReference)local_0),local_21) + local_27.doubleValue());
         // **REMOVED Substitution** index = local_21;
        c_memman.setDoubleArray(((KReference)local_0),local_21,(c_memman.getDoubleArray(((KReference)local_0),local_21) + local_27.doubleValue()));
         // *********[218] ALOAD(0)
         // **REMOVED Substitution** s0 = local_0;
         // *********[219] ILOAD(21)
         // **REMOVED Substitution** s1 = new KInteger(local_21);
         // *********[220] ICONST_1(Integer{1})
         // **REMOVED Substitution** s2 = IONE;
         // *********[221] IADD
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s1 = new KInteger((local_21 + 1));
         // *********[222] DUP2Type1
        reg = new KInteger((local_21 + 1));
         // **REMOVED Substitution** reg2 = local_0;
         // **REMOVED Substitution** s1 = reg;
         // **REMOVED Substitution** s2 = local_0;
         // **REMOVED Substitution** s3 = reg;
         // *********[223] DALOAD
         // **REMOVED Substitution** index = reg.intValue();
         // **REMOVED Substitution** s2 = new KDouble(c_memman.getDoubleArray(((KReference)local_0),reg.intValue()));
         // *********[224] DLOAD(29)
         // **REMOVED Substitution** s3 = local_29;
         // *********[225] DADD
         // **REMOVED Substitution** m_d13 = local_29.doubleValue();
         // **REMOVED Substitution** s2 = new KDouble((c_memman.getDoubleArray(((KReference)local_0),reg.intValue()) + local_29.doubleValue()));
         // *********[226] DASTORE
         // **REMOVED Substitution** m_d14 = (c_memman.getDoubleArray(((KReference)local_0),reg.intValue()) + local_29.doubleValue());
         // **REMOVED Substitution** index = reg.intValue();
        c_memman.setDoubleArray(((KReference)local_0),reg.intValue(),(c_memman.getDoubleArray(((KReference)local_0),reg.intValue()) + local_29.doubleValue()));
         // *********[227] ILOAD(20)
         // **REMOVED Substitution** s0 = new KInteger(local_20);
         // *********[228] ICONST_2(Integer{2})
         // **REMOVED Substitution** s1 = ITWO;
         // *********[229] ILOAD(5)
         // **REMOVED Substitution** s2 = new KInteger(local_5);
         // *********[230] IMUL
         // **REMOVED Substitution** index = local_5;
         // **REMOVED Substitution** s1 = new KInteger((2 * local_5));
         // *********[231] IADD
         // **REMOVED Substitution** index = (2 * local_5);
         // **REMOVED Substitution** s0 = new KInteger((local_20 + (2 * local_5)));
         // *********[232] ISTORE(20)
         // **REMOVED Substitution** local_20 = (local_20 + (2 * local_5));
        frame.setLocal(21,new KInteger(local_21));
        frame.setLocal(20,new KInteger((local_20 + (2 * local_5))));
        frame.setLocal(23,local_23);
        frame.setLocal(22,new KInteger(local_22));
        frame.setLocal(25,local_25);
        frame.setLocal(27,local_27);
        frame.setLocal(29,local_29);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[151] ICONST_2(Integer{2})
         // *********[152] ILOAD(20)
         // *********[153] ILOAD(19)
         // *********[154] IADD
         // *********[155] IMUL
         // *********[156] ISTORE(21)
         // *********[157] ICONST_2(Integer{2})
         // *********[158] ILOAD(20)
         // *********[159] ILOAD(19)
         // *********[160] IADD
         // *********[161] ILOAD(5)
         // *********[162] IADD
         // *********[163] IMUL
         // *********[164] ISTORE(22)
         // *********[165] ALOAD(0)
         // *********[166] ILOAD(22)
         // *********[167] DALOAD
        c_memman = process.getMemoryManager();
         // *********[168] DSTORE(23)
         // *********[169] ALOAD(0)
         // *********[170] ILOAD(22)
         // *********[171] ICONST_1(Integer{1})
         // *********[172] IADD
         // *********[173] DALOAD
         // *********[174] DSTORE(25)
         // *********[175] DLOAD(6)
         // *********[176] DLOAD(23)
         // *********[177] DMUL
         // *********[178] DLOAD(8)
         // *********[179] DLOAD(25)
         // *********[180] DMUL
         // *********[181] DSUB
         // *********[182] DSTORE(27)
         // *********[183] DLOAD(6)
         // *********[184] DLOAD(25)
         // *********[185] DMUL
         // *********[186] DLOAD(8)
         // *********[187] DLOAD(23)
         // *********[188] DMUL
         // *********[189] DADD
         // *********[190] DSTORE(29)
         // *********[191] ALOAD(0)
         // *********[192] ILOAD(22)
         // *********[193] ALOAD(0)
         // *********[194] ILOAD(21)
         // *********[195] DALOAD
         // *********[196] DLOAD(27)
         // *********[197] DSUB
         // *********[198] DASTORE
         // *********[199] ALOAD(0)
         // *********[200] ILOAD(22)
         // *********[201] ICONST_1(Integer{1})
         // *********[202] IADD
         // *********[203] ALOAD(0)
         // *********[204] ILOAD(21)
         // *********[205] ICONST_1(Integer{1})
         // *********[206] IADD
         // *********[207] DALOAD
         // *********[208] DLOAD(29)
         // *********[209] DSUB
         // *********[210] DASTORE
         // *********[211] ALOAD(0)
         // *********[212] ILOAD(21)
         // *********[213] DUP2Type1
         // *********[214] DALOAD
         // *********[215] DLOAD(27)
         // *********[216] DADD
         // *********[217] DASTORE
         // *********[218] ALOAD(0)
         // *********[219] ILOAD(21)
         // *********[220] ICONST_1(Integer{1})
         // *********[221] IADD
         // *********[222] DUP2Type1
         // *********[223] DALOAD
         // *********[224] DLOAD(29)
         // *********[225] DADD
         // *********[226] DASTORE
         // *********[227] ILOAD(20)
         // *********[228] ICONST_2(Integer{2})
         // *********[229] ILOAD(5)
         // *********[230] IMUL
         // *********[231] IADD
         // *********[232] ISTORE(20)
        c_next = instructions[(index + 1)];
      }
}
