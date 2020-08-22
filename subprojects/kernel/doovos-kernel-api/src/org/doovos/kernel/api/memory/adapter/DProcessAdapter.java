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
 * Doovos Kernel is the heart of Doovos OS. It implements also the Doovos JVM
 * Doovos Kernel code is executed on host JVM
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
package org.doovos.kernel.api.memory.adapter;

import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.memory.KInteger;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.process.KProcess;

import java.rmi.RemoteException;
import org.doovos.kernel.api.jvm.jni.JNIEnv;
import org.doovos.kernel.api.jvm.reflect.KMethod;

public class DProcessAdapter extends AbstractFieldsMemoryAdapter {
    private StringAdapter path;
    private StringAdapter cwd;
    private StringAdapter user;
    private StringAdapter commandLine;
    private StringArrayAdapter arguments;
    private StringArrayAdapter command;
    private MapAdapter metadata;
    private MapAdapter envs;
    private SimpleClassAdapter threadGroup;
    private int pid;
    private int ppid;
    private KMethod setEnvMethod; 
    private KMethod getEnvMethod; 

    private DProcessAdapter() throws RemoteException {

    }

    public static DProcessAdapter newInstance(KProcess process) throws RemoteException {
        DProcessAdapter p = new DProcessAdapter();
        p.setProcess(process);
        p.setKClass(process.getClassRepository().getClassByName("org.doovos.api.DProcess"));
        p.setReference(process.getMemorySegment().allocObject(p.getKClass()));
        p.setPath(process.getPath());
        return p;
    }

    public DProcessAdapter(KProcess process, KReference reference) throws RemoteException {
        super(process, Doovos.getSystem().getMemoryManager().getPointer(reference).getKClass(), reference);
    }


    protected void reload() throws RemoteException {
        commandLine = getCommandLine0();
        path = getPath0();
        cwd = getCwd0();
        user = getUser0();
        arguments = getArguments0();
        command = loadStringArrayAdapter("command", false);

        envs = getEnvs0();
        metadata = getMetadata0();
        pid = getPID0();
        ppid = getParentPID0();
        threadGroup = getThreadGroup0();
    }

    public StringArrayAdapter getArguments0() throws RemoteException {
        return loadStringArrayAdapter("arguments", false);
    }

    public StringAdapter getCommandLine0() throws RemoteException {
        return loadStringAdapter("commandLine", false);
    }

    public StringAdapter getCwd0() throws RemoteException {
        return loadStringAdapter("cwd", false);
    }

    public StringAdapter getPath0() throws RemoteException {
        return loadStringAdapter("path", true);
    }

    public StringAdapter getUser0() throws RemoteException {
        return loadStringAdapter("user", false);
    }

    private MapAdapter getEnvs0() throws RemoteException {
        KReference envRef = loadReference("envs", false);
        return envRef.isNull() ? null : new MapAdapter(getProcess(), envRef);
    }

    public MapAdapter getMetadata0() throws RemoteException {
        KReference mdRef = loadReference("metadata", false);
        return mdRef.isNull() ? null : new MapAdapter(getProcess(), mdRef);
    }
    public int getPID0() throws RemoteException {
        return loadInt("pid", false);
    }

    public int getParentPID0() throws RemoteException {
        return loadInt("ppid", false);
    }

    public SimpleClassAdapter getThreadGroup0() throws RemoteException {
        KReference kReference = loadReference("threadGroup", false);
        return kReference == null ? null : new SimpleClassAdapter(getProcess(), kReference);
    }

    public StringArrayAdapter getArguments() throws RemoteException {
        checkLoaded();
        return arguments;
    }

    public StringArrayAdapter getCommand() throws RemoteException {
        checkLoaded();
        return command;
    }

    public MapAdapter getEnvs() throws RemoteException {
        checkLoaded();
        return envs;
    }

    public MapAdapter getMetadata() throws RemoteException {
        checkLoaded();
        return metadata;
    }

    public StringAdapter getCommandLine() throws RemoteException {
        checkLoaded();
        return commandLine;
    }

    public int getPID() throws RemoteException {
        checkLoaded();
        return pid;
    }

    public int getParentPID() throws RemoteException {
        checkLoaded();
        return ppid;
    }

    public void setPID(int pid) throws RemoteException {
        invalidate();
        getKClass().getField("pid", false).setInstanceValue(getReference(), new KInteger(pid));
    }

    public void setPath(String path) throws RemoteException {
        invalidate();
        getKClass().getField("path", true).setInstanceValue(getReference(), getProcess().getMemorySegment().allocString(path));
    }

    public void setUser(String user) throws RemoteException {
        invalidate();
        getKClass().getField("user", false).setInstanceValue(getReference(), getProcess().getMemorySegment().allocString(user));
    }

    public void setParentPID(int ppid) throws RemoteException {
        invalidate();
        getKClass().getField("ppid", false).setInstanceValue(getReference(), new KInteger(ppid));
    }

    public void setArguments(StringArrayAdapter args) throws RemoteException {
        invalidate();
        storeReferenceAdapter("arguments", false, args, getReference());
    }

    public void setRawMetadata(StringArrayAdapter argsmetadata) throws RemoteException {
        invalidate();
        storeReferenceAdapter("rawMetadata", false, argsmetadata, getReference());
    }

//    public void setEnvs(MapAdapter envs) throws RemoteException {
//        invalidate();
//        storeReferenceAdapter("envs", false, envs, getReference());
//    }

    public void setCommand(StringArrayAdapter command) throws RemoteException {
        invalidate();
        storeReferenceAdapter("command", false, command, getReference());
    }

    public void setRawEnvs(StringArrayAdapter command) throws RemoteException {
        invalidate();
        storeReferenceAdapter("rawEnvs", false, command, getReference());
    }

    public void setCwd(StringAdapter cwd) throws RemoteException {
        invalidate();
        storeReferenceAdapter("cwd", false, cwd, getReference());
        //TODO SHOULD CALL setEnv
        //setEnv(DoovosConstants.ENV_SYSTEM_WORKING_DIR, cwd.getValue());
    }

    public void setCommandLine(StringAdapter commandLine) throws RemoteException {
        invalidate();
        storeReferenceAdapter("commandLine", false, commandLine, getReference());
    }
    
    public void setEnv(JNIEnv env,String k,String v) throws Exception{
        if (setEnvMethod == null) {
            setEnvMethod = getKClass().getMethodBySignature("setEnv(Ljava/lang/String;Ljava/lang/String;)V");
        }
        final KMemorySegment m = env.getMemorySegment();
        KReference kr=k==null?KReference.NULL:m.allocString(k);
        KReference vr=v==null?KReference.NULL:m.allocString(v);
        env.invokeObjectMethod(setEnvMethod, getReference(), kr, vr);
    }
    public String getEnv(JNIEnv env,String k) throws Exception{
        if (getEnvMethod == null) {
            getEnvMethod = getKClass().getMethodBySignature("getEnv(Ljava/lang/String;)Ljava/lang/String;");
        }
        final KMemorySegment m = env.getMemorySegment();
        KReference kr=k==null?KReference.NULL:m.allocString(k);
        KReference vr=(KReference)env.invokeObjectMethod(getEnvMethod, getReference(), kr);
        if(vr.isNull()){
            return null;
        }
        return m.getString(vr.pointer);
    }
//    public ProcessEnvAdapter getEnv(JNIEnv env,String envName) throws RemoteException {
//        int len = getEnvs().get(env, Doovos.getSystem().getMemoryManager());
//        for (int i = 0; i < len; i++) {
//            ProcessEnvAdapter v = getEnvs().getEnv(i);
//            if (v.getKey().getValue().equals(envName)) {
//                return v;
//            }
//        }
//        return null;
//    }
//
//    public void setEnv(String envName, String value) throws RemoteException {
//        ProcessEnvAdapter e = getEnv(envName);
//        if (e != null) {
//            if (value == null) {
//                ProcessEnvArrayAdapter newEnvs = new ProcessEnvArrayAdapter(getProcess(), getEnvs().length() - 1);
//                int len = getEnvs().length();
//                int index = 0;
//                for (int i = 0; i < len; i++) {
//                    ProcessEnvAdapter v = getEnvs().getEnv(i);
//                    if (!v.getKey().getValue().equals(envName)) {
//                        newEnvs.setEnv(index, v);
//                        index++;
//                    }
//                }
//                setEnvs(newEnvs);
//            } else {
//                e.setValue(new StringAdapter(getProcess(), value));
//            }
//        } else {
//            if (value != null) {
//                ProcessEnvArrayAdapter newEnvs = new ProcessEnvArrayAdapter(getProcess(), getEnvs().length() + 1);
//                int len = getEnvs().length();
//                for (int i = 0; i < len; i++) {
//                    newEnvs.setArrayReference(i, getEnvs().getArrayReference(i));
//                }
//                newEnvs.setEnv(len, new ProcessEnvAdapter(getProcess(), envName, value, false));
//                setEnvs(newEnvs);
//            }
//        }
//    }

//    public StringPairAdapter getMetadata(String name) throws RemoteException {
//        int len = getMetadata().length();
//        for (int i = 0; i < len; i++) {
//            StringPairAdapter v = getMetadata().getStringPair(i);
//            if (v.getKey().getValue().equals(name)) {
//                return v;
//            }
//        }
//        return null;
//    }
//
//    public void setMetadata(String name, String value) throws RemoteException {
//        StringPairAdapter e = getMetadata(name);
//        if (e != null) {
//            if (value == null) {
//                StringPairArrayAdapter newArray = new StringPairArrayAdapter(getProcess(), getMetadata().length() - 1);
//                int len = getMetadata().length();
//                int index = 0;
//                for (int i = 0; i < len; i++) {
//                    StringPairAdapter v = getMetadata().getStringPair(i);
//                    if (!v.getKey().getValue().equals(name)) {
//                        newArray.setItemRef(index, v);
//                        index++;
//                    }
//                }
//                setMetadata(newArray);
//            } else {
//                e.setValue(new StringAdapter(getProcess(), value));
//            }
//        } else {
//            if (value != null) {
//                StringPairArrayAdapter newArray = new StringPairArrayAdapter(getProcess(), getMetadata().length() + 1);
//                int len = getMetadata().length();
//                for (int i = 0; i < len; i++) {
//                    newArray.setArrayReference(i, getMetadata().getArrayReference(i));
//                }
//                newArray.setItemRef(len, new StringPairAdapter(getProcess(), name, value));
//                setMetadata(newArray);
//            }
//        }
//    }

    public StringAdapter getCwd() throws RemoteException {
        checkLoaded();
        return cwd;
    }

    public StringAdapter getPath() throws RemoteException {
        checkLoaded();
        return path;
    }

    public StringAdapter getUser() throws RemoteException {
        checkLoaded();
        return user;
    }

    public SimpleClassAdapter getThreadGroup() throws RemoteException {
        checkLoaded();
        return threadGroup;
    }

    public void setThreadGroup(SimpleClassAdapter threadGroup) throws RemoteException {
        this.threadGroup = threadGroup;
        storeReferenceAdapter("threadGroup", false, threadGroup, getReference());
        invalidate();
    }
}
