/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.pattern.JJITPattern;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.pattern.JJITPatternUtils;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITDecField;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITDecVar;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.FieldStruct;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.MethodStruct;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.TypeStruct;

/**
 *
 * @author vpc
 */
public abstract class JJITExpressionImpl implements JJITExpression {

    private JJITExpression parent;

    public JJITExpression getParent() {
        return parent;
    }

    public void setParent(JJITExpression parent) {
//        if (this.parent != null && this.parent!=parent) {
//            throw new IllegalArgumentException("Why?");
//        }
        this.parent = parent;
    }

//    public JJITExpressionImpl cast(Class type) {
//        return cast(type.getName());
//    }
    
//    public JJITExpressionImpl cast(String type) {
//        return new JJITCast(this, type);
//    }
    
    public JJITExpressionImpl cast(TypeStruct type) {
        return new JJITCast(this, type);
    }

    public JJITExpressionImpl call(MethodStruct method,Object... args) {
        return new JJITCall(this, method,toEarr(args));
    }

    public JJITExpression incPost() {
        return new JJITInc(this, true, false);
    }

    public JJITExpression incPre() {
        return new JJITInc(this, true, true);
    }

    public JJITExpression decPost() {
        return new JJITInc(this, false, false);
    }

    public JJITExpression decPre() {
        return new JJITInc(this, false, true);
    }

    public JJITExpressionImpl arr(Object... args) {
        return new JJITArr(this, toEarr(args));
    }

    public JJITExpressionImpl field(FieldStruct field) {
        return new JJITField(this, field);
    }

    private JJITExpression[] toEarr(Object[] e) {
        JJITExpression[] cc = new JJITExpression[e.length];
        for (int i = 0; i < cc.length; i++) {
            cc[i] = toE(e[i]);
        }
        return cc;
    }

    private JJITExpression toE(Object e) {
        if (e == null) {
            return JJITConstant.NULL.copy();
        }
        if (e instanceof JJITExpression) {
            return (JJITExpression) e;
        }
        if (e instanceof String) {
            return JJITConstant.asString((String) e);
        }
        if (e instanceof Integer) {
            return JJITConstant.asInt((Integer) e);
        }
        if (e instanceof Double) {
            return JJITConstant.asDouble((Double) e);
        }
        if (e instanceof Long) {
            return JJITConstant.asLong((Long) e);
        }
        if (e instanceof Float) {
            return JJITConstant.asFloat((Float) e);
        }
        if (e instanceof Boolean) {
            return JJITConstant.asBool((Boolean) e);
        }
        throw new IllegalArgumentException("Insupportable " + e);
    }

    public JJITExpressionImpl not() {
        return new JJITNot(this);
    }

    public JJITExpressionImpl neg() {
        return new JJITNeg(this);
    }

    public JJITExpressionImpl add(Object e) {
        return add(toE(e));
    }

    public JJITExpressionImpl sub(Object e) {
        return sub(toE(e));
    }

    public JJITExpressionImpl div(Object e) {
        return div(toE(e));
    }

    public JJITExpressionImpl mul(Object e) {
        return mul(toE(e));
    }

    public JJITExpressionImpl calc(JJITMathOp op, JJITExpression e) {
        return new JJITMath(op, this, e);
    }

    public JJITExpressionImpl add(JJITExpression e) {
        return new JJITMath(JJITMathOp.ADD, this, e);
    }

    public JJITExpressionImpl bitor(JJITExpression e) {
        return new JJITMath(JJITMathOp.OR, this, e);
    }

    public JJITExpressionImpl sub(JJITExpression e) {
        return new JJITMath(JJITMathOp.SUB, this, e);
    }

    public JJITExpressionImpl ne(JJITExpression e) {
        return cmp(JJITCmpOp.NE, e);
    }

    public JJITExpressionImpl eq(JJITExpression e) {
        return cmp(JJITCmpOp.EQ, e);
    }

    public JJITExpressionImpl lt(JJITExpression e) {
        return cmp(JJITCmpOp.LT, e);
    }

    public JJITExpressionImpl gt(JJITExpression e) {
        return cmp(JJITCmpOp.GT, e);
    }

    public JJITExpressionImpl and(JJITExpression e) {
        return cmp(JJITCmpOp.AND, e);
    }

    public JJITExpressionImpl or(JJITExpression e) {
        return cmp(JJITCmpOp.OR, e);
    }

    public JJITExpressionImpl cmp(JJITCmpOp op, JJITExpression e) {
        return new JJITCmp(op, this, e);
    }

    public JJITExpressionImpl ge(JJITExpression e) {
        return cmp(JJITCmpOp.GE, e);
    }

    public JJITExpressionImpl le(JJITExpression e) {
        return cmp(JJITCmpOp.LE, e);
    }

    public JJITExpressionImpl div(JJITExpression e) {
        return new JJITMath(JJITMathOp.DIV, this, e);
    }

    public JJITExpressionImpl mul(JJITExpression e) {
        return new JJITMath(JJITMathOp.MUL, this, e);
    }

    @Override
    public String toString() {
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baos);
        write(out);
        return baos.toString();
    }

    public boolean contains(JJITExpression expr) {
        Stack<JJITExpression> s = new Stack<JJITExpression>();
        s.addAll(getChildren());
        while (!s.isEmpty()) {
            JJITExpression a = s.pop();
            if (a.equals(expr)) {
                return true;
            }
            for (JJITExpression c : a.getChildren()) {
                s.push(c);
            }
        }
        return false;
    }

    public final List<JJITExpression> getAllExpressions() {
        List<JJITExpression> e = new ArrayList<JJITExpression>();
        e.add(this);
        e.addAll(getDeepChildren());
        return e;
    }

    public Collection<JJITExpression> getDeepChildren() {
        ArrayList<JJITExpression> all = new ArrayList<JJITExpression>();
        Stack<JJITExpression> s = new Stack<JJITExpression>();
        s.addAll(getChildren());
        while (!s.isEmpty()) {
            JJITExpression a = s.pop();
            all.add(a);
            for (JJITExpression c : a.getChildren()) {
                s.push(c);
            }
        }
        return all;
    }

    public Set<String> getVars() {
        HashSet<String> all = new HashSet<String>();
        for (JJITExpression n : getDeepChildren()) {
            if (n instanceof JJITName) {
                all.add(((JJITName) n).getValue());
            }
        }
        return all;
    }

    public Map<JJITPattern, JJITExpression> matches(JJITExpression o) {
        HashMap<JJITPattern, JJITExpression> ee = new HashMap<JJITPattern, JJITExpression>();
        switch (JJITPatternUtils.matches0(this, o, ee)) {
            case JJITPatternUtils.MATCH_OK: {
                return ee;
            }
            case JJITPatternUtils.MATCH_KO: {
                return null;
            }
        }
        return matchesImpl(o, ee);
    }

    protected abstract Map<JJITPattern, JJITExpression> matchesImpl(JJITExpression o, Map<JJITPattern, JJITExpression> ee);


    protected JJITExpression simplifyChild(JJITExpression e,Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap){
        e = e == null ? JJITConstant.NULL.copy() : e.simplify(fields,varsMap);
        e.setParent(this);
        return e;
    }
}
