/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.core.site;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.filesystem.*;
import org.doovos.kernel.api.util.EmptyArray;
import org.doovos.kernel.core.util.FileCache;
import org.doovos.kernel.core.util.KUtils;

/**
 *
 * @author vpc
 */
public class KWhichLocatorImpl implements KWhichLocator {
//    private static final String[] EMPTY_ARRAY_STRING = new String[0];

    class CachedZipFile {

        FileCache cache;
        ZipFile zip;

        private CachedZipFile(KFile cache) throws IOException {
            this.cache = new FileCache(cache);
            this.zip = new ZipFile(this.cache.getLocalFile());
        }

        public ZipFile getZip() throws IOException {
            if (zip == null) {
                zip = new ZipFile(cache.getLocalFile());
//                } else if (cache.load()) {
//                    zip.close();
//                    zip = new ZipFile(cache.getLocalFile());
            }
            return zip;
        }

        private void close() {
            try {
                cache.close();
            } catch (Exception e) {
                //
            }
            if (zip != null) {
                try {
                    zip.close();
                } catch (IOException e) {
                    //
                }
            }
        }
    }

    public String[] which(String path, String workingdir, String pathEnv, String execExtensionEnv, String packageEnv, boolean rerieveOnlyFirst) throws RemoteException {

        Map<String, CachedZipFile> cachedZipFiles = null;

        ArrayList<String> all = new ArrayList<String>();
        if (path.indexOf('/') >= 0) {
            try {
                all.add(Doovos.getSystem().getFileSystemManager().getResource(path).getPath()/*.getCanonicalPath()*/);
            } catch (Exception e) {
                //
            }
        }
        ALL_TEST:
        {
            if (!rerieveOnlyFirst || all.isEmpty()) {
                ArrayList<String> pathItems0 = pathEnv == null ? new ArrayList<String>() : new ArrayList<String>(Arrays.asList(pathEnv.split(":")));
                ArrayList<String> pathItems = new ArrayList<String>();
                pathItems.add("");
                for (String pathItem : pathItems0) {
                    pathItems.addAll(Arrays.asList(KUtils.findPaths(workingdir, pathItem)));
                }
                ArrayList<String> allExtensions = execExtensionEnv == null ? new ArrayList<String>() : new ArrayList<String>(Arrays.asList(execExtensionEnv.split(":")));
                allExtensions.add("");

                //look for files !
                for (String pathItem : pathItems) {
                    for (String ex : allExtensions) {
                        String ss = pathItem ;
                        if(ss.length()>0 && !ss.endsWith("/")){
                            ss+=("/");
                        }
                        ss+=(path + ex);
                        if (ss.startsWith("/")) {
                            try {
                                Doovos.getSystem().getFileSystemManager().getResource(ss);
                                all.add(ss);
                                if (rerieveOnlyFirst) {
                                    break ALL_TEST;
                                }
                            } catch (Exception e) {
                                //
                            }
                        } else {
                            try {
                                String sss = KFilePath.canonicalize(workingdir, ss);
                                Doovos.getSystem().getFileSystemManager().getResource(sss);
                                all.add(sss);
                                if (rerieveOnlyFirst) {
                                    break ALL_TEST;
                                }
                            } catch (Exception e) {
                                //
                            }
                            //look for classes
                            //simply look for /?/?/className.class
                            ss = (pathItem + path.replace('.', '/') + ex);
                            if (ss.startsWith("/")) {
                                try {
                                    Doovos.getSystem().getFileSystemManager().getResource(ss);
                                    all.add(ss);
                                    if (rerieveOnlyFirst) {
                                        break ALL_TEST;
                                    }
                                } catch (Exception e) {
                                    //
                                }
                            } else {
                                String sss = KFilePath.canonicalize(workingdir, ss);
                                try {
                                    Doovos.getSystem().getFileSystemManager().getResource(sss);
                                    all.add(sss);
                                    if (rerieveOnlyFirst) {
                                        break ALL_TEST;
                                    }
                                } catch (Exception e) {
                                    //
                                }
                            }
                        }
                    }
                }
                //now try classes
                String[] allPkgs0 = packageEnv == null ? EmptyArray.STRINGS : packageEnv.split(":");
                String[] allPkgs = new String[allPkgs0.length + 1];
                allPkgs[0] = "";
                System.arraycopy(allPkgs0, 0, allPkgs, 1, allPkgs0.length);
                for (String pkg : allPkgs) {
                    if (pkg.length() > 0) {
                        pkg = pkg + ".";
                    }
                    String clazzName;
                    if (pkg.length() > 0 && !pkg.endsWith(".")) {
                        clazzName = pkg + "." + path;
                    } else {
                        clazzName = pkg + path;
                    }
                    String namePath = clazzName.replace('.', '/');


                    String ok = null;
                    for (String s : pathItems) {
                        KResource r = Doovos.getSystem().getFileSystemManager().find(s);
                        if (r != null) {
                            if (r instanceof KFile) {
                                if (cachedZipFiles == null) {
                                    cachedZipFiles = new HashMap<String, CachedZipFile>();
                                }
                                CachedZipFile zipFile = cachedZipFiles.get(s);
                                ZipEntry zipEntry = null;
                                try {
                                    if (zipFile == null) {
                                        cachedZipFiles.put(s, zipFile = new CachedZipFile((KFile) r));
                                    }
                                    zipEntry = zipFile.getZip().getEntry(namePath + ".class");
                                } catch (IOException e) {
                                    //do nothing
                                    //ignore error
                                }
                                if (zipEntry != null) {
                                    all.add(clazzName);
                                    if (rerieveOnlyFirst) {
                                        break ALL_TEST;
                                    }
                                }
                            } else if (r instanceof KFolder) {
                                if (!s.endsWith("/")) {
                                    s = s + "/";
                                }
                                r = Doovos.getSystem().getFileSystemManager().find((s + namePath + ".class"));
                                if (r != null && r instanceof KFile) {
                                    all.add(clazzName);
                                    if (rerieveOnlyFirst) {
                                        break ALL_TEST;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (cachedZipFiles != null) {
            for (Map.Entry<String, CachedZipFile> e : cachedZipFiles.entrySet()) {
                try {
                    e.getValue().zip.close();
                } catch (IOException e1) {
                    //
                }
            }
        }
        return all.toArray(new String[all.size()]);
    }
}
