0000 ALOAD(0)
0001 ARRAYLENGTH
0002 ALOAD(1)
0003 ARRAYLENGTH
0004 IADD
0005 ANEWARRAY(3)
0006 ASTORE(2)
0007 ALOAD(0)
0008 ICONST_0(Integer{0})
0009 ALOAD(2)
0010 ICONST_0(Integer{0})
0011 ALOAD(0)
0012 ARRAYLENGTH
0013 INVOKESTATIC(java.lang.System,arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V)
0014 ALOAD(1)
0015 ICONST_0(Integer{0})
0016 ALOAD(2)
0017 ALOAD(0)
0018 ARRAYLENGTH
0019 ALOAD(1)
0020 ARRAYLENGTH
0021 INVOKESTATIC(java.lang.System,arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V)
0022 ALOAD(2)
0023 ARETURN
