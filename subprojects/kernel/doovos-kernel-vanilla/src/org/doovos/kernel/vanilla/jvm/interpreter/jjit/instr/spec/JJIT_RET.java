/**
 * ====================================================================
 *             Doovos (Distributed Object Oriented Operating System)
 *
 * Doovos is a new Open Source Distributed Object Oriented Operating System
 * Design and implementation based on the Java Platform.
 * Actually, it is a try for designing a distributed operation system in
 * top of existing centralized/network OS.
 * Designed OS will follow the object oriented architecture for redefining
 * all OS resources (memory,process,file system,device,...etc.) in a highly
 * distributed context.
 * Doovos is also a distributed Java virtual machine that implements JVM
 * specification on top the distributed resources context.
 *
 * Doovos Kernel is the heart of Doovos OS. It implements also the Doovos JVM
 * Doovos Kernel code is executed on host JVM
 *
 * Copyright (C) 2008-2010 Taha BEN SALAH
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, writeSource to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 * ====================================================================
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec;

import org.doovos.kernel.api.jvm.bytecode.KOperator;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.KObjectType;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.memory.KReturn;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.core.util.IntArray;
import org.doovos.kernel.core.util.IntHashMap;
import org.doovos.kernel.core.util.IntKeyHashMap;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlNode;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstructionDef;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITChangeModel;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITChanges;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.base.JJIT__BASE_JSR;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITClassSource;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITMethodSourceRun;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITName;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Calls;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Types;

public final class JJIT_RET extends JJITInstructionDef {

    private int localIndex;

    public JJIT_RET(int localIndex) {
        super(KOperator.RET);
        this.localIndex = localIndex;
    }

    @Override
    public JJITChanges getChanges(JJITChangeModel model) {
        return JJITChanges.NOTHING;
    }

    public void visitImpl(JJITClassSource cls, JJITFlowControlNode node, int relativeIndex) {
        final JJITMethodSourceRun r = cls.run();
        JJITName index = r.declareIndex();
        r.set(index, r.getLocalPrimitive(localIndex, KObjectType.t_int));
//        r.set(index, r.getLocal(localIndex).cast(TypeStruct.KRETURN).field("value",TypeStruct.INT));
        r.Return(r.frame().call(Calls.KFrame_getInstruction, index).cast(Types.JJITINSTRUCTION));
    }

    @Override
    public int[] getNexts(int currentIndex, JJITInstructionDef[] instructions) {

        //should find out all JSR that lead th this RET
        IntKeyHashMap<IntArray> jsr=new IntKeyHashMap<IntArray>();
        for (int i = 0; i < instructions.length; i++) {
            JJITInstructionDef instruction = instructions[i];
            if(instruction instanceof JJIT__BASE_JSR){
                JJIT__BASE_JSR s=(JJIT__BASE_JSR) instruction;
                int label = s.getLabel();
                IntArray arr = jsr.get(label);
                if(arr==null){
                    arr=new IntArray(3);
                    jsr.put(label,arr);
                }
                arr.add(i);
            }
        }
        if(jsr.size()==0){
            throw new RuntimeException("Never Happens");
        }else {
            IntArray jsrLabels = jsr.keyArray();
            int relativeLabel=-1;
            if(jsr.size()==1){
                //this the very one
                relativeLabel = jsrLabels.get(0);
            }else{
                for(int i=0;i<jsrLabels.size();i++){
                    int x=jsrLabels.get(i);
                    if(x<currentIndex){
                        if(x>relativeLabel){
                            relativeLabel=x;
                        }
                    }
                }
            }
            IntArray jsrIndices = jsr.get(relativeLabel);
            int[] nexts=new int[jsrIndices.size()];
            for (int i = 0; i < nexts.length; i++) {
                nexts[i]=jsrIndices.get(i)+1;
            }
            return nexts;
        }
    }

//    private boolean checkJSR(JJITInstructionDef[] instructions,int jsrIndex, int retIndex){
//
//    }

    @Override
    public String toString() {
        return getOperator() + "(" + localIndex + ')';
    }

    @Override
    public boolean isJump() {
        return true;
    }

    @Override
    public JJITInstruction createSingleInstruction(Object[] constantDefs, IntHashMap labels) {
        return new Single(this);
    }

    private static class Single extends JJITInstructionSingle implements Cloneable {
        int localIndex;

        private Single(JJIT_RET d) {
            super(d);
            localIndex = d.localIndex;
        }

        public void init(int index, JJITInstruction[] instructions, KRegister[] constants, KProcess process) throws Exception {
        }

        public JJITInstruction run(KFrame frame) throws Exception {
            return (JJITInstruction) frame.getInstruction(((KReturn) frame.getLocal(localIndex)).value);
        }

    }

}
