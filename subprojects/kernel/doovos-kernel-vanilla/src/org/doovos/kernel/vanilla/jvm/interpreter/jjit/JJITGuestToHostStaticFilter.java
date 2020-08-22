/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit;

import org.doovos.kernel.api.jvm.jni.KJNIMethodInfo;

/**
 *
 * @author vpc
 */
public interface JJITGuestToHostStaticFilter {

    public abstract KJNIMethodInfo getImpl(String className, String methodSignature) ;
}
