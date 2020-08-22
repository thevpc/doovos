/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr;

import java.util.*;

import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITCmp;
import java.io.PrintStream;
import java.io.PrintWriter;

import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITCmpOp;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITExpressionImpl;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITExpression;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITName;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsageList;

/**
 *
 * @author vpc
 */
public class JJITBloc extends JJITInstrImpl {

    protected List<JJITInstr> list;

    protected JJITBloc(List<JJITInstr> list) {
        this.list = list;
    }

    public JJITBloc() {
        list = new ArrayList<JJITInstr>();
    }

    public JJITInstr simplify(Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i,list.get(i).simplify(fields, varsMap));
        }
        return this;
    }

    public List<JJITExpression> getRootReadExpressions() {
        ArrayList<JJITExpression> all = new ArrayList<JJITExpression>();
        for (JJITInstr ii : list) {
            all.addAll(ii.getRootReadExpressions());
        }
        return all;
    }
    

    @Override
    public JJITExpression[] getReadExpressions() {
        ArrayList<JJITExpression> all = new ArrayList<JJITExpression>();
        for (JJITInstr ii : list) {
            all.addAll(Arrays.asList(ii.getReadExpressions()));
        }
        return all.toArray(new JJITExpression[all.size()]);
    }

    @Override
    public Collection<JJITExpression> getExpressions() {
        ArrayList<JJITExpression> all = new ArrayList<JJITExpression>();
        for (JJITInstr li : list) {
            all.addAll(li.getExpressions());
        }
        return all;
    }

    public void removeInstr(int index) {
        list.remove(index);
    }

    public JJITInstr replaceReads(JJITExpression a, JJITExpression b) {
        List<JJITInstr> list2 = new ArrayList<JJITInstr>();
        Set<String> updatedVars = a.getVars();
        boolean noreplace = false;
        for (JJITInstr i : list) {
            if (!noreplace) {
                for (String v : updatedVars) {
                    if(i.getVarUsage(v).isWriteOrSet(v)){
                        noreplace = true;
                    }
                }
                list2.add(i.replaceReads(a, b));
            } else {
                list2.add(i);
            }
        }
        return new JJITBloc(list2);
    }

//    @Override
//    public boolean isVarRead(String name) {
//        for (JJITInstr ii : list) {
//            if (ii.isVarRead(name)) {
//                return true;
//            }
//        }
//        return false;
//    }

//    @Override
//    public boolean isVarUpdated(String name) {
//        for (JJITInstr ii : list) {
//            if (ii.isVarUpdated(name)) {
//                return true;
//            }
//        }
//        return false;
//    }

    public JJITVarUsageList getVarUsage(String ... names) {
        JJITVarUsageList found=new JJITVarUsageList();
        for (JJITInstr ii : list) {
            found.addAll(ii.getVarUsage(names));
        }
        return found;
    }

    public List<JJITInstr> getInstructions() {
        return list;
    }

    public JJITBloc addCode(JJITExpressionImpl e) {
        return addCode(new JJITExprInstr(e));
    }

    public JJITBloc lineComment(String cmt) {
        return addCode(new JJITCommentInstr(false, cmt));
    }

    public JJITBloc multiLineComment(String cmt) {
        return addCode(new JJITCommentInstr(true, cmt));
    }

    public JJITBloc insertCode(JJITInstr e,int index) {
        list.add(index,e);
        return this;
    }
    public JJITBloc addCode(JJITInstr e) {
        list.add(e);
        return this;
    }

    public void writeSource(PrintStream out, JavaSourceLayout layout) {
        for (JJITInstr e : list) {
            e.writeSource(out, layout);
        }
    }

    public void writeSource(PrintWriter out, JavaSourceLayout layout) {
        for (JJITInstr e : list) {
            e.writeSource(out, layout);
        }
    }

//    public JJITBloc set(String a, JJITExpression b) {
//        return set(new JJITName(a), b);
//    }

    public JJITBloc set(JJITExpressionImpl a, JJITExpression b) {
        addCode(new JJITSet(a, b));
        return this;
    }

    public JJITBloc Return(JJITExpression e) {
        return addCode(new JJITReturn(e));
    }

    public JJITBloc Return() {
        return addCode(new JJITReturn(null));
    }

    public JJITIf If(JJITExpression e) {
        JJITIf i = new JJITIf(e, new JJITBloc(), new JJITBloc());
        addCode(i);
        return i;
    }

    public JJITIf If(JJITCmpOp op, JJITExpression a, JJITExpression b) {
        JJITIf i = new JJITIf(new JJITCmp(op, a, b), new JJITBloc(), new JJITBloc());
        addCode(i);
        return i;
    }

    public JJITFor For(JJITInstr dec, JJITExpression cond, JJITExpression inc) {
        JJITFor i = new JJITFor(dec, cond, inc);
        addCode(i);
        return i;
    }

    public void clear() {
        list.clear();
    }

    public void addAll(List<JJITInstr> other) {
        list.addAll(other);
    }
}
