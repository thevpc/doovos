package org.doovos.kernel.core.util;

import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.KSysLog;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KSysLogImpl implements KSysLog {

    private static SimpleDateFormat logDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    private static PrintStream syslogStream;
    private String localSite;

    public KSysLogImpl(String name) {
        try {
            this.localSite = name;
            File folder = new File(Doovos.getSystem().getBootConfig().getBootFolder(),"sys/log/");
            folder.mkdirs();
            File file = File.createTempFile(name, ".log", folder);
            //File file = new File("./sys/log/" + name + ".log");
            //file.getParentFile().mkdirs();
            System.out.println("syslog to " + file.getCanonicalPath());
            syslogStream = new PrintStream(file);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void shutdown() {
        syslogStream.close();
    }

    public void error(Throwable e) {
        syslogStream.print("<<<syslog>>> [ERROR][" + logDateFormat.format(new Date()) + " @ " + (localSite) + "] ");
        e.printStackTrace(syslogStream);
    }

    public void error(String message, Throwable e) {
        syslogStream.print("<<<syslog>>> [ERROR][" + logDateFormat.format(new Date()) + " @ " + (localSite) + "] " + message);
        e.printStackTrace(syslogStream);
    }

    public void error(String msg) {
        syslogStream.println("<<<syslog>>> [ERROR][" + logDateFormat.format(new Date()) + " @ " + localSite + "] " + msg);
    }

    public void info(String msg) {
        syslogStream.println("<<<syslog>>> [INFO ][" + logDateFormat.format(new Date()) + " @ " + localSite + "] " + msg);
    }

    public void debug(String msg) {
        syslogStream.println("<<<syslog>>> [DEBUG][" + logDateFormat.format(new Date()) + " @ " + localSite + "] " + msg);
    }
}
