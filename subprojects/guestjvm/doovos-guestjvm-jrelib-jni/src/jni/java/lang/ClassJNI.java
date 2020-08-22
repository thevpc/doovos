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

import org.doovos.kernel.api.jvm.jni.JNIEnv;
import org.doovos.kernel.api.jvm.jni.THIS;
import org.doovos.kernel.api.jvm.jni.JNIPARAM;
import org.doovos.kernel.api.jvm.jni.JNICLASS;
import org.doovos.kernel.api.jvm.jni.JNICALL;
import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.memory.adapter.RefArrayAdapter;
import org.doovos.kernel.api.memory.adapter.SimpleClassAdapter;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.api.jvm.bytecode.KClassDef;
import org.doovos.kernel.api.jvm.bytecode.KFieldDef;
import org.doovos.kernel.api.jvm.bytecode.KMethodDef;
import org.doovos.kernel.api.jvm.bytecode.KParameterDef;

import java.lang.reflect.Modifier;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import org.doovos.kernel.api.memory.adapter.DSiteArrayAdapter;

@JNICLASS("java.lang.Class")
public class ClassJNI {
    private static final KMemoryManager memoryManager = Doovos.getSystem().getMemoryManager();

    @JNICALL
    public static void registerNatives(JNIEnv env) throws RemoteException {
    }

    @JNICALL
    public String getName0(JNIEnv env, @THIS KReference ref) throws RemoteException {
        return env.getClassRepository().getClassByGuestReference(ref).getName();
    }

    @JNICALL(returnType = "java.lang.Class")
    public /*Class<?>*/ KReference getComponentType(JNIEnv env, @THIS KReference ref) throws RemoteException {
        KClassRepository repo = env.getClassRepository();
        KClass klass = repo.getClassByGuestReference(ref);
        if (klass.isArray()) {

            return klass.getArrayComponent().getGuestReference();
        }
        return null;
    }

    @JNICALL(returnType = "java.lang.Class")
    public static KReference getPrimitiveClass(JNIEnv env, String name) throws RemoteException {
        KClass byName = env.getClassRepository().getClassByName(name);
        return byName.getGuestReference();
    }

    @JNICALL(returnType = "java.lang.Class")
    public /*Class*/ KReference getSuperclass(JNIEnv env, @THIS KReference ref) throws RemoteException {
        KClassRepository repo = env.getClassRepository();
        KClass klass = repo.getClassByGuestReference(ref);
        final KClass sc = klass.getSuperClass();
        return sc==null?KReference.NULL:sc.getGuestReference();
//        if (!Modifier.isInterface(klass.getDefinition().getModifiers())) {
//            String className = klass.getDefinition().getSuperClassName();
//            if (className == null) {
//                return null;
//            }
//            return repo.getClassByName(className).getGuestReference();
//        }
//        return repo.getClassByName("java.lang.Object").getGuestReference();
    }

    @JNICALL(returnType = "java.lang.Class")
    public static /*Class*/ KReference forName0(JNIEnv env, @JNIPARAM("java.lang.String") KReference name, boolean initialize,
            @JNIPARAM("java.lang.ClassLoader") KReference loader) throws Exception {
        KClassRepository repo = env.getClassRepository();
        String nameString = memoryManager.getString(name);
        KClass byName = repo.getClassByName(nameString);
        if (initialize) {
            env.invokeClassInitializer(byName);
        }
        return byName.getGuestReference();
    }

    @JNICALL(returnType = "java.lang.Class[]")
    public /*Class[]*/ KReference getInterfaces(JNIEnv env,@THIS KReference ref) throws Exception {
        KClassRepository repo = env.getClassRepository();
        KClass klass = repo.getClassByGuestReference(ref);
        KClassDef[] superInterfaces = klass.getDefinition().getSuperInterfaces();
        RefArrayAdapter guestArr=new DSiteArrayAdapter(env.getProcess(), superInterfaces.length);
        for (int i = 0; i < superInterfaces.length; i++) {
            KClassDef kClassDef = superInterfaces[i];
            guestArr.setArrayReference(i, repo.getClassByName(kClassDef.getName()).getGuestReference());
        }
        return guestArr.getReference();
    }

    @JNICALL
    public boolean isInstance(JNIEnv env, @THIS KReference ref, @JNIPARAM("java.lang.Object") KReference obj) throws RemoteException {
        return env.getClassRepository().getClassByGuestReference(ref).isAssignableFrom(obj);
    }

    @JNICALL
    public boolean isAssignableFrom(JNIEnv env, @THIS KReference ref, @JNIPARAM("java.lang.Class") KReference cls) throws RemoteException {
        KClassRepository repo = env.getClassRepository();
        KClass klass = repo.getClassByGuestReference(cls);
        return repo.getClassByGuestReference(ref).isAssignableFrom(klass);
    }

    @JNICALL
    public boolean isInterface(JNIEnv env, @THIS KReference ref) throws RemoteException {
        KClass byJvmReference = env.getClassRepository().getClassByGuestReference(ref);
        return Modifier.isInterface(byJvmReference.getDefinition().getModifiers());
    }

    @JNICALL
    public boolean isArray(JNIEnv env, @THIS KReference ref) throws RemoteException {
        return env.getClassRepository().getClassByGuestReference(ref).isArray();
    }

    @JNICALL
    public boolean isPrimitive(JNIEnv env, @THIS KReference ref) throws RemoteException {
        return env.getClassRepository().getClassByGuestReference(ref).isPrimitive();
    }

    @JNICALL(returnType = "java.lang.ClassLoader")
    public /*ClassLoader*/ KReference getClassLoader0(JNIEnv env, @THIS KReference ref) {
        //TODO FIX ME
        return null;
        //throw new UnsupportedOperationException();
    }

    @JNICALL
    public static boolean desiredAssertionStatus0(JNIEnv env, @JNIPARAM("java.lang.Class") KReference clazz) {
        //TODO FIX ME
        return false;
    }

    @JNICALL(returnType = "java.lang.reflect.Field[]")
    public /*Field[]*/ KReference getDeclaredFields0(JNIEnv env, @THIS KReference ref, boolean publicOnly) throws RemoteException {
        KClassRepository repo = env.getClassRepository();
        KClass klass = repo.getClassByGuestReference(ref);
        KClassDef def = klass.getDefinition();
        int count = def.getFieldsCount();
        RefArrayAdapter fields = RefArrayAdapter.newInstance(env.getProcess(), "java.lang.reflect.Field", count);
        for (int i = 0; i < count; i++) {
            KFieldDef field = def.getField(i);
            SimpleClassAdapter adapter = SimpleClassAdapter.newInstance(env, "java.lang.reflect.Field");
//        this.slot = slot;
//        this.annotations = annotations;
            adapter.setRegister("clazz", klass.getGuestReference());
            adapter.setString("name", field.getName());
            adapter.setReference("type", repo.getClassByName(field.getTypeName()).getGuestReference());
            adapter.setInt("modifiers", field.getModifiers());
            adapter.setInt("slot", 0);
            adapter.setString("signature", "?");
            fields.setArrayReference(i, adapter.getReference());
            //adapter.setInt("signature","?");
        }
        return fields.getReference();
    }

    @JNICALL(returnType = "java.lang.reflect.Method[]")
    public /*Method[]*/ KReference getDeclaredMethods0(JNIEnv env, @THIS KReference ref, boolean publicOnly) throws RemoteException {
        KProcess process = env.getProcess();
        KClassRepository repo = env.getClassRepository();
        KClass klass = repo.getClassByGuestReference(ref);
        KClassDef def = klass.getDefinition();
        int count = def.getMethodsCount();
        RefArrayAdapter methods = RefArrayAdapter.newInstance(env.getProcess(), "java.lang.reflect.Method", count);
        for (int i = 0; i < count; i++) {
            KMethodDef method = def.getMethod(i);
            SimpleClassAdapter adapter = SimpleClassAdapter.newInstance(env, "java.lang.reflect.Method");
//            this.clazz = declaringClass;
//            this.name = name;
//            this.returnType = returnType;
//            this.modifiers = modifiers;
//            this.slot = slot;
//            this.signature = signature;
//            this.parameterTypes = parameterTypes;
//            this.exceptionTypes = checkedExceptions;

//            this.annotations = annotations;
//            this.parameterAnnotations = parameterAnnotations;
//            this.annotationDefault = annotationDefault;
            adapter.setRegister("clazz", klass.getGuestReference());
            adapter.setString("name", method.getName());
            adapter.setReference("returnType", repo.getClassByName(method.getReturnType()).getGuestReference());
            adapter.setInt("modifiers", method.getModifiers());
            adapter.setInt("slot", 0);
            adapter.setString("signature", method.getSignature());

            List<KReference> types = new ArrayList<KReference>();
            for (KParameterDef param : method.getParameters()) {
                types.add(repo.getClassByName(param.getType()).getGuestReference());
            }
            adapter.setReference("parameterTypes", RefArrayAdapter.newInstance(env.getProcess(), "java.lang.Class", types).getReference());

            List<KReference> exceptions = new ArrayList<KReference>();
            for (String ex : method.getExceptionTypes()) {
                exceptions.add(repo.getClassByName(ex).getGuestReference());
            }
            adapter.setReference("exceptionTypes", RefArrayAdapter.newInstance(env.getProcess(), "java.lang.Class", exceptions).getReference());

            methods.setArrayReference(i, adapter.getReference());
            //adapter.setInt("signature","?");
        }
        return methods.getReference();
    }

    @JNICALL(returnType = "java.lang.reflect.Constructor[]")
    public /*Constructor[]*/ KReference getDeclaredConstructors0(JNIEnv env, @THIS KReference ref, boolean publicOnly) throws RemoteException {
        KProcess process = env.getProcess();
        KClassRepository repo = env.getClassRepository();
        KClass klass = repo.getClassByGuestReference(ref);
        ArrayList<KReference> m = new ArrayList<KReference>();
        for (KMethodDef method : klass.getDefinition().getConstructors()) {
            if (!publicOnly || Modifier.isPublic(method.getModifiers())) {
                SimpleClassAdapter adapter = SimpleClassAdapter.newInstance(env, "java.lang.reflect.Constructor");
//                private Class<T>		clazz;
//                private int			slot;
//                private Class[]		parameterTypes;
//                private Class[]		exceptionTypes;
//                private int			modifiers;
//                // Generics and annotations support
//                private transient String    signature;
//                // generic info repository; lazily initialized
//                private transient ConstructorRepository genericInfo;
//                private byte[]              annotations;
//                private byte[]              parameterAnnotations;
                adapter.setReference("clazz", ref);
                adapter.setInt("slot", 0);
                adapter.setInt("modifiers", method.getModifiers());
                adapter.setString("signature", method.getSignature());
                List<KReference> types = new ArrayList<KReference>();
                for (KParameterDef param : method.getParameters()) {
                    types.add(repo.getClassByName(param.getType()).getGuestReference());
                }
                adapter.setReference("parameterTypes", RefArrayAdapter.newInstance(env.getProcess(), "java.lang.Class", types).getReference());

                List<KReference> exceptions = new ArrayList<KReference>();
                for (String ex : method.getExceptionTypes()) {
                    exceptions.add(repo.getClassByName(ex).getGuestReference());
                }
                adapter.setReference("exceptionTypes", RefArrayAdapter.newInstance(env.getProcess(), "java.lang.Class", exceptions).getReference());
                m.add(adapter.getReference());
            }
        }
        return RefArrayAdapter.newInstance(process, "java.lang.reflect.Constructor", m).getReference();
    }

    @JNICALL(returnType = "java.lang.Class[]")
    public /*Class[]*/ KReference getDeclaredClasses0(JNIEnv env, @THIS KReference ref) throws RemoteException {
        KClassRepository repo = env.getClassRepository();
        KClass klass = repo.getClassByGuestReference(ref);
        throw new UnsupportedOperationException();
    }

    @JNICALL
    public int getModifiers(JNIEnv env, @THIS KReference ref) throws RemoteException {
        return env.getClassRepository().getClassByGuestReference(ref).getDefinition().getModifiers();
    }

    /**
     * Gets the signers of this class.
     *
     * @return the signers of this class, or null if there are no signers.  In
     *         particular, this method returns null if this object represents
     *         a primitive type or void.
     * @since JDK1.1
     */
    @JNICALL(returnType = "java.lang.Object[]")
    public /*Object[]*/ KReference getSigners(JNIEnv env, @THIS KReference ref) {
        //TODO fix me
        return null;
    }

    /**
     * Set the signers of this class.
     */
    @JNICALL
    public void setSigners(JNIEnv env, @THIS KReference ref, @JNIPARAM("java.lang.Object[]") KReference signers) {
        //TODO FIX ME
    }
}
