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
package org.doovos.boot;

import org.doovos.kernel.api.boot.BootConfig;
import org.doovos.kernel.api.Doovos;

import java.io.File;
import java.io.Serializable;
import java.util.Map;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 15 dec. 2005
 * Time: 16:28:28
 */
public class Boot {

    /**
     * when starting Doovos will look after the following file to load.
     * This file could/should contain
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;
     * &lt;!DOCTYPE properties SYSTEM "http://java.sun.com/dtd/properties.dtd"&gt;
     * &lt;properties&gt;
     * &lt;comment&gt;&lt;/comment&gt;
     * &lt;entry key="multicastPort"&gt;7777&lt;/entry&gt;
     * &lt;entry key="multicastAddress"&gt;230.192.1.1&lt;/entry&gt;
     * &lt;entry key="rmiPort"&gt;9001&lt;/entry&gt;
     * &lt;entry key="DScreenDeviceTabbedFrameImpl.exclusiveMode"&gt;false&lt;/entry&gt;
     * &lt;entry key="localSiteName"&gt;site2&lt;/entry&gt;
     * &lt;entry key="InitProgram.ExtraLoginTermCount"&gt;1&lt;/entry&gt;
     * &lt;entry key="org.doovos.kernel.DoovosFactory"&gt;org.doovos.kernelimpl.KFactoryImpl&lt;/entry&gt;
     * &lt;/properties&gt;
     * </pre>
     */
//    public static final String OS_BOOT_RC_PROPS_FILE = "./.bootrc";
//    public static final String OS_VERSION = "0.1.20090431.s.1";

    public static void main(String[] args) {
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
        try {
//            Doovos.addSystemListener(Doovos.Event.SHUTTING_DOWN, new PropertyChangeListener() {
//
//                public void propertyChange(PropertyChangeEvent evt) {
//                    store();
//                }
//            });
//            for (Map.Entry e : System.getProperties().entrySet()) {
//                System.out.println(e.getKey() + " = " + e.getValue());
//            }
            BootConfig bc = new BootConfig();
            bc.init(args);
            Doovos.getSystem().start(bc);
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(30);
        }
    }
//    private static void store() {
//        try {
//            TypedProperties bootProperties = new TypedProperties();
//            File p = new File(OS_BOOT_PROPS_FILE);
//            FileOutputStream fos = new FileOutputStream(p);
//            bootProperties.store(fos, "");
//            fos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    private static TypedProperties load() {
//        TypedProperties bootProperties = new TypedProperties();
//        File p = new File(OS_BOOT_PROPS_FILE);
//        try {
//            System.out.println("loading boot file " + p.getCanonicalPath());
//            if (p.exists()) {
//                FileInputStream fis = new FileInputStream(p);
//                bootProperties.load(fis);
//                fis.close();
//            }
//        } catch (IOException e) {
//            try {
//                System.err.println("Unable to load boot file. Local Naive path is " + p.getCanonicalPath());
//            } catch (IOException e1) {
//                System.err.println("Unable to load boot file. Local Naive path is " + p.getAbsolutePath());
//                //
//            }
//            e.printStackTrace();
//        }
//
//        return bootProperties;
//    }
}
