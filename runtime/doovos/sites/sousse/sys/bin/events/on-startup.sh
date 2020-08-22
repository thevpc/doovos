//This script is called on each Doovos boot time if it exists
export EXEC_EXT=".exe:.dasm:.dsh:.sh"
export EXEC_PKG="org.doovos.usr:test.syntax:test.perf:test.jni:test.api:test.syntax"
echo "*****************************"
echo "Starting Doovos ..."
export HOST_JRE=6
export PATH="/data/sys/bin/jre/${HOST_JRE}/*.jar:/data/sys/bin/*.jar:/data/bin/*.jar:/data/bin/*.jar:/data/bin/*.zip:/data/home/root/bin:/data/home/root/bin/test"
export INTERPRETER_RT=10
export SHELL="org.doovos.shell.DShell"
export HOME_ROOT="/data/home"
echo "*****************************"
//jnt.scimark2.commandline

export EXEC_PKG=org.doovos.usr


export SLAB=org.doovos.kernel.core.memory.slaballocator.KSlabMemorySegment
export HASH=org.doovos.kernel.vanilla.memory.KHashMemorySegment

export IDX=org.doovos.kernel.core.jvm.interpreter.KInterpreterIdx
export ASM=org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.KInterpreterAsmJIT
export JJIT=org.doovos.kernel.vanilla.jvm.interpreter.jjit.JJITInterpreter
export DBG=org.doovos.kernel.debug.jvm.iterpreter.KDebugInterpreter



//export EXEC_EXTENSION=.exe:.dasm:.dsh:.sh


//################
//###      @values : none or * or interpreter,step,init,noinit
//export DEBUG_TYPE=none
//################
//###      @values : console|file
//#boot.class.env.DEBUG_LOG=console|file
//export DEBUG_LOG=console

//################
//###      @values : absolute class method signature
//#boot.class.env.DEBUG_METHOD=myclass.method()V

//################
//###      @values : intervall of lines
//#boot.class.env.DEBUG_LINES=0-0
