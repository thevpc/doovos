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

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 14 août 2008
 * Time: 01:36:15
 * To change this template use File | Settings | File Templates.
 */
public enum KOperator {
    NOP(0, 0, 0,false, true, KOperatorGroup.NOP),//<name>
    ALOAD(1, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    ALOAD_0(0, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    ALOAD_1(0, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    ALOAD_2(0, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    ALOAD_3(0, 0, 1,false, true, KOperatorGroup.MISC),//<name>

    ACONST_NULL(0, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    BALOAD(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>
    BASTORE(0, 3, 0,false, true, KOperatorGroup.MISC),//<name>
    BIPUSH(1, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    ICONST_M1(0, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    ICONST_0(0, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    ICONST_1(0, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    ICONST_2(0, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    ICONST_3(0, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    ICONST_4(0, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    ICONST_5(0, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    IALOAD(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>
    IASTORE(0, 3, 0,false, true, KOperatorGroup.MISC),//<name>
    //@Deprecated
    //IPUSH(1, 0, 1),//<name>
    ISTORE(1, 1, 0,false, true, KOperatorGroup.MISC),//<name>
    ISTORE_0(0, 1, 0,false, true, KOperatorGroup.MISC),//<name>
    ISTORE_1(0, 1, 0,false, true, KOperatorGroup.MISC),//<name>
    ISTORE_2(0, 1, 0,false, true, KOperatorGroup.MISC),//<name>
    ISTORE_3(0, 1, 0,false, true, KOperatorGroup.MISC),//<name>
    ILOAD(1, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    ILOAD_0(0, 1, 0,false, true, KOperatorGroup.MISC),//<name>
    ILOAD_1(0, 1, 0,false, true, KOperatorGroup.MISC),//<name>
    ILOAD_2(0, 1, 0,false, true, KOperatorGroup.MISC),//<name>
    ILOAD_3(0, 1, 0,false, true, KOperatorGroup.MISC),//<name>
    IXOR(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>
    IUSHR(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>
    ISHR(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>
    ISHL(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>
    IADD(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>
    IAND(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>
    INSTANCEOF(0, 2, 1,false, false, KOperatorGroup.MISC),//<name>
    IOR(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>
    IMUL(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>
    ISUB(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>
    IDIV(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>
    INEG(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>
    IREM(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>
    IINC(2, 0, 0,false, false, KOperatorGroup.MISC),//<name>

    LRETURN(0, 1, 0,true, true, KOperatorGroup.RETURN),//<name>
    LALOAD(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>
    LLOAD(1, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    LLOAD_0(0, 1, 0,false, true, KOperatorGroup.MISC),//<name>
    LLOAD_1(0, 1, 0,false, true, KOperatorGroup.MISC),//<name>
    LLOAD_2(0, 1, 0,false, true, KOperatorGroup.MISC),//<name>
    LLOAD_3(0, 1, 0,false, true, KOperatorGroup.MISC),//<name>
    LSTORE(1, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    LSTORE_0(0, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    LSTORE_1(0, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    LSTORE_2(0, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    LSTORE_3(0, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    LASTORE(0, 3, 0,false, true, KOperatorGroup.MISC),//<name>
    LAND(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>

    LCMP(0, 2, 1,false, true, KOperatorGroup.IF),//<name>
    LOR(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>
    LREM(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>
    LNEG(0, 1, 1,false, true, KOperatorGroup.MISC),//<name>
    LXOR(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>
    LUSHR(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>
    LSHR(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>
    LSHL(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>
    LADD(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>
    LSUB(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>
    LMUL(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>
    LDIV(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>
    LCONST_0(0, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    LCONST_1(0, 0, 1,false, true, KOperatorGroup.MISC),//<name>

    CALOAD(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>
    CASTORE(0, 3, 0,false, true, KOperatorGroup.MISC),//<name>
    CHECKCAST(2, 1, 1,false, false, KOperatorGroup.MISC),//<name>
    SALOAD(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>
    FASTORE(0, 3, 0,false, true, KOperatorGroup.MISC),//<name>
    SASTORE(0, 3, 0,false, true, KOperatorGroup.MISC),//<name>
    IRETURN(0, 1, 0,true, true, KOperatorGroup.RETURN),//<name>
    //SRETURN(0, 1, 0,false),//<name>
    //@Deprecated
    //CRETURN(0, 1, 0,false),//<name>
    ARETURN(0, 1, 0,true, true, KOperatorGroup.RETURN),//<name>

//    NATIVEJ(0, 1, 0,false),//<name>
//    NATIVEJCONST(1, 0, 0,false),//<name>
//    SYS_ALLOC_SEGMENT(2, 0, 0,false),//<name>
//    PUSH(1, 0, 1,false),//<name>
//    PUSH_M(2, 0, 1,false),//<name>
    DADD(0, 2, 1,false, true, KOperatorGroup.BINOP),//<name>
    DALOAD(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>
    DASTORE(0, 3, 0,false, true, KOperatorGroup.MISC),//<name>
    //@Deprecated
    //DCMP(0, 2, 1,false),//<name>
    //DCONST(1, 0, 0,false),//<name>
    DDIV(0, 2, 1,false, true, KOperatorGroup.BINOP),//<name>
    DLOAD(1, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    DLOAD_0(0, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    DLOAD_1(0, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    DLOAD_2(0, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    DLOAD_3(0, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    DMUL(0, 2, 1,false, true, KOperatorGroup.BINOP),//<name>
    DSUB(0, 2, 1,false, true, KOperatorGroup.BINOP),//<name>
    DNEG(0, 1, 1,false, true, KOperatorGroup.BINOP),//<name>
    DREM(0, 2, 1,false, true, KOperatorGroup.BINOP),//<name>
    DRETURN(0, 1, 0,true, true, KOperatorGroup.RETURN),//<name>
    DCONST_0(0, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    DCONST_1(0, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    DUP(0, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    DUP_X1(0, -1, 3,false, false, KOperatorGroup.MISC),//<name>
    DUP_X2(0, -1, 3,false, false, KOperatorGroup.MISC),//<name>
    DUP2(0, -1, 3,false, false, KOperatorGroup.MISC),//<name>
    DUP2_X1(0, -1, 3,false, false, KOperatorGroup.MISC),//<name>
    DUP2_X2(0, -1, 3,false, false, KOperatorGroup.MISC),//<name>
    //DUB_I(0, 2, 1,false),//: y=pop;x=pop;push x-y
    D2F(0, 1, 1,false, true, KOperatorGroup.CONVERT),//<name>
    D2I(0, 1, 1,false, true, KOperatorGroup.CONVERT),//<name>
    D2L(0, 1, 1,false, true, KOperatorGroup.CONVERT),//<name>
    DCMPG(0, 2, 1,false, false, KOperatorGroup.MISC),//<name>
    DCMPL(0, 2, 1,false, false, KOperatorGroup.MISC),//<name>
    DSTORE(1, 1, 0,false, true, KOperatorGroup.MISC),//<name>
    DSTORE_0(0, 1, 0,false, true, KOperatorGroup.MISC),//<name>
    DSTORE_1(0, 1, 0,false, true, KOperatorGroup.MISC),//<name>
    DSTORE_2(0, 1, 0,false, true, KOperatorGroup.MISC),//<name>
    DSTORE_3(0, 1, 0,false, true, KOperatorGroup.MISC),//<name>

    POP(0, 1, 0,false, true, KOperatorGroup.MISC),//<name>
    POP2(0, 1, 0,false, false, KOperatorGroup.MISC),//<name>
//    POP_I(2, 0, 0,false),//<name>
//    POW_I(0, 2, 1,false),//: y=pop;x=pop;push x-y
//    NEG_I(0, 1, 1,false),//: y=pop;x=pop;push x-y
//    ALLOC_I(2, 0, 0,false),//<name>
//    ALLOC_IA(2, 0, 0,false),//<name>
//    REGDEFINE(0, 0, 0,false),//<name>
//    STDOUT(0, 0, 0,false),//<name>
    GOTO(1, 0, 0,true, false, KOperatorGroup.GOTO),//<name>
    JSR(1, 0, 1,true, false, KOperatorGroup.GOTO),//<name>
    JSR_W(1, 0, 1,true, false, KOperatorGroup.GOTO),//<name>
    RET(1, 0, 0,true, false, KOperatorGroup.GOTO),//<name>
    GOTO_W(1, 0, 0,true, false, KOperatorGroup.GOTO),//<name>

    IF_ACMPEQ(1, 2, 0,true, false, KOperatorGroup.IF),//<name>
    IF_ACMPNE(1, 2, 0,true, false, KOperatorGroup.IF),//<name>

    IF_ICMPEQ(1, 2, 0,true, false, KOperatorGroup.IF),//<name>
    IF_ICMPNE(1, 2, 0,true, false, KOperatorGroup.IF),//<name>
    IF_ICMPLT(1, 2, 0,true, false, KOperatorGroup.IF),//<name>
    IF_ICMPLE(1, 2, 0,true, false, KOperatorGroup.IF),//<name>
    IF_ICMPGT(1, 2, 0,true, false, KOperatorGroup.IF),//<name>
    IF_ICMPGE(1, 2, 0,true, false, KOperatorGroup.IF),//<name>
    //same as the if_eq in jvm
    IFEQ(1, 1, 0,true, false, KOperatorGroup.IF),//<name>
    IFNE(1, 1, 0,true, false, KOperatorGroup.IF),//<name>
    IFLT(1, 1, 0,true, false, KOperatorGroup.IF),//<name>
    IFLE(1, 1, 0,true, false, KOperatorGroup.IF),//<name>
    IFGE(1, 1, 0,true, false, KOperatorGroup.IF),//<name>
    IFGT(1, 1, 0,true, false, KOperatorGroup.IF),//<name>
    IFNONNULL(1, 1, 0,true, false, KOperatorGroup.IF),//<name>
    IFNULL(1, 1, 0,true, false, KOperatorGroup.IF),//<name>
    LDC(1, 0, 1,false, false, KOperatorGroup.MISC),//<name>
    LDC_W(1, 0, 1,false, false, KOperatorGroup.MISC),//<name>
    LDC2_W(1, 0, 1,false, false, KOperatorGroup.MISC),//<name>
//    END(0, 0, 0,false),//<name>
    RETURN(0, 0, 0,true, true, KOperatorGroup.RETURN),//<name>
//    SYSCALL(1, 0, 0,false),//<name>
    SIPUSH(1, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    ASTORE(1, 1, 0,false, true, KOperatorGroup.MISC),//<name>
    ASTORE_0(0, 1, 0,false, true, KOperatorGroup.MISC),//<name>
    ASTORE_1(0, 1, 0,false, true, KOperatorGroup.MISC),//<name>
    ASTORE_2(0, 1, 0,false, true, KOperatorGroup.MISC),//<name>
    ASTORE_3(0, 1, 0,false, true, KOperatorGroup.MISC),//<name>
    INVOKESTATIC(2, -1, 0,true, false, KOperatorGroup.INVOKE),//<name>
    INVOKESPECIAL(2, -1, 0,true, false, KOperatorGroup.INVOKE),//<name>
    INVOKEVIRTUAL(2, -1, 0,true, false, KOperatorGroup.INVOKE),//<name>
    INVOKEINTERFACE(2, -1, 0,true, false, KOperatorGroup.INVOKE),//<name>
    NEW(1, 0, 1,false, false, KOperatorGroup.MISC),//<name>
    NEWARRAY(1, 1, 0,false, false, KOperatorGroup.MISC),//<name>
    ANEWARRAY(1, 1, 1,false, false, KOperatorGroup.MISC),//<name>
    MULTIANEWARRAY(1, 1, 1,false, false, KOperatorGroup.MISC),//<name>
    MONITORENTER(0, 1, 0,false, true, KOperatorGroup.MISC),//<name>
    MONITOREXIT(0, 1, 0,false, true, KOperatorGroup.MISC),//<name>
    AASTORE(0, 3, 0,false, true, KOperatorGroup.MISC),//<name>
    AALOAD(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>
    GETSTATIC(2, 0, 1,true, false, KOperatorGroup.MISC),//<name>
    PUTSTATIC(2, 1, 0,true, false, KOperatorGroup.MISC),//<name>
    GETFIELD(2, 1, 1,true, false, KOperatorGroup.MISC),//<name>
    PUTFIELD(2, 2, 0,true, false, KOperatorGroup.MISC),//<name>
    SWAP(0, 2, 2,false, true, KOperatorGroup.MISC),//<name>
    ARRAYLENGTH(0, 1, 1,false, true, KOperatorGroup.MISC),//<name>
    ATHROW(0, 1, 1,true, true, KOperatorGroup.MISC),//<name>


    //------------------------

    FADD(0, 2, 1,false, true, KOperatorGroup.BINOP),//<name>
    FMUL(0, 2, 1,false, true, KOperatorGroup.BINOP),//<name>
    FDIV(0, 2, 1,false, true, KOperatorGroup.BINOP),//<name>
    FSUB(0, 2, 1,false, true, KOperatorGroup.BINOP),//<name>
    FCONST_0(0, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    FCONST_1(0, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    FCONST_2(0, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    FCMPG(0, 2, 1,false, true, KOperatorGroup.IF),//<name>
    FCMPL(0, 2, 1,false, true, KOperatorGroup.IF),//<name>
    FALOAD(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>
    FLOAD(1, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    FLOAD_0(0, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    FLOAD_1(0, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    FLOAD_2(0, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    FLOAD_3(0, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    FNEG(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>
    FREM(0, 2, 1,false, true, KOperatorGroup.MISC),//<name>
    FRETURN(0, 1, 0,true, true, KOperatorGroup.RETURN),//<name>
    FSTORE(1, 0, 1,false, true, KOperatorGroup.MISC),//<name>
    FSTORE_0(0, 1, 0,false, true, KOperatorGroup.MISC),//<name>
    FSTORE_1(0, 1, 0,false, true, KOperatorGroup.MISC),//<name>
    FSTORE_2(0, 1, 0,false, true, KOperatorGroup.MISC),//<name>
    FSTORE_3(0, 1, 0,false, true, KOperatorGroup.MISC),//<name>

    TABLESWITCH(0, 1, 0,true, false, KOperatorGroup.MISC),//<name>
    LOOKUPSWITCH(0, 1, 0,true, false, KOperatorGroup.MISC),//<name>


    I2F(0, 1, 1,false, true, KOperatorGroup.MISC),//<name>
    I2L(0, 1, 1,false, true, KOperatorGroup.MISC),//<name>
    L2I(0, 1, 1,false, true, KOperatorGroup.MISC),//<name>
    L2D(0, 1, 1,false, true, KOperatorGroup.MISC),//<name>
    L2F(0, 1, 1,false, true, KOperatorGroup.MISC),//<name>
    I2S(0, 1, 1,false, true, KOperatorGroup.MISC),//<name>
    I2B(0, 1, 1,false, true, KOperatorGroup.MISC),//<name>
    I2C(0, 1, 1,false, true, KOperatorGroup.MISC),//<name>
    I2D(0, 1, 1,false, true, KOperatorGroup.MISC),//<name>
//    S2L(0, 1, 1,false),//<name>
    F2I(0, 1, 1,false, true, KOperatorGroup.MISC),//<name>
    F2D(0, 1, 1,false, true, KOperatorGroup.MISC),//<name>
    F2L(0, 1, 1,false, true, KOperatorGroup.MISC),//<name>

    UNUSED(0, 0, 0,false, false, KOperatorGroup.MISC),//<name>
//    G2I(0, 1, 1,false),//<name>
//    G2CA(0, 1, 1,false),//<name>
//    CA2G(0, 1, 1,false),//<name>
//    G2L(0, 1, 1,false),//<name>
//    I2G(0, 1, 1,false),//<name>
    XTRA_JNI(0, 0, 0,false, false, KOperatorGroup.MISC),//<name>
    WIDE(0, 0, 0,false, false, KOperatorGroup.MISC),//<name>
    X_USER_DEFINED(0, 0, 0,false, false, KOperatorGroup.MISC)//<name>

//    dpop_ia,//<name>
//    dpop_l,//<name>
//    dpop_la,//<name>
//    dpop_b,//<name>
//    dpop_ba,//<name>
//    dpop_t,//<name>
//    dpop_ta,//<name>
//    dpop_d,//<name>
//    dpop_da,//<name>
//    dpop_f,//<name>
//    dpop_fa,//<name>
//
//    dsub,//: y=pop;x=pop;push x-y
//    dmul,//: y=pop;x=pop;push x*y
//    ddiv,//: y=pop;x=pop;push x/y
//    dlt,//: y=pop;x=pop;push x<y?true:false
//    djmpif,//: b=pop;addr=pop; if b jump to addr
//    djmpifn,//: b=pop;addr=pop; if !b jump to addr
//    ddefineclass,//<fullName>
//    ddefinemethod,//<classname> <returntype> <fullName> <type1> <param1> <type2> <param2> ....
//    ddefineattribute,//<classname> <type> <name>
//    dsetattribute,//: attr=pop
//    dgetattribute,//: push=attr
//    dselectmethod,//method <instance>=pop <classname> <returntype> <fullName> <type1> <param1> <type2> <param2> ....
//    dinvokemethod,//<paramcount> <param1> =pop, ... <paramn> =pop, <instance>=pop
//    dreturn,
//    lset,
//    lget,
//    ladd,//: y=pop;x=pop;push x+y
//    lsub,//,: y=pop;x=pop;push x-y
//    lmul,//: y=pop;x=pop;push x*y
//    ldiv,// y=pop;x=pop;push x/y
//    llt,// y=pop;x=pop;push x<y?true:false
//    ljmpif,// b=pop;addr=pop; if b jump to addr
//    ljmpifn,;// b=pop;addr=pop; if !b jump to addr
    ;
    /**
     * count of expected operands
     */
    private int operandsCount;
    /**
     * count of expected stack before
     */
    private int pushCount;
    /**
     * count of expected stack after
     */
    private int popCount;
    private boolean  jump;
    private boolean  generic;
    private KOperatorGroup  group;


    private KOperator(int operands, int popCount, int pushCount, boolean jump, boolean generic, KOperatorGroup group) {
        this.operandsCount = operands;
        this.pushCount = pushCount;
        this.popCount = popCount;
        this.jump = jump;
        this.group = group;
        this.generic = generic;
    }

    public boolean isGeneric() {
        return generic;
    }

    public boolean isJump() {
        return jump;
    }

    public int getOperandsCount() {
        return operandsCount;
    }

    public int getPushCount() {
        return pushCount;
    }

    public int getPopCount() {
        return popCount;
    }

    public KOperatorGroup getGroup() {
        return group;
    }
    
}
