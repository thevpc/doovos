0000 ALOAD(0)
0001 GETFIELD(jnt.Bench.Applet,cursor,I)
0002 ICONST_M1(Integer{-1})
0003 IF_ICMPEQ(9)
0004 ALOAD(0)
0005 GETFIELD(jnt.Bench.Applet,parent,Ljava/awt/Frame;)
0006 ALOAD(0)
0007 GETFIELD(jnt.Bench.Applet,cursor,I)
0008 INVOKEVIRTUAL(java.awt.Frame,setCursor(I)V)
0009 RETURN
