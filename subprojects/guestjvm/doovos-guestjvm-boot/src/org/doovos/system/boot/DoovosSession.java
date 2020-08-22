/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.system.boot;

import java.io.File;
import org.doovos.api.DProcess;
import org.doovos.api.DSystem;
import org.doovos.api.DThread;

/**
 *
 * @author vpc
 */
public class DoovosSession {

    static {
        DProcess info = DProcess.getProcess();
        String title = info.getMetadata("title");
        if (title == null) {
            info.setMetadata("title", "DoovosSession");
            info.setMetadata("version", "0.1.4");
            info.setMetadata("author", "Taha BEN SALAH");
            //info.setMetadata("date", "2009-04-12");
            info.setMetadata("date", "2010-12-06");
        }
    }

    public static void main(String[] args) {
        final DProcess p = DProcess.getProcess();
        String user = p.getUser();
        p.setEnv("USER",user);
        String userHome = p.getEnv("HOME");
        String userHomeRoot = p.getEnv("HOME_ROOT");
        if (userHome == null) {
            if (userHomeRoot == null) {
                userHomeRoot="/data/home/";
            }
            if(!userHomeRoot.endsWith("/")){
                userHomeRoot=userHomeRoot+"/";
            }
            userHome = userHomeRoot + user;
            p.setEnv("HOME", userHome);
        }
        DSystem.shell(new String[]{
            "--startup-script",
            userHome + "/bin/events/on-logon.sh",
            "--shutdown-script",
            userHome + "/bin/events/on-logout.sh"
        }, null, null, null, userHome);
        DThread.getThread().waitChild();
    }

//    public static void inlineInProcess(String path) {
//        File file = new File(path);
//        if (file.exists()) {
//            try {
//                DSystem.inline(path);
//            } catch (Exception e) {
//                System.err.println(e.toString());
//                e.printStackTrace();
//            }
//        }
//    }
}
