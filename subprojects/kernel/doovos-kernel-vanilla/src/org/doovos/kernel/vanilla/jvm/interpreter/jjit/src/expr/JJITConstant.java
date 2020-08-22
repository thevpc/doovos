/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.pattern.JJITPattern;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.pattern.JJITPatternUtils;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsageList;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Types;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITDecField;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITDecVar;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.TypeStruct;

/**
 *
 * @author vpc
 */
public class JJITConstant extends JJITExpressionImpl {

    private String expression;
    private Object object;
    private TypeStruct expressionType;
    public static final JJITConstant NULL = new JJITConstant(null,"null", Types.VOID);
    public static final JJITConstant KREFERENCE_NULL = new JJITConstant(KReference.NULL,"KReference.NULL", Types.VOID);
    public static final JJITConstant TRUE = asBool(true);
    public static final JJITConstant FALSE = asBool(false);
    public static final JJITConstant I0 = asInt(0);
    public static final JJITConstant I1 = asInt(1);
    public static final JJITConstant IM1 = asInt(-1);

    public JJITConstant(Object object,String expression,TypeStruct type) {
        this.object = object;
        this.expression = expression;
        this.expressionType = type;
    }

    public TypeStruct getExpressionType() {
        return expressionType;
    }


    public JJITExpression simplify(Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap) {
        return this;
    }

    public JJITVarUsageList getVarUsage(String ... names) {
        return new JJITVarUsageList();
    }

    protected Map<JJITPattern, JJITExpression> matchesImpl(JJITExpression o, Map<JJITPattern, JJITExpression> ee) {
        JJITConstant other = (JJITConstant) o;
        if (!JJITPatternUtils.matches(expression, expression)) {
            return null;
        }
        return ee;
    }

//    public boolean isReadVar(String name) {
//        return false;
//    }
//
//    public boolean isWriteVar(String name) {
//        return false;
//    }

    public static JJITConstant asBool(boolean v) {
        return new JJITConstant(v,String.valueOf(v), Types.BOOLEAN);
    }

    public static JJITConstant asString(String s) {
        //TODO fix me
        return new JJITConstant(s,"\"" + s + "\"", Types.STRING);
    }

    public static JJITConstant asInt(int s) {
        //TODO fix me
        return new JJITConstant(s,String.valueOf(s), Types.INT);
    }

    public static JJITConstant asDouble(double s) {
        //TODO fix me
        return new JJITConstant(s,String.valueOf(s) + "D", Types.DOUBLE);
    }

    public static JJITConstant asLong(long s) {
        //TODO fix me
        return new JJITConstant(s,String.valueOf(s) + "L", Types.LONG);
    }

    public static JJITConstant asFloat(float s) {
        //TODO fix me
        return new JJITConstant(s,String.valueOf(s) + "f", Types.FLOAT);
    }

    public void write(PrintStream out) {
        out.print(expression);
    }

    public void write(PrintWriter out) {
        out.print(expression);
    }

    public JJITExpression replace(JJITExpression a, JJITExpression b) {
        if (a.equals(this)) {
            return b.copy();
        }
        return copy();
    }

    public JJITExpression copy() {
        return new JJITConstant(object, expression,expressionType);
    }

    public Collection<JJITExpression> getChildren() {
        return Collections.EMPTY_LIST;
    }

    public Object getObject() {
        return object;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JJITConstant that = (JJITConstant) o;

        if (expression != null ? !expression.equals(that.expression) : that.expression != null) return false;
        if (expressionType != null ? !expressionType.equals(that.expressionType) : that.expressionType != null)
            return false;
        if (object != null ? !object.equals(that.object) : that.object != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = expression != null ? expression.hashCode() : 0;
        result = 31 * result + (object != null ? object.hashCode() : 0);
        result = 31 * result + (expressionType != null ? expressionType.hashCode() : 0);
        return result;
    }
}
