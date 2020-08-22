/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.debug.jvm.iterpreter.filter;

import java.rmi.RemoteException;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.debug.jvm.iterpreter.KFrameFilter;

/**
 *
 * @author vpc
 */
public class KFrameStepFilter implements KFrameFilter {

    private long stepMin;
    private long stepMax;

    public KFrameStepFilter(long stepMin, long stepMax) {
        this.stepMin = stepMin;
        this.stepMax = stepMax;
    }

    public boolean accept(KFrame frame, long step) throws RemoteException {
        return (stepMin < 0 || step >= stepMin)
                && (stepMax < 0 || step <= stepMax);
    }

    public boolean accept(KMethod method, long step) throws RemoteException {
        return (stepMin < 0 || step >= stepMin)
                && (stepMax < 0 || step <= stepMax);
    }


}
