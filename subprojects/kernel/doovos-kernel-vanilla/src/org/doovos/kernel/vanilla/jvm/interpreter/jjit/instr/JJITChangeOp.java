/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr;

import com.sun.tools.javac.code.Type;
import org.doovos.kernel.api.memory.KRegisterType;

/**
 * @author vpc
 */
public class JJITChangeOp {
    private KRegisterType registerType;
    private JJITChangeType op;
    private int index;
    public static final JJITChangeOp PUSH_REF = new JJITChangeOp(KRegisterType.REF, JJITChangeType.PUSH, 0);
    public static final JJITChangeOp PUSH_INTEGER = new JJITChangeOp(KRegisterType.INTEGER, JJITChangeType.PUSH, 0);
    public static final JJITChangeOp PUSH_DOUBLE = new JJITChangeOp(KRegisterType.DOUBLE, JJITChangeType.PUSH, 0);
    public static final JJITChangeOp PUSH_LONG = new JJITChangeOp(KRegisterType.LONG, JJITChangeType.PUSH, 0);
    public static final JJITChangeOp PUSH_FLOAT = new JJITChangeOp(KRegisterType.FLOAT, JJITChangeType.PUSH, 0);
    public static final JJITChangeOp PUSH_RETURN = new JJITChangeOp(KRegisterType.RETURN, JJITChangeType.PUSH, 0);

    public static final JJITChangeOp POP_REF = new JJITChangeOp(KRegisterType.REF, JJITChangeType.POP, 0);
    public static final JJITChangeOp POP_INTEGER = new JJITChangeOp(KRegisterType.INTEGER, JJITChangeType.POP, 0);
    public static final JJITChangeOp POP_DOUBLE = new JJITChangeOp(KRegisterType.DOUBLE, JJITChangeType.POP, 0);
    public static final JJITChangeOp POP_LONG = new JJITChangeOp(KRegisterType.LONG, JJITChangeType.POP, 0);
    public static final JJITChangeOp POP_FLOAT = new JJITChangeOp(KRegisterType.FLOAT, JJITChangeType.POP, 0);
    public static final JJITChangeOp POP_RETURN = new JJITChangeOp(KRegisterType.RETURN, JJITChangeType.POP, 0);


    public static JJITChangeOp Push(KRegisterType registerType){
        switch (registerType){
            case INTEGER:{
                return PUSH_INTEGER;
            }
            case DOUBLE:{
                return PUSH_DOUBLE;
            }
            case FLOAT:{
                return PUSH_FLOAT;
            }
            case LONG:{
                return PUSH_LONG;
            }
            case REF:{
                return PUSH_REF;
            }
            case RETURN:{
                return PUSH_RETURN;
            }
        }
        throw new IllegalArgumentException("Unsupported "+registerType);
    }

    public static JJITChangeOp Pop(KRegisterType registerType){
        switch (registerType){
            case INTEGER:{
                return POP_INTEGER;
            }
            case DOUBLE:{
                return POP_DOUBLE;
            }
            case FLOAT:{
                return POP_FLOAT;
            }
            case LONG:{
                return POP_LONG;
            }
            case REF:{
                return POP_REF;
            }
            case RETURN:{
                return POP_RETURN;
            }
        }
        throw new IllegalArgumentException("Unsupported "+registerType);
    }

    public static JJITChangeOp SetLocal(int index, KRegisterType registerType){
        return new JJITChangeOp(registerType,JJITChangeType.SETLOCAL, index);
    }

    public static JJITChangeOp GetLocal(int index, KRegisterType registerType){
        return new JJITChangeOp(registerType,JJITChangeType.GETLOCAL, index);
    }

    public JJITChangeOp(KRegisterType registerType, JJITChangeType op,int index) {
        this.registerType = registerType;
        this.op = op;
        this.index = index;
    }

    @Override
    public String toString() {
        switch (op){
            case PUSH:{
                return "PUSH "+registerType;
            }
            case POP:{
                return "POP  "+registerType;
            }
            case SETLOCAL:{
                return "SETLOCAL  "+index+" "+registerType;
            }
            case GETLOCAL:{
                return "GETLOCAL  "+index+" "+registerType;
            }
        }
        return super.toString();
    }

    public JJITChangeType getType() {
        return op;
    }

    public boolean isPush() {
        return op==JJITChangeType.PUSH;
    }

    public boolean isPop() {
        return op==JJITChangeType.POP;
    }

    public KRegisterType getRegisterType() {
        return registerType;
    }

    public int getIndex() {
        return index;
    }
}
