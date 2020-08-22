package org.doovos.kernel.core.jvm.jni;

import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.jni.*;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.core.util.KUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.rmi.RemoteException;


class KJNINativeMethodImpl implements KJNIMethod {

    private KJNIMethodInfo jniDef;
    private String signature;
    private String key;
    private Object instance;
    private Method javaMethod;
    private NativeParam[] params;
    private KUtils.KRegisterFactory returnFactory;
    private boolean procedure;
    private String classNamePath;

    KJNINativeMethodImpl(Object instance, Method javaMethod, String classNamePath) {
//        if (!Modifier.isPublic(javaMethod.getModifiers())) {
//            throw new KJNIException("JNICALL must be public : " + javaMethod);
//        }
        JNICALL annotationJNICALL = javaMethod.getAnnotation(JNICALL.class);
        String preferredMethodName = annotationJNICALL.value();
        if (preferredMethodName == null || preferredMethodName.length() == 0) {
            preferredMethodName = javaMethod.getName();
        }
        Class<?>[] parameterTypes = javaMethod.getParameterTypes();
        Annotation[][] parameterAnnotation = javaMethod.getParameterAnnotations();
        int prefix;
        if (Modifier.isStatic(javaMethod.getModifiers())) {
            if (parameterTypes.length < 1 || !JNIEnv.class.equals(parameterTypes[0])) {
                throw new KJNIException("static methods should have as first arg a JNIEnv instance : " + javaMethod);
            }
            prefix = 1;
        } else {
            if (parameterTypes.length < 2 || !JNIEnv.class.equals(parameterTypes[0]) || !KReference.class.equals(parameterTypes[1])) {
                throw new KJNIException("instance methods should have as first arg a JNIEnv instance and THIS reference : " + javaMethod);
            }
            if (NativeLibrariesRepository.containsAnnotation(parameterAnnotation[1], THIS.class) == null) {
                throw new KJNIException("instance methods should have THIS reference : " + javaMethod);
            }
            prefix = 2;
        }

        String[] javaMethodParamStrings = new String[parameterTypes.length];
        String[] specParameterTypes = new String[parameterTypes.length];
        StringBuilder typeNames = new StringBuilder();
        for (int i = prefix; i < parameterTypes.length; i++) {
            Class cls = parameterTypes[i];
            javaMethodParamStrings[i] = cls.getName();
            try {
                typeNames.append(NativeLibrariesRepository.toParamCanonicalName(cls, parameterAnnotation[i], javaMethod));
                specParameterTypes[i] = NativeLibrariesRepository.toParamTypeName(cls, parameterAnnotation[i], javaMethod);
            } catch (Exception e) {
                throw new KJNIException(e.getMessage() + " : " + javaMethod, e);
            }
        }
        Class returnType = javaMethod.getReturnType();
        this.signature = preferredMethodName + "(" + typeNames + ")" + NativeLibrariesRepository.toReturnTypeCanonicalName(returnType, javaMethod.getAnnotations(), javaMethod)

        ;
        this.key = (classNamePath + "." + signature);
        this.instance = instance;
        this.javaMethod = javaMethod;

        this.jniDef = new KJNIMethodInfo(key, classNamePath, preferredMethodName, specParameterTypes, javaMethod.getDeclaringClass().getName(), javaMethod.getName(), javaMethodParamStrings);


        params = new NativeParam[parameterTypes.length];
        //ignore first param JNIEnv
        for (int i = 1; i < parameterTypes.length; i++) {
            Class parameterType = parameterTypes[i];
            params[i] = NativeLibrariesRepository.getNativeParam(parameterType.getName());
            if (params[i] == null) {
                throw new IllegalArgumentException("param " + (i + 1) + " " + parameterType + " is of unsupported type in " + key);
            }
        }
        procedure = (Void.TYPE.equals(returnType));
        if (!procedure) {
            try {
                returnFactory = KUtils.toRegisterFactory(returnType);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(e.getMessage() + " in " + key);
            }
        }
    }

    public String getKey() {
        return key;
    }

    public KJNIMethodInfo getJniDef() {
        return jniDef;
    }

    @Override
    public String toString() {
        return "NativeMethod{"
                + "key=" + key
                + ", javaMethod=" + javaMethod
                + ", instance=" + instance
                + '}';
    }


    public KRegister invoke(KFrame frame, KRegister[] parameters) throws KJNIInvocationException {
//        int dotIndex= methodId.indexOf('(');
//        if(dotIndex>0){
//            methodId = methodId.substring(0,dotIndex);
//        }
        try {
            int parameters_length = parameters.length;
            Object[] args = new Object[parameters_length + 1];
            args[0] = frame;
            NativeParam[] _params = this.params;
            for (int i = parameters_length - 1; i >= 0; i--) {
                KRegister parameter = parameters[i];
                args[i + 1] = (_params[i + 1].toHost(parameter, frame));
            }
            Object o = null;
            o = javaMethod.invoke(instance, args);

            if (o == null) {
                return KReference.NULL;
            } else {
                return returnFactory.toRegister(o, frame.getMemorySegment());
            }
        } catch (IllegalAccessException e) {
            throw new  KJNIInvocationException(e);
        } catch (InvocationTargetException e) {
            Throwable e3 = e.getCause();
            if (e3 instanceof RuntimeException) {
                throw (RuntimeException) e3;
            }
            throw new  KJNIInvocationException(e3);
        } catch (RemoteException e) {
            throw new  KJNIInvocationException(e);
        }
    }

    public String getSignature() {
        return signature;
    }
}
