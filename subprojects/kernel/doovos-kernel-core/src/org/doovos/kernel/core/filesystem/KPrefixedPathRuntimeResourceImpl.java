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
public class KPrefixedPathRuntimeResourceImpl extends KResourceImpl{
    private String parentPath;
    private String prefix;
    private String suffix;

    public KPrefixedPathRuntimeResourceImpl() throws RemoteException {

    }
    public KPrefixedPathRuntimeResourceImpl(KResourceType type, boolean leaf,String parentPath,String prefix,String suffix) throws RemoteException {
        super(type, leaf);
        this.parentPath=parentPath;
        this.prefix=prefix;
        this.suffix=suffix;
    }

    protected void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }

    protected void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    protected void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public void attach() throws RemoteException {
        super.attach();
        Doovos.getSystem().getLocalSite().registerResource(this,parentPath,prefix,suffix);
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
