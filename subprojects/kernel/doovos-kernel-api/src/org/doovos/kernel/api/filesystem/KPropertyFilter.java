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

import java.io.Serializable;
import java.util.*;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 14 nov. 2004
 * Time: 09:36:58
 */
public class KPropertyFilter implements Serializable {
    private String regexPattern;
    private transient String[] regexPatternOrder;

    public KPropertyFilter(String filter) {
        regexPattern = filter;
    }

    public boolean matchesProperty(String propertyName) {
        return propertyName.matches(regexPattern);
    }

    public void reorderProperies(List<String> properties) {
        final Map<String, Integer> h = new HashMap<String, Integer>();
        Collections.sort(properties, new Comparator<String>() {
            public int compare(String s, String s1) {
                if (!h.containsKey(s)) {
                    h.put(s, getMatchingIndex(s));
                }
                if (!h.containsKey(s1)) {
                    h.put(s1, getMatchingIndex(s1));
                }
                int i = h.get(s);
                int i1 = h.get(s1);
                if (i * i1 >= 0) {
                    return i - i1;
                } else if (i < 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
    }

    public int getMatchingIndex(String propertyName) {
        if (!propertyName.matches(regexPattern)) {
            return -1;
        }
        if (regexPatternOrder == null) {
            ArrayList<String> list = new ArrayList<String>();
            for (StringTokenizer st = new StringTokenizer(regexPattern, "|"); st.hasMoreTokens();) {
                String s = st.nextToken();
                list.add(s);
            }
            regexPatternOrder = (String[]) list.toArray(new String[list.size()]);
        }
        for (int i = 0; i < regexPatternOrder.length; i++) {
            String s = regexPatternOrder[i];
            if (propertyName.matches(s)) {
                return i;
            }
        }
        return -1;
    }
}
