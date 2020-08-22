/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.doovos.kernel.api.jvm.jni;

import org.doovos.kernel.api.util.JavaByteCodeUtils;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author vpc
 */
public class KJNIMethodInfo implements Serializable{
    private String implClassName;
    private String implMethodName;
    private String[] implParameterTypes;
    private String specMethodDesc;
    private String specClassName;
    private String specMethodName;
    private String[] specParameterTypes;

    public KJNIMethodInfo(String fullMethodSig, String implClassName, String implMethodName, String[] implParameterTypes) {
        specMethodDesc = fullMethodSig;
        String classAndMethod = fullMethodSig.substring(0, fullMethodSig.indexOf('('));
        int c2m = classAndMethod.lastIndexOf('.');
        specClassName = classAndMethod.substring(0, c2m);
        specMethodName = classAndMethod.substring(c2m+1);
        specParameterTypes = JavaByteCodeUtils.getMethodTypes(fullMethodSig);
        this.implClassName = implClassName==null?specClassName:implClassName;
        this.implMethodName = implMethodName==null?specMethodName:implMethodName;
        this.implParameterTypes = implParameterTypes==null?specParameterTypes:implParameterTypes;
    }

    public KJNIMethodInfo(String specMethodDesc, String specClassName, String specMethodName, String[] specParameterTypes, String implClassName, String implMethodName, String[] implParameterTypes) {
        this.specMethodDesc = specMethodDesc;
        this.specClassName = specClassName;
        this.specMethodName = specMethodName;
        this.specParameterTypes = specParameterTypes;

        this.implClassName = implClassName;
        this.implMethodName = implMethodName;
        this.implParameterTypes = implParameterTypes;
    }

    public String getImplClassName() {
        return implClassName;
    }

    public String getImplMethodName() {
        return implMethodName;
    }

    public String[] getImplParameterTypes() {
        return implParameterTypes;
    }

    public String getSpecClassName() {
        return specClassName;
    }

    public String getSpecMethodDesc() {
        return specMethodDesc;
    }

    public String getSpecMethodName() {
        return specMethodName;
    }

    public String[] getSpecParameterTypes() {
        return specParameterTypes;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KJNIMethodInfo other = (KJNIMethodInfo) obj;
        if ((this.implClassName == null) ? (other.implClassName != null) : !this.implClassName.equals(other.implClassName)) {
            return false;
        }
        if ((this.implMethodName == null) ? (other.implMethodName != null) : !this.implMethodName.equals(other.implMethodName)) {
            return false;
        }
        if (!Arrays.deepEquals(this.implParameterTypes, other.implParameterTypes)) {
            return false;
        }
        if ((this.specMethodDesc == null) ? (other.specMethodDesc != null) : !this.specMethodDesc.equals(other.specMethodDesc)) {
            return false;
        }
        if ((this.specClassName == null) ? (other.specClassName != null) : !this.specClassName.equals(other.specClassName)) {
            return false;
        }
        if ((this.specMethodName == null) ? (other.specMethodName != null) : !this.specMethodName.equals(other.specMethodName)) {
            return false;
        }
        if (!Arrays.deepEquals(this.specParameterTypes, other.specParameterTypes)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.implClassName != null ? this.implClassName.hashCode() : 0);
        hash = 17 * hash + (this.implMethodName != null ? this.implMethodName.hashCode() : 0);
        hash = 17 * hash + Arrays.deepHashCode(this.implParameterTypes);
        hash = 17 * hash + (this.specMethodDesc != null ? this.specMethodDesc.hashCode() : 0);
        hash = 17 * hash + (this.specClassName != null ? this.specClassName.hashCode() : 0);
        hash = 17 * hash + (this.specMethodName != null ? this.specMethodName.hashCode() : 0);
        hash = 17 * hash + Arrays.deepHashCode(this.specParameterTypes);
        return hash;
    }

    
}
