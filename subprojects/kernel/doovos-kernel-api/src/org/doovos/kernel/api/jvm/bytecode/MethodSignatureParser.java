/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.api.jvm.bytecode;

import org.doovos.kernel.api.util.JavaByteCodeUtils;

/**
 *
 * @author vpc
 */
public class MethodSignatureParser {
    private String signature;
    private String className;
    private String methodName;
    private String[] arguments;
    private String returnType;

    public MethodSignatureParser(String signature) {
        this.signature = signature;
        int openBraket=signature.indexOf('(');
        int closeBraket=signature.indexOf(')',openBraket+1);
        int endClassName=signature.lastIndexOf('.',openBraket-1);
        className=signature.substring(0,endClassName);
        methodName=signature.substring(endClassName+1,openBraket);
        String types=signature.substring(openBraket+1,closeBraket);
        String rtype=signature.substring(closeBraket+1);
        arguments=JavaByteCodeUtils.getMethodTypeCodes0(types);
        returnType=JavaByteCodeUtils.getMethodTypeCodes0(rtype)[0];
    }

    public String[] getArguments() {
        return arguments;
    }

    public String getClassName() {
        return className;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getReturnType() {
        return returnType;
    }

    public String getSignature() {
        return signature;
    }
    
    
}
