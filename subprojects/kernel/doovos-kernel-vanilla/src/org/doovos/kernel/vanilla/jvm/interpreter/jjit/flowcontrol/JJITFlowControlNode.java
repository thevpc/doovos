/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import org.doovos.kernel.core.util.IntHashSet;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstructionDef;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITChanges;

/**
 *
 * @author vpc
 */
public class JJITFlowControlNode {

    List<JJITFlowControlNode> previous = new ArrayList<JJITFlowControlNode>(2);
    List<JJITFlowControlNode> next = new ArrayList<JJITFlowControlNode>(2);
    public JJITInstructionDef instruction0;
    public JJITInstructionDef instruction;
    private int index;
    private JJITFlowControl flowControl;
    private JJITChanges changes;
    private HashSet<String> initClasses = new LinkedHashSet<String>(2);
    
    public JJITFlowControlNode(JJITInstructionDef def, JJITFlowControl flowControl,int oldIndex,Object[] objConstantsPool) {
        this.instruction = def;
        this.flowControl = flowControl;
        this.index = oldIndex;
        initClasses.addAll(Arrays.asList(def.getLoadingClasses()));
    }


    public JJITFlowControl getFlowControl() {
        return flowControl;
    }

    public int getIndex() {
        return index;
    }

    public void setInstruction(JJITInstructionDef instruction) {
        this.instruction = instruction;
    }

    

    public JJITInstructionDef getInstruction() {
        return instruction;
    }

    boolean isInitializedInParent(String cls) {
        for (JJITFlowControlNode nn : previous) {
            if (nn.isInitialized(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "[" + index + "] " + instruction;
    }

    private boolean isInitialized(String cls) {
        return isInitialized(cls, new IntHashSet());
    }

    private boolean isInitialized(String cls, IntHashSet visited) {
        if (initClasses.contains(cls)) {
            return true;
        }
        visited.add(index);
        for (JJITFlowControlNode nn : previous) {
            if (!visited.contains(nn.index)) {
                if (nn.isInitialized(cls, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<JJITFlowControlNode> getNext() {
        return next;
    }

    public List<JJITFlowControlNode> getPrevious() {
        return previous;
    }
    
//    public KRegisterType getPushType(int depth) {
//        TreeSet<Integer> visited = new TreeSet<Integer>();
//        KRegisterType x = null;
//        for (JJITFlowControlNode p : previous) {
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

//    private KRegisterType getPushType(JJITFlowControlNode node, TreeSet<Integer> visited, int toIgnore) {
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

    public JJITChanges getChanges(){
        return changes;//instruction.getStackChanges(this);
    }

    public void setChanges(JJITChanges changes) {
        this.changes = changes;
    }
}
