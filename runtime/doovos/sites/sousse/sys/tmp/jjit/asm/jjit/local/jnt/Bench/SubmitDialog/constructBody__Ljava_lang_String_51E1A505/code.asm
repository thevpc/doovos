0000 NEW(java.lang.StringBuffer)
0001 DUP
0002 INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
0003 ASTORE(1)
0004 ALOAD(1)
0005 LDC(88->"START : **************************************** ;
")
0006 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0007 POP
0008 ALOAD(1)
0009 NEW(java.lang.StringBuffer)
0010 DUP
0011 INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
0012 LDC(89->"Benchmark.name    : ")
0013 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0014 ALOAD(0)
0015 ALOAD(0)
0016 GETFIELD(jnt.Bench.SubmitDialog,bench,Ljnt/Bench/Bench;)
0017 INVOKEVIRTUAL(jnt.Bench.Bench,getName()Ljava/lang/String;)
0018 INVOKEVIRTUAL(jnt.Bench.SubmitDialog,clean(Ljava/lang/String;)Ljava/lang/String;)
0019 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0020 LDC(92->";
")
0021 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0022 INVOKEVIRTUAL(java.lang.StringBuffer,toString()Ljava/lang/String;)
0023 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0024 POP
0025 ALOAD(0)
0026 GETFIELD(jnt.Bench.SubmitDialog,bench,Ljnt/Bench/Bench;)
0027 INVOKEVIRTUAL(jnt.Bench.Bench,getCurrentValues()[D)
0028 ASTORE(2)
0029 ALOAD(1)
0030 LDC(94->"Benchmark.Values  : ")
0031 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0032 POP
0033 ALOAD(2)
0034 IFNULL(56)
0035 ICONST_0(Integer{0})
0036 ISTORE(3)
0037 GOTO(52)
0038 ALOAD(1)
0039 NEW(java.lang.StringBuffer)
0040 DUP
0041 INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
0042 LDC(56->" ")
0043 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0044 ALOAD(2)
0045 ILOAD(3)
0046 DALOAD
0047 INVOKEVIRTUAL(java.lang.StringBuffer,append(D)Ljava/lang/StringBuffer;)
0048 INVOKEVIRTUAL(java.lang.StringBuffer,toString()Ljava/lang/String;)
0049 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0050 POP
0051 IINC(3,1)
0052 ILOAD(3)
0053 ALOAD(2)
0054 ARRAYLENGTH
0055 IF_ICMPLT(38)
0056 ALOAD(1)
0057 LDC(92->";
")
0058 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0059 POP
0060 ALOAD(1)
0061 NEW(java.lang.StringBuffer)
0062 DUP
0063 INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
0064 LDC(96->"  sys.os.name     : ")
0065 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0066 ALOAD(0)
0067 ALOAD(0)
0068 LDC(53->"os.name")
0069 INVOKEVIRTUAL(jnt.Bench.SubmitDialog,getSysProp(Ljava/lang/String;)Ljava/lang/String;)
0070 INVOKEVIRTUAL(jnt.Bench.SubmitDialog,clean(Ljava/lang/String;)Ljava/lang/String;)
0071 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0072 LDC(92->";
")
0073 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0074 INVOKEVIRTUAL(java.lang.StringBuffer,toString()Ljava/lang/String;)
0075 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0076 POP
0077 ALOAD(1)
0078 NEW(java.lang.StringBuffer)
0079 DUP
0080 INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
0081 LDC(97->"  sys.os.version  : ")
0082 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0083 ALOAD(0)
0084 ALOAD(0)
0085 LDC(57->"os.version")
0086 INVOKEVIRTUAL(jnt.Bench.SubmitDialog,getSysProp(Ljava/lang/String;)Ljava/lang/String;)
0087 INVOKEVIRTUAL(jnt.Bench.SubmitDialog,clean(Ljava/lang/String;)Ljava/lang/String;)
0088 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0089 LDC(92->";
")
0090 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0091 INVOKEVIRTUAL(java.lang.StringBuffer,toString()Ljava/lang/String;)
0092 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0093 POP
0094 ALOAD(1)
0095 NEW(java.lang.StringBuffer)
0096 DUP
0097 INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
0098 LDC(98->"  sys.os.arch     : ")
0099 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0100 ALOAD(0)
0101 ALOAD(0)
0102 LDC(99->"os.arch")
0103 INVOKEVIRTUAL(jnt.Bench.SubmitDialog,getSysProp(Ljava/lang/String;)Ljava/lang/String;)
0104 INVOKEVIRTUAL(jnt.Bench.SubmitDialog,clean(Ljava/lang/String;)Ljava/lang/String;)
0105 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0106 LDC(92->";
")
0107 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0108 INVOKEVIRTUAL(java.lang.StringBuffer,toString()Ljava/lang/String;)
0109 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0110 POP
0111 ALOAD(1)
0112 NEW(java.lang.StringBuffer)
0113 DUP
0114 INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
0115 LDC(100->"  sys.java.vendor : ")
0116 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0117 ALOAD(0)
0118 ALOAD(0)
0119 LDC(61->"java.vendor")
0120 INVOKEVIRTUAL(jnt.Bench.SubmitDialog,getSysProp(Ljava/lang/String;)Ljava/lang/String;)
0121 INVOKEVIRTUAL(jnt.Bench.SubmitDialog,clean(Ljava/lang/String;)Ljava/lang/String;)
0122 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0123 LDC(92->";
")
0124 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0125 INVOKEVIRTUAL(java.lang.StringBuffer,toString()Ljava/lang/String;)
0126 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0127 POP
0128 ALOAD(1)
0129 NEW(java.lang.StringBuffer)
0130 DUP
0131 INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
0132 LDC(101->"  sys.java.version: ")
0133 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0134 ALOAD(0)
0135 ALOAD(0)
0136 LDC(62->"java.version")
0137 INVOKEVIRTUAL(jnt.Bench.SubmitDialog,getSysProp(Ljava/lang/String;)Ljava/lang/String;)
0138 INVOKEVIRTUAL(jnt.Bench.SubmitDialog,clean(Ljava/lang/String;)Ljava/lang/String;)
0139 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0140 LDC(92->";
")
0141 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0142 INVOKEVIRTUAL(java.lang.StringBuffer,toString()Ljava/lang/String;)
0143 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0144 POP
0145 ALOAD(1)
0146 NEW(java.lang.StringBuffer)
0147 DUP
0148 INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
0149 LDC(102->"  user.name       : ")
0150 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0151 ALOAD(0)
0152 ALOAD(0)
0153 GETFIELD(jnt.Bench.SubmitDialog,user,Ljava/awt/TextComponent;)
0154 INVOKEVIRTUAL(java.awt.TextComponent,getText()Ljava/lang/String;)
0155 INVOKEVIRTUAL(jnt.Bench.SubmitDialog,clean(Ljava/lang/String;)Ljava/lang/String;)
0156 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0157 LDC(92->";
")
0158 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0159 INVOKEVIRTUAL(java.lang.StringBuffer,toString()Ljava/lang/String;)
0160 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0161 POP
0162 ALOAD(1)
0163 NEW(java.lang.StringBuffer)
0164 DUP
0165 INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
0166 LDC(104->"  user.email      : ")
0167 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0168 ALOAD(0)
0169 ALOAD(0)
0170 GETFIELD(jnt.Bench.SubmitDialog,from,Ljava/awt/TextComponent;)
0171 INVOKEVIRTUAL(java.awt.TextComponent,getText()Ljava/lang/String;)
0172 INVOKEVIRTUAL(jnt.Bench.SubmitDialog,clean(Ljava/lang/String;)Ljava/lang/String;)
0173 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0174 LDC(92->";
")
0175 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0176 INVOKEVIRTUAL(java.lang.StringBuffer,toString()Ljava/lang/String;)
0177 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0178 POP
0179 ALOAD(1)
0180 NEW(java.lang.StringBuffer)
0181 DUP
0182 INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
0183 LDC(105->"  user.computer   : ")
0184 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0185 ALOAD(0)
0186 ALOAD(0)
0187 GETFIELD(jnt.Bench.SubmitDialog,brand,Ljava/awt/TextComponent;)
0188 INVOKEVIRTUAL(java.awt.TextComponent,getText()Ljava/lang/String;)
0189 INVOKEVIRTUAL(jnt.Bench.SubmitDialog,clean(Ljava/lang/String;)Ljava/lang/String;)
0190 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0191 LDC(92->";
")
0192 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0193 INVOKEVIRTUAL(java.lang.StringBuffer,toString()Ljava/lang/String;)
0194 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0195 POP
0196 ALOAD(1)
0197 NEW(java.lang.StringBuffer)
0198 DUP
0199 INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
0200 LDC(106->"  user.CPU        : ")
0201 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0202 ALOAD(0)
0203 ALOAD(0)
0204 GETFIELD(jnt.Bench.SubmitDialog,cpu,Ljava/awt/TextComponent;)
0205 INVOKEVIRTUAL(java.awt.TextComponent,getText()Ljava/lang/String;)
0206 INVOKEVIRTUAL(jnt.Bench.SubmitDialog,clean(Ljava/lang/String;)Ljava/lang/String;)
0207 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0208 LDC(92->";
")
0209 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0210 INVOKEVIRTUAL(java.lang.StringBuffer,toString()Ljava/lang/String;)
0211 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0212 POP
0213 ALOAD(1)
0214 NEW(java.lang.StringBuffer)
0215 DUP
0216 INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
0217 LDC(107->"  user.OS         : ")
0218 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0219 ALOAD(0)
0220 ALOAD(0)
0221 GETFIELD(jnt.Bench.SubmitDialog,os,Ljava/awt/TextComponent;)
0222 INVOKEVIRTUAL(java.awt.TextComponent,getText()Ljava/lang/String;)
0223 INVOKEVIRTUAL(jnt.Bench.SubmitDialog,clean(Ljava/lang/String;)Ljava/lang/String;)
0224 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0225 LDC(92->";
")
0226 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0227 INVOKEVIRTUAL(java.lang.StringBuffer,toString()Ljava/lang/String;)
0228 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0229 POP
0230 ALOAD(1)
0231 NEW(java.lang.StringBuffer)
0232 DUP
0233 INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
0234 LDC(108->"  user.VM         : ")
0235 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0236 ALOAD(0)
0237 ALOAD(0)
0238 GETFIELD(jnt.Bench.SubmitDialog,vm,Ljava/awt/TextComponent;)
0239 INVOKEVIRTUAL(java.awt.TextComponent,getText()Ljava/lang/String;)
0240 INVOKEVIRTUAL(jnt.Bench.SubmitDialog,clean(Ljava/lang/String;)Ljava/lang/String;)
0241 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0242 LDC(92->";
")
0243 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0244 INVOKEVIRTUAL(java.lang.StringBuffer,toString()Ljava/lang/String;)
0245 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0246 POP
0247 ALOAD(1)
0248 NEW(java.lang.StringBuffer)
0249 DUP
0250 INVOKESPECIAL(java.lang.StringBuffer,<init>()V)
0251 LDC(109->"  user.Comments   : ")
0252 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0253 ALOAD(0)
0254 ALOAD(0)
0255 GETFIELD(jnt.Bench.SubmitDialog,comments,Ljava/awt/TextComponent;)
0256 INVOKEVIRTUAL(java.awt.TextComponent,getText()Ljava/lang/String;)
0257 INVOKEVIRTUAL(jnt.Bench.SubmitDialog,clean(Ljava/lang/String;)Ljava/lang/String;)
0258 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0259 LDC(92->";
")
0260 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0261 INVOKEVIRTUAL(java.lang.StringBuffer,toString()Ljava/lang/String;)
0262 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0263 POP
0264 ALOAD(1)
0265 LDC(110->"END : **************************************** ;
")
0266 INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
0267 POP
0268 ALOAD(1)
0269 INVOKEVIRTUAL(java.lang.StringBuffer,toString()Ljava/lang/String;)
0270 ARETURN
