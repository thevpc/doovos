0000 ALOAD(0)
0001 ARRAYLENGTH
0002 ISTORE(3)
0003 ALOAD(0)
0004 ICONST_0(Integer{0})
0005 AALOAD
0006 ARRAYLENGTH
0007 ISTORE(4)
0008 ICONST_0(Integer{0})
0009 ISTORE(5)
0010 ICONST_0(Integer{0})
0011 ISTORE(6)
0012 GOTO(60)
0013 ALOAD(1)
0014 ILOAD(6)
0015 IALOAD
0016 ISTORE(7)
0017 ALOAD(2)
0018 ILOAD(7)
0019 DALOAD
0020 DSTORE(8)
0021 ALOAD(2)
0022 ILOAD(7)
0023 ALOAD(2)
0024 ILOAD(6)
0025 DALOAD
0026 DASTORE
0027 ILOAD(5)
0028 IFNE(49)
0029 ILOAD(5)
0030 ISTORE(10)
0031 GOTO(45)
0032 DLOAD(8)
0033 ALOAD(0)
0034 ILOAD(6)
0035 AALOAD
0036 ILOAD(10)
0037 DALOAD
0038 ALOAD(2)
0039 ILOAD(10)
0040 DALOAD
0041 DMUL
0042 DSUB
0043 DSTORE(8)
0044 IINC(10,1)
0045 ILOAD(10)
0046 ILOAD(6)
0047 IF_ICMPLT(32)
0048 GOTO(55)
0049 DLOAD(8)
0050 DCONST_0(Double{0.0})
0051 DCMPL
0052 IFNE(55)
0053 ILOAD(6)
0054 ISTORE(5)
0055 ALOAD(2)
0056 ILOAD(6)
0057 DLOAD(8)
0058 DASTORE
0059 IINC(6,1)
0060 ILOAD(6)
0061 ILOAD(3)
0062 IF_ICMPLT(13)
0063 ILOAD(4)
0064 ICONST_1(Integer{1})
0065 ISUB
0066 ISTORE(7)
0067 GOTO(104)
0068 ALOAD(2)
0069 ILOAD(7)
0070 DALOAD
0071 DSTORE(8)
0072 ILOAD(7)
0073 ICONST_1(Integer{1})
0074 IADD
0075 ISTORE(10)
0076 GOTO(90)
0077 DLOAD(8)
0078 ALOAD(0)
0079 ILOAD(7)
0080 AALOAD
0081 ILOAD(10)
0082 DALOAD
0083 ALOAD(2)
0084 ILOAD(10)
0085 DALOAD
0086 DMUL
0087 DSUB
0088 DSTORE(8)
0089 IINC(10,1)
0090 ILOAD(10)
0091 ILOAD(4)
0092 IF_ICMPLT(77)
0093 ALOAD(2)
0094 ILOAD(7)
0095 DLOAD(8)
0096 ALOAD(0)
0097 ILOAD(7)
0098 AALOAD
0099 ILOAD(7)
0100 DALOAD
0101 DDIV
0102 DASTORE
0103 IINC(7,-1)
0104 ILOAD(7)
0105 IFGE(68)
0106 RETURN