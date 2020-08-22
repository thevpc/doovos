/**
 * ====================================================================
 *             Doovos (Distributed Object Oriented Operating System)
 *
 * Doovos is a new Open Source Distributed Object Oriented Operating System
 * Design and implementation based on the Java Platform.
 * Actually, it is a try for designing a distributed operation system in
 * top of existing centralized/network OS.
 * Designed OS will follow the object oriented architecture for redefining
 * all OS resources (memory,process,file system,device,...etc.) in a highly
 * distributed context.
 * Doovos is also a distributed Java virtual machine that implements JVM
 * specification on top the distributed resources context.
 *
 * Doovos JAVA JNI is the native implementation (in Doovos sens so in java)
 * of the hotspot java libraries (provided by sun).
 * JNI code is executed on host JVM (in doovos kernel mode)
 *
 * Copyright (C) 2008-2010 Taha BEN SALAH
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 * ====================================================================
 */
package jni.java.lang;

import org.doovos.kernel.api.jvm.jni.JNICLASS;
import org.doovos.kernel.api.jvm.jni.JNICALL;
import org.doovos.kernel.api.jvm.jni.JNIEnv;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 3 mai 2009
 * Time: 04:21:26
 * To change this template use File | Settings | File Templates.
 */
@JNICLASS("java.lang.StrictMath")
public class StrictMathJNI {

    @JNICALL
    public static  double sin(JNIEnv env,double a){
        return StrictMath.sin(a);
    }

    @JNICALL
    public static  double cos(JNIEnv env,double a){
        return StrictMath.cos(a);
    }

    @JNICALL
    public static  double tan(JNIEnv env,double a){
        return StrictMath.tan(a);
    }
    @JNICALL
    public static  double asin(JNIEnv env,double a){
        return StrictMath.asin(a);
    }

    @JNICALL
    public static  double acos(JNIEnv env,double a){
        return StrictMath.acos(a);
    }

    @JNICALL
    public static  double atan(JNIEnv env,double a){
        return StrictMath.atan(a);
    }

    @JNICALL
    public static  double exp(JNIEnv env,double a){
        return StrictMath.exp(a);
    }

    @JNICALL
    public static  double log(JNIEnv env,double a){
        return StrictMath.log(a);
    }


    @JNICALL
    public static  double log10(JNIEnv env,double a){
        return StrictMath.log10(a);
    }

    @JNICALL
    public static  double sqrt(JNIEnv env,double a){
        return StrictMath.sqrt(a);
    }

    @JNICALL
    public static  double cbrt(JNIEnv env,double a){
        return StrictMath.cbrt(a);
    }

    @JNICALL
    public static  double IEEEremainder(JNIEnv env,double f1, double f2){
        return StrictMath.IEEEremainder(f1,f2);
    }

    @JNICALL
    public static  double ceil(JNIEnv env,double a){
        return StrictMath.ceil(a);
    }

    @JNICALL
    public static  double floor(JNIEnv env,double a){
        return StrictMath.floor(a);
    }


    @JNICALL
    public static  double atan2(JNIEnv env,double y, double x){
        return StrictMath.atan2(y,x);
    }


    @JNICALL
    public static  double pow(JNIEnv env,double a, double b){
        return StrictMath.pow(a,b);
    }


    @JNICALL
    public static  double sinh(JNIEnv env,double x){
        return StrictMath.sinh(x);
    }

    @JNICALL
    public static  double cosh(JNIEnv env,double x){
        return StrictMath.cosh(x);
    }

    @JNICALL
    public static  double tanh(JNIEnv env,double x){
        return StrictMath.tanh(x);
    }

    @JNICALL
    public static  double hypot(JNIEnv env,double x, double y){
        return StrictMath.hypot(x,y);
    }

    @JNICALL
    public static  double expm1(JNIEnv env,double x){
        return StrictMath.expm1(x);
    }

    @JNICALL
    public static  double log1p(JNIEnv env,double x){
        return StrictMath.log1p(x);
    }
}
