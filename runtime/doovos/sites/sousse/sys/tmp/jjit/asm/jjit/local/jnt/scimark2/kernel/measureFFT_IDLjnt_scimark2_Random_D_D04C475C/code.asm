0000 ICONST_2(Integer{2})
0001 ILOAD(0)
0002 IMUL
0003 ALOAD(3)
0004 INVOKESTATIC(jnt.scimark2.kernel,RandomVector(ILjnt/scimark2/Random;)[D)
0005 ASTORE(4)
0006 ALOAD(4)
0007 INVOKESTATIC(jnt.scimark2.kernel,NewVectorCopy([D)[D)
0008 ASTORE(5)
0009 LCONST_1(Long{1})
0010 LSTORE(6)
0011 NEW(jnt.scimark2.Stopwatch)
0012 DUP
0013 INVOKESPECIAL(jnt.scimark2.Stopwatch,<init>()V)
0014 ASTORE(8)
0015 GOTO(16)
0016 ALOAD(8)
0017 INVOKEVIRTUAL(jnt.scimark2.Stopwatch,start()V)
0018 ICONST_0(Integer{0})
0019 ISTORE(9)
0020 GOTO(26)
0021 ALOAD(4)
0022 INVOKESTATIC(jnt.scimark2.FFT,transform([D)V)
0023 ALOAD(4)
0024 INVOKESTATIC(jnt.scimark2.FFT,inverse([D)V)
0025 IINC(9,1)
0026 ILOAD(9)
0027 I2L
0028 LLOAD(6)
0029 LCMP
0030 IFLT(21)
0031 ALOAD(8)
0032 INVOKEVIRTUAL(jnt.scimark2.Stopwatch,stop()D)
0033 POP2
0034 ALOAD(8)
0035 INVOKEVIRTUAL(jnt.scimark2.Stopwatch,read()D)
0036 DLOAD(1)
0037 DCMPL
0038 IFLT(40)
0039 GOTO(45)
0040 LLOAD(6)
0041 LDC(12->"2")
0042 LMUL
0043 LSTORE(6)
0044 GOTO(16)
0045 ALOAD(4)
0046 INVOKESTATIC(jnt.scimark2.FFT,test([D)D)
0047 ILOAD(0)
0048 I2D
0049 DDIV
0050 LDC(14->"1.0E-10")
0051 DCMPL
0052 IFLE(55)
0053 DCONST_0(Double{0.0})
0054 DRETURN
0055 ILOAD(0)
0056 INVOKESTATIC(jnt.scimark2.FFT,num_flops(I)D)
0057 LLOAD(6)
0058 L2D
0059 DMUL
0060 ALOAD(8)
0061 INVOKEVIRTUAL(jnt.scimark2.Stopwatch,read()D)
0062 DDIV
0063 LDC(16->"1.0E-6")
0064 DMUL
0065 DRETURN
