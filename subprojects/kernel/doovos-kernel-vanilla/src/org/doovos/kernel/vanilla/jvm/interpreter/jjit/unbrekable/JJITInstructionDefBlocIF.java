/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.unbrekable;

import org.doovos.kernel.api.jvm.bytecode.KOperator;
import org.doovos.kernel.core.util.IntHashMap;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlNode;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstructionDef;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITChangeModel;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITChanges;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITClassSource;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITCmpOp;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITMethodSourceRun;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITConstant;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Calls;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITIf;

/**
 *
 * @author vpc
 */
public class JJITInstructionDefBlocIF extends JJITInstructionDef {

    private BlocIF bloc;

    public JJITInstructionDefBlocIF(BlocIF bloc) {
        super(KOperator.NOP);
        this.bloc = bloc;
    }

    @Override
    public JJITInstruction createSingleInstruction(Object[] constantDefs, IntHashMap labels) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JJITChanges getChanges(JJITChangeModel model) {
        //truebloc and false bloc are valid java instructions so they does not affect Stack
        BlocItem condition = (BlocItem) bloc.condition;
        return condition.getNode().getChanges();
//        return JJITStackChange.NOTHING;
    }

    @Override
    public void visitImpl(JJITClassSource cls, JJITFlowControlNode node, int relativeIndex) {
        JJITMethodSourceRun r = cls.run();
//        for (JJITInstructionDef d : BlocParser.toJJITInstructionDef(bloc.condition)) {
//            d.visit(cls);
//        }
        JJITInstructionDef c= ((BlocItem) bloc.condition).getInstruction();
        JJITCmpOp op= JJITCmpOp.AND;
        JJITIf IFexpr=null ;
        switch(c.getOperator()){
            case IFEQ:{
                IFexpr=r.If(JJITCmpOp.NE, r.popInt(), JJITConstant.I0);
                break;
            }
            case IFNE:{
                IFexpr=r.If(JJITCmpOp.EQ, r.popInt(), JJITConstant.I0);
                break;
            }
            case IFGE:{
                IFexpr=r.If(JJITCmpOp.LT, r.popInt(), JJITConstant.I0);
                break;
            }
            case IFGT:{
                IFexpr=r.If(JJITCmpOp.LE, r.popInt(), JJITConstant.I0);
                break;
            }
            case IFLE:{
                IFexpr=r.If(JJITCmpOp.GT, r.popInt(), JJITConstant.I0);
                break;
            }
            case IFLT:{
                IFexpr=r.If(JJITCmpOp.GE, r.popInt(), JJITConstant.I0);
                break;
            }
            case IFNULL:{
                IFexpr=r.If(r.popRef().call(Calls.KReference_isNotNull));
                break;
            }
            case IFNONNULL:{
                IFexpr=r.If(r.popRef().call(Calls.KReference_isNull));
                break;
            }
            case IF_ICMPNE:{
                IFexpr=r.If(JJITCmpOp.EQ, r.popInt(), r.popInt());
                break;
            }
            case IF_ICMPEQ:{
                IFexpr=r.If(JJITCmpOp.NE, r.popInt(), r.popInt());
                break;
            }
            case IF_ICMPGT:{
                IFexpr=r.If(JJITCmpOp.LE, r.popInt(), r.popInt());
                break;
            }
            case IF_ICMPGE:{
                IFexpr=r.If(JJITCmpOp.LT, r.popInt(), r.popInt());
                break;
            }
            case IF_ICMPLT:{
                IFexpr=r.If(JJITCmpOp.GE, r.popInt(), r.popInt());
                break;
            }
            case IF_ICMPLE:{
                IFexpr=r.If(JJITCmpOp.GT, r.popInt(), r.popInt());
                break;
            }
            default:{
                throw new IllegalArgumentException("Unsupported COMP "+c.getOperator());
            }    
        }
        if (bloc.trueBloc != null) {
            r.enterBloc(IFexpr.Then());
            int relativeIndex2=0;
            for (JJITFlowControlNode nn : BlocParser.toJJITInstructionDef(bloc.trueBloc)) {
                nn.getInstruction().visit(cls, nn, relativeIndex2++);
            }
            r.exitBloc();
        }
        if (bloc.falseBloc != null) {
            r.enterBloc(IFexpr.Else());
            int relativeIndex2=0;
            for (JJITFlowControlNode nn : BlocParser.toJJITInstructionDef(bloc.falseBloc)) {
                nn.getInstruction().visit(cls, nn, relativeIndex2++);
            }
            r.exitBloc();
        }
    }


    @Override
    public String toString() {
        return bloc.toString();
    }

    public BlocIF getBloc() {
        return bloc;
    }
}
