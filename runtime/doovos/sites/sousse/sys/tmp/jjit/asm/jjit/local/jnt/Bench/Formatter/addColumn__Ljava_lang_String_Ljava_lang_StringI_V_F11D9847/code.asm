0000 ICONST_0(Integer{0})
0001 ISTORE(3)
0002 ICONST_0(Integer{0})
0003 ISTORE(4)
0004 ICONST_0(Integer{0})
0005 ISTORE(6)
0006 GOTO(28)
0007 ALOAD(0)
0008 ILOAD(6)
0009 AALOAD
0010 INVOKEVIRTUAL(java.lang.String,length()I)
0011 DUP
0012 ISTORE(5)
0013 ILOAD(3)
0014 IF_ICMPLE(17)
0015 ILOAD(5)
0016 ISTORE(3)
0017 ALOAD(1)
0018 ILOAD(6)
0019 AALOAD
0020 INVOKEVIRTUAL(java.lang.String,length()I)
0021 DUP
0022 ISTORE(5)
0023 ILOAD(4)
0024 IF_ICMPLE(27)
0025 ILOAD(5)
0026 ISTORE(4)
0027 IINC(6,1)
0028 ILOAD(6)
0029 ALOAD(0)
0030 ARRAYLENGTH
0031 IF_ICMPLT(7)
0032 ICONST_0(Integer{0})
0033 ISTORE(7)
0034 GOTO(70)
0035 NEW(java.lang.StringBuffer)
0036 DUP
0037 INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
0038 ALOAD(0)
0039 ILOAD(7)
0040 DUP2_X1
0041 AALOAD
0042 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0043 BIPUSH(32)
0044 ILOAD(3)
0045 ALOAD(0)
0046 ILOAD(7)
0047 AALOAD
0048 INVOKEVIRTUAL(java.lang.String,length()I)
0049 ISUB
0050 ICONST_1(Integer{1})
0051 IADD
0052 ILOAD(4)
0053 ALOAD(1)
0054 ILOAD(7)
0055 AALOAD
0056 INVOKEVIRTUAL(java.lang.String,length()I)
0057 ISUB
0058 ILOAD(2)
0059 IMUL
0060 IADD
0061 INVOKESTATIC(jnt.Bench.Formatter,pad(CI)Ljava/lang/String;)
0062 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0063 ALOAD(1)
0064 ILOAD(7)
0065 AALOAD
0066 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0067 INVOKEVIRTUAL(java.lang.StringBuffer,toString()Ljava/lang/String;)
0068 AASTORE
0069 IINC(7,1)
0070 ILOAD(7)
0071 ALOAD(0)
0072 ARRAYLENGTH
0073 IF_ICMPLT(35)
0074 RETURN
