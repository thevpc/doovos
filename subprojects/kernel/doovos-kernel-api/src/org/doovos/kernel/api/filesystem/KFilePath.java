/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.api.filesystem;

import java.util.ArrayList;

/**
 *
 * @author vpc
 */
public class KFilePath {

    private String path;
    private String[] pathArray;

    private KFilePath(String path, String[] pathArray) {
        this.path = path;
        this.pathArray = pathArray;
    }

    public KFilePath(String path) {
        this.path = path;
        ArrayList<String> all = new ArrayList<String>();
        char[] cc = path.toCharArray();
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
        pathArray = all.toArray(new String[all.size()]);
    }

    public String getPath() {
        return path;
    }

    public String[] getPathArray() {
        return pathArray;
    }

    public String getName() {
        return pathArray.length == 0 ? "" : pathArray[pathArray.length - 1];
    }

    public KFilePath getParent() {
        if (pathArray.length <= 1) {
            return null;
        }
        StringBuffer r = new StringBuffer("");
        boolean end = false;
        switch (pathArray.length) {
            case 0: {
                end = true;
                break;
            }
            case 1: {
                end = true;
                r.append("/");
                break;
            }
        }
        if (!end) {
            for (int i = 0; i < pathArray.length - 1; i++) {
                r.append('/');
                r.append(pathArray[i]);

            }
        }
        String[] pp=new String[pathArray.length-1];
        System.arraycopy(pathArray, 0, pp, 0, pp.length);
        return new KFilePath(r.toString(), pathArray);
    }

    public String getParentPath() {
        StringBuffer r = new StringBuffer("");
        switch (pathArray.length) {
            case 0: {
                return "";
            }
            case 1: {
                return "/";
            }
        }
        for (int i = 0; i < pathArray.length - 1; i++) {
            r.append('/');
            r.append(pathArray[i]);

        }
        return r.toString();
    }

    public String canonicalize() {
        String[] n = pathArray;
        ArrayList<String> nl = new ArrayList<String>();
        for (String s : n) {
            if (s.equals(".")) {
                //ignore;
            } else if (s.equals("..")) {
                if (nl.size() > 0) {
                    nl.remove(nl.size() - 1);
                } else {
                    throw new IllegalArgumentException("Invalid path " + path);
                }
            } else {
                nl.add(s);
            }
        }
        StringBuffer r = new StringBuffer("");
        switch (nl.size()) {
            case 0: {
                return "/";
            }
        }
        for (String aN : nl) {
            r.append('/');
            r.append(aN);
        }
        return r.toString();
    }

    public static String canonicalize(String parent, String relativeOrAbsolute) {
        if (relativeOrAbsolute.startsWith("/")) {
            return new KFilePath(relativeOrAbsolute).canonicalize();
        } else {
            return new KFilePath(parent + "/" + relativeOrAbsolute).canonicalize();
        }
    }
}
