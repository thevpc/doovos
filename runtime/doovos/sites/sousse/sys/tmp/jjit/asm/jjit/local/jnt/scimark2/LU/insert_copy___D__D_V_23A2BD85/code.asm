0000 ALOAD(1)
0001 ARRAYLENGTH
0002 ISTORE(2)
0003 ALOAD(1)
0004 ICONST_0(Integer{0})
0005 AALOAD
0006 ARRAYLENGTH
0007 ISTORE(3)
0008 ILOAD(3)
0009 ICONST_3(Integer{3})
0010 IAND
0011 ISTORE(4)
0012 ICONST_0(Integer{0})
0013 ISTORE(5)
0014 GOTO(80)
0015 ALOAD(0)
0016 ILOAD(5)
0017 AALOAD
0018 ASTORE(6)
0019 ALOAD(1)
0020 ILOAD(5)
0021 AALOAD
0022 ASTORE(7)
0023 ICONST_0(Integer{0})
0024 ISTORE(8)
0025 GOTO(33)
0026 ALOAD(6)
0027 ILOAD(8)
0028 ALOAD(7)
0029 ILOAD(8)
0030 DALOAD
0031 DASTORE
0032 IINC(8,1)
0033 ILOAD(8)
0034 ILOAD(4)
0035 IF_ICMPLT(26)
0036 ILOAD(4)
0037 ISTORE(9)
0038 GOTO(76)
0039 ALOAD(6)
0040 ILOAD(9)
0041 ALOAD(7)
0042 ILOAD(9)
0043 DALOAD
0044 DASTORE
0045 ALOAD(6)
0046 ILOAD(9)
0047 ICONST_1(Integer{1})
0048 IADD
0049 ALOAD(7)
0050 ILOAD(9)
0051 ICONST_1(Integer{1})
0052 IADD
0053 DALOAD
0054 DASTORE
0055 ALOAD(6)
0056 ILOAD(9)
0057 ICONST_2(Integer{2})
0058 IADD
0059 ALOAD(7)
0060 ILOAD(9)
0061 ICONST_2(Integer{2})
0062 IADD
0063 DALOAD
0064 DASTORE
0065 ALOAD(6)
0066 ILOAD(9)
0067 ICONST_3(Integer{3})
0068 IADD
0069 ALOAD(7)
0070 ILOAD(9)
0071 ICONST_3(Integer{3})
0072 IADD
0073 DALOAD
0074 DASTORE
0075 IINC(9,4)
0076 ILOAD(9)
0077 ILOAD(3)
0078 IF_ICMPLT(39)
0079 IINC(5,1)
0080 ILOAD(5)
0081 ILOAD(2)
0082 IF_ICMPLT(15)
0083 RETURN