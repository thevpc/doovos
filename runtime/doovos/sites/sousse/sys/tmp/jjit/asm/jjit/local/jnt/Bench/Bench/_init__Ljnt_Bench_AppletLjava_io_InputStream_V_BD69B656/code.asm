0000 ALOAD(0)
0001 INVOKESPECIAL(java.lang.Object,<init>()V)
0002 ALOAD(0)
0003 LDC(8->"A BenchMark")
0004 PUTFIELD(jnt.Bench.Bench,name)
0005 ALOAD(0)
0006 ACONST_NULL
0007 PUTFIELD(jnt.Bench.Bench,targetClass)
0008 ALOAD(0)
0009 ACONST_NULL
0010 PUTFIELD(jnt.Bench.Bench,subemail)
0011 ALOAD(0)
0012 ACONST_NULL
0013 PUTFIELD(jnt.Bench.Bench,suburl)
0014 ALOAD(0)
0015 LDC(14->"Seconds")
0016 PUTFIELD(jnt.Bench.Bench,units)
0017 ALOAD(0)
0018 ICONST_0(Integer{0})
0019 PUTFIELD(jnt.Bench.Bench,decimals)
0020 ALOAD(0)
0021 ICONST_1(Integer{1})
0022 ANEWARRAY(18)
0023 PUTFIELD(jnt.Bench.Bench,segments)
0024 ALOAD(0)
0025 NEW(java.util.Vector)
0026 DUP
0027 INVOKESPECIAL(java.util.Vector,<init>()V)
0028 PUTFIELD(jnt.Bench.Bench,entries)
0029 ALOAD(0)
0030 ACONST_NULL
0031 PUTFIELD(jnt.Bench.Bench,applet)
0032 ALOAD(0)
0033 ICONST_1(Integer{1})
0034 PUTFIELD(jnt.Bench.Bench,ascending)
0035 ALOAD(0)
0036 ICONST_M1(Integer{-1})
0037 PUTFIELD(jnt.Bench.Bench,specpos)
0038 ALOAD(0)
0039 ICONST_0(Integer{0})
0040 PUTFIELD(jnt.Bench.Bench,timerAPIused)
0041 ALOAD(0)
0042 ALOAD(1)
0043 PUTFIELD(jnt.Bench.Bench,applet)
0044 ALOAD(0)
0045 ALOAD(2)
0046 INVOKEVIRTUAL(jnt.Bench.Bench,parseDescriptor(Ljava/io/InputStream;)V)
0047 RETURN
