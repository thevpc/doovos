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
package org.doovos.kernel.api.process;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 27 déc. 2005
 * Time: 23:19:53
 */
public final class KProcessLiveStatus {

    public static final int INIT = 0;
    public static final int READY = 1;
    public static final int RUNNING = 2;
    public static final int BLOCKED = 3;
    public static final int SHADOW = 4;
    public static final int ZOMBIE = 5;
    public static final int INIT_READY = 6;
    public static final int INIT_BLOCKED = 7;
    public static final int INIT_SHADOW = 8;
    public static final int INIT_ZOMBIE = 9;
    public static final int READY_RUNNING = 10;
    public static final int READY_BLOCKED = 11;
    public static final int READY_SHADOW = 12;
    public static final int READY_ZOMBIE = 13;
    public static final int RUNNING_READY = 14;
    public static final int RUNNING_BLOCKED = 15;
    public static final int RUNNING_SHADOW = 16;
    public static final int RUNNING_ZOMBIE = 17;
    public static final int BLOCKED_READY = 18;
    public static final int BLOCKED_SHADOW = 19;
    public static final int BLOCKED_ZOMBIE = 20;
    public static final int SHADOW_READY = 21;
    public static final int _MAX_ = SHADOW_READY + 1;

    public static String toString(int value) {
        switch (value) {
            case INIT:
                return "INIT";
            case READY:
                return "READY";
            case RUNNING:
                return "RUNNING";
            case BLOCKED:
                return "BLOCKED";
            case SHADOW:
                return "SHADOW";
            case ZOMBIE:
                return "ZOMBIE";

            case INIT_READY:
                return "INIT_READY";
            case INIT_BLOCKED:
                return "INIT_BLOCKED";
            case INIT_SHADOW:
                return "INIT_SHADOW";
            case INIT_ZOMBIE:
                return "INIT_ZOMBIE";

            case READY_RUNNING:
                return "READY_RUNNING";
            case READY_BLOCKED:
                return "READY_BLOCKED";
            case READY_SHADOW:
                return "READY_SHADOW";
            case READY_ZOMBIE:
                return "READY_ZOMBIE";

            case RUNNING_READY:
                return "RUNNING_READY";
            case RUNNING_BLOCKED:
                return "RUNNING_BLOCKED";
            case RUNNING_SHADOW:
                return "RUNNING_SHADOW";
            case RUNNING_ZOMBIE:
                return "RUNNING_ZOMBIE";

            case BLOCKED_READY:
                return "BLOCKED_READY";
            case BLOCKED_SHADOW:
                return "BLOCKED_SHADOW";
            case BLOCKED_ZOMBIE:
                return "BLOCKED_ZOMBIE";

            case SHADOW_READY:
                return "SHADOW_READY";
        }
        return String.valueOf(value);
    }
}
