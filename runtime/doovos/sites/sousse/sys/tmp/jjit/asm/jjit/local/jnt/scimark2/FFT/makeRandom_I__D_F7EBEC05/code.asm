0000 ICONST_2(Integer{2})
0001 ILOAD(0)
0002 IMUL
0003 ISTORE(1)
0004 ILOAD(1)
0005 NEWARRAY
0006 ASTORE(2)
0007 ICONST_0(Integer{0})
0008 ISTORE(3)
0009 GOTO(15)
0010 ALOAD(2)
0011 ILOAD(3)
0012 INVOKESTATIC(java.lang.Math,random()D)
0013 DASTORE
0014 IINC(3,1)
0015 ILOAD(3)
0016 ILOAD(1)
0017 IF_ICMPLT(10)
0018 ALOAD(2)
0019 ARETURN
