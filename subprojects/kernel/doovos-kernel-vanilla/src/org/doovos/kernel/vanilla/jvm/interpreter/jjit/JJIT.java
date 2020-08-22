package org.doovos.kernel.vanilla.jvm.interpreter.jjit;

import org.doovos.kernel.vanilla.jvm.interpreter.jjit.stats.JJITMethodCompilerStat;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.stats.JJITSharedBlocKey;
import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.jvm.bytecode.KInstructionDef;
import org.doovos.kernel.api.jvm.bytecode.KMethodDef;
import org.doovos.kernel.api.jvm.bytecode.KTryCatchDef;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.jvm.reflect.KMethodInfo;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.core.util.IntHashMap;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.compiler.JJITCompiler;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.compiler.JJITCompiler5;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.debug.JJITDebug;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.debug.JJITLog;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControl;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlNode;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstructionDef;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstructionFactory;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.shared.SharedInstructionFactory;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_BIPUSH;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.special.JJIT_ABSTRACT_CALL;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.special.JJIT_INITIALIZE_CLASS;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.special.JJIT_JNI_CALL;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITClassSource;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.unbrekable.Bloc;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.unbrekable.BlocParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.special.JJIT_COMPILE;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.special.JJIT_INITIALIZE_CLASS_AND_RECOMPILE;

public class JJIT {

    private static JJITInstructionFactory factory = new JJITInstructionFactory();
    private static JJITCompiler compiler;
    //    private static JJITCompiler5 compiler5;
    private static final File bootFolder;
    private static final File srcFolder;
    private static final File binFolder;
    private static final File asmFolder;
    private static final File cacheFolder;
    private static JJITGuestToHostStaticFilter g2h = new JJITGuestToHostStaticFilterDefault();
    private static DecimalFormat DF = new DecimalFormat("000");

    static {
        try {
            bootFolder = new File(Doovos.getSystem().getBootConfig() == null ? new File(".") : Doovos.getSystem().getBootConfig().getBootFolder(), "sys/tmp/jjit");
            //compiler = new JJITCompiler(, );
            binFolder = new File(bootFolder, "bin");
            srcFolder = new File(bootFolder, "src");
            asmFolder = new File(bootFolder, "asm");
            cacheFolder = new File(bootFolder, "cache");
            binFolder.mkdirs();
            srcFolder.mkdirs();
            asmFolder.mkdirs();

            compiler = new JJITCompiler5(srcFolder, binFolder);
//            compiler5 = new JJITCompiler5();
        } catch (IOException e) {
            throw new RuntimeException("Should not happen");
        }
    }

    public static void disassembleMethod(KMethodDef method, JJITDebug debug) {
        PrintWriter p = null;
        try {
            String packageName = JJITUtils.getPackageName(method, debug);
            File asmFile = new File(asmFolder, packageName.replace('.', '/') + "/code.asm");
            asmFile.getParentFile().mkdirs();
            p = new PrintWriter(asmFile);
            int index = 0;
            DecimalFormat f = new DecimalFormat("0000");

            Object[] objConstantsPool = method.getParentClass().getConstantsPool();
            KInstructionDef[] instructionDefs = method.getCode();
            for (int i = 0; i < instructionDefs.length; i++) {
                final JJITInstructionDef ii = factory.createInstruction(i, instructionDefs[i], objConstantsPool);
                p.println(f.format(index) + " " + ii.toString());
                index++;
            }
            p.close();
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } finally {
            if (p != null) {
                p.close();
            }
        }
    }

    public static void initializeMethod(KMethod method, KProcess process, JJITDebug debug) {
        KMethodInfo i = null;
        JJITProcessStat stat = null;
        if (debug.isStat()) {
            try {
                stat = (JJITProcessStat) process.getAttribute(JJITProcessStat.class.getName());
                if (stat == null) {
                    stat = new JJITProcessStat();
                    process.setAttribute(JJITProcessStat.class.getName(), stat);
                }
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
        JJITMethodCompilerCache cache = (JJITMethodCompilerCache) method.getMethodCompilerCache();
        if (cache == null) {
            KInstructionDef[] codeDef = method.getDefinition().getCode();
            JJITInstructionDef[] instructionDefs = new JJITInstructionDef[codeDef.length];
            Exception errFact = null;
            Object[] objConstantsPool = method.getParentClass().getConstantsPool();
            for (int j = 0; j < instructionDefs.length; j++) {
                try {
                    instructionDefs[j] = factory.createInstruction(j, codeDef[j], objConstantsPool);
                } catch (Exception e) {
                    errFact = e;
                    System.err.println(e);
                }
            }
            if (errFact != null) {
                throw new RuntimeException(errFact);
            }
            cache = new JJITMethodCompilerCache();
            cache.setInstructionDefs(instructionDefs);
            method.setMethodCompilerCache(cache);
        }
        JJITMethodCompilerHints hints = (JJITMethodCompilerHints) method.getMethodCompilerHints();
        if (hints == null) {
            hints = new JJITMethodCompilerHints();
            if (debug.isOptRecompileOnClassLoaded()) {
                for (JJITInstructionDef def : cache.getInstructionDefs()) {
                    hints.getYetToInitializeClasses().addAll(Arrays.asList(def.getLoadingClasses()));
                }
            }
            method.setMethodCompilerHints(hints);
        } else {
            if (debug.isOptRecompileOnClassLoaded()) {
                for (Iterator<String> it = hints.getYetToInitializeClasses().iterator(); it.hasNext();) {
                    try {
                        String s = it.next();
                        if (process.getClassRepository().getClassByName(s).isInitialized()) {
                            it.remove();
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
        if (debug.isOptCacheClasses()) {
            String packageName = JJITUtils.getPackageName(method, hints, debug);
            File serFile = new File(cacheFolder, packageName.replace('.', '/') + "/method-info.ser");
            if (serFile.exists()) {
                try {
                    i = (KMethodInfo) JJITUtils.loadObject(serFile, compiler.getClassLoader());
                } catch (IOException e) {
                    e.printStackTrace();
                    //ignore
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    //ignore
                }
            }
            if (i == null) {
                i = compileMethod(new CompileInfo(method.getDefinition(), process, cache, hints, debug, stat, compiler));
                try {
                    JJITUtils.saveObject(serFile, i);
                } catch (IOException e) {
                    System.err.println(e);
//            e.printStackTrace();
                    //ignore
                }
            }
        } else {
            i = compileMethod(new CompileInfo(method.getDefinition(), process, cache, hints, debug, stat, compiler));
        }

        final KRegister[] regConstantsPool = method.getParentClass().getConstantsPool();
        JJITInstruction[] instructions = (JJITInstruction[]) i.getCode();
        for (int j = 0; j < instructions.length; j++) {
            try {
                instructions[j].init(j, instructions, regConstantsPool, process);
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        method.setCode(instructions);
        method.setTryCatchDef(i.getTryCatchBlocs());
    }

    public static class CompileInfo {

        KProcess process;
        KMethodDef method;
        JJITMethodCompilerCache cache;
        JJITMethodCompilerHints hints;
        JJITDebug debug;
        JJITProcessStat processStat;
        JJITInstructionDef[] instructionDefs;
        JJITCompiler compiler;
        IntHashMap labelsMap;
        String packageName;
        Object[] objConstantsPool;

        public CompileInfo(KMethodDef method, KProcess process, JJITMethodCompilerCache cache, JJITMethodCompilerHints hints, JJITDebug debug, JJITProcessStat processStat, JJITCompiler compiler) {
            this.method = method;
            this.process = process;
            this.cache = cache;
            this.hints = hints;
            this.debug = debug;
            this.processStat = processStat;
            this.compiler = compiler;
        }
    }

    public static KMethodInfo compileMethod(CompileInfo compileInfo) {
        if (compileInfo.debug.isStat()) {
            if (compileInfo.cache.getStat() == null) {
                compileInfo.cache.setStat(new JJITMethodCompilerStat());
                compileInfo.processStat.methodstat.put(compileInfo.method.getAbsoluteSignature(), compileInfo.cache.getStat());
            }
        }
        if (compileInfo.debug.isDisassemble()) {
            disassembleMethod(compileInfo.method, compileInfo.debug);
        }
        if (compileInfo.method.isNative() /*|| process.existsNativeMethod(method.getSignature())*/) {
            //new JJITMethodDecoration(new String[]{"NATIVE " + method.getAbsoluteSignature()})
            return new KMethodInfo(
                    compileInfo.method.getModifiers(),
                    compileInfo.method.getSignature(),
                    compileInfo.method.getClassName(),
                    new JJITInstruction[]{new JJIT_JNI_CALL(compileInfo.method.getAbsoluteSignature())},
                    compileInfo.method.getTryCatchBlocs(),
                    JJITInstruction.class);
        } else if (compileInfo.method.isAbstract()) {
            //new JJITMethodDecoration(new String[]{"ABSTRACT " + method.getAbsoluteSignature()}),
            return new KMethodInfo(
                    compileInfo.method.getModifiers(),
                    compileInfo.method.getSignature(),
                    compileInfo.method.getClassName(),
                    new JJITInstruction[]{new JJIT_ABSTRACT_CALL(compileInfo.method.getAbsoluteSignature())},
                    compileInfo.method.getTryCatchBlocs(),
                    JJITInstruction.class);
        }

//        KMethodDef methodDefinition = method.getDefinition();

        final KInstructionDef[] codeDef = compileInfo.method.getCode();
        final String[] codeDebugInfo = new String[codeDef.length];
        IntHashMap labelsMap = new IntHashMap();
        KTryCatchDef[] blocs0 = compileInfo.method.getTryCatchBlocs();
        for (KTryCatchDef bloc : blocs0) {
            labelsMap.put(bloc.getFrom(), -1);
            labelsMap.put(bloc.getTo(), -1);
            labelsMap.put(bloc.getTarget(), -1);
        }
        JJITInstructionDef[] instructionDefs = new JJITInstructionDef[codeDef.length];
        Exception errFact = null;
        Object[] objConstantsPool = compileInfo.method.getParentClass().getConstantsPool();
        for (int i = 0; i < instructionDefs.length; i++) {
            try {
                final JJITInstructionDef ii = factory.createInstruction(i, codeDef[i], objConstantsPool);
                instructionDefs[i] = ii;
                codeDebugInfo[i] = i + ": " + ii.toString();
                for (int lab : ii.getLabels()) {
                    labelsMap.put(lab, -1);
                }
            } catch (Exception e) {
                errFact = e;
                System.err.println(e);
            }
        }
        if (errFact != null) {
            throw new RuntimeException(errFact);
        }

//        for (Entry<Integer, Integer> entry : labelsMap.toMap().entrySet()) {
//            if(entry.getValue()==-1){
//                throw new RuntimeException("Bad very bad value");
//            }
//        }
        String packageName = JJITUtils.getPackageName(compileInfo.method, compileInfo.debug);
        JJITInstruction[] instructions = null;
        compileInfo.instructionDefs = instructionDefs;
        compileInfo.labelsMap = labelsMap;
        compileInfo.packageName = packageName;
        compileInfo.objConstantsPool = objConstantsPool;
        switch (compileInfo.debug.getProcessorType()) {
            case INTERPRET_ONLY: {
                instructions = process_INTERPRET_ONLY(compileInfo);
                break;
            }
            case LAZY_COMPILE: {
                instructions = process_LAZY_COMPILE(compileInfo);
                break;
            }
            case EAGER_COMPILE: {
                instructions = process_EAGER_COMPILE(compileInfo);
                break;
            }
        }

        KTryCatchDef[] blocs = new KTryCatchDef[blocs0.length];
        for (int ii = 0; ii < blocs0.length; ii++) {
            KTryCatchDef kTryCatchDef = blocs0[ii];
            blocs[ii] = new KTryCatchDef(
                    labelsMap.get(kTryCatchDef.getFrom(), -1),
                    labelsMap.get(kTryCatchDef.getTo(), -1),
                    labelsMap.get(kTryCatchDef.getTarget(), -1),
                    kTryCatchDef.getType());
        }
        return new KMethodInfo(
                compileInfo.method.getModifiers(),
                compileInfo.method.getSignature(),
                compileInfo.method.getClassName(),
                instructions,
                blocs,
                //                deco,
                JJITInstruction.class);
    }

    private static void newBloc(ArrayList<Object> instructions, ArrayList<JJITFlowControlNode> current, JJITDebug debug) {
        try {
            if (!current.isEmpty()) {
                final JJITFlowControlNode[] a = current.toArray(new JJITFlowControlNode[current.size()]);
                addInstr(a, instructions, debug);
            }
            current.clear();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private static JJITInstruction[] processUnbreakable(JJITInstructionDef[] definitions, CompileInfo compileInfo) {
        JJITLog.log("processUnbreakable " + compileInfo.method);
        Bloc gg = BlocParser.toBloc(compileInfo.cache.getFlowControl().getNodes());
        JJITFlowControlNode[] toJJITInstructionDef = BlocParser.toJJITInstructionDef(gg);
        JJITInstruction r = compile(toJJITInstructionDef, 0, 0, compileInfo);
        return new JJITInstruction[]{r};
    }

    private static JJITInstruction[] process_INTERPRET_ONLY(CompileInfo compileInfo) {
        compileInfo.hints.setHint(JJITMethodCompilerHints.ProcessorType.INTERPRETER);
        ArrayList<JJITInstruction> instructions = new ArrayList<JJITInstruction>();
        for (JJITInstructionDef d : compileInfo.instructionDefs) {
            for (String cls : d.getLoadingClasses()) {
                instructions.add(new JJIT_INITIALIZE_CLASS(cls));
            }
            instructions.add(d.createSingleInstruction(compileInfo.objConstantsPool, compileInfo.labelsMap));
        }
        if (compileInfo.debug.isLog()) {
            JJITLog.log("INTERPRET_ONLY : " + instructions.size() + " defs --> ");
        }
        return instructions.toArray(new JJITInstruction[instructions.size()]);
    }

    private static JJITInstruction[] process_LAZY_COMPILE(CompileInfo compileInfo) {
        switch (compileInfo.hints.getHint()) {
            case INTERPRETER: {
                compileInfo.hints.setHint(JJITMethodCompilerHints.ProcessorType.INTERPRETER);
                ArrayList<JJITInstruction> instructions = new ArrayList<JJITInstruction>();
                instructions.add(new JJIT_COMPILE());
                for (JJITInstructionDef d : compileInfo.instructionDefs) {
                    for (String cls : d.getLoadingClasses()) {
                        instructions.add(new JJIT_INITIALIZE_CLASS_AND_RECOMPILE(cls));
                    }
                    instructions.add(d.createSingleInstruction(compileInfo.objConstantsPool, compileInfo.labelsMap));
                }
                if (compileInfo.debug.isLog()) {
                    JJITLog.log("INTERPRET_ONLY : " + instructions.size() + " defs --> ");
                }
                return instructions.toArray(new JJITInstruction[instructions.size()]);
            }
            case COMPILER: {
                return process_EAGER_COMPILE(compileInfo);
            }
        }
        throw new IllegalArgumentException("Unsupported");
    }

    private static JJITInstruction[] process_EAGER_COMPILE(CompileInfo compileInfo) {
        ArrayList<Object> instructions = new ArrayList<Object>();

        JJITFlowControl flowControl = compileInfo.cache.getFlowControl();
        if (flowControl == null) {
            compileInfo.cache.setFlowControl(flowControl = new JJITFlowControl(compileInfo.instructionDefs, compileInfo.objConstantsPool, compileInfo.method));
        }
        if (flowControl.isUnbreakable(compileInfo.method.getClassName())) {
            return processUnbreakable(compileInfo.instructionDefs, compileInfo);
        }
        JJITTransformerContext ctx = new JJITTransformerContext(g2h, flowControl);
        JJITFlowControlNode[] nodes = flowControl.getNodes();
        ArrayList<JJITFlowControlNode> current = new ArrayList<JJITFlowControlNode>();
        boolean optRecompileOnClassLoaded = compileInfo.debug.isOptRecompileOnClassLoaded();
        KClassRepository classRepository;
        try {
            classRepository = compileInfo.process == null ? null : compileInfo.process.getClassRepository();
        } catch (Exception ex) {
            throw new IllegalArgumentException("Problem " + ex);
        }
        for (int i = 0; i < nodes.length; i++) {
            JJITFlowControlNode node = nodes[i];
            ctx.setNode(node);
//            final String[] loadingClasses = iinstr.getLoadingClasses(constPool);
            //boolean label=labelsMap.containsKey(i); //instruction.isLabel()??
//            final KOperator op = iinstr.getOperator();
            //int oldOrdinal = instruction.getOrdinal();
            //KInstruction instruction0 = instruction;
//            instruction = instruction0.clone();
//            ((KInstructionIdx) instruction).base = (KInstructionIdx) instruction0;
            node.instruction0 = node.instruction;
            node.instruction = node.instruction.transform(ctx);
            for (String cls : node.instruction.getLoadingClasses()) {
                if (optRecompileOnClassLoaded) {
                    if (!compileInfo.method.getClassName().equals(cls)) {
                        boolean initializable = true;
                        try {
                            if (classRepository != null) {
                                initializable = classRepository.getClassByName(cls).isInitializable();
                            }
                        } catch (Exception ex) {
                            //
                        }
                        if (initializable) {
                            if (!flowControl.isInitializedInParent(i, cls)) {
                                newBloc(instructions, current, compileInfo.debug);
                                addInstr(new JJIT_INITIALIZE_CLASS_AND_RECOMPILE(cls), instructions, compileInfo.debug);
                            }
                        }
                    }
                } else {
                    //TODO : if class not initialized!!
                    if (!compileInfo.method.getClassName().equals(cls)) {
                        if (!flowControl.isInitializedInParent(i, cls)) {
                            newBloc(instructions, current, compileInfo.debug);
                            addInstr(new JJIT_INITIALIZE_CLASS(cls), instructions, compileInfo.debug);
                        }
                    }
                }
            }
            if (compileInfo.labelsMap.containsKey(i)) {
                newBloc(instructions, current, compileInfo.debug);
                current.add(node);
                compileInfo.labelsMap.put(i, instructions.size());
            } else {
                current.add(node);
            }
            if (node.instruction.isJump()) {
                newBloc(instructions, current, compileInfo.debug);
            }
        }
        newBloc(instructions, current, compileInfo.debug);

        int x = 0;
        int arr1 = 0;
        int arrN = 0;
        int arrNS = 0;
        int init = 0;
        boolean stat = compileInfo.debug.isStat();
        JJITMethodCompilerStat s = null;
        if (stat) {
            s = compileInfo.cache.getStat();
        }
        for (int i = 0; i < instructions.size(); i++) {
            Object object = instructions.get(i);
            if (object instanceof JJITFlowControlNode[]) {
                final JJITFlowControlNode[] darr = (JJITFlowControlNode[]) object;
                int length = darr.length;
                switch (length) {
                    case 1: {
                        JJITInstructionDef ii = darr[0].getInstruction();
                        setInstr(i, ii.createSingleInstruction(compileInfo.objConstantsPool, compileInfo.labelsMap), instructions);
                        arr1 += length;
                        if (stat) {
                            IntHashMap m = s.getPrivateCompileSize();
                            m.put(length, m.get(length, 0) + 1);
                        }
                        break;
                    }
                    case 2: {
                        JJITInstructionDef a = darr[0].getInstruction();
                        JJITInstructionDef b = darr[1].getInstruction();
                        if (a.isSharable() && b.isSharable()) {
                            setInstr(i, compileShared(darr, x, compileInfo), instructions);
                            arrNS += length;
                            arrN++;
                            if (stat) {
                                IntHashMap m = s.getSharedCompileSize();
                                m.put(length, m.get(length, 0) + 1);
                            }
                        } else {
                            setInstr(i, compile(darr, i, x, compileInfo), instructions);
                            arrNS += length;
                            arrN++;
                            if (stat) {
                                IntHashMap m = s.getPrivateCompileSize();
                                m.put(length, m.get(length, 0) + 1);
                            }
                        }
                        break;
                    }
                    default: {
                        setInstr(i, compile(darr, i, x, compileInfo), instructions);
                        arrNS += length;
                        arrN++;
                        if (stat) {
                            IntHashMap m = s.getPrivateCompileSize();
                            m.put(length, m.get(length, 0) + 1);
                        }
                        break;
                    }
                }
                x += length;
            } else {
                //initilialize ==> no x++;
                init++;
                if (stat) {
                    s.getExtraCompileSize().inc(object.getClass().getSimpleName());
                }
            }
        }
        if (compileInfo.debug.isLog()) {
            JJITLog.log(nodes.length + " defs --> " + instructions.size() + " = " + (arrN) + " multiple (" + (((double) arrNS) / arrN) + ") + " + arr1 + " single + " + init + " init");
        }
        if (stat) {
            s.setInitialSize(nodes.length);
            s.setFinalSize(instructions.size());
        }
        return instructions.toArray(new JJITInstruction[instructions.size()]);
    }

    private static JJITInstruction compile(JJITFlowControlNode[] blocInstructions, int blocIndex, int startIndex, CompileInfo compileInfo) {
        try {
            JJITFlowControl flowControl = compileInfo.cache.getFlowControl();
            if (compileInfo.debug.getClassIndex() > 0 && (blocIndex + 1) != compileInfo.debug.getClassIndex()) {
                return null;
            }
            if (blocInstructions.length == 1) {
                throw new RuntimeException("Unsupported array count " + blocInstructions.length);
//                final JJITInstructionDef ii = blocInstructions[0].getInstruction();
//                if(debug.isLog()){
//                    JJITLog.log("Compile Single Block "+(blocIndex + 1));
//                }
//                return ii.createSingleInstruction(objConstantsPool, labelsMap);
            } else {
                final String className = compileInfo.method.getName().replace("<", "_").replace(">", "_") + "_" + DF.format(blocIndex + 1);
                if (compileInfo.debug.isLog()) {
                    JJITLog.log("Compile Bulk Block [" + (blocIndex + 1) + "] of " + blocInstructions.length + " instructions : " + className + " : " + Arrays.asList(blocInstructions));
                }
                //                final JJITInstructionDef[] instructions1 = bloc.getInstructions();
                String fullClassName = compileInfo.packageName + "." + className;
                Class<JJITInstruction> jitInstrClass = null;
                if (compileInfo.debug.isOptCacheClasses()) {
                    jitInstrClass = (Class<JJITInstruction>) compiler.loadCached(compileInfo.packageName, className);
                    if (jitInstrClass != null) {
                        if (compileInfo.debug.isLog()) {
                            JJITLog.log(":::: perfect, reloaded from cache " + fullClassName);
                        }
                    }
                }
                if (jitInstrClass == null) {
                    final JJITClassSource cs = new JJITClassSource(compileInfo.method, compileInfo.packageName, className, blocInstructions, compileInfo.labelsMap, compileInfo.objConstantsPool, blocIndex, flowControl, startIndex, compileInfo.debug);
                    cs.build();
                    jitInstrClass = compiler.compile(compileInfo.packageName, className, cs);
                }
                return (jitInstrClass.newInstance());
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private static JJITInstruction compileShared(JJITFlowControlNode[] blocInstructions, int startIndex, CompileInfo compileInfo) {
        try {
            JJITFlowControl flowControl = compileInfo.cache.getFlowControl();
            int hash = 0;
            for (JJITFlowControlNode blocInstruction : blocInstructions) {
                hash = hash * 31 + blocInstruction.getInstruction().hashCode();
            }
            //blocInstructions.length == 2
            JJITFlowControlNode a = blocInstructions[0];
            JJITFlowControlNode b = blocInstructions[1];
            JJITInstructionDef ai = a.getInstruction();
            JJITInstructionDef bi = b.getInstruction();
            JJITInstruction simple = SharedInstructionFactory.create(ai, bi);
            if (simple != null) {
                return simple;
            }
            final String className = ai.getShareName() + "_" + bi.getShareName();
            if (compileInfo.debug.isLog()) {
                JJITLog.log("Compile Shared Block of " + blocInstructions.length + " instructions : " + className + " : " + Arrays.asList(blocInstructions));
            }
            if (compileInfo.debug.isStat()) {
                JJITSharedBlocKey sk = new JJITSharedBlocKey(ai, bi);
                compileInfo.processStat.sharedBlocsCountDetails.inc(sk);
            }
            //                final JJITInstructionDef[] instructions1 = bloc.getInstructions();
            String pkg = "jjit.shared";
            String fullClassName = pkg + "." + className;
            Class<JJITInstruction> jitInstrClass = null;
            if (compileInfo.debug.isOptCacheClasses()) {
                jitInstrClass = (Class<JJITInstruction>) compiler.loadCached(pkg, className);
                if (jitInstrClass != null) {
                    if (compileInfo.debug.isLog()) {
                        JJITLog.log(":::: perfect, reloaded from cache " + fullClassName);
                    }
                }
            }
            if (jitInstrClass == null) {
                final JJITClassSource cs = new JJITClassSource(compileInfo.method, pkg, className, blocInstructions, compileInfo.labelsMap, compileInfo.objConstantsPool, Integer.MIN_VALUE, flowControl, startIndex, compileInfo.debug);
//                cs.setSharedMode(true);
                cs.build();
                jitInstrClass = compiler.compile(pkg, className, cs);
            }

            JJITInstruction ii = jitInstrClass.newInstance();
            return ii;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private static String getPreferredInstName(JJITInstructionDef i) {
        StringBuilder b = new StringBuilder();
        b.append(i.getOperator());
        switch (i.getOperator()) {
            case ALOAD:
            case ALOAD_0:
            case ALOAD_1:
            case ALOAD_2:
            case ALOAD_3: {
                b.append(i.getReadLocal());
                break;
            }
            case BIPUSH: {
                b.append(((JJIT_BIPUSH) i).getValue());
                break;
            }
            default: {
                throw new IllegalArgumentException("Not yet supported");
            }
        }
        if (i.getReadLocal() != -1) {
            b.append(i.getReadLocal());
        } else if (i.getWriteLocal() != -1) {
            b.append(i.getWriteLocal());
        }
        return b.toString();
    }

    private static void setInstr(int index, JJITInstruction i, ArrayList<Object> instructions) {
//        assert log("============> " + index + " : " + i);
        instructions.set(index, i);
    }

    private static void addInstr(Object i, ArrayList<Object> instructions, JJITDebug debug) {
        if (debug.isLog()) {
//            if (i instanceof JJITFlowControlNode[]) {
//                JJITFlowControlNode[] a = (JJITFlowControlNode[]) i;
//                StringBuilder ss = new StringBuilder();
//                for (JJITFlowControlNode d : a) {
//                    ss.append(" ").append(d.toString());
//                }
//                JJITLog.log("addInstr["+instructions.size()+"]  Array  : " + " [count=" + a.length + "]" + ss);
//            } else {
//                JJITLog.log("addInstr["+instructions.size()+"]  Simple "+i+" : " + (instructions.size() + 1) + " : " + i);
//            }
        }

        instructions.add(i);
    }

    public static String getSharedVarName(int instrIndex, int index) {
        return "share_" + instrIndex + "_" + index;
    }
}
