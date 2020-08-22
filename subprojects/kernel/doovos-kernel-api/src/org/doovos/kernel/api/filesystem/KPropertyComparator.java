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
//package org.doovos.kernel.api.filesystem;
//
//import org.doovos.kernel.api.Doovos;
//
//import java.rmi.RemoteException;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.StringTokenizer;
//
///**
// * @author vpc (taha.bensalah@gmail.com)
// * @lastmodified 14 nov. 2004
// * Time: 16:02:46
// */
//public class KPropertyComparator implements Comparator<KResource> {
//    private Order[] orders;
//
//    public KPropertyComparator(String order) {
//        ArrayList<Order> o = new ArrayList<Order>();
//        StringBuffer colfilter = new StringBuffer();
//        for (StringTokenizer st = new StringTokenizer(order, ",|"); st.hasMoreTokens();) {
//            String s = st.nextToken();
//            if (s.endsWith("+")) {
//                o.add(new Order(s.substring(0, s.length() - 1), true));
//                if (colfilter.length() == 0) {
//                    colfilter.append("|");
//                }
//
//                colfilter.append(s.substring(0, s.length() - 1));
//            } else if (s.endsWith("-")) {
//                o.add(new Order(s.substring(0, s.length() - 1), false));
//                if (colfilter.length() == 0) {
//                    colfilter.append("|");
//                }
//
//                colfilter.append(s.substring(0, s.length() - 1));
//            } else {
//                o.add(new Order(s, true));
//                if (colfilter.length() == 0) {
//                    colfilter.append("|");
//                }
//
//                colfilter.append(s);
//            }
//        }
//        orders = (Order[]) o.toArray(new Order[o.size()]);
////        DPropertyFilter f=new DPropertyFilter(colfilter.toString());
////        values = new Object[resources.length][orders.length];
////        for (int i = 0; i < resources.length; i++) {
////            DResource resource = resources[i];
////            Map<String,Object> prps = resource.getProperties(f);
////            for (int j = 0; j < orders.length; j++) {
////                values[i][j]=prps.get(orders[j].propertyName);
////            }
////        }
//
//    }
//
//    public int privateCompare(Object a, Object b) {
//        if (a instanceof Comparable && b instanceof Comparable) {
//            return ((Comparable) a).compareTo(b);
//        } else {
//            return String.valueOf(a).compareTo(String.valueOf(b));
//        }
//    }
//
//    public int compare(KResource r1, KResource r2) {
//        for (int i = 0; i < orders.length; i++) {
//            Order order = orders[i];
//            try {
//                i = privateCompare(r1.getProperty(order.propertyName), r2.getProperty(order.propertyName));
//            } catch (RemoteException e) {
//                Doovos.getSystem().getLog().error(e);
//            }
//            if (i == 0) {
//                continue;
//            }
//            return order.isAscending ? i : -i;
//        }
//        return 0;
//    }
//
//    public static class Order {
//        public Order(String propertyName, boolean ascending) {
//            this.propertyName = propertyName;
//            isAscending = ascending;
//        }
//
//        String propertyName;
//        boolean isAscending;
//    }
//}
