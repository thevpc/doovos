/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.doovos.kernel.api.memory;

import java.rmi.RemoteException;
import org.doovos.kernel.api.filesystem.KLocalResource;
import org.doovos.kernel.api.jvm.bytecode.KSegmentDef;
import org.doovos.kernel.api.process.KProcess;

/**
 *
 * @author vpc
 */
public interface KLocalMemorySegment extends KMemorySegment,KLocalResource{
    public void init(KProcess process,KSegmentDef options) throws RemoteException;
}
