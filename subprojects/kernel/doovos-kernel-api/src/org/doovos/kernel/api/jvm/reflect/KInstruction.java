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
package org.doovos.kernel.api.jvm.reflect;


import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 1 mars 2009
 * Time: 00:07:41
 * To change this template use File | Settings | File Templates.
 */
public interface KInstruction extends Serializable {
    public KInstruction clone();
//    int run(KFrame frame) throws RemoteException;
//    KInstruction runDirect(KFrame frame) throws RemoteException;

//    void relink(int index, KInstruction[] code, KMethod method);
//
//
//    void restoreLabels(int index, KInstruction[] code, KMethod method, Hashtable<Integer, Integer> labelsMap) throws RemoteException;
//
//    void storeLabels(Hashtable<Integer, Integer> labelsMap) throws RemoteException;
//
//    boolean isJump() throws RemoteException;
//    boolean isLabel() throws RemoteException;
//
//
//    KInstruction clone();
//
//    public int getOrdinal();
//
//    public int getOperator();
//    public long[] getOperands();
}
