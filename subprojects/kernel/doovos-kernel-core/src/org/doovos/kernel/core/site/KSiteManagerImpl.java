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
package org.doovos.kernel.core.site;

import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.site.KSite;
import org.doovos.kernel.api.site.KSiteManager;

import java.io.IOException;
import java.net.*;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.*;
import org.doovos.kernel.api.site.KSiteEntry;
import org.doovos.kernel.api.site.KSiteRegistrationListener;
import org.doovos.kernel.core.site.protocol.IlallikaMessage;
import org.doovos.kernel.core.site.protocol.WaalaykomMessage;
import org.doovos.kernel.core.site.protocol.SiteProtocolMessage;
import org.doovos.kernel.core.site.protocol.SalamMessage;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 28-nov.-2005
 * Time: 22:07:20
 */
public class KSiteManagerImpl implements KSiteManager {

    public static String localUrl = null;
    private KSiteTable sites = new KSiteTable();
//    public String multicastAddress = "230.192.1.1";
    public String interfaceName = null;//"eth0";
    public String multicastAddress = "231.192.1.2";
    public static final int defaultMulticastPort = 7777;
    public int multicastPort = defaultMulticastPort;
    public int multicastPortIndex = 0;
    public int multicastPortMaxIndex = 2;
    public static int defaultRmiPort = 9001;
    public int rmiPort = defaultRmiPort;
    public boolean availableNetworks = true;
    private KSiteEntry localSiteEntry = null;
    private KSiteEntry[] cachedSitesTable = null;
    private List<KSiteRegistrationListener> listeners = new ArrayList<KSiteRegistrationListener>();
    private Map<String, SiteProtocolMessage> messages = new HashMap<String, SiteProtocolMessage>();

    public void stop() {
        //
    }

    public void start() throws RemoteException {
        multicastAddress = Doovos.getSystem().getBootConfig().getStringProperty("multicastAddress", multicastAddress, true);
        multicastPort = Doovos.getSystem().getBootConfig().getIntProperty("multicastPort", multicastPort, true);
        multicastPortMaxIndex = Doovos.getSystem().getBootConfig().getIntProperty("multicastPortMaxIndex", multicastPortMaxIndex, true);
        rmiPort = Doovos.getSystem().getBootConfig().getIntProperty("rmiPort", rmiPort, true);
        availableNetworks = checkAvailableNetworks();
        try {
            Doovos.getSystem().getLog().info("Start SiteManager multicast(" + multicastAddress + ":" + multicastPort + "), rmi(" + InetAddress.getLocalHost().getCanonicalHostName() + ":" + rmiPort + ")");
        } catch (UnknownHostException ex) {
            Doovos.getSystem().getLog().info("Start SiteManager multicast(" + multicastAddress + ":" + multicastPort + "), rmi(localhost:" + rmiPort + ")");
        }
        registerMessage(new WaalaykomMessage());
        registerMessage(new SalamMessage());
        registerMessage(new IlallikaMessage());
        new KTableListener().start();
        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                //sendMulticastString(SITE_PROT_HEART_BEAT);
            }
        }, 0, 4000);
        sendMulticastString(new SalamMessage());
    }

    private void registerMessage(SiteProtocolMessage m) {
        messages.put(m.getPrefix(), m);
    }

    public void registerSite(String url) throws NotBoundException, MalformedURLException, RemoteException {
//        String sid = url.substring(0, url.indexOf('@'));
        String rmiUrl = url.substring(url.indexOf('@') + 1);
        KSite site = (KSite) Naming.lookup(rmiUrl);
        registerSite(rmiUrl, site);
    }

    public KSiteEntry registerSite(String url, KSite site) throws RemoteException {
        String siteUUID = site.getUUID();
        KSiteEntry e = new SiteEntryImpl(siteUUID, url, site);
        if (sites.register(e)) {
//        cachedSites = null;
            cachedSitesTable = null;
            Doovos.getSystem().getLog().info("registering " + (url == null ? "<local site>" : url));
            for (KSiteRegistrationListener listener : listeners) {
                listener.siteRegistered(e);
            }
//        Doovos.log("Table{");
//        for (Map.Entry<String, DSiteEntryImpl> entry : systems.entrySet()) {
//            Doovos.log("\t" + entry.getKey() + " : " + entry.getValue().siteId + " @" + entry.getValue().url);
//        }
//        Doovos.log("}");
            return e;
        }
        return null;
    }

    public void unregisterSite(String uuid) throws RemoteException {
        KSiteEntry e = sites.unregister(uuid);
        if (e != null) {
            cachedSitesTable = null;
            for (KSiteRegistrationListener listener : listeners) {
                listener.siteUnregistered(e);
            }
        }
    }

    public KSiteEntry getSite(String name) {
        for (KSiteEntry e : sites) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        throw new RuntimeException("Unknown Site " + name);
    }

    public KSiteEntry getLocalSite() throws RemoteException {
        return localSiteEntry;
    }

    public KSiteEntry[] getSites() {
        if (cachedSitesTable == null) {
            cachedSitesTable = sites.toArray();
        }
        return cachedSitesTable;
    }

    public void invalidatePath(String path) throws RemoteException {
        for (KSiteEntry site : sites) {
            if (!site.isLocal()) {
                site.getSite().invalidatePath(path);
            }
        }
    }

    public void registerLocalSite() throws RemoteException {
        try {
            String name = Doovos.getSystem().getName();
            for (KSiteEntry e : sites) {
                if (e.getName().equals(name)) {
                    throw new IllegalArgumentException("Anather site is already registred with name " + name);
                }
            }
            for (int i = 0; i < 100; i++) {
                try {
                    java.rmi.registry.LocateRegistry.createRegistry(rmiPort);
                    break;
                } catch (RemoteException e) {
                    rmiPort++;
                    if (i == 100 - 1) {
                        throw new RuntimeException("Unable to create registry");
                    }
                }
            }
            localUrl = "rmi://" + InetAddress.getLocalHost().getCanonicalHostName() + ":" + rmiPort + "/" + Doovos.VERSION.getOsId() + "/" + name;
            Doovos.getSystem().getLog().info("creating local registry on port " + rmiPort + "... rmi url is " + localUrl);
            Naming.rebind(localUrl, Doovos.getSystem().getLocalSite().toRemote());
            try {
                localSiteEntry = registerSite(localUrl, Doovos.getSystem().getLocalSite());
                if (localSiteEntry == null) {
                    throw new IllegalArgumentException("Unable to register local site");
                }
                sendMulticastString(new SalamMessage());
            } catch (Exception ee) {
                Doovos.getSystem().getLog().info("Unable to register local site "+Doovos.getSystem().getLocalSite());
                Naming.unbind(localUrl);
                localUrl=null;
                throw ee;
            }
            //Thread.sleep(3 * 1000);
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to register local site",e);
        }
    }

    public static class SiteEntryImpl implements KSiteEntry {

        private String uuid;
        private String siteName;
        private String url;

        public SiteEntryImpl(String uuid, String url, KSite site) throws RemoteException {
            this.uuid = uuid;
            this.siteName = site.getName();
            this.url = url;
        }

        public boolean isAlive() {
            return getSite() != null;
        }

        public boolean isLocal() {
            return localUrl != null && url.endsWith(localUrl);
        }

        public KSite getSite() {
            try {
                return (localUrl != null && url.equals(localUrl)) ? Doovos.getSystem().getLocalSite() : (KSite) Naming.lookup(url);
            } catch (Exception e) {
                return null;
            }
        }

        public String getName() {
            return siteName;
        }

        public String getUUID() {
            return uuid;
        }

        public String getUrl() {
            return url;
        }
    }

    private void sendMulticastString(SiteProtocolMessage message) {
        String str = message.toMessage();
        if (!availableNetworks) {
            Doovos.getSystem().getLog().debug("SEND TO <localhost:" + defaultMulticastPort + ".." + (defaultMulticastPort + 9) + "> message \"" + str + "\"");
            byte[] data = (str).getBytes();
            for (int i = 0; i < multicastPortMaxIndex; i++) {
                try {
                    DatagramPacket dp = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), multicastPort + i);
                    MulticastSocket ms = new MulticastSocket();
                    if (interfaceName != null && interfaceName.length() > 0) {
                        ms.setNetworkInterface(NetworkInterface.getByName(interfaceName));
                    }
                    ms.send(dp);
                    ms.close();
                } catch (SocketException se) {
                    System.err.println(se);
                } catch (IOException ie) {
                    System.err.println(ie);
                }
            }
        } else {
            for (int i = 0; i < multicastPortMaxIndex; i++) {
                InetAddress ia = null;
                int port = 0;
                try {
                    ia = InetAddress.getByName(multicastAddress);
                    port = multicastPort + i;
                    //if (args.length > 2) ttl = (byte) Integer.parseInt(args[2]);
                } catch (Exception e) {
                    System.err.println(e);
                    System.exit(1);
                }

                byte[] data = (str).getBytes();
                DatagramPacket dp = new DatagramPacket(data, data.length, ia, port);

                try {
//                MulticastSocket ms = new MulticastSocket();
                    DatagramSocket ms = new DatagramSocket();
                    Doovos.getSystem().getLog().debug("SEND TO MULTICAST <" + ia + ":" + port + "> message \"" + str + "\"");
                    ms.send(dp);
                    ms.close();
                } catch (SocketException se) {
                    Doovos.getSystem().getLog().error("Unable to send to " + ia + ":" + port + " : " + se);
                } catch (IOException ie) {
                    Doovos.getSystem().getLog().error("Unable to send to " + ia + ":" + port + " : " + ie);
                }
            }
        }
    }

    public class KTableListener extends Thread {

        public KTableListener() {
            super("KTableListener");
        }

        @Override
        public void run() {
            // waiting fro reponse
            Doovos.getSystem().getLog().debug("Starting KTableListener...");
            if (!availableNetworks) {
                for (int i = 0; i < multicastPortMaxIndex; i++) {
                    DatagramSocket ms = null;
                    try {
                        multicastPortIndex = i;
                        ms = new DatagramSocket(multicastPort + multicastPortIndex);
                        Doovos.getSystem().getLog().debug("KTableListener started on " + multicastPort + multicastPortIndex);
                        byte[] buffer = new byte[1024];
                        //noinspection InfiniteLoopStatement
                        while (true) {
                            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                            ms.receive(dp);
                            String s = new String(dp.getData(), 0, dp.getLength());
                            onReceiveMessageSafe(s);
                        }
                    } catch (BindException e) {
                        if (i == 9) {
                            System.err.println(e);
                        }
                    } catch (IOException e) {
                        System.err.println(e);
                    } finally {
                        if (ms != null) {
                            ms.close();
                        }
                    }
                }
            } else {
                InetAddress group = null;
                int port;
                MulticastSocket ms = null;
                for (int i = 0; i < multicastPortMaxIndex; i++) {
                    try {
                        group = InetAddress.getByName(multicastAddress);
                        port = multicastPort + i;
                        ms = new MulticastSocket(port);
                        if (interfaceName != null && interfaceName.length() > 0) {
                            ms.setNetworkInterface(NetworkInterface.getByName(interfaceName));
                        }
                        ms.joinGroup(group);
                        Doovos.getSystem().getLog().debug("[MC] KTableListener started on " + group + ":" + (port));
                        byte[] buffer = new byte[1024];
                        //noinspection InfiniteLoopStatement
                        while (true) {
                            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                            ms.receive(dp);
                            String s = new String(dp.getData(), 0, dp.getLength());
                            onReceiveMessageSafe(s);
                        }
                    } catch (UnknownHostException e) {
                        Doovos.getSystem().getLog().error("[MC] Unable to start KTableListener on " + group + ":" + (multicastPort + i) + " : " + e);
                    } catch (IOException e) {
                        Doovos.getSystem().getLog().error("[MC] Unable to start KTableListener on " + group + ":" + (multicastPort + i) + " : " + e);
                    } finally {
                        if (ms != null) {
                            try {
                                ms.leaveGroup(group);
                                ms.close();
                            } catch (IOException e) {
                                //
                            }
                        }
                    }
                }
            }
        }

        private void onReceiveMessageSafe(String message) {
            try {
                onReceiveMessage(message);
            } catch (Throwable ex) {
                ex.printStackTrace();
            }
        }

        private void onReceiveMessage(String message) throws MalformedURLException, RemoteException {
            Doovos.getSystem().getLog().debug("<RECIEVE> " + message);
            boolean logged = false;
            int ii = message.indexOf(":");
            if (ii > 0) {
                String prefix = message.substring(0, ii);
                String info = message.substring(ii + 1);
                SiteProtocolMessage m = messages.get(prefix).parse(info);
                if (m.getSourceUUID().equals(Doovos.getSystem().getUUID())) {
                    Doovos.getSystem().getLog().debug("<RECIEVE> Ignored (from local) " + message);
                    //ignore local messages
                    return;
                }
                if (m instanceof SalamMessage) {
                    SalamMessage tt = (SalamMessage) m;
                    logged = true;
                    if (!tt.isAnonymous()) {
                        try {
                            KSite site = (KSite) Naming.lookup(tt.getSourceUrl());
                            registerSite(tt.getSourceUrl(), site);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (localUrl != null) {
                        sendMulticastString(new WaalaykomMessage());
                    }
                } else if (m instanceof WaalaykomMessage) {
                    WaalaykomMessage tt = (WaalaykomMessage) m;
                    Doovos.getSystem().getLog().debug("RECIEVE " + message);
                    logged = true;
                    try {
                        KSite site = (KSite) Naming.lookup(tt.getSourceUrl());
                        registerSite(tt.getSourceUrl(), site);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (m instanceof IlallikaMessage) {
                    IlallikaMessage tt = (IlallikaMessage) m;
                    Doovos.getSystem().getLog().debug("RECIEVE " + message);
                    logged = true;
                    try {
                        unregisterSite(tt.getSourceUUID());
                    } catch (Exception ex) {
                        Doovos.getSystem().getLog().error(ex);
                    }
                }
            } else {
                Doovos.getSystem().getLog().debug("<RECIEVE> Ignored invalid " + message);
            }
            if (!logged) {
//                Doovos.syslog("IGNORE RECIEVE " + message);
            }
        }
    }

    public boolean checkAvailableNetworks() {
        InetAddress group;
        int port;
        MulticastSocket ms;
        try {
            group = InetAddress.getByName(multicastAddress);
            port = multicastPort + multicastPortIndex;
            ms = new MulticastSocket(port);
            ms.joinGroup(group);
            ms.leaveGroup(group);
            return true;
        } catch (Exception e) {
            Doovos.getSystem().getLog().info("Deactivate Multicast support. (" + e.getMessage() + ")");
            return false;
        }
//        return false;
    }

    public void addSiteRegistrationListener(KSiteRegistrationListener listener) throws RemoteException {
        listeners.add(listener);
    }

    public void removeSiteRegistrationListener(KSiteRegistrationListener listener) throws RemoteException {
        listeners.remove(listener);
    }
}
