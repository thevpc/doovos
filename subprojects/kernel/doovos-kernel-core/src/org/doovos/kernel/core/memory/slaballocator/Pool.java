/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.core.memory.slaballocator;

import java.io.Serializable;
import java.lang.reflect.Array;

/**
 *
 * @author vpc
 */
abstract class Pool<T> implements Serializable {

    private int maxPoolSize = 1000;
    private int initPoolSize = 1000;
    //private LinkedList<T> pool = new LinkedList<T>();
    private T[] pool;
    private int index;

    public Pool(int init,int max,Class<T> cls) {
        this.initPoolSize=init;
        this.maxPoolSize=max;
        pool=(T[]) Array.newInstance(cls, max);
        for(int i=0;i<init;i++){
            pool[i]=createInstance();
        }
        index=init;
    }

    public T getPooledInstance() {
//        return createInstance();
        T i;
        if (index>0) {
            i = pool[--index];
            resetInstance(i);
        } else  {
            i=pool[0] = createInstance();
            index=1;
        }
        return i;
    }

    public abstract void resetInstance(T t);
    public abstract T createInstance();

    void freePooledInstance(T instance) {
        if (index < maxPoolSize) {
            pool[index++]=instance;
        }
    }
}
