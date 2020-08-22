/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit;

import org.doovos.kernel.api.jvm.bytecode.KMethodDef;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.debug.JJITDebug;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlNode;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstructionDef;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITExpression;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITName;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsage;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsageList;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsageType;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.unbrekable.*;

import java.io.*;
import java.util.HashMap;

/**
 * @author vpc
 */
public final class JJITUtils {

    public static final String JIT_CLASS_NAME_PREFIX = "JITSRC_";

    private JJITUtils() {
    }

    public static void saveObject(File physicalName, Object object) throws IOException {
        ObjectOutputStream oos = null;
        try {
            physicalName.getParentFile().mkdirs();
            oos = new ObjectOutputStream(new FileOutputStream(physicalName));
            oos.writeObject(object);
            oos.close();
        } finally {
            if (oos != null) {
                oos.close();
            }
        }
    }

    public static Object loadObject(File physicalName, final ClassLoader loader) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(physicalName)) {

                private final HashMap primClasses = new HashMap(8, 1.0F);

                {
                    primClasses.put("boolean", boolean.class);
                    primClasses.put("byte", byte.class);
                    primClasses.put("char", char.class);
                    primClasses.put("short", short.class);
                    primClasses.put("int", int.class);
                    primClasses.put("long", long.class);
                    primClasses.put("float", float.class);
                    primClasses.put("double", double.class);
                    primClasses.put("void", void.class);
                }

                protected Class<?> resolveClass(ObjectStreamClass desc)
                        throws IOException, ClassNotFoundException {
                    String name = desc.getName();
                    try {
                        return Class.forName(name, false, loader);
                    } catch (ClassNotFoundException ex) {
                        Class cl = (Class) primClasses.get(name);
                        if (cl != null) {
                            return cl;
                        } else {
                            throw ex;
                        }
                    }
                }
            };
            return ois.readObject();
        } finally {
            if (ois != null) {
                ois.close();
            }
        }
    }

    public static String getPackageName(KMethodDef method, JJITDebug debug) {
        StringBuilder p = new StringBuilder();
        p.append("jjit.local.");
        p.append(method.getClassName());
        p.append('.');
        p.append(escapeMethodName(method, debug));
//        p.append('.');
//        p.append("S").append(Integer.toHexString(hints.hashCode()*31+debug.hashCode()).toUpperCase());
        String ps = debug.getPackageSuffix();
        if (ps != null) {
            p.append('.');
            p.append(ps);
        }
        return p.toString();
    }

    public static String getPackageName(KMethod method, JJITMethodCompilerHints hints, JJITDebug debug) {
        StringBuilder p = new StringBuilder();
        p.append("jjit.");
        p.append(method.getClassName());
        p.append('.');
        p.append(escapeMethodName(method, debug));
        p.append('.');
        p.append("S").append(Integer.toHexString(hints.hashCode()*31+debug.hashCode()).toUpperCase());
        String ps = debug.getPackageSuffix();
        if (ps != null) {
            p.append('.');
            p.append(ps);
        }
        return p.toString();
    }

    public static String guessLocalType(JJITFlowControlNode[] instructions, int var) {
        String t = null;
        for (JJITFlowControlNode node : instructions) {
            JJITInstructionDef instruction = node.getInstruction();
            if (instruction instanceof JJITInstructionDefBlocIF) {
                t = combine(t, guessLocalType(((JJITInstructionDefBlocIF) instruction).getBloc(), var));
            } else {
                t = combine(t, guessLocalType(node.getInstruction(), var));
            }
        }
        if (t != null && t.equals("?")) {
            return null;
        }
        return t;
    }

    private static String combine(String oldValue, String newValue) {
        if (oldValue == null) {
            return newValue;
        }
        if (newValue == null) {
            return oldValue;
        }
        if (oldValue.equals(newValue)) {
            return newValue;
        } else {
            return "?";
        }
    }

    private static String guessLocalType(Bloc bloc, int var) {
        if (bloc instanceof BlocItem) {
            BlocItem i = (BlocItem) bloc;
            return guessLocalType(i.getInstruction(), var);
        } else if (bloc instanceof BlocList) {
            BlocList list = (BlocList) bloc;
            String t = null;
            for (Bloc item : list) {
                t = combine(t, guessLocalType(item, var));
            }
            return t;
        } else if (bloc instanceof BlocIF) {
            BlocIF f = (BlocIF) bloc;
            String t = null;
            t = combine(t, guessLocalType(f.getTrueBloc(), var));
            if (f.getFalseBloc() != null) {
                t = combine(t, guessLocalType(f.getFalseBloc(), var));
            }
            return t;
        }
        return null;
    }

    public static String guessLocalType(JJITInstructionDef instruction, int var) {
        switch (instruction.getOperator()) {
            case IINC: {
                if (instruction.getWriteLocal() == var) {
                    return "I";
                }
                break;
            }
            case ISTORE:
            case ISTORE_0:
            case ISTORE_1:
            case ISTORE_2:
            case ISTORE_3: {
                if (instruction.getWriteLocal() == var) {
                    return "I";
                }
                break;
            }
            case ILOAD:
            case ILOAD_0:
            case ILOAD_1:
            case ILOAD_2:
            case ILOAD_3: {
                if (instruction.getReadLocal() == var) {
                    return "I";
                }
                break;
            }
            case LSTORE:
            case LSTORE_0:
            case LSTORE_1:
            case LSTORE_2:
            case LSTORE_3: {
                if (instruction.getWriteLocal() == var) {
                    return "J";
                }
                break;
            }
            case LLOAD:
            case LLOAD_0:
            case LLOAD_1:
            case LLOAD_2:
            case LLOAD_3: {
                if (instruction.getReadLocal() == var) {
                    return "J";
                }
                break;
            }
            case DSTORE:
            case DSTORE_0:
            case DSTORE_1:
            case DSTORE_2:
            case DSTORE_3: {
                if (instruction.getWriteLocal() == var) {
                    return "D";
                }
                break;
            }
            case DLOAD:
            case DLOAD_0:
            case DLOAD_1:
            case DLOAD_2:
            case DLOAD_3: {
                if (instruction.getReadLocal() == var) {
                    return "D";
                }
                break;
            }
            case FSTORE:
            case FSTORE_0:
            case FSTORE_1:
            case FSTORE_2:
            case FSTORE_3: {
                if (instruction.getWriteLocal() == var) {
                    return "F";
                }
                break;
            }
            case FLOAD:
            case FLOAD_0:
            case FLOAD_1:
            case FLOAD_2:
            case FLOAD_3: {
                if (instruction.getReadLocal() == var) {
                    return "F";
                }
                break;
            }
            case ASTORE:
            case ASTORE_0:
            case ASTORE_1:
            case ASTORE_2:
            case ASTORE_3: {
                if (instruction.getWriteLocal() == var) {
                    return "Ljava.lang.Object;";
                }
                break;
            }
            case ALOAD:
            case ALOAD_0:
            case ALOAD_1:
            case ALOAD_2:
            case ALOAD_3: {
                if (instruction.getReadLocal() == var) {
                    return "Ljava.lang.Object;";
                }
            }
        }
        return null;
    }

    public static String escapeMethodName(KMethod method, JJITDebug debug) {
        String m = method.getSignature();
        if (debug.isMethodHashId()) {
            m += ("_" + Integer.toHexString(method.hashCode()).toUpperCase());
        }
        StringBuilder sb = new StringBuilder();
        int len = m.length();
        for (int i = 0; i < len; i++) {
            char c = m.charAt(i);
            switch (c) {
                case '(': {
                    sb.append("_");
                    break;
                }
                case ')': {
                    sb.append("_");
                    break;
                }
                case ';': {
                    sb.append("");
                    break;
                }
                case '[': {
                    sb.append("_");
                    break;
                }
                case '<': {
                    sb.append("_");
                    break;
                }
                case '>': {
                    sb.append("_");
                    break;
                }
                case '/': {
                    sb.append("_");
                    break;
                }
                case '.': {
                    sb.append("_");
                    break;
                }
                case '-': {
                    sb.append("_");
                    break;
                }
                case '+': {
                    sb.append("_");
                    break;
                }
                case '_': {
                    sb.append("_");
                    break;
                }
                default: {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public static String escapeMethodName(KMethodDef method, JJITDebug debug) {
        String m = method.getSignature();
        if (debug.isMethodHashId()) {
            m += ("_" + Integer.toHexString(method.hashCode()).toUpperCase());
        }
        StringBuilder sb = new StringBuilder();
        int len = m.length();
        for (int i = 0; i < len; i++) {
            char c = m.charAt(i);
            switch (c) {
                case '(': {
                    sb.append("_");
                    break;
                }
                case ')': {
                    sb.append("_");
                    break;
                }
                case ';': {
                    sb.append("");
                    break;
                }
                case '[': {
                    sb.append("_");
                    break;
                }
                case '<': {
                    sb.append("_");
                    break;
                }
                case '>': {
                    sb.append("_");
                    break;
                }
                case '/': {
                    sb.append("_");
                    break;
                }
                case '.': {
                    sb.append("_");
                    break;
                }
                case '-': {
                    sb.append("_");
                    break;
                }
                case '+': {
                    sb.append("_");
                    break;
                }
                case '_': {
                    sb.append("_");
                    break;
                }
                default: {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public static void fillNamesIntoUsageList(JJITExpression e, JJITVarUsageList list, JJITVarUsageType type, String... names) {
        if (e instanceof JJITName) {
            JJITName arName = (JJITName) e;
            for (String n : names) {
                if (arName.getValue().equals(n)) {
                    list.add(new JJITVarUsage(arName, type));
                    return;
                }
            }
        }
    }

    public static boolean isName(JJITExpression e, String name) {
        return (e instanceof JJITName) && ((JJITName) e).getValue().equals(name);
    }

    public static String stringifyForName(int i) {
        if (i < 0) {
            return "M" + i;
        } else {
            return String.valueOf(i);
        }
    }

    public static String stringifyForName(long i) {
        if (i < 0) {
            return "M" + i;
        } else {
            return String.valueOf(i);
        }
    }

    public static String stringifyForName(double i) {
        if (Double.isInfinite(i)) {
            if (i > 0) {
                return "PInf";
            } else {
                return "NInf";
            }
        } else if (Double.isNaN(i)) {
            return "NaN";
        } else {
            String s = String.valueOf(i);
            s = s.replace('.', '_');
            s = s.replace('+', '_');
            s = s.replace('-', 'M');
            return s;
        }
    }

    public static String stringifyForName(float i) {
        if (Float.isInfinite(i)) {
            if (i > 0) {
                return "PInf";
            } else {
                return "NInf";
            }
        } else if (Float.isNaN(i)) {
            return "NaN";
        } else {
            String s = String.valueOf(i);
            s = s.replace('.', '_');
            s = s.replace('+', '_');
            s = s.replace('-', 'M');
            return s;
        }
    }
}
