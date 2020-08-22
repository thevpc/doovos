//package org.doovos.kernel.debug;
//
//import org.doovos.kernel.api.KFactory;
//import org.doovos.kernel.api.KSysLog;
//import org.doovos.kernel.api.filesystem.*;
//import org.doovos.kernel.api.io.screen.KLocalScreenDevice;
//import org.doovos.kernel.api.io.screen.KScreenDevice;
//import org.doovos.kernel.api.io.stream.KInputStream;
//import org.doovos.kernel.api.io.stream.KLocalInputStream;
//import org.doovos.kernel.api.io.stream.KLocalOutputStream;
//import org.doovos.kernel.api.io.stream.KOutputStream;
//import org.doovos.kernel.api.jvm.KGarbageCollector;
//import org.doovos.kernel.api.jvm.bytecode.KClassDefRepository;
//import org.doovos.kernel.api.jvm.interpreter.KFrame;
//import org.doovos.kernel.api.jvm.interpreter.KInterpreter;
//import org.doovos.kernel.api.jvm.reflect.KClassLoader;
//import org.doovos.kernel.api.jvm.reflect.KLocalClassRepository;
//import org.doovos.kernel.api.jvm.reflect.KMethod;
//import org.doovos.kernel.api.memory.KEnvInfo;
//import org.doovos.kernel.api.memory.KMemoryManager;
//import org.doovos.kernel.api.memory.KRegister;
//import org.doovos.kernel.api.migration.KCostManager;
//import org.doovos.kernel.api.process.*;
//import org.doovos.kernel.api.security.KCredentials;
//import org.doovos.kernel.api.security.KSecurityManager;
//import org.doovos.kernel.api.site.KLocalSite;
//import org.doovos.kernel.api.site.KSiteManager;
//
//import java.io.File;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.rmi.RemoteException;
//import org.doovos.kernel.api.jvm.bytecode.KSegmentDef;
//import org.doovos.kernel.api.memory.KLocalMemorySegment;
//
///**
// * Created by IntelliJ IDEA.
// * User: vpc
// * Date: 18 avr. 2010
// * Time: 02:53:32
// * To change this template use File | Settings | File Templates.
// */
//public class KFactoryAdapter implements KFactory {
//    private KFactory base;
//
//    public KFactoryAdapter(KFactory base) {
//        this.base = base;
//    }
//
//
//    public KCredentials createCredentials(String login, char[] password) {
//        return base.createCredentials(login, password);
//    }
//
//    public KSysLog createSysLog(String name) {
//        return base.createSysLog(name);
//    }
//
//    public KMemoryManager createMemoryManager() {
//        return base.createMemoryManager();
//    }
//
//    public KSecurityManager createSecurityManager() {
//        return base.createSecurityManager();
//    }
//
//    public KCostManager createMigrationManager() {
//        return base.createMigrationManager();
//    }
//
//    public KLocalSite createSite() {
//        return base.createSite();
//    }
//
//    public KSiteManager createSiteNamingTable() {
//        return base.createSiteNamingTable();
//    }
//
//    public KLocalScreenDevice createScreen() throws RemoteException {
//        return base.createScreen();
//    }
//
//    public KLocalOutputStream createOutputStream(OutputStream out) throws RemoteException {
//        return base.createOutputStream(out);
//    }
//
//    public KLocalInputStream createInputStream(InputStream in) throws RemoteException {
//        return base.createInputStream(in);
//    }
//
//    public KInterpreter createInterpreter(KProcess process) throws RemoteException {
//        return base.createInterpreter(process);
//    }
//
//    public KGarbageCollector createGarbageCollector(KEnvInfo[] env) throws RemoteException {
//        return base.createGarbageCollector(env);
//    }
//
//    public KLocalMemorySegment createMemorySegment(KProcess process, KEnvInfo[] envs, KSegmentDef options) throws RemoteException {
//        return base.createMemorySegment(process, envs, options);
//    }
//
//    public KFrame createThreadFrame(KLocalThread thread, int index, KMethod method, KRegister[] parameters, KProcessCache cache) throws RemoteException {
//        return base.createThreadFrame(thread, index, method, parameters, cache);
//    }
//
//    public KClassDefRepository createClassDefRepository(final KProcess process) throws RemoteException {
//        return base.createClassDefRepository(process);
//    }
//
//    public KClassLoader createBootstrapClassLoader(final KProcess process, String[] bootstrapPaths) throws RemoteException {
//        return base.createBootstrapClassLoader(process, bootstrapPaths);
//    }
//
//    public KLocalThread createThread(KProcess process, KInterpreter kjvmInterpreter) throws RemoteException {
//        return base.createThread(process, kjvmInterpreter);
//    }
//
//    public KLocalProcess createProcess(KProcess parentProcess, KEnvInfo[] envs) throws RemoteException {
//        return base.createProcess(parentProcess, envs);
//    }
//
//    public KResource createResource(String path, KResource[] resources) throws RemoteException {
//        return base.createResource(path, resources);
//    }
//
//    public KWhichLocator createWhichLocator() throws RemoteException {
//        return base.createWhichLocator();
//    }
//
//    public KFileSystemManager createFileSystemManager() throws RemoteException {
//        return base.createFileSystemManager();
//    }
//
//    public KResourceBlocking createParkLock(KLocalThread local) throws RemoteException {
//        return base.createParkLock(local);
//    }
//
//    public KResourceBlocking createAbsoluteTimeLock(KLocalThread local, long time) throws RemoteException {
//        return base.createAbsoluteTimeLock(local, time);
//    }
//
//    public KResourceBlocking createRelativeTimeLock(KLocalThread local, long time) throws RemoteException {
//        return base.createRelativeTimeLock(local, time);
//    }
//
//    public KFactory getBase() {
//        return base;
//    }
//
//    public KLocalClassRepository createClassRepository(KProcess process, KEnvInfo[] envs) throws RemoteException {
//        return base.createClassRepository(process, envs);
//    }
//
//    public KFile createFile(String path, File hostFile) throws RemoteException {
//        return base.createFile(path,hostFile);
//    }
//
//    public KFolder createFolder(String path, File hostFolder) throws RemoteException {
//        return base.createFolder(path,hostFolder);
//    }
//}
