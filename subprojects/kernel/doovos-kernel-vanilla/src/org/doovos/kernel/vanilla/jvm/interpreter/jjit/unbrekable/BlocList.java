/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.unbrekable;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author vpc
 */
public class BlocList extends Bloc implements Iterable<Bloc>{

    private ArrayList<Bloc> content = new ArrayList<Bloc>();

    public Bloc get(int i) {
        return content.get(i);
    }
    
    public void add(Bloc a) {
        if (a instanceof BlocList) {
            content.addAll(((BlocList) a).content);
        } else {
            content.add(a);
        }
    }

    public Iterator<Bloc> iterator() {
        return content.iterator();
    }
    
    
}
