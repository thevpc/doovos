package org.doovos.kernel.vanilla.jvm.interpreter.jjit;

import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlUtils;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowIterator;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Calls;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Fields;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Types;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.FieldStruct;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.MethodStruct;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.TypeStruct;

import java.util.*;

public class JJITOptimizer {

    private static final Map<TypeStruct, MethodStruct> INLINE_CONSTRUCTORS = new HashMap<TypeStruct, MethodStruct>();
    private static final Map<MethodStruct, TypeStruct> INV_INLINE_CONSTRUCTORS = new HashMap<MethodStruct, TypeStruct>();
    private static final Map<FieldStruct, JJITConstant> CONSTANTS = new HashMap<FieldStruct, JJITConstant>();

    static {
        INLINE_CONSTRUCTORS.put(Types.KINTEGER, Calls.KRegister_intValue);
        INLINE_CONSTRUCTORS.put(Types.KDOUBLE, Calls.KRegister_doubleValue);
        INLINE_CONSTRUCTORS.put(Types.KLONG, Calls.KRegister_longValue);

        INV_INLINE_CONSTRUCTORS.put(Calls.KRegister_intValue, Types.KINTEGER);
        INV_INLINE_CONSTRUCTORS.put(Calls.KRegister_doubleValue, Types.KDOUBLE);
        INV_INLINE_CONSTRUCTORS.put(Calls.KRegister_longValue, Types.KLONG);
        INV_INLINE_CONSTRUCTORS.put(Calls.KRegister_floatValue, Types.KFLOAT);
        CONSTANTS.put(Fields.KInteger_M1, JJITConstant.IM1);
        CONSTANTS.put(Fields.KInteger_ZERO, JJITConstant.I0);
        CONSTANTS.put(Fields.KInteger_ONE, JJITConstant.I1);
    }

    public static void performSubstitution(JJITFlowIterator flowIterator, boolean simplify, Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap) {

        JJITInstr[] rinstructions = flowIterator.getArray();
        int start = flowIterator.getStart();
        int end = flowIterator.getEnd();
        for (int i = start; i < end; i++) {
            JJITInstr ii = rinstructions[i];
            if (simplify) {
                rinstructions[i]= ii = ii.simplify(fields, varsMap);
            }
            if ((ii instanceof JJITCommentInstr)) {
                //ignore
            } else if (ii instanceof JJITIf) {
                JJITIf e = (JJITIf) ii;

                JJITBloc then2 = e.Then();
                if (then2 != null) {
                    List<JJITInstr> li = then2.getInstructions();
                    JJITInstr[] arr = li.toArray(new JJITInstr[li.size()]);
                    performSubstitution(new JJITFlowIterator(new JJITFlowIterator(
                            flowIterator.getParent(),
                            flowIterator.getArray(),
                            i + 1,
                            end
                    ), arr, 0, arr.length), simplify, fields, varsMap);
                    then2 = new JJITBloc();
                    then2.addAll(Arrays.asList(arr));
                }
                JJITBloc else2 = e.Else();
                if (else2 != null) {
                    List<JJITInstr> li = else2.getInstructions();
                    JJITInstr[] arr = li.toArray(new JJITInstr[li.size()]);
                    performSubstitution(new JJITFlowIterator(new JJITFlowIterator(
                            flowIterator.getParent(),
                            flowIterator.getArray(),
                            i + 1,
                            end
                    ), arr, 0, arr.length), simplify, fields, varsMap);
                    else2 = new JJITBloc();
                    else2.addAll(Arrays.asList(arr));
                }
                rinstructions[i] = new JJITIf(e.getCondition(), then2, else2);
            } else if (ii instanceof JJITSet) {
                JJITSet iiset = (JJITSet) ii;
                JJITExpression replacement = iiset.getRight();
                if (iiset.getLeft() instanceof JJITName) {
                    JJITName var = (JJITName) iiset.getLeft();
                    JJITFlowIterator pFlowIterator = new JJITFlowIterator(
                            flowIterator.getParent(),
                            rinstructions, i, flowIterator.getEnd()
                    );
                    int[] indices = JJITFlowControlUtils.getSubstitutableInstructionIndices(var, replacement, pFlowIterator);
                    if (indices == null) {
                        //variable not used
                        rinstructions[i] = JJITFlowControlUtils.comment("Not used", rinstructions[i]);
                    } else if (indices.length > 0) {
                        for (int p : indices) {
                            rinstructions[p] = rinstructions[p].replaceReads(var, replacement);
                        }
                        rinstructions[i] = JJITFlowControlUtils.comment("Substitution", rinstructions[i]);
                    }
                }

            }
        }
        if(simplify){
            commentUnusedDeclarations(rinstructions);
        }
    }

    public static void performSimplify(JJITInstr[] rinstructions, Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap) {
//        JJITExpressionImpl this_ref = new JJITName("this_ref");
//        JJITExpressionImpl this_ref_casted = new JJITName("this_ref").cast("KReference");
        for (int i = 0; i < rinstructions.length; i++) {
            rinstructions[i] = rinstructions[i].simplify(fields, varsMap);
        }
        commentUnusedDeclarations(rinstructions);
    }

    private static JJITInstr simplifyReplacement(JJITInstr ii, JJITExpression oldExpr, JJITExpression newExpr) {
        return ii.replaceReads(oldExpr, newExpr);
    }

    private static void commentUnusedDeclarations(JJITInstr[] all) {
        HashSet<String> usedVars = new HashSet<String>();
        for (JJITInstr i : all) {
            if (!(i instanceof JJITDecVar)) {
                usedVars.addAll(i.getReadVars());
            }
        }
        for (int i = 0; i < all.length; i++) {
            JJITInstr jjitInstr = all[i];
            if (jjitInstr instanceof JJITDecVar) {
                JJITDecVar v = (JJITDecVar) jjitInstr;
                if (!usedVars.contains(v.getName())) {
                    all[i] = JJITFlowControlUtils.comment("Unused Var", all[i]);
                }
            }
        }

    }

    private static JJITExpression convertToFloat(JJITExpression e) {
        TypeStruct expressionType = e.getExpressionType();
        if (expressionType.equals(Types.FLOAT)) {
            return e;
        }
        if (e instanceof JJITCall) {
            JJITCall call = (JJITCall) e;
            if (Types.isKRegister(call.getVar().getExpressionType())) {
                return new JJITCall(call.getVar(), Calls.KRegister_floatValue);
            }
        }
        return new JJITCast(e, Types.FLOAT);
    }

    private static JJITExpression convertToDouble(JJITExpression e) {
        TypeStruct expressionType = e.getExpressionType();
        if (expressionType.equals(Types.DOUBLE)) {
            return e;
        }
        if (e instanceof JJITCall) {
            JJITCall call = (JJITCall) e;
            if (Types.isKRegister(call.getVar().getExpressionType())) {
                return new JJITCall(call.getVar(), Calls.KRegister_doubleValue);
            }
        }
        return new JJITCast(e, Types.DOUBLE);
    }

    private static JJITExpression convertToLong(JJITExpression e) {
        TypeStruct expressionType = e.getExpressionType();
        if (expressionType.equals(Types.LONG)) {
            return e;
        }
        if (e instanceof JJITCall) {
            JJITCall call = (JJITCall) e;
            if (Types.isKRegister(call.getVar().getExpressionType())) {
                return new JJITCall(call.getVar(), Calls.KRegister_longValue);
            }
        }
        return new JJITCast(e, Types.LONG);
    }

    private static JJITExpression convertToInt(JJITExpression e) {
        TypeStruct expressionType = e.getExpressionType();
        if (expressionType.equals(Types.INT)) {
            return e;
        }
        if (e instanceof JJITCall) {
            JJITCall call = (JJITCall) e;
            if (Types.isKRegister(call.getVar().getExpressionType())) {
                return new JJITCall(call.getVar(), Calls.KRegister_intValue);
            }
        }
        return new JJITCast(e, Types.INT);
    }
}
