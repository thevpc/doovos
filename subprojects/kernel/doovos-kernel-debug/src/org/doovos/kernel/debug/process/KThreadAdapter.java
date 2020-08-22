//package org.doovos.kernel.debug.process;
//
//import org.doovos.kernel.api.filesystem.*;
//import org.doovos.kernel.api.jvm.interpreter.KFrame;
//import org.doovos.kernel.api.jvm.interpreter.KInterpreter;
//import org.doovos.kernel.api.jvm.reflect.KClass;
//import org.doovos.kernel.api.jvm.reflect.KMethod;
//import org.doovos.kernel.api.memory.KReference;
//import org.doovos.kernel.api.memory.KRegister;
//import org.doovos.kernel.api.process.KProcess;
//import org.doovos.kernel.api.process.KResourceBlocking;
//import org.doovos.kernel.api.process.KLocalThread;
//
//import java.io.Serializable;
//import java.rmi.RemoteException;
//import java.util.*;
//
//public class KThreadAdapter implements KLocalThread {
//
//    private KLocalThread base;
//
//    public KThreadAdapter(KLocalThread base) {
//        this.base = base;
//    }
//
//    public void requestStatus(int status) throws RemoteException {
//        base.requestStatus(status);
//    }
//
//    public void setStatus(int status) throws RemoteException {
//        base.setStatus(status);
//    }
//
//    public KFrame getFrame() throws RemoteException {
//        return base.getFrame();
//    }
//
//    public KFrame pushFrame(KMethod method, KRegister... parameters) throws RemoteException {
//        return base.pushFrame(method, parameters);
//    }
//
//    public void start(String clazz, String method, KRegister[] parameters) throws RemoteException {
//        base.start(clazz, method, parameters);
//    }
//
//    public KFrame popFrame() throws RemoteException {
//        return base.popFrame();
//    }
//
//    public KFrame rollbackFrame() throws RemoteException {
//        return base.rollbackFrame();
//    }
//
//    public KFrame getFrame(int i) throws RemoteException {
//        return base.getFrame(i);
//    }
//
//    public boolean isRunningNativeThread() throws RemoteException {
//        return base.isRunningNativeThread();
//    }
//
//    public int getStatus() throws RemoteException {
//        return base.getStatus();
//    }
//
//    public KProcess getProcess() throws RemoteException {
//        return base.getProcess();
//    }
//
//    public int getPriority() throws RemoteException {
//        return base.getPriority();
//    }
//
//    public void setPriority(int priority) throws RemoteException {
//        base.setPriority(priority);
//    }
//
//    public void addDependency(KResourceBlocking b) throws RemoteException {
//        base.addDependency(b);
//    }
//
//    public void removeDependency(KResourceBlocking b) throws RemoteException {
//        base.removeDependency(b);
//    }
//
//    public boolean waitChild() throws RemoteException {
//        return base.waitChild();
//    }
//
//    public void checkBlocking() throws RemoteException {
//        base.checkBlocking();
//    }
//
//    public KInterpreter getInterpreter() throws RemoteException {
//        return base.getInterpreter();
//    }
//
//    public void setJVMReference(KReference ref) throws RemoteException {
//        base.setJVMReference(ref);
//    }
//
//    public KReference getJVMReference() throws RemoteException {
//        return base.getJVMReference();
//    }
//
//    public void sleep(long time) throws RemoteException {
//        base.sleep(time);
//    }
//
//    public void start() throws RemoteException {
//        base.start();
//    }
//
//    public boolean isAlive() throws RemoteException {
//        return base.isAlive();
//    }
//
//    public int getFramesCount() throws RemoteException {
//        return base.getFramesCount();
//    }
//
//    public int getId() throws RemoteException {
//        return base.getId();
//    }
//
//    public String getStartClass() throws RemoteException {
//        return base.getStartClass();
//    }
//
//    public String getStartMethod() throws RemoteException {
//        return base.getStartMethod();
//    }
//
//    public List<KRegister> getStartParams() throws RemoteException {
//        return base.getStartParams();
//    }
//
//    public boolean isLeaf() throws RemoteException {
//        return base.isLeaf();
//    }
//
//    public KResource getChild(String[] path, int offset) throws RemoteException {
//        return base.getChild(path, offset);
//    }
//
//    public String getPath() throws RemoteException {
//        return base.getPath();
//    }
//
//    public KInternalPath getInternalPath() throws RemoteException {
//        return base.getInternalPath();
//    }
//
//    public String getName() throws RemoteException {
//        return base.getName();
//    }
//
//    public void free() throws RemoteException {
//        base.free();
//    }
//
//    public KResource getParent() throws RemoteException {
//        return base.getParent();
//    }
//
//    public String getShortDesc() throws RemoteException {
//        return base.getShortDesc();
//    }
//
//    public String getLongDesc() throws RemoteException {
//        return base.getLongDesc();
//    }
//
//    public void setShortDesc(String desc) throws RemoteException {
//        base.setShortDesc(desc);
//    }
//
//    public void setLongDesc(String desc) throws RemoteException {
//        base.setLongDesc(desc);
//    }
//
//    public Date getCreationTime() throws RemoteException {
//        return base.getCreationTime();
//    }
//
//    public Class getImplClass() throws RemoteException {
//        return base.getImplClass();
//    }
//
//    public Map<String, Object> getProperties(KPropertyFilter propsPattern) throws RemoteException {
//        return base.getProperties(propsPattern);
//    }
//
//    public Set<String> getPropertyNames(KPropertyFilter propsPattern) throws RemoteException {
//        return base.getPropertyNames(propsPattern);
//    }
//
//    public void setProperty(String key, Serializable value) throws RemoteException {
//        base.setProperty(key, value);
//    }
//
//    public Object getProperty(String property) throws RemoteException {
//        return base.getProperty(property);
//    }
//
//    public KResourceType getType() throws RemoteException {
//        return base.getType();
//    }
//
//    public Object setAttribute(String name, Object newValue) throws RemoteException {
//        return base.setAttribute(name, newValue);
//    }
//
//    public void setAttributes(Attributes newValues) throws RemoteException {
//        base.setAttributes(newValues);
//    }
//
//    public Serializable getAttribute(String name) throws RemoteException {
//        return base.getAttribute(name);
//    }
//
//    public void addPropertyEventListener(String dPath, String propertyEvent) throws RemoteException {
//        base.addPropertyEventListener(dPath, propertyEvent);
//    }
//
//    public void removePropertyEventListener(String dPath, String propertyEvent) throws RemoteException {
//        base.removePropertyEventListener(dPath, propertyEvent);
//    }
//
//    public void onPropertyEvent(KPropertyEvent event) throws RemoteException {
//        base.onPropertyEvent(event);
//    }
//
//    public String getCreationSiteId() throws RemoteException {
//        return base.getCreationSiteId();
//    }
//
//    public String getCurrentSiteId() throws RemoteException {
//        return base.getCurrentSiteId();
//    }
//
//    public void migrateTo(String siteId) throws RemoteException {
//        base.migrateTo(siteId);
//    }
//
//    public boolean isSticky() throws RemoteException {
//        return base.isSticky();
//    }
//
//    public KLifeStatus getLifeStatus() throws RemoteException {
//        return base.getLifeStatus();
//    }
//
//    public int getLocalChildrenCount() throws RemoteException {
//        return base.getLocalChildrenCount();
//    }
//
//    public Collection<KLocalResource> getLocalChildren() throws RemoteException {
//        return base.getLocalChildren();
//    }
//
//    public KLocalResource getLocalChild(String name) throws RemoteException {
//        return base.getLocalChild(name);
//    }
//
//    public void detach() throws RemoteException {
//        base.detach();
//    }
//
//    public void attach() throws RemoteException {
//        base.attach();
//    }
//
//    public void attach(KResource resource) throws RemoteException {
//        base.attach(resource);
//    }
//
//    public KResource toRemote() throws RemoteException {
//        return base.toRemote();
//    }
//
//    public void setPath(String path) throws RemoteException {
//        base.setPath(path);
//    }
//
//    public void setInternalPath(KInternalPath internalPath) throws RemoteException {
//        base.setInternalPath(internalPath);
//    }
//
//    public void run() throws RemoteException {
//        base.run();
//    }
//
//    public boolean pushClassInitializerFrame(KClass dpc) throws RemoteException {
//        return base.pushClassInitializerFrame(dpc);
//    }
//
//    public void initResource(String path) throws RemoteException {
//        base.initResource(path);
//    }
//
//    public String nextChildName(String prefix, String suffix) throws RemoteException {
//        return base.nextChildName(prefix,suffix);
//    }
//}
