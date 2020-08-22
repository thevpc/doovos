package org.doovos.kernel.api;

public interface KSysLog {
    void shutdown();

    void error(Throwable e);

    void error(String message,Throwable e);

    void error(String msg);

    void info(String msg);

    void debug(String msg);
}
