/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author vpc
 */
public class JJITVarHelper {

    private int runVarIndex = 1;
    private HashSet<String> runVarNamesByName = new HashSet<String>();
    private HashMap<Object,String> varsByObject = new HashMap<Object,String>();
    private String globalPrefix;

    public JJITVarHelper(String globalPrefix) {
        this.globalPrefix = globalPrefix;
    }

    public String getVarById(Object ... obj) {
        JJRunVarKey k = obj.length==0?null: new JJRunVarKey(globalPrefix, obj);
        if(k!=null){
            String n = varsByObject.get(k);
            if(n!=null){
                return n;
            }
        }
        return null;
    }

    public boolean exists(Object ... obj) {
        JJRunVarKey k = obj.length==0?null: new JJRunVarKey(globalPrefix, obj);
        if(k!=null){
            String n = varsByObject.get(k);
            if(n!=null){
                return true;
            }
        }
        return false;
    }

    public String createVar(String prefix, Object ... obj) {
        JJRunVarKey k = obj.length==0?null: new JJRunVarKey(globalPrefix, obj);
        if(k!=null){
            String n = varsByObject.get(k);
            if(n!=null){
                return n;
            }
        }
        if (prefix == null) {
            prefix = "";
        }
        StringBuilder name0 = new StringBuilder(validateVar(globalPrefix));
        name0.append(validateVar(prefix));

        String name = null;
        while (true) {
            name = name0.toString() ;
            if(runVarIndex>1){
                name+=runVarIndex;
            }
            if (!runVarNamesByName.contains(name)) {
                runVarNamesByName.add(name);
                if(k!=null){
                    varsByObject.put(k, name);
                }
                return name;
            } else {
                runVarIndex++;
            }
        }
    }

    private String validateVar(String n) {
        StringBuilder s = new StringBuilder();
        char[] n0 = n.toCharArray();
        char c = n0[0];
        boolean isaz = (c >= 'a' && c < 'z') || (c >= 'A' && c < 'Z');
        boolean is_ = (c == '_');
        if (!(isaz || is_)) {
            s.append('_');
        } else {
            s.append(c);
        }

        for (int i = 1; i < n0.length; i++) {
            c = n0[i];
            isaz = (c >= 'a' && c < 'z') || (c >= 'A' && c < 'Z');
            boolean is09 = (c >= '0' && c < '9');
            is_ = (c == '_');
            if (!(isaz || is09 || is_)) {
                s.append('_');
            } else {
                s.append(c);
            }
        }
        return s.toString();
    }

    private boolean isValidVar(String n) {
        char[] n0 = n.toCharArray();
        if (n0.length > 6 || n0.length == 0) {
            return false;
        }
        char c = n0[0];
        boolean isaz = (c >= 'a' && c < 'z') || (c >= 'A' && c < 'Z');
        boolean is_ = (c == '_');
        if (!(isaz || is_)) {
            return false;
        }

        for (int i = 1; i < n0.length; i++) {
            c = n0[i];
            isaz = (c >= 'a' && c < 'z') || (c >= 'A' && c < 'Z');
            boolean is09 = (c >= '0' && c < '9');
            is_ = (c == '_');
            if (!(isaz || is09 || is_)) {
                return false;
            }
        }
        return true;
    }

    private static class JJRunVarKey {

        private Object[] values;
        private String globalPrefix;

        public JJRunVarKey(String globalPrefix, Object[] values) {
            this.values = values;
            this.globalPrefix = globalPrefix;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final JJRunVarKey other = (JJRunVarKey) obj;
            if (!Arrays.deepEquals(this.values, other.values)) {
                return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 83 * hash + Arrays.deepHashCode(this.values);
            return hash;
        }

        @Override
        public String toString() {
            StringBuilder s = new StringBuilder(globalPrefix);
            if (values.length > 0) {
                s.append(String.valueOf(values[0]));
                for (int i = 0; i < values.length; i++) {
                    s.append(";");
                    s.append(s.toString());
                }
            }
            return s.toString();
        }
    }
}
