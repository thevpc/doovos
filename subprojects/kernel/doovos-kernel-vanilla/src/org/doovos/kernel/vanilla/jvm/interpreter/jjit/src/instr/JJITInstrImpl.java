/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.JJITUtils;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITCall;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITExpression;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITName;

/**
 *
 * @author vpc
 */
public abstract class JJITInstrImpl implements JJITInstr {

    @Override
    public String toString() {
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baos);
        writeSource(out, new JavaSourceLayout("", false, true));
        return baos.toString();
    }

    public boolean contains(JJITExpression expr) {
        return getExpressions().contains(expr);
    }

    public abstract Collection<JJITExpression> getExpressions();

//    public boolean isReadVar(String name) {
//        return false;
//    }
//
//    public boolean isWriteVar(String name) {
//        return false;
//    }
    public int getVarReadCount(String name) {
        int x = 0;
        for (JJITExpression expression : this.getExpressions()) {
            if (JJITUtils.isName(expression, name)) {
                x++;
            }
        }
        return x;
    }

    public JJITExpression[] getReadExpressions(JJITExpression n) {
        List<JJITExpression> found = new ArrayList<JJITExpression>();
        for (JJITExpression expression : this.getReadExpressions()) {
            if (expression.equals(n)) {
                found.add(n);
            }
        }
        return found.toArray(new JJITExpression[found.size()]);
    }

    public boolean containsReadExpressions(JJITExpression n) {
        for (JJITExpression expression : this.getReadExpressions()) {
            if (expression.equals(n)) {
                return true;
            }
        }
        return false;
    }

    public JJITExpression[] getReadExpressions() {
        ArrayList<JJITExpression> all = new ArrayList<JJITExpression>();
        all.addAll(this.getExpressions());
        return all.toArray(new JJITExpression[all.size()]);
    }

    public Set<String> getReadVars() {
        HashSet<String> all = new HashSet<String>();
        for (JJITExpression expression : this.getExpressions()) {
            if (expression instanceof JJITName) {
                all.add(((JJITName) expression).getValue());
            }
        }
        return all;
    }
    private static Set<String> GETTERS = new HashSet<String>(Arrays.asList(
            "isNull", "isNotNull",
            "intValue", "doubleValue", "longValue", "floatValue", "byteValue", "charValue", "shortValue", "booleanValue"));

    public boolean isVarContentUpdated(String n) {
        for (JJITExpression expression : getExpressions()) {
            if (expression instanceof JJITCall) {
                JJITCall c = (JJITCall) expression;
                String method = c.getMethodName();
                //getters are ignored!
                if (!method.startsWith("get") && !GETTERS.contains(method)) {
                    for (String r : c.getVar().getVars()) {
                        if (r.equals(n)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
