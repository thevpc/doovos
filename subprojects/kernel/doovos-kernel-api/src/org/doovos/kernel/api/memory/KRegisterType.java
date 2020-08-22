/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.doovos.kernel.api.memory;

/**
 *
 * @author vpc
 */
public enum KRegisterType {
    INTEGER(false)
    ,SHORT(false)
    ,LONG(true)
    ,DOUBLE(true)
    ,FLOAT(false)
    ,BYTE(false)
    ,CHAR(false)
    ,BOOLEAN(false)
    ,RETURN(false)
    ,REF(false)
    ;
    private boolean type2;

    private KRegisterType(boolean type2) {
        this.type2 = type2;
    }

    public boolean isType2() {
        return type2;
    }
}
