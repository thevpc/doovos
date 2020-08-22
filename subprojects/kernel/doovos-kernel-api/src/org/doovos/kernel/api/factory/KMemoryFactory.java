/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.api.factory;

import java.rmi.RemoteException;
import java.util.Properties;
import org.doovos.kernel.api.jvm.bytecode.KClassDef;
import org.doovos.kernel.api.jvm.bytecode.KSegmentDef;
import org.doovos.kernel.api.memory.KLocalMemorySegment;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.process.KProcess;

/**
 *
 * @author vpc
 */
public interface KMemoryFactory {

    public void prepareClassDef(KClassDef classDef);
    
    public KMemoryManager createMemoryManager();

    public KLocalMemorySegment createMemorySegment(KProcess process, Properties envs, KSegmentDef options) throws RemoteException;
}
