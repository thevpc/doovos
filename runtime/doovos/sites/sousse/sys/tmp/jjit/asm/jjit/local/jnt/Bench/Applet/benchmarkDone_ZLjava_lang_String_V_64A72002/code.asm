0000 ALOAD(0)
0001 GETFIELD(jnt.Bench.Applet,status,Ljava/awt/Label;)
0002 ALOAD(2)
0003 INVOKEVIRTUAL(java.awt.Label,setText(Ljava/lang/String;)V)
0004 ALOAD(0)
0005 GETFIELD(jnt.Bench.Applet,status,Ljava/awt/Label;)
0006 ALOAD(0)
0007 INVOKEVIRTUAL(java.awt.Component,getForeground()Ljava/awt/Color;)
0008 INVOKEVIRTUAL(java.awt.Component,setForeground(Ljava/awt/Color;)V)
0009 ALOAD(0)
0010 INVOKEVIRTUAL(jnt.Bench.Applet,revertCursor()V)
0011 ALOAD(0)
0012 GETFIELD(jnt.Bench.Applet,abortButton,Ljava/awt/Button;)
0013 INVOKEVIRTUAL(java.awt.Component,disable()V)
0014 ALOAD(0)
0015 GETFIELD(jnt.Bench.Applet,submitButton,Ljava/awt/Button;)
0016 ILOAD(1)
0017 IFEQ(24)
0018 ALOAD(0)
0019 GETFIELD(jnt.Bench.Applet,bench,Ljnt/Bench/Bench;)
0020 INVOKEVIRTUAL(jnt.Bench.Bench,isSubmittable()Z)
0021 IFEQ(24)
0022 ICONST_1(Integer{1})
0023 GOTO(25)
0024 ICONST_0(Integer{0})
0025 INVOKEVIRTUAL(java.awt.Component,enable(Z)V)
0026 ALOAD(0)
0027 INVOKEVIRTUAL(jnt.Bench.Applet,doDisplay()V)
0028 ALOAD(0)
0029 ACONST_NULL
0030 PUTFIELD(jnt.Bench.Applet,thread)
0031 RETURN