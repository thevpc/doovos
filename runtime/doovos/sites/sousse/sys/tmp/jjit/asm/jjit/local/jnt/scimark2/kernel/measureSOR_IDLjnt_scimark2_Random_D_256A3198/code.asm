0000 ILOAD(0)
0001 ILOAD(0)
0002 ALOAD(3)
0003 INVOKESTATIC(jnt.scimark2.kernel,RandomMatrix(IILjnt/scimark2/Random;)[[D)
0004 ASTORE(4)
0005 NEW(jnt.scimark2.Stopwatch)
0006 DUP
0007 INVOKESPECIAL(jnt.scimark2.Stopwatch,<init>()V)
0008 ASTORE(5)
0009 ICONST_1(Integer{1})
0010 ISTORE(6)
0011 GOTO(12)
0012 ALOAD(5)
0013 INVOKEVIRTUAL(jnt.scimark2.Stopwatch,start()V)
0014 LDC(18->"1.25")
0015 ALOAD(4)
0016 ILOAD(6)
0017 INVOKESTATIC(jnt.scimark2.SOR,execute(D[[DI)V)
0018 ALOAD(5)
0019 INVOKEVIRTUAL(jnt.scimark2.Stopwatch,stop()D)
0020 POP2
0021 ALOAD(5)
0022 INVOKEVIRTUAL(jnt.scimark2.Stopwatch,read()D)
0023 DLOAD(1)
0024 DCMPL
0025 IFLT(27)
0026 GOTO(32)
0027 ILOAD(6)
0028 ICONST_2(Integer{2})
0029 IMUL
0030 ISTORE(6)
0031 GOTO(12)
0032 ILOAD(0)
0033 ILOAD(0)
0034 ILOAD(6)
0035 INVOKESTATIC(jnt.scimark2.SOR,num_flops(III)D)
0036 ALOAD(5)
0037 INVOKEVIRTUAL(jnt.scimark2.Stopwatch,read()D)
0038 DDIV
0039 LDC(16->"1.0E-6")
0040 DMUL
0041 DRETURN