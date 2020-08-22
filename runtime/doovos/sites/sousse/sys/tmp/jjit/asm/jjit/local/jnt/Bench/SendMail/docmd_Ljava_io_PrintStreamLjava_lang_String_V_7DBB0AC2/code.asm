0000 ALOAD(1)
0001 INVOKEVIRTUAL(java.lang.String,trim()Ljava/lang/String;)
0002 ASTORE(1)
0003 ALOAD(0)
0004 NEW(java.lang.StringBuffer)
0005 DUP
0006 INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
0007 ALOAD(1)
0008 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0009 LDC(35->"
")
0010 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0011 INVOKEVIRTUAL(java.lang.StringBuffer,toString()Ljava/lang/String;)
0012 INVOKEVIRTUAL(java.io.PrintStream,print(Ljava/lang/String;)V)
0013 RETURN
