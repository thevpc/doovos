0000 ALOAD(0)
0001 GETFIELD(jnt.Bench.Applet,thread,Ljava/lang/Thread;)
0002 IFNONNULL(26)
0003 ALOAD(0)
0004 GETFIELD(jnt.Bench.Applet,status,Ljava/awt/Label;)
0005 LDC(120->"Running Benchmark")
0006 INVOKEVIRTUAL(java.awt.Label,setText(Ljava/lang/String;)V)
0007 ALOAD(0)
0008 GETFIELD(jnt.Bench.Applet,status,Ljava/awt/Label;)
0009 GETSTATIC(java.awt.Color,red,Ljava/awt/Color;)
0010 INVOKEVIRTUAL(java.awt.Component,setForeground(Ljava/awt/Color;)V)
0011 ALOAD(0)
0012 INVOKEVIRTUAL(jnt.Bench.Applet,waitCursor()V)
0013 ALOAD(0)
0014 GETFIELD(jnt.Bench.Applet,abortButton,Ljava/awt/Button;)
0015 INVOKEVIRTUAL(java.awt.Component,enable()V)
0016 ALOAD(0)
0017 NEW(java.lang.Thread)
0018 DUP
0019 ALOAD(0)
0020 GETFIELD(jnt.Bench.Applet,bench,Ljnt/Bench/Bench;)
0021 INVOKESPECIAL(java.lang.Thread,<init>(Ljava/lang/Runnable;)V)
0022 PUTFIELD(jnt.Bench.Applet,thread)
0023 ALOAD(0)
0024 GETFIELD(jnt.Bench.Applet,thread,Ljava/lang/Thread;)
0025 INVOKEVIRTUAL(java.lang.Thread,start()V)
0026 RETURN
