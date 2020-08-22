package org.doovos.kernel.api.site;

import java.io.Serializable;
import java.util.Properties;

/**
 *
 * @author vpc
 */
public class KParentProcessContext implements Serializable{
    private int pid;
    private Properties envs;
    private String cwd;
    private String login;

    public KParentProcessContext(int pid, Properties envs, String cwd, String login) {
        this.pid = pid;
        this.envs = envs;
        this.cwd = cwd;
        this.login = login;
    }

    public String getCwd() {
        return cwd;
    }

    public Properties getEnvs() {
        return envs;
    }

    public String getLogin() {
        return login;
    }

    public int getPid() {
        return pid;
    }
    
}
