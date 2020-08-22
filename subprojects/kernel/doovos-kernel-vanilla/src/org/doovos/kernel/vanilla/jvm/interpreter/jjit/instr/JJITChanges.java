/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr;

import org.doovos.kernel.api.memory.KRegisterType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author vpc
 */
public class JJITChanges implements Iterable<JJITChangeOp>{
    public static final JJITChanges NOTHING = new JJITChanges();
    private JJITChangeOp[] ops;

    public JJITChanges(JJITChangeOp... ops) {
        this.ops = ops;
    }

    public JJITChangeOp get(int i) {
        return ops[i];
    }

    public int getPopCount() {
        int x = 0;
        for (JJITChangeOp op : ops) {
            if(op.isPop()){
                x++;
            }
        }
        return x;
    }

    public int getPushCount() {
        int x = 0;
        for (JJITChangeOp op : ops) {
            if(op.isPush()){
                x++;
            }
        }
        return x;
    }

    public KRegisterType[] getPop() {
        ArrayList<KRegisterType> pops=new ArrayList<KRegisterType>();
        for (JJITChangeOp op : ops) {
            if(op.isPop()){
                pops.add(op.getRegisterType());
            }
        }
        return pops.toArray(new KRegisterType[pops.size()]);
    }

    public KRegisterType[] getPush() {
        ArrayList<KRegisterType> pushs=new ArrayList<KRegisterType>();
        for (JJITChangeOp op : ops) {
            if(op.isPush()){
                pushs.add(op.getRegisterType());
            }
        }
        return pushs.toArray(new KRegisterType[pushs.size()]);
    }

    public Iterator<JJITChangeOp> iterator() {
        return Arrays.asList(ops).iterator();
    }

    @Override
    public String toString() {
        return "JJITChanges{" +
                "ops=" + (ops == null ? null : Arrays.asList(ops)) +
                '}';
    }
}
