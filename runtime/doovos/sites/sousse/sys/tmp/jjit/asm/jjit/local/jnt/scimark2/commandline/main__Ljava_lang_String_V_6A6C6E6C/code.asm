0000 LDC(2->"2.0")
0001 DSTORE(1)
0002 SIPUSH(Integer{1024})
0003 ISTORE(3)
0004 BIPUSH(100)
0005 ISTORE(4)
0006 SIPUSH(Integer{1000})
0007 ISTORE(5)
0008 SIPUSH(Integer{5000})
0009 ISTORE(6)
0010 BIPUSH(100)
0011 ISTORE(7)
0012 ALOAD(0)
0013 ARRAYLENGTH
0014 IFLE(60)
0015 ALOAD(0)
0016 ICONST_0(Integer{0})
0017 AALOAD
0018 LDC(3->"-h")
0019 INVOKEVIRTUAL(java.lang.String,equalsIgnoreCase(Ljava/lang/String;)Z)
0020 IFNE(27)
0021 ALOAD(0)
0022 ICONST_0(Integer{0})
0023 AALOAD
0024 LDC(6->"-help")
0025 INVOKEVIRTUAL(java.lang.String,equalsIgnoreCase(Ljava/lang/String;)Z)
0026 IFEQ(31)
0027 GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
0028 LDC(10->"Usage: [-large] [minimum_time]")
0029 INVOKEVIRTUAL(java.io.PrintStream,println(Ljava/lang/String;)V)
0030 RETURN
0031 ICONST_0(Integer{0})
0032 ISTORE(8)
0033 ALOAD(0)
0034 ILOAD(8)
0035 AALOAD
0036 LDC(13->"-large")
0037 INVOKEVIRTUAL(java.lang.String,equalsIgnoreCase(Ljava/lang/String;)Z)
0038 IFEQ(50)
0039 LDC(14->"1048576")
0040 ISTORE(3)
0041 SIPUSH(Integer{1000})
0042 ISTORE(4)
0043 LDC(15->"100000")
0044 ISTORE(5)
0045 LDC(16->"1000000")
0046 ISTORE(6)
0047 SIPUSH(Integer{1000})
0048 ISTORE(7)
0049 IINC(8,1)
0050 ALOAD(0)
0051 ARRAYLENGTH
0052 ILOAD(8)
0053 IF_ICMPLE(60)
0054 ALOAD(0)
0055 ILOAD(8)
0056 AALOAD
0057 INVOKESTATIC(java.lang.Double,valueOf(Ljava/lang/String;)Ljava/lang/Double;)
0058 INVOKEVIRTUAL(java.lang.Double,doubleValue()D)
0059 DSTORE(1)
0060 BIPUSH(6)
0061 NEWARRAY
0062 ASTORE(8)
0063 NEW(jnt.scimark2.Random)
0064 DUP
0065 LDC(21->"101010")
0066 INVOKESPECIAL(jnt.scimark2.Random,<init>(I)V)
0067 ASTORE(9)
0068 ALOAD(8)
0069 ICONST_1(Integer{1})
0070 ILOAD(3)
0071 DLOAD(1)
0072 ALOAD(9)
0073 INVOKESTATIC(jnt.scimark2.kernel,measureFFT(IDLjnt/scimark2/Random;)D)
0074 DASTORE
0075 ALOAD(8)
0076 ICONST_2(Integer{2})
0077 ILOAD(4)
0078 DLOAD(1)
0079 ALOAD(9)
0080 INVOKESTATIC(jnt.scimark2.kernel,measureSOR(IDLjnt/scimark2/Random;)D)
0081 DASTORE
0082 ALOAD(8)
0083 ICONST_3(Integer{3})
0084 DLOAD(1)
0085 ALOAD(9)
0086 INVOKESTATIC(jnt.scimark2.kernel,measureMonteCarlo(DLjnt/scimark2/Random;)D)
0087 DASTORE
0088 ALOAD(8)
0089 ICONST_4(Integer{4})
0090 ILOAD(5)
0091 ILOAD(6)
0092 DLOAD(1)
0093 ALOAD(9)
0094 INVOKESTATIC(jnt.scimark2.kernel,measureSparseMatmult(IIDLjnt/scimark2/Random;)D)
0095 DASTORE
0096 ALOAD(8)
0097 ICONST_5(Integer{5})
0098 ILOAD(7)
0099 DLOAD(1)
0100 ALOAD(9)
0101 INVOKESTATIC(jnt.scimark2.kernel,measureLU(IDLjnt/scimark2/Random;)D)
0102 DASTORE
0103 ALOAD(8)
0104 ICONST_0(Integer{0})
0105 ALOAD(8)
0106 ICONST_1(Integer{1})
0107 DALOAD
0108 ALOAD(8)
0109 ICONST_2(Integer{2})
0110 DALOAD
0111 DADD
0112 ALOAD(8)
0113 ICONST_3(Integer{3})
0114 DALOAD
0115 DADD
0116 ALOAD(8)
0117 ICONST_4(Integer{4})
0118 DALOAD
0119 DADD
0120 ALOAD(8)
0121 ICONST_5(Integer{5})
0122 DALOAD
0123 DADD
0124 LDC(29->"5.0")
0125 DDIV
0126 DASTORE
0127 GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
0128 INVOKEVIRTUAL(java.io.PrintStream,println()V)
0129 GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
0130 LDC(31->"SciMark 2.0a")
0131 INVOKEVIRTUAL(java.io.PrintStream,println(Ljava/lang/String;)V)
0132 GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
0133 INVOKEVIRTUAL(java.io.PrintStream,println()V)
0134 GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
0135 NEW(java.lang.StringBuffer)
0136 DUP
0137 INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
0138 LDC(33->"Composite Score: ")
0139 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0140 ALOAD(8)
0141 ICONST_0(Integer{0})
0142 DALOAD
0143 INVOKEVIRTUAL(java.lang.StringBuffer,append(D)Ljava/lang/StringBuffer;)
0144 INVOKEVIRTUAL(java.lang.StringBuffer,toString()Ljava/lang/String;)
0145 INVOKEVIRTUAL(java.io.PrintStream,println(Ljava/lang/String;)V)
0146 GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
0147 NEW(java.lang.StringBuffer)
0148 DUP
0149 INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
0150 LDC(37->"FFT (")
0151 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0152 ILOAD(3)
0153 INVOKEVIRTUAL(java.lang.StringBuffer,append(I)Ljava/lang/StringBuffer;)
0154 LDC(39->"): ")
0155 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0156 INVOKEVIRTUAL(java.lang.StringBuffer,toString()Ljava/lang/String;)
0157 INVOKEVIRTUAL(java.io.PrintStream,print(Ljava/lang/String;)V)
0158 ALOAD(8)
0159 ICONST_1(Integer{1})
0160 DALOAD
0161 DCONST_0(Double{0.0})
0162 DCMPL
0163 IFNE(168)
0164 GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
0165 LDC(41->" ERROR, INVALID NUMERICAL RESULT!")
0166 INVOKEVIRTUAL(java.io.PrintStream,println(Ljava/lang/String;)V)
0167 GOTO(173)
0168 GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
0169 ALOAD(8)
0170 ICONST_1(Integer{1})
0171 DALOAD
0172 INVOKEVIRTUAL(java.io.PrintStream,println(D)V)
0173 GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
0174 NEW(java.lang.StringBuffer)
0175 DUP
0176 INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
0177 LDC(43->"SOR (")
0178 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0179 ILOAD(4)
0180 INVOKEVIRTUAL(java.lang.StringBuffer,append(I)Ljava/lang/StringBuffer;)
0181 LDC(44->"x")
0182 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0183 ILOAD(4)
0184 INVOKEVIRTUAL(java.lang.StringBuffer,append(I)Ljava/lang/StringBuffer;)
0185 LDC(39->"): ")
0186 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0187 LDC(45->"  ")
0188 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0189 ALOAD(8)
0190 ICONST_2(Integer{2})
0191 DALOAD
0192 INVOKEVIRTUAL(java.lang.StringBuffer,append(D)Ljava/lang/StringBuffer;)
0193 INVOKEVIRTUAL(java.lang.StringBuffer,toString()Ljava/lang/String;)
0194 INVOKEVIRTUAL(java.io.PrintStream,println(Ljava/lang/String;)V)
0195 GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
0196 NEW(java.lang.StringBuffer)
0197 DUP
0198 INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
0199 LDC(46->"Monte Carlo : ")
0200 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0201 ALOAD(8)
0202 ICONST_3(Integer{3})
0203 DALOAD
0204 INVOKEVIRTUAL(java.lang.StringBuffer,append(D)Ljava/lang/StringBuffer;)
0205 INVOKEVIRTUAL(java.lang.StringBuffer,toString()Ljava/lang/String;)
0206 INVOKEVIRTUAL(java.io.PrintStream,println(Ljava/lang/String;)V)
0207 GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
0208 NEW(java.lang.StringBuffer)
0209 DUP
0210 INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
0211 LDC(47->"Sparse matmult (N=")
0212 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0213 ILOAD(5)
0214 INVOKEVIRTUAL(java.lang.StringBuffer,append(I)Ljava/lang/StringBuffer;)
0215 LDC(48->", nz=")
0216 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0217 ILOAD(6)
0218 INVOKEVIRTUAL(java.lang.StringBuffer,append(I)Ljava/lang/StringBuffer;)
0219 LDC(39->"): ")
0220 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0221 ALOAD(8)
0222 ICONST_4(Integer{4})
0223 DALOAD
0224 INVOKEVIRTUAL(java.lang.StringBuffer,append(D)Ljava/lang/StringBuffer;)
0225 INVOKEVIRTUAL(java.lang.StringBuffer,toString()Ljava/lang/String;)
0226 INVOKEVIRTUAL(java.io.PrintStream,println(Ljava/lang/String;)V)
0227 GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
0228 NEW(java.lang.StringBuffer)
0229 DUP
0230 INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
0231 LDC(49->"LU (")
0232 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0233 ILOAD(7)
0234 INVOKEVIRTUAL(java.lang.StringBuffer,append(I)Ljava/lang/StringBuffer;)
0235 LDC(44->"x")
0236 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0237 ILOAD(7)
0238 INVOKEVIRTUAL(java.lang.StringBuffer,append(I)Ljava/lang/StringBuffer;)
0239 LDC(39->"): ")
0240 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0241 INVOKEVIRTUAL(java.lang.StringBuffer,toString()Ljava/lang/String;)
0242 INVOKEVIRTUAL(java.io.PrintStream,print(Ljava/lang/String;)V)
0243 ALOAD(8)
0244 ICONST_5(Integer{5})
0245 DALOAD
0246 DCONST_0(Double{0.0})
0247 DCMPL
0248 IFNE(253)
0249 GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
0250 LDC(41->" ERROR, INVALID NUMERICAL RESULT!")
0251 INVOKEVIRTUAL(java.io.PrintStream,println(Ljava/lang/String;)V)
0252 GOTO(258)
0253 GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
0254 ALOAD(8)
0255 ICONST_5(Integer{5})
0256 DALOAD
0257 INVOKEVIRTUAL(java.io.PrintStream,println(D)V)
0258 GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
0259 INVOKEVIRTUAL(java.io.PrintStream,println()V)
0260 GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
0261 NEW(java.lang.StringBuffer)
0262 DUP
0263 INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
0264 LDC(50->"java.vendor: ")
0265 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0266 LDC(51->"java.vendor")
0267 INVOKESTATIC(java.lang.System,getProperty(Ljava/lang/String;)Ljava/lang/String;)
0268 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0269 INVOKEVIRTUAL(java.lang.StringBuffer,toString()Ljava/lang/String;)
0270 INVOKEVIRTUAL(java.io.PrintStream,println(Ljava/lang/String;)V)
0271 GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
0272 NEW(java.lang.StringBuffer)
0273 DUP
0274 INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
0275 LDC(53->"java.version: ")
0276 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0277 LDC(54->"java.version")
0278 INVOKESTATIC(java.lang.System,getProperty(Ljava/lang/String;)Ljava/lang/String;)
0279 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0280 INVOKEVIRTUAL(java.lang.StringBuffer,toString()Ljava/lang/String;)
0281 INVOKEVIRTUAL(java.io.PrintStream,println(Ljava/lang/String;)V)
0282 GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
0283 NEW(java.lang.StringBuffer)
0284 DUP
0285 INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
0286 LDC(55->"os.arch: ")
0287 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0288 LDC(56->"os.arch")
0289 INVOKESTATIC(java.lang.System,getProperty(Ljava/lang/String;)Ljava/lang/String;)
0290 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0291 INVOKEVIRTUAL(java.lang.StringBuffer,toString()Ljava/lang/String;)
0292 INVOKEVIRTUAL(java.io.PrintStream,println(Ljava/lang/String;)V)
0293 GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
0294 NEW(java.lang.StringBuffer)
0295 DUP
0296 INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
0297 LDC(57->"os.name: ")
0298 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0299 LDC(58->"os.name")
0300 INVOKESTATIC(java.lang.System,getProperty(Ljava/lang/String;)Ljava/lang/String;)
0301 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0302 INVOKEVIRTUAL(java.lang.StringBuffer,toString()Ljava/lang/String;)
0303 INVOKEVIRTUAL(java.io.PrintStream,println(Ljava/lang/String;)V)
0304 GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
0305 NEW(java.lang.StringBuffer)
0306 DUP
0307 INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
0308 LDC(59->"os.version: ")
0309 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0310 LDC(60->"os.version")
0311 INVOKESTATIC(java.lang.System,getProperty(Ljava/lang/String;)Ljava/lang/String;)
0312 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0313 INVOKEVIRTUAL(java.lang.StringBuffer,toString()Ljava/lang/String;)
0314 INVOKEVIRTUAL(java.io.PrintStream,println(Ljava/lang/String;)V)
0315 RETURN
