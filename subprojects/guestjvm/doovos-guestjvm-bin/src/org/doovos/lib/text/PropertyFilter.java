/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.lib.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author vpc
 */
public class PropertyFilter implements Serializable {

    private String regexPattern;
    private transient String[] regexPatternOrder;

    public PropertyFilter(String filter) {
        regexPattern = filter;
    }

    public boolean matchesProperty(String propertyName) {
        return propertyName.matches(regexPattern);
    }

    public List<String> filter(List<String> properties) {
        List<String> a = new ArrayList<String>();
        for (String p : properties) {
            int x = getMatchingIndex(p);
            if (x >= 0) {
                a.add(p);
            }
        }
        reorderProperies(a);
        return a;
    }

    public void reorderProperies(List<String> properties) {
        final HashMap<String, Integer> h = new HashMap<String, Integer>();
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
            regexPatternOrder = list.toArray(new String[list.size()]);
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
