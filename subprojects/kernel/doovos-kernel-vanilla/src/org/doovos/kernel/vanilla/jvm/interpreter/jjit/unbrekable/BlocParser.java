/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.unbrekable;

import java.util.ArrayList;
import java.util.Arrays;
import org.doovos.kernel.api.jvm.bytecode.KOperator;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlNode;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstructionDef;

/**
 *
 * @author vpc
 */
public class BlocParser {

    public static Bloc toBloc(JJITFlowControlNode[] nodes) {
        return toBloc(nodes, 0, nodes.length);
    }

    public static Bloc toBloc(JJITFlowControlNode[] nodes, int i0, int j0) {
        for (int z = i0; z < j0; z++) {
            JJITFlowControlNode n = nodes[z];
            JJITInstructionDef i = n.getInstruction();
            switch (i.getOperator().getGroup()) {
                case RETURN: {
                    //ignore
                    break;
                }
                case IF: {
                    int index = n.getIndex();
                    JJITInstructionDef[] instructions = n.getFlowControl().getInstructions();
                    int[] nexts = i.getNexts(index, instructions);
                    if (nexts.length == 2) {
                        if (nexts[0] == index + 1 && nexts[1] > index + 1) {
                            int elseLabel = nexts[1];
                            int trueBlocEnd = elseLabel - 1;
                            JJITInstructionDef trueBlocEndInstr = nodes[trueBlocEnd].getInstruction();
                            KOperator trueBlocEndOp = trueBlocEndInstr.getOperator();
                            if (trueBlocEndOp.equals(KOperator.GOTO) || trueBlocEndOp.equals(KOperator.GOTO_W)) {
                                int[] gotoNexts = trueBlocEndInstr.getNexts(trueBlocEnd, instructions);
                                if (gotoNexts[0] > (trueBlocEnd)) {
                                    int falseBlocEnd = gotoNexts[0];
                                    BlocIF bif = new BlocIF();

                                    bif.condition = new BlocItem(nodes[index]);
                                    bif.trueBloc = toBloc(nodes, index + 1, trueBlocEnd);
                                    bif.falseBloc = toBloc(nodes, elseLabel, falseBlocEnd);
                                    BlocList list = new BlocList();
                                    for (int zz = i0; zz < index; zz++) {
                                        list.add(new BlocItem(nodes[zz]));
                                    }
                                    list.add(bif);
                                    list.add(toBloc(nodes, falseBlocEnd, j0));
                                    return list;
                                }
                            } else {
                                BlocIF bif = new BlocIF();
                                bif.condition = new BlocItem(nodes[index]);
                                bif.trueBloc = toBloc(nodes, index + 1, elseLabel);
                                BlocList list = new BlocList();
                                for (int zz = i0; zz < index; zz++) {
                                    JJITFlowControlNode nn = nodes[zz];
                                    list.add(new BlocItem(nn));
                                }
                                list.add(bif);
                                list.add(toBloc(nodes, elseLabel, j0));
                                return list;
                            }
                        }
                    }
                    break;
                }
            }
        }
        BlocList list = new BlocList();
        for (int z = i0; z < j0; z++) {
            list.add(new BlocItem(nodes[z]));
        }
        return list;
    }

    public static JJITFlowControlNode[] toJJITInstructionDef(Bloc bloc) {
        if (bloc instanceof BlocList) {
            ArrayList<JJITFlowControlNode> aa = new ArrayList<JJITFlowControlNode>();
            BlocList list = (BlocList) bloc;
            for (Bloc a : list) {
                aa.addAll(Arrays.asList(toJJITInstructionDef(a)));
            }
            return aa.toArray(new JJITFlowControlNode[aa.size()]);
        } else if (bloc instanceof BlocItem) {
            return new JJITFlowControlNode[]{((BlocItem) bloc).getNode()};
        } else if (bloc instanceof BlocIF) {
            BlocIF ifControl = (BlocIF) bloc;
            JJITFlowControlNode condNode = ((BlocItem) ifControl.condition).getNode();
            JJITInstructionDefBlocIF jJITInstructionDefBlocIF = new JJITInstructionDefBlocIF(ifControl);
            JJITFlowControlNode n=new JJITFlowControlNode(jJITInstructionDefBlocIF, condNode.getFlowControl(), -1, null);
            return new JJITFlowControlNode[]{n};
        } else {
            throw new IllegalArgumentException("Not supported");
        }
    }
}
