0000 ALOAD(0)
0001 GETFIELD(jnt.Bench.Applet,status,Ljava/awt/Label;)
0002 ALOAD(2)
0003 INVOKEVIRTUAL(java.awt.Label,setText(Ljava/lang/String;)V)
0004 ALOAD(0)
0005 GETFIELD(jnt.Bench.Applet,submitButton,Ljava/awt/Button;)
0006 ILOAD(1)
0007 IFNE(10)
0008 ICONST_1(Integer{1})
0009 GOTO(11)
0010 ICONST_0(Integer{0})
0011 INVOKEVIRTUAL(java.awt.Component,enable(Z)V)
0012 RETURN
