/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;

import org.doovos.kernel.vanilla.jvm.interpreter.jjit.JJITUtils;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITArr;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITConstant;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITExpression;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITName;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsage;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsageList;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsageType;

/**
 *
 * @author vpc
 */
public class JJITSet extends JJITInstrImpl {

    private JJITExpression left;
    private JJITExpression right;

    public JJITSet(JJITExpression a, JJITExpression b) {
        this.left = a;
        this.right = b == null ? JJITConstant.NULL : b;
    }

    public JJITInstr simplify(Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap) {
        this.left=left.simplify(fields, varsMap);
        this.right=right==null?null:right.simplify(fields, varsMap);
        return this;
    }

    public JJITInstr replaceReads(JJITExpression a, JJITExpression b) {
        return new JJITSet(this.left, this.right.replace(a, b));
    }

    public JJITVarUsageList getVarUsage(String... names) {
        JJITVarUsageList list = new JJITVarUsageList();
        list.addAll(right.getVarUsage(names));
        if (left instanceof JJITArr) {
            JJITArr ar = (JJITArr) getLeft();
            JJITExpression arExpr = ar.getExpression();
            list.addAll(arExpr.getVarUsage(names));
            for (JJITExpression z : ar.getArgs()) {
                list.addAll(z.getVarUsage(names));
            }
            JJITUtils.fillNamesIntoUsageList(arExpr, list, JJITVarUsageType.SETTER, names);
        } else if (left instanceof JJITName) {
            JJITUtils.fillNamesIntoUsageList(left, list, JJITVarUsageType.WRITE, names);
        } else {
            throw new IllegalArgumentException("Unsupported");
        }
        return list;
    }

//    @Override
//    public boolean isVarRead(String name) {
//        return left.isReadVar(name) || right.isReadVar(name);
//    }
//
//    @Override
//    public boolean isVarUpdated(String name) {
//        return (left instanceof JJITName && ((JJITName)left).getValue().equals(name)) || left.isWriteVar(name) || right.isWriteVar(name);
//    }
    @Override
    public Collection<JJITExpression> getExpressions() {
        ArrayList<JJITExpression> all = new ArrayList<JJITExpression>();
        all.add(left);
        all.add(right);
        all.addAll(left.getDeepChildren());
        all.addAll(right.getDeepChildren());
        return all;
    }

    public void writeSource(PrintStream out, JavaSourceLayout layout) {
        out.print(layout.getIndent());
        left.write(out);
        out.print(" = ");
        right.write(out);
        out.print(";");
        if (layout.isNewLine()) {
            out.println();
        }
    }

    public void writeSource(PrintWriter out, JavaSourceLayout layout) {
        out.print(layout.getIndent());
        left.write(out);
        out.print(" = ");
        right.write(out);
        out.print(";");
        if (layout.isNewLine()) {
            out.println();
        }
    }

    public JJITExpression getLeft() {
        return left;
    }

    public JJITExpression getRight() {
        return right;
    }

    @Override
    public int getVarReadCount(String name) {
        int x = 0;
        JJITExpression a = getRight();
        if (a instanceof JJITName) {
            JJITName n = (JJITName) a;
            if (n.getValue().equals(name)) {
                x++;
            }
        } else {
            for (JJITExpression expression : a.getDeepChildren()) {
                if (expression instanceof JJITName) {
                    JJITName n = (JJITName) expression;
                    if (n.getValue().equals(name)) {
                        x++;
                    }
                }
            }
        }
        if (getLeft() instanceof JJITArr) {
            JJITArr ar = (JJITArr) getLeft();
            for (JJITExpression expression : ar.getDeepChildren()) {
                if (expression instanceof JJITName) {
                    JJITName n = (JJITName) expression;
                    if (n.getValue().equals(name)) {
                        x++;
                    }
                }
            }
        }
        return x;
    }

    public List<JJITExpression> getRootReadExpressions() {
        ArrayList<JJITExpression> a = new ArrayList<JJITExpression>();
        a.add(right);
        if (getLeft() instanceof JJITArr) {
            JJITArr ar = (JJITArr) getLeft();
            a.addAll(Arrays.asList(ar.getArgs()));
        }
        return a;
    }

    @Override
    public JJITExpression[] getReadExpressions() {
        ArrayList<JJITExpression> all = new ArrayList<JJITExpression>();
        JJITExpression a = getRight();
        all.addAll(a.getAllExpressions());
        if (getLeft() instanceof JJITArr) {
            JJITArr ar = (JJITArr) getLeft();
            all.addAll(ar.getDeepChildren());
        }
        return all.toArray(new JJITExpression[all.size()]);
    }

    @Override
    public Set<String> getReadVars() {
        if (left instanceof JJITName) {
            return right.getVars();
        }
        HashSet<String> all = new HashSet<String>();
        all.addAll(left.getVars());
        all.addAll(right.getVars());
        return all;
    }
}
