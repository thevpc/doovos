/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.doovos.kernel.api.filesystem;

import java.rmi.RemoteException;

/**
 *
 * @author vpc
 */
public interface KWhichLocator {
    public String[] which(String path, String workingdir, String pathEnv, String execExtensionEnv, String packageEnv, boolean rerieveOnlyFirst) throws RemoteException ;
}
