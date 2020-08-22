/**
 * ====================================================================
 *             Doovos (Distributed Object Oriented Operating System)
 *
 * Doovos is a new Open Source Distributed Object Oriented Operating System
 * Design and implementation based on the Java Platform.
 * Actually, it is a try for designing a distributed operation system in
 * top of existing centralized/network OS.
 * Designed OS will follow the object oriented architecture for redefining
 * all OS resources (memory,process,file system,device,...etc.) in a highly
 * distributed context.
 * Doovos is also a distributed Java virtual machine that implements JVM
 * specification on top the distributed resources context.
 *
 * Doovos Kernel is the heart of Doovos OS. It implements also the Doovos JVM
 * Doovos Kernel code is executed on host JVM
 *
 * Copyright (C) 2008-2010 Taha BEN SALAH
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 * ====================================================================
 */
package org.doovos.kernel.api.jvm.bytecode;


import java.lang.reflect.Field;

public class KOperatorCodes {
    private KOperatorCodes() {
    }

    public static final int NOP = 0; // visitInsn
    public static final int ACONST_NULL = 1; // -
    public static final int ICONST_M1 = 2; // -
    public static final int ICONST_0 = 3; // -
    public static final int ICONST_1 = 4; // -
    public static final int ICONST_2 = 5; // -
    public static final int ICONST_3 = 6; // -
    public static final int ICONST_4 = 7; // -
    public static final int ICONST_5 = 8; // -
    public static final int LCONST_0 = 9; // -
    public static final int LCONST_1 = 10; // -
    public static final int FCONST_0 = 11; // -
    public static final int FCONST_1 = 12; // -
    public static final int FCONST_2 = 13; // -
    public static final int DCONST_0 = 14; // -
    public static final int DCONST_1 = 15; // -
    public static final int BIPUSH = 16; // visitIntInsn
    public static final int SIPUSH = 17; // -
    public static final int LDC = 18; // visitLdcInsn
    public static final int LDC_W = 19; // -
    public static final int LDC2_W = 20; // -
    public static final int ILOAD = 21; // visitVarInsn
    public static final int LLOAD = 22; // -
    public static final int FLOAD = 23; // -
    public static final int DLOAD = 24; // -
    public static final int ALOAD = 25; // -
    public static final int ILOAD_0 = 26; // -
    public static final int ILOAD_1 = 27; // -
    public static final int ILOAD_2 = 28; // -
    public static final int ILOAD_3 = 29; // -
    public static final int LLOAD_0 = 30; // -
    public static final int LLOAD_1 = 31; // -
    public static final int LLOAD_2 = 32; // -
    public static final int LLOAD_3 = 33; // -
    public static final int FLOAD_0 = 34; // -
    public static final int FLOAD_1 = 35; // -
    public static final int FLOAD_2 = 36; // -
    public static final int FLOAD_3 = 37; // -
    public static final int DLOAD_0 = 38; // -
    public static final int DLOAD_1 = 39; // -
    public static final int DLOAD_2 = 40; // -
    public static final int DLOAD_3 = 41; // -
    public static final int ALOAD_0 = 42; // -
    public static final int ALOAD_1 = 43; // -
    public static final int ALOAD_2 = 44; // -
    public static final int ALOAD_3 = 45; // -
    public static final int IALOAD = 46; // visitInsn
    public static final int LALOAD = 47; // -
    public static final int FALOAD = 48; // -
    public static final int DALOAD = 49; // -
    public static final int AALOAD = 50; // -
    public static final int BALOAD = 51; // -
    public static final int CALOAD = 52; // -
    public static final int SALOAD = 53; // -
    public static final int ISTORE = 54; // visitVarInsn
    public static final int LSTORE = 55; // -
    public static final int FSTORE = 56; // -
    public static final int DSTORE = 57; // -
    public static final int ASTORE = 58; // -
    public static final int ISTORE_0 = 59; // -
    public static final int ISTORE_1 = 60; // -
    public static final int ISTORE_2 = 61; // -
    public static final int ISTORE_3 = 62; // -
    public static final int LSTORE_0 = 63; // -
    public static final int LSTORE_1 = 64; // -
    public static final int LSTORE_2 = 65; // -
    public static final int LSTORE_3 = 66; // -
    public static final int FSTORE_0 = 67; // -
    public static final int FSTORE_1 = 68; // -
    public static final int FSTORE_2 = 69; // -
    public static final int FSTORE_3 = 70; // -
    public static final int DSTORE_0 = 71; // -
    public static final int DSTORE_1 = 72; // -
    public static final int DSTORE_2 = 73; // -
    public static final int DSTORE_3 = 74; // -
    public static final int ASTORE_0 = 75; // -
    public static final int ASTORE_1 = 76; // -
    public static final int ASTORE_2 = 77; // -
    public static final int ASTORE_3 = 78; // -
    public static final int IASTORE = 79; // visitInsn
    public static final int LASTORE = 80; // -
    public static final int FASTORE = 81; // -
    public static final int DASTORE = 82; // -
    public static final int AASTORE = 83; // -
    public static final int BASTORE = 84; // -
    public static final int CASTORE = 85; // -
    public static final int SASTORE = 86; // -
    public static final int POP = 87; // -
    public static final int POP2 = 88; // -
    public static final int DUP = 89; // -
    public static final int DUP_X1 = 90; // -
    public static final int DUP_X2 = 91; // -
    public static final int DUP2 = 92; // -
    public static final int DUP2_X1 = 93; // -
    public static final int DUP2_X2 = 94; // -
    public static final int SWAP = 95; // -
    public static final int IADD = 96; // -
    public static final int LADD = 97; // -
    public static final int FADD = 98; // -
    public static final int DADD = 99; // -
    public static final int ISUB = 100; // -
    public static final int LSUB = 101; // -
    public static final int FSUB = 102; // -
    public static final int DSUB = 103; // -
    public static final int IMUL = 104; // -
    public static final int LMUL = 105; // -
    public static final int FMUL = 106; // -
    public static final int DMUL = 107; // -
    public static final int IDIV = 108; // -
    public static final int LDIV = 109; // -
    public static final int FDIV = 110; // -
    public static final int DDIV = 111; // -
    public static final int IREM = 112; // -
    public static final int LREM = 113; // -
    public static final int FREM = 114; // -
    public static final int DREM = 115; // -
    public static final int INEG = 116; // -
    public static final int LNEG = 117; // -
    public static final int FNEG = 118; // -
    public static final int DNEG = 119; // -
    public static final int ISHL = 120; // -
    public static final int LSHL = 121; // -
    public static final int ISHR = 122; // -
    public static final int LSHR = 123; // -
    public static final int IUSHR = 124; // -
    public static final int LUSHR = 125; // -
    public static final int IAND = 126; // -
    public static final int LAND = 127; // -
    public static final int IOR = 128; // -
    public static final int LOR = 129; // -
    public static final int IXOR = 130; // -
    public static final int LXOR = 131; // -
    public static final int IINC = 132; // visitIincInsn
    public static final int I2L = 133; // visitInsn
    public static final int I2F = 134; // -
    public static final int I2D = 135; // -
    public static final int L2I = 136; // -
    public static final int L2F = 137; // -
    public static final int L2D = 138; // -
    public static final int F2I = 139; // -
    public static final int F2L = 140; // -
    public static final int F2D = 141; // -
    public static final int D2I = 142; // -
    public static final int D2L = 143; // -
    public static final int D2F = 144; // -
    public static final int I2B = 145; // -
    public static final int I2C = 146; // -
    public static final int I2S = 147; // -
    public static final int LCMP = 148; // -
    public static final int FCMPL = 149; // -
    public static final int FCMPG = 150; // -
    public static final int DCMPL = 151; // -
    public static final int DCMPG = 152; // -
    public static final int IFEQ = 153; // visitJumpInsn
    public static final int IFNE = 154; // -
    public static final int IFLT = 155; // -
    public static final int IFGE = 156; // -
    public static final int IFGT = 157; // -
    public static final int IFLE = 158; // -
    public static final int IF_ICMPEQ = 159; // -
    public static final int IF_ICMPNE = 160; // -
    public static final int IF_ICMPLT = 161; // -
    public static final int IF_ICMPGE = 162; // -
    public static final int IF_ICMPGT = 163; // -
    public static final int IF_ICMPLE = 164; // -
    public static final int IF_ACMPEQ = 165; // -
    public static final int IF_ACMPNE = 166; // -
    public static final int GOTO = 167; // -
    public static final int JSR = 168; // -
    public static final int RET = 169; // visitVarInsn
    public static final int TABLESWITCH = 170; // visiTableSwitchInsn
    public static final int LOOKUPSWITCH = 171; // visitLookupSwitch
    public static final int IRETURN = 172; // visitInsn
    public static final int LRETURN = 173; // -
    public static final int FRETURN = 174; // -
    public static final int DRETURN = 175; // -
    public static final int ARETURN = 176; // -
    public static final int RETURN = 177; // -
    public static final int GETSTATIC = 178; // visitFieldInsn
    public static final int PUTSTATIC = 179; // -
    public static final int GETFIELD = 180; // -
    public static final int PUTFIELD = 181; // -
    public static final int INVOKEVIRTUAL = 182; // visitMethodInsn
    public static final int INVOKESPECIAL = 183; // -
    public static final int INVOKESTATIC = 184; // -
    public static final int INVOKEINTERFACE = 185; // -
    public static final int UNUSED = 186; // NOT VISITED
    public static final int NEW = 187; // visitTypeInsn
    public static final int NEWARRAY = 188; // visitIntInsn
    public static final int ANEWARRAY = 189; // visitTypeInsn
    public static final int ARRAYLENGTH = 190; // visitInsn
    public static final int ATHROW = 191; // -
    public static final int CHECKCAST = 192; // visitTypeInsn
    public static final int INSTANCEOF = 193; // -
    public static final int MONITORENTER = 194; // visitInsn
    public static final int MONITOREXIT = 195; // -
    public static final int WIDE = 196; // NOT VISITED
    public static final int MULTIANEWARRAY = 197; // visitMultiANewArrayInsn
    public static final int IFNULL = 198; // visitJumpInsn
    public static final int IFNONNULL = 199; // -
    public static final int GOTO_W = 200; // -
    public static final int JSR_W = 201; // -


    public static final String[] ALL_NAMES;
    public static final KOperator[] ALL_OPERATORS;

    static {
        ALL_NAMES = new String[202];
        ALL_OPERATORS = new KOperator[202];
        for (Field field : KOperatorCodes.class.getDeclaredFields()) {
            try {
                if (!field.getName().startsWith("ALL_")) {
                    int ii = field.getInt(null);
                    ALL_NAMES[ii] = field.getName();
                    try {
                        ALL_OPERATORS[ii] = KOperator.valueOf(field.getName());
                    } catch (IllegalArgumentException e) {
                        System.err.println("unable to initialize ALL_OPERATORS : "+e.getMessage());
                    }
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }
}
