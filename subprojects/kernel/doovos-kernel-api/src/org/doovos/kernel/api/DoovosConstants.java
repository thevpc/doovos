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
package org.doovos.kernel.api;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 15 dec. 2005
 * Time: 16:56:41
 */
public class DoovosConstants {

    /**
     * all native files prefixed with the following string are not
     * exported on the distributed system and could be used in local
     * specific site implementation (for cache, optimization, replication,
     * personnalization, etc...)
     */
    public static final String OS_RESERVED_FILENAME_PREFIX = ".reserved.";


    /**
     * System / path. the absolute root of the system
     */
    public static final String ROOT_PATH = "/";

    /**
     * System /program path
     * this path is a holder for all programs
     */
    public static final String RUNTIME_PATH = "/runtime";

    /**
     * System /devices path
     * this path is a holder for all system devices (screens, ... etc.)
     */
    public static final String DEVICE_PATH = RUNTIME_PATH + "/devices";

    /**
     * System /file path
     * this path is a holder for all system files
     */
    public static final String FILE_PATH = "/data";

    /**
     * System /home path
     * this path is a holder for all users working dirs
     */
    public static final String HOME_PATH = FILE_PATH + "/home";

    /**
     * System /home/root path
     * this path is a holder for root (super user) working dir
     */
    public static final String USER_ROOT_PATH = HOME_PATH + "/root";

    /**
     * System /home/root path
     * this path is a holder for all users working dir
     */
    public static final String USER_ALL_PATH = HOME_PATH + "/all";

    /**
     * System /home/root path
     * this path is a holder for all users working dir
     */
    public static final String USERS_PATH = HOME_PATH + "/users";

    /**
     * System /home/default path
     * this path is a holder for all users working dir
     */
    public static final String USER_DEFAULT_PATH = HOME_PATH + "/default";

    /**
     * System /home/root path
     * this path is a holder for root (super user) working dir
     */
    public static final String SITE_PATH = RUNTIME_PATH + "/sites";

    /**
     * System /config path
     * this path is a holder for all system config items (not directly related to a specific site
     */
    public static final String SYSTEM_PATH = FILE_PATH + "/sys";

    /**
     * System /config path
     * this path is a holder for all system config items (not directly related to a specific site
     */
    public static final String SYSTEM_BOOT_PATH = SYSTEM_PATH + "/boot";


    /**
     * System /program path
     * this path is a holder for all programs
     */
    public static final String PROGRAM_PATH = RUNTIME_PATH + "/programs";


    /**
     * System /stream path
     * this path is a holder for all system streams (in/out, pipes, ...etc.)
     */
    public static final String STREAM_PATH = RUNTIME_PATH + "/streams";

    /**
     * System /process path.
     * this path is a holder for all system process
     */
    public static final String PROCESS_PATH = RUNTIME_PATH + "/processes";
    public static final String MEMORY_SEGMENTS_PATH = RUNTIME_PATH + "/memsegments";
    public static final String CLASS_REPOSITORY_PATH = RUNTIME_PATH + "/classrepositories";

    public static final String PROCESS_MEM_NAME = "mem";
    public static final String PROCESS_THREAD_NAME = "threads";

    public static final String PROCESS_PREFIX = "";
    public static final String DEVICE_SCREEN_PREFIX = "screen";
    public static final String DEVICE_TERM_PREFIX = "term";
    public static final String STREAM_OUT_PREFIX = "out";
    public static final String STREAM_IN_PREFIX = "in";

    public static final String STREAM_PIPE_PREFIX = "pipe";

    public static final String STREAM_SOURCE = "streamSource";
    public static final String FILE_SIZE_PROPERTY = "memorySize";
    public static final String FILE_HIDDEN_PROPERTY = "hidden";
    public static final String FILE_LAST_MODIFIED_PROPERTY = "mtime";
    public static final String PROCESS_STATUS_PROPERTY = "status";
    public static final String PROCESS_CMD_PROPERTY = "cmd";
    public static final String PROCESS_TITLE_PROPERTY = "title";
    public static final String PROCESS_PARENT_PROPERTY = "parent";

    /**
     * children pids
     */
    public static final String PROCESS_CPIDS_PROPERTY = "cpids";


    public static final String RESOURCE_INIT_THREAD = "initthread";
    public static final String RESOURCE_INIT_PROCESS = "initprocess";
    public static final String RESOURCE_NAME_PROPERTY = "name";
    public static final String RESOURCE_TYPE_PROPERTY = "type";
    public static final String RESOURCE_SITE_PROPERTY = "site";
    public static final String RESOURCE_IMPL_PROPERTY = "impl";
    public static final String RESOURCE_PATH_PROPERTY = "path";
    public static final String RESOURCE_CREATION_TIME_PROPERTY = "ctime";
    public static final String RESOURCE_CREATION_SITE_PROPERTY = "csite";
    public static final String RESOURCE_CHILDREN_COUNT_PROPERTY = "entries";
    public static final String RESOURCE_PROPERTY_NAMES_PROPERTY = "props";
    public static final String MEM_PREVIEW_PROPERTY = "preview";
    public static final String MEM_VALUE_PROPERTY = "value";
    public static final String MEM_CLASS_PROPERTY = "class";
    public static final String ENV_EXPORT_PROPERTY = "export";


    public static final String ENV_SYSTEM_CMD = "CMD";
    public static final String ENV_SYSTEM_TERM = "term";
    public static final String ENV_SYSTEM_WORKING_DIR = "CWD";
    public static final String ENV_SYSTEM_PID = "PID";
    public static final String ENV_SYSTEM_STDIN = "in";
    public static final String ENV_SYSTEM_STDOUT = "out";
    public static final String ENV_SYSTEM_STDERR = "err";
    public static final String ENV_SYSTEM_ENVS = "envs";
    public static final String ENV_SYSTEM_THIS_PROCESS = "process";
    public static final String ENV_SYSTEM_LOCAL_SITE = "SITE";
    public static final String ENV_PATH = "PATH";
    public static final String ENV_EXEC_PACKAGES = "EXEC_PKG";
    public static final String ENV_EXEC_EXTENSIONS = "EXEC_EXT";

    public static final String ENV_OS_COPYRIGHTS = "OS_COPYRIGHTS";
    public static final String ENV_OS_ID = "OS_ID";
    public static final String ENV_OS_NAME = "OS_VERSION";
    public static final String ENV_OS_VERSION = "OS_VERSION";
    public static final String ENV_OS_LOCAL_SITE = "OS_LOCAL_SITE";

    public static final String LOGIN_PROGRAM_DEFAULT_LOGIN = "root";

    public static final String LOGIN_PROGRAM_DEFAULT_PWD = "root";
    public static final String DEFAULT_FACTORY_NAME = "org.doovos.kernel.core.util.KFactoryImpl";

    public static final int PROPERTY_THREAD_REQUEST_STATUS = 6;
    public static final String PROPERTY_NAME_THREAD_REQUEST_STATUS = "THREAD_REQUEST_STATUS";

    public static final int PROPERTY_ID_PRE_FREE = 3;
    public static final int PROPERTY_ID_FREE = 4;


    /**
     * sent from process to al threads when some child process dead
     */
    public static final int PROPERTY_ID_PROCESS_CHILD_DEATH_TO_THREADS = 106;

    /**
     * set from process to its parent whe it dies
     */
    public static final int PROPERTY_ID_PROCESS_CHILD_DEATH = 101;

    /**
     * sent from process to its parent when created
     */
    public static final int PROPERTY_ID_PROCESS_CHILD_BIRTH = 102;

    /**
     * sent from process to its children when ending
     */
    public static final int PROPERTY_ID_PROCESS_PARENT_DEATH = 103;

    public static final int PROPERTY_ID_THREAD_BIRTH = 104;
    public static final int PROPERTY_ID_THREAD_DEATH = 105;

    public static final String PROPERTY_NAME_PROCESS_CHILD_DEATH = "PROCESS_CHILD_DEATH";
    public static final String PROPERTY_NAME_PROCESS_CHILD_BIRTH = "PROCESS_CHILD_BIRTH";
    public static final String PROPERTY_NAME_PROCESS_THREAD_BIRTH = "PROCESS_THREAD_BIRTH";
    public static final String PROPERTY_NAME_PROCESS_THREAD_DEATH = "PROCESS_THREAD_DEATH";
    public static final String PROPERTY_NAME_PROCESS_PARENT_DEATH = "PROCESS_PARENT_DEATH";
    public static final String PROPERTY_NAME_PROCESS_CHILD_DEATH_TO_THREADS = "PROPERTY_NAME_PROCESS_CHILD_DEATH_TO_THREADS";
    public static final String PROPERTY_NAME_PRE_FREE = "pre-free";
    public static final String PROPERTY_NAME_FREE = "free";
    public static final String DEBUG_PREFIX = "********";
    public static final String MIME_DASSEMBLER = "application/x-doovos-asm";
    public static final String MIME_DSHELL = "text/doovos-sh";
    public static final String MIME_DEXEC_FORMAT = "application/doovos-exec-format";
    public static final String MIME_JAVA = "application/java";
    public static final String MIME_UNKNOWN = "application/x-unknown-mime-type";
}
