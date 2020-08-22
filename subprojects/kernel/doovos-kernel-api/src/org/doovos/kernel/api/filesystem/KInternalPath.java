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
package org.doovos.kernel.api.filesystem;

import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.site.KSite;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 25 oct. 2004
 * Time: 21:29:36
 */
public class KInternalPath implements Serializable {
    public String siteId;
    public String localPath;
    public String publicPath;

    public KInternalPath(String publicPath) throws RemoteException {
        this(
                !Doovos.getSystem().isLocalSite() ? "?" :
                        Doovos.getSystem().getName(), publicPath, publicPath, false);
    }

    public KInternalPath(String systemId, String localPath, String publicPath, boolean isCanonical) {
        this.siteId = systemId;
        this.publicPath = publicPath;
        this.localPath = localPath;
        if (this.localPath == null || localPath.length() == 0) {
            this.localPath = "/";
        } else if (!isCanonical) {
            StringBuilder b = new StringBuilder();
            String[] all = toStringArray();
            ArrayList<String> a = new ArrayList<String>(all.length);
            for (int i = 0; i < all.length; i++) {
                String s = all[i];
                if (s.equals(".")) {
                    // do nothing
                } else if (s.equals("..")) {
                    if (a.size() > 1) {
                        a.remove(a.size() - 1);
                    }
                } else {
                    a.add(s);
                }
            }
            all = a.toArray(new String[a.size()]);
            for (int i = 0; i < all.length; i++) {
                b.append("/").append(all[i]);
            }
            if (b.length() == 0) {
                b.append("/");
            }
            this.localPath = b.toString();
        }
    }

    public String getSiteId() {
        return siteId;
    }

    public KSite getSite() {
        return Doovos.getSystem().getSiteManager().getSite(siteId).getSite();
    }

    @Override
    public String toString() {
        return localPath;
    }

    public String getLocalPath() {
        return localPath;
    }

    public String getPublicPath() {
        return publicPath;
    }


    public String getName() {
        String[] all = toStringArray();
        return all.length == 0 ? "/" : all[all.length - 1];
    }

    public KInternalPath getParent() {
        if (localPath.equals("/")) {
            return this;
        }
        StringBuilder b = new StringBuilder();
        String[] all = toStringArray();
        for (int i = 0; i < all.length - 1; i++) {
            b.append("/").append(all[i]);

        }
        return new KInternalPath(siteId, b.toString(), getGuestParentPath(publicPath), false);
    }

    public static String[] getGuestPathArray(String guestPath) {
        ArrayList<String> all = new ArrayList<String>();
        char[] cc = guestPath.toCharArray();
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < cc.length; i++) {
            char c = cc[i];
            switch (c) {
                case '/': {
                    if (name.length() > 0) {
                        all.add(name.toString());
                        name.delete(0, name.length());
                    }
                    break;
                }
                case '\\': {
                    if (i + 1 < cc.length) {
                        name.append(cc[i + 1]);
                        i++;
                    } else {
                        name.append(cc[i]);
                    }
                    break;
                }
                default: {
                    name.append(cc[i]);
                }
            }
        }
        if (name.length() > 0) {
            all.add(name.toString());
        }
        return all.toArray(new String[all.size()]);
    }

    public static String getGuestFileName(String guestPath) {
        String[] n = getGuestPathArray(guestPath);
        return n.length == 0 ? "" : n[n.length - 1];
    }

    public static String getGuestParentPath(String guestPath) {
        String[] n = getGuestPathArray(guestPath);
        StringBuffer r = new StringBuffer("");
        switch (n.length) {
            case 0: {
                return "";
            }
            case 1: {
                return "/";
            }
        }
        for (int i = 0; i < n.length - 1; i++) {
            r.append('/');
            r.append(n[i]);

        }
        return r.toString();
    }


//    public DPath getCanonicalPath() {
//        StringBuilder b = new StringBuilder();
//        String[] all = toStringArray();
//        ArrayList<String> a = new ArrayList<String>(all.length);
//        for (int i = 0; i < all.length; i++) {
//            String s = all[i];
//            if (s.equals(".")) {
//                // do nothing
//            } else if (s.equals("..")) {
//                if (a.size() > 1) {
//                    a.remove(a.size() - 1);
//                }
//            } else {
//                a.add(s);
//            }
//        }
//        all = a.toArray(new String[a.size()]);
//        for (int i = 0; i < all.length; i++) {
//            b.append("/").append(all[i]);
//        }
//        return new DPath(b.toString());
//    }

    public String[] toStringArray() {
        ArrayList<String> a = new ArrayList<String>();
        String[] s = localPath.split("/");
        for (int i = 0; i < s.length; i++) {
            String s1 = s[i];
            if (s1.length() > 0) {
                a.add(s1);
            }
        }
        return a.toArray(new String[a.size()]);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KInternalPath)) return false;

        final KInternalPath dInternalPath = (KInternalPath) o;

        if (!localPath.equals(dInternalPath.localPath)) {
            return false;
        }
        if (publicPath != null ? !publicPath.equals(dInternalPath.publicPath) : dInternalPath.publicPath != null)
            return false;
        if (!siteId.equals(dInternalPath.siteId)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int result;
        result = siteId.hashCode();
        result = 29 * result + localPath.hashCode();
        result = 29 * result + (publicPath != null ? publicPath.hashCode() : 0);
        return result;
    }
}

/**
 public String siteId;
 public String localPath;
 public DPath publicPath;

 public KInternalPath(String siteId, String localPath,DPath publicPath) {
 this.siteId = siteId;
 this.localPath = localPath;
 this.publicPath = publicPath;
 }

 public String getSiteId() {
 return siteId;
 }

 public Site getSite() {
 return Doovos.getSite(siteId);
 }

 public String getLocalPath() {
 return localPath;
 }

 public DPath getPublicPath() {
 return publicPath;
 }
 */