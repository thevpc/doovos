package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src;

import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.memory.KRegisterType;

/**
* Created by IntelliJ IDEA.
* User: vpc
* Date: 09/01/11
* Time: 12:03
* To change this template use File | Settings | File Templates.
*/
public class KInitConst implements KRegister {

    int constId;

    public KInitConst(int constId) {
        this.constId = constId;
    }

    public int getConstId() {
        return constId;
    }

    public boolean booleanValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public KRegisterType getType() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public byte byteValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public char charValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public double doubleValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public float floatValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int intValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isType2() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public long longValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public short shortValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object toJavaNative() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
