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
package org.doovos.kernel.core.process;

import org.doovos.kernel.api.process.KProcessLiveStatus;
import org.doovos.kernel.api.process.KProcessRequestedStatus;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 24 mai 2009
 * Time: 20:50:04
 * To change this template use File | Settings | File Templates.
 */
public class KProcessstatusFSA {
    public static final int[][] FSA_MATRIX = new int[KProcessLiveStatus._MAX_ /*values().length*/][KProcessRequestedStatus._MAX_ /*values().length*/];
    //private static final KProcessLiveStatus[] cachedProcessLiveStatusValues = KProcessLiveStatus.values();

    static {
        int THROW = -2;
        for (int i = 0; i < FSA_MATRIX.length; i++) {
            for (int j = 0; j < FSA_MATRIX[i].length; j++) {
                FSA_MATRIX[i][j] = THROW;
            }
        }
        FSA_MATRIX[KProcessLiveStatus.INIT/*.ordinal()*/][KProcessRequestedStatus.INIT/*.ordinal()*/] = KProcessLiveStatus.INIT/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.INIT/*.ordinal()*/][KProcessRequestedStatus.READY/*.ordinal()*/] = KProcessLiveStatus.INIT_READY/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.INIT/*.ordinal()*/][KProcessRequestedStatus.RUNNING/*.ordinal()*/] = THROW;
        FSA_MATRIX[KProcessLiveStatus.INIT/*.ordinal()*/][KProcessRequestedStatus.BLOCKED/*.ordinal()*/] = KProcessLiveStatus.INIT_BLOCKED/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.INIT/*.ordinal()*/][KProcessRequestedStatus.SHADOW/*.ordinal()*/] = KProcessLiveStatus.INIT_SHADOW/*.ordinal()*/;

        FSA_MATRIX[KProcessLiveStatus.INIT_READY/*.ordinal()*/][KProcessRequestedStatus.INIT/*.ordinal()*/] = KProcessLiveStatus.INIT_READY/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.INIT_READY/*.ordinal()*/][KProcessRequestedStatus.READY/*.ordinal()*/] = KProcessLiveStatus.INIT_READY/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.INIT_READY/*.ordinal()*/][KProcessRequestedStatus.RUNNING/*.ordinal()*/] = THROW;
        FSA_MATRIX[KProcessLiveStatus.INIT_READY/*.ordinal()*/][KProcessRequestedStatus.BLOCKED/*.ordinal()*/] = KProcessLiveStatus.INIT_BLOCKED/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.INIT_READY/*.ordinal()*/][KProcessRequestedStatus.SHADOW/*.ordinal()*/] = KProcessLiveStatus.INIT_SHADOW/*.ordinal()*/;

        FSA_MATRIX[KProcessLiveStatus.INIT_BLOCKED/*.ordinal()*/][KProcessRequestedStatus.INIT/*.ordinal()*/] = KProcessLiveStatus.INIT_BLOCKED/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.INIT_BLOCKED/*.ordinal()*/][KProcessRequestedStatus.READY/*.ordinal()*/] = KProcessLiveStatus.INIT_READY/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.INIT_BLOCKED/*.ordinal()*/][KProcessRequestedStatus.RUNNING/*.ordinal()*/] = THROW;
        FSA_MATRIX[KProcessLiveStatus.INIT_BLOCKED/*.ordinal()*/][KProcessRequestedStatus.BLOCKED/*.ordinal()*/] = KProcessLiveStatus.INIT_BLOCKED/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.INIT_BLOCKED/*.ordinal()*/][KProcessRequestedStatus.SHADOW/*.ordinal()*/] = KProcessLiveStatus.INIT_SHADOW/*.ordinal()*/;

        FSA_MATRIX[KProcessLiveStatus.INIT_SHADOW/*.ordinal()*/][KProcessRequestedStatus.INIT/*.ordinal()*/] = KProcessLiveStatus.INIT_SHADOW/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.INIT_SHADOW/*.ordinal()*/][KProcessRequestedStatus.READY/*.ordinal()*/] = KProcessLiveStatus.INIT_READY/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.INIT_SHADOW/*.ordinal()*/][KProcessRequestedStatus.RUNNING/*.ordinal()*/] = THROW;
        FSA_MATRIX[KProcessLiveStatus.INIT_SHADOW/*.ordinal()*/][KProcessRequestedStatus.BLOCKED/*.ordinal()*/] = KProcessLiveStatus.INIT_BLOCKED/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.INIT_SHADOW/*.ordinal()*/][KProcessRequestedStatus.SHADOW/*.ordinal()*/] = KProcessLiveStatus.INIT_SHADOW/*.ordinal()*/;

        FSA_MATRIX[KProcessLiveStatus.INIT_ZOMBIE/*.ordinal()*/][KProcessRequestedStatus.INIT/*.ordinal()*/] = KProcessLiveStatus.INIT_ZOMBIE/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.INIT_ZOMBIE/*.ordinal()*/][KProcessRequestedStatus.READY/*.ordinal()*/] = KProcessLiveStatus.INIT_READY/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.INIT_ZOMBIE/*.ordinal()*/][KProcessRequestedStatus.RUNNING/*.ordinal()*/] = THROW;
        FSA_MATRIX[KProcessLiveStatus.INIT_ZOMBIE/*.ordinal()*/][KProcessRequestedStatus.BLOCKED/*.ordinal()*/] = KProcessLiveStatus.INIT_BLOCKED/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.INIT_ZOMBIE/*.ordinal()*/][KProcessRequestedStatus.SHADOW/*.ordinal()*/] = KProcessLiveStatus.INIT_SHADOW/*.ordinal()*/;

        FSA_MATRIX[KProcessLiveStatus.READY/*.ordinal()*/][KProcessRequestedStatus.INIT/*.ordinal()*/] = KProcessLiveStatus.READY/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.READY/*.ordinal()*/][KProcessRequestedStatus.RUNNING/*.ordinal()*/] = KProcessLiveStatus.READY_RUNNING/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.READY/*.ordinal()*/][KProcessRequestedStatus.BLOCKED/*.ordinal()*/] = KProcessLiveStatus.READY_BLOCKED/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.READY/*.ordinal()*/][KProcessRequestedStatus.SHADOW/*.ordinal()*/] = KProcessLiveStatus.INIT_SHADOW/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.READY/*.ordinal()*/][KProcessRequestedStatus.ZOMBIE/*.ordinal()*/] = KProcessLiveStatus.READY_ZOMBIE/*.ordinal()*/;

        FSA_MATRIX[KProcessLiveStatus.READY_RUNNING/*.ordinal()*/][KProcessRequestedStatus.INIT/*.ordinal()*/] = KProcessLiveStatus.READY_RUNNING/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.READY_RUNNING/*.ordinal()*/][KProcessRequestedStatus.RUNNING/*.ordinal()*/] = KProcessLiveStatus.READY_RUNNING/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.READY_RUNNING/*.ordinal()*/][KProcessRequestedStatus.BLOCKED/*.ordinal()*/] = KProcessLiveStatus.READY_BLOCKED/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.READY_RUNNING/*.ordinal()*/][KProcessRequestedStatus.SHADOW/*.ordinal()*/] = KProcessLiveStatus.INIT_SHADOW/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.READY_RUNNING/*.ordinal()*/][KProcessRequestedStatus.ZOMBIE/*.ordinal()*/] = KProcessLiveStatus.READY_ZOMBIE/*.ordinal()*/;

        FSA_MATRIX[KProcessLiveStatus.READY_BLOCKED/*.ordinal()*/][KProcessRequestedStatus.INIT/*.ordinal()*/] = KProcessLiveStatus.READY_BLOCKED/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.READY_BLOCKED/*.ordinal()*/][KProcessRequestedStatus.RUNNING/*.ordinal()*/] = KProcessLiveStatus.READY_RUNNING/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.READY_BLOCKED/*.ordinal()*/][KProcessRequestedStatus.BLOCKED/*.ordinal()*/] = KProcessLiveStatus.READY_BLOCKED/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.READY_BLOCKED/*.ordinal()*/][KProcessRequestedStatus.SHADOW/*.ordinal()*/] = KProcessLiveStatus.INIT_SHADOW/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.READY_BLOCKED/*.ordinal()*/][KProcessRequestedStatus.ZOMBIE/*.ordinal()*/] = KProcessLiveStatus.READY_ZOMBIE/*.ordinal()*/;

        FSA_MATRIX[KProcessLiveStatus.READY_SHADOW/*.ordinal()*/][KProcessRequestedStatus.INIT/*.ordinal()*/] = KProcessLiveStatus.READY_SHADOW/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.READY_SHADOW/*.ordinal()*/][KProcessRequestedStatus.RUNNING/*.ordinal()*/] = KProcessLiveStatus.READY_RUNNING/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.READY_SHADOW/*.ordinal()*/][KProcessRequestedStatus.BLOCKED/*.ordinal()*/] = KProcessLiveStatus.READY_BLOCKED/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.READY_SHADOW/*.ordinal()*/][KProcessRequestedStatus.SHADOW/*.ordinal()*/] = KProcessLiveStatus.INIT_SHADOW/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.READY_SHADOW/*.ordinal()*/][KProcessRequestedStatus.ZOMBIE/*.ordinal()*/] = KProcessLiveStatus.READY_ZOMBIE/*.ordinal()*/;

        FSA_MATRIX[KProcessLiveStatus.READY_ZOMBIE/*.ordinal()*/][KProcessRequestedStatus.INIT/*.ordinal()*/] = KProcessLiveStatus.READY_ZOMBIE/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.READY_ZOMBIE/*.ordinal()*/][KProcessRequestedStatus.RUNNING/*.ordinal()*/] = KProcessLiveStatus.READY_RUNNING/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.READY_ZOMBIE/*.ordinal()*/][KProcessRequestedStatus.BLOCKED/*.ordinal()*/] = KProcessLiveStatus.READY_BLOCKED/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.READY_ZOMBIE/*.ordinal()*/][KProcessRequestedStatus.SHADOW/*.ordinal()*/] = KProcessLiveStatus.INIT_SHADOW/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.READY_ZOMBIE/*.ordinal()*/][KProcessRequestedStatus.ZOMBIE/*.ordinal()*/] = KProcessLiveStatus.READY_ZOMBIE/*.ordinal()*/;

        FSA_MATRIX[KProcessLiveStatus.RUNNING/*.ordinal()*/][KProcessRequestedStatus.READY/*.ordinal()*/] = KProcessLiveStatus.RUNNING_READY/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.RUNNING/*.ordinal()*/][KProcessRequestedStatus.RUNNING/*.ordinal()*/] = KProcessLiveStatus.RUNNING/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.RUNNING/*.ordinal()*/][KProcessRequestedStatus.BLOCKED/*.ordinal()*/] = KProcessLiveStatus.RUNNING_BLOCKED/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.RUNNING/*.ordinal()*/][KProcessRequestedStatus.SHADOW/*.ordinal()*/] = KProcessLiveStatus.RUNNING_SHADOW/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.RUNNING/*.ordinal()*/][KProcessRequestedStatus.ZOMBIE/*.ordinal()*/] = KProcessLiveStatus.RUNNING_ZOMBIE/*.ordinal()*/;

        FSA_MATRIX[KProcessLiveStatus.RUNNING_BLOCKED/*.ordinal()*/][KProcessRequestedStatus.READY/*.ordinal()*/] = KProcessLiveStatus.RUNNING_READY/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.RUNNING_BLOCKED/*.ordinal()*/][KProcessRequestedStatus.RUNNING/*.ordinal()*/] = KProcessLiveStatus.RUNNING_BLOCKED/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.RUNNING_BLOCKED/*.ordinal()*/][KProcessRequestedStatus.BLOCKED/*.ordinal()*/] = KProcessLiveStatus.RUNNING_BLOCKED/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.RUNNING_BLOCKED/*.ordinal()*/][KProcessRequestedStatus.SHADOW/*.ordinal()*/] = KProcessLiveStatus.RUNNING_SHADOW/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.RUNNING_BLOCKED/*.ordinal()*/][KProcessRequestedStatus.ZOMBIE/*.ordinal()*/] = KProcessLiveStatus.RUNNING_ZOMBIE/*.ordinal()*/;

        FSA_MATRIX[KProcessLiveStatus.RUNNING_READY/*.ordinal()*/][KProcessRequestedStatus.READY/*.ordinal()*/] = KProcessLiveStatus.RUNNING_READY/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.RUNNING_READY/*.ordinal()*/][KProcessRequestedStatus.RUNNING/*.ordinal()*/] = KProcessLiveStatus.RUNNING_READY/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.RUNNING_READY/*.ordinal()*/][KProcessRequestedStatus.BLOCKED/*.ordinal()*/] = KProcessLiveStatus.RUNNING_BLOCKED/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.RUNNING_READY/*.ordinal()*/][KProcessRequestedStatus.SHADOW/*.ordinal()*/] = KProcessLiveStatus.RUNNING_SHADOW/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.RUNNING_READY/*.ordinal()*/][KProcessRequestedStatus.ZOMBIE/*.ordinal()*/] = KProcessLiveStatus.RUNNING_ZOMBIE/*.ordinal()*/;

        FSA_MATRIX[KProcessLiveStatus.RUNNING_SHADOW/*.ordinal()*/][KProcessRequestedStatus.READY/*.ordinal()*/] = KProcessLiveStatus.RUNNING_READY/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.RUNNING_SHADOW/*.ordinal()*/][KProcessRequestedStatus.RUNNING/*.ordinal()*/] = KProcessLiveStatus.RUNNING_SHADOW/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.RUNNING_SHADOW/*.ordinal()*/][KProcessRequestedStatus.BLOCKED/*.ordinal()*/] = KProcessLiveStatus.RUNNING_BLOCKED/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.RUNNING_SHADOW/*.ordinal()*/][KProcessRequestedStatus.SHADOW/*.ordinal()*/] = KProcessLiveStatus.RUNNING_SHADOW/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.RUNNING_SHADOW/*.ordinal()*/][KProcessRequestedStatus.ZOMBIE/*.ordinal()*/] = KProcessLiveStatus.RUNNING_ZOMBIE/*.ordinal()*/;

        FSA_MATRIX[KProcessLiveStatus.RUNNING_ZOMBIE/*.ordinal()*/][KProcessRequestedStatus.READY/*.ordinal()*/] = KProcessLiveStatus.RUNNING_READY/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.RUNNING_ZOMBIE/*.ordinal()*/][KProcessRequestedStatus.RUNNING/*.ordinal()*/] = KProcessLiveStatus.RUNNING_ZOMBIE/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.RUNNING_ZOMBIE/*.ordinal()*/][KProcessRequestedStatus.BLOCKED/*.ordinal()*/] = KProcessLiveStatus.RUNNING_BLOCKED/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.RUNNING_ZOMBIE/*.ordinal()*/][KProcessRequestedStatus.SHADOW/*.ordinal()*/] = KProcessLiveStatus.RUNNING_SHADOW/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.RUNNING_ZOMBIE/*.ordinal()*/][KProcessRequestedStatus.ZOMBIE/*.ordinal()*/] = KProcessLiveStatus.RUNNING_ZOMBIE/*.ordinal()*/;

        FSA_MATRIX[KProcessLiveStatus.BLOCKED/*.ordinal()*/][KProcessRequestedStatus.READY/*.ordinal()*/] = KProcessLiveStatus.BLOCKED_READY/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.BLOCKED/*.ordinal()*/][KProcessRequestedStatus.BLOCKED/*.ordinal()*/] = KProcessLiveStatus.BLOCKED/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.BLOCKED/*.ordinal()*/][KProcessRequestedStatus.SHADOW/*.ordinal()*/] = KProcessLiveStatus.BLOCKED_SHADOW/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.BLOCKED/*.ordinal()*/][KProcessRequestedStatus.ZOMBIE/*.ordinal()*/] = KProcessLiveStatus.BLOCKED_ZOMBIE/*.ordinal()*/;

        FSA_MATRIX[KProcessLiveStatus.BLOCKED_READY/*.ordinal()*/][KProcessRequestedStatus.READY/*.ordinal()*/] = KProcessLiveStatus.BLOCKED_READY/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.BLOCKED_READY/*.ordinal()*/][KProcessRequestedStatus.BLOCKED/*.ordinal()*/] = KProcessLiveStatus.BLOCKED/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.BLOCKED_READY/*.ordinal()*/][KProcessRequestedStatus.SHADOW/*.ordinal()*/] = KProcessLiveStatus.BLOCKED_SHADOW/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.BLOCKED_READY/*.ordinal()*/][KProcessRequestedStatus.ZOMBIE/*.ordinal()*/] = KProcessLiveStatus.BLOCKED_ZOMBIE/*.ordinal()*/;

        FSA_MATRIX[KProcessLiveStatus.BLOCKED_SHADOW/*.ordinal()*/][KProcessRequestedStatus.READY/*.ordinal()*/] = KProcessLiveStatus.BLOCKED_READY/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.BLOCKED_SHADOW/*.ordinal()*/][KProcessRequestedStatus.BLOCKED/*.ordinal()*/] = KProcessLiveStatus.BLOCKED/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.BLOCKED_SHADOW/*.ordinal()*/][KProcessRequestedStatus.SHADOW/*.ordinal()*/] = KProcessLiveStatus.BLOCKED_SHADOW/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.BLOCKED_SHADOW/*.ordinal()*/][KProcessRequestedStatus.ZOMBIE/*.ordinal()*/] = KProcessLiveStatus.BLOCKED_ZOMBIE/*.ordinal()*/;

        FSA_MATRIX[KProcessLiveStatus.BLOCKED_ZOMBIE/*.ordinal()*/][KProcessRequestedStatus.READY/*.ordinal()*/] = KProcessLiveStatus.BLOCKED_READY/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.BLOCKED_ZOMBIE/*.ordinal()*/][KProcessRequestedStatus.BLOCKED/*.ordinal()*/] = KProcessLiveStatus.BLOCKED/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.BLOCKED_ZOMBIE/*.ordinal()*/][KProcessRequestedStatus.SHADOW/*.ordinal()*/] = KProcessLiveStatus.BLOCKED_SHADOW/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.BLOCKED_ZOMBIE/*.ordinal()*/][KProcessRequestedStatus.ZOMBIE/*.ordinal()*/] = KProcessLiveStatus.BLOCKED_ZOMBIE/*.ordinal()*/;

        FSA_MATRIX[KProcessLiveStatus.SHADOW/*.ordinal()*/][KProcessRequestedStatus.READY/*.ordinal()*/] = KProcessLiveStatus.SHADOW_READY/*.ordinal()*/;
        FSA_MATRIX[KProcessLiveStatus.SHADOW/*.ordinal()*/][KProcessRequestedStatus.SHADOW/*.ordinal()*/] = KProcessLiveStatus.SHADOW/*.ordinal()*/;

        FSA_MATRIX[KProcessLiveStatus.ZOMBIE/*.ordinal()*/][KProcessRequestedStatus.ZOMBIE/*.ordinal()*/] = KProcessLiveStatus.ZOMBIE/*.ordinal()*/;

    }
}
