package org.doovos.kernel.core.process;

import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.DoovosConstants;
import org.doovos.kernel.api.filesystem.*;
import org.doovos.kernel.api.io.screen.KConstructor;
import org.doovos.kernel.api.io.stream.KInputStream;
import org.doovos.kernel.api.io.stream.KOutputStream;
import org.doovos.kernel.api.io.term.KTerminal;
import org.doovos.kernel.api.jvm.KGarbageCollector;
import org.doovos.kernel.api.jvm.bytecode.KClassDef;
import org.doovos.kernel.api.jvm.bytecode.KSegmentDef;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.jni.KJNIException;
import org.doovos.kernel.api.jvm.jni.KJNIMethod;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.memory.adapter.*;
import org.doovos.kernel.api.process.*;
import org.doovos.kernel.api.util.EmptyArray;
import org.doovos.kernel.core.jvm.jni.NativeLibrariesRepository;
import org.doovos.kernel.core.util.KUtils;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.*;
import org.doovos.kernel.api.jvm.jni.KJNIMethodInfo;
import org.doovos.kernel.core.filesystem.KRuntimeFolderImpl;
import org.doovos.kernel.core.filesystem.KPrefixedPathRuntimeResourceImpl;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 11 oct. 2004
 * Time: 15:37:03
 */
public class KProcessImpl extends KPrefixedPathRuntimeResourceImpl implements KLocalProcess, Cloneable {

    private static final Doovos SYSTEM = Doovos.getSystem();
    private static final KMemoryManager MEMORY_MANAGER = SYSTEM.getMemoryManager();
    private static final KFileSystemManager FILE_SYSTEM_MANAGER = SYSTEM.getFileSystemManager();
    private Set<Integer> childrenProcesses = new HashSet<Integer>();
    private Set<Integer> childrenThreads = new HashSet<Integer>();
    private /*KProcessLiveStatus*/ int liveStatus = KProcessLiveStatus.INIT;
    private int classRepositoryId = -1;
    private KClassRepository classRepository = null;
    private Vector<String> memorySegmentPaths = new Vector<String>(1, 1);
    private Vector<KMemorySegment> memorySegments = new Vector<KMemorySegment>(1, 1);
    private Vector<KStreamDescriptor> descriptors = new Vector<KStreamDescriptor>();
//    private Vector<DPath> memorySegmentsSet = new Vector<DPath>(1, 1);
    //FIX ME : move that to memory segment impl
    private KReference processReference;
    private DProcessAdapter processAdapter;
    private KClass processClassRef;
    private NativeLibrariesRepository nativeLibraries = new NativeLibrariesRepository();
    private KGarbageCollector garbageCollector;
    private int id;
//    private KClassDefRepository classDefRepository;
//    public DProcessImpl(DProgram program, String parentPID)  {
//        this(program, parentPID, null);

    //    }
    public KProcessImpl() throws RemoteException {
        super(KResourceType.PROCESS, false, DoovosConstants.PROCESS_PATH, DoovosConstants.PROCESS_PREFIX, null);
        setStatus(KProcessRequestedStatus.INIT);
    }

    public void initialize(String classCode, int parentPID, String[] command, Properties env, String user, String workDir) throws RemoteException {
        Properties newEnv = new Properties();
        if (env != null) {
            for (Map.Entry ei : env.entrySet()) {
                newEnv.put(ei.getKey(), ei.getValue());
            }
        }
        String termPath = newEnv.getProperty(DoovosConstants.ENV_SYSTEM_TERM);

        KTerminal terminal;
        if (termPath == null) {
            terminal = SYSTEM.getLocalSite().getScreen().addTerminal(new KConstructor<KTerminal>(KTerminal.class).set(KTerminal.TITLE_PROPERTY, "NEW_TERMINAL"));
            newEnv.setProperty(DoovosConstants.ENV_SYSTEM_STDOUT, terminal.getOut().getPath());
            newEnv.setProperty(DoovosConstants.ENV_SYSTEM_STDIN, terminal.getIn().getPath());
            newEnv.setProperty(DoovosConstants.ENV_SYSTEM_STDERR, terminal.getErr().getPath());
        } else {
            terminal = (KTerminal) FILE_SYSTEM_MANAGER.getResource(termPath);
            if (!newEnv.containsKey(DoovosConstants.ENV_SYSTEM_STDOUT)) {
                newEnv.setProperty(DoovosConstants.ENV_SYSTEM_STDOUT, terminal.getOut().getPath());
            }
            if (!newEnv.containsKey(DoovosConstants.ENV_SYSTEM_STDIN)) {
                newEnv.setProperty(DoovosConstants.ENV_SYSTEM_STDIN, terminal.getIn().getPath());
            }
            if (!newEnv.containsKey(DoovosConstants.ENV_SYSTEM_STDERR)) {
                newEnv.setProperty(DoovosConstants.ENV_SYSTEM_STDERR, terminal.getErr().getPath());
            }
        }
        descriptors.add(new KStreamDescriptor(0, terminal.getIn().getPath()));
        descriptors.add(new KStreamDescriptor(1, terminal.getOut().getPath()));
        descriptors.add(new KStreamDescriptor(2, terminal.getErr().getPath()));
        newEnv.setProperty(DoovosConstants.ENV_SYSTEM_TERM, terminal.getPath());

//        if (!newEnv.containsKey(DoovosConstants.ENV_SYSTEM_WORKING_DIR)) {
//            newEnv.put(DoovosConstants.ENV_SYSTEM_WORKING_DIR, new KEnvInfo(DoovosConstants.ENV_SYSTEM_WORKING_DIR, "/", true));
//        }

        newEnv.setProperty(DoovosConstants.ENV_SYSTEM_THIS_PROCESS, getPath());

        newEnv.setProperty(DoovosConstants.ENV_SYSTEM_LOCAL_SITE, SYSTEM.getName());
        String[] argsValid = (command == null || command.length == 0) ? EmptyArray.STRINGS : command;
        String[] cmdValid = new String[argsValid.length+1];
        cmdValid[0]=classCode;
        System.arraycopy(argsValid, 0, cmdValid, 1, argsValid.length);
        //        String[] args = new String[commandValid.length - 1];
        //        System.arraycopy(commandValid, 1, args, 0, args.length);

        StringBuilder commandBuffer = new StringBuilder();
        commandBuffer.append(classCode);
        for (String s : argsValid) {
            commandBuffer.append(" ");
            commandBuffer.append(s);
        }


        newEnv.setProperty(DoovosConstants.ENV_SYSTEM_CMD, commandBuffer.toString());
        newEnv.setProperty(DoovosConstants.ENV_SYSTEM_PID, String.valueOf(getId()));
        newEnv.setProperty(DoovosConstants.ENV_SYSTEM_WORKING_DIR, workDir);

        setStatus(KProcessRequestedStatus.BLOCKED);

        String pathString = newEnv.getProperty(DoovosConstants.ENV_PATH);
        if (pathString == null) {
            throw new IllegalArgumentException("Environment variable '" + DoovosConstants.ENV_PATH + "' is required but not found");
        }

//        should treat wildcards??????
//        KEnvInfo cwdEnv = newEnv.get(DoovosConstants.ENV_SYSTEM_WORKING_DIR);
//        if (cwdEnv == null) {
//            throw new IllegalArgumentException("Environment variable '" + DoovosConstants.ENV_SYSTEM_WORKING_DIR + "' is required but not found");
//        }


        garbageCollector = SYSTEM.getFactory().createGarbageCollector(newEnv);

        KClassRepository clsRepository = SYSTEM.allocClassRepository(this, newEnv);

        setClassRepository(Integer.parseInt(clsRepository.getName()));

        //        Object[] localsValues = new Object[commandValid.length + 2];
        //        localsValues[0] = commandString.toCharArray();
        //        localsValues[1] = commandValid.length;
        //        for (int i = 0; i < commandValid.length; i++) {
        //            localsValues[2 + i] = commandValid[i].toCharArray();
        //        }
        KSegmentDef initialSegmentInfo = new KSegmentDef(".init", 16 * 1024 * 1024, KMemorySegment.Options.DEFAULT, null);
        KMemorySegment initialSegment = SYSTEM.allocMemorySegment(this, initialSegmentInfo, newEnv);
        addIndexedMemorySegment(initialSegment.getPath());
        List<String> allPaths = new ArrayList<String>();
        for (String p : pathString.split(":")) {
            allPaths.addAll(Arrays.asList(KUtils.findPaths(workDir, KUtils.expandEnv(p, newEnv))));
        }
        String[] bootstrapPaths = allPaths.toArray(new String[allPaths.size()]);

        clsRepository.init(SYSTEM.getFactory().createBootstrapClassLoader(this, bootstrapPaths), initialSegment, newEnv);

        initialSegment.prepare();


        processAdapter = DProcessAdapter.newInstance(this);
        processReference = processAdapter.getReference();

        SimpleClassAdapter group = SimpleClassAdapter.newInstance(this, "java.lang.ThreadGroup");
        //        this.name = "system";
        //        this.maxPriority = Thread.MAX_PRIORITY;

        group.setString("name", "system");
        group.setInt("maxPriority", Thread.MAX_PRIORITY);

        processAdapter.setThreadGroup(group);
        /**
         * increment not to be garbage collected
         */
        getGarbageCollector().incReferencesCount(processAdapter.getReference());

        processAdapter.setCommandLine(new StringAdapter(this, commandBuffer.toString()));
        processAdapter.setCommand(new StringArrayAdapter(this, cmdValid));
        processAdapter.setArguments(new StringArrayAdapter(this, argsValid));
        processAdapter.setPID(getId());
        processAdapter.setParentPID(parentPID);
        processAdapter.setUser(user);
        ArrayList<String> rawEnv = new ArrayList<String>(newEnv.size());
        for (Map.Entry<Object, Object> entry : newEnv.entrySet()) {
            rawEnv.add((String) entry.getKey());
            rawEnv.add((String) entry.getValue());
        }
        processAdapter.setRawEnvs(new StringArrayAdapter(this, rawEnv.toArray(new String[rawEnv.size()])));
        processClassRef = getClassRepository().getClassByName(classCode);
        KClassDef processClass = processClassRef.getDefinition();

        ArrayList<String> rawMetadata = new ArrayList<String>(processClass.getMetadata().size() * 2);
        for (Map.Entry<Object, Object> entry : processClass.getMetadata().entrySet()) {
            rawMetadata.add((String) entry.getKey());
            rawMetadata.add((String) entry.getValue());
        }
        processAdapter.setRawMetadata(new StringArrayAdapter(this, rawMetadata.toArray(new String[rawMetadata.size()])));

        String envInfo = newEnv.getProperty(DoovosConstants.ENV_SYSTEM_STDIN);
        if (envInfo != null) {
            setStdin((KInputStream) FILE_SYSTEM_MANAGER.getResource(envInfo));
        }
        envInfo = newEnv.getProperty(DoovosConstants.ENV_SYSTEM_STDOUT);
        if (envInfo != null) {
            setStdout((KOutputStream) FILE_SYSTEM_MANAGER.getResource(envInfo));
        }
        envInfo = newEnv.getProperty(DoovosConstants.ENV_SYSTEM_STDERR);
        if (envInfo != null) {
            setStderr((KOutputStream) FILE_SYSTEM_MANAGER.getResource(envInfo));
        }
        //ignore
//        envInfo = newEnv.get(DoovosConstants.ENV_SYSTEM_WORKING_DIR);
//        if (envInfo != null) {
//            setCwd(envInfo.getValue());
//        }
        processAdapter.setCwd(new StringAdapter(this, workDir));
        setParentID(parentPID);
        KMethod mainMethod = getKClass().getMainMethod();
        if (mainMethod == null) {
            throw new IllegalArgumentException("Not a valid program Class. no class main found");
        }
    }

    public KClass getKClass() {
        return processClassRef;
    }
    //    public int getLocalChildrenCount() {
//        return 2;
//    }

    public int getParentPID() throws RemoteException {
        return processAdapter.getParentPID0();
    }

    public String getUser() throws RemoteException {
        StringAdapter login = processAdapter.getUser0();
        return login == null ? null : login.getValue();
    }

    public /*KProcessLiveStatus*/ int getStatus() throws RemoteException {
        return liveStatus;
    }

    public void setStatus(/*KProcessRequestedStatus*/int status) throws RemoteException {
        switch (liveStatus) {
            case KProcessLiveStatus.INIT:
            case KProcessLiveStatus.INIT_READY:
            case KProcessLiveStatus.INIT_BLOCKED:
            case KProcessLiveStatus.INIT_SHADOW:
            case KProcessLiveStatus.INIT_ZOMBIE: {
                switch (status) {
                    case KProcessRequestedStatus.INIT: {
                        break;
                    }
                    case KProcessRequestedStatus.READY: {
                        liveStatus = KProcessLiveStatus.INIT_READY;
                        break;
                    }
                    case KProcessRequestedStatus.BLOCKED: {
                        liveStatus = KProcessLiveStatus.INIT_BLOCKED;
                        break;
                    }
                    case KProcessRequestedStatus.SHADOW: {
                        liveStatus = KProcessLiveStatus.INIT_SHADOW;
                        break;
                    }
                    case KProcessRequestedStatus.ZOMBIE: {
                        liveStatus = KProcessLiveStatus.INIT_ZOMBIE;
                        break;
                    }
                    default: {
                        throw new NoSuchElementException();
                    }
                }
                break;
            }
            case KProcessLiveStatus.READY:
            case KProcessLiveStatus.READY_RUNNING:
            case KProcessLiveStatus.READY_BLOCKED:
            case KProcessLiveStatus.READY_SHADOW:
            case KProcessLiveStatus.READY_ZOMBIE: {
                switch (status) {
                    case KProcessRequestedStatus.READY: {
                        break;
                    }
                    case KProcessRequestedStatus.RUNNING: {
                        liveStatus = KProcessLiveStatus.READY_RUNNING;
                        break;
                    }
                    case KProcessRequestedStatus.BLOCKED: {
                        liveStatus = KProcessLiveStatus.READY_BLOCKED;
                        break;
                    }
                    case KProcessRequestedStatus.SHADOW: {
                        liveStatus = KProcessLiveStatus.READY_SHADOW;
                        break;
                    }
                    case KProcessRequestedStatus.ZOMBIE: {
                        liveStatus = KProcessLiveStatus.READY_ZOMBIE;
                        break;
                    }
                    default: {
                        throw new NoSuchElementException();
                    }
                }
                break;
            }
            case KProcessLiveStatus.RUNNING:
            case KProcessLiveStatus.RUNNING_BLOCKED:
            case KProcessLiveStatus.RUNNING_READY:
            case KProcessLiveStatus.RUNNING_SHADOW:
            case KProcessLiveStatus.RUNNING_ZOMBIE: {
                switch (status) {
                    case KProcessRequestedStatus.READY: {
                        liveStatus = KProcessLiveStatus.RUNNING_READY;
                        break;
                    }
                    case KProcessRequestedStatus.RUNNING: {
                        break;
                    }
                    case KProcessRequestedStatus.BLOCKED: {
                        liveStatus = KProcessLiveStatus.RUNNING_BLOCKED;
                        break;
                    }
                    case KProcessRequestedStatus.SHADOW: {
                        liveStatus = KProcessLiveStatus.RUNNING_SHADOW;
                        break;
                    }
                    case KProcessRequestedStatus.ZOMBIE: {
                        liveStatus = KProcessLiveStatus.RUNNING_ZOMBIE;
                        break;
                    }
                    default: {
                        throw new NoSuchElementException();
                    }
                }
                break;
            }
            case KProcessLiveStatus.BLOCKED:
            case KProcessLiveStatus.BLOCKED_READY:
            case KProcessLiveStatus.BLOCKED_SHADOW:
            case KProcessLiveStatus.BLOCKED_ZOMBIE: {
                switch (status) {
                    case KProcessRequestedStatus.READY: {
                        liveStatus = KProcessLiveStatus.BLOCKED_READY;
                        break;
                    }
                    case KProcessRequestedStatus.BLOCKED: {
                        break;
                    }
                    case KProcessRequestedStatus.SHADOW: {
                        liveStatus = KProcessLiveStatus.BLOCKED_SHADOW;
                        break;
                    }
                    case KProcessRequestedStatus.ZOMBIE: {
                        liveStatus = KProcessLiveStatus.BLOCKED_ZOMBIE;
                        break;
                    }
                    default: {
                        throw new NoSuchElementException();
                    }
                }
                break;
            }
            case KProcessLiveStatus.SHADOW: {
                switch (status) {
                    case KProcessRequestedStatus.READY: {
                        liveStatus = KProcessLiveStatus.SHADOW_READY;
                        break;
                    }
                    case KProcessRequestedStatus.SHADOW: {
                        break;
                    }
                    default: {
                        throw new NoSuchElementException();
                    }
                }
                break;
            }
            case KProcessLiveStatus.ZOMBIE: {
                switch (status) {
                    case KProcessRequestedStatus.ZOMBIE: {
                        break;
                    }
                    default: {
                        throw new NoSuchElementException();
                    }
                }
                break;
            }

        }
    }

//    public String getEnv(String name) throws RemoteException {
//        processAdapter.invalidate();
//        ProcessEnvAdapter processEnvAdapter = processAdapter.getEnv(name);
//        return processEnvAdapter == null ? null : new KEnvInfo(
//                processEnvAdapter.getKey().getValue(),
//                processEnvAdapter.getValue().getValue(),
//                processEnvAdapter.isExported()
//        );
//    }
    public String getCwd() throws RemoteException {
        StringAdapter cwd = processAdapter.getCwd0();
        return cwd == null ? null : cwd.getValue();
    }

    @Deprecated
    public void setCwd(String newDir) throws RemoteException {
        processAdapter.setCwd(new StringAdapter(this, newDir));
    }

    public KInputStream getStdin() throws RemoteException {
        String p = descriptors.get(0).getPath();
        return (KInputStream) FILE_SYSTEM_MANAGER.getResource(p);
    }

    public void setStdin(KInputStream stdin) throws RemoteException {
        descriptors.set(0, new KStreamDescriptor(0, stdin.getPath()));
    }

    public KOutputStream getStdout() throws RemoteException {
        String p = descriptors.get(1).getPath();
        return (KOutputStream) FILE_SYSTEM_MANAGER.getResource(p);
    }

    public KOutputStream getStderr() throws RemoteException {
        String p = descriptors.get(2).getPath();
        return (KOutputStream) FILE_SYSTEM_MANAGER.getResource(p);
    }

    public void setStdout(KOutputStream stdout) throws RemoteException {
        descriptors.set(1, new KStreamDescriptor(1, stdout.getPath()));
    }

    public void setStderr(KOutputStream stdout) throws RemoteException {
        descriptors.set(2, new KStreamDescriptor(2, stdout.getPath()));
    }

    @Override
    public void migrateTo(String SiteId) throws RemoteException {
        setStatus(KProcessRequestedStatus.SHADOW);
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
        setStatus(KProcessRequestedStatus.ZOMBIE);
        FILE_SYSTEM_MANAGER.getResource(getPath() + "/" + DoovosConstants.PROCESS_THREAD_NAME).free();
        FILE_SYSTEM_MANAGER.getResource(getPath() + "/" + DoovosConstants.PROCESS_MEM_NAME).free();
        super.freeImpl();

        int ppid = getParentPID();
//        super.freeImpl();
        if (ppid != -1) {
            //attach my children to my parent
            KProcess parentProcess = SYSTEM.getProcess(ppid);

            KPropertyEvent event;
            event = new KPropertyEvent(getPath(), getType(), DoovosConstants.PROPERTY_ID_PROCESS_CHILD_DEATH, DoovosConstants.PROPERTY_NAME_PROCESS_CHILD_DEATH, false, true);
            parentProcess.onPropertyEvent(event);

            event = new KPropertyEvent(getPath(), getType(), DoovosConstants.PROPERTY_ID_PROCESS_PARENT_DEATH, DoovosConstants.PROPERTY_NAME_PROCESS_PARENT_DEATH, false, parentProcess.getId());
            for (Integer s : childrenProcesses) {
                try {
                    SYSTEM.getProcess(s).onPropertyEvent(event);
                } catch (RemoteException ex) {
                    SYSTEM.getLog().error(ex);
                }
            }
        }
    }

    @Override
    public void attach() throws RemoteException {
        super.attach();
        id = Integer.parseInt(getName());
        try {
            KRuntimeFolderImpl r = new KRuntimeFolderImpl(getPath() + "/" + DoovosConstants.PROCESS_THREAD_NAME);
            r.attach();
        } catch (RemoteException ex) {
            SYSTEM.getLog().error(ex);
        }
        try {
            KRuntimeFolderImpl r = new KRuntimeFolderImpl(getPath() + "/" + DoovosConstants.PROCESS_MEM_NAME);
            r.attach();
        } catch (RemoteException ex) {
            SYSTEM.getLog().error(ex);
        }
    }

    public int getProcessesChildrenCount() {
        return childrenProcesses.size();
    }

    public Collection<KProcess> getProcessesChildren() throws RemoteException {
        ArrayList<KProcess> p = new ArrayList<KProcess>();
        for (Integer s : childrenProcesses) {
            p.add((KProcess) FILE_SYSTEM_MANAGER.getResource(DoovosConstants.PROCESS_PATH + "/" + String.valueOf(s)));
        }
        return p;
    }

    @Override
    public boolean isSticky() throws RemoteException {
        return false;
    }

    public KMemorySegment getMemorySegment(int index) throws RemoteException {
        return memorySegments.get(index);
    }

    public KMemorySegment[] getMemorySegments() throws RemoteException {
        return memorySegments.toArray(new KMemorySegment[memorySegments.size()]);
    }

    public int addIndexedMemorySegment(String path) throws RemoteException {
        KMemorySegment mem = KMemorySegment.class.cast(FILE_SYSTEM_MANAGER.getResource(path));
        memorySegmentPaths.add(path);
        memorySegments.add(mem);
        return memorySegmentPaths.size() - 1;
    }

    @Override
    public void onPropertyEvent(KPropertyEvent event) throws RemoteException {
        String source = event.getSource();
        switch (event.getEventId()) {
            case DoovosConstants.PROPERTY_ID_PRE_FREE: {
                break;
            }
            case DoovosConstants.PROPERTY_ID_PROCESS_CHILD_BIRTH: {
                childrenProcesses.add(Integer.parseInt(new KFilePath(source).getName()));
                break;
            }
            case DoovosConstants.PROPERTY_ID_PROCESS_CHILD_DEATH: {
                childrenProcesses.remove(Integer.parseInt(new KFilePath(source).getName()));
                KPropertyEvent event2 = new KPropertyEvent(
                        getPath(), getType(),
                        DoovosConstants.PROPERTY_ID_PROCESS_CHILD_DEATH_TO_THREADS,
                        DoovosConstants.PROPERTY_NAME_PROCESS_CHILD_DEATH_TO_THREADS,
                        null,
                        event.getSource());
                for (Integer childrenThread : childrenThreads) {
                    KThread t = (KThread) FILE_SYSTEM_MANAGER.getResource((getPath() + "/" + DoovosConstants.PROCESS_THREAD_NAME + "/" + String.valueOf(childrenThread)));
                    t.onPropertyEvent(event2);
                }
                break;
            }
            case DoovosConstants.PROPERTY_ID_PROCESS_PARENT_DEATH: {
                setParentID((Integer) event.getNewValue());
                break;
            }
            case DoovosConstants.PROPERTY_ID_THREAD_BIRTH: {
                childrenThreads.add(Integer.parseInt(new KFilePath(source).getName()));
                break;
            }
            case DoovosConstants.PROPERTY_ID_THREAD_DEATH: {
                childrenThreads.remove(Integer.parseInt(new KFilePath(source).getName()));
                if (childrenThreads.size() == 0) {
                    free();
                }
                break;
            }
        }
    }

    /**
     * called by system
     *
     * @param newParentID
     * @throws java.rmi.RemoteException
     */
    public void setParentID(int newParentID) throws RemoteException {
        processAdapter.setParentPID(newParentID);
        if (newParentID != -1) {
            KProcess pp = SYSTEM.getProcess(newParentID);
            KPropertyEvent event = new KPropertyEvent(getPath(), getType(), DoovosConstants.PROPERTY_ID_PROCESS_CHILD_BIRTH, DoovosConstants.PROPERTY_NAME_PROCESS_CHILD_BIRTH, false, true);
            pp.onPropertyEvent(event);
        }
    }

    public KReference getInfoReference() throws RemoteException {
        return getGuestReference();
    }

    public int getClassRepositoryId() throws RemoteException {
        return classRepositoryId;
    }

    public KClassRepository getClassRepository() throws RemoteException {
        return classRepository;
        //return Doovos.getClassRepository(classRepositoryId);
    }

    public void setClassRepository(int classRepositoryId) throws RemoteException {
        this.classRepositoryId = classRepositoryId;
        if (classRepositoryId == -1) {
            this.classRepository = null;
        } else {
            this.classRepository = SYSTEM.getClassRepository(classRepositoryId);
        }
    }

    public KMemorySegment getMemorySegment() throws RemoteException {
        return getMemorySegment(0);
    }

    public KMemoryManager getMemoryManager() throws RemoteException {
        return MEMORY_MANAGER;
    }

    public KReference getGuestReference() throws RemoteException {
        return processReference;
    }

//    public void setInfoReference(KReference reference) throws RemoteException {
//        this.infoReference = reference;
//    }
    public void loadNativeLibraryClass(String library) throws RemoteException {
        try {
            nativeLibraries.addLibraryClass(library, this);
        } catch (KJNIException e) {
            throw e;
        } catch (RuntimeException e) {
            throw e;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public Set<String> getForcedToNativeMethods(String className) throws RemoteException {
        return nativeLibraries.getForcedToNativeMethods(className);
    }

    public KJNIMethodInfo getJNIMethodInfo(String methodFullId) throws RemoteException {
        return nativeLibraries.getJNIMethodInfo(methodFullId);
    }
    
    public KJNIMethod getJNIMethod(String methodFullId) throws RemoteException{
        return nativeLibraries.getJNIMethod(methodFullId);
    }

    public boolean existsNativeMethod(String methodFullId) throws RemoteException {
        return nativeLibraries.existsNativeMethod(methodFullId);
    }

    public KRegister invokeNativeMethod(String methodId, KFrame frame, KRegister[] parameters) throws RemoteException{
        return nativeLibraries.invokeMethod(methodId, frame, parameters);
    }

    public KGarbageCollector getGarbageCollector() throws RemoteException {
        return garbageCollector;
    }

    public void gc() throws RemoteException {
        for (KMemorySegment m : memorySegments) {
            garbageCollector.gc(m);
        }
    }

    public long maxMemorySize() throws RemoteException {
        long val = 0;
        for (KMemorySegment m : memorySegments) {
            val += m.maxMemorySize();
        }
        return val;
    }

    public long freeMemorySize() throws RemoteException {
        long val = 0;
        for (KMemorySegment m : memorySegments) {
            val += m.freeMemorySize();
        }
        return val;
    }

    public KStreamDescriptor getStreamDescriptor(int desc) throws RemoteException {
        return descriptors.get(desc);
    }

    public KStreamDescriptor openInputStream(String path) throws IOException {
        KStreamDescriptor desc;
        String absolutePath = KFilePath.canonicalize(getCwd(), path);
        KInputStream stream = SYSTEM.openInputStream(absolutePath);
        for (int i = 0; i < descriptors.size(); i++) {
            KStreamDescriptor descriptor = descriptors.get(i);
            if (descriptor == null) {
                descriptors.set(i, desc = new KStreamDescriptor(i, stream.getPath()));
                return desc;
            }
        }
        descriptors.add(desc = new KStreamDescriptor(descriptors.size(), stream.getPath()));
        return desc;
    }

    public KStreamDescriptor openOutputStream(String path, boolean append) throws IOException {
        KStreamDescriptor desc;
        String absolutePath = KFilePath.canonicalize(getCwd(), path);
        KOutputStream stream = SYSTEM.openOutputStream(this, absolutePath, new KFile.OutFlags().setAppend(append).setCreate(true));
        for (int i = 0; i < descriptors.size(); i++) {
            KStreamDescriptor descriptor = descriptors.get(i);
            if (descriptor == null) {
                descriptors.set(i, desc = new KStreamDescriptor(i, stream.getPath()));
                return desc;
            }
        }
        descriptors.add(desc = new KStreamDescriptor(descriptors.size(), stream.getPath()));
        return desc;
    }

    public List<KThread> getThreads() throws RemoteException {
        List<KThread> all = new ArrayList<KThread>();
        for (Integer childrenThread : childrenThreads) {
            KThread t = (KThread) FILE_SYSTEM_MANAGER.getResource((getPath() + "/" + DoovosConstants.PROCESS_THREAD_NAME + "/" + String.valueOf(childrenThread)));
            all.add(t);
        }
        return all;
    }

    public int getId() throws RemoteException {
        return id;
    }
}
