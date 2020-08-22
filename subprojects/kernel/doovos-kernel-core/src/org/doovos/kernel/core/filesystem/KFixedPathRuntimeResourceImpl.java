/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.doovos.kernel.core.filesystem;

import java.rmi.RemoteException;
import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.filesystem.KResource;
import org.doovos.kernel.api.filesystem.KResourceType;

/**
 *
 * @author vpc
 */
public class KFixedPathRuntimeResourceImpl extends KResourceImpl{
    private String fixedPath;

    public KFixedPathRuntimeResourceImpl(KResourceType type, boolean leaf,String path) throws RemoteException {
        super(type, leaf);
        this.fixedPath=path;
    }

    @Override
    public void attach() throws RemoteException {
        super.attach();
        initResource(fixedPath);
        Doovos.getSystem().getLocalSite().registerResource(this);
    }

    @Override
    public void attach(KResource resource) throws RemoteException {
        super.attach(resource);
        Doovos.getSystem().getLocalSite().registerResource(this);
    }

    @Override
    public void detach() throws RemoteException {
        super.detach();
        Doovos.getSystem().getLocalSite().unregisterResource(this);
    }

    @Override
    protected void freeImpl() throws RemoteException {
        super.freeImpl();
        Doovos.getSystem().getLocalSite().unregisterResource(this);
    }


}
