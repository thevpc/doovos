0000 NEW(java.net.URL)
0001 DUP
0002 ALOAD(0)
0003 INVOKESPECIAL(java.net.URL,<init>(Ljava/lang/String;)V)
0004 ASTORE(2)
0005 ALOAD(2)
0006 INVOKEVIRTUAL(java.net.URL,getPort()I)
0007 ISTORE(3)
0008 ILOAD(3)
0009 IFGE(12)
0010 BIPUSH(80)
0011 ISTORE(3)
0012 NEW(java.net.Socket)
0013 DUP
0014 ALOAD(2)
0015 INVOKEVIRTUAL(java.net.URL,getHost()Ljava/lang/String;)
0016 ILOAD(3)
0017 ICONST_1(Integer{1})
0018 INVOKESPECIAL(java.net.Socket,<init>(Ljava/lang/String;IZ)V)
0019 ASTORE(4)
0020 NEW(java.io.PrintStream)
0021 DUP
0022 ALOAD(4)
0023 INVOKEVIRTUAL(java.net.Socket,getOutputStream()Ljava/io/OutputStream;)
0024 INVOKESPECIAL(java.io.PrintStream,<init>(Ljava/io/OutputStream;)V)
0025 ASTORE(5)
0026 NEW(java.io.DataInputStream)
0027 DUP
0028 ALOAD(4)
0029 INVOKEVIRTUAL(java.net.Socket,getInputStream()Ljava/io/InputStream;)
0030 INVOKESPECIAL(java.io.DataInputStream,<init>(Ljava/io/InputStream;)V)
0031 ASTORE(6)
0032 ALOAD(5)
0033 NEW(java.lang.StringBuffer)
0034 DUP
0035 INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
0036 LDC(15->"POST ")
0037 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0038 ALOAD(2)
0039 INVOKEVIRTUAL(java.net.URL,getFile()Ljava/lang/String;)
0040 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0041 LDC(18->" HTTP/1.0")
0042 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0043 INVOKEVIRTUAL(java.lang.StringBuffer,toString()Ljava/lang/String;)
0044 INVOKEVIRTUAL(java.io.PrintStream,println(Ljava/lang/String;)V)
0045 ALOAD(5)
0046 NEW(java.lang.StringBuffer)
0047 DUP
0048 INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
0049 LDC(21->"Content-Length: ")
0050 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0051 ALOAD(1)
0052 INVOKEVIRTUAL(java.lang.String,length()I)
0053 INVOKEVIRTUAL(java.lang.StringBuffer,append(I)Ljava/lang/StringBuffer;)
0054 INVOKEVIRTUAL(java.lang.StringBuffer,toString()Ljava/lang/String;)
0055 INVOKEVIRTUAL(java.io.PrintStream,println(Ljava/lang/String;)V)
0056 ALOAD(5)
0057 INVOKEVIRTUAL(java.io.PrintStream,println()V)
0058 ALOAD(5)
0059 ALOAD(1)
0060 INVOKEVIRTUAL(java.io.PrintStream,print(Ljava/lang/String;)V)
0061 ALOAD(6)
0062 INVOKEVIRTUAL(java.io.DataInputStream,readLine()Ljava/lang/String;)
0063 ASTORE(7)
0064 ALOAD(7)
0065 BIPUSH(32)
0066 INVOKEVIRTUAL(java.lang.String,indexOf(I)I)
0067 ICONST_1(Integer{1})
0068 IADD
0069 ISTORE(8)
0070 ALOAD(7)
0071 BIPUSH(32)
0072 ILOAD(8)
0073 INVOKEVIRTUAL(java.lang.String,indexOf(II)I)
0074 ISTORE(9)
0075 ALOAD(7)
0076 ILOAD(8)
0077 ILOAD(9)
0078 INVOKEVIRTUAL(java.lang.String,substring(II)Ljava/lang/String;)
0079 INVOKEVIRTUAL(java.lang.String,trim()Ljava/lang/String;)
0080 INVOKESTATIC(java.lang.Integer,parseInt(Ljava/lang/String;)I)
0081 ISTORE(10)
0082 ILOAD(10)
0083 BIPUSH(100)
0084 IF_ICMPEQ(90)
0085 NEW(java.net.ProtocolException)
0086 DUP
0087 ALOAD(7)
0088 INVOKESPECIAL(java.net.ProtocolException,<init>(Ljava/lang/String;)V)
0089 ATHROW
0090 ALOAD(5)
0091 INVOKEVIRTUAL(java.io.PrintStream,close()V)
0092 ALOAD(4)
0093 INVOKEVIRTUAL(java.net.Socket,close()V)
0094 RETURN
