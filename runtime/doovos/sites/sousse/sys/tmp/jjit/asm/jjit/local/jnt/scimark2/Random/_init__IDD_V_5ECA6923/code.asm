0000 ALOAD(0)
0001 INVOKESPECIAL(java.lang.Object,<init>()V)
0002 ALOAD(0)
0003 ICONST_0(Integer{0})
0004 PUTFIELD(jnt.scimark2.Random,seed)
0005 ALOAD(0)
0006 ICONST_4(Integer{4})
0007 PUTFIELD(jnt.scimark2.Random,i)
0008 ALOAD(0)
0009 BIPUSH(16)
0010 PUTFIELD(jnt.scimark2.Random,j)
0011 ALOAD(0)
0012 BIPUSH(32)
0013 PUTFIELD(jnt.scimark2.Random,mdig)
0014 ALOAD(0)
0015 ICONST_1(Integer{1})
0016 PUTFIELD(jnt.scimark2.Random,one)
0017 ALOAD(0)
0018 LDC(9->"2147483647")
0019 PUTFIELD(jnt.scimark2.Random,m1)
0020 ALOAD(0)
0021 LDC(11->"65536")
0022 PUTFIELD(jnt.scimark2.Random,m2)
0023 ALOAD(0)
0024 LDC(13->"4.656612875245797E-10")
0025 PUTFIELD(jnt.scimark2.Random,dm1)
0026 ALOAD(0)
0027 ICONST_0(Integer{0})
0028 PUTFIELD(jnt.scimark2.Random,haveRange)
0029 ALOAD(0)
0030 DCONST_0(Double{0.0})
0031 PUTFIELD(jnt.scimark2.Random,left)
0032 ALOAD(0)
0033 DCONST_1(Double{1.0})
0034 PUTFIELD(jnt.scimark2.Random,right)
0035 ALOAD(0)
0036 DCONST_1(Double{1.0})
0037 PUTFIELD(jnt.scimark2.Random,width)
0038 ALOAD(0)
0039 ILOAD(1)
0040 INVOKESPECIAL(jnt.scimark2.Random,initialize(I)V)
0041 ALOAD(0)
0042 DLOAD(2)
0043 PUTFIELD(jnt.scimark2.Random,left)
0044 ALOAD(0)
0045 DLOAD(4)
0046 PUTFIELD(jnt.scimark2.Random,right)
0047 ALOAD(0)
0048 DLOAD(4)
0049 DLOAD(2)
0050 DSUB
0051 PUTFIELD(jnt.scimark2.Random,width)
0052 ALOAD(0)
0053 ICONST_1(Integer{1})
0054 PUTFIELD(jnt.scimark2.Random,haveRange)
0055 RETURN
