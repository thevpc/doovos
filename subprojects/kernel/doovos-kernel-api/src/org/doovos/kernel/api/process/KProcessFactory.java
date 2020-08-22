package org.doovos.kernel.api.process;

import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.interpreter.KInterpreter;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Properties;

public interface KProcessFactory extends Serializable {
    public void init(KProcess parentProcess, Properties env) throws RemoteException ;
    public KFrame createThreadFrame() throws RemoteException ;
    public KInterpreter createInterpreter() throws RemoteException;
}
