0000 ALOAD(0)
0001 GETFIELD(jnt.Bench.Applet,segment,I)
0002 ICONST_M1(Integer{-1})
0003 IF_ICMPNE(46)
0004 ALOAD(0)
0005 GETFIELD(jnt.Bench.Applet,flipper,Ljava/awt/CardLayout;)
0006 ALOAD(0)
0007 GETFIELD(jnt.Bench.Applet,centerPanel,Ljava/awt/Panel;)
0008 LDC(60->"table")
0009 INVOKEVIRTUAL(java.awt.CardLayout,show(Ljava/awt/Container;Ljava/lang/String;)V)
0010 ALOAD(0)
0011 GETFIELD(jnt.Bench.Applet,table,Ljava/awt/List;)
0012 INVOKEVIRTUAL(java.awt.List,countItems()I)
0013 IFLE(17)
0014 ALOAD(0)
0015 GETFIELD(jnt.Bench.Applet,table,Ljava/awt/List;)
0016 INVOKEVIRTUAL(java.awt.List,clear()V)
0017 ALOAD(0)
0018 GETFIELD(jnt.Bench.Applet,bench,Ljnt/Bench/Bench;)
0019 INVOKEVIRTUAL(jnt.Bench.Bench,tableRows()[Ljava/lang/String;)
0020 ASTORE(1)
0021 ICONST_0(Integer{0})
0022 ISTORE(2)
0023 GOTO(31)
0024 ALOAD(0)
0025 GETFIELD(jnt.Bench.Applet,table,Ljava/awt/List;)
0026 ALOAD(1)
0027 ILOAD(2)
0028 AALOAD
0029 INVOKEVIRTUAL(java.awt.List,addItem(Ljava/lang/String;)V)
0030 IINC(2,1)
0031 ILOAD(2)
0032 ALOAD(1)
0033 ARRAYLENGTH
0034 IF_ICMPLT(24)
0035 ALOAD(0)
0036 GETFIELD(jnt.Bench.Applet,bench,Ljnt/Bench/Bench;)
0037 INVOKEVIRTUAL(jnt.Bench.Bench,getSpecialRownum()I)
0038 ISTORE(3)
0039 ILOAD(3)
0040 IFLT(71)
0041 ALOAD(0)
0042 GETFIELD(jnt.Bench.Applet,table,Ljava/awt/List;)
0043 ILOAD(3)
0044 INVOKEVIRTUAL(java.awt.List,select(I)V)
0045 GOTO(71)
0046 ALOAD(0)
0047 GETFIELD(jnt.Bench.Applet,flipper,Ljava/awt/CardLayout;)
0048 ALOAD(0)
0049 GETFIELD(jnt.Bench.Applet,centerPanel,Ljava/awt/Panel;)
0050 LDC(55->"graph")
0051 INVOKEVIRTUAL(java.awt.CardLayout,show(Ljava/awt/Container;Ljava/lang/String;)V)
0052 ALOAD(0)
0053 GETFIELD(jnt.Bench.Applet,plotter,Ljnt/Bench/Plotter;)
0054 ALOAD(0)
0055 GETFIELD(jnt.Bench.Applet,bench,Ljnt/Bench/Bench;)
0056 INVOKEVIRTUAL(jnt.Bench.Bench,getEntries()[Ljava/lang/String;)
0057 ALOAD(0)
0058 GETFIELD(jnt.Bench.Applet,bench,Ljnt/Bench/Bench;)
0059 ALOAD(0)
0060 GETFIELD(jnt.Bench.Applet,segment,I)
0061 INVOKEVIRTUAL(jnt.Bench.Bench,getSegmentValues(I)[D)
0062 ALOAD(0)
0063 GETFIELD(jnt.Bench.Applet,bench,Ljnt/Bench/Bench;)
0064 ALOAD(0)
0065 GETFIELD(jnt.Bench.Applet,segment,I)
0066 INVOKEVIRTUAL(jnt.Bench.Bench,getSegmentUnits(I)Ljava/lang/String;)
0067 ALOAD(0)
0068 GETFIELD(jnt.Bench.Applet,bench,Ljnt/Bench/Bench;)
0069 INVOKEVIRTUAL(jnt.Bench.Bench,getSpecialPos()I)
0070 INVOKEVIRTUAL(jnt.Bench.Plotter,setData([Ljava/lang/String;[DLjava/lang/String;I)V)
0071 RETURN