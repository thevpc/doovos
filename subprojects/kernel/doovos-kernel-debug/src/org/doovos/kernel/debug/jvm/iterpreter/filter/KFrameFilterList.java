/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.doovos.kernel.debug.jvm.iterpreter.filter;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.debug.jvm.iterpreter.KFrameFilter;

/**
 *
 * @author vpc
 */
public class KFrameFilterList implements KFrameFilter{
    private List<KFrameFilter> filters=new ArrayList<KFrameFilter>();

    public boolean accept(KFrame frame, long step) throws RemoteException {
        for (KFrameFilter f : filters) {
            if(!f.accept(frame, step)){
                return false;
            }
        }
        return true;
    }

    public boolean accept(KMethod method, long step) throws RemoteException {
        for (KFrameFilter f : filters) {
            if(!f.accept(method, step)){
                return false;
            }
        }
        return true;
    }



    public void add(KFrameFilter f){
        if(f!=null){
            filters.add(f);
        }
    }

}
