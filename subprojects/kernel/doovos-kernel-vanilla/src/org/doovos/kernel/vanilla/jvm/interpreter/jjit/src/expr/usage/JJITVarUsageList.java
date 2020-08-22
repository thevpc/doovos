/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author vpc
 */
public class JJITVarUsageList implements Iterable<JJITVarUsage> {

    public ArrayList<JJITVarUsage> list = new ArrayList<JJITVarUsage>();

    public void add(JJITVarUsage a) {
        list.add(a);
    }

    public void addAll(JJITVarUsageList a) {
        list.addAll(a.list);
    }

    public Iterator<JJITVarUsage> iterator() {
        return list.iterator();
    }

    public boolean isReadBeforeUpdate(String readName, Set<String> updates) {
        for (JJITVarUsage t : list) {
            if (readName.equals(t.getVar().getValue())) {
                switch (t.getType()) {
                    case READ:
                    case GETTER: {
                        return true;
                    }
                    case WRITE:
                    case SETTER: {
                        return false;
                    }
                    default: {
                        throw new IllegalArgumentException("Unexpected");
                    }
                }
            }else if (updates.contains(t.getVar().getValue())) {
                switch (t.getType()) {
                    case READ:
                    case GETTER: {
                        //ignore
                        break;
                    }
                    case WRITE:
                    case SETTER: {
                        return false;
                    }
                    default: {
                        throw new IllegalArgumentException("Unexpected");
                    }
                }
            }
        }
        return false;
    }

    public boolean isWriteOrSet(String name) {
        for (JJITVarUsage t : list) {
            if (name.equals(t.getVar().getValue())) {
                switch (t.getType()) {
                    case READ:
                    case GETTER: {
                        //ignore
                        break;
                    }
                    case WRITE:
                    case SETTER: {
                        return true;
                    }
                    default: {
                        throw new IllegalArgumentException("Unexpected");
                    }
                }
            }
        }
        return false;
    }
    public boolean isWriteAlways(String name) {
        for (JJITVarUsage t : list) {
            if (name.equals(t.getVar().getValue())) {
                switch (t.getType()) {
                    case SETTER:
                    case READ:
                    case GETTER: {
                        //ignore
                        break;
                    }
                    case WRITE:{
                        if(!t.isConditional()){
                           return true;
                        }
                        break;
                    }
                    default: {
                        throw new IllegalArgumentException("Unexpected");
                    }
                }
            }
        }
        return false;
    }

    public boolean isWrite(String name) {
        for (JJITVarUsage t : list) {
            if (name.equals(t.getVar().getValue())) {
                switch (t.getType()) {
                    case SETTER:
                    case READ:
                    case GETTER: {
                        //ignore
                        break;
                    }
                    case WRITE:{
                        return true;
                    }
                    default: {
                        throw new IllegalArgumentException("Unexpected");
                    }
                }
            }
        }
        return false;
    }
    public boolean isSet(String name) {
        for (JJITVarUsage t : list) {
            if (name.equals(t.getVar().getValue())) {
                switch (t.getType()) {
                    case WRITE:
                    case READ:
                    case GETTER: {
                        //ignore
                        break;
                    }
                    case SETTER:{
                        return true;
                    }
                    default: {
                        throw new IllegalArgumentException("Unexpected");
                    }
                }
            }
        }
        return false;
    }

    public int getReads(String name) {
       int reads = 0;
        for (JJITVarUsage t : list) {
            if (name.equals(t.getVar().getValue())) {
                switch (t.getType()) {
                    case READ: {
                        reads++;
                        break;
                    }
                    case GETTER: {
                        //ignore
                        break;
                    }
                }
            }
        }
        return reads;
    }

    public int getReadsBeforeWriteOrSet(String name) {
        int reads = 0;
        for (JJITVarUsage t : list) {
            if (name.equals(t.getVar().getValue())) {
                switch (t.getType()) {
                    case READ: {
                        reads++;
                        break;
                    }
                    case GETTER: {
                        //ignore
                        break;
                    }
                    case WRITE:
                    case SETTER: {
                        return reads;
                    }
                    default: {
                        throw new IllegalArgumentException("Unexpected");
                    }
                }
            }
        }
        return reads;
    }
    public int getReadsAfterWriteOrSet(String name) {
        int reads = 0;
        boolean writeOrSet=false;
        for (JJITVarUsage t : list) {
            if (name.equals(t.getVar().getValue())) {
                switch (t.getType()) {
                    case READ: {
                        if(writeOrSet){
                            reads++;
                        }
                        break;
                    }
                    case GETTER: {
                        //ignore
                        break;
                    }
                    case WRITE:
                    case SETTER: {
                        writeOrSet=true;
                        break;
                    }
                    default: {
                        throw new IllegalArgumentException("Unexpected");
                    }
                }
            }
        }
        return reads;
    }

    public void combine(JJITVarUsageList a) {
        ArrayList<JJITVarUsage> b1 = new ArrayList<JJITVarUsage>(list);
        ArrayList<JJITVarUsage> b2 = a.list;
        list.clear();
        int max = Math.max(b1.size(), b2.size());
        for (int i = 0; i < max; i++) {
            JJITVarUsage u1 = null;
            JJITVarUsage u2 = null;
            if (i < b1.size()) {
                u1 = b1.get(i);
                if (i < b2.size()) {
                    u2 = b2.get(i);
                    if (u1.equals(u2)) {
                        //excellent, no problem
                    } else {
                        list.add(u1);
                        list.add(u2);
                    }
                } else {
                    list.add(u1);
                }
            } else {
                u2 = b2.get(i);
                list.add(u2);
            }
        }
    }
//    public boolean isRead();
//    public boolean isWrite();
//    public boolean isMultipleReads();
//    public boolean isMultipleWrites();
//    public boolean isReadAfterWrite();
//    public boolean isWriteAfterRead();
//    public boolean isStartReading();
//    public boolean isStartWriting();
}
