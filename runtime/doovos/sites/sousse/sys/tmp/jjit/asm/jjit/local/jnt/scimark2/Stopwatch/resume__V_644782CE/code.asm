0000 ALOAD(0)
0001 GETFIELD(jnt.scimark2.Stopwatch,running,Z)
0002 IFNE(9)
0003 ALOAD(0)
0004 INVOKESTATIC(jnt.scimark2.Stopwatch,seconds()D)
0005 PUTFIELD(jnt.scimark2.Stopwatch,last_time)
0006 ALOAD(0)
0007 ICONST_1(Integer{1})
0008 PUTFIELD(jnt.scimark2.Stopwatch,running)
0009 RETURN
