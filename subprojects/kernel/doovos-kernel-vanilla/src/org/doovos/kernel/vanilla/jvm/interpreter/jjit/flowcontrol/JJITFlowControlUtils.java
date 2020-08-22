package org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol;

import org.doovos.kernel.api.util.EmptyArray;
import org.doovos.kernel.core.util.IntArray;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITCall;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITExpression;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITName;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsageList;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITCommentInstr;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITInstr;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class JJITFlowControlUtils {

    //    public static final TreeSet<String> REG_TYPES = new TreeSet<String>(Arrays.asList("KDouble", "KInteger", "KFloat", "KLong"));
//    public static final Set<Class> MOVEABLE_EXPRS = new HashSet<Class>(Arrays.asList(
//            JJITName.class,
//            JJITMath.class));
//    private static final int[] INTS = new int[0];

    /**
     * given a position (offset) look after the first instruction in the reverse order that updates the var value (i.e. the last update)
     * This gives the expression to inline
     *
     * @param name         var name
     * @param instructions instructions
     * @param offset       last index to look into
     * @return instr position
     */
//    public static int getLastUpdatedVarInstr(String name, JJITInstr[] instructions, int offset) {
//        for (int i = offset; i >= 0; i--) {
//            JJITInstr ii = instructions[i];
//            if (ii.isVarUpdated(name)) {
//                return i;
//            }
//        }
//        return -1;
//    }

    /**
     * return instr positions where var named "name" was used in read mode before being first updated
     * if the var is used more than one in an instruction, the index is returned accordingly
     *
     * @param name var name
     *             //     * @param instructions instr array
     *             //     * @param offset       start instr index, typically the one following the var update
     * @return index positions where the var was used before being overridden or updated
     */
    public static int[] getSubstitutableInstructionIndices(JJITName name, JJITExpression expression, JJITFlowIterator flowIterator) {
        JJITInstr[] instructions = flowIterator.getArray();
        int offset = flowIterator.getStart();
        int end = flowIterator.getEnd();
        IntArray usagesBeforeUpdate = new IntArray();
        int readsBeforeUpdate = 0;
        int readsAfterUpdate = 0;
        boolean writeOrSet = false;
        boolean writeAlways = false;
        String varName = name.getValue();
        for (int i = offset + 1; i < end; i++) {
            JJITInstr ii = instructions[i];
            JJITVarUsageList usage = ii.getVarUsage(varName);
            if (!writeOrSet) {
                int b = usage.getReadsBeforeWriteOrSet(varName);
                int a = usage.getReadsAfterWriteOrSet(varName);
                if (b > 0) {
                    usagesBeforeUpdate.add(i);
                    readsBeforeUpdate += b;
                }
                readsAfterUpdate += a;
            } else {
                readsAfterUpdate += usage.getReads(varName);
            }
            if (usage.isWriteAlways(varName)) {
                writeAlways = true;
                break; //ignore the rest of updates!!
            } else if (usage.isWriteOrSet(varName)) {
                writeOrSet = true;
            }
        }
        int count = usagesBeforeUpdate.size();
        if ((!writeOrSet)) {
            if (isReadBeforeUpdate(name, flowIterator.getParent())) {
                return EmptyArray.INTS;
            }
        }
        if (readsBeforeUpdate == 0) {
            //should check parent from THIS index

            //variable not used
            if (isReadBeforeUpdate(name, flowIterator.getParent())) {
                return EmptyArray.INTS;
            }
            for (String v : expression.getVars()) {
                JJITVarUsageList u = expression.getVarUsage(v);
                if (u.isWriteOrSet(v)) {
                    return EmptyArray.INTS;
                }
            }
            return null;
        }
        if (readsAfterUpdate > 0) {
            return EmptyArray.INTS;
        }
        if (readsBeforeUpdate > 0) {
            if (readsBeforeUpdate > 1) {
                for (String v : expression.getVars()) {
                    JJITVarUsageList u = expression.getVarUsage(v);
                    if (u.isWriteOrSet(v)) {
                        return EmptyArray.INTS;
                    }
                }
                for (String v : expression.getVars()) {
                    JJITVarUsageList u = expression.getVarUsage(v);
                    if (u.isWriteOrSet(v)) {
                        return EmptyArray.INTS;
                    }
                }
                // if heavy return false
                // check is the expression is heavy
                Collection<JJITExpression> allExpressions = expression.getAllExpressions();
                int weight = allExpressions.size();
                if (weight > 3) {
                    //It is heavy
                    return EmptyArray.INTS;
                }
                for (JJITExpression allExpression : allExpressions) {
                    if (allExpression instanceof JJITCall) {
                        //It is heavy
                        return EmptyArray.INTS;
                    }
                }
            }

            if (!isMoveExpressionPossible(expression, name, new JJITFlowIterator(
                    flowIterator.getParent(),
                    instructions, offset, usagesBeforeUpdate.get(count - 1) + 1

            ))) {
                return EmptyArray.INTS;
            }
        }
        return usagesBeforeUpdate.toArray();
    }

    private static boolean isReadBeforeUpdate(JJITName name, JJITFlowIterator flowIterator) {
        String n = name.getValue();
        HashSet<String> u = new HashSet<String>();
        u.add(n);
        while (flowIterator != null) {
            JJITInstr[] aee = flowIterator.getArray();
            int end = flowIterator.getEnd();
            for (int i = flowIterator.getStart(); i < end; i++) {
                if (aee[i].getVarUsage(n).isReadBeforeUpdate(n, u)) {
                    return true;
                }
            }
            flowIterator = flowIterator.getParent();
        }
        return false;
    }


    public static boolean isMoveExpressionPossible(JJITExpression expression, JJITName as, JJITFlowIterator flowIterator) {
        JJITInstr[] instructions = flowIterator.getArray();
        int from = flowIterator.getStart();
        int to = flowIterator.getEnd() - 1;

        Set<String> vars = expression.getVars();
        Set<String> vars2 = new HashSet<String>(vars);
        vars2.add(as.getValue());
        String[] vars2Arr = vars2.toArray(new String[vars2.size()]);
        for (int x = from + 1; x < to; x++) {
            JJITInstr ii = instructions[x];
            JJITVarUsageList usage = ii.getVarUsage(vars2Arr);
            for (String n : vars2Arr) {
                if (usage.isWriteOrSet(n)) {
                    return false;
                }
            }
        }
        JJITVarUsageList pusage = instructions[to].getVarUsage(vars2Arr);
        if (!pusage.isReadBeforeUpdate(as.getValue(), vars)) {
            return false;
        }
        return true;
    }

    public static JJITInstr comment(String debug, JJITInstr ii) {
        String s = ii.toString();
        return new JJITCommentInstr(false, "**REMOVED " + debug + "** " + s);
    }
}
