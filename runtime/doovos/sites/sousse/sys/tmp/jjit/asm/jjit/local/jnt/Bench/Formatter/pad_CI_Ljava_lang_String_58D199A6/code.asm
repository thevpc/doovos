0000 ILOAD(1)
0001 IFGT(4)
0002 LDC(2->"")
0003 ARETURN
0004 ILOAD(1)
0005 NEWARRAY
0006 ASTORE(2)
0007 ICONST_0(Integer{0})
0008 ISTORE(3)
0009 GOTO(15)
0010 ALOAD(2)
0011 ILOAD(3)
0012 ILOAD(0)
0013 CASTORE
0014 IINC(3,1)
0015 ILOAD(3)
0016 ILOAD(1)
0017 IF_ICMPLT(10)
0018 NEW(java.lang.String)
0019 DUP
0020 ALOAD(2)
0021 INVOKESPECIAL(java.lang.String,<init>([C)V)
0022 ARETURN
