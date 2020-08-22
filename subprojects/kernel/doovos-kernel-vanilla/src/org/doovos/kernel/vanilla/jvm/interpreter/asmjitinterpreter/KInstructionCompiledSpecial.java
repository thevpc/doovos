package org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter;

import java.rmi.RemoteException;

public abstract class KInstructionCompiledSpecial extends KInstructionJITImpl implements KInstructionCompiled {
    protected KInstructionCompiled next;
    protected int currentIndex;

    protected KInstructionCompiledSpecial(int operator, boolean jump, boolean label) {
        super(operator, jump, label);
    }

    protected KInstructionCompiledSpecial(int operator, long[] operands, boolean jump, boolean label) {
        super(operator, operands, jump, label);
    }

    @Override
    public final void produceRunMethod(JITContext context) throws Exception {
        throw new IllegalArgumentException("Should never be called");
    }

    public void configure(KInstructionCompiled[] instructions, int index) throws RemoteException {
        this.currentIndex = index;
        if (index < instructions.length) {
            next = instructions[index];
        }
    }

}
