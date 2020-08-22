/**
 * ====================================================================
 *             Doovos (Distributed Object Oriented Operating System)
 *
 * Doovos is a new Open Source Distributed Object Oriented Operating System
 * Design and implementation based on the Java Platform.
 * Actually, it is a try for designing a distributed operation system in
 * top of existing centralized/network OS.
 * Designed OS will follow the object oriented architecture for redefining
 * all OS resources (memory,process,file system,device,...etc.) in a highly
 * distributed context.
 * Doovos is also a distributed Java virtual machine that implements JVM
 * specification on top the distributed resources context.
 *
 * Doovos Kernel is the heart of Doovos OS. It implements also the Doovos JVM
 * Doovos Kernel code is executed on host JVM
 *
 * Copyright (C) 2008-2010 Taha BEN SALAH
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 * ====================================================================
 */
package org.doovos.kernel.debug.jvm.iterpreter;

import org.doovos.kernel.debug.jvm.iterpreter.filter.KFrameDepthFilter;
import org.doovos.kernel.debug.jvm.iterpreter.filter.KFrameFilterList;
import org.doovos.kernel.debug.jvm.iterpreter.filter.KFrameMethodFilter;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.doovos.kernel.api.jvm.interpreter.KInterpreter;
import org.doovos.kernel.api.jvm.reflect.KInstruction;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.memory.KInteger;
import org.doovos.kernel.api.memory.KShort;
import org.doovos.kernel.api.memory.KChar;
import org.doovos.kernel.api.memory.KReturn;
import org.doovos.kernel.api.memory.KByte;
import org.doovos.kernel.api.memory.KBoolean;
import org.doovos.kernel.api.memory.KDouble;
import org.doovos.kernel.api.memory.KFloat;
import org.doovos.kernel.api.memory.KLong;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.KPointerInfo;
import org.doovos.kernel.api.process.KLocalThread;

import java.rmi.RemoteException;
import java.util.Properties;
import org.doovos.kernel.api.jvm.interpreter.KEndOfThreadException;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.jvm.reflect.KMethod;
//import org.doovos.kernel.core.util.IntHashMap;
import org.doovos.kernel.debug.Debug;
import org.doovos.kernel.debug.jvm.iterpreter.filter.KFrameStepFilter;

public final class KDebugInterpreter implements KInterpreter {

    private KInterpreter interpreter;
    private KLocalThread _thread;
    private KFrameFilterList frameFilter;
    private long step = 0;
    private long invocations = 0;
    private boolean debugRun;
    private boolean debugInitThread;
    private boolean debugInitMethod;
    private boolean debugInitFrame;
    private boolean debugStat;
    private boolean debugClose;
    private HashMap<Class, Integer> usage;
    //private IntHashMap statOpBy;

    private static class InstrInfo {

        private Class clazz;
        private int hits;
    }

    public KDebugInterpreter(Properties env) {
        try {
            this.interpreter = (KInterpreter) Class.forName(env.getProperty("Interpreter.Debug.Interpreter")).newInstance();
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
        String frameFilterString = env.getProperty("Interpreter.Debug.Depth");
        frameFilter = new KFrameFilterList();
        if (frameFilterString != null) {
            frameFilter.add(new KFrameDepthFilter(Integer.parseInt(frameFilterString)));
        }

        frameFilterString = env.getProperty("Interpreter.Debug.Method");
        if (frameFilterString != null) {
            frameFilter.add(new KFrameMethodFilter(frameFilterString));
        }
        String debugLines = env.getProperty("Interpreter.Debug.Step");
        if (debugLines != null && debugLines.length() > 0) {
            String[] strings = debugLines.split("-");
            frameFilter.add(new KFrameStepFilter(
                    strings[0].equals("*") ? -1 : Integer.parseInt(strings[0]),
                    strings[1].equals("*") ? -1 : Integer.parseInt(strings[1])));
        }
        String debugTypes = env.getProperty("Interpreter.Debug.Types");
        debugClose = Debug.isDebug("close", debugTypes);
        debugStat = Debug.isDebug("stat", debugTypes);
        debugRun = Debug.isDebug("run", debugTypes);
        debugInitFrame = Debug.isDebug("initFrame", debugTypes);
        debugInitThread = Debug.isDebug("initThread", debugTypes);
        debugInitMethod = Debug.isDebug("initMethod", debugTypes);
    }

    public void init(KLocalThread thread) throws Exception {
        this._thread = thread;
        if (debugInitThread) {
            Debug.log(thread).log(Level.INFO, "Init Thread {0} {1} {2}", new Object[]{thread.getStartClass(), thread.getStartMethod(), thread.getStartParams()});
        }
        interpreter.init(thread);
    }

    public KInstruction getCurrent(KFrame frame) throws Exception {
        return interpreter.getCurrent(frame);
    }

    public void run(KFrame frame) throws Exception {
        KLocalThread currentThread = frame.getThread();
        KInstruction i = getCurrent(frame);//  currentContext.getInstruction();
//        int popc = KOperatorCodes.ALL_OPERATORS[i.getOperator()].getPopCount();
//        int pushc = KOperatorCodes.ALL_OPERATORS[i.getOperator()].getPushCount();
        int stacksizeBefore = frame.getStackSize();
        String contextString = frame.toString();
//        if(s0.contains("<55571>")){
        boolean showDebug =
                frameFilter.accept(frame, step)
                && debugRun;
        String stackBefore = traceStack(frame);
        String localsBefore = traceLocals(frame);
        Throwable ex = null;
        try {
//            if (showDebug) {
//                //just to enable break point!!
//                showDebug = true;
//            }
            interpreter.run(frame);
        } catch (Throwable e) {
            ex = e;
        }
//        if(counter==79337){
//            System.out.println("?");
//        }
        if (showDebug || (ex != null && !(ex instanceof KEndOfThreadException)) ) {
            int stacksizeAfter = frame.getStackSize();
            String stackAfter = traceStack(frame);
            String localsAfter = traceLocals(frame);
            Logger log = Debug.log(currentThread);
            log.log(Level.INFO, "<{0}>{1} : Stack({2}->{3}){4}=>{5} ; locals{6}=>{7} :: {8}", new Object[]{step, contextString, stacksizeBefore, stacksizeAfter, stackBefore, stackAfter, localsBefore, localsAfter, i});
        }
        step++;
        if (ex != null) {
            if (ex instanceof Exception) {
                throw (Exception) ex;
            }
            throw new Exception(ex);
        }
    }

    public long getCounter() {
        return step;
    }

    public void init(KFrame frame) throws Exception {
        KLocalThread t = Doovos.currentThread();
        if (debugInitFrame && frameFilter.accept(frame, step)) {
            Debug.log(t).log(Level.INFO, "Init Frame {0}", frame.getMethod().getAbsoluteSignature());
        }
        interpreter.init(frame);
        invocations++;
    }

    public void init(KMethod method) throws Exception {
        KLocalThread t = Doovos.currentThread();
        if (debugInitMethod && frameFilter.accept(method, step)) {
            long start = System.currentTimeMillis();
            interpreter.init(method);
            long end = System.currentTimeMillis();
            Debug.log(t).log(Level.INFO, "Init Method {0} ms {1}", new Object[]{(end - start), method.getAbsoluteSignature()});
        } else {
            interpreter.init(method);
        }
    }

    public static String traceStack(KFrame ctx) throws RemoteException {
        StringBuilder s = new StringBuilder("{");
        for (int i = 0; i < ctx.getStackSize(); i++) {
            KRegister register = ctx.peek(i);
            if (i > 0) {
                s.append(",");
            }
            s.append(toDebugObject(register));
        }
        s.append("}");
        return s.toString();
    }

    public static String traceLocals(KFrame ctx) throws RemoteException {
        int locals = ctx.getMethod().getDefinition().getMaxLocals();
        String[] all = new String[locals];
        for (int i = 0; i < all.length; i++) {
            all[i] = "[" + i + "=" + toDebugObject(ctx.getLocal(i)) + "]";
        }
        return toDebugObject(all);
    }

    public static String toDebugObject(KRegister[] r) {
        StringBuilder s = new StringBuilder("{");
        for (int i = 0; i < r.length; i++) {
            KRegister register = r[i];
            if (i > 0) {
                s.append(",");
            }
            s.append(toDebugObject(register));
        }
        s.append("}");
        return s.toString();
    }

    public static String toDebugObject(String[] r) {
        StringBuilder s = new StringBuilder("{");
        for (int i = 0; i < r.length; i++) {
            String v = r[i];
            if (i > 0) {
                s.append(",");
            }
            s.append(v);
        }
        s.append("}");
        return s.toString();
    }

    public static String toDebugObject(KRegister r) {
        if (r == null) {
            return "**NULL**";
        } else if (r instanceof KBoolean) {
            KBoolean a = (KBoolean) r;
            return String.valueOf(a.value);
        } else if (r instanceof KByte) {
            KByte a = (KByte) r;
            return String.valueOf(a.value + "B");
        } else if (r instanceof KChar) {
            KChar a = (KChar) r;
            return String.valueOf("'" + a.value + "'");
        } else if (r instanceof KDouble) {
            KDouble a = (KDouble) r;
            return String.valueOf(a.value + "D");
        } else if (r instanceof KFloat) {
            KFloat a = (KFloat) r;
            return String.valueOf(a.value + "F");
        } else if (r instanceof KInteger) {
            KInteger a = (KInteger) r;
            return String.valueOf(a.value + "I");
        } else if (r instanceof KLong) {
            KLong a = (KLong) r;
            return String.valueOf(a.value + "L");
        } else if (r instanceof KShort) {
            KShort a = (KShort) r;
            return String.valueOf(a.value + "S");
        } else if (r instanceof KReturn) {
//            KReturn a=(KReturn) r;
            return String.valueOf(r);
        } else if (r instanceof KReference) {
            KReference a = (KReference) r;
            try {
                if (a.isNull()) {
                    return "NULL";
                }
                KPointerInfo pi = Doovos.getSystem().getMemoryManager().getPointer(a);
                if (pi.getKClass().getName().equals("java.lang.String")) {
                    KField valueField = pi.getKClass().getField("value", true);
                    KReference v = (KReference) valueField.getInstanceValue(a);
                    if (v.isNotNull()) {
                        return "\"" + Doovos.getSystem().getMemoryManager().getString(a) + "\"@(" + a.segment + "," + a.pointer + ")";
                    } else {
                        return "InvalidString@(" + a.segment + "," + a.pointer + ")";
                    }
                }
                return String.valueOf(pi);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            return String.valueOf(a);

        }
        throw new UnsupportedOperationException(KDebugInterpreter.class.getName());
    }

    public void close() {
        //
        if (_thread != null) {
            if (debugClose || debugStat) {
                try {
                    Logger log = Debug.log(_thread);
                    if (debugStat) {
                        log.log(Level.INFO, "Stat # Instructions: {0} ", new Object[]{step});
                        log.log(Level.INFO, "Stat # Invocations  : {0} ", new Object[]{invocations});
                    }
                    if (debugClose) {
                        log.log(Level.INFO, "End thread", new Object[]{});
                    }
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
