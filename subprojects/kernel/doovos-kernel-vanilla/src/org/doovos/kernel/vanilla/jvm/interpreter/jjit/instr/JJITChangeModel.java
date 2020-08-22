package org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr;

import org.doovos.kernel.api.memory.KRegisterType;
import org.doovos.kernel.core.util.IntKeyHashMap;

import java.util.Collections;
import java.util.Set;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 24/07/11
 * Time: 12:19
 * To change this template use File | Settings | File Templates.
 */
public class JJITChangeModel {
    private Stack<KRegisterType> stack = new Stack<KRegisterType>();
    private IntKeyHashMap<KRegisterType> locals = new IntKeyHashMap<KRegisterType>();

    public JJITChangeModel() {

    }

    public JJITChangeModel(Stack<KRegisterType> stack) {
        this.stack = stack;
    }

    public Stack<KRegisterType> getStack() {
        return (Stack<KRegisterType>) stack.clone();
    }

    public void peek(KRegisterType t) {
        pop(t);
        push(t);
    }

    public void push(KRegisterType t) {
        stack.push(t);
    }

    public void popInt() {
        pop(KRegisterType.INTEGER);
    }

    public void popLong() {
        pop(KRegisterType.LONG);
    }

    public void popDouble() {
        pop(KRegisterType.DOUBLE);
    }

    public void popFloat() {
        pop(KRegisterType.FLOAT);
    }

    public void pop(KRegisterType expected) {
        KRegisterType found = pop();
        if (found != expected) {
            //should handle case of KReturn that is considered as REF in JVM
            if(expected.equals(KRegisterType.REF) && found.equals(KRegisterType.RETURN)){
                return;
            }
            throw new IllegalStateException("Expected " + expected + ", found " + found);
        }
    }

    public void popRef() {
        pop(KRegisterType.REF);
    }

    public KRegisterType pop() {
        return stack.pop();
    }

    public KRegisterType peek() {
        return stack.pop();
    }

    public KRegisterType peek(int i) {
        return stack.get(stack.size() - 1 - i);
    }

    public boolean isStackEmpty() {
        return stack.empty();
    }

    public int getStackSize() {
        return stack.size();
    }

    public void setLocal(int local, KRegisterType type) {
        locals.put(local, type);
    }

    public KRegisterType getLocal(int local, KRegisterType type) {
        KRegisterType t = locals.get(local);
        if (t != type) {
            throw new IllegalStateException("Expected REF, found " + t);
        }
        return t;
    }

    public KRegisterType getLocal(int local) {
        return locals.get(local);
    }

    @Override
    public String toString() {
        return "{" +
                "stack=" + stack +
                //", locals=" + locals +
                '}';
    }
}
