package org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr;

import org.doovos.kernel.api.memory.KRegisterType;
import org.doovos.kernel.core.util.IntKeyHashMap;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 24/07/11
 * Time: 12:19
 * To change this template use File | Settings | File Templates.
 */
public class JJITSimulator {
    private Stack<KRegisterType> stack = new Stack<KRegisterType>();
    private IntKeyHashMap<Set<KRegisterType>> localTypes = new IntKeyHashMap<Set<KRegisterType>>();
    private IntKeyHashMap<KRegisterType> locals = new IntKeyHashMap<KRegisterType>();

    public void push(KRegisterType t) {
        stack.push(t);
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

    public boolean isStackEmpty(){
        return stack.empty();
    }

    public int getStackSize(){
        return stack.size();
    }

    public void setLocal(int local,KRegisterType type){
        locals.put(local,type);
        Set<KRegisterType> s = localTypes.get(local);
        if(s==null){
            s=new HashSet<KRegisterType>();
            localTypes.put(local,s);
        }
        s.add(type);
    }

    public KRegisterType getLocal(int local){
        return locals.get(local);
    }

    public Set<KRegisterType> getLocalTypes(int local){
        Set<KRegisterType> s = localTypes.get(local);
        if(s==null){
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(s);
    }
}
