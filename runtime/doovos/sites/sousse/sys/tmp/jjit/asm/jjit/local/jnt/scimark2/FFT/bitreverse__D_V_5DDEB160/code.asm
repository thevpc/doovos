0000 ALOAD(0)
0001 ARRAYLENGTH
0002 ICONST_2(Integer{2})
0003 IDIV
0004 ISTORE(1)
0005 ILOAD(1)
0006 ICONST_1(Integer{1})
0007 ISUB
0008 ISTORE(2)
0009 ICONST_0(Integer{0})
0010 ISTORE(3)
0011 ICONST_0(Integer{0})
0012 ISTORE(4)
0013 GOTO(82)
0014 ILOAD(3)
0015 ICONST_1(Integer{1})
0016 ISHL
0017 ISTORE(5)
0018 ILOAD(4)
0019 ICONST_1(Integer{1})
0020 ISHL
0021 ISTORE(6)
0022 ILOAD(1)
0023 ICONST_1(Integer{1})
0024 ISHR
0025 ISTORE(7)
0026 ILOAD(3)
0027 ILOAD(4)
0028 IF_ICMPGE(74)
0029 ALOAD(0)
0030 ILOAD(5)
0031 DALOAD
0032 DSTORE(8)
0033 ALOAD(0)
0034 ILOAD(5)
0035 ICONST_1(Integer{1})
0036 IADD
0037 DALOAD
0038 DSTORE(10)
0039 ALOAD(0)
0040 ILOAD(5)
0041 ALOAD(0)
0042 ILOAD(6)
0043 DALOAD
0044 DASTORE
0045 ALOAD(0)
0046 ILOAD(5)
0047 ICONST_1(Integer{1})
0048 IADD
0049 ALOAD(0)
0050 ILOAD(6)
0051 ICONST_1(Integer{1})
0052 IADD
0053 DALOAD
0054 DASTORE
0055 ALOAD(0)
0056 ILOAD(6)
0057 DLOAD(8)
0058 DASTORE
0059 ALOAD(0)
0060 ILOAD(6)
0061 ICONST_1(Integer{1})
0062 IADD
0063 DLOAD(10)
0064 DASTORE
0065 GOTO(74)
0066 ILOAD(4)
0067 ILOAD(7)
0068 ISUB
0069 ISTORE(4)
0070 ILOAD(7)
0071 ICONST_1(Integer{1})
0072 ISHR
0073 ISTORE(7)
0074 ILOAD(7)
0075 ILOAD(4)
0076 IF_ICMPLE(66)
0077 ILOAD(4)
0078 ILOAD(7)
0079 IADD
0080 ISTORE(4)
0081 IINC(3,1)
0082 ILOAD(3)
0083 ILOAD(2)
0084 IF_ICMPLT(14)
0085 RETURN
