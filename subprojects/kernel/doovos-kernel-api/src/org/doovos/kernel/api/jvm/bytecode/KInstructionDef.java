package org.doovos.kernel.api.jvm.bytecode;

import org.doovos.kernel.api.util.EmptyArray;

import java.io.Serializable;
import java.util.Arrays;

public class KInstructionDef implements Serializable{
    public final int operator;
    public final long operands[];

    public KInstructionDef(int operator) {
        this.operator = operator;
        this.operands = EmptyArray.LONGS;
    }

    public KInstructionDef(int operator,long arg) {
        this.operator = operator;
        this.operands = new long[]{arg};
    }

    public KInstructionDef(int operator,long arg1,long arg2) {
        this.operator = operator;
        this.operands = new long[]{arg1,arg2};
    }

    public KInstructionDef(int operator,long arg1,long arg2,long arg3) {
        this.operator = operator;
        this.operands = new long[]{arg1,arg2,arg3};
    }

    public KInstructionDef(int operator, long[] operands) {
        this.operator = operator;
        this.operands = operands;
    }

    public int getOperator() {
        return operator;
    }

    public long[] getOperands() {
        return operands;
    }

    @Override
    public String toString() {
        return operator+""+Arrays.toString(operands);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KInstructionDef other = (KInstructionDef) obj;
        if (this.operator != other.operator) {
            return false;
        }
        if (!Arrays.equals(this.operands, other.operands)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.operator;
        hash = 97 * hash + Arrays.hashCode(this.operands);
        return hash;
    }

}
