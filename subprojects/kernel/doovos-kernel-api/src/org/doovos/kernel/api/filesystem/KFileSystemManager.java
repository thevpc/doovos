package org.doovos.kernel.api.filesystem;

import java.rmi.RemoteException;
import java.util.Collection;

public interface KFileSystemManager {

    public void start() throws RemoteException;

    public void shutdown() throws RemoteException;

    public Collection<KResource> list(String path, KPathFilter filter) throws RemoteException;

    public KResource find(String path) throws RemoteException;
    public KResource getResource(String path) throws RemoteException;

    void invalidate(String path, boolean recurse) throws RemoteException;
    

    public boolean exists(String pathinternalPath) throws RemoteException;

    public String nextName(String parentPath,String prefix,String suffix,KNameAction action) throws RemoteException;

}
