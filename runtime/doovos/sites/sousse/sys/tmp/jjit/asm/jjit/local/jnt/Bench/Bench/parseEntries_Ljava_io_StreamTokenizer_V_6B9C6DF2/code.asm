0000 ALOAD(0)
0001 INVOKEVIRTUAL(jnt.Bench.Bench,checkDefaultSegment()V)
0002 DCONST_0(Double{0.0})
0003 DSTORE(2)
0004 ALOAD(0)
0005 ALOAD(1)
0006 BIPUSH(40)
0007 INVOKEVIRTUAL(jnt.Bench.Bench,getPunct(Ljava/io/StreamTokenizer;C)V)
0008 ICONST_0(Integer{0})
0009 ISTORE(4)
0010 GOTO(68)
0011 ALOAD(0)
0012 GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;)
0013 ARRAYLENGTH
0014 NEWARRAY
0015 ASTORE(5)
0016 ALOAD(0)
0017 GETFIELD(jnt.Bench.Bench,entries,Ljava/util/Vector;)
0018 NEW(jnt.Bench.Entry)
0019 DUP
0020 ALOAD(0)
0021 ALOAD(1)
0022 LDC(69->"Entry Name")
0023 INVOKEVIRTUAL(jnt.Bench.Bench,parseString(Ljava/io/StreamTokenizer;Ljava/lang/String;)Ljava/lang/String;)
0024 ALOAD(5)
0025 INVOKESPECIAL(jnt.Bench.Entry,<init>(Ljava/lang/String;[D)V)
0026 INVOKEVIRTUAL(java.util.Vector,addElement(Ljava/lang/Object;)V)
0027 ICONST_0(Integer{0})
0028 ISTORE(6)
0029 GOTO(38)
0030 ALOAD(5)
0031 ILOAD(6)
0032 ALOAD(0)
0033 ALOAD(1)
0034 LDC(71->"Segment Value")
0035 INVOKEVIRTUAL(jnt.Bench.Bench,parseNumber(Ljava/io/StreamTokenizer;Ljava/lang/String;)D)
0036 DASTORE
0037 IINC(6,1)
0038 ILOAD(6)
0039 ALOAD(0)
0040 GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;)
0041 ARRAYLENGTH
0042 IF_ICMPLT(30)
0043 ILOAD(4)
0044 IFLE(59)
0045 ALOAD(0)
0046 ALOAD(0)
0047 GETFIELD(jnt.Bench.Bench,ascending,Z)
0048 IFEQ(57)
0049 DLOAD(2)
0050 ALOAD(5)
0051 ICONST_0(Integer{0})
0052 DALOAD
0053 DCMPG
0054 IFGE(57)
0055 ICONST_1(Integer{1})
0056 GOTO(58)
0057 ICONST_0(Integer{0})
0058 PUTFIELD(jnt.Bench.Bench,ascending)
0059 ALOAD(5)
0060 ICONST_0(Integer{0})
0061 DALOAD
0062 DSTORE(2)
0063 ALOAD(0)
0064 ALOAD(1)
0065 BIPUSH(41)
0066 INVOKEVIRTUAL(jnt.Bench.Bench,getPunct(Ljava/io/StreamTokenizer;C)V)
0067 IINC(4,1)
0068 ALOAD(1)
0069 INVOKEVIRTUAL(java.io.StreamTokenizer,nextToken()I)
0070 BIPUSH(40)
0071 IF_ICMPEQ(11)
0072 ALOAD(1)
0073 INVOKEVIRTUAL(java.io.StreamTokenizer,pushBack()V)
0074 ALOAD(0)
0075 ALOAD(1)
0076 BIPUSH(41)
0077 INVOKEVIRTUAL(jnt.Bench.Bench,getPunct(Ljava/io/StreamTokenizer;C)V)
0078 RETURN
