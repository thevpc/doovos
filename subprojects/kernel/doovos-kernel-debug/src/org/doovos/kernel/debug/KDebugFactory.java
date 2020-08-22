///**
// * ====================================================================
// *             Doovos (Distributed Object Oriented Operating System)
// *
// * Doovos is a new Open Source Distributed Object Oriented Operating System
// * Design and implementation based on the Java Platform.
// * Actually, it is a try for designing a distributed operation system in
// * top of existing centralized/network OS.
// * Designed OS will follow the object oriented architecture for redefining
// * all OS resources (memory,process,file system,device,...etc.) in a highly
// * distributed context.
// * Doovos is also a distributed Java virtual machine that implements JVM
// * specification on top the distributed resources context.
// *
// * Doovos Kernel is the heart of Doovos OS. It implements also the Doovos JVM
// * Doovos Kernel code is executed on host JVM
// *
// * Copyright (C) 2008-2010 Taha BEN SALAH
// *
// * This program is free software; you can redistribute it and/or modify
// * it under the terms of the GNU General Public License as published by
// * the Free Software Foundation; either version 2 of the License, or
// * (at your option) any later version.
// *
// * This program is distributed in the hope that it will be useful,
// * but WITHOUT ANY WARRANTY; without even the implied warranty of
// * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// * GNU General Public License for more details.
// *
// * You should have received a copy of the GNU General Public License along
// * with this program; if not, write to the Free Software Foundation, Inc.,
// * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
// * ====================================================================
// */
//package org.doovos.kernel.debug;
//
//import org.doovos.kernel.api.KFactory;
//import org.doovos.kernel.api.jvm.interpreter.KFrame;
//import org.doovos.kernel.api.jvm.interpreter.KInterpreter;
//import org.doovos.kernel.api.jvm.reflect.KClass;
//import org.doovos.kernel.api.jvm.reflect.KMethod;
//import org.doovos.kernel.api.memory.KRegister;
//import org.doovos.kernel.api.process.KProcess;
//import org.doovos.kernel.api.process.KProcessCache;
//import org.doovos.kernel.api.process.KLocalThread;
//import org.doovos.kernel.debug.jvm.iterpreter.KDebugFrame;
//import org.doovos.kernel.debug.jvm.iterpreter.KDebugInterpreter;
//import org.doovos.kernel.debug.process.KDebugThread;
//
//import java.rmi.RemoteException;
//
///**
// * @author vpc
// */
//public class KDebugFactory extends KFactoryAdapter {
//    public KDebugFactory(KFactory base) {
//        super(base);
//    }
//
//
//    public KInterpreter createInterpreter(KProcess process) throws RemoteException {
//        KInterpreter baseInterpreter = getBase().createInterpreter(process);
//        if (Debug.isDebug(process, "interpreter")) {
//            baseInterpreter = new KDebugInterpreter(baseInterpreter, Debug.getDebugFilter(process));
//        }
//        return baseInterpreter;
//    }
//
//    public KLocalThread createThread(final KProcess process, KInterpreter kjvmInterpreter) throws RemoteException {
//        if (Debug.isDebug(process, "interpreter")) {
//            return new KDebugThread(getBase().createThread(process, kjvmInterpreter));
//        } else {
//            return getBase().createThread(process, kjvmInterpreter);
//        }
//    }
//
//    public KFrame createThreadFrame(final KLocalThread thread, int index, KMethod method, KRegister[] parameters, KProcessCache cache) throws RemoteException {
//        if (Debug.isDebug(thread.getProcess(), "interpreter")) {
//            return new KDebugFrame(Debug.getDebugFilter(thread.getProcess()), super.createThreadFrame(thread, index, method, parameters, cache));
//        } else {
//            return super.createThreadFrame(thread, index, method, parameters, cache);
//        }
//    }
//
//}
