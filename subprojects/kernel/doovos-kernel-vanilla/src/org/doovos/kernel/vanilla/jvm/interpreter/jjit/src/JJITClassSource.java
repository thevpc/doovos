/**
 * ====================================================================
 *             Doovos (Distributed Object Oriented Operating System)
 *
 * Doovos is a new Open Source Distributed Object Oriented Operating System
 * Design and implementation based on the Java Platform.
 * Actually, it is a try for designing a distributed operation system in
 * top of existing centralized/network OS.
 * Designed OS will follow the object oriented architecture for redefining
 * all OS resources (memory,process,file system,device,...etc.) in a highly
 * distributed context.
 * Doovos is also a distributed Java virtual machine that implements JVM
 * specification on top the distributed resources context.
 *
 * Doovos Kernel is the heart of Doovos OS. It implements also the Doovos JVM
 * Doovos Kernel code is executed on host JVM
 *
 * Copyright (C) 2008-2010 Taha BEN SALAH
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, writeSource to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 * ====================================================================
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src;

import org.doovos.kernel.api.jvm.bytecode.KMethodDef;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.core.util.IntHashMap;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.compiler.JJITWriter;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.debug.JJITDebug;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControl;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlNode;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITConstant;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITExpression;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITKRegisterConstant;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITName;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Calls;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Types;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITDecField;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITDecVar;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITInstr;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JavaSourceLayout;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.TypeStruct;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.*;

public class JJITClassSource implements JJITWriter {

    private List<String> imports = new ArrayList<String>();
    private JJITMethodSourceRun run;
    private JJITMethodSourceInit init;
    private HashMap<String, JJITDecField> fields = new LinkedHashMap<String, JJITDecField>();
    private JJITVarHelper varHelper = new JJITVarHelper("c_");
    private JJITFlowControlNode[] nodes;
    private IntHashMap labels;
    private Object[] constants;
    private JJITDebug debug;
    private String packageName;
    private String className;
    private String fullClassName;
    private KMethodDef baseMethod;
    private JJITFlowControl flowControl;
    private int flowControlIndex;
    private int blocIndex;
    private boolean sharedMode;

    /**
     * source compile a subsequentlist of instructions (bloc instruction)
     *
     * @param packageName
     * @param className
     * @param instructions
     * @param labels
     * @param constants
     * @param blocIndex        bloc index
     * @param flowControl
     * @param flowControlIndex the index of the first instrcution in the bloc among ALL method nstructions
     * @param debug
     */
    public JJITClassSource(KMethodDef baseMethod, String packageName, String className, JJITFlowControlNode[] instructions, IntHashMap labels, Object[] constants, int blocIndex, JJITFlowControl flowControl, int flowControlIndex, JJITDebug debug) {
        this.baseMethod = baseMethod;
        this.blocIndex = blocIndex;
        this.packageName = packageName;
        this.className = className;
        this.fullClassName = packageName + "." + className;
        this.debug = debug;
        this.nodes = instructions;
        this.labels = labels;
        this.constants = constants;
        this.flowControl = flowControl;
        this.flowControlIndex = flowControlIndex;
        run = new JJITMethodSourceRun(this);
        init = new JJITMethodSourceInit(this);
    }

    public int getBlocIndex() {
        return blocIndex;
    }

    public JJITFlowControl getFlowControl() {
        return flowControl;
    }

    public int getFlowControlIndex() {
        return flowControlIndex;
    }

    public JJITFlowControlNode[] getInstructions() {
        return nodes;
    }

    public JJITDebug getDebug() {
        return debug;
    }

    public String getClassName() {
        return className;
    }

    public String getFullClassName() {
        return fullClassName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void build() {
        int relativeIndex=0;
        run.init();
        init.init();
        for (JJITFlowControlNode nn : nodes) {
            run.setCurrentNode(nn);
            nn.getInstruction().visit(this, nn, relativeIndex++);
        }
        run.build();
        init.build();

        if (debug.isOptSimplify()) {
            HashSet<String> usedVars = new HashSet<String>();
            for (JJITInstr i : run.getBaseBloc().getInstructions()) {
                usedVars.addAll(i.getReadVars());
            }
            for (JJITInstr i : init.getBaseBloc().getInstructions()) {
                usedVars.addAll(i.getReadVars());
            }
            HashSet<String> fieldNames = new HashSet<String>(fields.keySet());
            for (String s : fieldNames) {
                if(!usedVars.contains(s)){
                   fields.remove(s);
                }
            }
//            }
        }
    }

    //    public String prepareClass(String classPath) {
//        String v = getClassVar(classPath);
//        return "if(" + v + "==null){\n"
//                + "  " + v + "=repository.getClassByName(\"" + classPath + "\");\n"
//                + "}\n";
//    }
    public String getClassVar(String className) {
        return className.replace(";", "_").replace("/", "_").replace(".", "_");
    }

    public String getMethodVar(String methodName) {
        return methodName.replace(";", "_").replace("/", "_").replace(".", "_").replace("(", "_").replace(")", "_");
    }

    public Object getConstant(int index) {
        return constants[index];
    }

    public Object[] getConstants() {
        return constants;
    }

    public int getLabel(int pos) {
        return labels.get(pos, pos);
    }

    //    public IntHashMap getLabels() {
//        return labels;
//    }
//    public String toVar(String cls) {
//        return cls.replace('.', '$');
//    }
    public JJITMethodSourceRun run() {
        return run;
    }

    public JJITName createVar(TypeStruct type, String prefix, Object... obj) {
        return new JJITName(varHelper.createVar(prefix, obj), type);
    }

    public JJITMethodSourceInit init() {
        return init;
    }

    public JJITClassSource defineImport(TypeStruct imports) {
        this.imports.add(imports.getName());
        return this;
    }

    public JJITClassSource defineImport(String imports) {
        this.imports.add(imports);
        return this;
    }

    public List<String> getImports() {
        return imports;
    }

    public JJITName declareConst(int index) {
        Object val = constants[index];
        if (val instanceof Integer) {
            return declareConst(new KInteger((Integer) val));
        }
        if (val instanceof Long) {
            return declareConst(new KLong((Long) val));
        }
        if (val instanceof Short) {
            return declareConst(new KShort((Short) val));
        }
        if (val instanceof Float) {
            return declareConst(new KFloat((Float) val));
        }
        if (val instanceof Double) {
            return declareConst(new KDouble((Double) val));
        }
        if (val instanceof String) {
            return declareConst(new KInitConst(index));
        }
        throw new IllegalArgumentException("Unsupported const type");
    }

    public JJITName declareConst(KRegister val) {

        if (val instanceof KInitConst) {
            KInitConst k = (KInitConst) val;
            TypeStruct kreferenceType = Types.KREFERENCE;
            JJITName n = new JJITName("R" + k.constId, kreferenceType);
            JJITExpression e = JJITConstant.NULL;
            init.set(n, init().constants().arr(k.constId).cast(kreferenceType));
            declareField(new JJITDecField(Modifier.PRIVATE | Modifier.STATIC, kreferenceType, n.getValue(), e));
            return n;
        } else {
            JJITKRegisterConstant e = new JJITKRegisterConstant(val);
            TypeStruct typeName = null;
            switch (e.getRegType()) {
                case INTEGER: {
                    typeName = Types.KINTEGER;
                    break;
                }
                case LONG: {
                    typeName = Types.KLONG;
                    break;
                }
                case SHORT: {
                    typeName = Types.KSHORT;
                    break;
                }
                case BYTE: {
                    typeName = Types.KBYTE;
                    break;
                }
                case CHAR: {
                    typeName = Types.KCHAR;
                    break;
                }
                case DOUBLE: {
                    typeName = Types.KDOUBLE;
                    break;
                }
                case FLOAT: {
                    typeName = Types.KFLOAT;
                    break;
                }
                case BOOLEAN: {
                    typeName = Types.KBOOLEAN;
                    break;
                }
                case RETURN: {
                    typeName = Types.KRETURN;
                    break;
                }
            }
            declareField(new JJITDecField(Modifier.PRIVATE | Modifier.STATIC | Modifier.FINAL, typeName, e.getPreferredName(), e));
            return new JJITName(e.getPreferredName(), typeName);
        }
    }

    public JJITName declareFieldNext() {
        return declareField(Types.JJITINSTRUCTION, "next", "JJITInstruction:next", null);
    }

    public JJITName declareFieldLabel() {
        return declareField(Types.JJITINSTRUCTION, "label", "JJITInstruction:label", null);
    }

    public JJITName declareField(TypeStruct type, String prefix, String id, JJITExpression initVal) {
        final JJITName n = createVar(type, prefix, id);
        defineImport(type);
        JJITDecField v = new JJITDecField(Modifier.PRIVATE, type, n.getValue(), initVal);
        declareField(v);
        return n;
    }

    public JJITName getFieldVarById(String id, TypeStruct type) {
        String varById = varHelper.getVarById(id);
        return varById == null ? null : new JJITName(varById, type);
    }

    public boolean isDeclaredFieldById(String id) {
        return varHelper.exists(id);
    }

    public JJITName declareField(TypeStruct type, String prefix, JJITExpression initVal) {
        final JJITName n = createVar(type, prefix);
        JJITDecField v = new JJITDecField(Modifier.PRIVATE, type, n.getValue(), initVal);
        declareField(v);
        return n;
    }

    public JJITClassSource declareField(JJITDecField v) {
        for (String gg : v.getReadVars()) {
            if (fields.containsKey(gg)) {
                //ok
            } else {
                throw new NoSuchElementException("unknown field var " + gg);
            }
        }
        if (!fields.containsKey(v.getName())) {
            fields.put(v.getName(), v);
        }
        return this;
    }

    public JJITDecField[] getFields() {
        return fields.values().toArray(new JJITDecField[fields.size()]);
    }

    public void write(PrintStream out) {
        JavaSourceLayout layout = new JavaSourceLayout("    ", getDebug().isNoComments(), true);
        JavaSourceLayout layout2 = layout.indent(2);
        TreeSet<String> _imports = new TreeSet<String>();
        _imports.add(JJITInstruction.class.getPackage().getName() + ".*");
//        _imports.add(KClassDef.class.getPackage().getName() + ".*");
//        _imports.add(KClass.class.getPackage().getName() + ".*");
//        _imports.add(KMemoryManager.class.getPackage().getName() + ".*");
//        _imports.add(KOperator.class.getPackage().getName() + ".*");
        _imports.add(KFrame.class.getPackage().getName() + ".*");
        _imports.add(KRegister.class.getPackage().getName() + ".*");
        _imports.add(KLocalThread.class.getName());
//        imports.add("java.rmi.RemoteException");
        //_imports.add(packageName + ".*");
//        imports.add(packageName + ".instr.*");
        ArrayList<JJITDecField> _fields = new ArrayList<JJITDecField>();
        ArrayList<JJITDecVar> initVars = new ArrayList<JJITDecVar>();

        _imports.addAll(this.getImports());
        initVars.addAll(Arrays.asList(this.init().getVars()));
        _fields.addAll(Arrays.asList(this.getFields()));
        //String className = "JITSRC_" + String.valueOf(Math.random()).replace(".", "_0").replace("-", "_1").replace("+", "_2");
        out.println("package " + packageName + ";");
        for (String ai : _imports) {
            out.println("import " + ai + ";");
        }
        StringBuilder dump = new StringBuilder("[count=").append(nodes.length).append("]");
        for (JJITFlowControlNode d : nodes) {
            dump.append(" ").append(d.toString());
        }
        out.println("/**");
        out.println(" * " + baseMethod.getClassName());
        out.println(" * " + baseMethod.getSignature());
        out.println(" * " + dump);
        out.println(" */");
        out.println("public final class " + className + " extends JJITAbstractInstruction implements Cloneable{");
        for (JJITDecField ai : _fields) {
            ai.writeSource(out, layout2);
//            out.println();
        }
//        out.println("  public " + className + "(){");
//        //out.println("    super(KOperator.X_USER_DEFINED);");
//        out.println("  }");
        run.writeSource(out, layout2);
        init.writeSource(out, layout2);
//        out.println("  public JJITInstruction clone(){");
//        out.println("    try {");
//        out.println("      return (JJITInstruction)super.clone();");
//        out.println("    } catch (CloneNotSupportedException e) {");
//        out.println("      throw new IllegalArgumentException(\"Clone unsupported\",e);");
//        out.println("    }");
//        out.println("  }");
        out.println("}");
    }

    public void write(PrintWriter out) {
        JavaSourceLayout layout = new JavaSourceLayout("    ", getDebug().isNoComments(), true);
        JavaSourceLayout layout2 = layout.indent(2);
        TreeSet<String> _imports = new TreeSet<String>();
        _imports.add(JJITInstruction.class.getPackage().getName() + ".*");
//        _imports.add(KClassDef.class.getPackage().getName() + ".*");
//        _imports.add(KClass.class.getPackage().getName() + ".*");
//        _imports.add(KMemoryManager.class.getPackage().getName() + ".*");
//        _imports.add(KOperator.class.getPackage().getName() + ".*");
        _imports.add(KFrame.class.getPackage().getName() + ".*");
        _imports.add(KRegister.class.getPackage().getName() + ".*");
        _imports.add(KLocalThread.class.getName());
//        imports.add("java.rmi.RemoteException");
        //_imports.add(packageName + ".*");
//        imports.add(packageName + ".instr.*");
        ArrayList<JJITDecField> _fields = new ArrayList<JJITDecField>();
        ArrayList<JJITDecVar> initVars = new ArrayList<JJITDecVar>();

        _imports.addAll(this.getImports());
        initVars.addAll(Arrays.asList(this.init().getVars()));
        _fields.addAll(Arrays.asList(this.getFields()));
        //String className = "JITSRC_" + String.valueOf(Math.random()).replace(".", "_0").replace("-", "_1").replace("+", "_2");
        out.println("package " + packageName + ";");
        for (String ai : _imports) {
            out.println("import " + ai + ";");
        }
        StringBuilder dump = new StringBuilder("[count=").append(nodes.length).append("]");
        for (JJITFlowControlNode d : nodes) {
            dump.append(" ").append(d.toString());
        }
        out.println("/**");
        out.println(" * " + baseMethod.getClassName());
        out.println(" * " + baseMethod.getSignature());
        out.println(" * " + dump);
        out.println(" */");
        out.println("public final class " + className + " implements JJITInstruction, java.io.Serializable,Cloneable{");
        for (JJITDecField ai : _fields) {
            ai.writeSource(out, layout2);
            out.println();
        }
        out.println("  public " + className + "(){");
        //out.println("    super(KOperator.X_USER_DEFINED);");
        out.println("  }");
        run.writeSource(out, layout2);
        init.writeSource(out, layout2);
        out.println("  public JJITInstruction clone(){");
        out.println("    try {");
        out.println("      return (JJITInstruction)super.clone();");
        out.println("    } catch (CloneNotSupportedException e) {");
        out.println("      throw new IllegalArgumentException(\"Clone unsupported\",e);");
        out.println("    }");
        out.println("  }");
        out.println("}");
    }

    @Override
    public String toString() {
        return "JJITClassSource{" + "fullClassName=" + fullClassName + '}';
    }

    public JJITName declareMemMan() {
        Class<KMemoryManager> clazz = KMemoryManager.class;
        defineImport(Types.KMEMORYMANAGER);
        String kMemoryManager = clazz.getName();
        JJITName memman = getFieldVarById(kMemoryManager, Types.KMEMORYMANAGER);
        if (memman != null) {
            return memman;
        }
        memman = declareField(Types.KMEMORYMANAGER, "memman", kMemoryManager, null);
        init().set(memman, init().process().call(Calls.KProcess_getMemoryManager));
        return memman;
    }

    public JJITName declareRepo() {
        Class<KClassRepository> clazz = KClassRepository.class;
        defineImport(Types.KCLASSREPOSITORY);
        JJITName memman = getFieldVarById(clazz.getName(), Types.KCLASSREPOSITORY);
        if (memman != null) {
            return memman;
        }
        memman = declareField(Types.KCLASSREPOSITORY, "repo", clazz.getSimpleName(), null);
        init().set(memman, init().process().call(Calls.KProcess_getClassRepository));
        return memman;
    }

    public KMethodDef getBaseMethod() {
        return baseMethod;
    }

    public boolean isSharedMode() {
        return sharedMode;
    }

    public void setSharedMode(boolean sharedMode) {
        this.sharedMode = sharedMode;
    }
}
