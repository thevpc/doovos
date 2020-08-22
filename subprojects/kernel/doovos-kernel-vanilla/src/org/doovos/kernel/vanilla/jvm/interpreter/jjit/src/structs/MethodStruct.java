/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs;

import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Types;

import java.util.Arrays;

/**
 *
 * @author vpc
 */
public class MethodStruct {

    private String className;
    private String methodName;
    private TypeStruct[] arguments;
    private TypeStruct returnType;
    private boolean updateContent;

    public MethodStruct(Class className, String methodName, boolean updateContent, TypeStruct returnType, TypeStruct... arguments) {
        this.className = className.getName();
        this.methodName = methodName;
        this.arguments = arguments;
        this.returnType = returnType;
        this.updateContent = updateContent;
    }

//    public MethodStruct(Class className, String methodName, boolean updateContent, Class returnType, Class... arguments) {
//        this.className = className.getName();
//        this.methodName = methodName;
//        this.arguments = new TypeStruct[arguments.length];
//        for (int i = 0; i < arguments.length; i++) {
//            this.arguments[i] = new TypeStruct(arguments[i]);
//        }
//        this.returnType = returnType == null ? Types.VOID : new TypeStruct(returnType);
//        this.updateContent = updateContent;
//    }

    public MethodStruct(String className, String methodName, boolean updateContent, String returnType, String... arguments) {
        this.className = className;
        this.methodName = methodName;
        this.arguments = new TypeStruct[arguments.length];
        for (int i = 0; i < arguments.length; i++) {
            this.arguments[i] = new TypeStruct(arguments[i]);
        }
        this.returnType = returnType == null ? Types.VOID : new TypeStruct(returnType);
        this.updateContent = updateContent;
    }

//    public MethodStruct(String className, String methodName, boolean updateContent, TypeStruct returnType, TypeStruct... arguments) {
//        this.className = className;
//        this.methodName = methodName;
//        this.arguments = arguments;
//        this.returnType = returnType;
//        this.updateContent = updateContent;
//    }

    public boolean isUpdateContent() {
        return updateContent;
    }

    public TypeStruct[] getArguments() {
        return arguments;
    }

    public String getClassName() {
        return className;
    }

    public String getMethodName() {
        return methodName;
    }

    public TypeStruct getReturnType() {
        return returnType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MethodStruct that = (MethodStruct) o;

        if (updateContent != that.updateContent) return false;
        if (!Arrays.equals(arguments, that.arguments)) return false;
        if (className != null ? !className.equals(that.className) : that.className != null) return false;
        if (methodName != null ? !methodName.equals(that.methodName) : that.methodName != null) return false;
        if (returnType != null ? !returnType.equals(that.returnType) : that.returnType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = className != null ? className.hashCode() : 0;
        result = 31 * result + (methodName != null ? methodName.hashCode() : 0);
        result = 31 * result + (arguments != null ? Arrays.hashCode(arguments) : 0);
        result = 31 * result + (returnType != null ? returnType.hashCode() : 0);
        result = 31 * result + (updateContent ? 1 : 0);
        return result;
    }
}
