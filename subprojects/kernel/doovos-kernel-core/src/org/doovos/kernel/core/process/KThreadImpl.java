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
package org.doovos.kernel.core.process;

import org.doovos.kernel.api.KFactory;
import org.doovos.kernel.api.filesystem.KPropertyEvent;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.interpreter.KInterpreter;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.process.KResourceBlocking;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcessLiveStatus;
import org.doovos.kernel.api.process.KProcessRequestedStatus;
import org.doovos.kernel.api.process.KProcessCache;
import org.doovos.kernel.api.process.KProcess;

import java.io.PrintStream;

import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.DoovosConstants;
import org.doovos.kernel.api.jvm.interpreter.KEndOfThreadException;
import org.doovos.kernel.api.jvm.bytecode.KMethodDef;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.filesystem.KResourceType;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.memory.KRegister;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import org.doovos.kernel.api.jvm.bytecode.KClassDef;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.site.KLocalSite;
import org.doovos.kernel.core.filesystem.KPrefixedPathRuntimeResourceImpl;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 11 oct. 2004
 * Time: 15:37:03
 */
public final class KThreadImpl extends KPrefixedPathRuntimeResourceImpl implements KLocalThread, Cloneable {

    private static final Doovos SYSTEM = Doovos.getSystem();
    private static final KLocalSite LOCAL_SITE = SYSTEM.getLocalSite();
    private /*KProcessLiveStatus*/ int liveStatus = KProcessLiveStatus.INIT;
    //private transient KProcessSchedulerThread scheduler = null;
    private KProcessCache cache;
    private int parentPID;
    private int framesCount = -1;
    private KFrame[] frames = new KFrame[40];
    private final Object depsLock = new Object();
    private KResourceBlocking[] deps = KResourceBlocking.EMPTY_ARRAY;
    private KFrame currentFrame;
    private KInterpreter interpreter;
    private KProcess process;
    private KReference guestReference;
    private int priority = 5;
    private boolean started = false;
    private int id;
    private String startClass;
    private String startMethod;
    private KRegister[] startParams;
    private KFactory factory;
    boolean runningNativeThread = false;

    public KThreadImpl(KProcess process, KInterpreter interpreter) throws RemoteException {
        setType(KResourceType.THREAD);
        setLeaf(true);
        //super(KResourceType.THREAD, true, process.getPath() + "/" + DoovosConstants.PROCESS_THREAD_NAME, DoovosConstants.PROCESS_PREFIX, null);
        //setStatus(KProcessLiveStatus.INIT);
    }

    //    public int getLocalChildrenCount() {
//        return 2;
//    }
    public int getParentPID() throws RemoteException {
        return parentPID;
    }

    public int getStatus() throws RemoteException {
        return liveStatus;
    }

    public void setStatus(/*KProcessLiveStatus*/int status) throws RemoteException {
        //Doovos.syslog(id+"."+System.identityHashCode(this) + " : setStatus " + KProcessLiveStatus.toString(liveStatus) + " --> " + KProcessLiveStatus.toString(status));
        liveStatus = status;
    }

    public void requestStatus(/*KProcessRequestedStatus*/int status) throws RemoteException {
        try {
//            int i = statusMatrix[liveStatus/*.ordinal()*/][status/*.ordinal()*/];
//            if(i<0){
//                System.err.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
//                i= statusMatrix[liveStatus/*.ordinal()*/][status/*.ordinal()*/];
//            }
//            liveStatus = i;//cachedProcessLiveStatusValues[i];
            int old = liveStatus;
            liveStatus = KProcessstatusFSA.FSA_MATRIX[liveStatus][status];
            //Doovos.syslog(id+"."+System.identityHashCode(this) + " : requestStatus " + KProcessLiveStatus.toString(old) + " --> " + KProcessLiveStatus.toString(status) + " == " + KProcessLiveStatus.toString(liveStatus));
            if (old != liveStatus) {
                switch (liveStatus) {
                    case KProcessLiveStatus.READY:
                    case KProcessLiveStatus.BLOCKED_READY:
                    case KProcessLiveStatus.SHADOW_READY:
                    case KProcessLiveStatus.INIT_READY: {
                        if (started && !runningNativeThread) {
                            LOCAL_SITE.threadAttachNative(this);
                        }
                        break;
                    }
                }
            }
            //firePropertyEventListener(DoovosConstants.PROPERTY_THREAD_REQUEST_STATUS, DoovosConstants.PROPERTY_NAME_THREAD_REQUEST_STATUS, null, this);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Unknown status Target " + liveStatus + " -> " + status);
            e.printStackTrace();
//            throw new ArrayIndexOutOfBoundsException();
        }
//        int i = liveStatus.ordinal();
//        int j = status.ordinal();
//        liveStatus= KProcessLiveStatus.values()[statusMatrix[i][j]];
    }

    //    public void requestStatus(KProcessRequestedStatus status) throws RemoteException {
//        switch (liveStatus) {
//            case INIT:
//            case INIT_READY:
//            case INIT_BLOCKED:
//            case INIT_SHADOW:
//            case INIT_ZOMBIE: {
//                switch (status) {
//                    case INIT: {
//                        break;
//                    }
//                    case READY: {
//                        liveStatus = KProcessLiveStatus.INIT_READY;
//                        break;
//                    }
//                    case BLOCKED: {
//                        liveStatus = KProcessLiveStatus.INIT_BLOCKED;
//                        break;
//                    }
//                    case SHADOW: {
//                        liveStatus = KProcessLiveStatus.INIT_SHADOW;
//                        break;
//                    }
//                    case ZOMBIE: {
//                        liveStatus = KProcessLiveStatus.INIT_ZOMBIE;
//                        break;
//                    }
//                    default: {
//                        throw new NoSuchElementException();
//                    }
//                }
//                break;
//            }
//            case READY:
//            case READY_RUNNING:
//            case READY_BLOCKED:
//            case READY_SHADOW:
//            case READY_ZOMBIE: {
//                switch (status) {
//                    case READY: {
//                        break;
//                    }
//                    case RUNNING: {
//                        liveStatus = KProcessLiveStatus.READY_RUNNING;
//                        break;
//                    }
//                    case BLOCKED: {
//                        liveStatus = KProcessLiveStatus.READY_BLOCKED;
//                        break;
//                    }
//                    case SHADOW: {
//                        liveStatus = KProcessLiveStatus.READY_SHADOW;
//                        break;
//                    }
//                    case ZOMBIE: {
//                        liveStatus = KProcessLiveStatus.READY_ZOMBIE;
//                        break;
//                    }
//                    default: {
//                        throw new NoSuchElementException();
//                    }
//                }
//                break;
//            }
//            case RUNNING:
//            case RUNNING_BLOCKED:
//            case RUNNING_READY:
//            case RUNNING_SHADOW:
//            case RUNNING_ZOMBIE: {
//                switch (status) {
//                    case READY: {
//                        liveStatus = KProcessLiveStatus.RUNNING_READY;
//                        break;
//                    }
//                    case RUNNING: {
//                        break;
//                    }
//                    case BLOCKED: {
//                        liveStatus = KProcessLiveStatus.RUNNING_BLOCKED;
//                        break;
//                    }
//                    case SHADOW: {
//                        liveStatus = KProcessLiveStatus.RUNNING_SHADOW;
//                        break;
//                    }
//                    case ZOMBIE: {
//                        liveStatus = KProcessLiveStatus.RUNNING_ZOMBIE;
//                        break;
//                    }
//                    default: {
//                        throw new NoSuchElementException();
//                    }
//                }
//                break;
//            }
//            case BLOCKED:
//            case BLOCKED_READY:
//            case BLOCKED_SHADOW:
//            case BLOCKED_ZOMBIE: {
//                switch (status) {
//                    case READY: {
//                        liveStatus = KProcessLiveStatus.BLOCKED_READY;
//                        break;
//                    }
//                    case BLOCKED: {
//                        break;
//                    }
//                    case SHADOW: {
//                        liveStatus = KProcessLiveStatus.BLOCKED_SHADOW;
//                        break;
//                    }
//                    case ZOMBIE: {
//                        liveStatus = KProcessLiveStatus.BLOCKED_ZOMBIE;
//                        break;
//                    }
//                    default: {
//                        throw new NoSuchElementException();
//                    }
//                }
//                break;
//            }
//            case SHADOW: {
//                switch (status) {
//                    case READY: {
//                        liveStatus = KProcessLiveStatus.SHADOW_READY;
//                        break;
//                    }
//                    case SHADOW: {
//                        break;
//                    }
//                    default: {
//                        throw new NoSuchElementException();
//                    }
//                }
//                break;
//            }
//            case ZOMBIE: {
//                switch (status) {
//                    case ZOMBIE: {
//                        break;
//                    }
//                    default: {
//                        throw new NoSuchElementException();
//                    }
//                }
//                break;
//            }
//
//        }
//    }
    @Override
    public void migrateTo(String SiteId) throws RemoteException {
//        setStatus(KProcessStatus.SHADOW);
        requestStatus(KProcessRequestedStatus.SHADOW);
        LOOP:
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            /*KProcessLiveStatus*/
            int actual = getStatus();
            switch (actual) {
                case KProcessLiveStatus.SHADOW:
                case KProcessLiveStatus.SHADOW_READY: {
                    break LOOP;
                }
                case KProcessLiveStatus.ZOMBIE: {
                    return;
                }
            }
        }
        super.migrateTo(SiteId);
    }

    @Override
    public void freeImpl() throws RemoteException {
        started = false;
        interpreter.close();
        requestStatus(KProcessRequestedStatus.ZOMBIE);
        super.freeImpl();
        if (parentPID != -1) {
            //attach my children to my parent
            KProcess parentProcess = SYSTEM.getProcess(parentPID);

            KPropertyEvent event;
            event = new KPropertyEvent(getPath(), getType(), DoovosConstants.PROPERTY_ID_THREAD_DEATH, DoovosConstants.PROPERTY_NAME_PROCESS_THREAD_DEATH, false, true);
            parentProcess.onPropertyEvent(event);
        }
    }

    @Override
    public void attach() throws RemoteException {
        setLeaf(true);
        setParentPath(process.getPath() + "/" + DoovosConstants.PROCESS_THREAD_NAME);
        setPrefix("");
        //super(KResourceType.THREAD, true, process.getPath() + "/" + DoovosConstants.PROCESS_THREAD_NAME, DoovosConstants.PROCESS_PREFIX, null);
        super.attach();
        setParentID(process.getId());
        id = Integer.parseInt(getName());
        if (started && !runningNativeThread) {
            LOCAL_SITE.threadAttachNative(this);
        }
    }

    public void start() throws RemoteException {
        if (!started) {
            started = true;
            if (!runningNativeThread) {
                LOCAL_SITE.threadAttachNative(this);
            }
        } else {
            throw new IllegalArgumentException("thread Already Started");
        }
    }

    public boolean isAlive() throws RemoteException {
        return started;
    }

    @Override
    public boolean isSticky() throws RemoteException {
        return false;
    }

    public void sleep(long time) throws RemoteException {
        addDependency(new KRelativeTimeResourceBlocking(SYSTEM.currentTimeMillis() + time));
    }

    public KFrame pushInvokeInstance(KMethod method) throws RemoteException {
        KRegister[] args = new KRegister[method.getParametersCount()];
        KFrame frame = currentFrame;
        for (int j = args.length - 1; j >= 0; j--) {
            args[j] = frame.pop();
        }
        return pushFrame(method, args);
    }

    public KFrame pushInvokeStatic(KMethod method) throws RemoteException {
        KRegister[] args = new KRegister[method.getParametersCount() + 1];
        KFrame frame = currentFrame;
        for (int j = args.length - 1; j >= 0; j--) {
            args[j] = frame.pop();
        }
        /*p.getClassRepository().getClassByName(methodByName.getClassName())*/
        return pushFrame(method, args);
    }

    public KFrame pushFrame(KMethod method, KRegister... parameters) throws RemoteException {
        if (method.getStatus() == KMethod.STATUS_DIRTY) {
            try {
                method.setStatus(KMethod.STATUS_INITIALZING);
                interpreter.init(method);
                method.setStatus(KMethod.STATUS_READY);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(method.getCode()==null){
            try {
                method.setStatus(KMethod.STATUS_INITIALZING);
                interpreter.init(method);
                method.setStatus(KMethod.STATUS_READY);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ++framesCount;
        KFrame frame;
        try {
            frame = frames[framesCount];
//            if(frame==null){
//                frames[framesCount]=frame=factory.createFrame();
//                frame.setThread(this);
//            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //add some 5 elements
            int fc = framesCount;
            KFrame[] newFrames = new KFrame[fc + 20];
            System.arraycopy(frames, 0, newFrames, 0, fc);
            for (int i = newFrames.length - 1; i >= fc; i--) {
                KFrame f = factory.createFrame();
                f.setThread(this);
                newFrames[i] = f;
            }
            frames = newFrames;
            frames[framesCount] = frame = factory.createFrame();
            frame.setThread(this);
            //frame = newFrames[framesCount];
        }
        frame.init(framesCount, method, parameters);
        try {
            interpreter.init(frame);
        } catch (Exception e) {
            e.printStackTrace();
        }
        currentFrame = frame;
        return frame;
    }

    public KProcessCache getCache() {
        return cache;
    }

    public void initialize(KProcess process, KInterpreter interpreter, String className, String method, KRegister[] parameters) throws RemoteException {

        cache = new KProcessCache();
        this.interpreter = interpreter;
        this.process = process;
        attach();
        startClass = className;
        startMethod = method;
        startParams = parameters;
        KProcess parentProcess = getProcess();
        KClassRepository classRepository = parentProcess.getClassRepository();
        KClass clazz = classRepository.getClassByName(className);
        KMethod bySignature = clazz.getVirtualMethodBySignature(method);

        factory = SYSTEM.getFactory();
        for (int i = frames.length - 1; i >= 0; i--) {
            KFrame frame = factory.createFrame();
            frame.setThread(this);
            frames[i] = frame;
        }

//        if (Debug.isDebug(process, "interpreter")) {
//            Logger logger = Debug.log(this);
//            logger.info("Thread started " + className + "." + method + "(" + (parameters == null ? "" : Arrays.asList(parameters)) + ")");
//            //logger.info(KClassIntrospector.dump(parameters));
//        }
        try {
            interpreter.init(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        pushFrame(bySignature, parameters);
        pushClassInitializerFrame(clazz);
//        Doovos.getLocalSite().registerLocalResource(this);
        KMethodDef methodDefinition = bySignature.getDefinition();
        int params = methodDefinition.getParametersCount();
        for (int i = 0; i < params; i++) {
            String typeName = methodDefinition.getParameter(i).getType();
            KClass typeClassRef = classRepository.getClassByName(typeName);
            KClass dpc = typeClassRef;
            if (dpc != null) {
                pushClassInitializerFrame(dpc);
            } else if (typeClassRef.isRef()) {
                dpc = typeClassRef.getReferenceTo();
                if (dpc != null) {//not primitive
                    pushClassInitializerFrame(dpc);
                }
            }
        }
    }

    public KFrame popFrame() throws RemoteException {
//        KFrame frame = frames[framesCount];
//        int xx = framesCount;
        framesCount--;
//        KFrameListener listener = frame.getFrameListener();
//        if (listener != null) {
//            listener.framePoped(frame);
//        }
        if (framesCount < 0) {
            currentFrame = null;
            throw new KEndOfThreadException();
        }
//        frames[xx] = null;
        return currentFrame = frames[framesCount];
    }

    public KFrame rollbackFrame() throws RemoteException {
        KFrame parentFrame = popFrame();
        parentFrame.setProgramCounter(parentFrame.getProgramCounter() - 1);
        return parentFrame;
    }

    public int getFramesCount() throws RemoteException {
        return framesCount + 1;
    }

    public KFrame getFrame(int i) throws RemoteException {
        return frames[framesCount - i];
    }

    public KFrame getFrame() throws RemoteException {
        return currentFrame;
        //return getFrames().peek();
    }

    @Override
    public void onPropertyEvent(KPropertyEvent event) throws RemoteException {
        switch (event.getEventId()) {
            case DoovosConstants.PROPERTY_ID_PROCESS_CHILD_DEATH_TO_THREADS: {
                removeDependency(KWaitChildResourceBlocking.INSTANCE);
                break;
            }
        }
    }

    /**
     * called by system
     *
     * @param newParentID
     */
    public void setParentID(int newParentID) throws RemoteException {
        this.parentPID = newParentID;
        if (parentPID != -1) {
            KProcess pp = SYSTEM.getProcess(parentPID);
            KPropertyEvent event = new KPropertyEvent(getPath(), getType(), DoovosConstants.PROPERTY_ID_THREAD_BIRTH, DoovosConstants.PROPERTY_NAME_PROCESS_THREAD_BIRTH, false, true);
            pp.onPropertyEvent(event);
            process = SYSTEM.getProcess(parentPID);

        } else {
            process = null;
        }
    }

    public KProcess getProcess() throws RemoteException {
        return process;
    }

    public int getPriority() throws RemoteException {
        return priority;
    }

    public void setPriority(int priority) throws RemoteException {
        this.priority = priority;
    }

    public void addDependency(KResourceBlocking b) throws RemoteException {
        synchronized (depsLock) {
            int dep_ken = deps.length;
            if (dep_ken == 0) {
                deps = new KResourceBlocking[]{b};
            } else {
                KResourceBlocking[] ee = new KResourceBlocking[dep_ken + 1];
                System.arraycopy(deps, 0, ee, 1, dep_ken);
                ee[0] = b;
                deps = ee;
            }
        }
        checkBlocking();
    }

    public void removeDependency(KResourceBlocking b) throws RemoteException {
        synchronized (depsLock) {
            int x = -1;
            KResourceBlocking[] deps0 = deps;
            int deps_len = deps0.length;
            for (int i = 0; i < deps_len; i++) {
                KResourceBlocking dep = deps0[i];
                if (dep.equals(b)) {
                    x = i;
                    break;
                }
            }
            if (x < 0) {
                return;
            } else {
                if (deps_len == 1) {
                    deps = KResourceBlocking.EMPTY_ARRAY;
                    requestStatus(KProcessRequestedStatus.READY);
                } else {
                    KResourceBlocking[] ee = new KResourceBlocking[deps_len - 1];
                    if (x > 0) {
                        //ee[0,x[=deps0[0,x[
                        System.arraycopy(deps0, 0, ee, 0, x);
                    }
                    if (x < ee.length) {
                        //ee[x,deps_len-1[=deps0[x+1,deps_len[
                        System.arraycopy(deps0, x + 1, ee, x, deps_len - 1 - x);
                    }
                    deps = ee;
                }
            }
        }
        checkBlocking();
    }

    public boolean waitChild() throws RemoteException {
        if (getProcess().getProcessesChildrenCount() > 0) {
            addDependency(KWaitChildResourceBlocking.INSTANCE);
            return true;
        }
        return false;
    }

    public void checkBlocking() throws RemoteException {
        if (deps.length > 0) {
            synchronized (depsLock) {
                int r = 0;
                KResourceBlocking[] deps0 = deps;
                int deps_len = deps0.length;
                if (deps_len > 0) {
                    int[] toRemove = new int[deps_len];
                    for (int i = 0; i < deps_len; i++) {
                        KResourceBlocking dep = deps0[i];
                        if (dep.isBlocked(process, null, currentFrame)) {
//                            Doovos.syslog(id+System.identityHashCode(this) +" request blocking "+dep);
                            requestStatus(KProcessRequestedStatus.BLOCKED);
                            return;
                        } else {
                            toRemove[r] = i + 1;
                            r++;
                        }
                    }
                    if (r == deps_len) {
                        deps = KResourceBlocking.EMPTY_ARRAY;
                        requestStatus(KProcessRequestedStatus.READY);
                    } else {
                        int rindex = 0;
                        int findex = 0;
                        KResourceBlocking[] ee = new KResourceBlocking[deps_len - r];
                        for (int i = 0; i < deps_len; i++) {
                            int tr = toRemove[rindex];
                            if (tr == 0) {
                                System.arraycopy(deps0, i, ee, findex, deps_len - i);
                                break;
                            } else if (i == tr - 1) {
                                rindex++;
                            } else {
                                ee[findex] = deps0[i];
                                findex++;
                            }
                        }
                        deps = ee;
                    }
                }
            }
        }
    }

    public KInterpreter getInterpreter() {
        return interpreter;
    }

    public void setJVMReference(KReference ref) throws RemoteException {
        guestReference = ref;
    }

    public KReference getJVMReference() throws RemoteException {
        return guestReference;
    }

    public int getId() throws RemoteException {
        return id;
    }

    public String getStartClass() {
        return startClass;
    }

    public String getStartMethod() {
        return startMethod;
    }

    public List<KRegister> getStartParams() {
        return Arrays.asList(startParams);
    }

    public void run() {
//        if (runningNativeThread) {
//            Doovos.syslog("already running " + id);
//            return;
//        }
        try {
            runningNativeThread = true;
            //Doovos.syslog(id+System.identityHashCode(this) +" running start");
//        try {
//            if (process.getStatus() != DProcess.Status.SHADOW) {
//                process.setStatus(DProcess.Status.READY);
//                process.requestStatus(DProcess.Status.RUNNING);
//            } else {
//                process.setStatus(process.getRequestedStatus());
//                process.requestStatus(process.getRequestedStatus());
//            }
//        } catch (RemoteException e) {
//            e.printStackTrace();
//            return;
//        }
            KLocalThread currentThread0 = this;
            boolean freed = false;
            KInterpreter _interpreter = null;
            try {
                _interpreter = currentThread0.getInterpreter();
                _interpreter.init(currentThread0);
            } catch (Exception e) {
                e.printStackTrace();
            }

//        int MAX=1;
//        try {
//            KEnvInfo intRT = currentThread.getProcess().getEnv("INTERPRETER_RT");
//            MAX=intRT==null?10:Integer.valueOf(intRT.getValue());
//            if(MAX<0){
//                MAX=1;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        int blockingIndex =MAX;

            while (true) {
                //latestStatementStartTime = System.currentTimeMillis();
                try {
//                Doovos.log("["+process.getName()+":"+process.getStatus()+"->"+process.getRequestedStatus()+"]");
                    switch (currentThread0.getStatus()) {
                        case KProcessLiveStatus.INIT: {
                            //DO nothing
                            break;
                        }
                        case KProcessLiveStatus.INIT_READY:
                        case KProcessLiveStatus.RUNNING_READY:
                        case KProcessLiveStatus.BLOCKED_READY:
                        case KProcessLiveStatus.SHADOW_READY: {
                            currentThread0.setStatus(KProcessLiveStatus.READY);
                            break;
                        }
                        case KProcessLiveStatus.READY:
                        case KProcessLiveStatus.READY_RUNNING: {
                            currentThread0.setStatus(KProcessLiveStatus.RUNNING);
                            break;
                        }
                        case KProcessLiveStatus.INIT_BLOCKED:
                        case KProcessLiveStatus.READY_BLOCKED:
                        case KProcessLiveStatus.RUNNING_BLOCKED: {
                            currentThread0.setStatus(KProcessLiveStatus.BLOCKED);
                            break;
                        }
                        case KProcessLiveStatus.BLOCKED: {
                            runningNativeThread = false;
                            return;
                            //currentThread0.checkBlocking();
                            //break;
                        }
                        case KProcessLiveStatus.BLOCKED_SHADOW:
                        case KProcessLiveStatus.READY_SHADOW:
                        case KProcessLiveStatus.RUNNING_SHADOW: {
                            currentThread0.setStatus(KProcessLiveStatus.SHADOW);
                            break;
                        }
                        case KProcessLiveStatus.SHADOW: {
                            return;
                        }
                        case KProcessLiveStatus.RUNNING_ZOMBIE: {
                            currentThread0.setStatus(KProcessLiveStatus.ZOMBIE);
                            break;
                        }
                        case KProcessLiveStatus.ZOMBIE: {
                            //lib�rer toutes les mem, les env et le process!!!
                            freed = true; //yes before, i know!!
                            currentThread0.free();
                            return;
                        }
                        case KProcessLiveStatus.RUNNING: {
//        try {
//            System.out.println("[Process-"+getName()+":"+getProgram().getTitle()+"] "+currentStatement+" : "+program.getStatement(currentStatement));
//        } catch (RemoteException e) {
//            //
//        }
                            try {
//                                System.out.println(currentThread0.getFrame());
                                _interpreter.run(currentThread0.getFrame());
//                            blockingIndex--;
//                            if(blockingIndex ==0){
                                //currentThread0.checkBlocking();
//                                blockingIndex =MAX;
//                            }
                            } catch (KEndOfThreadException e) {
                                currentThread0.setStatus(KProcessLiveStatus.ZOMBIE);
                            } catch (Throwable e) {
                                //TODO fix me
                                //Debug.log(currentThread0).throwing("KProcessSchedulerThread", "run", e);
                                KProcess _process = currentThread0.getProcess();
                                try {
                                    PrintStream ps = new PrintStream(_process.getStderr().getOutputStream());
                                    e.printStackTrace(ps);
                                    ps.flush();
                                    ps.println("Error in process " + _process.getName());
                                    ps.println(" : " + currentThread0.getProcess().getId());
                                    ps.println(currentThread0.getFrame());
                                    ps.flush();
                                    ps.close();
                                } catch (Throwable e1) {
                                    e.printStackTrace();
                                    e1.printStackTrace();
                                    System.err.println("Error in process " + _process.getName());
                                    System.err.println(" : " + currentThread0.getProcess().getId());
                                }
                                currentThread0.setStatus(KProcessLiveStatus.ZOMBIE);
                            }
                            break;
                        }
                        default: {
                            throw new IllegalArgumentException("Unknown status " + currentThread0.getStatus());
                        }
                    }
                } catch (Throwable e) {
                    try {
                        KProcess pp = currentThread0.getProcess();
                        System.err.println("Error in Process " + pp.getPath() + ":" + pp.getId() + " : " + e);
                    } catch (Exception e1) {
                        //e1.printStackTrace();
                    }
                    e.printStackTrace();
                    if (!freed) {
                        try {
                            currentThread0.free();
                        } catch (Throwable e2) {
                            e2.printStackTrace();
                        }
                    }
                    return;
                }
            }
        } finally {
            runningNativeThread = false;
//            Doovos.syslog(id+System.identityHashCode(this) +" running ended");
        }
    }

    public boolean isRunningNativeThread() throws RemoteException {
        return runningNativeThread;
    }

    //    public static KFrameListener clinitContextListener = new KFrameListener() {
//
//        public void framePoped(KFrame frame) {
//            try {
//                frame.getKClass().setStatus(KClassStatus.READY);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    };
    public boolean pushClassInitializerFrame(KClass dpc) throws RemoteException {
        if (!dpc.isInitialized()) {
//            if (dpc.isArray()) {
//                dpc.setStatus(KClassStatus.READY);
//                return false;
//            }
            KClassDef classDefinition = dpc.getDefinition();
//TODO FIX ME
//            for (String signature : process.getForcedToNativeMethods(classDefinition.getName())) {
//                try {
//                    KMethod m = dpc.getMethodBySignature(signature);
//                    if (!m.isNative()) {
//                        //Doovos.syslog("Force to Native : " + m);
//                        m.setModifiers(m.getModifiers() | Modifier.NATIVE);
//                        //m.setCode(new KInstruction[]{ KJVMInstructions.createInstruction(KJVMOperator.XTRA_JNI, null)});
//                    }
//                } catch (NoSuchElementException e) {
//                    Doovos.getLog().error(e);
//                }
//            }
            KMethod initMethod = dpc.findClassInitializerMethod();
            boolean init = false;
            KClassRepository _classRepository = process.getClassRepository();
            dpc.setInitialized(true);
            if (initMethod != null) {
                pushFrame(initMethod, KRegister.EMPTY_ARRAY);
                //dpc.setStatus(KClassStatus.INITIALIZING);
//                newFrame.setFrameListener(clinitContextListener);
                init = true;
            }
            String superClassName = classDefinition.getSuperClassName();
            if (superClassName != null) {
                KClass superClass = _classRepository.getClassByName(superClassName);
                boolean initSuper = pushClassInitializerFrame(superClass);
                if (initSuper) {
                    init = true;
                }
            }
            return init;

        }
        return false;
    }

    public boolean isStarted() {
        return started;
    }
}
