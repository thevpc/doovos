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
package org.doovos.kernel.debug;

import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.api.process.KThread;
import org.doovos.kernel.debug.jvm.iterpreter.KFrameFilter;

import java.io.File;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class Debug {
    private final static Map<String, Logger> initializedLogger = new HashMap<String, Logger>();
    //private KFrameFilter filter = new KFrameMethodFilter("java\\.util\\.concurrent\\.atomic\\.AtomicLong", ".*");
    public static KFrameFilter filter = KFrameFilter.NONE;// new KFrameMethodFilter(".*", ".*objectFieldOffset.*");

    static {
        Logger rootLogger = Logger.getLogger("");
        Handler[] handlers = rootLogger.getHandlers();
        for (Handler handler : handlers) {
            handler.setFormatter(new DebugFormatter(""));
            rootLogger.removeHandler(handler);
        }
//        ConsoleHandler consoleHandler = new ConsoleHandler();
//        rootLogger.addHandler(consoleHandler);
    }

//    public static void log(KFrame frame,Object o) throws RemoteException {
//        log(frame.getProcess().getId(),frame.getThread().getId(),System.identityHashCode(frame.getThread()),o);
//    }
//
//    public static void log(int process,int thread,int sub_id,Object o){
//        log(process,thread,sub_id).info(o.toString());
//    }

    //

    public static Logger log(KThread thread0) throws RemoteException {
        synchronized (initializedLogger) {
            int process = thread0.getProcess().getId();
            int thread = thread0.getId();
            int sub_id = System.identityHashCode(thread0);
            String id = process + "_" + thread + "_" + sub_id;
            Logger logger = initializedLogger.get(id);
            if (logger == null) {
                logger = Logger.getLogger(Debug.class.getName() + id);
                FileHandler fileHandler = null;
                String p = thread0.getStartClass();
                int i = p.lastIndexOf('.');
                if (i > 0) {
                    p = p.substring(i + 1);
                }
                p = p + "." + thread0.getStartMethod();
                try {
                    File localTmpFolder = Doovos.getSystem().getBootConfig().getLocalTempFolder();
                    String prefixPath=localTmpFolder.getPath() +"/data/sys/log/";
                    new File(Doovos.getSystem().getBootConfig().getBootFolder(),prefixPath).mkdirs();
                    fileHandler = new FileHandler(prefixPath+ "thread_" + id + "_" + (thread0.getStartClass() + "." + thread0.getStartMethod().replace('[', '_').replace('/', '_').replace(';', '_')) + ".log");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                DebugFormatter formatter = new DebugFormatter(thread0.getStartClass() + "." + thread0.getStartMethod());
                fileHandler.setFormatter(formatter);
                logger.addHandler(fileHandler);
//                String sysprop_LOG = thread0.getProcess().get("DEBUG_LOG");
//                if (sysprop_LOG != null && "console".matches(sysprop_LOG)) {
                    ConsoleHandler consoleHandler = new ConsoleHandler();
                    consoleHandler.setFormatter(new DebugFormatter(id + "]" + p));
                    logger.addHandler(consoleHandler);
//                }

                initializedLogger.put(id, logger);
            }
            return logger;
        }
    }

    public static boolean isDebug(String type,String typePattern){
        if (typePattern == null) {
            return false;
        }
        String[] strings = typePattern.split(",");
        boolean positive = false;
//        boolean negative = false;
        int positiveCount = 0;
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i].trim();
            if (!string.startsWith("!")) {
                positiveCount++;
                if (type.matches(string.replace("*", ".*"))) {
                    positive = true;
                }
            } else {
                if (type.matches(string.substring(1).replace("*", ".*"))) {
                    return false;
                }
            }
        }
        return positiveCount == 0 || positive;
    }

    public static KFrameFilter getDebugFilter(KProcess process) throws RemoteException {
        return filter;
    }
}
