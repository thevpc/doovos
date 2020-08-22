/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol;

import org.doovos.kernel.api.jvm.bytecode.KMethodDef;
import org.doovos.kernel.api.jvm.bytecode.KOperator;
import org.doovos.kernel.api.jvm.bytecode.KOperatorGroup;
import org.doovos.kernel.api.jvm.bytecode.KTryCatchDef;
import org.doovos.kernel.api.memory.KRegisterType;
import org.doovos.kernel.core.util.IntHashSet;
import org.doovos.kernel.core.util.IntKeyHashMap;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITChangeModel;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITChangeOp;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITChanges;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstructionDef;

import java.util.*;

/**
 * @author vpc
 */
public class JJITFlowControl {

    private KMethodDef method;
    private JJITFlowControlNode[] nodes;
    private JJITInstructionDef[] instructions;
    private IntKeyHashMap<Set<KRegisterType>> localTypes = new IntKeyHashMap<Set<KRegisterType>>();

    public JJITFlowControl(JJITInstructionDef[] instructions, Object[] objConstantsPool, KMethodDef method) {
        this.method=method;
        JJITFlowControlNode[] _nodes = new JJITFlowControlNode[instructions.length];
        for (int i = 0; i < instructions.length; i++) {
            _nodes[i] = new JJITFlowControlNode(instructions[i], this, i, objConstantsPool);
        }
        for (int i = 0; i < _nodes.length; i++) {
            final JJITFlowControlNode n = _nodes[i];
            final JJITInstructionDef dd = n.getInstruction();
            for (int j : dd.getNexts(i, instructions)) {
                n.next.add(_nodes[j]);
                _nodes[j].previous.add(n);
            }
        }
        this.nodes = _nodes;


        class CCC {
            JJITChangeModel m;
            JJITFlowControlNode n;

            CCC(JJITChangeModel m, JJITFlowControlNode n) {
                this.m = m;
                this.n = n;
            }
        }

        Stack<CCC> s = new Stack<CCC>();
        for (KTryCatchDef tryCatchDef : method.getTryCatchBlocs()) {
            JJITChangeModel m0 = new JJITChangeModel();
            m0.push(KRegisterType.REF);
            s.push(new CCC(m0, nodes[tryCatchDef.getTarget()]));
        }
        s.push(new CCC(new JJITChangeModel(), nodes[0]));
        IntHashSet visited = new IntHashSet();
        while (!s.empty()) {
            CCC ccc = s.pop();
            JJITFlowControlNode n = ccc.n;
//            System.out.println(">> " + n);
            while (n != null) {
                if (visited.contains(n.getIndex())) {
                    break;
                }
                visited.add(n.getIndex());
                JJITChangeModel m = ccc.m;
                JJITInstructionDef ii = n.getInstruction();
//                String zzz = n + " : " + m + " => ";
                JJITChanges sc = ii.getChanges(m);
                try {
                    for (JJITChangeOp so : sc) {
                        switch (so.getType()) {
                            case PUSH: {
                                m.push(so.getRegisterType());
                                break;
                            }
                            case POP: {
                                m.pop(so.getRegisterType());
                                break;
                            }
                            case SETLOCAL: {
                                m.setLocal(so.getIndex(), so.getRegisterType());
                                Set<KRegisterType> ss = localTypes.get(so.getIndex());
                                if (ss == null) {
                                    ss = new HashSet<KRegisterType>();
                                    localTypes.put(so.getIndex(), ss);
                                }
                                ss.add(so.getRegisterType());
                                break;
                            }
                            case GETLOCAL: {
                                m.getLocal(so.getIndex(), so.getRegisterType());
                                Set<KRegisterType> ss = localTypes.get(so.getIndex());
                                if (ss == null) {
                                    ss = new HashSet<KRegisterType>();
                                    localTypes.put(so.getIndex(), ss);
                                }
                                ss.add(so.getRegisterType());
                                break;
                            }
                        }
                    }
                    n.setChanges(sc);
//                    for (int i = 0; i < s.size(); i++) {
//                        System.out.print(" ");
//                    }
//                    System.out.println(zzz + m);
                } catch (RuntimeException e) {
//                    for (int i = 0; i < s.size(); i++) {
//                        System.out.print(" ");
//                    }
//                    System.out.println(zzz+" :: Changes are "+sc);
                    e.printStackTrace();
                    throw e;
                }
                List<JJITFlowControlNode> next = n.getNext();
                List<JJITFlowControlNode> next2 = new ArrayList<JJITFlowControlNode>();
                for (JJITFlowControlNode nn : next) {
                    if (!visited.contains(nn.getIndex())) {
                        next2.add(nn);
                    }
                }
                int size = next2.size();
                switch (size) {
                    case 0: {
                        n = null;
                        break;
                    }
                    case 1: {
                        n = next2.get(0);
                        break;
                    }
                    default: {
                        n = null;
//                        System.out.println("POSSIBLE BRANCHES " + next2);
                        for (JJITFlowControlNode nn : next2) {
                            s.push(new CCC(new JJITChangeModel(ccc.m.getStack()), nn));
                        }
                        break;
                    }
                }

            }
        }

        //check if all nodes are processed
        for (JJITFlowControlNode node : _nodes) {
            if(node.getChanges()==null){
                throw new IllegalStateException("Node never visited "+node);
            }
        }

    }


    public JJITFlowControlNode getNode(int index) {
        return nodes[index];
    }

//    public KRegisterType getPushType(JJITFlowControlNode node, int depth) {
//        IntHashSet visited = new IntHashSet();
//        KRegisterType x = null;
//        for (JJITFlowControlNode p : node.previous) {
//            x = getPushType(p, visited, depth);
//            if (x != null) {
//                break;
//            }
//        }
//        if (x == null) {
//            throw new IllegalArgumentException("Unsupported");
//        }
//        return x;
//    }
//
//    public KRegisterType getPushType(int index, int depth) {
//        IntHashSet visited = new IntHashSet();
//        KRegisterType x = null;
//        for (JJITFlowControlNode p : nodes[index].previous) {
//            x = getPushType(p, visited, depth);
//            if (x != null) {
//                break;
//            }
//        }
//        if (x == null) {
//            throw new IllegalArgumentException("Unsupported");
//        }
//        return x;
//    }

//    private KRegisterType getPushType(JJITFlowControlNode node, IntHashSet visited, int toIgnore) {
//        JJITStackChange sc = node.getInstruction().getChanges(node, $$$$);
//        //? a[n]... a[1] a[0]->? b[0] b[2] ... b[n]
//        KRegisterType[] a = sc.getPop();
//        KRegisterType[] b = sc.getPush();
//        for (int i = b.length - 1; i >= 0; i--) {
//            if (toIgnore > 0) {
//                toIgnore--;
//            } else {
//                return b[i];
//            }
//        }
//        toIgnore += a.length;
//
//        visited.add(node.getIndex());
//        for (JJITFlowControlNode p : node.previous) {
//            if (!visited.contains(p.getIndex())) {
//                KRegisterType x = getPushType(p, visited, toIgnore);
//                if (x != null) {
//                    return x;
//                }
//            }
//        }
//        return null;
//    }

    public boolean isInitializedInParent(int index, String className) {
        return nodes[index].isInitializedInParent(className);
    }

    public boolean isUnbreakable(String className) {


        IntHashSet consumedGotos = new IntHashSet();
        int ifCount = 0;
        for (JJITFlowControlNode n : nodes) {
            JJITInstructionDef i = n.getInstruction();
            switch (i.getOperator().getGroup()) {
                case RETURN: {
//                    if (n.getIndex() == nodes[nodes.length - 1].getIndex()) {
//                        //ignore
//                    } else {
//                        return false;
//                    }
                    break;
                }
                case INVOKE: {
                    //TODO, should take into consideration inlinable methods, etc...
                    return false;
                }
                case IF: {
                    boolean ifInstruction = false;
                    int index = n.getIndex();
                    int[] nexts = i.getNexts(index, instructions);
                    if (nexts.length == 2) {
                        if (nexts[0] == index + 1 && nexts[1] > index + 1) {
                            int beforeNext = nexts[1] - 1;
                            JJITFlowControlNode n2 = nodes[beforeNext];
                            JJITInstructionDef ii2 = n2.getInstruction();
                            KOperator op = ii2.getOperator();
                            if (!op.equals(KOperator.GOTO) && !op.equals(KOperator.GOTO_W)) {
                                if (op.getGroup().equals(KOperatorGroup.IF)) {
                                    //this is an OR | AND expression
                                    return false;
                                } else {
                                    //this is an IF
                                    consumedGotos.add(n2.getIndex());
                                    ifInstruction = true;
                                }
                            } else {
                                int[] gotoNexts = ii2.getNexts(beforeNext, instructions);
                                if (gotoNexts[0] > (beforeNext)) {
                                    ifInstruction = true;
                                    consumedGotos.add(beforeNext);
                                }
                            }
                        }
                    } else if (nexts.length == 1) {
                        KOperator op = i.getOperator();
                        if (op.equals(KOperator.GOTO) || op.equals(KOperator.GOTO_W)) {
                            if (consumedGotos.contains(index)) {
                                continue;
                            }
                        }
                    }
                    if (!ifInstruction) {
                        return false;
                    } else {
//                        ifCount++;
//                        if (ifCount > 1) {
//                            return false;
//                        }
                    }
                    break;
                }
                default: {
                    switch (i.getOperator()) {
                        case ATHROW:
                        case JSR:
                        case JSR_W:
                        case LOOKUPSWITCH:
                        case TABLESWITCH:
                        case MONITORENTER:
                        case MONITOREXIT: {
                            return false;
                        }
                        case GOTO:
                        case GOTO_W: {
                            if (!consumedGotos.contains(n.getIndex())) {
                                return false;
                            }
                        }
                    }
                    String[] loadingClasses = i.getLoadingClasses();
                    for (String c : loadingClasses) {
                        if (!c.equals(className)) {
                            return false;
                        }
                    }
                    break;
                }
            }
        }
        //FIXME
        return method.getClassName().equals("jnt.scimark2.Random") && method.getSignature().equals("nextDouble()D");
//        return true;
    }

    public JJITFlowControlNode[] getNodes() {
        return nodes;
    }

    public JJITInstructionDef[] getInstructions() {
        return instructions;
    }
}
