0000 NEW(java.io.StreamTokenizer)
0001 DUP
0002 ALOAD(1)
0003 INVOKESPECIAL(java.io.StreamTokenizer,<init>(Ljava/io/InputStream;)V)
0004 ASTORE(2)
0005 ALOAD(2)
0006 BIPUSH(35)
0007 INVOKEVIRTUAL(java.io.StreamTokenizer,commentChar(I)V)
0008 ALOAD(2)
0009 BIPUSH(34)
0010 INVOKEVIRTUAL(java.io.StreamTokenizer,quoteChar(I)V)
0011 ALOAD(2)
0012 BIPUSH(95)
0013 BIPUSH(95)
0014 INVOKEVIRTUAL(java.io.StreamTokenizer,wordChars(II)V)
0015 ALOAD(2)
0016 BIPUSH(44)
0017 BIPUSH(44)
0018 INVOKEVIRTUAL(java.io.StreamTokenizer,whitespaceChars(II)V)
0019 ALOAD(2)
0020 BIPUSH(59)
0021 BIPUSH(59)
0022 INVOKEVIRTUAL(java.io.StreamTokenizer,whitespaceChars(II)V)
0023 ALOAD(2)
0024 INVOKEVIRTUAL(java.io.StreamTokenizer,parseNumbers()V)
0025 GOTO(128)
0026 ALOAD(2)
0027 GETFIELD(java.io.StreamTokenizer,sval,Ljava/lang/String;)
0028 ASTORE(3)
0029 ALOAD(0)
0030 ALOAD(2)
0031 BIPUSH(61)
0032 INVOKEVIRTUAL(jnt.Bench.Bench,getPunct(Ljava/io/StreamTokenizer;C)V)
0033 ALOAD(3)
0034 LDC(9->"name")
0035 INVOKEVIRTUAL(java.lang.String,equals(Ljava/lang/Object;)Z)
0036 IFEQ(44)
0037 ALOAD(0)
0038 ALOAD(0)
0039 ALOAD(2)
0040 LDC(9->"name")
0041 INVOKEVIRTUAL(jnt.Bench.Bench,parseString(Ljava/io/StreamTokenizer;Ljava/lang/String;)Ljava/lang/String;)
0042 PUTFIELD(jnt.Bench.Bench,name)
0043 GOTO(128)
0044 ALOAD(3)
0045 LDC(43->"target")
0046 INVOKEVIRTUAL(java.lang.String,equals(Ljava/lang/Object;)Z)
0047 IFEQ(55)
0048 ALOAD(0)
0049 ALOAD(0)
0050 ALOAD(2)
0051 LDC(43->"target")
0052 INVOKEVIRTUAL(jnt.Bench.Bench,parseString(Ljava/io/StreamTokenizer;Ljava/lang/String;)Ljava/lang/String;)
0053 PUTFIELD(jnt.Bench.Bench,targetClass)
0054 GOTO(128)
0055 ALOAD(3)
0056 LDC(44->"submission_email")
0057 INVOKEVIRTUAL(java.lang.String,equals(Ljava/lang/Object;)Z)
0058 IFEQ(66)
0059 ALOAD(0)
0060 ALOAD(0)
0061 ALOAD(2)
0062 LDC(44->"submission_email")
0063 INVOKEVIRTUAL(jnt.Bench.Bench,parseString(Ljava/io/StreamTokenizer;Ljava/lang/String;)Ljava/lang/String;)
0064 PUTFIELD(jnt.Bench.Bench,subemail)
0065 GOTO(128)
0066 ALOAD(3)
0067 LDC(45->"submission_url")
0068 INVOKEVIRTUAL(java.lang.String,equals(Ljava/lang/Object;)Z)
0069 IFEQ(77)
0070 ALOAD(0)
0071 ALOAD(0)
0072 ALOAD(2)
0073 LDC(45->"submission_url")
0074 INVOKEVIRTUAL(jnt.Bench.Bench,parseString(Ljava/io/StreamTokenizer;Ljava/lang/String;)Ljava/lang/String;)
0075 PUTFIELD(jnt.Bench.Bench,suburl)
0076 GOTO(128)
0077 ALOAD(3)
0078 LDC(15->"units")
0079 INVOKEVIRTUAL(java.lang.String,equals(Ljava/lang/Object;)Z)
0080 IFEQ(88)
0081 ALOAD(0)
0082 ALOAD(0)
0083 ALOAD(2)
0084 LDC(15->"units")
0085 INVOKEVIRTUAL(jnt.Bench.Bench,parseString(Ljava/io/StreamTokenizer;Ljava/lang/String;)Ljava/lang/String;)
0086 PUTFIELD(jnt.Bench.Bench,units)
0087 GOTO(128)
0088 ALOAD(3)
0089 LDC(16->"decimals")
0090 INVOKEVIRTUAL(java.lang.String,equals(Ljava/lang/Object;)Z)
0091 IFEQ(100)
0092 ALOAD(0)
0093 ALOAD(0)
0094 ALOAD(2)
0095 LDC(16->"decimals")
0096 INVOKEVIRTUAL(jnt.Bench.Bench,parseNumber(Ljava/io/StreamTokenizer;Ljava/lang/String;)D)
0097 D2I
0098 PUTFIELD(jnt.Bench.Bench,decimals)
0099 GOTO(128)
0100 ALOAD(3)
0101 LDC(19->"segments")
0102 INVOKEVIRTUAL(java.lang.String,equals(Ljava/lang/Object;)Z)
0103 IFEQ(108)
0104 ALOAD(0)
0105 ALOAD(2)
0106 INVOKEVIRTUAL(jnt.Bench.Bench,parseSegments(Ljava/io/StreamTokenizer;)V)
0107 GOTO(128)
0108 ALOAD(3)
0109 LDC(22->"entries")
0110 INVOKEVIRTUAL(java.lang.String,equals(Ljava/lang/Object;)Z)
0111 IFEQ(116)
0112 ALOAD(0)
0113 ALOAD(2)
0114 INVOKEVIRTUAL(jnt.Bench.Bench,parseEntries(Ljava/io/StreamTokenizer;)V)
0115 GOTO(128)
0116 NEW(java.io.IOException)
0117 DUP
0118 NEW(java.lang.StringBuffer)
0119 DUP
0120 INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
0121 LDC(51->"Unknown parameter ")
0122 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0123 ALOAD(3)
0124 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0125 INVOKEVIRTUAL(java.lang.StringBuffer,toString()Ljava/lang/String;)
0126 INVOKESPECIAL(java.io.IOException,<init>(Ljava/lang/String;)V)
0127 ATHROW
0128 ALOAD(2)
0129 INVOKEVIRTUAL(java.io.StreamTokenizer,nextToken()I)
0130 BIPUSH(-3)
0131 IF_ICMPEQ(26)
0132 ALOAD(0)
0133 INVOKEVIRTUAL(jnt.Bench.Bench,checkDefaultSegment()V)
0134 RETURN
