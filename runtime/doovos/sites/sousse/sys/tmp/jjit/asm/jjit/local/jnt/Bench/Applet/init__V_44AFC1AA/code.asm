0000 ALOAD(0)
0001 ALOAD(0)
0002 LDC(15->"BGCOLOR")
0003 ALOAD(0)
0004 INVOKEVIRTUAL(java.awt.Component,getBackground()Ljava/awt/Color;)
0005 INVOKEVIRTUAL(jnt.Bench.Applet,getColor(Ljava/lang/String;Ljava/awt/Color;)Ljava/awt/Color;)
0006 INVOKEVIRTUAL(java.awt.Component,setBackground(Ljava/awt/Color;)V)
0007 ALOAD(0)
0008 ALOAD(0)
0009 LDC(20->"TEXT")
0010 ALOAD(0)
0011 INVOKEVIRTUAL(java.awt.Component,getForeground()Ljava/awt/Color;)
0012 INVOKEVIRTUAL(jnt.Bench.Applet,getColor(Ljava/lang/String;Ljava/awt/Color;)Ljava/awt/Color;)
0013 INVOKEVIRTUAL(java.awt.Component,setForeground(Ljava/awt/Color;)V)
0014 ALOAD(0)
0015 LDC(23->"BUTTON_BGCOLOR")
0016 ALOAD(0)
0017 INVOKEVIRTUAL(java.awt.Component,getBackground()Ljava/awt/Color;)
0018 INVOKEVIRTUAL(jnt.Bench.Applet,getColor(Ljava/lang/String;Ljava/awt/Color;)Ljava/awt/Color;)
0019 ASTORE(1)
0020 ALOAD(0)
0021 LDC(24->"BUTTON_TEXT")
0022 ALOAD(0)
0023 INVOKEVIRTUAL(java.awt.Component,getForeground()Ljava/awt/Color;)
0024 INVOKEVIRTUAL(jnt.Bench.Applet,getColor(Ljava/lang/String;Ljava/awt/Color;)Ljava/awt/Color;)
0025 ASTORE(2)
0026 ALOAD(0)
0027 INVOKEVIRTUAL(java.awt.Component,getFont()Ljava/awt/Font;)
0028 ASTORE(3)
0029 ALOAD(3)
0030 IFNONNULL(38)
0031 NEW(java.awt.Font)
0032 DUP
0033 LDC(27->"Helvetica")
0034 ICONST_0(Integer{0})
0035 BIPUSH(12)
0036 INVOKESPECIAL(java.awt.Font,<init>(Ljava/lang/String;II)V)
0037 ASTORE(3)
0038 NEW(java.awt.GridBagLayout)
0039 DUP
0040 INVOKESPECIAL(java.awt.GridBagLayout,<init>()V)
0041 ASTORE(4)
0042 NEW(java.awt.GridBagConstraints)
0043 DUP
0044 INVOKESPECIAL(java.awt.GridBagConstraints,<init>()V)
0045 ASTORE(5)
0046 ALOAD(0)
0047 ALOAD(4)
0048 INVOKEVIRTUAL(java.awt.Container,setLayout(Ljava/awt/LayoutManager;)V)
0049 NEW(java.awt.Label)
0050 DUP
0051 LDC(34->"")
0052 ICONST_1(Integer{1})
0053 INVOKESPECIAL(java.awt.Label,<init>(Ljava/lang/String;I)V)
0054 ASTORE(6)
0055 ALOAD(6)
0056 NEW(java.awt.Font)
0057 DUP
0058 ALOAD(3)
0059 INVOKEVIRTUAL(java.awt.Font,getName()Ljava/lang/String;)
0060 ICONST_1(Integer{1})
0061 ALOAD(3)
0062 INVOKEVIRTUAL(java.awt.Font,getSize()I)
0063 ICONST_2(Integer{2})
0064 IADD
0065 INVOKESPECIAL(java.awt.Font,<init>(Ljava/lang/String;II)V)
0066 INVOKEVIRTUAL(java.awt.Component,setFont(Ljava/awt/Font;)V)
0067 ALOAD(5)
0068 ICONST_2(Integer{2})
0069 PUTFIELD(java.awt.GridBagConstraints,fill)
0070 ALOAD(5)
0071 ICONST_0(Integer{0})
0072 PUTFIELD(java.awt.GridBagConstraints,gridwidth)
0073 ALOAD(4)
0074 ALOAD(6)
0075 ALOAD(5)
0076 INVOKEVIRTUAL(java.awt.GridBagLayout,setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V)
0077 ALOAD(0)
0078 ALOAD(6)
0079 INVOKEVIRTUAL(java.awt.Container,add(Ljava/awt/Component;)Ljava/awt/Component;)
0080 POP
0081 ALOAD(0)
0082 NEW(java.awt.Choice)
0083 DUP
0084 INVOKESPECIAL(java.awt.Choice,<init>()V)
0085 PUTFIELD(jnt.Bench.Applet,chooser)
0086 ALOAD(0)
0087 GETFIELD(jnt.Bench.Applet,chooser,Ljava/awt/Choice;)
0088 ALOAD(2)
0089 INVOKEVIRTUAL(java.awt.Component,setForeground(Ljava/awt/Color;)V)
0090 ALOAD(0)
0091 GETFIELD(jnt.Bench.Applet,chooser,Ljava/awt/Choice;)
0092 ALOAD(1)
0093 INVOKEVIRTUAL(java.awt.Component,setBackground(Ljava/awt/Color;)V)
0094 ALOAD(4)
0095 ALOAD(0)
0096 GETFIELD(jnt.Bench.Applet,chooser,Ljava/awt/Choice;)
0097 ALOAD(5)
0098 INVOKEVIRTUAL(java.awt.GridBagLayout,setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V)
0099 ALOAD(0)
0100 ALOAD(0)
0101 GETFIELD(jnt.Bench.Applet,chooser,Ljava/awt/Choice;)
0102 INVOKEVIRTUAL(java.awt.Container,add(Ljava/awt/Component;)Ljava/awt/Component;)
0103 POP
0104 ALOAD(0)
0105 NEW(java.awt.Panel)
0106 DUP
0107 INVOKESPECIAL(java.awt.Panel,<init>()V)
0108 PUTFIELD(jnt.Bench.Applet,centerPanel)
0109 ALOAD(5)
0110 ICONST_1(Integer{1})
0111 PUTFIELD(java.awt.GridBagConstraints,fill)
0112 ALOAD(5)
0113 ALOAD(5)
0114 DCONST_1(Double{1.0})
0115 DUP2_X1
0116 PUTFIELD(java.awt.GridBagConstraints,weighty)
0117 PUTFIELD(java.awt.GridBagConstraints,weightx)
0118 ALOAD(4)
0119 ALOAD(0)
0120 GETFIELD(jnt.Bench.Applet,centerPanel,Ljava/awt/Panel;)
0121 ALOAD(5)
0122 INVOKEVIRTUAL(java.awt.GridBagLayout,setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V)
0123 ALOAD(0)
0124 ALOAD(0)
0125 GETFIELD(jnt.Bench.Applet,centerPanel,Ljava/awt/Panel;)
0126 INVOKEVIRTUAL(java.awt.Container,add(Ljava/awt/Component;)Ljava/awt/Component;)
0127 POP
0128 ALOAD(0)
0129 GETFIELD(jnt.Bench.Applet,centerPanel,Ljava/awt/Panel;)
0130 ALOAD(0)
0131 NEW(java.awt.CardLayout)
0132 DUP
0133 INVOKESPECIAL(java.awt.CardLayout,<init>()V)
0134 DUP_X1
0135 PUTFIELD(jnt.Bench.Applet,flipper)
0136 INVOKEVIRTUAL(java.awt.Container,setLayout(Ljava/awt/LayoutManager;)V)
0137 ALOAD(0)
0138 GETFIELD(jnt.Bench.Applet,centerPanel,Ljava/awt/Panel;)
0139 LDC(55->"graph")
0140 ALOAD(0)
0141 NEW(jnt.Bench.Plotter)
0142 DUP
0143 INVOKESPECIAL(jnt.Bench.Plotter,<init>()V)
0144 DUP_X1
0145 PUTFIELD(jnt.Bench.Applet,plotter)
0146 INVOKEVIRTUAL(java.awt.Container,add(Ljava/lang/String;Ljava/awt/Component;)Ljava/awt/Component;)
0147 POP
0148 ALOAD(0)
0149 GETFIELD(jnt.Bench.Applet,centerPanel,Ljava/awt/Panel;)
0150 LDC(60->"table")
0151 ALOAD(0)
0152 NEW(java.awt.List)
0153 DUP
0154 INVOKESPECIAL(java.awt.List,<init>()V)
0155 DUP_X1
0156 PUTFIELD(jnt.Bench.Applet,table)
0157 INVOKEVIRTUAL(java.awt.Container,add(Ljava/lang/String;Ljava/awt/Component;)Ljava/awt/Component;)
0158 POP
0159 ALOAD(0)
0160 LDC(63->"PLOTTER_BGCOLOR")
0161 GETSTATIC(java.awt.Color,white,Ljava/awt/Color;)
0162 INVOKEVIRTUAL(jnt.Bench.Applet,getColor(Ljava/lang/String;Ljava/awt/Color;)Ljava/awt/Color;)
0163 ASTORE(7)
0164 ALOAD(0)
0165 LDC(66->"PLOTTER_TEXT")
0166 GETSTATIC(java.awt.Color,black,Ljava/awt/Color;)
0167 INVOKEVIRTUAL(jnt.Bench.Applet,getColor(Ljava/lang/String;Ljava/awt/Color;)Ljava/awt/Color;)
0168 ASTORE(8)
0169 ALOAD(0)
0170 GETFIELD(jnt.Bench.Applet,plotter,Ljnt/Bench/Plotter;)
0171 ALOAD(7)
0172 INVOKEVIRTUAL(jnt.Bench.Plotter,setPlotterColor(Ljava/awt/Color;)V)
0173 ALOAD(0)
0174 GETFIELD(jnt.Bench.Applet,plotter,Ljnt/Bench/Plotter;)
0175 ALOAD(8)
0176 INVOKEVIRTUAL(jnt.Bench.Plotter,setLineColor(Ljava/awt/Color;)V)
0177 ALOAD(0)
0178 GETFIELD(jnt.Bench.Applet,plotter,Ljnt/Bench/Plotter;)
0179 ALOAD(0)
0180 LDC(70->"PLOTTER_BAR")
0181 GETSTATIC(java.awt.Color,yellow,Ljava/awt/Color;)
0182 INVOKEVIRTUAL(jnt.Bench.Applet,getColor(Ljava/lang/String;Ljava/awt/Color;)Ljava/awt/Color;)
0183 INVOKEVIRTUAL(jnt.Bench.Plotter,setBarColor(Ljava/awt/Color;)V)
0184 ALOAD(0)
0185 GETFIELD(jnt.Bench.Applet,plotter,Ljnt/Bench/Plotter;)
0186 ALOAD(0)
0187 LDC(73->"PLOTTER_SPECIAL")
0188 GETSTATIC(java.awt.Color,red,Ljava/awt/Color;)
0189 INVOKEVIRTUAL(jnt.Bench.Applet,getColor(Ljava/lang/String;Ljava/awt/Color;)Ljava/awt/Color;)
0190 INVOKEVIRTUAL(jnt.Bench.Plotter,setSpecialColor(Ljava/awt/Color;)V)
0191 ALOAD(0)
0192 GETFIELD(jnt.Bench.Applet,table,Ljava/awt/List;)
0193 ALOAD(7)
0194 INVOKEVIRTUAL(java.awt.Component,setBackground(Ljava/awt/Color;)V)
0195 ALOAD(0)
0196 GETFIELD(jnt.Bench.Applet,table,Ljava/awt/List;)
0197 ALOAD(8)
0198 INVOKEVIRTUAL(java.awt.Component,setForeground(Ljava/awt/Color;)V)
0199 ALOAD(0)
0200 GETFIELD(jnt.Bench.Applet,table,Ljava/awt/List;)
0201 NEW(java.awt.Font)
0202 DUP
0203 LDC(76->"Courier")
0204 ICONST_0(Integer{0})
0205 ALOAD(3)
0206 INVOKEVIRTUAL(java.awt.Font,getSize()I)
0207 INVOKESPECIAL(java.awt.Font,<init>(Ljava/lang/String;II)V)
0208 INVOKEVIRTUAL(java.awt.Component,setFont(Ljava/awt/Font;)V)
0209 ALOAD(0)
0210 NEW(java.awt.Button)
0211 DUP
0212 LDC(78->"Execute Benchmark")
0213 INVOKESPECIAL(java.awt.Button,<init>(Ljava/lang/String;)V)
0214 PUTFIELD(jnt.Bench.Applet,executeButton)
0215 ALOAD(0)
0216 GETFIELD(jnt.Bench.Applet,executeButton,Ljava/awt/Button;)
0217 ALOAD(2)
0218 INVOKEVIRTUAL(java.awt.Component,setForeground(Ljava/awt/Color;)V)
0219 ALOAD(0)
0220 GETFIELD(jnt.Bench.Applet,executeButton,Ljava/awt/Button;)
0221 ALOAD(1)
0222 INVOKEVIRTUAL(java.awt.Component,setBackground(Ljava/awt/Color;)V)
0223 ALOAD(5)
0224 DCONST_1(Double{1.0})
0225 PUTFIELD(java.awt.GridBagConstraints,weightx)
0226 ALOAD(5)
0227 DCONST_0(Double{0.0})
0228 PUTFIELD(java.awt.GridBagConstraints,weighty)
0229 ALOAD(5)
0230 ICONST_2(Integer{2})
0231 PUTFIELD(java.awt.GridBagConstraints,fill)
0232 ALOAD(5)
0233 ICONST_1(Integer{1})
0234 PUTFIELD(java.awt.GridBagConstraints,gridwidth)
0235 ALOAD(4)
0236 ALOAD(0)
0237 GETFIELD(jnt.Bench.Applet,executeButton,Ljava/awt/Button;)
0238 ALOAD(5)
0239 INVOKEVIRTUAL(java.awt.GridBagLayout,setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V)
0240 ALOAD(0)
0241 ALOAD(0)
0242 GETFIELD(jnt.Bench.Applet,executeButton,Ljava/awt/Button;)
0243 INVOKEVIRTUAL(java.awt.Container,add(Ljava/awt/Component;)Ljava/awt/Component;)
0244 POP
0245 ALOAD(0)
0246 NEW(java.awt.Button)
0247 DUP
0248 LDC(82->"ABORT")
0249 INVOKESPECIAL(java.awt.Button,<init>(Ljava/lang/String;)V)
0250 PUTFIELD(jnt.Bench.Applet,abortButton)
0251 ALOAD(0)
0252 GETFIELD(jnt.Bench.Applet,abortButton,Ljava/awt/Button;)
0253 ALOAD(2)
0254 INVOKEVIRTUAL(java.awt.Component,setForeground(Ljava/awt/Color;)V)
0255 ALOAD(0)
0256 GETFIELD(jnt.Bench.Applet,abortButton,Ljava/awt/Button;)
0257 ALOAD(1)
0258 INVOKEVIRTUAL(java.awt.Component,setBackground(Ljava/awt/Color;)V)
0259 ALOAD(0)
0260 GETFIELD(jnt.Bench.Applet,abortButton,Ljava/awt/Button;)
0261 INVOKEVIRTUAL(java.awt.Component,disable()V)
0262 ALOAD(4)
0263 ALOAD(0)
0264 GETFIELD(jnt.Bench.Applet,abortButton,Ljava/awt/Button;)
0265 ALOAD(5)
0266 INVOKEVIRTUAL(java.awt.GridBagLayout,setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V)
0267 ALOAD(0)
0268 ALOAD(0)
0269 GETFIELD(jnt.Bench.Applet,abortButton,Ljava/awt/Button;)
0270 INVOKEVIRTUAL(java.awt.Container,add(Ljava/awt/Component;)Ljava/awt/Component;)
0271 POP
0272 ALOAD(0)
0273 NEW(java.awt.Button)
0274 DUP
0275 LDC(85->"Submit Results")
0276 INVOKESPECIAL(java.awt.Button,<init>(Ljava/lang/String;)V)
0277 PUTFIELD(jnt.Bench.Applet,submitButton)
0278 ALOAD(0)
0279 GETFIELD(jnt.Bench.Applet,submitButton,Ljava/awt/Button;)
0280 ALOAD(2)
0281 INVOKEVIRTUAL(java.awt.Component,setForeground(Ljava/awt/Color;)V)
0282 ALOAD(0)
0283 GETFIELD(jnt.Bench.Applet,submitButton,Ljava/awt/Button;)
0284 ALOAD(1)
0285 INVOKEVIRTUAL(java.awt.Component,setBackground(Ljava/awt/Color;)V)
0286 ALOAD(0)
0287 GETFIELD(jnt.Bench.Applet,submitButton,Ljava/awt/Button;)
0288 INVOKEVIRTUAL(java.awt.Component,disable()V)
0289 ALOAD(5)
0290 ICONST_0(Integer{0})
0291 PUTFIELD(java.awt.GridBagConstraints,gridwidth)
0292 ALOAD(4)
0293 ALOAD(0)
0294 GETFIELD(jnt.Bench.Applet,submitButton,Ljava/awt/Button;)
0295 ALOAD(5)
0296 INVOKEVIRTUAL(java.awt.GridBagLayout,setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V)
0297 ALOAD(0)
0298 ALOAD(0)
0299 GETFIELD(jnt.Bench.Applet,submitButton,Ljava/awt/Button;)
0300 INVOKEVIRTUAL(java.awt.Container,add(Ljava/awt/Component;)Ljava/awt/Component;)
0301 POP
0302 ALOAD(0)
0303 NEW(java.awt.Label)
0304 DUP
0305 LDC(34->"")
0306 ICONST_1(Integer{1})
0307 INVOKESPECIAL(java.awt.Label,<init>(Ljava/lang/String;I)V)
0308 PUTFIELD(jnt.Bench.Applet,status)
0309 ALOAD(0)
0310 GETFIELD(jnt.Bench.Applet,status,Ljava/awt/Label;)
0311 NEW(java.awt.Font)
0312 DUP
0313 ALOAD(3)
0314 INVOKEVIRTUAL(java.awt.Font,getName()Ljava/lang/String;)
0315 ICONST_1(Integer{1})
0316 ALOAD(3)
0317 INVOKEVIRTUAL(java.awt.Font,getSize()I)
0318 INVOKESPECIAL(java.awt.Font,<init>(Ljava/lang/String;II)V)
0319 INVOKEVIRTUAL(java.awt.Component,setFont(Ljava/awt/Font;)V)
0320 ALOAD(4)
0321 ALOAD(0)
0322 GETFIELD(jnt.Bench.Applet,status,Ljava/awt/Label;)
0323 ALOAD(5)
0324 INVOKEVIRTUAL(java.awt.GridBagLayout,setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V)
0325 ALOAD(0)
0326 ALOAD(0)
0327 GETFIELD(jnt.Bench.Applet,status,Ljava/awt/Label;)
0328 INVOKEVIRTUAL(java.awt.Container,add(Ljava/awt/Component;)Ljava/awt/Component;)
0329 POP
0330 ALOAD(0)
0331 GETFIELD(jnt.Bench.Applet,bench,Ljnt/Bench/Bench;)
0332 IFNONNULL(363)
0333 ALOAD(0)
0334 LDC(89->"descriptor")
0335 INVOKEVIRTUAL(java.applet.Applet,getParameter(Ljava/lang/String;)Ljava/lang/String;)
0336 ASTORE(9)
0337 ALOAD(9)
0338 IFNONNULL(341)
0339 LDC(90->"default.descriptor")
0340 ASTORE(9)
0341 ALOAD(0)
0342 NEW(jnt.Bench.Bench)
0343 DUP
0344 ALOAD(0)
0345 NEW(java.net.URL)
0346 DUP
0347 ALOAD(0)
0348 INVOKEVIRTUAL(java.applet.Applet,getDocumentBase()Ljava/net/URL;)
0349 ALOAD(9)
0350 INVOKESPECIAL(java.net.URL,<init>(Ljava/net/URL;Ljava/lang/String;)V)
0351 INVOKESPECIAL(jnt.Bench.Bench,<init>(Ljnt/Bench/Applet;Ljava/net/URL;)V)
0352 PUTFIELD(jnt.Bench.Applet,bench)
0353 GOTO(363)
0354 ASTORE(9)
0355 ALOAD(0)
0356 GETFIELD(jnt.Bench.Applet,status,Ljava/awt/Label;)
0357 ALOAD(9)
0358 INVOKEVIRTUAL(java.lang.Throwable,toString()Ljava/lang/String;)
0359 INVOKEVIRTUAL(java.awt.Label,setText(Ljava/lang/String;)V)
0360 ALOAD(9)
0361 GETSTATIC(java.lang.System,out,Ljava/io/PrintStream;)
0362 INVOKEVIRTUAL(java.lang.Throwable,printStackTrace(Ljava/io/PrintStream;)V)
0363 ALOAD(0)
0364 GETFIELD(jnt.Bench.Applet,bench,Ljnt/Bench/Bench;)
0365 IFNULL(409)
0366 ALOAD(6)
0367 ALOAD(0)
0368 GETFIELD(jnt.Bench.Applet,bench,Ljnt/Bench/Bench;)
0369 INVOKEVIRTUAL(jnt.Bench.Bench,getName()Ljava/lang/String;)
0370 INVOKEVIRTUAL(java.awt.Label,setText(Ljava/lang/String;)V)
0371 ALOAD(0)
0372 GETFIELD(jnt.Bench.Applet,bench,Ljnt/Bench/Bench;)
0373 INVOKEVIRTUAL(jnt.Bench.Bench,getSegmentNames()[Ljava/lang/String;)
0374 ASTORE(9)
0375 ALOAD(0)
0376 GETFIELD(jnt.Bench.Applet,chooser,Ljava/awt/Choice;)
0377 ALOAD(9)
0378 ICONST_0(Integer{0})
0379 AALOAD
0380 INVOKEVIRTUAL(java.awt.Choice,addItem(Ljava/lang/String;)V)
0381 ALOAD(0)
0382 GETFIELD(jnt.Bench.Applet,chooser,Ljava/awt/Choice;)
0383 LDC(105->"Show Table")
0384 INVOKEVIRTUAL(java.awt.Choice,addItem(Ljava/lang/String;)V)
0385 ICONST_1(Integer{1})
0386 ISTORE(10)
0387 GOTO(395)
0388 ALOAD(0)
0389 GETFIELD(jnt.Bench.Applet,chooser,Ljava/awt/Choice;)
0390 ALOAD(9)
0391 ILOAD(10)
0392 AALOAD
0393 INVOKEVIRTUAL(java.awt.Choice,addItem(Ljava/lang/String;)V)
0394 IINC(10,1)
0395 ILOAD(10)
0396 ALOAD(9)
0397 ARRAYLENGTH
0398 IF_ICMPLT(388)
0399 ALOAD(0)
0400 GETFIELD(jnt.Bench.Applet,bench,Ljnt/Bench/Bench;)
0401 INVOKEVIRTUAL(jnt.Bench.Bench,isRunnable()Z)
0402 IFNE(406)
0403 ALOAD(0)
0404 GETFIELD(jnt.Bench.Applet,executeButton,Ljava/awt/Button;)
0405 INVOKEVIRTUAL(java.awt.Component,disable()V)
0406 ALOAD(0)
0407 INVOKEVIRTUAL(jnt.Bench.Applet,doDisplay()V)
0408 GOTO(412)
0409 ALOAD(0)
0410 GETFIELD(jnt.Bench.Applet,executeButton,Ljava/awt/Button;)
0411 INVOKEVIRTUAL(java.awt.Component,disable()V)
0412 RETURN
