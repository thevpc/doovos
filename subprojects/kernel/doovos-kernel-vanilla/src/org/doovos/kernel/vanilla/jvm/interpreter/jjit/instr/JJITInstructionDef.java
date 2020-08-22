/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr;

import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.api.util.EmptyArray;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.JJIT;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITClassSource;
import org.doovos.kernel.api.jvm.bytecode.KOperator;
import org.doovos.kernel.core.util.IntHashMap;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.JJITTransformerContext;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlNode;

/**
 * JJITInstructionDef implements JJITInstruction so that no need to create single instruction class
 * @author vpc
 */
public abstract class JJITInstructionDef {

    protected KOperator operator;
//    protected static int[] NO_LABELS = new int[0];
//    protected static String[] NO_CLASSES = new String[0];

    public JJITInstructionDef(KOperator operator) {
        this.operator = operator;
    }

    public JJITInstructionDef transform(JJITTransformerContext context) {
        return this;
    }

    public KOperator getOperator() {
        return operator;
    }

//    public JJITStackChange getStackChanges(FlowControlNode node,int index) {
//        return NO_PUSH;
//    }
    public abstract JJITChanges getChanges(JJITChangeModel model);

    public int[] getLabels() {
        return EmptyArray.INTS;
    }

    public int[] getNexts(int currentIndex, JJITInstructionDef[] instructions) {
        return new int[]{currentIndex + 1};
    }

    public void visit(JJITClassSource cls, JJITFlowControlNode node, int relativeIndex){
        cls.run().lineComment("*********" + node);
        cls.init().lineComment("*********" + node);
        visitImpl(cls, node, relativeIndex);
    }
    
    protected abstract void visitImpl(JJITClassSource cls, JJITFlowControlNode node, int relativeIndex);

    public boolean isJump() {
        return operator.isJump();
    }

    /**
     * 
     * @return
     */
    public String[] getLoadingClasses() {
        return EmptyArray.STRINGS;
    }

    public int getReadLocal() {
        return -1;
    }

    public int getWriteLocal() {
        return -1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JJITInstructionDef other = (JJITInstructionDef) obj;
        if (this.operator != other.operator) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.operator != null ? this.operator.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return operator.toString();
    }

    public abstract JJITInstruction createSingleInstruction(Object[] constantDefs, IntHashMap labels);


    protected static abstract class JJITInstructionSingleNext extends JJITInstructionSingle {
        protected transient JJITInstruction next;

        protected JJITInstructionSingleNext(JJITInstructionDef d) {
            super(d);
        }

        public void init(int index, JJITInstruction[] instructions, KRegister[] constants, KProcess process) throws Exception {
            next=instructions[index+1];
        }

    }

    protected static abstract class JJITInstructionSingle implements JJITInstruction {
        private String toStr;
        protected JJITInstructionSingle() {

        }
        protected JJITInstructionSingle(JJITInstructionDef d) {
            toStr=d.toString();
        }

        @Override
        public String toString() {
            return toStr;
        }

        @Override
        public JJITInstruction clone(){
            try {
                return (JJITInstruction)super.clone();
            } catch (CloneNotSupportedException e) {
                throw new IllegalArgumentException("Clone unsupported",e);
            }
        }
    }

    public String getShareName(){
        throw new AbstractMethodError("Not implemented");
    }

    public boolean isSharable(){
        return false;
    }

    public void prepareShare(JJITInstruction ii, int relativeIndex){

    }

    protected void prepareShareVar(JJITInstruction ii, int relativeIndex,int index,Object value){
        try {
            ii.getClass().getField(JJIT.getSharedVarName(relativeIndex, index)).set(ii,value);
        } catch (Exception e) {
            throw new IllegalArgumentException("Problem here");
        }
    }
}
