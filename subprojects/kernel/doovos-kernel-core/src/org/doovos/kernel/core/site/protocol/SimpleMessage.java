/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.core.site.protocol;

import java.rmi.RemoteException;
import org.doovos.kernel.api.Doovos;

/**
 *
 * @author vpc
 */
public class SimpleMessage extends SiteProtocolMessage {
    private static final String ANONYMOUS = "anonymous";

    private String prefix;
    private String sourceName;
    private String url;
    private String uuid;

    public SimpleMessage(String prefix) {
        this.prefix = prefix;
        if (Doovos.getSystem().isLocalSite()) {
            this.sourceName = Doovos.getSystem().getName();
            try {
                this.url = Doovos.getSystem().getSiteManager().getLocalSite().getUrl();
            } catch (RemoteException ex) {
                throw new IllegalArgumentException(ex);
            }
        } else {
            this.sourceName = ANONYMOUS;
            this.url = ANONYMOUS;
        }
        this.uuid = Doovos.getSystem().getUUID();
    }

    public String getSourceUUID() {
        return uuid;
    }

    public boolean isAnonymous() {
        return ANONYMOUS.equals(url);
    }

    public String getInfo() {
        return uuid+"@"+ sourceName + "@" + url;
    }

    public String getPrefix() {
        return prefix;
    }

    @Override
    public SiteProtocolMessage parse(String info) {
        int a1 = info.indexOf('@');
        if (a1 < 0) {
            return null;
        }
        int a2 = info.indexOf('@', a1 + 1);
        if (a2 < 0) {
            return null;
        }
        String _uuid = info.substring(0, a1);
        String _name = info.substring(a1 + 1, a2);
        String _url = info.substring(a2 + 1);
        SimpleMessage r;
        try {
            r = (SimpleMessage) this.clone();
        } catch (CloneNotSupportedException ex) {
            throw new RuntimeException(ex);
        }
        r.url = _url;
        r.sourceName = _name;
        r.uuid = _uuid;
        return r;
    }

    public String getSourceUrl() {
        return url;
    }

    public String getSourceName() {
        return sourceName;
    }
}
