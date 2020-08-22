package org.doovos.kernel.vanilla.jvm.interpreter.jjit.stats;

import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstructionDef;

import java.util.Arrays;

/**
* Created by IntelliJ IDEA.
* User: vpc
* Date: 23/07/11
* Time: 16:51
* To change this template use File | Settings | File Templates.
*/
public class JJITSharedBlocKey {
    private JJITInstructionDef[] code;

    public JJITSharedBlocKey(JJITInstructionDef... code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "{" +
                (code == null ? null : Arrays.asList(code)) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JJITSharedBlocKey sharedKey = (JJITSharedBlocKey) o;

        if (!Arrays.equals(code, sharedKey.code)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return code != null ? Arrays.hashCode(code) : 0;
    }
}
