package org.doovos.kernel.api.jvm.jni;

import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.KRegister;

public interface KJNIMethod {
    KRegister invoke(KFrame frame, KRegister[] parameters) throws KJNIInvocationException;
}
