0000 ALOAD(0)
0001 GETFIELD(jnt.Bench.Stopwatch,running,Z)
0002 IFEQ(17)
0003 INVOKESTATIC(java.lang.System,currentTimeMillis()J)
0004 LSTORE(1)
0005 ALOAD(0)
0006 DUP
0007 GETFIELD(jnt.Bench.Stopwatch,total,J)
0008 LLOAD(1)
0009 ALOAD(0)
0010 GETFIELD(jnt.Bench.Stopwatch,last_time,J)
0011 LSUB
0012 LADD
0013 PUTFIELD(jnt.Bench.Stopwatch,total)
0014 ALOAD(0)
0015 LLOAD(1)
0016 PUTFIELD(jnt.Bench.Stopwatch,last_time)
0017 ALOAD(0)
0018 GETFIELD(jnt.Bench.Stopwatch,total,J)
0019 L2D
0020 LDC(11->"0.0010")
0021 DMUL
0022 DRETURN
