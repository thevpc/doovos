0000 BIPUSH(6)
0001 NEWARRAY
0002 ASTORE(2)
0003 NEW(jnt.scimark2.Random)
0004 DUP
0005 LDC(3->"101010")
0006 INVOKESPECIAL(jnt.scimark2.Random,<init>(I)V)
0007 ASTORE(3)
0008 LDC(5->"2.0")
0009 DSTORE(4)
0010 LDC(6->"1.0E-5")
0011 DSTORE(6)
0012 ALOAD(1)
0013 LDC(7->"Downloading FFT")
0014 INVOKEVIRTUAL(jnt.Bench.Bench,noteStatus(Ljava/lang/String;)V)
0015 ALOAD(2)
0016 ICONST_1(Integer{1})
0017 BIPUSH(16)
0018 DLOAD(6)
0019 ALOAD(3)
0020 INVOKESTATIC(jnt.scimark2.kernel,measureFFT(IDLjnt/scimark2/Random;)D)
0021 DASTORE
0022 INVOKESTATIC(java.lang.Thread,yield()V)
0023 ALOAD(1)
0024 LDC(14->"Downloading SOR")
0025 INVOKEVIRTUAL(jnt.Bench.Bench,noteStatus(Ljava/lang/String;)V)
0026 ALOAD(2)
0027 ICONST_2(Integer{2})
0028 BIPUSH(10)
0029 DLOAD(6)
0030 ALOAD(3)
0031 INVOKESTATIC(jnt.scimark2.kernel,measureSOR(IDLjnt/scimark2/Random;)D)
0032 DASTORE
0033 INVOKESTATIC(java.lang.Thread,yield()V)
0034 ALOAD(1)
0035 LDC(16->"Downloading Monte Carlo")
0036 INVOKEVIRTUAL(jnt.Bench.Bench,noteStatus(Ljava/lang/String;)V)
0037 ALOAD(2)
0038 ICONST_3(Integer{3})
0039 DLOAD(6)
0040 ALOAD(3)
0041 INVOKESTATIC(jnt.scimark2.kernel,measureMonteCarlo(DLjnt/scimark2/Random;)D)
0042 DASTORE
0043 INVOKESTATIC(java.lang.Thread,yield()V)
0044 ALOAD(1)
0045 LDC(18->"Downloading Sparse Matrix Multplication")
0046 INVOKEVIRTUAL(jnt.Bench.Bench,noteStatus(Ljava/lang/String;)V)
0047 ALOAD(2)
0048 ICONST_4(Integer{4})
0049 BIPUSH(10)
0050 BIPUSH(50)
0051 DLOAD(6)
0052 ALOAD(3)
0053 INVOKESTATIC(jnt.scimark2.kernel,measureSparseMatmult(IIDLjnt/scimark2/Random;)D)
0054 DASTORE
0055 INVOKESTATIC(java.lang.Thread,yield()V)
0056 ALOAD(1)
0057 LDC(20->"Downloading LU factorization")
0058 INVOKEVIRTUAL(jnt.Bench.Bench,noteStatus(Ljava/lang/String;)V)
0059 ALOAD(2)
0060 ICONST_5(Integer{5})
0061 BIPUSH(10)
0062 DLOAD(6)
0063 ALOAD(3)
0064 INVOKESTATIC(jnt.scimark2.kernel,measureLU(IDLjnt/scimark2/Random;)D)
0065 DASTORE
0066 INVOKESTATIC(java.lang.Thread,yield()V)
0067 ALOAD(1)
0068 LDC(22->"benchmarking FFT")
0069 INVOKEVIRTUAL(jnt.Bench.Bench,noteStatus(Ljava/lang/String;)V)
0070 ALOAD(2)
0071 ICONST_1(Integer{1})
0072 SIPUSH(Integer{1024})
0073 DLOAD(4)
0074 ALOAD(3)
0075 INVOKESTATIC(jnt.scimark2.kernel,measureFFT(IDLjnt/scimark2/Random;)D)
0076 DASTORE
0077 ALOAD(1)
0078 LDC(23->"benchmarking SOR")
0079 INVOKEVIRTUAL(jnt.Bench.Bench,noteStatus(Ljava/lang/String;)V)
0080 ALOAD(2)
0081 ICONST_2(Integer{2})
0082 BIPUSH(100)
0083 DLOAD(4)
0084 ALOAD(3)
0085 INVOKESTATIC(jnt.scimark2.kernel,measureSOR(IDLjnt/scimark2/Random;)D)
0086 DASTORE
0087 ALOAD(1)
0088 LDC(24->"benchmarking Monte Carlo")
0089 INVOKEVIRTUAL(jnt.Bench.Bench,noteStatus(Ljava/lang/String;)V)
0090 ALOAD(2)
0091 ICONST_3(Integer{3})
0092 DLOAD(4)
0093 ALOAD(3)
0094 INVOKESTATIC(jnt.scimark2.kernel,measureMonteCarlo(DLjnt/scimark2/Random;)D)
0095 DASTORE
0096 ALOAD(1)
0097 LDC(25->"benchmarking Sparse Matrix Multplication")
0098 INVOKEVIRTUAL(jnt.Bench.Bench,noteStatus(Ljava/lang/String;)V)
0099 ALOAD(2)
0100 ICONST_4(Integer{4})
0101 SIPUSH(Integer{1000})
0102 SIPUSH(Integer{5000})
0103 DLOAD(4)
0104 ALOAD(3)
0105 INVOKESTATIC(jnt.scimark2.kernel,measureSparseMatmult(IIDLjnt/scimark2/Random;)D)
0106 DASTORE
0107 ALOAD(1)
0108 LDC(26->"benchmarking LU factorization")
0109 INVOKEVIRTUAL(jnt.Bench.Bench,noteStatus(Ljava/lang/String;)V)
0110 ALOAD(2)
0111 ICONST_5(Integer{5})
0112 BIPUSH(100)
0113 DLOAD(4)
0114 ALOAD(3)
0115 INVOKESTATIC(jnt.scimark2.kernel,measureLU(IDLjnt/scimark2/Random;)D)
0116 DASTORE
0117 ALOAD(2)
0118 ICONST_0(Integer{0})
0119 ALOAD(2)
0120 ICONST_1(Integer{1})
0121 DALOAD
0122 ALOAD(2)
0123 ICONST_2(Integer{2})
0124 DALOAD
0125 DADD
0126 ALOAD(2)
0127 ICONST_3(Integer{3})
0128 DALOAD
0129 DADD
0130 ALOAD(2)
0131 ICONST_4(Integer{4})
0132 DALOAD
0133 DADD
0134 ALOAD(2)
0135 ICONST_5(Integer{5})
0136 DALOAD
0137 DADD
0138 LDC(27->"5.0")
0139 DDIV
0140 DASTORE
0141 ALOAD(2)
0142 ICONST_1(Integer{1})
0143 DALOAD
0144 DCONST_0(Double{0.0})
0145 DCMPL
0146 IFEQ(153)
0147 ALOAD(2)
0148 ICONST_5(Integer{5})
0149 DALOAD
0150 DCONST_0(Double{0.0})
0151 DCMPL
0152 IFNE(177)
0153 ALOAD(2)
0154 ICONST_0(Integer{0})
0155 ALOAD(2)
0156 ICONST_1(Integer{1})
0157 ALOAD(2)
0158 ICONST_2(Integer{2})
0159 ALOAD(2)
0160 ICONST_3(Integer{3})
0161 ALOAD(2)
0162 ICONST_4(Integer{4})
0163 ALOAD(2)
0164 ICONST_5(Integer{5})
0165 DCONST_0(Double{0.0})
0166 DUP2_X2
0167 DASTORE
0168 DUP2_X2
0169 DASTORE
0170 DUP2_X2
0171 DASTORE
0172 DUP2_X2
0173 DASTORE
0174 DUP2_X2
0175 DASTORE
0176 DASTORE
0177 ALOAD(2)
0178 ARETURN
