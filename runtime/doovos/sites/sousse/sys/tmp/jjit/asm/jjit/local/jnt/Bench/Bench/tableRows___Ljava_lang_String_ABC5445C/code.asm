0000 ICONST_2(Integer{2})
0001 ANEWARRAY(40)
0002 ASTORE(1)
0003 ALOAD(1)
0004 ICONST_0(Integer{0})
0005 ALOAD(1)
0006 ICONST_1(Integer{1})
0007 LDC(57->"")
0008 DUP_X2
0009 AASTORE
0010 AASTORE
0011 ALOAD(1)
0012 ALOAD(0)
0013 INVOKEVIRTUAL(jnt.Bench.Bench,getEntries()[Ljava/lang/String;)
0014 INVOKESTATIC(jnt.Bench.Formatter,conc([Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;)
0015 ASTORE(2)
0016 ICONST_0(Integer{0})
0017 ISTORE(3)
0018 GOTO(50)
0019 ALOAD(1)
0020 ICONST_0(Integer{0})
0021 ALOAD(0)
0022 GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;)
0023 ILOAD(3)
0024 AALOAD
0025 GETFIELD(jnt.Bench.Segment,shortname,Ljava/lang/String;)
0026 AASTORE
0027 ALOAD(1)
0028 ICONST_1(Integer{1})
0029 ALOAD(0)
0030 GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;)
0031 ILOAD(3)
0032 AALOAD
0033 GETFIELD(jnt.Bench.Segment,units,Ljava/lang/String;)
0034 AASTORE
0035 ALOAD(2)
0036 ALOAD(1)
0037 ALOAD(0)
0038 ILOAD(3)
0039 INVOKEVIRTUAL(jnt.Bench.Bench,getSegmentValues(I)[D)
0040 ALOAD(0)
0041 GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;)
0042 ILOAD(3)
0043 AALOAD
0044 GETFIELD(jnt.Bench.Segment,decimals,I)
0045 INVOKESTATIC(jnt.Bench.Formatter,format([DI)[Ljava/lang/String;)
0046 INVOKESTATIC(jnt.Bench.Formatter,conc([Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;)
0047 ICONST_1(Integer{1})
0048 INVOKESTATIC(jnt.Bench.Formatter,addColumn([Ljava/lang/String;[Ljava/lang/String;I)V)
0049 IINC(3,1)
0050 ILOAD(3)
0051 ALOAD(0)
0052 GETFIELD(jnt.Bench.Bench,segments,[Ljnt/Bench/Segment;)
0053 ARRAYLENGTH
0054 IF_ICMPLT(19)
0055 ALOAD(2)
0056 ARETURN
